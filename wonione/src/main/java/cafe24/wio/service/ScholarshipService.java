package cafe24.wio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafe24.wio.bean.ScholarShip;
import cafe24.wio.mapper.ScholarshipMapper;

@Service
public class ScholarshipService {

	@Autowired
	private ScholarshipMapper scholarshipMapper;
	
	public List<ScholarShip> getScholarList(ScholarShip scholarship){
		List<ScholarShip> scholarshipList = scholarshipMapper.getScholarList(scholarship);
		return scholarshipList;
	}
}
