package cafe24.wio.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cafe24.wio.bean.Report;
import cafe24.wio.service.ReportService;

@Controller
public class WorkReportController {
	@Autowired
	private ReportService reportService;
	
	//보고서목록조회
	@RequestMapping(value="/getReportList", method= RequestMethod.GET)
	public String getReportList(Report report, Model model) {
		
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
		Report report = reportService.getReportDetailList(lecOpenCode);
		System.out.println(report + "report");
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
	                        ,@RequestParam(value="lecTuition", required = false) String lecTuition
	                        ,@RequestParam(value="mrId", required = false) String mrId
	                        ,@RequestParam(value="lecTarget", required = false) String lecTarget
	                        ,@RequestParam(value="lecPlan", required = false) String lecPlan
	                        ,@RequestParam(value="lecEtc", required = false) String lecEtc
	                        ,@RequestParam(value="openLecRegDate", required = false) String openLecRegDate
	                        ) {
	      System.out.println("lecOpenCode -> " + lecOpenCode);
	      System.out.println("lecOpenScheCode->" + lecOpenScheCode);
	      System.out.println("lecTuition->" + lecTuition);
	      System.out.println("mrId->" + mrId);
	      System.out.println("lecTarget->" + lecTarget);
	      System.out.println("lecPlan->" + lecPlan);
	      System.out.println("lecEtc->" + lecEtc);
	      System.out.println("openLecRegDate->" + openLecRegDate);
	      reportService.getReportWrite(report);
	      model.addAttribute("Report", report);
	      model.addAttribute("Reportcomplete", "/workreport");
	      return "humanresource/workreport";
	   }
	   
	   //보고서작성
	   @GetMapping("/workreportwrite")
	   public String getReportwrite(Model model) {
		  List<Map<String, Object>> clCode = reportService.classCode();
		  List<Map<String, Object>> wName = reportService.writeName();
	      model.addAttribute("classCode", clCode);
	      model.addAttribute("writeName", wName);
	      return "humanresource/workreportwrite";
	   }
	   
}
