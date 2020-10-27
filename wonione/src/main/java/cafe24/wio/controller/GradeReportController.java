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
	
	//성적업무보고서 리스트 
	@RequestMapping(value="/getGradeReportList", method = RequestMethod.GET)
	public String getGradeReportList(Model model, GradeReport gradeReport
									,@RequestParam( value="currentPage", required = false, defaultValue = "1") int currentPage) {
		List<GradeReport> reportGrade = gradeReportService.getGradeReportList(gradeReport);
		Map<String,Object> countGradeReportList = gradeReportService.countGradeReportList(currentPage);
		model.addAttribute("reportGrade", reportGrade);
		model.addAttribute("title", "성적업무보고서");
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("countGradeReportList",countGradeReportList.get("listReportGrade"));
		model.addAttribute("lastPage", countGradeReportList.get("lastPage"));
		model.addAttribute("lastPageNum", countGradeReportList.get("lastPageNum"));
		model.addAttribute("startPageNum", countGradeReportList.get("startPageNum"));
		return "humanresource/gradereportList";
	}
	
	//성적업무 보고 상세리스트
	@GetMapping("/GradeReportDetailList")
	public String GradeReportDetailList(Model model
										,@RequestParam(value="reportLecCode",required=false)String reportLecCode) {
		GradeReport gradeReport = gradeReportService.GradeReportDetailList(reportLecCode);		
		model.addAttribute("gradeReport", gradeReport);
		model.addAttribute("title", "성적업무보고서상세보기");
		return "humanresource/gradereportDetail";
	}
	
	//성적업무 보고서 작성하기 
	   @PostMapping("/GradeReportWrite")
	   public String GradeReportInsert(GradeReport gradeReport
	                        ,Model model, HttpSession session
	                        ,@RequestParam(value="reportLecCode", required = false)String reportLecCode
	                        ,@RequestParam(value="mrName", required = false) String mrName
	                        ,@RequestParam(value="lecOpenCode", required = false) String lecOpenCode
	                        ,@RequestParam(value="testNumber", required = false) String testNumber
	                        ,@RequestParam(value="gradeAverage", required = false) int gradeAverage
	                        ,@RequestParam(value="achievementRate",required=false) int achievementRate
	                        ,@RequestParam(value="workReport", required = false) String workReport
	                        ,@RequestParam(value="claPeople", required = false) int claPeople
			   ) {
		  String sessionName = session.getAttribute("SNAME").toString();
		  String sessionId = session.getAttribute("SID").toString();
		  List<Map<String, Object>> testNum =  gradeReportService.testNum();
		  model.addAttribute("sessionIdName", sessionName);
		  model.addAttribute("sessionId", sessionId);
		  gradeReportService.GradeReportInsert(gradeReport);
	      model.addAttribute("testNum", testNum);
	      return "redirect:/getGradeReportList";
	   }
	   
	   //보고서작성
	   @GetMapping("/GradeReportWrite")
	   public String GradeReportInsert(Model model ,HttpSession session 
			   						,@RequestParam(value="lecOsCode", required = false) String lecOsCode
			   						,@RequestParam(value="testRound", required = false) String testRound) {
		  String sessionName= session.getAttribute("SNAME").toString();
		  String sessionId = session.getAttribute("SID").toString();
	      String codeResult =  gradeReportService.gradeCode();
	     
	      List<Map<String, Object>> testNum =  gradeReportService.testNum();
	      List<Map<String, Object>> clCode = gradeReportService.classCode(sessionId);
	      
	      model.addAttribute("sessionName", sessionName);
		  model.addAttribute("sessionId", sessionId);
	      model.addAttribute("codeResult", codeResult);
	      model.addAttribute("title", "성적업무 보고서 작성하기");
	      model.addAttribute("testNum", testNum);
	      model.addAttribute("classCode", clCode);
	      return "humanresource/addGradereport";
	   }
	
	//업무계획서코드 가져오기
	   @PostMapping("/lecOpenCodeNum")
	   @ResponseBody
	   public Map<String, Object> lecOpenCodeNum(HttpSession session, 
			   			@RequestParam(value = "lecOpenCode", required = false) String lecOsCode
			   			 ) {
		   String sessionId = session.getAttribute("SID").toString();
		   Map<String, Object> lecOpenCodeNum = gradeReportService.lecOpenCodeNum(sessionId,lecOsCode);
		   return lecOpenCodeNum;
		   
	   }
	   
	   
	//평균점수 구하기
	   @PostMapping("/gradeAvg")
	   @ResponseBody
	   public Map<String, Object> gradeAvg(
								    	@RequestParam(value = "lecCode", required = false) String lecCode,
								    	@RequestParam(value = "testRou", required = false) String testNum ) {
		 Map<String, Object> gradeAvg = gradeReportService.gradeAvg(lecCode, testNum);
		 return gradeAvg; 
	   }
	 
	 //과목에 따른 학생 수
	   
	   @PostMapping("/claPeople")
	   @ResponseBody
	   public Map<String, Object> claPeople(
			   								@RequestParam(value = "lecOsCode", required = false) String lecOsCode){
		   Map<String, Object> claPeople = gradeReportService.studentCount(lecOsCode);
		return claPeople;
	   }
	   
	 //과목에 따른 목표점 넘은 학생 수 
	   @PostMapping("/studentTargetCount")
	   @ResponseBody
	   public Map<String, Object> studentTargetCount(
											   @RequestParam(value = "lecOsCode", required = false) String lecOsCode
											   ,@RequestParam(value = "testRound", required = false) String testRound){
		   Map<String, Object> studentTargetCount = gradeReportService.studentTargetCount(lecOsCode, testRound);
		   return studentTargetCount;
	   }
	   
	//조건검색
	@GetMapping(value = "/gradereport", produces = "application/json")
	@ResponseBody
	public List<GradeReport> searchGradeReport(Model model,
									@RequestParam(value = "graRe", required = false) String graRe,
									@RequestParam(value = "graResult", required = false) String graResult) {
		List<GradeReport> countGradeReportList = gradeReportService.searchGradeReport(graRe, graResult);
		model.addAttribute("countGradeReportList", countGradeReportList);
		return countGradeReportList;
	}
		
	//조건검색
	@PostMapping("/searchGradeReport")
	public String searchReportGrade(Model model
									,@RequestParam(value = "graRe", required = false) String graRe
									,@RequestParam(value = "graResult", required = false) String graResult) {
		List<GradeReport> countGradeReportList = gradeReportService.searchGradeReport(graRe, graResult);
		model.addAttribute("countGradeReportList", countGradeReportList);
		  return "humanresource/gradereportList";
		
	}
	
	//삭제처리
	@GetMapping("/gradeReportDelete")
	public String gradeReportDelete(@RequestParam(value = "reportLecCode", required = false) String reportLecCode) {
		gradeReportService.gradeReportDelete(reportLecCode);
		return "redirect:/getGradeReportList";
		
	}
	
}
