package pl.coderslab;

import java.time.LocalTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Task3Controller {

	@GetMapping("/task3")
	public String getColors(Model model) {
		LocalTime localTime = LocalTime.now().plusHours(10);
		if (localTime.getHour() > 8 && localTime.getHour() < 20) {
			
		}else {
			model.addAttribute("backgroundColor", "black");
			model.addAttribute("color", "white");
		}

		return "home";
	}

}
// #### Zadanie 3
//
// 1. W widoku `home.jsp` dodaj tag `style`. Tag powinien zawierać selector
// `body`, który ustawia dwie właściwości `color` i `backgroundColor`.
// 2. Wartościami tych właściwości powinny być odpowiednio wartości przekazane z
// kontrolera `color` i `backgroundColor`.
// 4. W akcji sprawdzaj aktualną godzinę i jeśli jest między 8:00 a 20:00
// podmieniał tekst `color` i `backgroundColor` odpowiednio na `black` i
// `white`.
// 5. Gdy godzina wypada między 20:00 a 8:00, podmień wartości właściwości
// odwrotnie.
// 6. Uruchom stronę i zobacz efekt. Tekst powinien być czarny, a strona biała.
// 7. Zmodyfikuj program tak, aby nie brał pod uwagę aktualnej godziny, tylko na
// sztywno wpisz godzinę 1:00 w nocy.
// 8. Wyświetl stronę i zobacz efekt. Tekst powinien być biały, a strona czarna.
