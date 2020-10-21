package cafe24.wio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class refundController {
	@GetMapping("/refundApplication")
	public String refundApplication() {
		return "refund/refundApplication";
	}
}
