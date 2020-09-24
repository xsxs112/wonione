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
	

	//직원 목록조회
	public List<OfficersPay> getOfficersList() {	
		List<OfficersPay> OfficersList = officersPayMapper.getOfficersList();
		
		return OfficersList;
	}
	
	//자원테이블 가져오기
	public List<OfficersPay> standardSheet() {
		List<OfficersPay> standardSheetHour = officersPayMapper.standardSheet();
		
		return standardSheetHour;
	}	
	
	//직원 한명 정보 조회
	public OfficersPay callOfficersInfo(String mrId) {
		OfficersPay OfficersInfo = officersPayMapper.callOfficersInfo(mrId);
				
		return OfficersInfo;
	}	

	//직원 급여명세 조회
	public List<OfficersPay> getOfficersPay(String mrId) {
		
		List<OfficersPay> officersPay = officersPayMapper.getOfficersPay(mrId);		
		return officersPay;
	}

	//직원급여계 입력하기
	public int addOffiCalpay(OfficersPay officersPay) {
		int result = officersPayMapper.addOffiCalpay(officersPay);
		
		return 	result;
	}
	

}
