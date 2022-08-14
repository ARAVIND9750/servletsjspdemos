package ecommerce;

public class Product {
	private long ID;
	private String pName;
	private float pPrice;
	
	public Product(long iD, String pName, float pPrice) {
		super();
		ID = iD;
		this.pName = pName;
		this.pPrice = pPrice;
	}
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public float getpPrice() {
		return pPrice;
	}
	public void setpPrice(float pPrice) {
		this.pPrice = pPrice;
	}

}