package cafe24.wio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cafe24.wio.bean.Member;
import cafe24.wio.mapper.MemberMapper;

@Service
public class MemberService {
	
@Autowired
private MemberMapper memberMapper;


		/**
		 * 3. 아이디 중복 검사, 로그인 처리시 사용
		 * @param mrId
		 * @param mrPw
		 * @return
		 */
		public String WIOMemberIdCheck(String mrId, String mrPw) {
			
			String WIOIdcheck = memberMapper.WIOMemberIdCheck(mrId, mrPw);
			
			System.out.println(WIOIdcheck + "<-- WIOIdcheck memberService");
			
			if(WIOIdcheck != null && !"".equals(WIOIdcheck)) {
				
			}
			return WIOIdcheck;
		}

		
		/**
		 * 2. 구성원 정보 조회
		 * @param mrId
		 * @return
		 */
		public Member getMemberInfo(String mrId) {
		Member member = memberMapper.getMemberInfo(mrId);
		System.out.println(member + "<-- member 정보 조회 / memberService");
		
		if(member != null) {
			int levelNum = 0;
			levelNum = member.getLevelNum();
			
			if(levelNum > 0) {
				if(levelNum == 1) {
					member.setLevelName("관리자");
				}else if(levelNum == 2) {
					member.setLevelName("시간 강사");
				}else if(levelNum == 3) {
					member.setLevelName("일반 직원");
				}else if(levelNum == 4) {
					member.setLevelName("학원생");
				}else {
					member.setLevelName("비회원");
				}
			}
		}
		
		return member;
		}


		/**
		 * 구성원 리스트 가져오기.
		 * @return
		 */
	public List<Member> getWIOMemberList(){
		
		// 회원 정보가 담긴 WIOMemberList 객체 생성
		List<Member> WIOMemberList = memberMapper.getWIOMemberList();
		System.out.println(WIOMemberList + "<--MemberList MemberService");
		
		//회원 정보가 null 이 아닐 경우 조회
		if(WIOMemberList != null) {
			for(int n=0; n<WIOMemberList.size(); n++) {
				
				//회원 레벨 변수 초기화
				int memberLevel = 0;
				memberLevel = WIOMemberList.get(n).getLevelNum();
				if(memberLevel > 0) {
					if(memberLevel == 1) {
						WIOMemberList.get(n).setLevelName("관리자");
					}else if(memberLevel == 2) {
						WIOMemberList.get(n).setLevelName("시간 강사");
					}else if(memberLevel == 3) {
						WIOMemberList.get(n).setLevelName("일반 직원");
					}else if(memberLevel == 4){
						WIOMemberList.get(n).setLevelName("학원생");
					}else {
						WIOMemberList.get(n).setLevelName("비회원");
					}
				}
			}
		}
		
		return WIOMemberList;
	}
}
