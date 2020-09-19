package cafe24.wio.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cafe24.wio.bean.OfficersPay;
import cafe24.wio.bean.StaffPay;

@Mapper
public interface PayMapper {
	
	//강사 급여 목록 조회
	public List<StaffPay> getStaffPayList();

	//직원 급여 목록 조회
	public List<OfficersPay> getOfficersPayList();

}
