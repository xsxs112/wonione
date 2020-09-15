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

		// 1. 구성원 리스트 가져오기.
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
					}
				}
			}
		}
		
		
		return null;
	}
}