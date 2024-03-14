package Model;

public class Categorys {
	public String id;
	public String caname;
	public Categorys(String id, String caname) {
		super();
		this.id = id;
		this.caname = caname;
	}
	public Categorys() {
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCaname() {
		return caname;
	}
	public void setCaname(String caname) {
		this.caname = caname;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + caname + "]";
	}
	

}
