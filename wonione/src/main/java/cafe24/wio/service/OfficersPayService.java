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
	
	//공제액 계산하기
	public OfficersPay OfficersDedu(String opdCode, String iyCode, String opdIncomeTax ) {
		OfficersPay officersDedu = officersPayMapper.OfficersDedu(opdCode, iyCode, opdIncomeTax);
		
		return officersDedu;
	}
	
	//보험요율표가져오기
	public List<OfficersPay> insuranceYear() {
		List<OfficersPay> insuranceYear = officersPayMapper.insuranceYear();
		return insuranceYear;
	}
	
	//직원 한명 정보 조회
	public OfficersPay callOfficersInfo(String mrId) {
		OfficersPay officersInfo = officersPayMapper.callOfficersInfo(mrId);
		
		String opcMaxcode = officersInfo.getOpcCode();
		String tempCode = null;
		String supOpCode = null;
		int maxCode = 0;
		if(opcMaxcode != null && !"".equals(opcMaxcode)) {
			maxCode = Integer.parseInt(opcMaxcode);
			if(maxCode <10) {
				tempCode = "OP_000";
			}else if(10<=maxCode && maxCode <100) {
				tempCode = "OP_00";
			}else if(100<=maxCode && maxCode <1000) {
				tempCode = "OP_0";
			}
		}
		supOpCode = tempCode + maxCode;
		officersInfo.setOpcCode(supOpCode);
		
		return officersInfo;
	}	

	//직원 급여명세 조회
	public List<OfficersPay> getOfficersPay(String mrId, String opCode) {
		
		List<OfficersPay> officersPay = officersPayMapper.getOfficersPay(mrId, opCode);		
		
		return officersPay;
	}

	//직원급여계 입력하기
	public int addOffiCalpay(OfficersPay officersPay) {
		int result = officersPayMapper.addOffiCalpay(officersPay);
		
		return 	result;
	}
	//직원공제계 입력하기
	public int addOffiDedupay(OfficersPay officersPay) {
		int result = officersPayMapper.addOffiDedupay(officersPay);
		
		return 	result;
	}

	//급여 입력하기
	public int addOfficersPay(OfficersPay officersPay) {
		int result = officersPayMapper.addOfficersPay(officersPay);
		
		return 	result;
		
	}


	

}
