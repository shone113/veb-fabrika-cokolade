package services;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import beans.Chocolate;
import beans.Product;
import dao.ChocolateDAO;
import dao.ProductDAO;


@Path("/chocolates")
public class ChocolateService {
	@Context
	ServletContext ctx;
	
	public ChocolateService() {
	}
	
	@PostConstruct
	// ctx polje je null u konstruktoru, mora se pozvati nakon konstruktora (@PostConstruct anotacija)
	public void init() {
		// Ovaj objekat se instancira vise puta u toku rada aplikacije
		// Inicijalizacija treba da se obavi samo jednom
		if (ctx.getAttribute("chocolateDAO") == null) {
	    	String contextPath = ctx.getRealPath("");
			ctx.setAttribute("chocolateDAO", new ChocolateDAO(contextPath));
		}
	}
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Chocolate> getChocolates() {
		ChocolateDAO dao = (ChocolateDAO) ctx.getAttribute("chocolateDAO");
		return dao.findAll();
	}

	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Chocolate newChocolate(Chocolate chocolate) {
		ChocolateDAO dao = (ChocolateDAO) ctx.getAttribute("chocolateDAO");
		return dao.save(chocolate);
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Chocolate deleteChocolate(@PathParam("id") String id) {
		ChocolateDAO dao = (ChocolateDAO) ctx.getAttribute("chocolateDAO");
		return dao.deleteChocolate(id);
	}
	
	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Chocolate updateChocolate(@PathParam("id") String id, Chocolate chocolate) {
		ChocolateDAO dao = (ChocolateDAO) ctx.getAttribute("chocolateDAO");
		return dao.updateChocolate(id, chocolate);
	}
	
		
}
