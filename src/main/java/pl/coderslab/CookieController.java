package pl.coderslab;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

@Controller
public class CookieController {

	@RequestMapping("/setcookie/{c1}/{c2}")
	@ResponseBody
	public String setCookie(@PathVariable("c1") String c1, @PathVariable("c2") String c2,
			HttpServletResponse response) {
		Cookie cookie = new Cookie("c1", c1);
		cookie.setPath("/");
		Cookie cookie2 = new Cookie("c2", c2);
		cookie2.setPath("/");
		response.addCookie(cookie);
		response.addCookie(cookie2);
		return "Cookies has been added";
	}

	@RequestMapping("/getcookie")
	@ResponseBody
	public String showCookies(@CookieValue("c1") String c1,
			HttpServletRequest request) {
		Cookie cookie = WebUtils.getCookie(request, "c2");
		return "Cookie1 value: "+c1+" "+ "cookie2 value: "+cookie.getValue();
	}

}

// #### Zadanie 4
// 1. Utwórz kontroler `CookieController`.
// 2. Utwórz akcję dostępną pod adresem `/setcookie/<value1>/<value>`.
// 3. Akcja ma pobrać wartości parametrów `value1` oraz `value2`, a następnie
// ustawić
// dwa ciasteczka o nazwach `cookie1` i wartości `value1` oraz `cookie2` i
// wartości `value2`.
// 4. Utwórz akcję dostępną pod adresem `/getcookies`, która pobierze wartości
// ciasteczek.
// 5. Wykorzystaj 2 sposoby opisane w prezentacji - klasę `WebUtils` oraz
// adnotację `@CookieValue`.
// 6. Wyświetl pobrane dane.
