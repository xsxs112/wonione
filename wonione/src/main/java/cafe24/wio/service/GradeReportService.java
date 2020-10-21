package cafe24.wio.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafe24.wio.bean.Grade;
import cafe24.wio.bean.GradeReport;
import cafe24.wio.bean.Report;
import cafe24.wio.mapper.GradeMapper;
import cafe24.wio.mapper.GradeReportMapper;

@Service
public class GradeReportService {
	@Autowired
	private GradeReportMapper gradeReportMapper;

	
	private static final Logger logger = LoggerFactory.getLogger(GradeReportService.class);

	// 성적보고서 리스트
	public List<GradeReport> getGradeReportList(GradeReport gradeReport) {

		List<GradeReport> reportGrade = gradeReportMapper.getGradeReportList(gradeReport);
		logger.info("getGradeReportList-->" + reportGrade);
		return reportGrade;

	}

	//성적보고서 리스트 상세보기
	public GradeReport GradeReportDetailList(String reportLecCode){
		GradeReport reportGrade = gradeReportMapper.GradeReportDetailList(reportLecCode);
		logger.info("GradeReportDetailList-->" + reportGrade);
		return reportGrade;
	}
	
	//성적보고서 작성하기
	public int GradeReportInsert(GradeReport gradeReport) {
		int insertGradeReport = gradeReportMapper.GradeReportWrite(gradeReport);
		return insertGradeReport;
		
	}
	
	//강의예정코드조회	
	public List<Map<String, Object>> classCode(String sessionId) {
		List<Map<String, Object>> clCode = gradeReportMapper.classCode(sessionId);
		System.out.println(clCode);
		return clCode;
	}	

	
	//조건검색
	public List<GradeReport> searchGradeReport(String graRe, String graResult){
		List<GradeReport> gradeReport = gradeReportMapper.searchGradeReport(graRe, graResult);
		logger.info("gradeReport-->" + gradeReport);
		return gradeReport;
	}
	
	//수정처리
	public int gradeReportDelete(String reportLecCode) {
		int reportGrade = gradeReportMapper.gradeReportDelete(reportLecCode);
		return reportGrade;
	}
	
	 //회차가져오기
	public List<Map<String,Object>> testNum(){
		List<Map<String,Object>> testList = gradeReportMapper.testNum(); 
		return testList; 
		}
	
	
	//자동증가코드가져오기
	 public String gradeCode() {
		 
	      Map<String, Object> reCodeMax =  gradeReportMapper.gradeCode();
	      
	      System.out.println("reCodeMax ------------> " + reCodeMax);
	      String tempCode = "report_lec_";
	      
	      int getMax = Integer.parseInt(reCodeMax.get("max").toString());

	      if(getMax<10) {
	         tempCode = "report_lec_0";
	      }
	      String reCode = tempCode + String.valueOf(reCodeMax.get("max"));
	      
	      System.out.println("reCode ------------> " + reCode);
	      
	      return reCode;
	   }
	 
	//평균점수가져오기
	public  Map<String, Object> gradeAvg(String lecCode, String testNum) {
		Map<String, Object> avgGrade = gradeReportMapper.gradeAvg(lecCode, testNum);
		return avgGrade;
	}
	 
	//업무목표점수가져오기
	 public   Map<String, Object> targetScore(String sessionId, String lecOsCode) {
		 Map<String, Object> targetScore = gradeReportMapper.targetScore(sessionId, lecOsCode);
		return targetScore;
	 }
		 
	 
		//페이징
		public Map<String,Object> countGradeReportList(int currentPage){
			
			final int ROW_PER_PAGE = 5;
		      
		      int startRow = 0;
		      
		      int startPageNum = 1;
		      int lastPageNum = ROW_PER_PAGE;
		      
		      if(currentPage > (ROW_PER_PAGE/2)) {
		         startPageNum = currentPage - ((lastPageNum/2)-1);
		         lastPageNum += startPageNum;
		      }
		      
		      startRow = (currentPage - 1) * ROW_PER_PAGE ;
		      
		      Map<String,Object> gradeReportMap = new HashMap<String,Object>();
		            
		      gradeReportMap.put("startRow", startRow);
		      gradeReportMap.put("rowPerPage", ROW_PER_PAGE);

		      List<Grade> listReportGrade = gradeReportMapper.countGradeReportList(gradeReportMap) ;
		      double totalRowCount = gradeReportMapper.countGradeReport();
		      
		      int lastPage = (int)Math.ceil((totalRowCount / ROW_PER_PAGE));
			
		      if(currentPage >= (lastPage-4)) {
			         lastPageNum = lastPage;
			      }
			      
			      Map<String,Object> gradeReportList = new HashMap<String,Object>();
			      gradeReportList.put("listReportGrade", listReportGrade);
			      gradeReportList.put("lastPage", lastPage);
			      gradeReportList.put("startPageNum", startPageNum);
			      gradeReportList.put("lastPageNum", lastPageNum);
			
			return gradeReportList;
			
		}
	 
	
}
