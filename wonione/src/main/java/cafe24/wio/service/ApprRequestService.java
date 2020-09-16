package cafe24.wio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafe24.wio.bean.ApprovalRequest;
import cafe24.wio.mapper.ApprMapper;

@Service
public class ApprRequestService {

	
	@Autowired
	private ApprMapper apprMapper;
	
	public List<ApprovalRequest> getHolidayList() {
		
		List<ApprovalRequest> holliday = apprMapper.getHolidayList();
		
		
		return holliday;
	}
	

}
