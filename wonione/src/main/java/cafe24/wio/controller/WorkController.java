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
import cafe24.wio.service.ApprRequestService;

//황미현 - 출퇴근 컨트롤러

@Controller
public class WorkController {

	@Autowired
	private ApprRequestService apprRequestService;

	
	@GetMapping("/workAttendanceDetail")
	public String workAttendanceDetail(Model model, @RequestParam(value = "attCode", required = false) String attCode) {
		
		
		System.out.println(attCode + "attCode!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		
		
		AttManagement attManagementDetail = apprRequestService.getAttManagemetDetail(attCode);
		
		model.addAttribute("attManagementDetail", attManagementDetail);

		return "workmanagment/workAttendanceDetail";
	}
	
	@PostMapping("/workTimeDelete")
	public String workTimeDelete(@RequestParam(value = "mrId", required = false) String mrId) {

		apprRequestService.workTimeDelete(mrId);

		return "redirect:/attManage";
	}

	@GetMapping("/manageConfirm")
	public String manageConfirm(AttManagement attManagement,
			@RequestParam(value = "attCode", required = false) String attCode) {

		apprRequestService.manageConfirm(attCode);

		return "redirect:/attManage";
	}

	@PostMapping("/workTimeModify")
	public String workTimeModify(AttTimeManage attTimeManage,
			@RequestParam(value = "mrId", required = false) String mrId,
			@RequestParam(value = "workStTime", required = false) String workStTime,
			@RequestParam(value = "workEndTime", required = false) String workEndTime,
			@RequestParam(value = "mStTime", required = false) String mStTime,
			@RequestParam(value = "mEndTime", required = false) String mEndTime,
			@RequestParam(value = "note", required = false) String note) {

		attTimeManage.setMrId(mrId);
		attTimeManage.setWorkStTime(workStTime);
		attTimeManage.setWorkEndTime(workEndTime);
		
		workStTime = "0000-01-01 " + workStTime;
		workEndTime = "0000-01-01 " + workEndTime;
		
		float numWorkTime = apprRequestService.getWorkTime(workStTime,workEndTime);
		float mealTime = 0;

		if (mStTime == "" || mStTime == null || mEndTime == "" || mEndTime == null) {
			attTimeManage.setmStTime(null);
			attTimeManage.setmEndTime(null);
		} else {
			attTimeManage.setmStTime(mStTime);
			attTimeManage.setmEndTime(mEndTime);
			mStTime = "0000-01-01 " + mStTime;
			mEndTime = "0000-01-01 " + mEndTime;
			mealTime = apprRequestService.getMealTime(mStTime,mEndTime);
			attTimeManage.setMealTime(mealTime);
			numWorkTime = numWorkTime-mealTime;
		}


		String workTime = Float.toString(numWorkTime) + "시간";
		
		attTimeManage.setWorkTime(workTime);

		apprRequestService.workTimeModify(attTimeManage);

		return "redirect:/attManage";
	}

	
	@PostMapping("/workTimeStorage")
	public String workTimeStorage(AttTimeManage attTimeManage,
			@RequestParam(value = "mrId", required = false) String mrId,
			@RequestParam(value = "workStTime", required = false) String workStTime,
			@RequestParam(value = "workEndTime", required = false) String workEndTime,
			@RequestParam(value = "mStTime", required = false) String mStTime,
			@RequestParam(value = "mEndTime", required = false) String mEndTime,
			@RequestParam(value = "note", required = false) String note) {

		String getTimeCode = apprRequestService.getTimeCode();
		
		attTimeManage.setAttTimeCode(getTimeCode);
		attTimeManage.setMrId(mrId);
		attTimeManage.setWorkStTime(workStTime);
		attTimeManage.setWorkEndTime(workEndTime);
		
		workStTime = "0000-01-01 " + workStTime;
		workEndTime = "0000-01-01 " + workEndTime;
		
		
		float numWorkTime = apprRequestService.getWorkTime(workStTime,workEndTime);
		
		float mealTime = 0;

		if (mStTime == "" || mStTime == null || mEndTime == "" || mEndTime == null) {
			attTimeManage.setmStTime(null);
			attTimeManage.setmEndTime(null);
		} else {
			attTimeManage.setmStTime(mStTime);
			attTimeManage.setmEndTime(mEndTime);
			mStTime = "0000-01-01 " + mStTime;
			mEndTime = "0000-01-01 " + mEndTime;
			
			mealTime = apprRequestService.getMealTime(mStTime,mEndTime);
			attTimeManage.setMealTime(mealTime);
			
			numWorkTime = numWorkTime-mealTime;
		}
		
		String workTime = Float.toString(numWorkTime) + "시간";
		attTimeManage.setWorkTime(workTime);
		

		apprRequestService.addWorkTime(attTimeManage);

		return "redirect:/attManage";
	}

	@GetMapping(value = "/checkWorkTimeList", produces = "application/json")
	@ResponseBody
	public int checkWorkTimeList(@RequestParam(value = "mrId", required = false) String mrId) {

		int checkNum = apprRequestService.checkWorkTimeList(mrId);

		return checkNum;
	}

	// 직원 정보 불러오기
	@GetMapping(value = "/workerListDetail", produces = "application/json")
	@ResponseBody
	public AttTimeManage workerListDetail(@RequestParam(value = "mrId", required = false) String mrId) {
		AttTimeManage attTimeManage = apprRequestService.workerListDetail(mrId);
		if (attTimeManage == null) {
			attTimeManage = apprRequestService.nullList(mrId);
		}

		return attTimeManage;
	}

	@RequestMapping(value = "/attManage", method = { RequestMethod.GET, RequestMethod.POST })
	public String attManage(Model model) {

		List<Member> workerList = apprRequestService.getWorkerList();
		model.addAttribute("workerList", workerList);
		List<AttManagement> noConfirmList = apprRequestService.noConfirmList();
		model.addAttribute("noConfirmList", noConfirmList);

		List<AttManagement> confirmList = apprRequestService.confirmList();
		model.addAttribute("confirmList", confirmList);
		return "workmanagment/attManage";
	}

	@GetMapping("/goingOutEnd")
	public String goingOutEnd(AttManagement attManagement, HttpSession session) {
		String SID = (String) session.getAttribute("SID");
		String attCode = apprRequestService.getAttCode(SID);
		apprRequestService.goingOutEnd(attCode);
		
		float goingOut = apprRequestService.getGoingOutTime(attCode);
		
		int goingOutHH = (int) goingOut;

		if (goingOut % 1 < 0.5) {
			goingOut = (float) (goingOutHH + 0.5);
		} else {
			goingOut = goingOutHH + 1;
		}
		attManagement.setAttCode(attCode);
		attManagement.setGoingOut(goingOut);
		apprRequestService.setGoingOut(attManagement);

		return "redirect:/workAttendanceList";
	}

	@GetMapping("/workAttendanceEnd")
	public String workAttendanceEnd(AttManagement attManagement, HttpSession session) {
		String SID = (String) session.getAttribute("SID");
		String attCode = apprRequestService.getAttCode(SID);

		apprRequestService.setWorkEndTime(attCode);
		
		
		/* 지각,조퇴,외출 여부 구하고 비고란에 업데이트 */
		int late = apprRequestService.late(attCode);
		int earlyLeave = apprRequestService.earlyLeave(attCode);
		float outTime = apprRequestService.GoingOutTime(attCode);
		
		String note = "";
		if(late == 1) {
			note += "지각 ";
		}
		if(earlyLeave == 1) {
			note += "조퇴 ";
		}
		if(outTime >0) {
			note += "외출 ";
		}
		//------------------------------------------------------
		
		
		
		/* 근무시간 구하기 */
		float realWorkTime = apprRequestService.getAttEndTime(attCode);
		float getMealTime = apprRequestService.MealTime(SID);
		
		int notMealTime = apprRequestService.notMealTime(attCode);
		
		/* 만약 점심시간보다 늦게 출근 한 경우(리턴값 1) 일때 점심시간은 0 */
		if(notMealTime == 1) {
			getMealTime = 0;
		}
		//---------------------------------------------------
		
		int workTimeHH = (int) realWorkTime;
		
		if (realWorkTime % 1 < 0.5) {
			realWorkTime = workTimeHH;
			
		} else {
			realWorkTime = (float) (workTimeHH + 0.5);
		}
		
		System.out.println(realWorkTime + "------------->실제 근무 시간");
		//-------------------------------------------------------
		
		/* 초과 근무시간 구하기 */
		String ListWorkTime = apprRequestService.ListWorkTime(SID);
		float overWorkTime;
		float fListWorkTime = Float.parseFloat(ListWorkTime.substring(0, 3));
		realWorkTime = realWorkTime-outTime-getMealTime;
		System.out.println(realWorkTime + "------------->외출,점심 뺀 실제 근무 시간");
		
		if(realWorkTime > fListWorkTime) {
			overWorkTime = realWorkTime-fListWorkTime;
			attManagement.setWorkOvertime(overWorkTime);
			System.out.println(overWorkTime + "------------->초과 근무 시간");
		}
		attManagement.setAttCode(attCode);
		attManagement.setAttTime(realWorkTime);
		attManagement.setRealMealTime(getMealTime);
		attManagement.setAttNote(note);
		
		apprRequestService.setWorkTime(attManagement);
		//-------------------------------------------------
		
		
		
		
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
	/*
	 * @GetMapping("/holidayApproval")
	 * 
	 * @PostMapping("/holidayApproval")
	 * 
	 * public String getHolidayList(Model model) {
	 * 
	 * List<ApprovalRequest> holidayList = apprRequestService.getHolidayList();
	 * model.addAttribute("holidayList", holidayList);
	 * 
	 * return "workmanagment/holidayApproval"; }
	 */

	@GetMapping("/holidayApproval")
	@PostMapping("/holidayApproval")
	public String holiRequest(ApprovalRequest approvalRequest, Model model, HttpSession session) {

		String now = apprRequestService.getNow();
		now = now.substring(0, 10);
		System.out.println(now);
		approvalRequest.setReDate(now);
		String SID = (String) session.getAttribute("SID");
		String getPhone = apprRequestService.getMemberPhone(SID);
		model.addAttribute("getPhone", getPhone);
		List<ApprovalRequest> holidayList = apprRequestService.getHolidayList();
		model.addAttribute("holidayList", holidayList);

		return "workmanagment/holidayApproval";
	}

}
