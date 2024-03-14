package Model;

public class OrderID {
	public String userid;
	public String username;
	public String email;
	public String date;
	public String orderid;
	public OrderID(String userid, String username, String email, String date, String orderid) {
		super();
		this.userid = userid;
		this.username = username;
		this.email = email;
		this.date = date;
		this.orderid = orderid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	@Override
	public String toString() {
		return "OrderID [userid=" + userid + ", username=" + username + ", email=" + email + ", date=" + date
				+ ", orderid=" + orderid + "]";
	}

	

}
