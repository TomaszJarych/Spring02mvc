package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MultiplyController {
	
	@GetMapping("/multiply")
	public String multiply(@RequestParam("size") int size, Model model) {
		model.addAttribute("size", size);
		return "task4";
	}

}
// #### Zadanie 4
//
// 1. Utwórz kontroler o nazwie `MultiplyController`.
// 2. Utwórz nową akcję multiply, dostępną pod adresem `/multiply`.
// 3. Akcja ma pobierać jeden parametr w URL o nazwie `size`.
// 4. Ustaw domyślną wartość tego parametru na wartość 10.
// 5. Przekaż zmienną do widoku a następnie wyświetl tabliczkę mnożenia w
// tabelce html w postaci:
//
//
// | x | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10|
// |---|---|---|---|---|---|---|---|---|---|---|
// | 1 | 1 | 2 | 3 | | | | | | | |
// | 2 | ... |
// | 3 | |
// | 4 | |
// | ... |
// | 9 | 9 |18 |27 |36 |45 |54 |63 |72 |81 |90 |
// | 10|...|