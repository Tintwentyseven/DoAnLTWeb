package Model;

import java.sql.Date;

public class KhachHang {
		String userName;
		String password;
		String name;
		String email;
		String phonenumber;
		String address;
		String roles;
		
		public KhachHang(String userName, String password, String name, String email, String phonenumber,
				String address, String roles) {
			super();
			this.userName = userName;
			this.password = password;
			this.name = name;
			this.email = email;
			this.phonenumber = phonenumber;
			this.address = address;
			this.roles = roles;
		
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
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
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getRoles() {
			return roles;
		}
		public void setRoles(String roles) {
			this.roles = roles;
		}
		
		@Override
		public String toString() {
			return "KhachHang [userName=" + userName + ", password=" + password + ", name=" + name + ", email=" + email
					+ ", phonenumber=" + phonenumber + ", address=" + address + ", roles=" + roles + "]";
		}
		
		
		
		
		
		
		
}
