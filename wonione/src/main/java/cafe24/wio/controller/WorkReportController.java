package cafe24.wio.controller;

import java.util.List;
import java.util.Map;

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
	public String getReportList(Report report, Model model) {
		
		logger.info("===============================");
		logger.info("@GetMapping getReportList");
		logger.info("===============================");
		
		List<Report> reportList = reportService.getReportList(report);
		System.out.println(reportList + "reportList");
		
		model.addAttribute("reportList", reportList);
		model.addAttribute("titleList", "보고서리스트");
		
		return "humanresource/workreport";
		
	}
	
	//보고서 상세보기
	@GetMapping("/workreportpage")
	public String getReportDetailList(Model model,
										@RequestParam(value="lecOpenCode", required = false) String lecOpenCode) {
		logger.info("===============================");
		logger.info("@GetMapping workreportpage");
		logger.info("===============================");
		Report report = reportService.getReportDetailList(lecOpenCode);
		logger.info("Report" + report);
		model.addAttribute("Report", report);
		model.addAttribute("reportSangse", "보고서 상세보기");
		
		return "humanresource/workreportpage";
		
	}
	
	//보고서작성
	   @PostMapping("/workreportwrite")
	   public String getReportWrite(Report report
	                        ,Model model
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
		logger.info("lecOpenCode");
		logger.info("lecOpenCode->" + lecOpenCode);
		logger.info("lecOpenScheCode->" + lecOpenScheCode);
		logger.info("lecName->" + lecName);
		logger.info("lecTarget->" + lecTarget);
		logger.info("lecPlan->" + lecPlan);
		logger.info("lecEtc->" + lecEtc);
		logger.info("openLecRegDate->" + openLecRegDate);
	      reportService.getReportWrite(report);
	      model.addAttribute("Report", report);
	      model.addAttribute("Reportcomplete", "/workreport");
	      return "redirect:/getReportList";
	   }
	   
	   //보고서작성
	   @GetMapping("/workreportwrite")
	   public String getReportwrite(Model model) {
		  List<Map<String, Object>> clCode = reportService.classCode();
		  List<Map<String, Object>> wName = reportService.writeName();
	      String codeResult =  reportService.getReCode();
	      logger.info("===============================");
	      logger.info("@GetMapping workreportwrite");
	      logger.info("===============================");
	      logger.info(codeResult + " < -- codeResult");
	      model.addAttribute("codeResult", codeResult);
	      model.addAttribute("classCode", clCode);
	      model.addAttribute("writeName", wName);
	      return "humanresource/workreportwrite";
	   }
	   
	   //보고서 삭제
	   @GetMapping("/deleteCode")
	   public String deleteCode(Model model  
			   					,@RequestParam(value="lecOpenCode", required = false) String lecOpenCode) {
		  reportService.deleteCode(lecOpenCode);
		  logger.info("===============================");
	      logger.info("@GetMapping deleteCode");
	      logger.info("===============================");
		  logger.info(lecOpenCode + "lecOpenCode");
		   return "redirect:/getReportList";
	   }
	   
	   //보고서수정
	   @PostMapping("/updateCode")
	   public String updateCode(Report report, Model model
				               ) {
		  logger.info("===============================");
		  logger.info("@PostMapping updateCode");
		  logger.info("===============================");
		  logger.info("보고서수정" + report);
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
		  logger.info("===============================");
		  logger.info("@GetMapping updateCode");
		  logger.info("===============================");
		  logger.info(lecOpenCode + " < -- lecOpenCode");
		  logger.info(report+"<--report");
		   model.addAttribute("Report", report);
		   return "humanresource/updateworkreport";
	   }
	   
	   //검색조건
		@GetMapping(value="/workreport", produces="application/json")
		@ResponseBody
		public List<Report> memberList(Model model
								,@RequestParam(value="lecSk", required = false) String lecSk
								,@RequestParam(value="lecSv", required = false) String lecSv) {
			List<Report> reportList = reportService.getSearchList(lecSk, lecSv);
			logger.info("===============================");
			logger.info("@GetMapping workreport");
			logger.info("===============================");
			logger.info(reportList +"reportList");
			model.addAttribute("reportList", reportList);
			return reportList;
}
		//조건검색
		@PostMapping("/searchList")
		public String searchList(Model model
										,@RequestParam(value="lecSk", required = false) String lecSk
										,@RequestParam(value="lecSv", required = false) String lecSv) {
			logger.info("===============================");
			logger.info("@PostMapping searchList");
			logger.info("===============================");
			List<Report> reportList = reportService.getSearchList(lecSk, lecSv);
			logger.info(reportList +"reportList");
			model.addAttribute("reportList", reportList);
			return "humanresource/workreport";
		}
		
	
}