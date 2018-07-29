package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ParamNameController {

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String createForm() {
		return "views/ParamNameForm.jsp";
	}

	@PostMapping("/form")
	@ResponseBody
	public String printParam(@RequestParam("userInput") String userInput) {
		return "Wpisany parametr to: "+ userInput;
	}

}
// #### Zadanie 4
//
// Stwórz dwie akcje:
// 1. Pierwsza akcja ma być przypisana do adresu `/form` i metody `GET`.
// 2. Utwórz formularz w pliku `jsp` z polem tekstowym o nazwie `paramName`.
// Pierwsza akcja ma wyświetlać ten formularz.
// 2. Druga akcja ma być przypisana do adresu `/form` i metody `POST`.
// 3. Określając adresy wykorzystaj adnotacje `@GetMapping` oraz `@PostMapping`.
// 4. W metodzie obsługiwanej metodą POST odbierz, a następnie wyświetl
// parametr.