package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.Checkout;
import Model.KhachHang;
import Model.MyConnectDB;
import Model.Order;
import Model.OrderDetail;
import Model.Product;

public class OrderDAO {
	private MyConnectDB connectDB;
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

    public OrderDAO() {
        connectDB = new MyConnectDB();
    }
    public boolean themOrder(Order model) {
		
		 
        try (Connection connection = MyConnectDB.connect();
        		PreparedStatement stmt = connection.prepareStatement("INSERT INTO orders (username, email,product_name,quantity,price,totalprice, order_date,status) VALUES (?, ?, ?, ?, ?, ?, ?,?)")) {
        	// Set parameter values
        	stmt.setString(1, model.getUsername());
        	stmt.setString(2, model.getEmail());
        	stmt.setString(3, model.getProductname());
        	stmt.setInt(4, model.getQuantity());
        	stmt.setDouble(5, model.getPrices());
        	stmt.setDouble(6, model.getTotalprice());
        	stmt.setString(7, model.getDate());
        	stmt.setInt(8, 0);
        	
        	
        	// Execute the update
        	int affectedRows = stmt.executeUpdate();
        	return affectedRows > 0;
        } catch (Exception e) {
        	e.printStackTrace();
        	return false;
        }
    }
    public List<Order> getAllOrderByUser(String username){
    	ArrayList<Order> list2 = new ArrayList<Order>();
    	try {
    		ResultSet rs = connectDB.chonDuLieu("SELECT * FROM orders WHERE username = '"+ username +"'");
    		while(rs.next()) {
    			list2.add(new Order(rs.getString(1),
    					rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5),rs.getDouble(6), rs.getString(7),rs.getInt(8),rs.getString(9)));
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return list2;
    }
    public boolean deleteOrderByOrderid(String id,String username) {
    	try (Connection connection = MyConnectDB.connect();
    			PreparedStatement stmt = connection.prepareStatement("DELETE FROM orders WHERE orderid = ? and username=?")) {
    		// Set parameter values
    		stmt.setString(1, id);
    		stmt.setString(2, username);
    		
    		// Execute the update
    		int affectedRows = stmt.executeUpdate();
    		return affectedRows > 0; // True if the update is successful, False otherwise
    	} catch (Exception e) {
    		e.printStackTrace();
    		return false;
    	}
    }
    public boolean deleteOrderByStatus(int status) {
        try (Connection connection = MyConnectDB.connect();
             PreparedStatement stmt = connection.prepareStatement("DELETE FROM orders WHERE status = ?")) {
            // Set parameter values
            stmt.setInt(1, status);

            // Execute the update
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0; // True if the update is successful, False otherwise
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean deleteOrderByOrderid2(String id) {
    	try (Connection connection = MyConnectDB.connect();
    			PreparedStatement stmt = connection.prepareStatement("DELETE FROM orders WHERE orderid = ?")) {
    		// Set parameter values
    		stmt.setString(1, id);
    		
    		// Execute the update
    		int affectedRows = stmt.executeUpdate();
    		return affectedRows > 0; // True if the update is successful, False otherwise
    	} catch (Exception e) {
    		e.printStackTrace();
    		return false;
    	}
    }
    public boolean deleteOrders(StringBuilder orderid) {
    	try (Connection connection = MyConnectDB.connect()) {
    		// Disable foreign key checks
    		try (PreparedStatement disableChecksStmt = connection.prepareStatement("SET FOREIGN_KEY_CHECKS=0;")) {
    			disableChecksStmt.executeUpdate();
    		}
    		
    		// Truncate the Comments table
    		try (PreparedStatement truncateStmt = connection.prepareStatement("DELETE FROM orders where orderid IN (" + orderid + ")")) {
    			truncateStmt.executeUpdate();
    		}
    		
    		// Enable foreign key checks
    		try (PreparedStatement enableChecksStmt = connection.prepareStatement("SET FOREIGN_KEY_CHECKS=1;")) {
    			enableChecksStmt.executeUpdate();
    		}
    		
    		return true; // Successful if no exceptions were thrown
    	} catch (Exception e) {
    		e.printStackTrace();
    		return false;
    	}
    }
    public boolean deleteOrderCheckOuts(StringBuilder orderid) {
  	  try (Connection connection = MyConnectDB.connect()) {
            // Disable foreign key checks
            try (PreparedStatement disableChecksStmt = connection.prepareStatement("SET FOREIGN_KEY_CHECKS=0;")) {
                disableChecksStmt.executeUpdate();
            }

            // Truncate the Comments table
            try (PreparedStatement truncateStmt = connection.prepareStatement("DELETE FROM Checkout where orderid IN (" + orderid + ")")) {
                truncateStmt.executeUpdate();
            }

            // Enable foreign key checks
            try (PreparedStatement enableChecksStmt = connection.prepareStatement("SET FOREIGN_KEY_CHECKS=1;")) {
                enableChecksStmt.executeUpdate();
            }

            return true; // Successful if no exceptions were thrown
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
  }
    public boolean deleteAllOrderByUserName(String username) {
    	try (Connection connection = MyConnectDB.connect();
    			PreparedStatement stmt = connection.prepareStatement("DELETE FROM orders WHERE username = ?")) {
    		// Set parameter values
    		stmt.setString(1, username);
    		
    		// Execute the update
    		int affectedRows = stmt.executeUpdate();
    		return affectedRows > 0; // True if the update is successful, False otherwise
    	} catch (Exception e) {
    		e.printStackTrace();
    		return false;
    	}
    }
    public boolean deleteAllCheckOut() {
    	try (Connection connection = MyConnectDB.connect();
    			PreparedStatement stmt = connection.prepareStatement("TRUNCATE Table Checkout ")) {
    		// Set parameter values
    		
    		
    		// Execute the update
    		int affectedRows = stmt.executeUpdate();
    		return affectedRows > 0; // True if the update is successful, False otherwise
    	} catch (Exception e) {
    		e.printStackTrace();
    		return false;
    	}
    }
    public List<Order> getAllOrder(String username, int status) {
    	ArrayList<Order> list2 = new ArrayList<Order>();
    	try {
    		ResultSet rs = connectDB.chonDuLieu("SELECT * FROM orders WHERE username = '"+ username +"' and status = '" + status + "'");
    		while(rs.next()) {
    			list2.add(new Order(rs.getString(1),
    					rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5),rs.getDouble(6), rs.getString(7),rs.getInt(8),rs.getString(9)));
    		}
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return list2;
    }
    public List<Order> getAllOrderByAdmin(int status) {
    	ArrayList<Order> list2 = new ArrayList<Order>();
    	try {
    		ResultSet rs = connectDB.chonDuLieu("SELECT * FROM orders WHERE status = '" + status + "'");
    		while(rs.next()) {
    			list2.add(new Order(rs.getString(1),
    					rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5),rs.getDouble(6), rs.getString(7),rs.getInt(8),rs.getString(9)));
    		}
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return list2;
    }
    public List<Order> getAllOrderLower100(int status) {
    	ArrayList<Order> list2 = new ArrayList<Order>();
    	try {
    		ResultSet rs = connectDB.chonDuLieu("SELECT * FROM orders WHERE totalprice < 100.00 and status = '" + status + "'");
    		while(rs.next()) {
    			list2.add(new Order(rs.getString(1),
    					rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5),rs.getDouble(6), rs.getString(7),rs.getInt(8),rs.getString(9)));
    		}
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return list2;
    }
    public List<Order> getAllOrderFrom100to300(int status) {
    	ArrayList<Order> list2 = new ArrayList<Order>();
    	try {
    		ResultSet rs = connectDB.chonDuLieu("SELECT * FROM orders WHERE totalprice between 100.00 and 300.00 and status = '" + status + "'");
    		while(rs.next()) {
    			list2.add(new Order(rs.getString(1),
    					rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5),rs.getDouble(6), rs.getString(7),rs.getInt(8),rs.getString(9)));
    		}
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return list2;
    }
    public List<Order> getAllOrderHigher300(int status) {
    	ArrayList<Order> list2 = new ArrayList<Order>();
    	try {
    		ResultSet rs = connectDB.chonDuLieu("SELECT * FROM orders WHERE totalprice > 300.00 and status = '" + status + "'");
    		while(rs.next()) {
    			list2.add(new Order(rs.getString(1),
    					rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5),rs.getDouble(6), rs.getString(7),rs.getInt(8),rs.getString(9)));
    		}
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return list2;
    }
    public boolean updateThanhToan(String username, int status) {
		  try (Connection connection = MyConnectDB.connect();
				  PreparedStatement stmt = connection.prepareStatement("UPDATE orders SET status=? where username='" + username + "' ")) {
			  // Set parameter values
			  stmt.setInt(1, status);
			

			  
			  // Execute the update
			  int affectedRows = stmt.executeUpdate();
			  return affectedRows > 0; // True nếu cập nhật thành công, False nếu không
		  } catch (Exception e) {
			  e.printStackTrace();
			  return false;
		  }
	}
    public boolean updateStatus(String orderid, String status) {
    	try (Connection connection = MyConnectDB.connect();
    			PreparedStatement stmt = connection.prepareStatement("UPDATE Checkout SET statuscheckout=? where orderid=? ")) {
    		// Set parameter values
    		stmt.setString(1, status);
    		stmt.setString(2, orderid);
    		
    		
    		
    		// Execute the update
    		int affectedRows = stmt.executeUpdate();
    		return affectedRows > 0; // True nếu cập nhật thành công, False nếu không
    	} catch (Exception e) {
    		e.printStackTrace();
    		return false;
    	}
    }
    public List<Checkout> getAllCheckOutLower100() {
    	ArrayList<Checkout> list2 = new ArrayList<Checkout>();
    	try {
    		ResultSet rs = connectDB.chonDuLieu("SELECT * from checkout \r\n"
    				+ "JOIN orders on orders.orderid = checkout.orderid\r\n"
    				+ "AND totalprice < 100.00;");
    		while(rs.next()) {
    			list2.add(new Checkout(rs.getString(1),
    					rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6), rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13)));
    		}
    		
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return list2;
    }
    public List<Checkout> getAllCheckOutFrom100to300() {
    	ArrayList<Checkout> list2 = new ArrayList<Checkout>();
    	try {
    		ResultSet rs = connectDB.chonDuLieu("SELECT * from checkout \r\n"
    				+ "JOIN orders on orders.orderid = checkout.orderid\r\n"
    				+ "AND totalprice <= 300.00 AND totalprice >= 100.00;");
    		while(rs.next()) {
    			list2.add(new Checkout(rs.getString(1),
    					rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6), rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13)));
    		}
    		
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return list2;
    }
    public List<Checkout> getAllCheckOutHigher100() {
    	ArrayList<Checkout> list2 = new ArrayList<Checkout>();
    	try {
    		ResultSet rs = connectDB.chonDuLieu("SELECT * from checkout \r\n"
    				+ "JOIN orders on orders.orderid = checkout.orderid\r\n"
    				+ "AND totalprice > 300.00;");
    		while(rs.next()) {
    			list2.add(new Checkout(rs.getString(1),
    					rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6), rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13)));
    		}
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return list2;
    }
    public Checkout getAllCheckOutById(String id) {
        Checkout p = new Checkout();
        String querry = "SELECT * FROM Checkout WHERE orderid = '" + id + "'";

        try (Connection conn = MyConnectDB.connect();
             PreparedStatement ps = conn.prepareStatement(querry)) {
               
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    p.setUsername(rs.getString(1));
                    p.setOrderid(rs.getString(2));
                    p.setCountry(rs.getString(3));
                    p.setFirstname(rs.getString(4));
                    p.setLastname(rs.getString(5));
                    p.setCompanyname(rs.getString(6));
                    p.setAddress(rs.getString(7));
                    p.setEmail(rs.getString(8));
                    p.setPhonenumber(rs.getString(9));
                    p.setNotes(rs.getString(10));
                    p.setTransfers(rs.getString(11));
                    p.setCheckoutdate(rs.getString(12));
                    p.setStatusch(rs.getString(13));
                   
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        return p;
    }
 public int getTotalProduct(int status) {
    	
    	String querry = "Select SUM(quantity) FROM orders where status = '"+ status +"'";
    	
    	try (Connection conn = MyConnectDB.connect();
    			PreparedStatement ps = conn.prepareStatement(querry)) {
    		
    		ResultSet rs = ps.executeQuery();
    		
    		if (rs.next()) {
    			return rs.getInt("SUM(quantity)");
    			
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return 0;
 }
 public int getTotalDrinkSell(String productname,int status) {
	    String query = "SELECT SUM(quantity) "
	            + "FROM orders o "
	            + "JOIN product p on o.product_name = p.name "
	            + "JOIN category c ON p.categoryid = c.categoryid "
	            + "WHERE c.caname = '" + productname +"' AND status = '"+ status +"';";

	    try (Connection conn = MyConnectDB.connect();
	         PreparedStatement ps = conn.prepareStatement(query)) {

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            return rs.getInt("SUM(quantity)");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return 0;
	}
 public double getTotalDrinkSellM(String productname,int status) {
	 String query = "SELECT o.*,\r\n"
	 		+ "       SUM(o.quantity * p.price) AS total_amount,\r\n"
	 		+ "       (SELECT SUM(o2.quantity * p2.price) \r\n"
	 		+ "        FROM orders o2\r\n"
	 		+ "        JOIN product p2 ON o2.product_name = p2.name\r\n"
	 		+ "        JOIN category c2 ON p2.categoryid = c2.categoryid\r\n"
	 		+ "        WHERE o2.status = '"+status+"' AND c2.caname = '"+ productname +"') AS total_all\r\n"
	 		+ "FROM orders o\r\n"
	 		+ "JOIN product p ON o.product_name = p.name\r\n"
	 		+ "JOIN category c ON p.categoryid = c.categoryid\r\n"
	 		+ "WHERE o.status = '"+status+"' AND c.caname = '"+productname+"'\r\n"
	 		+ "GROUP BY o.orderid\r\n"
	 		+ "ORDER BY total_amount DESC;";
	 
	 try (Connection conn = MyConnectDB.connect();
			 PreparedStatement ps = conn.prepareStatement(query)) {
		 
		 ResultSet rs = ps.executeQuery();
		 
		 if (rs.next()) {
			 return rs.getDouble("total_all");
		 }
	 } catch (Exception e) {
		 e.printStackTrace();
	 }
	 return 0;
 }
 public List<Order> getAllSellByAdminDesc(int status) {
	 ArrayList<Order> list2 = new ArrayList<Order>();
	 	try {
	 		ResultSet rs = connectDB.chonDuLieu("SELECT o.*, "
	                + "SUM(o.quantity * p.price) AS total_amount "
	                + "FROM orders o "
	                + "JOIN product p ON o.product_name = p.name "
	                + "JOIN category c ON p.categoryid = c.categoryid "
	                + "WHERE o.status = '"+ status +"' "
	                + "GROUP BY o.orderid "
	                + "ORDER BY total_amount DESC");
	 		while(rs.next()) {
	 			list2.add(new Order(rs.getString(1),
	 					rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5),rs.getDouble(6), rs.getString(7),rs.getInt(8),rs.getString(9)));
	 		}
	 		
	 	} catch (Exception e) {
	 		e.printStackTrace();
	 	}
	 	return list2;
	}
 public List<Order> getAllSellByAdminAsc(int status) {
	 ArrayList<Order> list2 = new ArrayList<Order>();
	 try {
		 ResultSet rs = connectDB.chonDuLieu("SELECT o.*, "
				 + "SUM(o.quantity * p.price) AS total_amount "
				 + "FROM orders o "
				 + "JOIN product p ON o.product_name = p.name "
				 + "JOIN category c ON p.categoryid = c.categoryid "
				 + "WHERE o.status = '"+ status +"' "
				 + "GROUP BY o.orderid "
				 + "ORDER BY total_amount ASC");
		 while(rs.next()) {
			 list2.add(new Order(rs.getString(1),
					 rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5),rs.getDouble(6), rs.getString(7),rs.getInt(8),rs.getString(9)));
		 }
		 
	 } catch (Exception e) {
		 e.printStackTrace();
	 }
	 return list2;
 }
 public List<Order> getAllQuantitySellDESC(int status) {
 	ArrayList<Order> list2 = new ArrayList<Order>();
 	try {
 		ResultSet rs = connectDB.chonDuLieu("SELECT * FROM orders where status = '"+ status +"' ORDER BY quantity DESC");
 		while(rs.next()) {
 			list2.add(new Order(rs.getString(1),
 					rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5),rs.getDouble(6), rs.getString(7),rs.getInt(8),rs.getString(9)));
 		}
 		
 	} catch (Exception e) {
 		e.printStackTrace();
 	}
 	return list2;
 }
 public List<Order> getAllQuantitySellASC(int status) {
	 ArrayList<Order> list2 = new ArrayList<Order>();
	 try {
		 ResultSet rs = connectDB.chonDuLieu("SELECT * FROM orders where status = '"+ status +"' ORDER BY quantity ASC");
		 while(rs.next()) {
			 list2.add(new Order(rs.getString(1),
					 rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5),rs.getDouble(6), rs.getString(7),rs.getInt(8),rs.getString(9)));
		 }
		 
	 } catch (Exception e) {
		 e.printStackTrace();
	 }
	 return list2;
 }
 public boolean themCheckout(Checkout model) {
		
	 
     try (Connection connection = MyConnectDB.connect();
     		PreparedStatement stmt = connection.prepareStatement("INSERT INTO Checkout (username,orderid,country,firstname,lastname,companyname,address,email,phonenumber,notes,transfers,checkout_date,statuscheckout) VALUES (?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?)")) {
     	// Set parameter values
     	stmt.setString(1, model.getUsername());
     	stmt.setString(2, model.getOrderid());
     	stmt.setString(3, model.getCountry());
     	stmt.setString(4, model.getFirstname());
     	stmt.setString(5, model.getLastname());
     	stmt.setString(6, model.getCompanyname());
     	stmt.setString(7, model.getAddress());
     	stmt.setString(8, model.getEmail());
     	stmt.setString(9, model.getPhonenumber());
     	stmt.setString(10, model.getNotes());
     	stmt.setString(11, model.getTransfers());
     	stmt.setString(12, model.getCheckoutdate());
     	stmt.setString(13, model.getStatusch());
     	
     	
     	
     	
     	// Execute the update
     	int affectedRows = stmt.executeUpdate();
     	return affectedRows > 0;
     } catch (Exception e) {
     	e.printStackTrace();
     	return false;
     }
 }
 public List<Checkout> getAllCheckout() {
 	ArrayList<Checkout> list2 = new ArrayList<Checkout>();
 	try {
 		ResultSet rs = connectDB.chonDuLieu("SELECT * FROM Checkout ");
 		while(rs.next()) {
 			list2.add(new Checkout(rs.getString(1),
					rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6), rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13)));
		}
		
 		
 	} catch (Exception e) {
 		e.printStackTrace();
 	}
 	return list2;
 }
