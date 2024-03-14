package Model;

import java.util.ArrayList;
import java.util.List;

public class Cart extends Product{
	private int quantity;
	

	

	public Cart() {
	}


	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	@Override
	public String toString() {
		return "Cart [quantity=" + quantity + "]";
	}
	
	
	

}
