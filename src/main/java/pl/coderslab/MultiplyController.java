package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MultiplyController {
	
	@GetMapping("/multiply")
	@ResponseBody
	public String multiply(@RequestParam("size") int size) {
		String output ="";
		output +="<html><body><table border=\"=1\">";
		output +="<tr>";
		for (int i = 1; i <= size; i++) {
			output += "<td>"+i+"</td>";
		}
		output +="</tr>";
		
		for (int i = 1; i <= size; i++) {
			output+= "<tr>";
			for (int j = 1; j <= size; j++) {
				output += "<td>"+i*j+"</td>";
			}
			output += "</tr>";
		}
		output += "</table></body></html>";
		
		return output;
	}
	@GetMapping("/paramMultiply/{rows}/{col}")
	@ResponseBody
	public String multiply(@PathVariable int rows, 
						@PathVariable int col) {
		String output ="";
		output +="<html><body><table border=\"=1\">";
		output +="<tr>";
		for (int i = 1; i <= col; i++) {
			output += "<td>"+i+"</td>";
		}
		output +="</tr>";
		
		for (int i = 1; i <= rows; i++) {
			output+= "<tr>";
			for (int j = 1; j <= col; j++) {
				output += "<td>"+i*j+"</td>";
			}
			output += "</tr>";
		}
		output += "</table></body></html>";
		
		return output;
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