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
	
	
	public int workTimeDelete(String mrId) {
		
		
		return apprMapper.workTimeDelete(mrId);
		
	}
	
	public int workTimeModify(AttTimeManage attTimeManage) {
		
		
		return apprMapper.workTimeModify(attTimeManage);
		
	}
	
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
	
	public int addWorkTime(AttTimeManage attTimeManage) {
		
		int checkNum = apprMapper.addWorkTime(attTimeManage);
		
		
		return checkNum;
		
	}
	
	
	public int checkWorkTimeList(String mrId) {
		
		int checkNum = apprMapper.checkWorkTimeList(mrId);
		
		
		return checkNum;
		
	}
	
	
	public AttTimeManage nullList(String mrId) {
		
		AttTimeManage attTimeManage = apprMapper.nullList(mrId);
		
		
		return attTimeManage;
		
	}
	
	public AttTimeManage workerListDetail(String mrId) {
		
		AttTimeManage attTimeManage = apprMapper.workerListDetail(mrId);
		
		
		return attTimeManage;
		
	}
	
	
	public List<Member> getWorkerList() {
		
		List<Member> getWorkerList = apprMapper.getWorkerList();
		
		
		return getWorkerList;
	}
	
	
	public int goingOutEnd(String attCode) {
		
		return apprMapper.goingOutEnd(attCode);
	}
	
	public int workAttendanceEnd(String attCode) {
		
		return apprMapper.workAttendanceEnd(attCode);
	}
	
	public int dateCheck(String sid) {
		
		return apprMapper.dateCheck(sid);
	}
	
	
	public int goingStOut(String attCode) {
	
		return apprMapper.goingStOut(attCode);
	}
	
	
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
	
	public int addholidayApproval(ApprovalRequest approvalRequest) {
		
		
		approvalRequest.setReCode(getReCode());

		int result = apprMapper.addholidayApproval(approvalRequest);
		
		
		return result;
	}


	
	

}
