package beans;

public class Address {
	private String id;
    private String street;
    private int number;
    private String city;
    private String postalCode;

    public Address() {}
    
    public Address(String id, String street, int number, String city, String postalCode) {
    	this.id = id;
    	this.street = street;
        this.number = number;
        this.city = city;
        this.postalCode = postalCode;
    }

	public void setId(String i) {
		id = i;
	}

	public String getId() {
		return id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
    
}