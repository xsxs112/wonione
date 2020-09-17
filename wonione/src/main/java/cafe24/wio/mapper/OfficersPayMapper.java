package cafe24.wio.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cafe24.wio.controller.OfficersPayController;

@Mapper
public interface OfficersPayMapper {
	
	//직원 급여 목록 조회
	public List<OfficersPayController> getOfficersPayList();

	//직원급여명세서 조회
	public List<OfficersPayController> getOfficersPay(String mrId);

	//직원 목록 조회
	public List<OfficersPayController> getOfficersList();

	//직원 정보 조회
	public List<OfficersPayController> callOfficersInfo(String mrId);

}
