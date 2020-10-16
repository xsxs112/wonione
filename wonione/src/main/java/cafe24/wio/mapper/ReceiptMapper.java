package cafe24.wio.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cafe24.wio.bean.Course;

@Mapper
public interface ReceiptMapper {
	
	
	// 1-2. 개설 예정 과목 리스트 가져오기
	public List<Map<String, Object>> getOpenLecList();
	
	// 1. 과정 선택
	public int getCourseSelection(Course course);
}
