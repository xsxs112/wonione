package cafe24.wio.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cafe24.wio.bean.ApprovalRequest;
import cafe24.wio.bean.Member;
import cafe24.wio.bean.WorkAttendance;
import cafe24.wio.mapper.ApprMapper;
import cafe24.wio.service.ApprRequestService;

//황미현 - 출퇴근 컨트롤러

@Controller
public class WorkController {

	// @Autowired private ApprovalRequest approvalRequest;

	@Autowired
	private ApprRequestService apprRequestService;
	@Autowired
	private ApprMapper apprMapper;


	
	
	@ResponseBody
	@GetMapping("/startDayCk")
	public int startDayCk(@RequestParam(value = "startDate", required = false) String startDate) {
		System.out.println(startDate+"workCotroller");
		int getStartDate = apprRequestService.getStartDayCk(startDate);

	
		return getStartDate;
		
	}
	
	
	@PostMapping("/holidayRequest")
	public String holidayRequest(ApprovalRequest approvalRequest,	@RequestParam(value = "reStartDate", required = false) String reStartDate,
												@RequestParam(value = "reEndDate", required = false) String reEndDate,
												@RequestParam(value = "mrId", required = false) String mrId,
												@RequestParam(value = "mrName", required = false) String mrName,
												@RequestParam(value = "reReason", required = false) String reReason,
												@RequestParam(value ="holidaySt", required = false) String holidaySt) {
			System.out.println("mrId--------------"+mrId);
			approvalRequest.setMrId(mrId);
			approvalRequest.setReStartDate(reStartDate);
			approvalRequest.setReEndDate(reEndDate);
			approvalRequest.setSortation(holidaySt);
			approvalRequest.setReReason(reReason);
			apprRequestService.addholidayApproval(approvalRequest);
			
			
		return "redirect:/holidayApproval";


	}
	
	
	//휴가요청 리스트
	@GetMapping("/holidayApproval")
	@PostMapping("/holidayApproval")
	public String getHolidayList(Model model) {

		List<ApprovalRequest> holidayList = apprRequestService.getHolidayList();
		model.addAttribute("holidayList", holidayList);

		return "workmanagment/holidayApproval";
	}

	
	/*
	 * //아직 사용X
	 * 
	 * @GetMapping("/workAttendance") public String workAttendance(WorkAttendance
	 * workAttendance) {
	 * 
	 * return "workmanagment/workAttendance"; }
	 */
	

	/*
	 * //휴가 신청 하려는데 아직 로그인 기능이 없어 세션 아이디 비밀번호를 쓸 수가 없어서 //여기서만 쓸수있게 임시로 만들게요
	 * 
	 * @GetMapping("/LoginForHoliday") public String LoginForHoliday(Model model) {
	 * 
	 * 
	 * return "workmanagment/holidayLogin"; }
	 */
	
	
	
	/*
	 * @PostMapping("/LoginForHoliday") public String LoginForHoliday(Model
	 * model, @RequestParam(value = "mrId", required = false) String mrId,
	 * 
	 * @RequestParam(value = "mrPw", required = false) String mrPw, HttpSession
	 * session) { Member member = apprMapper.getMemberById(mrId); if (member !=
	 * null) { if (member.getMrPw().equals(mrPw)) { session.setAttribute("SID",
	 * member.getMrId()); session.setAttribute("SNAME", member.getMrName()); return
	 * "workmanagment/holidayApproval"; } }
	 * 
	 * return "workmanagment/holidayLogin";
	 * 
	 * }
	 */
	
	

}
