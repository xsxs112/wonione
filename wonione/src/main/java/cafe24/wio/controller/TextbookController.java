package cafe24.wio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class TextbookController {

	@GetMapping("/textbooklist")
	public String textbookList(Model model) {
		
			model.addAttribute("title", "교재목록페이지");
			model.addAttribute("mainTitle", "교재목록페이지");
		
		return "textbookresource/textbooklist";
	}
	
}
