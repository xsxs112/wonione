package cafe24.wio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OfficersPay {

	//직원급여 초기페이지
	@GetMapping("/officersPayIndex")
	public String officersPay() {
		return "humanresource/officersPay";
	}
}
