package cafe24.wio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	//이것은주석
	@GetMapping("/")
	public String index() {
		return "index";
	}
}
