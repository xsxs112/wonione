package cafe24.wio.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cafe24.wio.bean.ApprovalRequest;
import cafe24.wio.bean.AttManagement;
import cafe24.wio.bean.AttTimeManage;
import cafe24.wio.bean.Member;
import cafe24.wio.bean.OfficersPay;
import cafe24.wio.service.ApprRequestService;

//황미현 - 출퇴근 컨트롤러

@Controller
public class WorkController {

	@Autowired
	private ApprRequestService apprRequestService;

	
	
	
	
	
	@PostMapping("/workTimeDelete")
	public String workTimeDelete(@RequestParam(value = "mrId", required = false) String mrId) {
		
		apprRequestService.workTimeDelete(mrId);
		

		return "redirect:/attManage";
	}
	
	
	
	
	
	@PostMapping("/workTimeModify")
	public String workTimeModify(AttTimeManage attTimeManage,@RequestParam(value = "mrId", required = false) String mrId
															,@RequestParam(value = "workStTime", required = false) String workStTime
															,@RequestParam(value = "workEndTime", required = false) String workEndTime
															,@RequestParam(value = "mStTime", required = false) String mStTime
															,@RequestParam(value = "mEndTime", required = false) String mEndTime
															,@RequestParam(value = "note", required = false) String note) {
		
		
		attTimeManage.setMrId(mrId);
		attTimeManage.setWorkStTime(workStTime);
		attTimeManage.setWorkEndTime(workEndTime);
		attTimeManage.setmStTime(mStTime);
		attTimeManage.setmEndTime(mEndTime);
		
		apprRequestService.workTimeModify(attTimeManage);
	
		
		
		return "redirect:/attManage";
	}
	
	@PostMapping("/workTimeStorage")
	public String workTimeStorage(AttTimeManage attTimeManage,@RequestParam(value = "mrId", required = false) String mrId
															,@RequestParam(value = "workStTime", required = false) String workStTime
															,@RequestParam(value = "workEndTime", required = false) String workEndTime
															,@RequestParam(value = "mStTime", required = false) String mStTime
															,@RequestParam(value = "mEndTime", required = false) String mEndTime
															,@RequestParam(value = "note", required = false) String note) {
		
		
		String getTimeCode = apprRequestService.getTimeCode();
		
		
		if(mStTime == "" || mStTime == null ||mEndTime == "" || mEndTime == null ) {
			attTimeManage.setmStTime(null);
			attTimeManage.setmEndTime(null);
		}else {
			attTimeManage.setmStTime(mStTime);
			attTimeManage.setmEndTime(mEndTime);
		}
		
		attTimeManage.setAttTimeCode(getTimeCode);
		attTimeManage.setMrId(mrId);
		attTimeManage.setWorkStTime(workStTime);
		attTimeManage.setWorkEndTime(workEndTime);
	
		
		
		
		apprRequestService.addWorkTime(attTimeManage);
		
		
		
		
		//"redirect:/holidayApproval"
		return "redirect:/attManage";
	}
	
	
	@GetMapping(value = "/checkWorkTimeList",produces = "application/json")
	@ResponseBody
	public int checkWorkTimeList(@RequestParam(value = "mrId", required = false) String mrId) {
		
		int checkNum = apprRequestService.checkWorkTimeList(mrId);
		
		
		
		return checkNum;
	}
	
	
	
	//직원 정보 불러오기
	@GetMapping(value = "/workerListDetail",produces = "application/json")
	@ResponseBody
	public AttTimeManage workerListDetail(@RequestParam(value = "mrId", required = false) String mrId) {
		AttTimeManage attTimeManage = apprRequestService.workerListDetail(mrId);
		if(attTimeManage == null) {
			attTimeManage = apprRequestService.nullList(mrId);
		}
		
		
		return attTimeManage;
	}
	
	
	
	@RequestMapping(value="/attManage" , method = {RequestMethod.GET, RequestMethod.POST})
	public String workAttendanceList2(Model model) {
		
		List<Member> workerList = apprRequestService.getWorkerList();
		model.addAttribute("workerList", workerList);

		return "workmanagment/attManage";
	}
	
	@GetMapping("/goingOutEnd")
	public String goingOutEnd(AttManagement attManagement, HttpSession session) {
		String SID = (String) session.getAttribute("SID");
		String attCode = apprRequestService.getAttCode(SID);
		apprRequestService.goingOutEnd(attCode);

		return "redirect:/workAttendanceList";
	}
	
	
	
	@GetMapping("/workAttendanceEnd")
	public String workAttendanceEnd(AttManagement attManagement, HttpSession session) {
		String SID = (String) session.getAttribute("SID");
		String attCode = apprRequestService.getAttCode(SID);
		
		apprRequestService.workAttendanceEnd(attCode);

		return "redirect:/workAttendanceList";
	}
	
	
	
	@ResponseBody
	@GetMapping("/dateCheck")
	public int dateCheck(HttpSession session, @RequestParam(value = "sid", required = false) String sid) {

		int nowDate = apprRequestService.dateCheck(sid);

		return nowDate;
	}

