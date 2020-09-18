package cafe24.wio.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cafe24.wio.bean.Report;

@Mapper
public interface ReportMapper {

	//보고서조회
	public List<Report> getReportList(Report report);
	
	//id조회
	public Report getReportDetailList(String lecOpenCode);
	
	//보고서작성
	public int getReportWrite(Report report);
	
	//강의코드불러오기
	public List<Map<String, Object>> classCode();
	 
	//작성자이름 불러오기
	public List<Map<String, Object>> writeName();
	
	//삭제처리
	public int deleteCode(String lecOpenCode);
	
	//수정처리
	public int updateCode(Report report);
	
	//검색조건
	public List<Report> getSearchList(String lecSk, String lecSv);
	
	//자동증가
	public Map<String, Object> getReCode();

}
