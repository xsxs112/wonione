package cafe24.wio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import cafe24.wio.bean.ApprovalRequest;
import cafe24.wio.bean.WorkAttendance;

//황미현 - 출퇴근 컨트롤러

@Controller
public class WorkController {
	
	@GetMapping("/workAttendance")
	public String workAttendance(WorkAttendance workAttendance) {
		
		
		return "workmanagment/workAttendance";
	}
	
	@GetMapping("/holidayApproval")
	public String holidayApproval(ApprovalRequest approvalRequest) {
		
		
		return "workmanagment/holidayApproval";
	}
	

}
