package cafe24.wio.service;

import java.util.List;
import java.util.Map;

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
	
	//보고서작성
	   public int getReportWrite(Report report) {
	      int wrtite = reportMapper.getReportWrite(report);
	      return wrtite;
	   }
	
	
	//코드로 조회
		public Report getReportDetailList(String lecOpenCode) {
			Report report = reportMapper.getReportDetailList(lecOpenCode);
			return report;
		}

	//강의예정코드조회	
	public List<Map<String, Object>> classCode() {
		List<Map<String, Object>> clCode = reportMapper.classCode();
		System.out.println(clCode);
		return clCode;
	}	
	
	public List<Map<String, Object>> writeName(){
		List<Map<String, Object>> wName = reportMapper.writeName();
		System.out.println(wName);
		return wName;
		
	}
	
}
