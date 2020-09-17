package cafe24.wio.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafe24.wio.bean.ApprovalRequest;
import cafe24.wio.bean.Member;
import cafe24.wio.mapper.ApprMapper;

@Service
public class ApprRequestService {

	
	@Autowired
	private ApprMapper apprMapper;
	
	public List<ApprovalRequest> getHolidayList() {
		
		List<ApprovalRequest> holliday = apprMapper.getHolidayList();
		
		
		return holliday;
	}
	
	
	public String getReCode() {
		Map<String, Object> reCodeMax =  apprMapper.getReCode();
		
		System.out.println("reCodeMax ------------> " + reCodeMax);
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
