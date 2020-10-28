package cafe24.wio.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cafe24.wio.bean.Grade;
import cafe24.wio.bean.GradeReport;
import cafe24.wio.bean.Report;
import cafe24.wio.bean.ScholarShip;

@Mapper
public interface GradeReportMapper {

	//보고서조회
	public List<GradeReport> getGradeReportList(GradeReport gradeReport);
	
	//보고서 상세조회
	public GradeReport GradeReportDetailList(String reportLecCode);
	
	//조건검색
	public List<GradeReport> searchGradeReport(String graRe, String graResult);
	
	//삭제처리
	public int gradeReportDelete(String reportLecCode);
	
	//회차 불러오기
	public List<Map<String, Object>> testNum();
	
	//성적보고서 작성하기
	public int GradeReportWrite(GradeReport gradeReport);
	
	//자동증가코드
	public Map<String, Object> gradeCode();
	
	//강의코드불러오기
	public Map<String, Object> classCode(String lecOpenCode);
	
	//업무목표점수가져오기
	public Map<String, Object> targetScore(String sessionId, String lecOsCode);
	
	//페이징을 위한 카운팅
	public int countGradeReport();
	
	//보고서 리스트 페이징
	public List<Grade> countGradeReportList(Map<String,Object> gradeMap);
	
	//평균구하기
	public Map<String, Object> gradeAvg(String lecCode, String testNum);
	
	//반에 따른 학생수
	public Map<String, Object> studentCount(String lecOsCode);
	
	//반에따른 목표점넘은 학생수
	public Map<String, Object> studentTargetCount(String lecOsCode , String testRound);
	
	//업무계획서 코드 조회하기
	public List<Map<String, Object>> lecOpenCodeNum(String sessionId);
	
	//선생님아이디이름가져오기
	public Map<String, Object> teacherId();
	
}
