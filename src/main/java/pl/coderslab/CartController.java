package pl.coderslab;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.classes.Cart;
import pl.coderslab.classes.CartItem;
import pl.coderslab.classes.Product;

@Controller
public class CartController {
	private  final Cart cart;
	@Autowired
	public CartController(Cart cart) {
		this.cart = cart;
	}
	
	@RequestMapping("/addtocart")
	@ResponseBody
	public String addtocart(Model model, HttpSession ses) {
	        Random rand = new Random();
	        cart.addToCart(new CartItem(1, new Product("prod" + rand.nextInt(10), rand.nextDouble())));
	        return "addtocart";
	}
}
