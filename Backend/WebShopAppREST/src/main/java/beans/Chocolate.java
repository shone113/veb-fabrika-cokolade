package beans;

enum StockStatus {
    IN_STOCK,
    OUT_OF_STOCK;
}

public class Chocolate{
	private String id;
	private String name;
	private double price;
	private String factoryId;
	private String type;
	private double weight;
	private String description;
    private StockStatus stockStatus;
    private int stockQuantity;
    
    public Chocolate() {
    	
    }
    
    public Chocolate(String id, String name, double price, String factoryId, String type, double weight, String description, StockStatus stockStatus, int stockQuantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.factoryId = factoryId;
        this.type = type;
        this.weight = weight;
        this.description = description;
        this.stockStatus = stockStatus;
        this.stockQuantity = stockQuantity;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getFactoryId() {
		return factoryId;
	}

	public void setFactoryId(String factoryId) {
		this.factoryId = factoryId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public StockStatus getStockStatus() {
		return stockStatus;
	}

	public void setStockStatus(StockStatus stockStatus) {
		this.stockStatus = stockStatus;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
    
    

}