	@GetMapping("/workAttendance")
	public String workAttendance(Model model, AttManagement attManagement, HttpSession session) {
		String sid = (String) session.getAttribute("SID");
		String attCode = apprRequestService.getAttMaxCode();
		session.setAttribute("ATTCODE", attCode);
		attManagement.setAttCode(attCode);
		attManagement.setMrId(sid);
		apprRequestService.addAttendance(attManagement);

		return "redirect:/workAttendanceList";
	}

	@GetMapping("/goingStOut")
	public String goingOut(AttManagement attManagement, HttpSession session) {

		String SID = (String) session.getAttribute("SID");
		String attCode = apprRequestService.getAttCode(SID);
		apprRequestService.goingStOut(attCode);

		return "redirect:/workAttendanceList";
	}

	@GetMapping("/workAttendanceList")
	public String workAttendanceList(Model model, AttManagement attManagement, HttpSession session) {

		String sid = (String) session.getAttribute("SID");
		List<AttManagement> getAttendanceList = apprRequestService.getAttendanceList(sid);
		System.out.println(getAttendanceList);

		model.addAttribute("getAttendanceList", getAttendanceList);

		return "workmanagment/workAttendance";
	}

	@GetMapping("/holiRequest")
	public String holiRequest(ApprovalRequest approvalRequest, Model model,
			@RequestParam(value = "reCode", required = false) String reCode) {

		String now = apprRequestService.getNow();
		now = now.substring(0, 10);
		System.out.println(now);
		approvalRequest.setReDate(now);
		String getPhone = apprRequestService.getMemberPhone(reCode);
		model.addAttribute("getPhone", getPhone);

		return "workmanagment/holidayRequest";
	}

	// 상세보기
	@GetMapping("/detail")
	public String detail(Model model, @RequestParam(value = "reCode", required = false) String reCode) {

		ApprovalRequest holidayDetail = apprRequestService.getHolidayDetail(reCode);
		model.addAttribute("holidayDetail", holidayDetail);

		return "workmanagment/holidayDetail";
	}

	// 관리자 화면 삭제
	@GetMapping("/reDelete")
	public String reDelete(Model model, @RequestParam(value = "reCode", required = false) String reCode) {

		apprRequestService.reDelete(reCode);

		return "redirect:/holidayList";
	}

	// 관리자화면 휴가 승인
	@GetMapping("/approval")
	public String approval(ApprovalRequest approvalRequest,
			@RequestParam(value = "reState", required = false) String reState,
			@RequestParam(value = "reCode", required = false) String reCode,
			@RequestParam(value = "inputRefuse", required = false) String inputRefuse, HttpSession session) {
		approvalRequest.setReState(reState);
		approvalRequest.setReCode(reCode);
		String supervisor = (String) session.getAttribute("SNAME");
		approvalRequest.setReSupervisor(supervisor);
		approvalRequest.setRefuseReason(inputRefuse);
		apprRequestService.approval(approvalRequest);

		return "redirect:/holidayList";

	}

	// 관리자 화면 휴가요청 리스트
	@GetMapping("/holidayList")
	public String holidayList(Model model) {

		List<ApprovalRequest> holidayList = apprRequestService.getHolidayList();
		model.addAttribute("holidayList", holidayList);

		return "workmanagment/holidayList";
	}

	// 휴가 중복 체크
	@ResponseBody
	@GetMapping("/holidayCk")
	// holidayApproval.html에서 startDate,endDate 값을 받는다
	public int holidayCk(@RequestParam(value = "startDate", required = false) String startDate,
			@RequestParam(value = "endDate", required = false) String endDate) {

		int holidayCk = 1;

		holidayCk = apprRequestService.hListDuplicate(startDate, endDate);

		return holidayCk;

	}

	// holidayApproval.html에서 startDate값을 받는다
	@ResponseBody
	@GetMapping("/startDayCk")
	public int startDayCk(@RequestParam(value = "startDate", required = false) String startDate) {
		// 변수 getStartDate를 선언하고
		// apprRequestService의 getStartDayCk에 startDate 를 입력하여 리턴 받은 값을 담아서
		// getStartDate 를 리턴한다
		int getStartDate = apprRequestService.getStartDayCk(startDate);

		return getStartDate;

	}

	// holidayApproval.html에서 데이터들을 받는다
	@PostMapping("/holidayRequest")
	public String holidayRequest(ApprovalRequest approvalRequest, HttpSession session,
			@RequestParam(value = "reStartDate", required = false) String reStartDate,
			@RequestParam(value = "reEndDate", required = false) String reEndDate,
			@RequestParam(value = "mrId", required = false) String mrId,
			@RequestParam(value = "mrName", required = false) String mrName,
			@RequestParam(value = "reReason", required = false) String reReason,
			@RequestParam(value = "holidaySt", required = false) String holidaySt) {

		// approvalRequest에 입력받은 값들을 셋팅한다
		String sname = (String) session.getAttribute("SNAME");
		System.out.println(sname + "snamedndndsnfkjdsh");
		System.out.println(mrName + "mrNamesssssssssss");
		System.out.println(mrId + "mrId");

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
