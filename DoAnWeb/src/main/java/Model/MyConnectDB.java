package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MyConnectDB {
	private static String dburl = "jdbc:mysql://localhost:3306/shop";
	 private static String dbuname = "root";
	 private static String dbpassword = "13122003";
	
		
		public MyConnectDB() {
			super();
			
			
		}
		
		public static  Connection connect() throws Exception{
			
			Connection connection = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection=DriverManager.getConnection(dburl,dbuname,dbpassword);
				System.out.println("Connect success");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return connection;
			
		}
		public  void thucThiSQL(String sql) throws Exception{
		    Connection connect = MyConnectDB.connect(); // Initialize with a valid connection

			Statement stmt = connect.prepareStatement(sql);
			stmt.executeUpdate(sql);
		}
		public ResultSet chonDuLieu(String sql) throws Exception{
			Connection connect = MyConnectDB.connect();
			Statement stmt = connect.createStatement();
			ResultSet rs=	stmt.executeQuery(sql);
			return rs;
		}
		
	
		public PreparedStatement dungStament(String sql) throws SQLException, Exception{
			return connect().prepareStatement(sql);
		}
		
	public static void main(String[] args) throws Exception {
		System.out.println(new MyConnectDB().connect());
	}
}
