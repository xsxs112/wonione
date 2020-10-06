package cafe24.wio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafe24.wio.bean.LectureOpenSchedule;
import cafe24.wio.bean.Member;
import cafe24.wio.mapper.LectureMapper;

@Service
public class LectureService {

	@Autowired
	private LectureMapper lectureMapper;

	/**
	 * 강의예정리스트 1개만 조회
	 * @param lecOsCode
	 * @return List<Map<String,Object>> lecOsList
	 */
	public List<Map<String,Object>> getLecOsListOnly(String lecOsCode){
		
		List<Map<String,Object>> lecOsList = lectureMapper.getLecOsListOnly(lecOsCode);
		return lecOsList;
	}
	
	/**
	 * 강의리스트 조회하기
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
	public int applyLectureOpen(LectureOpenSchedule lectureOs) {
			
		return lectureMapper.applyLectureOpen(lectureOs);
	}
	/**
	 * 강의코드만 가져오기
	 * @return List LectureOpenSchedule
	 */
	public List<LectureOpenSchedule> getLecOsCode(){
		
		return lectureMapper.getLecOsCode();
	}
	
	/**
	 * 강의예정 리스트
	 * @return List Map String,Object lectureOsList
	 */
	public List<Map<String,Object>> getLectureOsList(){
		
		List<Map<String,Object>> lectureOsList = lectureMapper.getLectureOsList();
		
		return lectureOsList;
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
	 * @return int result
	 */
	public List<Object> getApplyCount() {
		
		List<LectureOpenSchedule> lecOsCodeArray = lectureMapper.getLecOsCode();
		
		int result = 0;
		List<Object> lecApplyCount = new ArrayList<>();
		for(int i=0; i<lecOsCodeArray.size(); i++) {
			String lecOsCode = lecOsCodeArray.get(i).getLecOsCode();
			result = lectureMapper.getApplyCount(lecOsCode);
			lecApplyCount.add(result);
		}
		
		return lecApplyCount;
	}
	
}
