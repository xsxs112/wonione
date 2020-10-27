package cafe24.wio.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface refundMapper {
	//환불숫자
	public int refundCount(String sessionId);
	//환불리스트
	public List<Map<String, Object>> refundList(Map<String, Object> parameterMap);

}
