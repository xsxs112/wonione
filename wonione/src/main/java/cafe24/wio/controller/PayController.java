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
import cafe24.wio.bean.StaffPay;
import cafe24.wio.service.PayService;

@Controller
public class PayController {

	@Autowired
	private PayService payService;

	// log4j로 로그 찍기 위한 객체 삽입
	// 콘솔로그 말고 이젠 이거 씁니다!!!!
	private final static Logger logger = LoggerFactory.getLogger(PayController.class);

	// 강사급여 삭제하기
	@PostMapping(value = "/removeStaffPayDocu", produces = "application/json")
	@ResponseBody
	public int removeStaffPayDocu(StaffPay staffPay
								,@RequestParam(value = "spCode", required = false) String spCode) {
		int deleteResult = 0;
		if (staffPay.getSpCode() != null && !"".equals(staffPay.getSpCode())) {
			deleteResult = payService.removeStaffPayDocu(staffPay.getSpCode());			
		}
		
		return deleteResult;
	}
	
	// 직원급여 삭제하기
	@PostMapping(value = "/removeOffiPayDocu", produces = "application/json")
	@ResponseBody
	public int removeOffiPayDocu(OfficersPay officersPay
								,@RequestParam(value = "opCode", required = false) String opCode) {
		int deleteResult = 0;
		if (officersPay.getOpCode() != null && !"".equals(officersPay.getOpCode())) {
			deleteResult = payService.removeOffiPayDocu(officersPay.getOpCode());
		}

		return deleteResult;
	}


	// 아이디로 급여 리스트 가져오기
	@RequestMapping(value = "/getIdPayList", method = RequestMethod.GET)
	public String getIdPayList(@RequestParam(value = "mrId", required = false) String mrId, Model model) {
		// 직원급여목록조회
		List<OfficersPay> officersPayList = payService.getOffiIdPayList(mrId);

		model.addAttribute("officersPayList", officersPayList);
		model.addAttribute("title", "급여목록조회");

		// 강사급여목록조회
		List<StaffPay> staffPayList = payService.getStaIdPayList(mrId);

		model.addAttribute("staffPayList", staffPayList);
		model.addAttribute("title", "급여목록조회");

		return "pay/payIdList";

	}

	@RequestMapping(value = "/getPayList", method = RequestMethod.GET)
	public String getPayList(Model model) {

		// 직원급여목록조회
		List<OfficersPay> officersPayList = payService.getOfficersPayList();
		model.addAttribute("officersPayList", officersPayList);


		// 강사급여목록조회
		List<StaffPay> staffPayList = payService.getStaffPayList();
		model.addAttribute("staffPayList", staffPayList);
		
		//자원관리 테이블 통해 기준표 출력
		List<OfficersPay> standardSheetHour = payService.standardSheet();		
		model.addAttribute("standardSheetHour",standardSheetHour);
		
		//자원관리 테이블 통해 요율표 가져오기
		List<OfficersPay> insuranceYear = payService.insuranceYear();		
		model.addAttribute("insuranceYear",insuranceYear);
		
		model.addAttribute("title", "급여목록조회");
		
		return "pay/payList";
	}
	
	// 직원 급여 검색	
	@PostMapping(value = "/getSearchOPL",produces = "application/json")
	@ResponseBody
	public List<OfficersPay> getSearchOPL(	Model model
											,@RequestParam(value = "offisk", required = false) String offisk
											,@RequestParam(value = "offisv", required = false) String offisv) {
		
		List<OfficersPay> officersSPayList = payService.getSearchOPL(offisk, offisv);
		System.out.println(" officersSPayList ->> "+officersSPayList);
		
		model.addAttribute("officersSPayList", officersSPayList);
		
		return officersSPayList;
	}
	
	//강사 급여 검색
	@PostMapping(value = "/getSearchSPL",produces = "application/json")
	@ResponseBody
	public List<StaffPay> getSearchSPL(	Model model
										,@RequestParam(value = "staffsk", required = false) String staffsk
										,@RequestParam(value = "staffsv", required = false) String staffsv) {
								
		List<StaffPay> staffSPayList = payService.getSearchSPL(staffsk, staffsv);
		System.out.println(" staffSPayList ->> "+staffSPayList);
		
		model.addAttribute("staffSPayList", staffSPayList);
		
		return staffSPayList;
	}

}
