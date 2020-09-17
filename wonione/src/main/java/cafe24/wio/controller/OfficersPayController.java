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
import org.springframework.web.bind.annotation.ResponseBody;

import cafe24.wio.bean.OfficersPay;
import cafe24.wio.service.OfficersPayService;

@Controller
public class OfficersPayController {

	@Autowired
	private OfficersPayService officersPayService;

	// log4j로 로그 찍기 위한 객체 삽입
	// 콘솔로그 말고 이젠 이거 씁니다!!!!
	private final static Logger logger = LoggerFactory.getLogger(OfficersPayController.class);

	//직원 정보 불러오기
	@PostMapping(value = "/callOfficersInfo",produces = "application/json")
	@ResponseBody
	public OfficersPay callOfficersInfo(String mrId) {
		System.out.println(mrId +" <-mrId");
		OfficersPay OfficersInfo = officersPayService.callOfficersInfo(mrId);

		return OfficersInfo;
	}
	
	//직원리스트조회
	@RequestMapping(value = "/getOfficersList", method = RequestMethod.POST)
	public String getOfficersList(Model model) {
		List<OfficersPayController> OfficersList = officersPayService.getOfficersList();
		
		model.addAttribute("OfficersList", OfficersList);
		model.addAttribute("title", "직원목록조회");
		
		return "humanresource/officersPay";		
	}
	
	
	// 직원급여명세서조회
	@RequestMapping(value = "/getOfficersPay", method = RequestMethod.GET)
	public String getOfficersPay(Model model
								,@RequestParam(value = "mrId", required = false) String mrId) {
		System.out.println(mrId +" <-mrId");
		List<OfficersPayController> officersPay = officersPayService.getOfficersPay(mrId);

		model.addAttribute("officersPay", officersPay);
		model.addAttribute("title", "직원급여목록조회");
		return "humanresource/officersPayDocumet";

	}

	// 직원급여목록조회
	@RequestMapping(value = "/getOfficersPayList", method = RequestMethod.GET)
	public String getOfficersPayList(Model model) {
		List<OfficersPayController> officersPayList = officersPayService.getOfficersPayList();

		model.addAttribute("officersPayList", officersPayList);
		model.addAttribute("title", "직원급여목록조회");
		return "humanresource/payList";

	}

	//직원급여 초기페이지	
	@GetMapping("/officersPayIndex") 
	public String officersPay(Model model
							 ,@RequestParam(value = "mrId", required = false) String mrId) { 
		
		List<OfficersPayController> officersPayList = officersPayService.getOfficersPayList();

		model.addAttribute("officersPayList", officersPayList);
		model.addAttribute("title", "직원급여목록조회");		

		
		return "humanresource/officersPay"; 	
	}

}
