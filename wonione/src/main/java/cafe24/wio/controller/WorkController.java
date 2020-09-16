package cafe24.wio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cafe24.wio.bean.ApprovalRequest;
import cafe24.wio.bean.WorkAttendance;
import cafe24.wio.service.ApprRequestService;

//황미현 - 출퇴근 컨트롤러

@Controller
public class WorkController {
	
	
	 // @Autowired private ApprovalRequest approvalRequest;
	 
	
	  @Autowired private ApprRequestService apprRequestService;
	 

	/*
	 * @PostMapping("/getMemberList") public String getMemberList(Model
	 * model, @RequestParam(value = "sk", required = false) String sk,
	 * 
	 * @RequestParam(value = "sv", required = false) String sv) {
	 * 
	 * List<Member> memberList = memberService.getSearchMemberList(sk, sv);
	 * model.addAttribute("memberList", memberList);
	 * model.addAttribute("tite,회원목록 조회");
	 * 
	 * return "memberList"; }
	 */
	
	@GetMapping("/holidayApproval")
	public String holidayApproval(Model model) {
		
		List<ApprovalRequest> holidayList = apprRequestService.getHolidayList();
		model.addAttribute("holidayList", holidayList);
			 
		return "workmanagment/holidayApproval";
	}
	
	
	@GetMapping("/workAttendance")
	public String workAttendance(WorkAttendance workAttendance) {
		
		
		return "workmanagment/workAttendance";
	}
	
	

}
