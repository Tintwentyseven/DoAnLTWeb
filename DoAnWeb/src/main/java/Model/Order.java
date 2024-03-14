package Model;

import java.util.List;

public class Order extends Product {
    
	public String username;
	public String email;
	public String productname;
	public int quantity;
	public double prices;
	public double totalprice;
	public String date;
	public int status;
	public String orderid;
	public Order(String username, String email, String productname, int quantity, double prices,
			double totalprice, String date, int status, String orderid) {
		super();
		this.username = username;
		this.email = email;
		this.productname = productname;
		this.quantity = quantity;
		this.prices = prices;
		this.totalprice = totalprice;
		this.date = date;
		this.status = status;
		this.orderid = orderid;
	}
	public Order() {
		// TODO Auto-generated constructor stub
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrices() {
		return prices;
	}
	public void setPrices(double prices) {
		this.prices = prices;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	@Override
	public String toString() {
		return "Order [username=" + username + ", email=" + email + ", productname=" + productname + ", quantity="
				+ quantity + ", prices=" + prices + ", totalprice=" + totalprice + ", date=" + date + ", status="
				+ status + ", orderid=" + orderid + "]";
	}
	
	
	
	
	
	
	
	
	
}
	
	