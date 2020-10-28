package cafe24.wio.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cafe24.wio.bean.Grade;
import cafe24.wio.bean.Report;
@Mapper
public interface GradeMapper {

	//성적조회
	public List<Grade> getGradeList(Grade grade);

	//성적코드로상세조회
	public Grade getGradeDetailList(String gradeManCode);
	
	//조건검색
	public List<Grade> searchGrade(String lecGd, String lecGds);
	
	//성적작성
	public int insertGrade(Grade grade);
	
	//학생이름불러오기
	public List<Map<String, Object>> sName();
	  
	//회차 불러오기
	public List<Map<String, Object>> testNum();
	 
	//자동증가코드
	public Map<String, Object> gradeCode();
	
	//성적수정하기
	public int updateGrade(Grade grade);
	
	//성적삭제하기
	public int deleteGrade(String gradeManCode);
	
	//페이징을 위한 카운팅
	public int countGrade();
	
	//보고서 리스트 페이징
	public List<Grade> countGradeList(Map<String,Object> gradeMap);
	
	//과목 불러오기
	public List<Map<String, Object>> gradeClassId();
	
	//과목에따른 수강학생이름 불러오기
	public List<Map<String, Object>> idName(String lecOsCode);
	
	//강의코드불러오기
	public List<Map<String, Object>> classCode(String sessionId);
	
}
