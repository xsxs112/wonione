package cafe24.wio.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import cafe24.wio.bean.LectureOpen;
import cafe24.wio.bean.LectureOpenSchedule;
import cafe24.wio.mapper.LectureMapper;

@Service
public class LectureService {

	@Autowired
	private LectureMapper lectureMapper;
	
	
	/**
	 * 검색결과 유무 조회
	 * @param startPeriod
	 * @param endPeriod
	 * @param lecStartDate
	 * @param lecFinalDate
	 * @param selectlecOsSk
	 * @param lecOsSv
	 * @return int checkResult
	 */
	public int checkSearchResult(String startPeriod
								,String endPeriod
								,String lecStartDate
								,String lecFinalDate
								,String selectlecOsSk
								,String lecOsSv) {
		int checkResult = 0;

		if(startPeriod != null && endPeriod != null) {
			List<Map<String,Object>> searchResultByPeriod = 
							lectureMapper.lecOsSearchPeriod(lecStartDate, lecFinalDate, startPeriod, endPeriod);
			if(searchResultByPeriod.size()==0) {
				checkResult = 0;
			}else {
				checkResult = 1;
			}
		}else if(selectlecOsSk != null && lecOsSv != null) {
			List<Map<String,Object>> searchResult =
							lectureMapper.getLecOsSearch(selectlecOsSk, lecOsSv);
			if(searchResult.size() ==0) {
				checkResult = 0;
			}else {
				checkResult = 1;
			}
		}
		
		
		return checkResult;
	}
	
	/**
	 * 강의예정리스트 기간별 검색
	 * @param lecStartDate
	 * @param lecFinalDate
	 * @param startPeriod
	 * @param endPeriod
	 * @return List<Map<String,Object>> lectureOsList
	 */
	public List<Map<String,Object>> lecOsSearchPeriod(String lecStartDate
													, String lecFinalDate
													, String startPeriod
													, String endPeriod){
		
		List<Map<String,Object>> lectureOsList =
				lectureMapper.lecOsSearchPeriod(lecStartDate, lecFinalDate, startPeriod, endPeriod);
		
		return lectureOsList;
	}
	
	//페이징을 위한 강의예정리스트 카운팅
	public int countLecOs() {
		
		return 0;
	}
	
	/**
	 * 강의예정리스트 검색
	 * @param lecOsSk
	 * @param lecOsSv
	 * @return List<Map<String,Object>> lecOsList
	 */
	public List<Map<String,Object>> getLecOsSearch(String lecOsSk, String lecOsSv){
			List<Map<String,Object>> lecOsList = lectureMapper.getLecOsSearch(lecOsSk, lecOsSv);
		return lecOsList;
	}
	
	/**
	 * 강의코드 자동증가
	 * @return String lecOpCode
	 */
	public String getLecOpenCode() {
		String lecOpMaxCode = lectureMapper.getLecOpenCode();
		String tempCode = null;
		String lecOpCode = null;
		int maxCode = 0;
		if(lecOpMaxCode != null && !"".equals(lecOpMaxCode)) {
			maxCode = Integer.parseInt(lecOpMaxCode);
			if(maxCode <10) {
				tempCode = "lec_open_00";
			}else if(10<=maxCode && maxCode <100) {
				tempCode = "lec_open_0";
			}else if(100<=maxCode && maxCode <1000) {
				tempCode = "lec_open_";
			}
		}
		lecOpCode = tempCode + maxCode;
		
		return lecOpCode;
	}
	
	/**
	 * 강의리스트에 등록하기
	 * @param lectureOpen
	 * @return
	 */
	public int addLectureOpen(LectureOpen lectureOpen) {
		
		int addResult = lectureMapper.addLectureOpen(lectureOpen);
		return addResult;
	}
	
