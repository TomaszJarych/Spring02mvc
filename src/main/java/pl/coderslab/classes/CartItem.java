package pl.coderslab.classes;

public class CartItem {
	private  Integer quantity;
	private final Product product;

	public CartItem(Integer quantity, Product product) {
		this.quantity = quantity;
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	

}