//public int getNumById(String id) {
//    	
//    	String querry = "SELECT quantity FROM orders WHERE orderid = '" + id + "'";
//    	
//    	try (Connection conn = MyConnectDB.connect();
//    			PreparedStatement ps = conn.prepareStatement(querry)) {
//    		
//    		ResultSet rs = ps.executeQuery();
//    		
//    		if (rs.next()) {
//    			return rs.getInt("quantity");
//    			
//    		}
//    	} catch (Exception e) {
//    		e.printStackTrace();
//    	}
//    	
//    	return 0;
//    }
//    public boolean themOrderDetail(Order model) {
//        try (Connection connection = MyConnectDB.connect();
//             PreparedStatement stmt = connection.prepareStatement("INSERT INTO orders_details (orderid, quantity, price, productId) VALUES (?, ?, ?, ?)")) {
//
//            // Iterate through each OrderDetail object in the list
//            for (OrderDetail orderDetail : model.getOrderdetail()) {
//                // Set parameter values for each OrderDetail
//                stmt.setString(1, model.getOrderid());
//                stmt.setInt(2, orderDetail.getQuantity()); // Use getInt for quantity
//                stmt.setDouble(3, orderDetail.getPrice()); // Use getDouble for price
//                stmt.setString(4, orderDetail.getProduct().getId()); // Assuming Product has an "id" field
//
//                // Execute the update for each OrderDetail
//                int affectedRows = stmt.executeUpdate();
//                if (affectedRows == 0) {
//                    return false; // Indicate failure if no rows were inserted
//                }
//            }
//            return true; // All OrderDetail objects were inserted successfully
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    
//    }
    public static void main(String[] args) {
    	OrderDAO dao = new OrderDAO();
    	int n = dao.getTotalProduct(1);
    	double n1 = dao.getTotalDrinkSellM("Cà phê", 1);
    	System.out.println(n);
    	List<Checkout> list = dao.getAllCheckout();
    	System.out.println(list);
    	System.out.println(n1);
	
	}
}
