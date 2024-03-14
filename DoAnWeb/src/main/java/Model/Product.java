package Model;

public class Product {
	private String id;
	private String proname;
	private String descriptions;
	private String image;
	private Double price;
	private int availnumber;
	private String categoryid;
	public Product(String id, String proname, String descriptions, String image, Double price, int availnumber,
			String categoryid) {
		super();
		this.id = id;
		this.proname = proname;
		this.descriptions = descriptions;
		this.image = image;
		this.price = price;
		this.availnumber = availnumber;
		this.categoryid = categoryid;
	}
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProname() {
		return proname;
	}
	public void setProname(String proname) {
		this.proname = proname;
	}
	public String getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getAvailnumber() {
		return availnumber;
	}
	public void setAvailnumber(int availnumber) {
		this.availnumber = availnumber;
	}
	public String getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", proname=" + proname + ", descriptions=" + descriptions + ", image=" + image
				+ ", price=" + price + ", availnumber=" + availnumber + ", categoryid=" + categoryid + "]";
	}
	
	

}
