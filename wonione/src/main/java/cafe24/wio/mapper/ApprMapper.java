package cafe24.wio.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cafe24.wio.bean.ApprovalRequest;

@Mapper
public interface ApprMapper {
	
	
	public List<ApprovalRequest>getHolidayList();

}
