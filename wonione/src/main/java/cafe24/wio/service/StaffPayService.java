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
		
		return staffInfo;
	}
		
	//강사 급여명세 조회
	public List<StaffPay> getStaffPay(String mrId) {
		
		List<StaffPay> staffPay = staffPayMapper.getStaffPay(mrId);		
		return staffPay;
	}

	//보험요율표가져오기
	public List<StaffPay> insuranceYear() {
		List<StaffPay> insuranceYear = staffPayMapper.insuranceYear();
		return insuranceYear;
	}

}
