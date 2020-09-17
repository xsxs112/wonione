package cafe24.wio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafe24.wio.bean.OfficersPay;
import cafe24.wio.controller.OfficersPayController;
import cafe24.wio.mapper.OfficersPayMapper;

@Service
public class OfficersPayService {
	
	@Autowired
	private OfficersPayMapper officersPayMapper;
	
	public List<OfficersPayController> getOfficersPayList() {
		
		//직원들의 정보가 담긴 list객체
		List<OfficersPayController> officersPayList = officersPayMapper.getOfficersPayList();
	
		return officersPayList;
	}

	public List<OfficersPayController> getOfficersPay(String mrId) {
		//직원의 id 정보가 담긴 list객체
		List<OfficersPayController> officersPay = officersPayMapper.getOfficersPay(mrId);
		
		return officersPay;
	}

	public List<OfficersPayController> getOfficersList() {
		//직원의 급여 정보가 담긴 list객체
		List<OfficersPayController> OfficersList = officersPayMapper.getOfficersList();
		
		return OfficersList;
	}

	public OfficersPay callOfficersInfo(String mrId) {
		//직원의 정보가 담긴 list객체
		OfficersPay OfficersInfo = officersPayMapper.callOfficersInfo(mrId);
		
		return OfficersInfo;
	}

}
