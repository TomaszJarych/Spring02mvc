package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	@GetMapping("/hello")
	@ResponseBody
	public String helloWorld() {
		return "Hello World";
	}

}
//#### Zadanie 2 - rozwiązywane z wykładowcą
//
//1. Dodaj klasę konfiguracji.
//2. Utwórz inicjalizator aplikacji.
//3. Utwórz kontroler o nazwie `HelloController`.
//4. Utwórz akcję o nazwie `helloWorld`, oraz przypisz jej adres `hello`.
//5. Dodaj adnotację @ResponseBody i zwróć napis **Hello World**.
//6. Uruchom aplikację i sprawdź w przeglądarce utworzoną akcję. 
