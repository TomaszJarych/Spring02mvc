package pl.coderslab.classes;

public class CartItem {
	private final Integer quantity;
	private final Product product;

	public CartItem(Integer quantity, Product product) {
		this.quantity = quantity;
		this.product = product;
	}

}
