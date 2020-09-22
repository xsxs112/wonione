package cafe24.wio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cafe24.wio.bean.ApprovalRequest;
import cafe24.wio.service.ApprRequestService;

//황미현 - 출퇴근 컨트롤러

@Controller
public class WorkController {


	@Autowired
	private ApprRequestService apprRequestService;

	
	
	//관리자화면 휴가 승인
	@GetMapping("/approval")
	public String approval(@RequestParam(value = "reState", required = false) String reState) {

		apprRequestService.approval(reState);

		return "workmanagment/holidayList";
	}
	
	
	//관리자 화면 휴가요청 리스트
	@GetMapping("/holidayList")
	public String holidayList(Model model) {

		List<ApprovalRequest> holidayList = apprRequestService.getHolidayList();
		model.addAttribute("holidayList", holidayList);

		return "workmanagment/holidayList";
	}

	
	
	
	
	
	
	
	//휴가 중복 체크
	@ResponseBody
	@GetMapping("/holidayCk")
	//holidayApproval.html에서 startDate,endDate 값을 받는다
	public int holidayCk(@RequestParam(value = "startDate", required = false) String startDate,
							@RequestParam(value = "endDate", required = false) String endDate) {
								
		int holidayCk = 1;
		
		holidayCk =	apprRequestService.hListDuplicate(startDate,endDate);
		
		
		return holidayCk;
		
		
	}

	
	//holidayApproval.html에서 startDate값을 받는다
	@ResponseBody
	@GetMapping("/startDayCk")
	public int startDayCk(@RequestParam(value = "startDate", required = false) String startDate) {
		//변수 getStartDate를 선언하고
		//apprRequestService의 getStartDayCk에 startDate 를 입력하여 리턴 받은 값을 담아서 
		//getStartDate 를 리턴한다
		int getStartDate = apprRequestService.getStartDayCk(startDate);

		return getStartDate;

	}
	
	
	//holidayApproval.html에서 데이터들을 받는다
	@PostMapping("/holidayRequest")
	public String holidayRequest(ApprovalRequest approvalRequest,
			@RequestParam(value = "reStartDate", required = false) String reStartDate,
			@RequestParam(value = "reEndDate", required = false) String reEndDate,
			@RequestParam(value = "mrId", required = false) String mrId,
			@RequestParam(value = "mrName", required = false) String mrName,
			@RequestParam(value = "reReason", required = false) String reReason,
			@RequestParam(value = "holidaySt", required = false) String holidaySt) {
		
		//approvalRequest에 입력받은 값들을 셋팅한다
		approvalRequest.setMrId(mrId);
		approvalRequest.setReStartDate(reStartDate);
		approvalRequest.setReEndDate(reEndDate);
		approvalRequest.setSortation(holidaySt);
		approvalRequest.setReReason(reReason);
		apprRequestService.addholidayApproval(approvalRequest);
		
		
		// holidayApproval 으로 리다이렉트 한다
		return "redirect:/holidayApproval";

	}

	// 휴가요청 리스트
	@GetMapping("/holidayApproval")
	@PostMapping("/holidayApproval")
	public String getHolidayList(Model model) {

		List<ApprovalRequest> holidayList = apprRequestService.getHolidayList();
		model.addAttribute("holidayList", holidayList);

		return "workmanagment/holidayApproval";
	}

}
