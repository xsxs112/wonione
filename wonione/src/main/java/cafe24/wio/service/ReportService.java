package cafe24.wio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafe24.wio.bean.Report;
import cafe24.wio.mapper.ReportMapper;
@Service
public class ReportService {

	@Autowired
	private ReportMapper reportMapper;
	
	//보고서 목록
	public List<Report> getReportList(Report report){
		System.out.println(report +"<--report");
		List<Report> reportList = reportMapper.getReportList(report);
		return reportList;
		
	}
	
	
	//코드로 조회
		public Report getReportDetailList(String lecOpenCode) {
			Report report = reportMapper.getReportDetailList(lecOpenCode);
			return report;
		}

	
	
}
