package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.MyConnectDB;
import Model.Product;
import Model.Categorys;

public class CategoryDAO {
	private MyConnectDB connectDB;
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public CategoryDAO() {
		connectDB = new MyConnectDB();
		// TODO Auto-generated constructor stub
	} 
      
    public List<Categorys> getAllCategory(){
    	List<Categorys> list = new ArrayList<Categorys>();
    	 try {
             ResultSet rs = connectDB.chonDuLieu("Select * FROM category");
             while(rs.next()) {
            	 list.add(new Categorys(rs.getString(1),
            			 rs.getString(2)));
             }
            
         } catch (Exception e) {
             e.printStackTrace();
         }
    	 return list;
    }
    public List<Categorys> getCategoryByid(String caid){
		ArrayList<Categorys> list2 = new ArrayList<Categorys>();
		try {
			ResultSet rs = connectDB.chonDuLieu("SELECT * from category where categoryid = '" + caid + "'");
			while(rs.next()) {
				list2.add(new Categorys(rs.getString(1),
						rs.getString(2)));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list2;
}
    public Categorys getAllCatById(String id) {
        Categorys p = new Categorys();
        String querry = "SELECT * from category where categoryid = '" + id + "'";

        try (Connection conn = MyConnectDB.connect();
             PreparedStatement ps = conn.prepareStatement(querry)) {
               
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    p.setId(rs.getString(1));
                    p.setCaname(rs.getString(2));
                    
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        return p;
    }
    public boolean checkCategoryExists(String caid) {
        boolean exists = false;
        try {
            ResultSet rs = connectDB.chonDuLieu("select * from category where categoryid ='" + caid  + "'");
            if (rs.next()) {
                exists = true;
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exists;
    }
    public boolean deleteCategory(String caid) {
        try (Connection connection = MyConnectDB.connect();
             PreparedStatement stmt = connection.prepareStatement("SET FOREIGN_KEY_CHECKS=0;"
             		)) {
            stmt.executeUpdate(); // Execute the first statement to disable foreign key checks
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        try (Connection connection = MyConnectDB.connect();
             PreparedStatement stmt = connection.prepareStatement("DELETE FROM category WHERE categoryid = ?")) {
            // Set parameter values
            stmt.setString(1, caid);

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
    public boolean deleteAllCategory() {
        try (Connection connection = MyConnectDB.connect();
        		PreparedStatement stmt1 = connection.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
        	     PreparedStatement stmt2 = connection.prepareStatement("TRUNCATE TABLE category");
        	     PreparedStatement stmt3 = connection.prepareStatement("SET FOREIGN_KEY_CHECKS=1")) {

        	    stmt1.executeUpdate();
        	    stmt2.executeUpdate();
        	    stmt3.executeUpdate();
            // Execute the update
            int affectedRows = stmt2.executeUpdate();
            return affectedRows > 0; // True if the update is successful, False otherwise
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
	
    }
    public boolean deleteCategorys(StringBuilder caid) {
  	  try (Connection connection = MyConnectDB.connect()) {
            // Disable foreign key checks
            try (PreparedStatement disableChecksStmt = connection.prepareStatement("SET FOREIGN_KEY_CHECKS=0;")) {
                disableChecksStmt.executeUpdate();
            }

            // Truncate the Comments table
            try (PreparedStatement truncateStmt = connection.prepareStatement("DELETE FROM category where categoryid IN (" + caid + ")")) {
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
    public boolean deleteCategoryProducts(StringBuilder caid) {
    	try (Connection connection = MyConnectDB.connect()) {
    		// Disable foreign key checks
    		try (PreparedStatement disableChecksStmt = connection.prepareStatement("SET FOREIGN_KEY_CHECKS=0;")) {
    			disableChecksStmt.executeUpdate();
    		}
    		
    		// Truncate the Comments table
    		try (PreparedStatement truncateStmt = connection.prepareStatement("DELETE FROM product where categoryid IN (" + caid + ")")) {
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
    public boolean updateCategory(String categoryid, String name)  {
  		  try (Connection connection = MyConnectDB.connect();
  				  PreparedStatement stmt = connection.prepareStatement("UPDATE category SET caname=? WHERE categoryid=? ")) {
  			  // Set parameter values
  			  stmt.setString(1, name);
  			  stmt.setString(2, categoryid);
  			

  			  
  			  // Execute the update
  			  int affectedRows = stmt.executeUpdate();
  			  return affectedRows > 0; // True nếu cập nhật thành công, False nếu không
  		  } catch (Exception e) {
  			  e.printStackTrace();
  			  return false;
  		  }
    }
    
    public boolean themCategory(String categoryid,String name) {
    	;
        try (Connection connection = MyConnectDB.connect();
             PreparedStatement stmt = connection.prepareStatement("INSERT INTO category(categoryid,caname) VALUES (?, ?)")) {
            // Set parameter values
            stmt.setString(1, categoryid);
            stmt.setString(2, name);
          
           

            // Execute the update
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static void main(String[] args) {
		CategoryDAO dao = new CategoryDAO();
//		dao.deleteAllCategory();
		List<Categorys> ca = dao.getCategoryByid("ca01");
		System.out.println(ca);
	}
}
