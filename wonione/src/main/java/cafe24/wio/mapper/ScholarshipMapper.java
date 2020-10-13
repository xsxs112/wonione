package cafe24.wio.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cafe24.wio.bean.Report;
import cafe24.wio.bean.ScholarShip;

@Mapper
public interface ScholarshipMapper {

	//장학금지급내역리스
	public List<ScholarShip> getScholarList(ScholarShip scholarship);
	
	//장학금 상세보기
	public ScholarShip ScholarDetailList(String pmInfoCode);
	
	//코드자동증가
	public Map<String, Object> ScholarReCode();
	
	//장학금 지급내역 작성
	public int giveScholarShip(ScholarShip scholarship);
	
	//학생이름가져오기
	public List<Map<String, Object>> sName();
	
	//학생이름가져오기
	public List<Map<String, Object>> tName();
	
	//장학금액가져오기
	public List<Map<String, Object>> sMoney();
	
	//조건검색
	public List<ScholarShip> serchScholar(String awaBp,String awaBpSc);
	
	//삭제처리
	public int deleteScholarShip(String pmInfoCode);
	
	//페이징을 위한 카운팅
	public int countScholarShip();
	
	//학생이름별 과목가져오기
	public List<Map<String, Object>> sNameClass(String mrId);
	
	//보고서 리스트 페이징
	public List<Report> countScholarShipList(Map<String,Object> scholarMap);
}
