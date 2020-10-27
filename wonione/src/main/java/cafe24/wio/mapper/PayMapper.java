package cafe24.wio.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cafe24.wio.bean.OfficersPay;
import cafe24.wio.bean.StaffPay;

@Mapper
public interface PayMapper {
	
	//1. 직원급여 테이블 삭제
	public int removeOP(String opCode);
	//2. 직원급여 공제계 테이블 삭제
	public int removeOPD(String opCode);
	//3. 직원급여 급여계 테이블 삭제
	public int removeOPC(String opCode);
	
	//수정, 삭제 할 직원 급여정보 가져오기
	public OfficersPay getOPCode(String opCode);
	
	//1. 강사급여 테이블 삭제
	public int removeSP(String spCode);
	//2. 강사급여 공제계 테이블 삭제
	public int removeSPD(String spCode);
	//3. 강사급여 급여계 테이블 삭제
	public int removeSPC(String spCode);
	
	//수정, 삭제 할 강사 급여정보 가져오기
	public StaffPay getSPCode(String spCode);

	
	//강사 급여 목록 조회
	public List<StaffPay> getStaffPayList();

	//직원 급여 목록 조회
	public List<OfficersPay> getOfficersPayList();
	
	// 선택한 직원 급여정보 조회
	public List<OfficersPay> getOffiIdPayList(String mrId);
	
	// 선택한 강사 급여정보 조회
	public List<StaffPay> getStaIdPayList(String mrId);
	
	//직원급여목록조건검색
	public List<OfficersPay> getSearchOPL(String offisk, String offisv);
	
	//강사급여목록조건검색
	public List<StaffPay> getSearchSPL(String staffsk, String staffsv);
	
	//자원테이블 호출
	public List<OfficersPay> standardSheet();
	
	//보험요율표 불러오기
	public List<OfficersPay> insuranceYear();
	
	//직원급여 미지급목록 조회하기
	public List<OfficersPay> nonOffiPay();
	
	//강사급여 미지급목록 조회하기
	public List<StaffPay> nonStaffPay();
	
	//직원급여 월별 조회하기
	public List<OfficersPay> monthOffiPay(float pRTitle);
	
	//강사급여 월별 조회하기
	public List<OfficersPay> monthStaffPay(float pRTitle);
	
	//직원급여 년도별 조회하기
	public List<OfficersPay> yearOffiPay(float iyCode);
	
	//강사급여 년도별 조회하기
	public List<OfficersPay> yearStaffPay(float iyCode);		
	
}
