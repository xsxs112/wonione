package cafe24.wio.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cafe24.wio.bean.LectureOpenSchedule;


@Mapper
public interface LectureMapper {

	//강의코드가져오기
	public List<LectureOpenSchedule> getLecOsCode();
	
	//강의예정 리스트
	public List<Map<String,Object>> getLectureOsList();
	
	//시간강사목록 조회
	public List<Map<String,Object>> getTeacherList();
	
	//강의수준 조회
	public List<Map<String,Object>> getLectureLevel();
	
	//강의실 조회
	public List<Map<String,Object>> getLectureRoom();
	
	//강의시간 조회
	public List<Map<String,Object>> getLectureTime();
	
	//강의 신청인원 조회 
	public int getApplyCount(String lecOsCode);
}
