package cafe24.wio.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

import cafe24.wio.service.ReportService;
import cafe24.wio.service.ScholarshipService;
import cafe24.wio.bean.ScholarShip;

@Controller
public class ScholarshipController {

	@Autowired
	private ScholarshipService scholarshipService;
	
	private static final Logger logger = LoggerFactory.getLogger(ScholarshipController.class);

	
	//장학금지급내역 리스트
	@RequestMapping(value="/getScholarList", method= RequestMethod.GET)
	public String getScholarList(Model model, ScholarShip  scholarship ,HttpSession session
								,@RequestParam(value = "mrName", required = false) String mrId
								,@RequestParam(value = "lecOsCode", required = false) String lecOsCode
								,@RequestParam( value="currentPage", required = false, defaultValue = "1") int currentPage) {
		
		Map<String,Object> countScholarShipList =scholarshipService.countScholarShipList(currentPage);
		Map<String,Object> scholarshipCount = scholarshipService.scholarshipCount(lecOsCode);
		String scholarCode = scholarshipService.ScholarReCode();
		String sessionName= session.getAttribute("SNAME").toString();
		String sessionId = session.getAttribute("SID").toString();
		List<Map<String, Object>>  classcode = scholarshipService.classCode();
		
		model.addAttribute("classCode", classcode);
		model.addAttribute("scholarshipCount", scholarshipCount);
		model.addAttribute("sessionName", sessionName);
		model.addAttribute("sessionId", sessionId);
		model.addAttribute("scholarCode", scholarCode);
		model.addAttribute("countScholarShipList", countScholarShipList.get("scholarshipList"));
		model.addAttribute("lastPage", countScholarShipList.get("lastPage"));
		model.addAttribute("startPageNum", countScholarShipList.get("startPageNum"));
		model.addAttribute("lastPageNum", countScholarShipList.get("lastPageNum"));	
		model.addAttribute("currentPage", currentPage);
		List<Map<String,Object>> sName = scholarshipService.sName();
		List<Map<String,Object>> sMoney = scholarshipService.sMoney();
		model.addAttribute("title", "장학금 지급리스트");
		model.addAttribute("sName", sName);
		model.addAttribute("sMoney", sMoney);
		return "grade/scholarshipList";
		
	}
	
	//ajax호출
	@PostMapping(value="/sNameClass", produces = "application/json")
	@ResponseBody
	public List<Map<String, Object>> sNameClass(Model model
										,@RequestParam(value = "mrName", required = false) String mrId){
		List<Map<String, Object>> sNameClass = scholarshipService.sNameClass(mrId);
		
		return sNameClass;
		
	}
	
	//장학금 지급 상세리스트
	@GetMapping("/ScholarDetailList")
	public String getScholarList(Model model,
									@RequestParam(value="pmInfoCode" ,required = false) String pmInfoCode) {
		ScholarShip scholarshipDetail = scholarshipService.ScholarDetailList(pmInfoCode);
		model.addAttribute("scholarshipDetail", scholarshipDetail);
		model.addAttribute("title", "장학금 지급상세보기");
		return "grade/scholarshipDetail";
	}
	
	//장학금 지급 작성하기
	@PostMapping(value="/getScholarList")
	public String giveScholarShip(Model model, ScholarShip  scholarship
									,@RequestParam(value="pmInfoCode", required=false) String pmInfoCode
									,@RequestParam(value="awardBmPrice", required=false) String awardBmPrice
									,@RequestParam(value="mrName", required=false) String mrName
									,@RequestParam(value="pmInfoPayer", required=false) String pmInfoPayer){
		
		int result = scholarshipService.giveScholarShip(scholarship);
		String scholarCode = scholarshipService.ScholarReCode();
		model.addAttribute("ScholarShip", scholarship);
		model.addAttribute("scholarCode", scholarCode);
		model.addAttribute("result", result);
		return "redirect:/getScholarList";
	}
	//조건검색
	@PostMapping("/serchScholar")
	public String serchScholar(Model model,
								@RequestParam(value = "awaBp", required = false) String awaBp,
								@RequestParam(value = "awaBpSc", required = false) String awaBpSc) {
		if(awaBp.equals("mr_name")) awaBp = "r1." + awaBp;
		List<ScholarShip> countScholarShipList = scholarshipService.serchScholar(awaBp, awaBpSc);
		List<Map<String,Object>> sName = scholarshipService.sName();
		List<Map<String,Object>> sMoney = scholarshipService.sMoney();
		String scholarCode = scholarshipService.ScholarReCode();
		model.addAttribute("sName", sName);
		model.addAttribute("sMoney", sMoney);
		model.addAttribute("scholarCode", scholarCode);
		model.addAttribute("countScholarShipList", countScholarShipList);
		return "grade/scholarshipList";
	}
	
	//조건검색
	@GetMapping(value = "/scholarship", produces = "application/json")
	@ResponseBody
	public List<ScholarShip> serchScholarList(Model model
											,@RequestParam(value = "awaBp", required = false) String awaBp,
											 @RequestParam(value = "awaBpSc", required = false) String awaBpSc) {
		List<ScholarShip>  countScholarShipList = scholarshipService.serchScholar(awaBp, awaBpSc);
		model.addAttribute("countScholarShipList", countScholarShipList);
		return countScholarShipList;
	}
	
	//삭제처리
	@GetMapping("deleteScholarShip")
	public String deleteScholarShip(
									@RequestParam(value = "pmInfoCode", required = false) String pmInfoCode) {
		scholarshipService.deleteScholarShip(pmInfoCode);
		return "redirect:/getScholarList";
		
	}
	
}
