package pl.coderslab;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.classes.Cart;
import pl.coderslab.classes.CartItem;
import pl.coderslab.classes.Product;
import pl.coderslab.classes.ProductDao;

@Controller
public class CartController {
	private final Cart cart;

	@Autowired
	public CartController(Cart cart) {
		this.cart = cart;
	}

	@RequestMapping("/addtocart")
	@ResponseBody
	public String addtocart(@RequestParam(name = "id", required = true) long id,
			@RequestParam(name = "quantity", required = true) int quantity, Model model, HttpSession ses) {
		Product productToAdd=getProduct(id);
		List<CartItem> cartItems = cart.getCartItems();
		for (CartItem cartItem : cartItems) {
			if (cartItem.getProduct().equals(productToAdd)) {
				cartItem.setQuantity(quantity);
			}else {
				if (productToAdd != null) {
					cart.addToCart(new CartItem(quantity, productToAdd));
				}
			}
		}
		model.addAttribute("cart", cart);
		return "addtocart";
	}

	public Product getProduct(long id) {
		List<Product> productList = ProductDao.getList();
		for (Product product : productList) {
			if (product.getId() == id) {
				return product;
			}
		}
		return null;
	}
}
