package cafe24.wio.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafe24.wio.bean.ApprovalRequest;
import cafe24.wio.bean.AttManagement;
import cafe24.wio.bean.AttTimeManage;
import cafe24.wio.bean.Member;
import cafe24.wio.mapper.ApprMapper;

@Service
public class ApprRequestService {

	
	@Autowired
	private ApprMapper apprMapper;
	
	
	
	
	public float getModifyGoingOutTime(AttManagement attManagement) {
		
		
		return apprMapper.getModifyGoingOutTime(attManagement);
	}
	
	public float getRealWorkTime(String attStTime,String attEndTime) {
		
		
		return apprMapper.getRealWorkTime(attStTime,attEndTime);
	}
	
	public int attStTime(String stTime,String attCode) {
		
		
		return apprMapper.attStTime(stTime,attCode);
	}
	
	public AttManagement calculationTime(AttManagement attManagement) {
		
		
		return apprMapper.calculationTime(attManagement);
	}

	/* 삭제 후 외출시간 가져오기 */
	public AttManagement getDeleteGoingout(String attCode) {
		
		
		return apprMapper.getDeleteGoingout(attCode);
	}

	/* 외출시간 삭제 */
	public int deleteGoingOut(String attCode) {
		
		
		return apprMapper.deleteGoingOut(attCode);
	}

	/* confirm이 null인지 확인 */
	public String countConfirm(String attCode) {
		
		
		return apprMapper.countConfirm(attCode);
	}

	/* 업무시간 가져오기 */
	public AttTimeManage getAttTimeManage(String SID) {
		
		
		return apprMapper.getAttTimeManage(SID);
	}

	/* 수정 요청 내용 가져오기 */
	public String getModifyRequest(String attCode) {
		
		
		return apprMapper.getModifyRequest(attCode);
	}

	/* 출퇴근 정보 삭제 */
	public int deleteAttendance(String attCode) {
		
		
		return apprMapper.deleteAttendance(attCode);
	}
	
	/* 출퇴근 정보 수정 */
	public int attendanceModify(AttManagement attManagement) {
		
		
		return apprMapper.attendanceModify(attManagement);
	}

	/* 출퇴근 정보 수정 요청 */
	public int attendanceModifyRequest(String attCode,String reReason) {
		
		
		return apprMapper.attendanceModifyRequest(attCode,reReason);
	}
	
	
	/* 출퇴근 정보 상세보기 */
	public AttManagement getAttManagemetDetail(String attCode) {
		
		
		
		return apprMapper.getAttManagemetDetail(attCode);
	}

	/* 식사시간보다 늦게 출근한 경우 구하기 */
	public int notMealTime(String attCode) {
		
		
		
		return apprMapper.notMealTime(attCode);
	}

	/* 조퇴 유무 구하기 */
	public int earlyLeave(String attCode) {
		
		
		
		return apprMapper.earlyLeave(attCode);
	}

	/* 지각 유무 구하기 */
	public int late(String attCode) {
		
		
		
		return apprMapper.late(attCode);
	}
	
	/* 식사시간 가져오기 */
	public float MealTime(String SID) {
		
		
		
		return apprMapper.MealTime(SID);
	}
	
	/* 외출시간 구하기 */
	public float GoingOutTime(String attCode) {
		
		
		
		return apprMapper.GoingOutTime(attCode);
	}
	
	/* 출퇴근 관리 리스트에서 근무시간 가져오기 */
	public String ListWorkTime(String SID) {
		
		
		
		return apprMapper.ListWorkTime(SID);
	}

	/* 출퇴근 근무시간 가져오기 */
	public float getWorkTime(String workStTime, String workEndTime) {
		
		
		
		return apprMapper.getWorkTime(workStTime,workEndTime);
	}

	/* 식사시간 가져오기 */
	public float getMealTime(String mStTime,String mEndTime) {
		
		
		
		return apprMapper.getMealTime(mStTime,mEndTime);
	}

	/* 퇴근시간 저장 */
	public int setWorkEndTime(String attCode) {
		
		
		
		return apprMapper.setWorkEndTime(attCode);
	}

	/* 출근 리스트에서 근무 한 시간 업데이트 */
	public int setWorkTime(AttManagement attManagement) {
		
		
		
		return apprMapper.setWorkTime(attManagement);
	}
	
	/* 퇴근시간 - 출근시간 구하기 */
	public float getAttEndTime(String attCode) {
		
		
		
		return apprMapper.getAttEndTime(attCode);
	}
	
	/* 외출시간 저장 */
	public int setGoingOut(AttManagement attManagement) {
		
		
		
		
		return apprMapper.setGoingOut(attManagement);
	}
	
	
	/* 출퇴근 정보 확인 업데이트 */
	public int manageConfirm(String attCode, String confirm) {
		
		
		
		
		return apprMapper.manageConfirm(attCode, confirm);
	}
	
	
	
	/* 출퇴근 확인 리스트 */
	public List<AttManagement> confirmList() {
		
		List<AttManagement> confirmList = apprMapper.confirmList();
		
		
		return confirmList;
	}
	
	
	/* 출퇴근 확인 전 리스트 */
	public List<AttManagement> noConfirmList() {
		
		List<AttManagement> noConfirmList = apprMapper.noConfirmList();
		
		
		return noConfirmList;
	}
	
	
	/* 업무시간 삭제 */
	public int workTimeDelete(String mrId) {
		
		
		return apprMapper.workTimeDelete(mrId);
		
	}

