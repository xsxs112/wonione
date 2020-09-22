package cafe24.wio.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cafe24.wio.bean.ApprovalRequest;
import cafe24.wio.bean.Member;

@Mapper
public interface ApprMapper {
	
	
	public int approval(ApprovalRequest approvalRequest);
	
	
	public int hListDuplicate(String startDate,String endDate);
	
	
	public List<Map<String, Object>> getHolidayListTest();
	
	
	public int getStartDayCk(String startDate);
	
	
	public Map<String, Object> getReCode();
	
	//휴가신청 추가
	public int addholidayApproval(ApprovalRequest approvalRequest);
	
	//회원 정보 조회
	public Member getMemberById(String mrId);
	
	
	public List<ApprovalRequest>getHolidayList();

}
