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

	
	@PostMapping(value = "/calculationTime", produces = "application/json")
	@ResponseBody
	public AttManagement calculationTime(AttManagement attManagement,@RequestParam(value = "attStTime", required = false) String attStTime,
											@RequestParam(value = "attEndTime", required = false) String attEndTime,
											@RequestParam(value = "goingOutStTime", required = false) String goingOutStTime,
											@RequestParam(value = "goingOutEndTime", required = false) String goingOutEndTime,
											@RequestParam(value = "realMealTime", required = false) String realMealTime) {
		
		attManagement.setAttStTime("1996-12-18 " + attStTime);
		attManagement.setAttEndTime("1996-12-18 " + attEndTime);
		attManagement.setGoingOutStTime("1996-12-18 " +goingOutStTime);
		attManagement.setGoingOutEndTime("1996-12-18 " +goingOutEndTime);
		//식사시간 구하기
		float floatrealMealTime = Float.valueOf(realMealTime);
		if(realMealTime == null) {
			attManagement.setRealMealTime(0);
		}else {
			attManagement.setRealMealTime(floatrealMealTime);
		}
		//----------------------------------------------------------------------
		
		//외출시간 구하기
		float goingOut = 0;
		if("".equals(goingOutStTime) || "".equals(goingOutEndTime)) {
			attManagement.setGoingOut(goingOut);
		}
		AttManagement calculationTime = apprRequestService.calculationTime(attManagement);
		
		
		
		return calculationTime;
	}
	
	
	
	
	/*
	 * //외출시간 삭제
	 * 
	 * @GetMapping(value = "/deleteGoingOut", produces = "application/json")
	 * 
	 * @ResponseBody public AttManagement deleteGoingOut(@RequestParam(value =
	 * "attCode", required = false) String attCode) {
	 * 
	 * 
	 * apprRequestService.deleteGoingOut(attCode); AttManagement getDeleteGoingout =
	 * apprRequestService.getDeleteGoingout(attCode);
	 * 
	 * return getDeleteGoingout; }
	 */
	
	
	//출퇴근 정보수정 요청
	@GetMapping("/getModifyRequest")
	@ResponseBody
	public String getModifyRequest(@RequestParam(value = "attCode", required = false) String attCode) {
		String modifyRequest = apprRequestService.getModifyRequest(attCode);
		
		return modifyRequest;
	}
	
	//출퇴근 정보 삭제
	@GetMapping("/deleteAttendance")
	public String deleteAttendance(@RequestParam(value = "attCode", required = false) String attCode) {
		apprRequestService.deleteAttendance(attCode);
		
		return "redirect:/addAttManage";
	}
	
	
	//출퇴근 정보 수정
	@PostMapping("/attendanceModify")
	public String attendanceModify(AttManagement attManagement ,@RequestParam(value = "attCode", required = false) String attCode
									,@RequestParam(value = "attStTime", required = false) String attStTime
									,@RequestParam(value = "attEndTime", required = false) String attEndTime
									,@RequestParam(value = "realMealTime", required = false) float realMealTime
									,@RequestParam(value = "goingOutStTime", required = false) String goingOutStTime
									,@RequestParam(value = "goingOutEndTime", required = false) String goingOutEndTime
									,@RequestParam(value = "goingOut", required = false) float goingOut
									,@RequestParam(value = "attTime", required = false) float attTime
									,@RequestParam(value = "workOvertime", required = false) float workOvertime
									,@RequestParam(value = "attNote", required = false) String attNote) {
		
		
		attManagement.setAttCode(attCode);
		attManagement.setAttStTime(attStTime);
		attManagement.setAttEndTime(attEndTime);
		attManagement.setRealMealTime(realMealTime);
		if(goingOutStTime == "") {
			goingOutStTime = null;
		}
		if(goingOutEndTime == "") {
			goingOutEndTime = null;
		}
		
		attManagement.setGoingOutStTime(goingOutStTime);
		attManagement.setGoingOutEndTime(goingOutEndTime);
		attManagement.setGoingOut(goingOut);
		attManagement.setAttTime(attTime);
		attManagement.setWorkOvertime(workOvertime);
		attManagement.setAttNote(attNote);
		
		
		apprRequestService.attendanceModify(attManagement);
		
		
		
		return "redirect:/addAttManage";
	}
	
	
	
	//출퇴근 정보 수정화면
	@GetMapping("/modifyAttendance")
	public String modifyAttendance(Model model, AttTimeManage attTimeManage,HttpSession session,
									@RequestParam(value = "attCode", required = false) String attCode) {
		
		AttManagement attManagementDetail = apprRequestService.getAttManagemetDetail(attCode);
		model.addAttribute("attManagementDetail", attManagementDetail);
		
		String sid = (String) session.getAttribute("SID");
		AttTimeManage getAttTimeManage = apprRequestService.getAttTimeManage(sid);
		
		String getStTime;
		String getMTime;
		String getWorkTime;
		
		if(getAttTimeManage == null ) {
			getStTime = "정보 없음";
			getMTime = "정보 없음";
			getWorkTime = "정보 없음";
		}else {
			if(getAttTimeManage.getmStTime()==null || "".equals(getAttTimeManage.getmStTime()==null)
					|| getAttTimeManage.getmEndTime() ==null || "".equals(getAttTimeManage.getmEndTime())) {
				getMTime = "정보 없음";
			}else {
				getMTime = getAttTimeManage.getmStTime().substring(0, 5) +" ~ " + getAttTimeManage.getmEndTime().substring(0, 5);

			}
			getStTime = getAttTimeManage.getWorkStTime().substring(0, 5) +" ~ " + getAttTimeManage.getWorkEndTime().substring(0, 5);
			getWorkTime = getAttTimeManage.getWorkTime();

		}
		attTimeManage.setWorkStTime(getStTime);
		attTimeManage.setmStTime(getMTime);
		attTimeManage.setWorkTime(getWorkTime);
		
		
		model.addAttribute("attTimeManage", attTimeManage);
		
		
		return "workmanagment/modifyAttendance";
	}
	
	
	/*
	 * @GetMapping("/workAttendanceList") public String workAttenkdanceList(Model
	 * model, AttManagement attManagement, AttTimeManage attTimeManage, HttpSession
	 * session) {
	 * 
	 * String sid = (String) session.getAttribute("SID"); List<AttManagement>
	 * getAttendanceList = apprRequestService.getAttendanceList(sid); AttTimeManage
	 * getAttTimeManage = apprRequestService.getAttTimeManage(sid);
	 * 
	 * String getStTime; String getMTime; String getWorkTime;
	 * 
	 * if(getAttTimeManage == null ) { getStTime = "정보 없음"; getMTime = "정보 없음";
	 * getWorkTime = "정보 없음"; }else { if(getAttTimeManage.getmStTime()==null ||
	 * "".equals(getAttTimeManage.getmStTime()==null) ||
	 * getAttTimeManage.getmEndTime() ==null ||
	 * "".equals(getAttTimeManage.getmEndTime())) { getMTime = "정보 없음"; }else {
	 * getMTime = getAttTimeManage.getmStTime().substring(0, 5) +" ~ " +
	 * getAttTimeManage.getmEndTime().substring(0, 5);
	 * 
	 * } getStTime = getAttTimeManage.getWorkStTime().substring(0, 5) +" ~ " +
	 * getAttTimeManage.getWorkEndTime().substring(0, 5); getWorkTime =
	 * getAttTimeManage.getWorkTime();
	 * 
	 * } attTimeManage.setWorkStTime(getStTime); attTimeManage.setmStTime(getMTime);
	 * attTimeManage.setWorkTime(getWorkTime);
	 * 
	 * 
	 * 
	 * model.addAttribute("getAttendanceList", getAttendanceList);
	 * model.addAttribute("attTimeManage", attTimeManage);
	 * 
	 * return "workmanagment/workAttendance"; }
	 */
	
	
	
	
	
	
	/*
	 * @GetMapping("/modifyAttendance") public String modifyAttendance(Model
	 * model, @RequestParam(value = "attCode", required = false) String attCode) {
	 * 
	 * AttManagement attManagementDetail =
	 * apprRequestService.getAttManagemetDetail(attCode);
	 * model.addAttribute("attManagementDetail", attManagementDetail);
	 * 
	 * 
	 * return "workmanagment/modifyAttendance"; }
	 */
	
	
	//출퇴근 정보 수정 요청
	@PostMapping("/attendanceModifyRequest")
	public String attendanceModifyRequest(@RequestParam(value = "reReason", required = false) String reReason,
			@RequestParam(value = "attCode", required = false) String attCode) {

		apprRequestService.attendanceModifyRequest(attCode, reReason);

		return "redirect:/workAttendanceList";
	}

	//출퇴근 정보 상세보기
	@GetMapping("/workAttendanceDetail")
	public String workAttendanceDetail(Model model, @RequestParam(value = "attCode", required = false) String attCode) {

		AttManagement attManagementDetail = apprRequestService.getAttManagemetDetail(attCode);

		model.addAttribute("attManagementDetail", attManagementDetail);

		return "workmanagment/workAttendanceDetail";
	}

	//업무시간 삭제
	@PostMapping("/workTimeDelete")
	public String workTimeDelete(@RequestParam(value = "mrId", required = false) String mrId) {

		apprRequestService.workTimeDelete(mrId);

		return "redirect:/addAttManage";
	}
	
	//관리자 확인
	@GetMapping("/manageConfirm")
	public String manageConfirm(AttManagement attManagement,
			@RequestParam(value = "attCode", required = false) String attCode) {
		String confirm = apprRequestService.countConfirm(attCode);
		if(confirm != null) {
			confirm += ", 확인";
		}else {
			
			confirm = "확인";
		}
		
		
		apprRequestService.manageConfirm(attCode,confirm);
		return "redirect:/addAttManage";
	}
	
	//업무시간 수정
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

		float numWorkTime = apprRequestService.getWorkTime(workStTime, workEndTime);
		float mealTime = 0;

		if (mStTime == "" || mStTime == null || mEndTime == "" || mEndTime == null) {
			attTimeManage.setmStTime(null);
			attTimeManage.setmEndTime(null);
		} else {
			attTimeManage.setmStTime(mStTime);
			attTimeManage.setmEndTime(mEndTime);
			mStTime = "0000-01-01 " + mStTime;
			mEndTime = "0000-01-01 " + mEndTime;
			mealTime = apprRequestService.getMealTime(mStTime, mEndTime);
			attTimeManage.setMealTime(mealTime);
			numWorkTime = numWorkTime - mealTime;
		}

		String workTime = Float.toString(numWorkTime) + "시간";

		attTimeManage.setWorkTime(workTime);

		apprRequestService.workTimeModify(attTimeManage);

		return "redirect:/addAttManage";
	}
	
	//업무시간 저장
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

		float numWorkTime = apprRequestService.getWorkTime(workStTime, workEndTime);

		float mealTime = 0;

		if (mStTime == "" || mStTime == null || mEndTime == "" || mEndTime == null) {
			attTimeManage.setmStTime(null);
			attTimeManage.setmEndTime(null);
		} else {
			attTimeManage.setmStTime(mStTime);
			attTimeManage.setmEndTime(mEndTime);
			mStTime = "0000-01-01 " + mStTime;
			mEndTime = "0000-01-01 " + mEndTime;

			mealTime = apprRequestService.getMealTime(mStTime, mEndTime);
			attTimeManage.setMealTime(mealTime);

			numWorkTime = numWorkTime - mealTime;
		}

		String workTime = Float.toString(numWorkTime) + "시간";
		attTimeManage.setWorkTime(workTime);

		apprRequestService.addWorkTime(attTimeManage);

		return "redirect:/addAttManage";
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
	
	//출퇴근 관리 리스트
	@RequestMapping(value = "/addAttManage", method = { RequestMethod.GET, RequestMethod.POST })
	public String attManage(Model model) {

		List<Member> workerList = apprRequestService.getWorkerList();
		model.addAttribute("workerList", workerList);
		List<AttManagement> noConfirmList = apprRequestService.noConfirmList();
		model.addAttribute("noConfirmList", noConfirmList);

		List<AttManagement> confirmList = apprRequestService.confirmList();
		model.addAttribute("confirmList", confirmList);
		return "workmanagment/addAttManage";
	}
	
	//복귀시각, 외출 시간 구하기
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

		//apprRequestService.setWorkEndTime(attCode);

		/* 지각,조퇴,외출 여부 구하고 비고란에 업데이트 */
		int late = apprRequestService.late(attCode);
		int earlyLeave = apprRequestService.earlyLeave(attCode);
		float outTime = apprRequestService.GoingOutTime(attCode);

		String note = "";
		if (late == 1) {
			note += "지각 ";
		}
		if (earlyLeave == 1) {
			note += "조퇴 ";
		}
		if (outTime > 0) {
			note += "외출 ";
		}
		// ------------------------------------------------------

		/* 근무시간 구하기 */
		float realWorkTime = apprRequestService.getAttEndTime(attCode);
		
		
		float getMealTime = apprRequestService.MealTime(SID);
		/* 만약 점심시간보다 늦게 출근 한 경우(리턴값 1) 일때 점심시간은 0 */
		if(getMealTime > 0) {
			int notMealTime = apprRequestService.notMealTime(attCode);
			if (notMealTime == 1) {
				getMealTime = 0;
			}
		}
		// ---------------------------------------------------

		int workTimeHH = (int) realWorkTime;

		if (realWorkTime % 1 < 0.5) {
			realWorkTime = workTimeHH;

		} else {
			realWorkTime = (float) (workTimeHH + 0.5);
		}

		// -------------------------------------------------------

		/* 초과 근무시간 구하기 */
		String ListWorkTime = apprRequestService.ListWorkTime(SID);
		float overWorkTime;
		float fListWorkTime = Float.parseFloat(ListWorkTime.substring(0, 3));
		realWorkTime = realWorkTime - outTime - getMealTime;
		System.out.println(realWorkTime + "------------->외출,점심 뺀 실제 근무 시간");

		if (realWorkTime > fListWorkTime) {
			overWorkTime = realWorkTime - fListWorkTime;
			attManagement.setWorkOvertime(overWorkTime);
			note += "초과 근무 ";
			System.out.println(overWorkTime + "------------->초과 근무 시간");
		}
		attManagement.setAttCode(attCode);
		attManagement.setAttTime(realWorkTime);
		attManagement.setRealMealTime(getMealTime);
		attManagement.setAttNote(note);

		apprRequestService.setWorkTime(attManagement);
		// -------------------------------------------------

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
	
	//출퇴근 리스트에서 업무시간
	@GetMapping("/workAttendanceList")
	public String workAttendanceList(Model model, AttManagement attManagement, AttTimeManage attTimeManage, HttpSession session) {

		String sid = (String) session.getAttribute("SID");
		List<AttManagement> getAttendanceList = apprRequestService.getAttendanceList(sid);
		AttTimeManage getAttTimeManage = apprRequestService.getAttTimeManage(sid);
		
		String getStTime;
		String getMTime;
		String getWorkTime;
		
		if(getAttTimeManage == null ) {
			getStTime = "정보 없음";
			getMTime = "정보 없음";
			getWorkTime = "정보 없음";
		}else {
			if(getAttTimeManage.getmStTime()==null || "".equals(getAttTimeManage.getmStTime()==null)
					|| getAttTimeManage.getmEndTime() ==null || "".equals(getAttTimeManage.getmEndTime())) {
				getMTime = "정보 없음";
			}else {
				getMTime = getAttTimeManage.getmStTime().substring(0, 5) +" ~ " + getAttTimeManage.getmEndTime().substring(0, 5);

			}
			getStTime = getAttTimeManage.getWorkStTime().substring(0, 5) +" ~ " + getAttTimeManage.getWorkEndTime().substring(0, 5);
			getWorkTime = getAttTimeManage.getWorkTime();

		}
		attTimeManage.setWorkStTime(getStTime);
		attTimeManage.setmStTime(getMTime);
		attTimeManage.setWorkTime(getWorkTime);
		
		
		
		model.addAttribute("getAttendanceList", getAttendanceList);
		model.addAttribute("attTimeManage", attTimeManage);

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
		System.out.println(holidaySt + " <<<<holidaySt");
		approvalRequest.setMrId(mrId);
		approvalRequest.setReStartDate(reStartDate);
		approvalRequest.setReEndDate(reEndDate);
		approvalRequest.setSortation(holidaySt);
		approvalRequest.setReReason(reReason);
		apprRequestService.addholidayApproval(approvalRequest);

		// holidayApproval 으로 리다이렉트 한다
		return "redirect:/holidayApproval";

	}

	@GetMapping("/holidayApproval")
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
