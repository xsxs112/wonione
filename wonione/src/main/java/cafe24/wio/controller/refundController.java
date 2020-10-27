package cafe24.wio.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class refundController {
	
	@Autowired
	private cafe24.wio.service.refundService refundService;
	
	//환불신청리스트
	@GetMapping("/refundApplication")
	public String refundApplication(Model model
									,@RequestParam(value="currentPage", required = false, defaultValue = "1") int currentPage
									,HttpSession session) {
		String sessionId = (String) session.getAttribute("SID");
		System.out.println();
		Map<String, Object> refundMap = refundService.refundApplication(currentPage,sessionId);
		model.addAttribute("lastPage", refundMap.get("lastPage"));
		model.addAttribute("refundList", refundMap.get("refundList"));
		model.addAttribute("startPageNum", refundMap.get("startPageNum"));
		model.addAttribute("lastPageNum", refundMap.get("lastPageNum"));
		model.addAttribute("currentPage",currentPage);         
		return "refund/refundApplication";
	}
}
