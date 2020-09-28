package cafe24.wio.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cafe24.wio.bean.StaffPay;
import cafe24.wio.service.StaffPayService;

@Controller
public class StaffPayController {

	@Autowired
	private StaffPayService staffPayService;

	// log4j로 로그 찍기 위한 객체 삽입
	// 콘솔로그 말고 이젠 이거 씁니다!!!!
	private final static Logger logger = LoggerFactory.getLogger(StaffPayController.class);
	
	//요율표 비교 원천징수액 계산
	@PostMapping(value = "/StaffPayDedu",produces = "application/json")
	@ResponseBody
	public StaffPay StaffPayDedu(String spdCode, String iyCode, String spdTheBusinessTax) {
		StaffPay staffPayDedu = staffPayService.StaffPayDedu(spdCode, iyCode, spdTheBusinessTax);
		
		if(iyCode != null) {
			staffPayDedu.setIyCode(Integer.parseInt(iyCode));
			staffPayDedu.setSpdTheBusinessTax(Integer.parseInt(spdTheBusinessTax));
		}
		return staffPayDedu;
	}	
		
	//강사 급여계 입력하기
	@PostMapping(value = "/addStaffCalPay",produces = "application/json")
	@ResponseBody
	public StaffPay addStaffCalPay(StaffPay staffpay) {
		
		staffPayService.addStaffCalPay(staffpay);		
		
		return staffpay;
	}
	
	//강사 정보 불러오기
	@PostMapping(value = "/callStaffInfo",produces = "application/json")
	@ResponseBody
	public StaffPay callStaffInfo(String mrId
								,@RequestParam(value = "pRTitle", required = false) String pRTitle
								,@RequestParam(value = "spcIncentivePer", required = false) String spcIncentivePer
								,@RequestParam(value = "spcHourlyWage", required = false) String spcHourlyWage) {
		StaffPay staffInfo = staffPayService.callStaffInfo(mrId);

		//강사정보 급여계 넘기기
		if(pRTitle != null && spcHourlyWage != null && spcIncentivePer !=null) {
			staffInfo.setpRTitle(Float.parseFloat(pRTitle));
			staffInfo.setSpcIncentivePer(Float.parseFloat(spcIncentivePer));
			staffInfo.setSpcHourlyWage(Integer.parseInt(spcHourlyWage));			
		}
		
		
		return staffInfo;
	}
		
	@RequestMapping(value = "/staffPayIndex", method = RequestMethod.GET)
	public String getStaffList(Model model) {
		//강사리스트조회
		List<StaffPay> staffList = staffPayService.getStaffList();
		model.addAttribute("staffList", staffList);
		model.addAttribute("title", "강사목록조회");
		
		//자원관리 테이블 통해 기준표 출력
		List<StaffPay> standardSheetHour = staffPayService.standardSheet();		
		model.addAttribute("standardSheetHour",standardSheetHour);
		model.addAttribute("title", "시급기준표");
		
		//자원관리 테이블 통해 요율표 가져오기
		List<StaffPay> insuranceYear = staffPayService.insuranceYear();		
		model.addAttribute("insuranceYear",insuranceYear);
		model.addAttribute("title", "보험요율표");
		
		return "pay/staffPay";		
	}

	
	// 강사급여명세서조회
	@RequestMapping(value = "/getStaffPay", method = RequestMethod.GET)
	public String getStaffPay(Model model
								,@RequestParam(value = "mrId", required = false) String mrId) {
		System.out.println(mrId +" <-mrId");
		List<StaffPay> staffPay = staffPayService.getStaffPay(mrId);

		model.addAttribute("staffPay", staffPay);
		model.addAttribute("title", "강사급여목록조회");
		return "pay/staffPayDocumet";

	}

}
