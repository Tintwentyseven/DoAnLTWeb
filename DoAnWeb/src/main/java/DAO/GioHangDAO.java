package DAO;
import java.util.ArrayList;
import java.util.List;

import Model.Product;

public class GioHangDAO {
	public static List<Product> dsProduct= new ArrayList<>();
	public static ArrayList<Product> gioHang= new ArrayList<>();
	public GioHangDAO(){
		
		dsProduct.removeAll(dsProduct);
		ProductDAO dao = new ProductDAO();
		dsProduct = dao.getAllProduct();
	}
	public boolean kiemTraSanPhamCoTrongGioHangChua(String maSanPham){
		for (int i = 0; i < gioHang.size(); i++) {
			if(gioHang.get(i).getId().equals(maSanPham)){
				return true;
			}
		}
		return false;
	}
	
	public boolean themVaoGioHang(String maSanPham){
		boolean kiemTra = kiemTraSanPhamCoTrongGioHangChua(maSanPham);
		for (int i = 0; i <dsProduct.size(); i++) {
				if(dsProduct.get(i).getId().equals(maSanPham) && kiemTra==false){
					gioHang.add(dsProduct.get(i));
					return true;
				}
		}
		if(kiemTra==true){
			int index =gioHang.size();
			for (int i = 0; i < index; i++) {
				if(gioHang.get(i).getId().equals(maSanPham)){
					gioHang.get(i).setAvailnumber((gioHang.get(i).getAvailnumber())+1);
					index=i;
				}
			}
		}
		return false;
	}
	public boolean xoaSanPhamRaKkoiGioHang(String maSanPham){
		for (int i = 0; i < gioHang.size(); i++) {
			if(gioHang.get(i).getId().equals(maSanPham)){
				gioHang.remove(i);
				return true;
			}
		}
		return false;
	}

	public static List<Product> getDsProduct() {
		return dsProduct;
	}

	public static void setDsProduct(ArrayList<Product> dsProduct) {
		GioHangDAO.dsProduct = dsProduct;
	}

	public static ArrayList<Product> getGioHang() {
		return gioHang;
	}

	public static void setGioHang(ArrayList<Product> gioHang) {
		GioHangDAO.gioHang = gioHang;
	}
	
	

}
