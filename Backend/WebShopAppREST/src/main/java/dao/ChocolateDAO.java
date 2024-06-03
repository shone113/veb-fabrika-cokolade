package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.StringTokenizer;

import beans.Chocolate;
import beans.Chocolate.StockStatus;
import beans.Product;

/***
 * Klasa namenjena da ucita proizvode iz fajla i pruzi operacije nad njima (poput pretrage).
 * Proizvodi se nalaze u fajlu WebContent/products.txt u obliku: <br>
 * id;naziv;jedinicna cena
 * @author Lazar
 *
 */
public class ChocolateDAO {
	
	private HashMap<String, Chocolate> chocolates = new HashMap<String, Chocolate>();
	private String contextPath;
	
	public ChocolateDAO() {
		
	}
	
	/***
	 * @param contextPath Putanja do aplikacije u Tomcatu. Moze se pristupiti samo iz servleta.
	 */
	public ChocolateDAO(String contextPath) {
		this.contextPath = contextPath;
		loadChocolates();
	}

	/***
	 * Vraca sve proizvode.
	 * @return
	 */
	public Collection<Chocolate> findAll() {
		return chocolates.values();
	}

	public Chocolate deleteChocolate(String id) {
		Chocolate chocolate = chocolates.remove(id);
		saveChocolates();
		return chocolate;
	}
	
	/***
	 *  Vraca proizvod na osnovu njegovog id-a. 
	 *  @return Proizvod sa id-em ako postoji, u suprotnom null
	 */
	public Chocolate findChocolate(String id) {
		return chocolates.containsKey(id) ? chocolates.get(id) : null;
	}
	
	public Chocolate updateChocolate(String id, Chocolate chocolate) {
		Chocolate c = chocolates.containsKey(id) ? chocolates.get(id) : null;
		if (c == null) {
			return save(chocolate);
		} else {
			c.setName(chocolate.getName());
			c.setPrice(chocolate.getPrice());
			c.setType(chocolate.getType());
			c.setWeight(chocolate.getWeight());
			c.setDescription(chocolate.getDescription());
			c.setStockStatus(chocolate.getStockStatus());
			c.setStockQuantity(chocolate.getStockQuantity());
		}
		saveChocolates();
		return c;
	}
	
	/***
	 * Dodaje proizvod u mapu proizvoda. Id novog proizvoda ce biti postavljen na maxPostojeciId + 1.
	 * @param product
	 */
	public Chocolate save(Chocolate chocolate) {
		Integer maxId = -1;
		for (String id : chocolates.keySet()) {
			int idNum =Integer.parseInt(id);
			if (idNum > maxId) {
				maxId = idNum;
			}
		}
		maxId++;
		chocolate.setId(maxId.toString());
		chocolates.put(chocolate.getId(), chocolate);
		saveChocolates();
		return chocolate;
	}

	/**
	 * Ucitava korisnike iz WebContent/users.txt fajla i dodaje ih u mapu {@link #products}.
	 * Kljuc je id proizovda.
	 * @param contextPath Putanja do aplikacije u Tomcatu
	 */
	private void loadChocolates() {
	    BufferedReader in = null;
	    try {
	        File file = new File(contextPath + "/chocolates.txt");
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
	            double price = Double.parseDouble(parts[2].trim());
	            String factoryId = parts[3].trim();
	            String type = parts[4].trim();
	            double weight = Double.parseDouble(parts[5].trim());
	            String description = parts[6].trim();
	            StockStatus stockStatus = StockStatus.valueOf(parts[7].trim());
	            int stockQuantity = Integer.parseInt(parts[8].trim());

	            chocolates.put(id, new Chocolate(id, name, price, factoryId, type, weight, description, stockStatus, stockQuantity));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (in != null) {
	            try {
	                in.close();
	            } catch (Exception e) { }
	        }
	    }
	}
	
	private void saveChocolates() {
		System.out.println("ULAZIM OVDE");
	    BufferedWriter out = null;
	    try {
	        File file = new File(contextPath + "/chocolates.txt");
	    	//File file = new File("C:\\Users\\nenad\\Desktop\\Veb_projekat\\veb-fabrika-cokolade\\Backend\\WebShopAppREST\\src\\main\\webapp\\chocolates.txt");
	        System.out.println("Fajl putanja: " + file.getCanonicalPath());
	        out = new BufferedWriter(new FileWriter(file, false)); // false to overwrite the file
	        for (Chocolate chocolate : chocolates.values()) {
	            String line = String.join(";",
	                chocolate.getId(),
	                chocolate.getName(),
	                String.valueOf(chocolate.getPrice()),
	                chocolate.getFactoryId(),
	                chocolate.getType(),
	                String.valueOf(chocolate.getWeight()),
	                chocolate.getDescription(),
	                chocolate.getStockStatus().name(),
	                String.valueOf(chocolate.getStockQuantity())
	            );
	            out.write(line);
	            out.newLine();
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (out != null) {
	            try {
	                out.close();
	            } catch (Exception e) { }
	        }
	    }
	}


}
