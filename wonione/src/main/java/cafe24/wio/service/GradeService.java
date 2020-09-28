package cafe24.wio.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafe24.wio.bean.Grade;
import cafe24.wio.bean.Report;
import cafe24.wio.mapper.GradeMapper;

@Service
public class GradeService {
	@Autowired
	private GradeMapper gradeMapper;

	// 성적리스트
	public List<Grade> getGradeList(Grade grade) {

		List<Grade> gradeList = gradeMapper.getGradeList(grade);
		System.out.println("getGradeList-->" + gradeList);
		return gradeList;

	}

	//코드로 조회하기
	public Grade getGradeCode(String gradeManCode) {
		Grade gradeCode = gradeMapper.getGradeDetailList(gradeManCode);
		return gradeCode;
	}
	
	// 성적상세보기리스트
	public Grade getGradeDetailList(String gradeManCode) {

		Grade gradeList = gradeMapper.getGradeDetailList(gradeManCode);
		System.out.println("getGradeDetailList-->" + gradeList);
		return gradeList;
	}

	// 조건검색
	public List<Grade> searchGrade(String lecGd, String lecGds) {
		List<Grade> grade = gradeMapper.searchGrade(lecGd, lecGds);
		return grade;
	}

	// 성적입력
	public int insertGrade(Grade grade) {
		int inputGrade = gradeMapper.insertGrade(grade);
		return inputGrade;
	}

	
	 //학생이름가져오기
	public List<Map<String,Object>> sName(){
		List<Map<String,Object>> mapList = gradeMapper.sName(); 
		return mapList;
	  
	  }
	  
	 //회차가져오기
	public List<Map<String,Object>> testNum(){
		List<Map<String,Object>> testList = gradeMapper.testNum(); 
		return testList; 
	}
	
	//자동증가코드가져오기
	 public String gradeCode() {
		 
	      Map<String, Object> reCodeMax =  gradeMapper.gradeCode();
	      
	      System.out.println("reCodeMax ------------> " + reCodeMax);
	      String tempCode = "grade";
	      
	      int getMax = Integer.parseInt(reCodeMax.get("max").toString());

	      if(getMax<10) {
	         tempCode = "grade0";
	      }
	      String reCode = tempCode + String.valueOf(reCodeMax.get("max"));
	      
	      System.out.println("reCode ------------> " + reCode);
	      
	      return reCode;
	   }
	 
	 //성적수정하기
	 public int updateGrade(Grade grade) {		
		int updateGr = gradeMapper.updateGrade(grade);
		 return updateGr;
		 
	 }
	 
	 
}