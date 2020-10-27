package cafe24.wio.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cafe24.wio.bean.Member;

@Mapper
public interface MemberMapper {
	
	// 9. 구성원 정보 검색 처리
	public List<Member> getSearchMember(String sk, String sv);
	
	// 8. 구성원 등록 화면 셔틀 리스트 뽑아오기
	public List<Map<String, Object>> getShuttleList();
	
	// 7. 구성원 등록 화면에서 권한 레벨이 아닌 권한명으로 선택하도록 변경
	public List<Map<String,Object>> getMemberLevelName();
	
	// 6. 결제 정보 카테고리 조회
	public List<Map<String, Object>> getPmResourceList();
	
	// 5. 구성원 정보 수정
	public int modifyWIOMember(Member member);
	
	// 4. 구성원 등록
	public int addWIOMember(Member member);
	
	// 3. 아이디 중복 검사 , 로그인 처리시 사용
	public String WIOMemberIdCheck(String mrId, String mrPw);
	
	// 2. 회원 정보 상세 보기 (수납 테이블 완성 후, 강의 목록 등 보이게 수정 해야함.0916_16:25)
	public Member getMemberInfo(String mrId);
	
	// 1-1. 페이징을 위한 구성원 목록 카운팅
	public int getCountMemberList();
	
	// 1. 구성원 리스트 가져오기.
	public List<Member> getWIOMemberList(Map<String,Object>memberMap);
	
}
