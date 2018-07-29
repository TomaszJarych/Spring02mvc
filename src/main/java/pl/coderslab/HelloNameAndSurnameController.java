package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("first") // Zadanie 5
public class HelloNameAndSurnameController {
	@RequestMapping("/hello/{firstName}/{lastName}")
	@ResponseBody
	public String helloName(@PathVariable("firstName") String firsName, 
							@PathVariable("lastName") String lastName) {
		return "Hello "+firsName+" "+lastName;
	}

}
// #### Zadanie 3
//
// 1. Utwórz akcję dostępną pod pod adresem `/hello/<firstName>/<lastName>`
// gdzie `firstName` oraz `lastName` będą pobranymi parametrami.
// 3. Wyświetl w przeglądarce dane w następujący sposób: **Witaj** `<firstName>
// <lastName>`.
//#### Zadanie 5
//1. Dodaj do całego kontrolera przedrostek `/first`. 
//2. Sprawdź, jak zmieniły się adresy akcji z poprzedniego zadania.