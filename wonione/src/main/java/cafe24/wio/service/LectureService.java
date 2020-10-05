package cafe24.wio.service;

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
	public int getApplyCount(String lecOsCode) {
			int result = lectureMapper.getApplyCount(lecOsCode);
		return result;
	}
	
}
