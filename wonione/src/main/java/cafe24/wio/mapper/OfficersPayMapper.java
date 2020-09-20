package cafe24.wio.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cafe24.wio.bean.OfficersPay;

@Mapper
public interface OfficersPayMapper {

	//직원급여명세서 조회
	public List<OfficersPay> getOfficersPay(String mrId);

	//직원 목록 조회
	public List<OfficersPay> getOfficersList();
	
	//자원테이블 호출
	public List<OfficersPay> standardSheet();

	//직원 정보 조회
	public OfficersPay callOfficersInfo(String mrId);

	//직원정보 급여계 넘기기
	public OfficersPay officersFoinForm(String mrId);

}
