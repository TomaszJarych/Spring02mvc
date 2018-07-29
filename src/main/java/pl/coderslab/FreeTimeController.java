package pl.coderslab;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FreeTimeController {
	LocalDateTime localDateTime = LocalDateTime.now();

	@GetMapping("/freeTime")
	@ResponseBody
	public String getFreeTime() {
		
		// poprawić if'y
		String output = "";
		String dayofWeek = localDateTime.getDayOfWeek() + "";
		if (dayofWeek == "SUNDAY" || dayofWeek == "SATURDAY") {
			output = "WOLNE";
		} else {
			if (localDateTime.getHour() >= 9 && localDateTime.getHour() < 17) {
				output = "Pracuje, nie dzwoń";
			} else {
				output = "Po Pracy";
			}
		}
		return output;
	}

}
// #### Zadanie 4
//
// 1. Utwórz kontroler o nazwie `FreeTimeController`.
// 2. Pobierz aktualną datę.
// 3. Sprawdź aktualny dzień tygodnia oraz aktualną godzinę.
// 4. Jeśli dzień przypada na sobotę lub niedzielę, zwróć tekst `Wolne`.
// 5. Jeśli dzień przypada na dzień roboczy, a godzina od 9 do 17, zwróć tekst
// `Pracuje, nie dzwoń.`.
// 6. Jeśli dzień przypada na dzień roboczy, a godzina poza zakresem 9-17 zwróć
// tekst `Po Pracy`.
// 7. Aby przetestować działanie aplikacji, możesz zamiast aktualnej daty,
// pobrać wybraną przez siebie datę i godzinę.