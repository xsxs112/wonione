package cafe24.wio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafe24.wio.bean.StaffPay;
import cafe24.wio.mapper.StaffPayMapper;

@Service
public class StaffPayService {
	
	@Autowired
	private StaffPayMapper staffPayMapper;
	

	//강사 목록조회
	public List<StaffPay> getStaffList() {	
		List<StaffPay> staffList = staffPayMapper.getStaffList();
		
		return staffList;
	}
	
	//자원테이블 가져오기
	public List<StaffPay> standardSheet() {
		List<StaffPay> standardSheetHour = staffPayMapper.standardSheet();
		
		return standardSheetHour;
	}	
	
	//강사 한명 정보 조회
	public StaffPay callStaffInfo(String mrId) {
		StaffPay staffInfo = staffPayMapper.callStaffInfo(mrId);
		
		String spcMaxcode = staffInfo.getSpcCode();
		String tempCode = null;
		String supSpCode = null;
		int maxCode = 0;
		if(spcMaxcode != null && !"".equals(spcMaxcode)) {
			maxCode = Integer.parseInt(spcMaxcode);
			if(maxCode <10) {
				tempCode = "SP_000";
			}else if(10<=maxCode && maxCode <100) {
				tempCode = "SP_00";
			}else if(100<=maxCode && maxCode <1000) {
				tempCode = "SP_0";
			}
		}
		supSpCode = tempCode + maxCode;
		staffInfo.setSpcCode(supSpCode);
		
		return staffInfo;
	}
		
	//강사 급여명세 조회
	public List<StaffPay> getStaffPay(String mrId, String spCode) {
		
		List<StaffPay> staffPay = staffPayMapper.getStaffPay(mrId, spCode);		
		return staffPay;
	}

	//보험요율표가져오기
	public List<StaffPay> insuranceYear() {
		List<StaffPay> insuranceYear = staffPayMapper.insuranceYear();
		return insuranceYear;
	}
	
	//강사 급여계 입력하기
	public int addStaffCalPay(StaffPay staffpay) {
		int result = staffPayMapper.addStaffCalPay(staffpay);
		
		return result;
	}

	//요율표 비교 공제액 계산
	public StaffPay StaffPayDedu(String spdCode, String iyCode) {
		StaffPay staffPayDedu = staffPayMapper.StaffPayDedu(spdCode, iyCode);
		
		return staffPayDedu;
	}

	//강사 공제계 입력하기
	public int addStaffDedupay(StaffPay staffPay) {
		int result = staffPayMapper.addStaffDedupay(staffPay);
		
		return result;
	}

	//강사 급여 입력
	public int addStaffPay(StaffPay staffPay) {
		int result = staffPayMapper.addStaffPay(staffPay);
		
		return result;		
	}

	//수정할 강사정보 불러오기
	public StaffPay getMrBySId(String spCode) {
		StaffPay modiStaffPay = staffPayMapper.getMrBySId(spCode);

		return modiStaffPay;
	}

	//강사 급여계 수정하기
	public int modiStaffCal(StaffPay staffpay) {
		int result = staffPayMapper.modiStaffCal(staffpay);
		
		return result;		
	}

	//강사 공제계 수정하기
	public int modiStaffDedu(StaffPay staffPay) {
		int result = staffPayMapper.modiStaffDedu(staffPay);
		
		return result;	
	}

	//강사 급여 수정
	public int modiStaffPay(StaffPay staffPay) {
		int result = staffPayMapper.modiStaffPay(staffPay);
		
		return result;
	}

}
