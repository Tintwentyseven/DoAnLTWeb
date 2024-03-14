package DAO;


public interface ObjectDAO {
		public boolean themTaiKhoan(Object obj);
		public String getPasswordByUsername(String username);
		public boolean kiemTraDangNhap(String username,String pass);
}
