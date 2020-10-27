package cafe24.wio.service;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cafe24.wio.bean.Member;
import cafe24.wio.mapper.MemberMapper;

@Service
public class MemberService {
	
@Autowired
private MemberMapper memberMapper;
		

		/**
		 * 6. 구성원 정보 검색
		 * @param sk
		 * @param sv
		 * @return
		 */

		public List<Member>getSearchMember(String sk, String sv){
			
			List<Member> infoSearch = memberMapper.getSearchMember(sk, sv);
			
			
				if(infoSearch != null && "::검색 조건::".equals(infoSearch)) {

				for(int i = 0; i<infoSearch.size(); i++) {
					
					int memberLevel = 0;
					memberLevel = infoSearch.get(i).getLevelNum();
					
					if(memberLevel > 0) {
						if(memberLevel == 1) {
							infoSearch.get(i).setLevelName("관리자");
						}else if(memberLevel == 2) {
							infoSearch.get(i).setLevelName("시간 강사");
						}else if(memberLevel == 3) {
							infoSearch.get(i).setLevelName("일반 직원");
						}else if(memberLevel == 4) {
							infoSearch.get(i).setLevelName("학원생");
						}else {
							infoSearch.get(i).setLevelName("비회원");
						}
					}
				}
			}
			
			return infoSearch;
			
		}

		/**
		 * 5. 구성원 정보 수정
		 * @param member
		 * @return
		 */

		public int modifyWIOMember(Member member) {
			
			int modiResult = memberMapper.modifyWIOMember(member);
			
			return modiResult;
		}

		
		/**
		 * 4. 구성원 등록. 기본 정보만.
		 * @param member
		 * @return
		 */
		public int addWIOMember(Member member) {
			
			int addMemberResult = memberMapper.addWIOMember(member);
			
			return addMemberResult;
		}

		/**
		 * 3. 아이디 중복 검사, 로그인 처리시 사용
		 * @param mrId
		 * @param mrPw
		 * @return
		 */
		public String WIOMemberIdCheck(String mrId, String mrPw) {
			
			String WIOIdcheck = memberMapper.WIOMemberIdCheck(mrId, mrPw);
			
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
	public Map<String,Object> getWIOMemberList(int currentPage){
		
		final int ROW_PER_PAGE = 5;
		
		int startRow = 0;
		
		int startPageNum = 1;
		int lastPageNum = ROW_PER_PAGE;
		
		if(currentPage > (ROW_PER_PAGE/2)) {
			startPageNum = currentPage - ((lastPageNum/2)-1);
			lastPageNum += startPageNum;
		}
		
		startRow = (currentPage - 1) * ROW_PER_PAGE ;
		
		Map<String,Object> memberMap = new HashMap<String,Object>();
		
		
		memberMap.put("startRow", startRow);
		memberMap.put("rowPerPage", ROW_PER_PAGE);
		
		// 회원 정보가 담긴 WIOMemberList 객체 생성
		List<Member> WIOMemberList = memberMapper.getWIOMemberList(memberMap);
		
		double totalRowCount = memberMapper.getCountMemberList();
		
		int lastPage = (int)Math.ceil((totalRowCount / ROW_PER_PAGE));
		
		if(currentPage >= (lastPage-4)) {
			lastPageNum = lastPage;
		}
		
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
			
			Map<String,Object> WIOList = new HashMap<String,Object>();
			
			WIOList.put("WIOMemberList", WIOMemberList);
			WIOList.put("lastPage", lastPage);
			WIOList.put("startPageNum", startPageNum);
			WIOList.put("lastPageNum", lastPageNum);

		return WIOList;
	}
}