	/**
	 * 강의예정코드로 중복개설되었는지 확인
	 * @param lecOsCode
	 * @return int
	 */
	public int checkLecOpen (String lecOsCode){
		int checkResult = 0;
		List<LectureOpen> checkLecOpen = lectureMapper.checkLecOpen(lecOsCode);
		System.out.println(checkLecOpen.size() + " < -- checkLecOpen.size()");
		if(checkLecOpen !=null) {
			if(checkLecOpen.size() > 0) {
				checkResult = 1;
			}else {
				checkResult =0;
			}
		}
		
		return checkResult;
	}
	
	/**
	 * 강의예정리스트 수정하기
	 * @param lectureOs
	 * @return int modifyResult
	 */
	public int modifyLecOs(LectureOpenSchedule lectureOs) {
		int modifyResult = lectureMapper.modifyLecOs(lectureOs);
		return modifyResult;
	}
	
	/**
	 * 개설된 강의 상태변경
	 * @param changeLecStatus
	 * @param lecOpCode
	 * @return int changeResult
	 */
	public int changeLecStatus(String changeLecStatus
								, String lecOpCode) {
		int changeResult = lectureMapper.changeLecStatus(changeLecStatus, lecOpCode);
		return changeResult;
	}
	
	/**
	 * 강의예정리스트 1개만 조회
	 * @param lecOsCode
	 * @return List<Map<String,Object>> lecOsList
	 */
	public Map<String,Object> getLecOsListOnly(String lecOsCode){
		
		Map<String,Object> lecOsList = lectureMapper.getLecOsListOnly(lecOsCode);
		return lecOsList;
	}
	
	/**
	 * 개설된 강의리스트 조회하기
	 * @return List<Map<String, Object>>  lectureList
	 */
	public List<Map<String,Object>> getLectureList(){
		List<Map<String,Object>> lectureList = lectureMapper.getLectureList();
		return lectureList;
	}
	
	/**
	 * 강의예정리스트에서 비고사항 가져오기
	 * @param lecOsCode
	 * @return  List<Map<String,Object>> lecOsRemark
	 */
	public List<Map<String,Object>> getLecOsRemark(String lecOsCode){
		
		List<Map<String,Object>> lecOsRemark = lectureMapper.getLecOsRemark(lecOsCode);
		return lecOsRemark;
	}
	
	/**
	 * 강의개설신청시 코드 강의예정 코드 자동증가 
	 * @return String lecOsCode
	 */
	public String getLecOsMaxCode() {
		String lecOsMaxCode = lectureMapper.getLecOsMaxCode();
		String tempCode = null;
		String lecOsCode = null;
		int maxCode = 0;
		if(lecOsMaxCode != null && !"".equals(lecOsMaxCode)) {
			maxCode = Integer.parseInt(lecOsMaxCode);
			if(maxCode <10) {
				tempCode = "lec_os_00";
			}else if(10<=maxCode && maxCode <100) {
				tempCode = "lec_os_0";
			}else if(100<=maxCode && maxCode <1000) {
				tempCode = "lec_os_";
			}
		}
		lecOsCode = tempCode + maxCode;
		
		return lecOsCode;
	}
	
	
	/**
	 * 강의개설신청하기
	 * @param lectureOs
	 * @return
	 */
	public int addLectureOpenSchedule(LectureOpenSchedule lectureOs) {
			
		return lectureMapper.addLectureOpenSchedule(lectureOs);
	}
	/**
	 * 강의코드만 가져오기
	 * @return List LectureOpenSchedule
	 */
	public List<LectureOpenSchedule> getLecOsCode(){
		
		return lectureMapper.getLecOsCode();
	}
	
	/**
	 *  강의예정코드로 강의예정리스트가져오기 
	 * @param lecOsCode
	 * @return List<Map<String,Object>> getOnlyLecOsList
	 */
	public List<Map<String,Object>> getOnlyLecOsList(String lecOsCode){
		
		List<Map<String,Object>> getOnlyLecOsList = lectureMapper.getOnlyLecOsList(lecOsCode);
		return getOnlyLecOsList;
	}
	
