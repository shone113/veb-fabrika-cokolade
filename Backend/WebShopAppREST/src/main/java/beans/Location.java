package beans;

public class Location{
	private String id;
	private double latitude;
	private double longitude;
	private Address address;
	
	public Location() {
		
	}
	
	public Location(String id, double latitude, double longitude, Address address) {
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.address = address;
	}

	public void setId(String i) {
		id = i;
	}

	public String getId() {
		return id;
	}
	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}