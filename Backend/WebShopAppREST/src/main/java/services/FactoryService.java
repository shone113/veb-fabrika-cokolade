package services;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import beans.Factory;
import beans.Product;
import dao.FactoryDAO;
import dao.ProductDAO;


@Path("/factories")
public class FactoryService {
	@Context
	ServletContext ctx;
	
	public FactoryService() {
	}
	
	@PostConstruct
	// ctx polje je null u konstruktoru, mora se pozvati nakon konstruktora (@PostConstruct anotacija)
	public void init() {
		// Ovaj objekat se instancira vise puta u toku rada aplikacije
		// Inicijalizacija treba da se obavi samo jednom
		if (ctx.getAttribute("factoryDAO") == null) {
	    	String contextPath = ctx.getRealPath("");
			ctx.setAttribute("factoryDAO", new FactoryDAO(contextPath));
		}
	}
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Factory> getFactories() {
		FactoryDAO dao = (FactoryDAO) ctx.getAttribute("factoryDAO");
		return dao.findAll();
	}
	
}
