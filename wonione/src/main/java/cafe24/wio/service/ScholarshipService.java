package cafe24.wio.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafe24.wio.bean.ScholarShip;
import cafe24.wio.mapper.ScholarshipMapper;

@Service
public class ScholarshipService {

	@Autowired
	private ScholarshipMapper scholarshipMapper;
	
	//장학금 지급내역 리스트
	public List<ScholarShip> getScholarList(ScholarShip scholarship){
		List<ScholarShip> scholarshipList = scholarshipMapper.getScholarList(scholarship);
		return scholarshipList;
	}
	
	//장학금 지급내역 상세보기
	public ScholarShip ScholarDetailList(String pmInfoCode) {
		ScholarShip scholarshipDetail = scholarshipMapper.ScholarDetailList(pmInfoCode);
		return scholarshipDetail;
	}
	
	
	//코드 자동증가
	 public String ScholarReCode() {
		 
	      Map<String, Object> reCodeMax =  scholarshipMapper.ScholarReCode();
	      
	      System.out.println("reCodeMax ------------> " + reCodeMax);
	      String tempCode = "janghak_0";
	      
	      int getMax = Integer.parseInt(reCodeMax.get("max").toString());

	      if(getMax<10) {
	         tempCode = "janghak_00";
	      }
	      String reCode = tempCode + String.valueOf(reCodeMax.get("max"));
	      
	      System.out.println("reCode ------------> " + reCode);
	      
	      return reCode;
	   }
	
	 //장학금지급 작성하기
	 public int giveScholarShip(ScholarShip scholarship) {
		 int giveScholar = scholarshipMapper.giveScholarShip(scholarship);
		 return giveScholar;
		 
	 }
	
	 //학생이름가져오기
		public List<Map<String,Object>> sName(){
			List<Map<String,Object>> mapList = scholarshipMapper.sName(); 
			return mapList;
		  }
	//지급자 이름 가져오기
		public List<Map<String,Object>>tName(){
			List<Map<String,Object>> mapList = scholarshipMapper.tName(); 
			return mapList;
		  }
		
	//장학금액 가져오기
		public List<Map<String,Object>> sMoney(){
			List<Map<String,Object>> moneyList = scholarshipMapper.sMoney();
			return moneyList;
		}
	//조건검색
		public List<ScholarShip> serchScholar(String awaBp,String awaBpSc){
			List<ScholarShip> scholarSearch = scholarshipMapper.serchScholar(awaBp, awaBpSc);
			return scholarSearch;
		}
		
	//삭제처리
		public int deleteScholarShip(String pmInfoCode) {
			int deleteResult = scholarshipMapper.deleteScholarShip(pmInfoCode);
			return deleteResult;
		}
}
