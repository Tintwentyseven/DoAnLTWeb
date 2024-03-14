package Model;

public class Comments {
	public String Productid;
	public String Productname;
	public String Username;
	public String Detailcomment;
	public String Commentdate;
	public Comments(String productid, String productname, String username, String detailcomment, String commentdate) {
		super();
		Productid = productid;
		Productname = productname;
		Username = username;
		Detailcomment = detailcomment;
		Commentdate = commentdate;
	}
	
	public Comments() {
		// TODO Auto-generated constructor stub
	}
	public String getProductid() {
		return Productid;
	}
	public void setProductid(String productid) {
		Productid = productid;
	}
	public String getProductname() {
		return Productname;
	}
	public void setProductname(String productname) {
		Productname = productname;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getDetailcomment() {
		return Detailcomment;
	}
	public void setDetailcomment(String detailcomment) {
		Detailcomment = detailcomment;
	}
	public String getCommentdate() {
		return Commentdate;
	}
	public void setCommentdate(String commentdate) {
		Commentdate = commentdate;
	}
	@Override
	public String toString() {
		return "Comments [Productid=" + Productid + ", Productname=" + Productname + ", Username=" + Username
				+ ", Detailcomment=" + Detailcomment + ", Commentdate=" + Commentdate + "]";
	}
	


}
