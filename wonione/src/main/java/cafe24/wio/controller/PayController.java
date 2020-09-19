package cafe24.wio.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
