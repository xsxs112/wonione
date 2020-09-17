package cafe24.wio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafe24.wio.bean.OfficersPay;
import cafe24.wio.mapper.OfficersPayMapper;

@Service
public class OfficersPayService {
	
	@Autowired
	private OfficersPayMapper officersPayMapper;
	
	public List<OfficersPay> getOfficersPayList() {
		
		//직원들의 정보가 담긴 list객체
		List<OfficersPay> officersPayList = officersPayMapper.getOfficersPayList();
	
		return officersPayList;
	}

	public List<OfficersPay> getOfficersPay(String mrId) {
		//직원의 id 정보가 담긴 list객체
		List<OfficersPay> officersPay = officersPayMapper.getOfficersPay(mrId);
		
		return officersPay;
	}

	public List<OfficersPay> getOfficersList() {
		//직원의 급여 정보가 담긴 list객체
		List<OfficersPay> OfficersList = officersPayMapper.getOfficersList();
		
		return OfficersList;
	}

	public OfficersPay callOfficersInfo(String mrId) {
		//직원의 정보가 담긴 list객체
		OfficersPay OfficersInfo = officersPayMapper.callOfficersInfo(mrId);
		
		return OfficersInfo;
	}

}
