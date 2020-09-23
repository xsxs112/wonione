package cafe24.wio.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cafe24.wio.bean.Member;

@Mapper
public interface MemberMapper {
	
	// 4. 구성원 등록
	public int addWIOMember(Member member);
	
	// 3. 아이디 중복 검사 , 로그인 처리시 사용
	public String WIOMemberIdCheck(String mrId, String mrPw);
	
	// 2. 회원 정보 상세 보기 (수납 테이블 완성 후, 강의 목록 등 보이게 수정 해야함.0916_16:25)
	public Member getMemberInfo(String mrId);
	
	
	// 1. 구성원 리스트 가져오기.
	public List<Member>getWIOMemberList();
	
}
