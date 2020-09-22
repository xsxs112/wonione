package cafe24.wio.service;

import java.util.HashMap;
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
	
	//자동증가
	 public String getReCode() {
		 
	      Map<String, Object> reCodeMax =  reportMapper.getReCode();
	      
	      System.out.println("reCodeMax ------------> " + reCodeMax);
	      String tempCode = "work_num000";
	      
	      int getMax = Integer.parseInt(reCodeMax.get("max").toString());

	      if(getMax<10) {
	         tempCode = "work_num0000";
	      }
	      String reCode = tempCode + String.valueOf(reCodeMax.get("max"));
	      
	      
	      System.out.println("reCode ------------> " + reCode);
	      
	      return reCode;
	   }
	
	//보고서작성
	   public int getReportWrite(Report report) {
	      int write = reportMapper.getReportWrite(report);
	      return write;
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
	//강의자 조회
	public List<Map<String, Object>> writeName(){
		List<Map<String, Object>> wName = reportMapper.writeName();
		System.out.println(wName);
		return wName;
		
	}
	
	//보고서 삭제
	public int deleteCode(String lecOpenCode){
		int deleteCd = reportMapper.deleteCode(lecOpenCode);
		return deleteCd;
	}
	
	//보고서 수정
	public int updateCode(Report report) {
		int updateUc = reportMapper.updateCode(report);
		return updateUc;
		
	}
	
	//검색조건
	public List<Report> getSearchList(String lecSk, String lecSv){
		List<Report> reportList = reportMapper.getSearchList(lecSk, lecSv);
		return reportList;
		
	}	
	
}
