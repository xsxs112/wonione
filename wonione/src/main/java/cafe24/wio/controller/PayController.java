package cafe24.wio.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cafe24.wio.bean.OfficersPay;
import cafe24.wio.bean.StaffPay;
import cafe24.wio.service.PayService;

@Controller
public class PayController {

	@Autowired
	private PayService payService;

	// log4j로 로그 찍기 위한 객체 삽입
	// 콘솔로그 말고 이젠 이거 씁니다!!!!
	private final static Logger logger = LoggerFactory.getLogger(PayController.class);
	
	//직원급여 삭제하기
	@PostMapping("/removeOffiPayDocu")
	public String removeOffiPayDocu(OfficersPay officersPay) {
		if(officersPay.getOpCode() !=null && "".equals(officersPay.getOpCode())) {
			payService.removeOffiPayDocu(officersPay.getOpCode());
		}
		return "redirect:/payList";
	}
	
	// 삭제할 직원급여 가져오기
	@GetMapping("/removeOffiPayDocu")
	public String removeOffiPayDocu(OfficersPay officersPay, Model model) {
		if(officersPay.getOpCode() != null && !"".equals(officersPay.getOpCode())) {
			model.addAttribute("삭제화면", "급여삭제화면");
			model.addAttribute("getOpCode", officersPay.getOpCode());
		}
		return null;
	}
	
	/* //직원급여수정화면 아이디로 불러오기
	@GetMapping("/modiFyOfficersPay")
	public String modiFyOfficersPay(@RequestParam(value="mrId", required = false) String mrId 
									,Model model) {
		
		OfficersPay modiOfficersPay = payService.getMrById(mrId);
		
		System.out.println(modiOfficersPay);
		model.addAttribute("modiOfficersPay", modiOfficersPay);
		model.addAttribute("title", "직원급여수정");

		return "pay/modiFyOfficersPay";
	}*/
	
	@RequestMapping(value = "/getPayList", method = RequestMethod.GET)
	public String getPayList(Model model) {
		
		// 직원급여목록조회	
		List<OfficersPay> officersPayList = payService.getOfficersPayList();
		
		model.addAttribute("officersPayList", officersPayList);
		model.addAttribute("title", "직원급여목록조회");
		
		// 강사급여목록조회
		List<StaffPay> staffPayList = payService.getStaffPayList();
		System.out.println(staffPayList + "<- staffPayList 확인");		
		
		model.addAttribute("staffPayList", staffPayList);
		model.addAttribute("title", "강사급여목록조회");
		
		return "pay/payList";
	}
	
}
