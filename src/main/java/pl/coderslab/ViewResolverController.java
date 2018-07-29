package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewResolverController {
	@GetMapping("/hello1")
	public String sayHello() {
		return "HelloWorld";
	}
	
}
