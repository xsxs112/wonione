package cafe24.wio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafe24.wio.bean.Report;
import cafe24.wio.mapper.ReportMapper;
@Service
public class ReportService {

	@Autowired
	private ReportMapper reportmapper;
	
	public List<Report> getReportList(Report report){
	
		System.out.println(report +"<--report");
		List<Report> reportList = reportmapper.getReportList(report);
		return reportList;
		
	}
	
}
