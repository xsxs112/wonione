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

import cafe24.wio.bean.Grade;
import cafe24.wio.bean.GradeReport;
import cafe24.wio.bean.Report;
import cafe24.wio.service.GradeReportService;

@Controller
public class GradeReportController {

@Autowired
private GradeReportService gradeReportService;
	
	private static final Logger logger = LoggerFactory.getLogger(GradeReportController.class);

	//성적업무보고서 리스트 
	@RequestMapping(value="/getGradeReportList", method = RequestMethod.GET)
	public String getGradeReportList(Model model, GradeReport gradeReport) {
		List<GradeReport> reportGrade = gradeReportService.getGradeReportList(gradeReport);
		model.addAttribute("reportGrade", reportGrade);
		model.addAttribute("title", "성적업무보고서");
		return "humanresource/gradereport";
	}
	
	//성적업무 보고 상세리스트
	@GetMapping("/GradeReportDetailList")
	public String GradeReportDetailList(Model model
										,@RequestParam(value="reportLecCode",required=false)String reportLecCode) {
		logger.info("===============================");
		logger.info("@GetMapping GradeReportDetailList");
		logger.info("===============================");
		GradeReport gradeReport = gradeReportService.GradeReportDetailList(reportLecCode);		
		model.addAttribute("gradeReport", gradeReport);
		model.addAttribute("title", "성적업무보고서상세");
		return "humanresource/gradereportpage";
	}
	
	//성적업무 보고서 작성하기
	   @PostMapping("/GradeReportWrite")
	   public String GradeReportInsert(GradeReport gradeReport
	                        ,Model model, HttpSession session
	                        ,@RequestParam(value="reportLecCode", required = false)String reportLecCode
	                        ,@RequestParam(value="openLecCode", required = false) String openLecCode
	                        ,@RequestParam(value="testNumber", required = false) String testNumber
	                        ,@RequestParam(value="mrName", required = false) String mrName
	                        ,@RequestParam(value="workReport", required = false) String workReport
	                        ,@RequestParam(value="gradeAverage", required = false) String gradeAverage
	                        ,@RequestParam(value="achievementRate",required=false)String achievementRate
	                        ,@RequestParam(value="finLecRegDate", required = false) String finLecRegDate
	                        ) {
		
		  model.addAttribute("title", "성적업무 보고서 작성하기");
		  String sessionName= session.getAttribute("SNAME").toString();
		  String sessionId = session.getAttribute("SID").toString();
		  List<Map<String, Object>> testNum =  gradeReportService.testNum();
		  model.addAttribute("sessionName", sessionName);
		  model.addAttribute("sessionId", sessionId);
		  gradeReportService.GradeReportInsert(gradeReport);
	      model.addAttribute("testNum", testNum);
	      return "redirect:/getGradeReportList";
	   }
	   
	   //보고서작성
	   @GetMapping("/GradeReportWrite")
	   public String GradeReportInsert(Model model ,HttpSession session) {
		  String sessionName= session.getAttribute("SNAME").toString();
		  String sessionId = session.getAttribute("SID").toString();
	      String codeResult =  gradeReportService.gradeCode();
	      List<Map<String, Object>> testNum =  gradeReportService.testNum();
	      List<Map<String, Object>> clCode = gradeReportService.classCode();
	      List< Map<String, Object> > targetScore = gradeReportService.targetScore();
	      model.addAttribute("sessionName", sessionName);
		  model.addAttribute("sessionId", sessionId);
	      model.addAttribute("codeResult", codeResult);
	      model.addAttribute("title", "성적업무 보고서 작성하기");
	      model.addAttribute("testNum", testNum);
	      model.addAttribute("classCode", clCode);
	      model.addAttribute("targetScore", targetScore);
	      return "humanresource/gradereportwrite";
	   }
	
	
	//조건검색
	@GetMapping(value = "/gradereport", produces = "application/json")
	@ResponseBody
	public List<GradeReport> searchGradeReport(Model model,
									@RequestParam(value = "graRe", required = false) String graRe,
									@RequestParam(value = "graResult", required = false) String graResult) {
		List<GradeReport> gradeList = gradeReportService.searchGradeReport(graRe, graResult);
		logger.info("===============================");
		logger.info("@GetMapping searchGradeReport");
		logger.info("===============================");
		model.addAttribute("gradeList", gradeList);
		return gradeList;
	}
		
	//조건검색
	@PostMapping("/searchGradeReport")
	public String searchReportGrade(Model model
									,@RequestParam(value = "graRe", required = false) String graRe
									,@RequestParam(value = "graResult", required = false) String graResult) {
		logger.info("===============================");
		logger.info("@PostMapping searchReportGrade");
		logger.info("===============================");
		List<GradeReport> reportGrade = gradeReportService.searchGradeReport(graRe, graResult);
		model.addAttribute("reportGrade", reportGrade);
		  return "humanresource/gradereport";
		
	}
	
	//삭제처리
	@GetMapping("/gradeReportDelete")
	public String gradeReportDelete(@RequestParam(value = "reportLecCode", required = false) String reportLecCode) {
		gradeReportService.gradeReportDelete(reportLecCode);
		return "redirect:/getGradeReportList";
		
	}
	
	
	
}
