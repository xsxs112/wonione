package cafe24.wio.mapper;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cafe24.wio.bean.Consulting;


@Mapper
public interface ConsultingMapper {
	//선생님이름호출
	public List<Map<String, Object>> SelectTeacher();
	//강의이름 호출
	public List<Map<String, Object>> SelectLecName();
	//상담입력
	public int addConsultingWrite(Consulting consulting);

}
