package pl.coderslab;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import pl.coderslab.classes.Cart;
import pl.coderslab.classes.CartItem;
import pl.coderslab.classes.Product;
import pl.coderslab.classes.ProductDao;

@Controller
@SessionAttributes({ "cart", "cartSize", "totalPrice","productQuantity" })
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
		Product productToAdd = getProduct(id);
		CartItem cartItemToAdd = new CartItem(quantity, productToAdd);
		List<CartItem> cartItems = cart.getCartItems();
		if (checkIfProductIsInCart(cartItemToAdd, cartItems)) {
			cart.addToCart(cartItemToAdd);
		}else {
			for (CartItem cartItem : cartItems) {
				if (cartItem.getProduct().getId() == cartItemToAdd.getProduct().getId()) {
					cartItem.setQuantity(quantity+cartItem.getQuantity());
				}
			}
		}
		model.addAttribute("cart", cart);
		return "addtocart";
	}

	@RequestMapping("/cart")
	public String showCart(HttpSession session, Model model) {
		List<CartItem> cartItems = cart.getCartItems();
		int cartSize = cartItems.size();
		int productQuantity = 0;
		double totalPrice = 0;
		for (CartItem cartItem : cartItems) {
			productQuantity += cartItem.getQuantity();
			totalPrice += (cartItem.getQuantity()*cartItem.getProduct().getPrice());
		}
		
		model.addAttribute("cartSize", cartSize);
		model.addAttribute("productQuantity", productQuantity);
		model.addAttribute("totalPrice", totalPrice);
		return "cart";
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

	public boolean checkIfProductIsInCart(CartItem item, List<CartItem> list) {
		for (CartItem cartItem : list) {
			if (cartItem.getProduct().getId() == item.getProduct().getId()) {
				return false;
			}
		}
		return true;
	}
}
