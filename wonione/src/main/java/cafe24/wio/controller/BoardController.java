package cafe24.wio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
	
	//공지사항
	@GetMapping("/getNotice")
	public String notice() {		
		return "board/notice";
	}
	
}
