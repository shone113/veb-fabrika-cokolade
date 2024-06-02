package beans;

import java.util.List;

public class Factory{
	
	public enum Status {
	    WORKING,
	    NOT_WORKING;
	}

	
	private String id;
	private String name;
	//private List<Chocolate> chocolates;
	//radno vreme
    //private Location location;
    //private String image;
	private Status status;
	private double rating;
    
    public Factory() {
    	
    }
//    
//    public Factory(String id, String name, List<Chocolate> chocolates, Status status, Location location, String image, double rating) {
//        this.id = id;
//        this.name = name;
//        this.chocolates = chocolates;
//        this.status = status;
//        this.location = location;
//        this.image = image;
//        this.rating = rating;
//    }
    
    public Factory(String id, String name, Status status, double rating) {
        this.id = id;
        this.name = name;
        //this.chocolates = chocolates;
        this.status = status;
       // this.location = location;
        //this.image = image;
        this.rating = rating;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
//
//	public List<Chocolate> getChocolates() {
//		return chocolates;
//	}
//
//	public void setChocolates(List<Chocolate> chocolates) {
//		this.chocolates = chocolates;
//	}
//
//	public Location getLocation() {
//		return location;
//	}
//
//	public void setLocation(Location location) {
//		this.location = location;
//	}
//
//	public String getImage() {
//		return image;
//	}
//
//	public void setImage(String image) {
//		this.image = image;
//	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
    
}