package pl.coderslab;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RandomParamController {
	@RequestMapping("/random/{max}/{min}")
	@ResponseBody
	public String getRandom(@PathVariable("max") int max, @PathVariable("min") int min) {
		Random r = new Random();
		return (r.nextInt(max - min+1)+min)+"";
	}

}
//#### Zadanie 1 - rozwiązywane z wykładowcą
//
//1. Utwórz akcję dostępną pod pod adresem `/random/<max>` gdzie `max` będzie górną granicą zbioru z którego zostanie wylosowana liczba.
//2. Wylosuj wartość od 1 do `max`.
//3. Wyświetl w przeglądarce dane w następujący sposób: **Użytkownik podał wartość <max>. Wylosowano liczbę: <wylosowana liczba>**.