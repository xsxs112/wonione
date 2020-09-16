package cafe24.wio.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cafe24.wio.controller.OfficersPayController;

@Mapper
public interface OfficersPayMapper {
	
	//직원 급여 목록 조회
	public List<OfficersPayController> getOfficersPayList();

	//직원급여명세서 조회
	public List<OfficersPayController> getOfficersPay();

}
