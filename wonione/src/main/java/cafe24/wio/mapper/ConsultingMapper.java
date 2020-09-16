package cafe24.wio.mapper;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ConsultingMapper {
	//선생님이름호출
	public List<Map<String, Object>> SelectTeacher();
	//강의이름 호출
	public List<Map<String, Object>> SelectLecName();

}
