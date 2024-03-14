package Model;

public class Checkout extends Order {
	public String username;
	public String orderid;
	public String country;
	public String firstname;
	public String lastname;
	public String companyname;
	public String address;
	public String email;
	public String phonenumber;
	public String notes;
	public String transfers;
	public String checkoutdate;
	public String statusch;
	public Checkout(String username, String orderid, String country,
			String firstname, String lastname, String companyname, String address,String email, String phonenumber,
			String notes, String transfers, String checkoutdate, String statusch) {
		super();
		this.username = username;
		this.orderid = orderid;
		this.country = country;
		this.firstname = firstname;
		this.lastname = lastname;
		this.companyname = companyname;
		this.address = address;
		this.email = email;
		this.phonenumber = phonenumber;
		this.notes = notes;
		this.transfers = transfers;
		this.checkoutdate = checkoutdate;
		this.statusch = statusch;
	}
	public Checkout() {
		// TODO Auto-generated constructor stub
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getTransfers() {
		return transfers;
	}
	public void setTransfers(String transfers) {
		this.transfers = transfers;
	}
	public String getCheckoutdate() {
		return checkoutdate;
	}
	public void setCheckoutdate(String checkoutdate) {
		this.checkoutdate = checkoutdate;
	}
	public String getStatusch() {
		return statusch;
	}
	public void setStatusch(String statusch) {
		this.statusch = statusch;
	}
	@Override
	public String toString() {
		return "Checkout [username=" + username + ", orderid=" + orderid + ", country=" + country + ", firstname="
				+ firstname + ", lastname=" + lastname + ", companyname=" + companyname + ", address=" + address
				+ ", email=" + email + ", phonenumber=" + phonenumber + ", notes=" + notes + ", transfers=" + transfers
				+ ", checkoutdate=" + checkoutdate + ", statusch=" + statusch + "]";
	}
	
	
	
	
	
}

	
	