	/**
	 * 강의예정리스트 날짜별조회
	 * @param lecStDate
	 * @param lecFinDate
	 * @return  List<LectureOpenSchedule> lecOsListDate
	 */
	public List<Map<String,Object>> getLecOsListDate(String lecStartDate, String lecFinalDate){
		List<Map<String,Object>> lecOsListDate = 
							lectureMapper.getLecOsListDate(lecStartDate, lecFinalDate);
		return lecOsListDate;
	}
	
	
	/**
	 * 강의 예정리스트
	 * @param currentPage
	 * @return Map<String,Object> resultMap
	 */
	public Map<String,Object> getLectureOsList(int currentPage){
		
		final int ROW_PER_PAGE = 5;
	      
	      int startRow = 0;
	      
	      int startPageNum = 1;
	      int lastPageNum = ROW_PER_PAGE;
	      
	      if(currentPage > (ROW_PER_PAGE/2)) {
	         startPageNum = currentPage - ((lastPageNum/2)-1);
	         lastPageNum += startPageNum;
	      }
	      
	      startRow = (currentPage - 1) * ROW_PER_PAGE ;
	      
	      Map<String,Object> lecOsMap = new HashMap<String,Object>();
	            
	      lecOsMap.put("startRow", startRow);
	      lecOsMap.put("rowPerPage", ROW_PER_PAGE);

	      double totalRowCount = lectureMapper.countLecOs();
	      
	      int lastPage = (int)Math.ceil((totalRowCount / ROW_PER_PAGE));

	      List<Map<String,Object>> lectureOsList = lectureMapper.getLectureOsList(lecOsMap);
		
		
	      if(currentPage >= (lastPage-4)) {
		         lastPageNum = lastPage;
		      }
		      
		      Map<String,Object> resultMap = new HashMap<String,Object>();
		      resultMap.put("lectureOsList", lectureOsList);
		      resultMap.put("lastPage", lastPage);
		      resultMap.put("startPageNum", startPageNum);
		      resultMap.put("lastPageNum", lastPageNum);
		
		return resultMap;
		
	}
	
	/**
	 * 시간강사목록 조회
	 * @param mrTeahcerId
	 * @return List Map<String,Object> teacherList
	 */
	public List<Map<String,Object>> getTeacherList(){
		
		List<Map<String,Object>> teacherList= lectureMapper.getTeacherList();
		return teacherList;
	}
	
	/**
	 * 강의상태구분 조회
	 * @return List<Map<String,Object>> lectureStatus 
	 */
	public List<Map<String,Object>> getLectureStatus(){
		List<Map<String,Object>> lectureStatus 
							=lectureMapper.getLectureStatus();
		return lectureStatus;
	}
	
	/**
	 * 강의수준 조회
	 * @return List Map<String,Object> lectureLevel
	 */
	public List<Map<String,Object>> getLectureLevel(){
		List<Map<String,Object>> lectureLevel
								= lectureMapper.getLectureLevel();
		return lectureLevel;
	}
	
	/**
	 * 강의실 조회
	 * @return List Map<String,Object> lectureRoom
	 */
	public List<Map<String,Object>> getLectureRoom(){
		List<Map<String,Object>> lectureRoom
								= lectureMapper.getLectureRoom();
		return lectureRoom;
	}
	
	/**
	 * 강의시간 조회
	 * @return List Map<String,Object> lectureTime
	 */
	public List<Map<String,Object>> getLectureTime(){
		List<Map<String,Object>> lectureTime 
								= lectureMapper.getLectureTime();
		return lectureTime;
	}
	
	/**
	 * 수강신청인원 조회하기
	 * @param lecOsCode
	 * @return List<Map<String,Object>> lecApplyCount 
	 */
	public List<Map<String,Object>> getApplyCount() {
	
		List<Map<String,Object>> lecApplyCount 
								= lectureMapper.getApplyCount();
		return lecApplyCount;
	}
	
}
