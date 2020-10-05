package cafe24.wio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LectureController {

	@GetMapping("/lectureManage")
	public String lectureManage(Model model) {
		
		model.addAttribute("title", "강의관리 메인페이지");
		model.addAttribute("mainTitle", "강의관리 메인페이지");
		
		return "lecture/lectureManage";
	}
}