	/* 업무시간 수정 */
	public int workTimeModify(AttTimeManage attTimeManage) {
		
		
		return apprMapper.workTimeModify(attTimeManage);
		
	}

	/* 업무시간 코드 생성 */
	public String getTimeCode() {
		
		Map<String, Object> timeCodeMax =  apprMapper.getTimeCode();
		
		String tempCode = "att_time_";
		int getMax = Integer.parseInt(timeCodeMax.get("max").toString());
		if(getMax<10) {
			tempCode = "att_time_0";
		}
		String timeCode = tempCode + String.valueOf(timeCodeMax.get("max"));
		
		return timeCode;
		
	}

	/* 업무시간 저장 */
	public int addWorkTime(AttTimeManage attTimeManage) {
		
		int checkNum = apprMapper.addWorkTime(attTimeManage);
		
		
		return checkNum;
		
	}
	
	/* 업무시간 정보가 있는 직원 */
	public int checkWorkTimeList(String mrId) {
		
		int checkNum = apprMapper.checkWorkTimeList(mrId);
		
		
		return checkNum;
		
	}
	
	/* 출퇴근 상세보기가 없을 때 */
	public AttTimeManage nullList(String mrId) {
		
		AttTimeManage attTimeManage = apprMapper.nullList(mrId);
		
		
		return attTimeManage;
		
	}
	
	/* 직원 업무시간 상세보기 */
	public AttTimeManage workerListDetail(String mrId) {
		
		AttTimeManage attTimeManage = apprMapper.workerListDetail(mrId);
		
		
		return attTimeManage;
		
	}
	
	/* 관리자 화면 출퇴근 관리 직원 리스트 가져오기 */
	public List<Member> getWorkerList() {
		
		List<Member> getWorkerList = apprMapper.getWorkerList();
		
		
		return getWorkerList;
	}
	
	/* 복귀시간 저장 */
	public int goingOutEnd(String attCode) {
		
		return apprMapper.goingOutEnd(attCode);
	}
	
	/* 퇴근시간 저장 */
	public int workAttendanceEnd(String attCode) {
		
		return apprMapper.workAttendanceEnd(attCode);
	}
	
	/* 출근 중복 확인 */
	public int dateCheck(String sid) {
		
		return apprMapper.dateCheck(sid);
	}
	
	/* 외출시간 저장 */
	public int goingStOut(String attCode) {
	
		return apprMapper.goingStOut(attCode);
	}
	
	
	//출퇴근 코드 가져오기
	public String getAttCode(String SID) {
	
		return apprMapper.getAttCode(SID);
	}
	
	
	public int addAttendance(AttManagement attManagement) {
		
		return apprMapper.addAttendance(attManagement);
	}
	
	
	public String getAttMaxCode() {
		
		Map<String, Object> attCodeMax =  apprMapper.getAttMaxCode();
		String tempCode = "attendance_";
		int getMax = Integer.parseInt(attCodeMax.get("max").toString());
		if(getMax<10) {
			tempCode = "attendance_0";
		}
		String attCode = tempCode + String.valueOf(attCodeMax.get("max"));
		return attCode;
	
	}
	
	public float getGoingOutTime(String attCode) {
		
		return apprMapper.getGoingOutTime(attCode);
	}
	
	
	public List<AttManagement> getAttendanceList(String SID) {
		
		List<AttManagement> getAttendanceList = apprMapper.getAttendanceList(SID);
		
		
		return getAttendanceList;
	}
	
	public String getLevelName(String reCode) {
		
		return apprMapper.getLevelName(reCode);
	}
	
	
	public String getMemberPhone(String reCode) {
		
		return apprMapper.getMemberPhone(reCode);
	}
	
	
	public String getNow() {
		
		
		return apprMapper.getNow();
	}
	
	
	
	public ApprovalRequest getHolidayDetail(String reCode) {
		
		
		return apprMapper.getHolidayDetail(reCode);
	}
	
	public int reDelete(String reCode) {
		
		
		return apprMapper.reDelete(reCode);
	}
	
	
	/* ?? */
	public int approval(ApprovalRequest approvalRequest) {
		
		
		return apprMapper.approval(approvalRequest);
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
	
	//휴가코드 자동생성
	public String getReCode() {
		Map<String, Object> reCodeMax =  apprMapper.getReCode();
		
		String tempCode = "request_";
		
		//reCodeMax 에서 가져온 "max"는 처음에 데이터타입이 String이고 그걸 Integer.parseInt로 int 타입으로 바꿔준거니까
		//int형으로 변환하기전에 String으로 담아서 가져온 max값이 null인지 확인하고 null이라면 숫자 getMax는 1로 바꿔줘요
		int getMax = Integer.parseInt(reCodeMax.get("max").toString());
		
		
		if(getMax<10) {
			tempCode = "request_0";
		}
		String reCode = tempCode + String.valueOf(reCodeMax.get("max"));
		System.out.println("reCode ------------> " + reCode);
		
		return reCode;
	}
	
	//휴가생성
	public int addholidayApproval(ApprovalRequest approvalRequest) {
		
		
		approvalRequest.setReCode(getReCode());

		int result = apprMapper.addholidayApproval(approvalRequest);
		
		
		return result;
	}


	
	

}
