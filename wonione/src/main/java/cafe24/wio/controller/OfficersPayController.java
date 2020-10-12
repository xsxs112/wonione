package cafe24.wio.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
	
	//직원 급여 수정
	@PostMapping("/modiOffiPay")
	public String modiOffiPay(OfficersPay officersPay, HttpSession session) {
		
		String writer = (String) session.getAttribute("SID");
		officersPay.setWriter(writer);
		officersPayService.modiOffiPay(officersPay);
		String oid = officersPay.getMrId();
		return "redirect:/getIdPayList?mrId="+oid;
	}	
	
	//직원 공제계 수정하기
	@PostMapping(value = "/modifyOffiDedu",produces = "application/json")
	@ResponseBody
	public OfficersPay modifyOffiDedu(OfficersPay officersPay, HttpSession session) { 
		
		String writer = (String) session.getAttribute("SID");
		officersPay.setWriter(writer);
		
		officersPayService.modifyOffiDedu(officersPay);	
		
		return officersPay;		
	}
	
	//직원 급여계 수정하기
	@PostMapping(value = "/modifyOffiCal",produces = "application/json")
	@ResponseBody
	public OfficersPay modifyOffiCal(OfficersPay officersPay, HttpSession session) { 
		
		String writer = (String) session.getAttribute("SID");
		officersPay.setWriter(writer);
		
		officersPayService.modifyOffiCal(officersPay);	
		
		return officersPay;		
	}	
	
	// 직원급여수정화면 불러오기
	@GetMapping("/modiFyOfficersPay")
	public String modiFyOfficersPay(@RequestParam(value = "opCode", required = false) String opCode
									,Model model) {
		OfficersPay modiOfficersPay = officersPayService.getMrByOId(opCode);

		model.addAttribute("modiOfficersPay", modiOfficersPay);
		model.addAttribute("title", "직원급여수정");
		
		//자원관리 테이블 통해 기준표 출력
		List<OfficersPay> standardSheetHour = officersPayService.standardSheet();		
		model.addAttribute("standardSheetHour",standardSheetHour);
		model.addAttribute("title", "시급기준표");
		
		//자원관리 테이블 통해 요율표 가져오기
		List<OfficersPay> insuranceYear = officersPayService.insuranceYear();		
		model.addAttribute("insuranceYear",insuranceYear);
		model.addAttribute("title", "보험요율표");

		return "pay/modiFyOfficersPay";
	}	
		
	//직원급여 입력하기
	@PostMapping("/addOfficersPay")
	public String addOfficersPay(OfficersPay officersPay, HttpSession session) {
		
		String writer = (String) session.getAttribute("SID");
		officersPay.setWriter(writer);
		officersPayService.addOfficersPay(officersPay);
		
		return "redirect:/getPayList";
	}
	//직원 공제계 입력하기
	@PostMapping(value = "/addOffiDedupay",produces = "application/json")
	@ResponseBody
	public OfficersPay addOffiDedupay(OfficersPay officersPay, HttpSession session) { 
		
		String writer = (String) session.getAttribute("SID");
		officersPay.setWriter(writer);
		
		officersPayService.addOffiDedupay(officersPay);	
		
		return officersPay;		
	}		
	
	//요율표 비교 공제액 계산하기
	@PostMapping(value = "/OfficersDedu",produces = "application/json")
	@ResponseBody
	public OfficersPay OfficersDedu(String opdCode, String iyCode, String opdIncomeTax) {
		OfficersPay officersDedu = officersPayService.OfficersDedu(opdCode, iyCode, opdIncomeTax);
		
		if(iyCode != null && opdIncomeTax != null) {
			officersDedu.setIyCode(Integer.parseInt(iyCode));			
			officersDedu.setOpdIncomeTax(Integer.parseInt(opdIncomeTax));
		}		
		
		return officersDedu;
	}
	
	//직원급여계 입력하기
	@PostMapping(value = "/addOffiCalpay",produces = "application/json")
	@ResponseBody
	public OfficersPay addOffiCalpay(OfficersPay officersPay, HttpSession session) { 
		
		String writer = (String) session.getAttribute("SID");
		officersPay.setWriter(writer);
		
		officersPayService.addOffiCalpay(officersPay);	
		
		return officersPay;		
	}		
	
	//직원 정보 불러오기
	@PostMapping(value = "/callOfficersInfo",produces = "application/json")
	@ResponseBody
	public OfficersPay callOfficersInfo(String mrId
			,@RequestParam(value = "pRTitle", required = false) String pRTitle
			,@RequestParam(value = "opcHourlyWage", required = false) String opcHourlyWage			
			) {
		OfficersPay OfficersInfo = officersPayService.callOfficersInfo(mrId);
		
		//직원정보 급여계 넘기기
		
		if(pRTitle != null && opcHourlyWage != null) {
			OfficersInfo.setpRTitle(Float.parseFloat(pRTitle));
			OfficersInfo.setOpcHourlyWage(Integer.parseInt(opcHourlyWage));			
		}		
		
		return OfficersInfo;
	}
	
	@RequestMapping(value = "/officersPayIndex", method = RequestMethod.GET)
	public String getOfficersList(Model model
								,HttpSession session) {
		//직원리스트조회
		List<OfficersPay> OfficersList = officersPayService.getOfficersList();
		model.addAttribute("OfficersList", OfficersList);
		model.addAttribute("title", "직원목록조회");
		
		//자원관리 테이블 통해 기준표 출력
		List<OfficersPay> standardSheetHour = officersPayService.standardSheet();		
		model.addAttribute("standardSheetHour",standardSheetHour);
		model.addAttribute("title", "시급기준표");
		
		//자원관리 테이블 통해 요율표 가져오기
		List<OfficersPay> insuranceYear = officersPayService.insuranceYear();		
		model.addAttribute("insuranceYear",insuranceYear);
		model.addAttribute("title", "보험요율표");
		
		String writer = (String) session.getAttribute("SID");
		model.addAttribute("writer",writer);
		
		return "pay/officersPay";		
	}	
	
	// 직원급여명세서조회
	@RequestMapping(value = "/getOfficersPay", method = RequestMethod.GET)
	public String getOfficersPay(Model model
								,@RequestParam(value = "mrId", required = false) String mrId
								,@RequestParam(value = "opCode", required = false) String opCode) {
		List<OfficersPay> officersPay = officersPayService.getOfficersPay(mrId, opCode);

		model.addAttribute("officersPay", officersPay);
		model.addAttribute("title", "직원급여목록조회");
		return "pay/officersPayDocumet";

	}
}
