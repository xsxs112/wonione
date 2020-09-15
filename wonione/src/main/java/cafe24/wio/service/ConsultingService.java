package cafe24.wio.service;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafe24.wio.mapper.ConsultingMapper;

@Service
public class ConsultingService {
		
	@Autowired
	private ConsultingMapper consultingMapper;
	
	
	public List<Map<String, Object>> SelectTeacher() {
		List<Map<String, Object>> TeacherName = consultingMapper.SelectTeacher();
		System.out.println(TeacherName);
		return TeacherName;
	}
	public List<Map<String, Object>> SelectLecName() {
		List<Map<String, Object>> SelectLecName = consultingMapper.SelectLecName();
		System.out.println(SelectLecName);
		return SelectLecName;
	}

}
