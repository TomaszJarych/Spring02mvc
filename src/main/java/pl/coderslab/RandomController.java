package pl.coderslab;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RandomController {
	
	Random random = new Random();
	
	@GetMapping("/showRandom")
	@ResponseBody
	public String showRandom() {
		int randomNumber = random.nextInt(100)+1;
		return "Wylosowano liczbe: "+randomNumber;
	}

}
// #### Zadanie 3
//
// 1. Utwórz kontroler o nazwie `RandomController`.
// 2. Utwórz akcję kontrolera o nazwie `showRandom`, która wylosuje liczbę z
// zakresu od 1 do 100.
// 3. Wyświetli w przeglądarce napis: **Wylosowano liczbę: <wylosowana
// liczba>**.
