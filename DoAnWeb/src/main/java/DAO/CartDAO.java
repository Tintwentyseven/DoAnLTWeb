package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.Cart;
import Model.MyConnectDB;

public class CartDAO {
	private MyConnectDB connectDB;
	private Connection conn; 
	private PreparedStatement ps;
	private ResultSet rs;
	public CartDAO() {
		connectDB = new MyConnectDB();
	}
		// TODO Auto-generated constructor stub
		/*
		 * public double getTotalCartPrice(ArrayList<Cart> cartList) { double sum = 0;
		 * try { if (cartList.size() > 0) { String query =
		 * "SELECT price FROM product WHERE productid = ?"; for (Cart item : cartList) {
		 * // Initialize the PreparedStatement and ResultSet in try-with-resources try
		 * (PreparedStatement ps = connectDB.dungStament(query)) { // Set parameter
		 * index starting from 1 ps.setString(1, item.getProduct().getId());
		 * 
		 * try (ResultSet rs = ps.executeQuery()) { while (rs.next()) { sum +=
		 * rs.getDouble("price") * item.getQuantity(); } } } } } } catch (Exception e) {
		 * e.printStackTrace(); } return sum; } public boolean
		 * kiemTraSanPhamCoTrongGioHangChua(String maSanPham) { String query =
		 * "SELECT COUNT(*) FROM Carts WHERE productid = ?"; try (PreparedStatement ps =
		 * connectDB.dungStament(query)) { ps.setString(1, maSanPham); try (ResultSet rs
		 * = ps.executeQuery()) { if (rs.next()) { int count = rs.getInt(1); return
		 * count > 0; } } } catch (Exception e) { e.printStackTrace(); } return false; }
		 * public boolean addToCart(String productId) throws Exception { ProductDAO
		 * productDAO = new ProductDAO(); boolean isInCart =
		 * kiemTraSanPhamCoTrongGioHangChua(productId);
		 * 
		 * // Initialize `ps` within the try block try (Connection connection =
		 * MyConnectDB.connect(); PreparedStatement ps = connection.
		 * prepareStatement("INSERT INTO Carts(userid,quantity,totalprice,productid) VALUES (?, ?, ?, ?)"
		 * )) {
		 * 
		 * if (!isInCart) { // Add new cart entry String uid = "UID0" +
		 * productId.replaceAll("[^0-9]", ""); ps.setString(1, uid); ps.setInt(2, 1);
		 * ps.setDouble(3, productDAO.getPriceById(productId)); ps.setString(4,
		 * productId); } else { // Update existing cart entry ps.setString(1,
		 * productId); }
		 * 
		 * return false; } }
		 */
		

	    
		/*
		 * public List<Cart> getAllCart(){ List<Cart> list = new ArrayList<Cart>(); try
		 * { ResultSet rs = connectDB.chonDuLieu("Select * FROM Carts");
		 * while(rs.next()) { list.add(new Cart(rs.getString(1), rs.getString(2),
		 * rs.getInt(3),rs.getClass(4))); }
		 * 
		 * } catch (Exception e) { e.printStackTrace(); } return list; }
		 */
		

	/*
	 * public boolean themSanPham(Object obj) { Cart ca = (Cart) obj; KhachHangDAO
	 * dao = new KhachHangDAO(); KhachHang kh = (KhachHang) obj; try (Connection
	 * connection = MyConnectDB.connect(); PreparedStatement stmt = connection.
	 * prepareStatement("INSERT INTO Carts (userid,quantity,totalprice,productid) VALUES (?, ?, ?, ?)"
	 * )) { // Set parameter values stmt.setString(1,
	 * dao.getUserIdByEmail(kh.getEmail())); stmt.setString(2, kh.getPassword());
	 * stmt.setString(3, kh.getName()); stmt.setString(4, kh.getEmail());
	 * stmt.setString(5, kh.getPhonenumber()); stmt.setString(6, kh.getAddress());
	 * 
	 * // Execute the update int affectedRows = stmt.executeUpdate(); return
	 * affectedRows > 0; } catch (Exception e) { e.printStackTrace(); return false;
	 * }
	 * 
	 * }
	 */
	/*public static void main(String[] args) {
		ArrayList<Cart> cartList = new ArrayList<Cart>();
		CartDAO dao = new CartDAO();*/
		/*
		 * List<Cart> list = dao.getAllCart(); for(Cart o:list) { System.out.println(o);
		 * }
		 */
		/*
		 * cartList.add(new Cart("ca001","uid001",10,0,"p01")); cartList.add(new
		 * Cart("ca001","uid001",10,0,"p02"));
		 */
		/*
		 * Double total = dao.getTotalCartPrice(cartList); boolean b =
		 * dao.kiemTraSanPhamCoTrongGioHangChua("p01"); System.out.println(b);
		 * System.out.println(total);
		 */
		
	}


