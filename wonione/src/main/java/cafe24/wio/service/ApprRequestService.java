package cafe24.wio.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafe24.wio.bean.ApprovalRequest;
import cafe24.wio.mapper.ApprMapper;

@Service
public class ApprRequestService {

	
	@Autowired
	private ApprMapper apprMapper;
	
	
	
	public int approval(String approval) {
		
		int apprResult = 0;
		
		
		return apprResult;
	}
	
	public int hListDuplicate(String startDate,String endDate) {
		int hDuplicate = 1;
		
		hDuplicate = apprMapper.hListDuplicate(startDate,endDate);
	
		
		return hDuplicate;
	}


	
	public int getStartDayCk(String startDate) {
		//int형 getStartDate를 선언하고 
		//ApprMapper 클래스의 getStartDayCk 메소드에 입력값 startDate을 입력하여 리턴받은 값을 담는다
		int getStartDate = apprMapper.getStartDayCk(startDate);
		
		//호출한곳에 getStartDate를 리턴한다
		
		return getStartDate;
	}
	
	
	
	
	
	public List<ApprovalRequest> getHolidayList() {
		
		List<ApprovalRequest> holliday = apprMapper.getHolidayList();
		
		
		return holliday;
	}
	
	
	public String getReCode() {
		Map<String, Object> reCodeMax =  apprMapper.getReCode();
		
		String tempCode = "request_";
		
		int getMax = Integer.parseInt(reCodeMax.get("max").toString());

		if(getMax<10) {
			tempCode = "request_0";
		}
		String reCode = tempCode + String.valueOf(reCodeMax.get("max"));
		System.out.println("reCode ------------> " + reCode);
		
		return reCode;
	}
	
	public int addholidayApproval(ApprovalRequest approvalRequest) {
		
		
		approvalRequest.setReCode(getReCode());

		int result = apprMapper.addholidayApproval(approvalRequest);
		
		
		return result;
	}
	

}
