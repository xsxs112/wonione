package cafe24.wio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafe24.wio.bean.OfficersPay;
import cafe24.wio.bean.StaffPay;
import cafe24.wio.mapper.PayMapper;

@Service
public class PayService {
	
	@Autowired
	private PayMapper payMapper;
	
	public int removeStaffPayDocu(String spCode) {
		int result = 0;
		StaffPay staffpay = payMapper.getSPCode(spCode);
		if(staffpay != null) {
			//1. 강사급여 테이블 삭제
			result += payMapper.removeSP(spCode);
			//2. 강사급여 공제계 테이블 삭제
			result += payMapper.removeSPD(spCode);		
			//3. 강사급여 급여계 테이블 삭제
			result += payMapper.removeSPC(spCode);
		}
		return result;
	}
	
	//직원급여삭제
	public int removeOffiPayDocu(String opCode) {
		int result = 0;
		
		OfficersPay officersPay = payMapper.getOPCode(opCode);		
		if(officersPay != null) {
			//1. 직원급여 테이블 삭제
			result += payMapper.removeOP(opCode);
			//2. 직원급여 공제계 테이블 삭제
			result += payMapper.removeOPD(opCode);		
			//3. 직원급여 급여계 테이블 삭제
			result += payMapper.removeOPC(opCode);
		}
		//delete 성공 결과
		return result;
	}
	
	//직원 급여목록 조회
	public List<OfficersPay> getOfficersPayList() {		
		
		List<OfficersPay> officersPayList = payMapper.getOfficersPayList();	
		return officersPayList;
	}
	
	//강사 급여목록 조회
	public List<StaffPay> getStaffPayList() {		
		
		List<StaffPay> staffPayList = payMapper.getStaffPayList();	
		return staffPayList;
	}
	
	// 선택한 직원 급여정보 조회
	public List<OfficersPay> getOffiIdPayList(String mrId) {
		List<OfficersPay> officersPayList = payMapper.getOffiIdPayList(mrId);
		return officersPayList;
	}

	// 선택한 강사 급여정보 조회
	public List<StaffPay> getStaIdPayList(String mrId) {
		List<StaffPay> staffPayList = payMapper.getStaIdPayList(mrId);
		return staffPayList;
	}

	//직원급여목록조건검색
	public List<OfficersPay> getSearchOPL(String offisk, String offisv) {
		List<OfficersPay> officersSPayList = payMapper.getSearchOPL(offisk, offisv);
		return officersSPayList;
	}

	//강사급여목록조건검색
	public List<StaffPay> getSearchSPL(String staffsk, String staffsv) {
		List<StaffPay> staffSPayList = payMapper.getSearchSPL(staffsk, staffsv);
		return staffSPayList;
	}

	//자원테이블 가져오기
	public List<OfficersPay> standardSheet() {
		List<OfficersPay> standardSheetHour = payMapper.standardSheet();		
		return standardSheetHour;
	}

	//보험요율표가져오기
	public List<OfficersPay> insuranceYear() {
		List<OfficersPay> insuranceYear = payMapper.insuranceYear();
		return insuranceYear;
	}

	//직원급여 미지급목록 조회하기
	public List<OfficersPay> nonOffiPay() {
		List<OfficersPay> nonOffiPayList = payMapper.nonOffiPay();
		return nonOffiPayList;
	}

	//강사급여 미지급목록 조회하기
	public List<StaffPay> nonStaffPay() {
		List<StaffPay> nonStaffPayList = payMapper.nonStaffPay();		
		return nonStaffPayList;
	}

	//직원급여 월별 조회하기
	public List<OfficersPay> monthOffiPay(float pRTitle) {
		List<OfficersPay> nonOffiPayList = payMapper.monthOffiPay(pRTitle);
		return nonOffiPayList;
	}

	//강사급여 월별 조회하기
	public List<OfficersPay> monthStaffPay(float pRTitle) {
		List<OfficersPay> monthStaffPayList = payMapper.monthStaffPay(pRTitle);
		return monthStaffPayList;
	}
	
}
