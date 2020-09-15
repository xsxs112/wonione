package cafe24.wio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cafe24.wio.bean.Report;
import cafe24.wio.service.ReportService;

@Controller
public class WorkReportController {
	@Autowired
	private ReportService reportService;
	
	//리포트목록조회
	@RequestMapping(value="/getReportList", method= RequestMethod.GET)
	public String getReportList(Report report, Model model) {
		
		List<Report> reportList = reportService.getReportList(report);
		System.out.println(reportList + "reportList");
		
		model.addAttribute("reportList", reportList);
		model.addAttribute("title", "리포트목록조회");
		
		return "humanresource/workreport";
		
	}
	
							
	
	
}
