package cafe24.wio.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface QuestionMapper {

	public List<Map<String, Object>> QuestionList(Map<String, Object> parameterMap);

	public int QuestionListCount();


}
