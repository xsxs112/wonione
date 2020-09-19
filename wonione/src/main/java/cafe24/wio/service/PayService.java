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
	private PayMapper PayMapper;
		
	//직원 급여목록 조회
	public List<OfficersPay> getOfficersPayList() {		
		
		List<OfficersPay> officersPayList = PayMapper.getOfficersPayList();	
		return officersPayList;
	}
	
	//강사 급여목록 조회
	public List<StaffPay> getStaffPayList() {		
		
		List<StaffPay> staffPayList = PayMapper.getStaffPayList();	
		return staffPayList;
	}
	


}
