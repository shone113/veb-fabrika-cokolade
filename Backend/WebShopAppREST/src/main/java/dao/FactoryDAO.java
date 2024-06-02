package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.StringTokenizer;

import beans.Factory;
import beans.Factory.Status;
import beans.Location;
import beans.Product;

/***
 * Klasa namenjena da ucita proizvode iz fajla i pruzi operacije nad njima (poput pretrage).
 * Proizvodi se nalaze u fajlu WebContent/products.txt u obliku: <br>
 * id;naziv;jedinicna cena
 * @author Lazar
 *
 */
public class FactoryDAO {
	
	private HashMap<String, Factory> factories = new HashMap<String, Factory>();
	
	public FactoryDAO() {
		
	}
	
	/***
	 * @param contextPath Putanja do aplikacije u Tomcatu. Moze se pristupiti samo iz servleta.
	 */
	public FactoryDAO(String contextPath) {
		loadFactories(contextPath);
	}

	/***
	 * Vraca sve proizvode.
	 * @return
	 */
	public Collection<Factory> findAll() {
		return factories.values();
	}

	/***
	 *  Vraca proizvod na osnovu njegovog id-a. 
	 *  @return Proizvod sa id-em ako postoji, u suprotnom null
	 */
	public Factory findFactory(String id) {
		return factories.containsKey(id) ? factories.get(id) : null;
	}
	
	/***
	 * Dodaje proizvod u mapu proizvoda. Id novog proizvoda ce biti postavljen na maxPostojeciId + 1.
	 * @param product
	 */
	public Factory save(Factory factory) {
		Integer maxId = -1;
		for (String id : factories.keySet()) {
			int idNum =Integer.parseInt(id);
			if (idNum > maxId) {
				maxId = idNum;
			}
		}
		maxId++;
		factory.setId(maxId.toString());
		factories.put(factory.getId(), factory);
		return factory;
	}

	/**
	 * Ucitava korisnike iz WebContent/users.txt fajla i dodaje ih u mapu {@link #products}.
	 * Kljuc je id proizovda.
	 * @param contextPath Putanja do aplikacije u Tomcatu
	 */
	private void loadFactories(String contextPath) {
	    BufferedReader in = null;
	    try {
	        File file = new File(contextPath + "/factories.txt");
	        System.out.println(file.getCanonicalPath());
	        in = new BufferedReader(new FileReader(file));
	        String line;
	        while ((line = in.readLine()) != null) {
	            line = line.trim();
	            if (line.equals("") || line.indexOf('#') == 0)
	                continue;
	            String[] parts = line.split(";");
	            String id = parts[0].trim();
	            String name = parts[1].trim();
	            Status status = Status.valueOf(parts[2].trim());
	            double rating = Double.parseDouble(parts[3].trim());
	            factories.put(id, new Factory(id, name, status, rating));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (in != null) {
	            try {
	                in.close();
	            } catch (Exception e) {
	            }
	        }
	    }
	}

}
