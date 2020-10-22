package cafe24.wio.controller;

import java.util.List;
import java.util.Map;

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

import cafe24.wio.bean.Report;
import cafe24.wio.service.ReportService;

@Controller
public class WorkReportController {
	@Autowired
	private ReportService reportService;
	
	private static final Logger logger = LoggerFactory.getLogger(WorkReportController.class);

	//보고서목록조회
	@RequestMapping(value="/getReportList", method= RequestMethod.GET)
	public String getReportList(Report report, Model model,
								@RequestParam( value="currentPage", required = false, defaultValue = "1") int currentPage) {
		
		Map<String,Object> countReportList =reportService.countReportList(currentPage);
		
		logger.info("===============================");
		logger.info("@GetMapping getReportList");
		logger.info("===============================");
		
		model.addAttribute("title", "업무계획서 리스트");
		model.addAttribute("currentPage",currentPage);
		model.addAttribute("listReport", countReportList.get("listReport"));
		model.addAttribute("lastPage", countReportList.get("lastPage"));
		model.addAttribute("startPageNum", countReportList.get("startPageNum"));
		model.addAttribute("lastPageNum", countReportList.get("lastPageNum"));	
		return "humanresource/workreportList";
		
	}
	
	//보고서 상세보기
	@GetMapping("/workreportpage")
	public String getReportDetailList(Model model,
										@RequestParam(value="lecOpenCode", required = false) String lecOpenCode) {
		logger.info("===============================");
		logger.info("@GetMapping workreportpage");
		logger.info("===============================");
		Report report = reportService.getReportDetailList(lecOpenCode);
		model.addAttribute("Report", report);
		model.addAttribute("title", "업무계획서 상세보기");
		
		return "humanresource/workreportDetail";
		
	}
	
	//보고서작성
	   @PostMapping("/workreportwrite")
	   public String getReportWrite(Report report
	                        ,Model model, HttpSession session
	                        ,@RequestParam(value="lecOpenCode", required = false) String lecOpenCode
	                        ,@RequestParam(value="lecOpenScheCode", required = false) String lecOpenScheCode
	                        ,@RequestParam(value="lecName", required = false) String lecName
	                        ,@RequestParam(value="mrName", required = false) String mrName
	                        ,@RequestParam(value="lecTarget", required = false) String lecTarget
	                        ,@RequestParam(value="lecPlan", required = false) String lecPlan
	                        ,@RequestParam(value="lecEtc", required = false) String lecEtc
	                        ,@RequestParam(value="openLecRegDate", required = false) String openLecRegDate
	                        ) {
		logger.info("===============================");
		logger.info("@PostMapping workreportwrite");
		logger.info("===============================");
		  String sessionName= session.getAttribute("SNAME").toString();
		  String sessionId = session.getAttribute("SID").toString();
		  model.addAttribute("sessionName", sessionName);
		  model.addAttribute("sessionId", sessionId);
	      reportService.getReportWrite(report);
	      model.addAttribute("Report", report);
	      return "redirect:/getReportList";
	   }
	   
	   //보고서작성
	   @GetMapping("/workreportwrite")
	   public String getReportwrite(Model model ,HttpSession session) {
		  List<Map<String, Object>> clCode = reportService.classCode();
		  List<Map<String, Object>> wName = reportService.writeName();
		  String sessionName= session.getAttribute("SNAME").toString();
		  String sessionId = session.getAttribute("SID").toString();
	      String codeResult =  reportService.getReCode();
	      logger.info("===============================");
	      logger.info("@GetMapping workreportwrite");
	      logger.info("===============================");
	      model.addAttribute("sessionName", sessionName);
		  model.addAttribute("sessionId", sessionId);
	      model.addAttribute("codeResult", codeResult);
	      model.addAttribute("classCode", clCode);
	      model.addAttribute("writeName", wName);
	      model.addAttribute("title", "업무계획서 작성페이지");
	      return "humanresource/addWorkreport";
	   }
	   
	   //보고서 삭제
	   @GetMapping("/deleteCode")
	   public String deleteCode(  
			   					@RequestParam(value="lecOpenCode", required = false) String lecOpenCode) {
		  reportService.deleteCode(lecOpenCode);
		   return "redirect:/getReportList";
	   }
	   
	   //보고서수정
	   @PostMapping("/updateCode")
	   public String updateCode(Report report, Model model
				               ) {
		   reportService.updateCode(report);
		   model.addAttribute("Report", report);
		   return "redirect:/getReportList";
	   }
	   
	   //보고서 수정
	   @GetMapping("/updateCode")
	   public String updateCode(
			   					@RequestParam(value="lecOpenCode", required = false) String lecOpenCode
			   					,Model model ) {
		  Report report = reportService.getReportDetailList(lecOpenCode);
		   model.addAttribute("Report", report);
		   model.addAttribute("title", "업무계획서 수정페이지");
		   return "humanresource/modifyWorkreport";
	   }
	   
	   //조건검색
		@GetMapping(value="/workreport", produces="application/json")
		@ResponseBody
		public List<Report> memberList(Model model
								,@RequestParam(value="lecSk", required = false) String lecSk
								,@RequestParam(value="lecSv", required = false) String lecSv) {
			List<Report> listReport = reportService.getSearchList(lecSk, lecSv);
			model.addAttribute("listReport", listReport);
			return listReport;
}
		//조건검색
		@PostMapping("/searchList")
		public String searchList(Model model
										,@RequestParam(value="lecSk", required = false) String lecSk
										,@RequestParam(value="lecSv", required = false) String lecSv) {
			List<Report> listReport = reportService.getSearchList(lecSk, lecSv);
			model.addAttribute("listReport", listReport);
			return "humanresource/workreportList";
		}
		
	
}