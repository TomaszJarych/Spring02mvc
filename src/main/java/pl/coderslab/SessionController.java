package pl.coderslab;

import java.time.LocalDateTime;
import static pl.coderslab.SessionController.LOGIN_START;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(LOGIN_START)
public class SessionController {
	 static final String LOGIN_START = "loginStart";

	@GetMapping("/datetime")
	@ResponseBody
	public String getDateTime(HttpSession session, Model model) {
		String dateime = (String)session.getAttribute(LOGIN_START);
		if (dateime != null) {
			return dateime;
		}
		String localDateTime =LocalDateTime.now().toString();
		model.addAttribute(LOGIN_START, localDateTime);
		return localDateTime;
		
	}

}
//#### Zadanie 1 - rozwiązywane z wykładowcą
//1. Utwórz kontroler `SessionController`.
//2. Sprawdź czy w sesji jest zapisana wartość pod kluczem  `loginStart`.
//3. Jeżeli jest zapisana wyświetl ją - skorzystaj z adnotacji `@ResponseBody`.
//4. Jeżeli nie ma wartości - wstaw bieżącą datę i godzinę.