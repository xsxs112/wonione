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

import cafe24.wio.bean.Grade;
import cafe24.wio.bean.GradeReport;
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
		logger.info("reportGrade");
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
		logger.info("gradeReport");
		return "humanresource/gradereportpage";
	}
	
	//성적업무 보고서 작성하기
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
				logger.info(gradeList +"gradeList");
				model.addAttribute("gradeList", gradeList);
				return gradeList;

			}
		
	//조건검색
	@PostMapping("/searchGradeReport")
	public String searchGradeReport(Model model, GradeReport gradeReport
									,@RequestParam(value = "graRe", required = false) String graRe
									,@RequestParam(value = "graResult", required = false) String graResult) {
		logger.info("===============================");
		logger.info("@PostMapping searchGradeReport");
		logger.info("===============================");
		List<GradeReport> gradeList = gradeReportService.searchGradeReport(graRe, graResult);
		logger.info(gradeList +"gradeList");
		model.addAttribute("gradeList", gradeList);
		  return "humanresource/gradereport";
		
	}
	
	
}
