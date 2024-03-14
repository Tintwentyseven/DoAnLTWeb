package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Model.KhachHang;
import Model.MyConnectDB;
import Model.User;

public class KhachHangDAO implements ObjectDAO {

    private MyConnectDB connectDB;

    public KhachHangDAO() {
        connectDB = new MyConnectDB();
    }

    public boolean themTaiKhoan(Object obj) {
    	KhachHang kh = (KhachHang) obj;
        try (Connection connection = MyConnectDB.connect();
             PreparedStatement stmt = connection.prepareStatement("INSERT INTO users (username, password, firstname, email, phonenumber, address,roles) VALUES (?, ?, ?, ?, ?, ?, ?)")) {
            // Set parameter values
            stmt.setString(1, kh.getUserName());
            stmt.setString(2, kh.getPassword());
            stmt.setString(3, kh.getName());
            stmt.setString(4, kh.getEmail());
            stmt.setString(5, kh.getPhonenumber());
            stmt.setString(6, kh.getAddress());
            stmt.setString(7, kh.getRoles());

            // Execute the update
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean updateMatKhauTheoTenDangNhap(String username, String newPassword) {
    	  try (Connection connection = MyConnectDB.connect();
    	        PreparedStatement stmt = connection.prepareStatement("UPDATE users SET password = ? WHERE username = ?")) {
    	    // Set parameter values
    	    stmt.setString(1, newPassword);
    	    stmt.setString(2, username);

    	    // Execute the update
    	    int affectedRows = stmt.executeUpdate();
    	    return affectedRows > 0; // True nếu cập nhật thành công, False nếu không
    	  } catch (Exception e) {
    	    e.printStackTrace();
    	    return false;
    	  }
    }
    public boolean update(String userid, String role) {
    	try (Connection connection = MyConnectDB.connect();
    			PreparedStatement stmt = connection.prepareStatement("UPDATE users SET roles = ? WHERE userid = ?")) {
    		// Set parameter values
    		stmt.setString(1, role);
    		stmt.setString(2, userid);
    		
    		// Execute the update
    		int affectedRows = stmt.executeUpdate();
    		return affectedRows > 0; // True nếu cập nhật thành công, False nếu không
    	} catch (Exception e) {
    		e.printStackTrace();
    		return false;
    	}
    }
    	  public boolean updateUser(String userid,String username,String password,String name, String email,String phoneNumber,String address) {
    		  try (Connection connection = MyConnectDB.connect();
    				  PreparedStatement stmt = connection.prepareStatement("UPDATE users SET username=?,password=?,firstname=?,email=?,phoneNumber=?,address=? where userid='" + userid + "' ")) {
    			  // Set parameter values
    			  stmt.setString(1, username);
    			  stmt.setString(2, password);
    			  stmt.setString(3, name);
    			  stmt.setString(4, email);
    			  stmt.setString(5, phoneNumber);
    			  stmt.setString(6, address);

    			  
    			  // Execute the update
    			  int affectedRows = stmt.executeUpdate();
    			  return affectedRows > 0; // True nếu cập nhật thành công, False nếu không
    		  } catch (Exception e) {
    			  e.printStackTrace();
    			  return false;
    		  }
    	}
    
    public boolean checkUsernameExists(String username) {
        boolean exists = false;
        try {
            ResultSet rs = connectDB.chonDuLieu("select * from users where UserName='" + username + "'");
            if (rs.next()) {
                exists = true;
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exists;
    }
    public boolean checkEmailExists(String email) {
    	boolean exists = false;
    	try {
    		ResultSet rs = connectDB.chonDuLieu("select * from users where Email='" + email + "'");
    		if (rs.next()) {
    			exists = true;
    			
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return exists;
    }
    public String takePass(String email) {
        String password = null;
        try {
            ResultSet rs = connectDB.chonDuLieu("select Password from users where Email='" + email + "'");
            if (rs.next()) {
                password = rs.getString("Password");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return password;
    }
    public int getView() {
    	int num = 0;
    	try {
    		ResultSet rs = connectDB.chonDuLieu("select * from VIEWS");
    		if (rs.next()) {
    			num = rs.getInt("viewer");
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return num;
    }
    public void updateView() {
    	int count=0;
  	  try (Connection connection = MyConnectDB.connect();
  	        PreparedStatement stmt = connection.prepareStatement("UPDATE VIEWS SET viewer = viewer+1")) {
  	    // Set parameter values
  	   

  	    // Execute the update
  	    int affectedRows = stmt.executeUpdate();
  	    
  	  } catch (Exception e) {
  	    e.printStackTrace();
  	   
  	  }
  }
    
    
    public String takeRole(String username) {
    	String roles = null;
    	try {
    		ResultSet rs = connectDB.chonDuLieu("select roles from users where username ='" + username + "'");
    		if (rs.next()) {
    			roles = rs.getString("roles");
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return roles;
    }
    

    public KhachHang layThongTinTaiKhoan(String username) {
        try {
            ResultSet rs = connectDB.chonDuLieu("select * from users where username='" + username + "'");
            while (rs.next()) {
                String user = rs.getString(1);
                String pass = rs.getString(2);
                String firstname = rs.getString(3);
                String email = rs.getString(4);
                String telephone = rs.getString(5);
                String address = rs.getString(6);
                String role = rs.getString(7);
                String userid = rs.getString(8);
                return new KhachHang(user, pass, firstname, email, telephone, address,role);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public User layThongTinUser(String username) {
    	try {
    		ResultSet rs = connectDB.chonDuLieu("select username,password,firstname,email,phoneNumber,address,roles,userid from users where username='" + username + "'");
    		while (rs.next()) {
    			String user = rs.getString(1);
    			String pass = rs.getString(2);
    			String firstname = rs.getString(3);
    			String email = rs.getString(4);
    			String telephone = rs.getString(5);
    			String address = rs.getString(6);
    			String role = rs.getString(7);
    			String userid = rs.getString(8);
    			
    			return new User(user, pass, firstname, email, telephone, address,role,userid);
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return null;
    }
    public User layThongTinUser2(String userid) {
    	try {
    		ResultSet rs = connectDB.chonDuLieu("select username,password,firstname,email,phoneNumber,address,roles,userid from users where userid='" + userid + "'");
    		while (rs.next()) {
    			String user = rs.getString(1);
    			String pass = rs.getString(2);
    			String firstname = rs.getString(3);
    			String email = rs.getString(4);
    			String telephone = rs.getString(5);
    			String address = rs.getString(6);
    			String role = rs.getString(7);
    			
    			
    			return new User(user, pass, firstname, email, telephone, address,role,userid);
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return null;
    }
    public String getPasswordByUsername(String username) {
        try {
            ResultSet rs = connectDB.chonDuLieu("select * from users where UserName='" + username + "'");
            while (rs.next()) {
                String user = rs.getString(1);
                String pass = rs.getString(2);
                String firstname = rs.getString(3);
                if (user.equals(username)) {
                    return pass; // Trả về mật khẩu nếu tên người dùng khớp
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "This user does not exist."; // Trả về thông báo nếu người dùng không tồn tại
    }

    @Override
    public boolean kiemTraDangNhap(String username, String password) {
        try {
            ResultSet rs = connectDB.chonDuLieu("select * from users where username='" + username + "' and password='" + password + "'");
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public String getUserIdByEmail(String email) {
        try {
            ResultSet rs = connectDB.chonDuLieu("select userid from users where email='" + email + "'");
            if (rs.next()) {
                return rs.getString("userId"); // Return user ID if found
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // Return null if user not found
    }
    public String getEmailbyUserId(String userid) {
    	try {
    		ResultSet rs = connectDB.chonDuLieu("select email from users where userid='" + userid + "'");
    		if (rs.next()) {
    			return rs.getString("email"); // Return user ID if found
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return null; // Return null if user not found
    }
    public List<String> getEmailByRole(String role) {
    	ArrayList<String> list = new ArrayList<String>();

    	try {
    		ResultSet rs = connectDB.chonDuLieu("select email from users where roles='" + role + "'");
    		while (rs.next()) {
    			 list.add(rs.getString("email"));
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return list; // Return null if user not found
    }
    public List<User> getAllUser(){
    	ArrayList<User> list = new ArrayList<User>();
    	 try {
             ResultSet rs = connectDB.chonDuLieu("Select * FROM users where roles='User'");
             while(rs.next()) {
            	 list.add(new User(rs.getString(1),
            			 rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
             }
            
         } catch (Exception e) {
             e.printStackTrace();
         }
    	 return list;
    }
    public List<User> getAllAdmin(){
    	ArrayList<User> list = new ArrayList<User>();
    	try {
    		ResultSet rs = connectDB.chonDuLieu("Select * FROM users where roles='Admin'");
    		while(rs.next()) {
    			list.add(new User(rs.getString(1),
    					rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
    		}
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return list;
    }
    public List<User> getAllAdminExcept(){
    	ArrayList<User> list = new ArrayList<User>();
    	try {
    		ResultSet rs = connectDB.chonDuLieu("Select * FROM users where roles='Admin' and userid not like 'UID001'");
    		while(rs.next()) {
    			list.add(new User(rs.getString(1),
    					rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
    		}
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return list;
    }
    public List<User> getAdminBoss(){
    	ArrayList<User> list = new ArrayList<User>();
    	try {
    		ResultSet rs = connectDB.chonDuLieu("Select * FROM users where roles='Admin' and userid like 'UID001'");
    		while(rs.next()) {
    			list.add(new User(rs.getString(1),
    					rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
    		}
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return list;
    }
    public boolean deleteUser(String userid) {
        try (Connection connection = MyConnectDB.connect();
             PreparedStatement stmt = connection.prepareStatement("DELETE FROM users WHERE userid = ?")) {
            // Set parameter values
            stmt.setString(1, userid);

            // Execute the update
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0; // True if the update is successful, False otherwise
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean deleteUser2(String roles) {
    	try (Connection connection = MyConnectDB.connect();
    			PreparedStatement stmt = connection.prepareStatement("DELETE FROM users WHERE roles = ?")) {
    		// Set parameter values
    		stmt.setString(1, roles);
    		
    		// Execute the update
    		int affectedRows = stmt.executeUpdate();
    		return affectedRows > 0; // True if the update is successful, False otherwise
    	} catch (Exception e) {
    		e.printStackTrace();
    		return false;
    	}
    }
   
    
   
    public static void main(String[] args) {
		KhachHangDAO kh = new KhachHangDAO();
		KhachHang kh2 = kh.layThongTinTaiKhoan("Tom");
		String kh3 = kh.getUserIdByEmail("trungtinpham336@gmail.com");
		int view = kh.getView();
		System.out.println(view);
		User kh4 = kh.layThongTinUser("UID012");
		  KhachHangDAO dao = new KhachHangDAO(); List<User> list = dao.getAllUser();
		  for(User o:list) { System.out.println(o); }
		boolean dl = kh.deleteUser("UID005");
		boolean dl3 = kh.updateMatKhauTheoTenDangNhap("Neko", "1990");
		User u = kh.layThongTinUser("Andree");
		System.out.println(u);
//		boolean dl2 = kh.deleteUser2("User");
		boolean ed1 = kh.updateUser("AndreeRightHand1", "1987", "Thế Anh1", "1987@gmail.com", "011111111", "Tphcm","UID012");
		System.out.println(ed1);
//		System.out.println(dl2);
		System.out.println(kh2);
		System.out.println(kh3);
		System.out.println(kh4);
		
		List<String> liste = dao.getEmailByRole("User");
		
		// Sử dụng vòng lặp và nối chuỗi
		String resultUsingLoop = "";
		for (String email : liste) {
			resultUsingLoop += email + ", ";
		}
		// Loại bỏ dấu ',' cuối cùng nếu cần
		resultUsingLoop = resultUsingLoop.replaceAll(", $", "");
		
		System.out.println("Result using loop: " + resultUsingLoop);
		
		// Sử dụng Java 8 Streams và Collectors.joining
		String resultUsingStreams = liste.stream().collect(Collectors.joining(", "));
		System.out.println("Result using streams: " + resultUsingStreams);
    }
    
    
    
}
	

   

