package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Model.Cart;
import Model.Comments;
import Model.MyConnectDB;
import Model.Product;

public class ProductDAO {
	private MyConnectDB connectDB;
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

    public ProductDAO() {
        connectDB = new MyConnectDB();
    }
    public List<Product> getAllProduct(){
    	ArrayList<Product> list = new ArrayList<Product>();
    	 try {
             ResultSet rs = connectDB.chonDuLieu("Select * FROM product");
             while(rs.next()) {
            	 list.add(new Product(rs.getString(1),
            			 rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6),rs.getString(7)));
             }
            
         } catch (Exception e) {
             e.printStackTrace();
         }
    	 return list;
    }
    public List<Product> getAllProductE(){
    	ArrayList<Product> list = new ArrayList<Product>();
    	try {
    		ResultSet rs = connectDB.chonDuLieu("Select * FROM producteng");
    		while(rs.next()) {
    			list.add(new Product(rs.getString(1),
    					rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6),rs.getString(7)));
    		}
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return list;
    }
    public List<Product> getAllProductByCaid(String caid){
    	ArrayList<Product> list2 = new ArrayList<Product>();
    	try {
    		ResultSet rs = connectDB.chonDuLieu("SELECT * FROM product WHERE categoryid = '"+ caid +"'");
    		while(rs.next()) {
    			list2.add(new Product(rs.getString(1),
    					rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6),rs.getString(7)));
    		}
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return list2;
    }
    public List<Product> getAllProductByCaidE(String caid){
    	ArrayList<Product> list2 = new ArrayList<Product>();
    	try {
    		ResultSet rs = connectDB.chonDuLieu("SELECT * FROM producteng WHERE categoryid = '"+ caid +"'");
    		while(rs.next()) {
    			list2.add(new Product(rs.getString(1),
    					rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6),rs.getString(7)));
    		}
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return list2;
    }
    	public List<Product> getProductByName(String name){
    		ArrayList<Product> list2 = new ArrayList<Product>();
    		try {
    			ResultSet rs = connectDB.chonDuLieu("SELECT * FROM product WHERE BINARY name like '"+"%" + name + "%"+ "'");
    			while(rs.next()) {
    				list2.add(new Product(rs.getString(1),
    						rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6),rs.getString(7)));
    			}
    			
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		return list2;
    }
    public List<Product> getAllProductFromAtoZ(){
    	ArrayList<Product> list3 = new ArrayList<Product>();
    	try {
    		ResultSet rs = connectDB.chonDuLieu("SELECT *\r\n"
    				+ "FROM product\r\n"
    				+ "WHERE name LIKE '%a%'\r\n"
    				+ "ORDER BY name;");
    		while(rs.next()) {
    			list3.add(new Product(rs.getString(1),
    					rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6),rs.getString(7)));
    		}
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return list3;
    }
    public List<Product> getAllProductFromZtoA(){
    	ArrayList<Product> list4 = new ArrayList<Product>();
    	try {
    		ResultSet rs = connectDB.chonDuLieu("SELECT *\r\n"
    				+ "FROM product\r\n"
    				+ "WHERE name LIKE '%a%'\r\n"
    				+ "ORDER BY name DESC;");
    		while(rs.next()) {
    			list4.add(new Product(rs.getString(1),
    					rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6),rs.getString(7)));
    		}
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return list4;
    }
    public List<Product> getAllProductPrice1(){
    	ArrayList<Product> list3 = new ArrayList<Product>();
    	try {
    		ResultSet rs = connectDB.chonDuLieu("SELECT * FROM product where price between 0 and 50.00");
    		while(rs.next()) {
    			list3.add(new Product(rs.getString(1),
    					rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6),rs.getString(7)));
    		}
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return list3;
    }
    public List<Product> getAllProductPrice2(){
    	ArrayList<Product> list3 = new ArrayList<Product>();
    	try {
    		ResultSet rs = connectDB.chonDuLieu("SELECT * FROM product where price between 50.00 and 100.00");
    		while(rs.next()) {
    			list3.add(new Product(rs.getString(1),
    					rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6),rs.getString(7)));
    		}
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return list3;
    }
    public List<Product> getAllProductPrice3(){
    	ArrayList<Product> list3 = new ArrayList<Product>();
    	try {
    		ResultSet rs = connectDB.chonDuLieu("SELECT * FROM product where price between 100.00 and 500.00");
    		while(rs.next()) {
    			list3.add(new Product(rs.getString(1),
    					rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6),rs.getString(7)));
    		}
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return list3;
    }
    public Product getAllProductById(String id) {
        Product p = new Product();
        String querry = "SELECT * FROM product WHERE productId = '" + id + "'";

        try (Connection conn = MyConnectDB.connect();
             PreparedStatement ps = conn.prepareStatement(querry)) {
               
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    p.setId(rs.getString(1));
                    p.setProname(rs.getString(2));
                    p.setDescriptions(rs.getString(3));
                    p.setImage(rs.getString(4));
                    p.setPrice(rs.getDouble(5));
                    p.setAvailnumber(rs.getInt(6));
                    p.setCategoryid(rs.getString(7));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        return p;
    }
    public Product getAllProductByIdE(String id) {
    	Product p = new Product();
    	String querry = "SELECT * FROM producteng WHERE productId = '" + id + "'";
    	
    	try (Connection conn = MyConnectDB.connect();
    			PreparedStatement ps = conn.prepareStatement(querry)) {
    		
    		ResultSet rs = ps.executeQuery();
    		
    		if (rs.next()) {
    			p.setId(rs.getString(1));
    			p.setProname(rs.getString(2));
    			p.setDescriptions(rs.getString(3));
    			p.setImage(rs.getString(4));
    			p.setPrice(rs.getDouble(5));
    			p.setAvailnumber(rs.getInt(6));
    			p.setCategoryid(rs.getString(7));
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	return p;
    }
   
    public Double getPriceById(String id) {
    	
    	String querry = "SELECT price FROM product WHERE productId = '" + id + "'";
    	
    	try (Connection conn = MyConnectDB.connect();
    			PreparedStatement ps = conn.prepareStatement(querry)) {
    		
    		ResultSet rs = ps.executeQuery();
    		
    		if (rs.next()) {
    			return rs.getDouble("price");
    			
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	return null;
    }
    public String getProNameById(String id) {
    	
    	String querry = "SELECT name FROM product WHERE productId = '" + id + "'";
    	
    	try (Connection conn = MyConnectDB.connect();
    			PreparedStatement ps = conn.prepareStatement(querry)) {
    		
    		ResultSet rs = ps.executeQuery();
    		
    		if (rs.next()) {
    			return rs.getString("name");
    			
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	return null;
    }
    public int getTotalProduct() {
    	 try {
             ResultSet rs1 = connectDB.chonDuLieu("Select COUNT(*) FROM product");
             while(rs1.next()) {
            	 return rs1.getInt(1);
             }
    	 }catch (Exception e) {
    		 e.printStackTrace();
		}
    	 return 0;
    }
    public boolean themProduct(String productid,String name,String des,String url,double price,int number,String categoryid) {
    	;
        try (Connection connection = MyConnectDB.connect();
             PreparedStatement stmt = connection.prepareStatement("INSERT INTO product (productId,name,descriptions,imagelink,price,available_number,categoryid) VALUES (?, ?, ?, ?, ?,?,?)")) {
            // Set parameter values
            stmt.setString(1, productid);
            stmt.setString(2, name);
            stmt.setString(3, des);
            stmt.setString(4, url);
            stmt.setDouble(5, price);
            stmt.setInt(6, number);
            stmt.setString(7, categoryid);
           

            // Execute the update
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean checkProductExists(String productid) {
        boolean exists = false;
        try {
            ResultSet rs = connectDB.chonDuLieu("select * from product where productId ='" + productid  + "'");
            if (rs.next()) {
                exists = true;
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exists;
    }
    public boolean checkCatExists(String caid) {
    	boolean exists = false;
    	try {
    		ResultSet rs = connectDB.chonDuLieu("select * from product where categoryid ='" + caid  + "'");
    		if (rs.next()) {
    			exists = true;
    			
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return exists;
    }
    public boolean checkCategoryExists(String categoryid) {
    	boolean exists = false;
    	try {
    		ResultSet rs = connectDB.chonDuLieu("select * from product where categoryid ='" + categoryid + "'");
    		if (rs.next()) {
    			exists = true;
    			
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return exists;
    }
    public List<Cart> getCartProducts(ArrayList<Cart> cartList) throws Exception {
        List<Cart> product = new ArrayList<>();
        try {
            if (cartList.size() > 0) {
                for (Cart item : cartList) {
                    String productQuery = "SELECT * FROM product WHERE productId = ?";

                    try (Connection conn = MyConnectDB.connect();
                         PreparedStatement ps = conn.prepareStatement(productQuery)) {

                        ps.setString(1, item.getId());  // Now correctly setting parameter 1
                        ResultSet rs = ps.executeQuery();
                   
                    while (rs.next()) {
                        Cart row = new Cart();
                        row.setId(rs.getString("productId"));
                        row.setProname(rs.getString("name"));
                        row.setDescriptions(rs.getString("descriptions"));
                        row.setImage(rs.getString("imagelink"));
                        row.setPrice(rs.getDouble("price")*item.getQuantity());
                        row.setAvailnumber(rs.getInt("available_number"));
                        row.setCategoryid(rs.getString("categoryid"));
                        row.setQuantity(item.getQuantity());
                        product.add(row);
                    
                }
                     }
                }
            }
                }catch (SQLException e) {
                	e.printStackTrace();
                	System.out.println(e.getMessage());
                }
                return product;
            
    }
    public double getTotalCart(ArrayList<Cart> cartList) {
    	double sum=0;
    	try {
			if(cartList.size() > 0) {
				for(Cart item:cartList) {
                    String productQuery = "SELECT price FROM product WHERE productId = ?";
                    try (Connection conn = MyConnectDB.connect();
                            PreparedStatement ps = conn.prepareStatement(productQuery)) {

                           ps.setString(1, item.getId());  // Now correctly setting parameter 1
                           ResultSet rs = ps.executeQuery();
                           while(rs.next()) {
                        	   sum+=rs.getDouble("price")*item.getQuantity();
                           }

				}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
    	return sum;
    	
    }
    public boolean updateProduct(String productid, String name, String des, String url, double price, int number, String categoryid) {
        try (Connection connection = MyConnectDB.connect()) {
            // Disable foreign key checks
            try (PreparedStatement disableChecksStmt = connection.prepareStatement("SET FOREIGN_KEY_CHECKS=0;")) {
                disableChecksStmt.executeUpdate();
            }

            try (PreparedStatement stmt = connection.prepareStatement("UPDATE product SET name=?, descriptions=?, imagelink=?, price=?, available_number=?, categoryid=? WHERE productId=?")) {
                // Set parameter values
                stmt.setString(1, name);
                stmt.setString(2, des);
                stmt.setString(3, url);
                stmt.setDouble(4, price);
                stmt.setInt(5, number);
                stmt.setString(6, categoryid);
                stmt.setString(7, productid);

                // Execute the update
                int affectedRows = stmt.executeUpdate();

                // Enable foreign key checks again
                try (PreparedStatement enableChecksStmt = connection.prepareStatement("SET FOREIGN_KEY_CHECKS=1;")) {
                    enableChecksStmt.executeUpdate();
                }

                return affectedRows > 0; // True if the update is successful, False otherwise
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean deleteProduct(String productid) {
        try (Connection connection = MyConnectDB.connect();
             PreparedStatement stmt = connection.prepareStatement("SET FOREIGN_KEY_CHECKS=0;"
             		)) {
            stmt.executeUpdate(); // Execute the first statement to disable foreign key checks
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        try (Connection connection = MyConnectDB.connect();
             PreparedStatement stmt = connection.prepareStatement("DELETE FROM product WHERE productId = ?")) {
            // Set parameter values
            stmt.setString(1, productid);

            // Execute the update
            int affectedRows = stmt.executeUpdate();

            // Enable foreign key checks again
            try (PreparedStatement enableForeignKeyChecks = connection.prepareStatement("SET FOREIGN_KEY_CHECKS=1;"
             		)) {
                enableForeignKeyChecks.executeUpdate();
            }

            return affectedRows > 0; // True if the update is successful, False otherwise
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean deleteProducts(StringBuilder productid) {
    	  try (Connection connection = MyConnectDB.connect()) {
              // Disable foreign key checks
              try (PreparedStatement disableChecksStmt = connection.prepareStatement("SET FOREIGN_KEY_CHECKS=0;")) {
                  disableChecksStmt.executeUpdate();
              }

              // Truncate the Comments table
              try (PreparedStatement truncateStmt = connection.prepareStatement("DELETE FROM product where productId IN (" + productid + ")")) {
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
    public boolean deleteProductByCaid(String caid) {
    	try (Connection connection = MyConnectDB.connect();
    			PreparedStatement stmt = connection.prepareStatement("DELETE FROM product WHERE categoryid = ?")) {
    		// Set parameter values
    		stmt.setString(1, caid);
    		
    		// Execute the update
    		int affectedRows = stmt.executeUpdate();
    		return affectedRows > 0; // True if the update is successful, False otherwise
    	} catch (Exception e) {
    		e.printStackTrace();
    		return false;
    	}
    }
    public boolean deleteAllProduct() {
        try (Connection connection = MyConnectDB.connect();
             Statement statement = connection.createStatement()) {
            // Disable foreign key checks
            statement.executeUpdate("SET FOREIGN_KEY_CHECKS=0;");

            // Truncate the 'product' table
            statement.executeUpdate("TRUNCATE TABLE product;");

            // Enable foreign key checks
            statement.executeUpdate("SET FOREIGN_KEY_CHECKS=1;");

            return true; // Return true if the execution is successful
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    
    public boolean deleteComment(String date) {
        try (Connection connection = MyConnectDB.connect();
             PreparedStatement stmt = connection.prepareStatement("DELETE FROM Comments WHERE Comment_Date = ?")) {
            // Set parameter values
            stmt.setString(1, date);

            // Execute the update
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0; // True if the update is successful, False otherwise
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean deleteAllCommentByUserName(String username) {
    	try (Connection connection = MyConnectDB.connect();
    			PreparedStatement stmt = connection.prepareStatement("DELETE FROM Comments WHERE Username = ?")) {
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
    public boolean deleteAllCommentAdmin() {
        try (Connection connection = MyConnectDB.connect()) {
            // Disable foreign key checks
            try (PreparedStatement disableChecksStmt = connection.prepareStatement("SET FOREIGN_KEY_CHECKS=0;")) {
                disableChecksStmt.executeUpdate();
            }

            // Truncate the Comments table
            try (PreparedStatement truncateStmt = connection.prepareStatement("TRUNCATE TABLE Comments;")) {
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
    public boolean deleteCommentsAdmin(StringBuilder date) {
  	  try (Connection connection = MyConnectDB.connect()) {
            // Disable foreign key checks
            try (PreparedStatement disableChecksStmt = connection.prepareStatement("SET FOREIGN_KEY_CHECKS=0;")) {
                disableChecksStmt.executeUpdate();
            }

            // Truncate the Comments table
            try (PreparedStatement truncateStmt = connection.prepareStatement("DELETE FROM Comments where Comment_date IN (" + date + ")")) {
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
    public List<Comments> getAllComment(){
    	ArrayList<Comments> list = new ArrayList<Comments>();
    	 try {
             ResultSet rs = connectDB.chonDuLieu("Select * FROM Comments");
             while(rs.next()) {
            	 list.add(new Comments(rs.getString(1),
            			 rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5)));
             }
            
         } catch (Exception e) {
             e.printStackTrace();
         }
    	 return list;
    }
    public boolean themComment(Comments model) {
    	;
        try (Connection connection = MyConnectDB.connect();
             PreparedStatement stmt = connection.prepareStatement("INSERT INTO Comments(ProductId,Productname,Username,DetailComment,Comment_date) VALUES (?, ?, ?, ?, ?)")) {
            // Set parameter values
            stmt.setString(1, model.Productid);
            stmt.setString(2, model.getProductname());
            stmt.setString(3, model.getUsername());
            stmt.setString(4, model.getDetailcomment());
            stmt.setString(5, model.getCommentdate());
           

            // Execute the update
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public List<Comments> getAllCommentByUserName(String userName) {
    	ArrayList<Comments> list = new ArrayList<Comments>();
    	try {
            ResultSet rs = connectDB.chonDuLieu("SELECT * FROM Comments WHERE UserName = '" + userName + "'");
            while(rs.next()) {
           	 list.add(new Comments(rs.getString(1),
           			 rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5)));
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
   	 return list;
       
    }
    public int CountComment(String productId) {
        String query = "SELECT COUNT(*) AS commentCount FROM Comments WHERE ProductId = ?";  // Correct query to count comments

        try (Connection conn = MyConnectDB.connect();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, productId);  // Set the productId parameter
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("commentCount");  // Retrieve the comment count
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;  // Return 0 if no comments found or an error occurs
    }
    public List<Comments> getAllNewestComment(){
    	ArrayList<Comments> list = new ArrayList<Comments>();
    	try {
    		ResultSet rs = connectDB.chonDuLieu("Select * FROM Comments\r\n"
    				+ "ORDER BY Comment_date DESC");
    		while(rs.next()) {
    			list.add(new Comments(rs.getString(1),
              			 rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5)));
    		}
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return list;
    }
    public List<Comments> getAllOldestComment(){
    	ArrayList<Comments> list = new ArrayList<Comments>();
    	try {
    		ResultSet rs = connectDB.chonDuLieu("Select * FROM Comments\r\n"
    				+ "ORDER BY Comment_date ASC");
    		while(rs.next()) {
    			list.add(new Comments(rs.getString(1),
    					rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5)));
    		}
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return list;
    }
    
	
	  public List<Product> pagingProduct(int index){ List<Product> lists = new
	  ArrayList<Product>(); String querry =
	  "SELECT * FROM product ORDER BY productId LIMIT ?, 12;\r\n"
	  + "";
	  
	  try { conn = MyConnectDB.connect(); ps = conn.prepareStatement(querry);
	  ps.setInt(1, (index-1)*12); 
	  rs = ps.executeQuery(); 
	  while (rs.next()) {
	  lists.add(new Product(rs.getString(1), rs.getString(2), rs.getString(3),
	  rs.getString(4), rs.getDouble(5), rs.getInt(6),rs.getString(7))); 
	  }
	  
	  
	  } catch (Exception e) { e.printStackTrace(); } return lists; }
	 
    
    
    public static void main(String[] args) {
		
		/*
		 * ProductDAO dao = new ProductDAO(); List<Product> list =
		 * dao.getAllProductPrice1(); for(Product o:list) { System.out.println(o); }
		 * List<Comments> listC = dao.getAllComment(); for(Comments c:listC) {
		 * System.out.println(c); } List<Comments> listC1 =
		 * dao.getAllCommentByUserName("Andree"); for(Comments c1:listC1) {
		 * System.out.println(c1); }
		 */

  	
  	
    	ProductDAO dao6 = new ProductDAO(); List<Product> list6 = dao6.pagingProduct(1);
    	for(Product o6:list6) { System.out.println(o6); }
//    	ProductDAO dao7 = new ProductDAO(); List<Product> list7 = dao.getProductByName("Cà");
//    	for(Product o7:list7) { System.out.println(o7); }
//		 
//		  ProductDAO dao4 = new ProductDAO(); List<Product> list2 = dao.getAllProductByCaid("ca01");
//		  for(Product o2:list2) { System.out.println(o2); }
//		  ProductDAO dao5 = new ProductDAO(); List<Product> list3 = dao.getAllProductFromAtoZ();
//		  for(Product o3:list3) { System.out.println(o3); }
//		 
//		
		  ProductDAO dao2 = new ProductDAO(); int count = dao2.getTotalProduct();
		  System.out.println(count);
		 
			
		  ProductDAO dao3 = new ProductDAO();
			/*
			 * Comments c1 = new Comments("p05","Cà phê latte","Andree","Dở","2010-01-01");
			 * boolean comment = dao3.themComment(c1);
			 */
		  boolean ca = dao3.checkCategoryExists("ca01");
		  
		  
		  System.out.println(ca);
		  String pro = dao3.getProNameById("p05");
		  System.out.println(pro);
		  boolean deletecomment = dao3.deleteComment("2024-01-08 22:03:16"
		  		);
//          Double d = dao3.getPriceById("p01");
//          dao3.deleteProductByCaid("ca01");
//          dao3.updateProduct("p30", "S", "S", "S", 1.00, 1, "ca01");
//          dao3.themProduct("p31","Cf","Cf","src",10.00,2,"ca01");
//          System.out.println(d);
	        // Trường hợp 1: Sản phẩm có tồn tại với ID được cung cấp
	        System.out.println("Trường hợp 1: Sản phẩm có tồn tại với ID được cung cấp");
	        Product p1 = dao3.getAllProductById("p02");
	        Product p2 = dao3.getAllProductByIdE("p02");
	        System.out.println(p2);
	        if (p1 != null) {
	            System.out.println(p1);
	        } else {
	            System.out.println("No product found with id p02.");
	        }

			 
    	

	}
}
