package cafe24.wio.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cafe24.wio.bean.StaffPay;

@Mapper
public interface StaffPayMapper {

	//강사급여명세서 조회
	public List<StaffPay> getStaffPay(String mrId);

	//강사 목록 조회
	public List<StaffPay> getStaffList();
	
	//자원테이블 호출
	public List<StaffPay> standardSheet();

	//강사 정보 조회
	public StaffPay callStaffInfo(String mrId);

	//보험요율표 불러오기
	public List<StaffPay> insuranceYear();

	//강사급여계 입력하기
	public int addStaffCalPay(StaffPay staffpay);

	//요율표 비교 원천징수액 계산
	public StaffPay StaffPayDedu(String opdCode, String iyCode, String spdTheBusinessTax);

}
