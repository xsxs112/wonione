package cafe24.wio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	//이것은주석
	//Pull Push Commit Test
	@GetMapping("/")
	public String main() {
		
		return "redirect:/index";
	}
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("title","메인화면");
		return "index";
	}
}
