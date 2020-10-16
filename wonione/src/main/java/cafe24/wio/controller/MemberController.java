package cafe24.wio.controller;


import java.sql.Date;
import java.util.List;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cafe24.wio.bean.Member;
import cafe24.wio.mapper.MemberMapper;
import cafe24.wio.service.MemberService;

//구성원 컨트롤러 - 정진수

@Controller
public class MemberController {
	
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberMapper memberMapper;
	
	
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);

	
	// 3. 구성원 정보 수정
	@GetMapping("/modifyWIOMember")
	public String modifyWIOMember(Model model
								, @RequestParam(value = "mrId",required = false)String mrId
								, @RequestParam(value = "mrPw",required = false)String mrPw) {
		
		
		Member member = memberService.getMemberInfo(mrId);
		
		model.addAttribute("member", member);
		model.addAttribute("title", "구성원 정보 수정");
		model.addAttribute("pmResourceList", memberMapper.getPmResourceList());
		
		return "member/modifyWIOMember";

	}
	@PostMapping("/modifyWIOMember")
	public String modifyWIOMember(Member member) {
		
		memberService.modifyWIOMember(member);
		
		return "redirect:/getWIOMemberList";
	}
	
	
	
	// 2-1. 로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/";
	}

	
	// 2. 로그인 처리
	@PostMapping("/login")
	public String login(Model model
					   ,@RequestParam(value = "mrId",required = false)String mrId
					   ,@RequestParam(value = "mrPw",required = false)String mrPw
					   ,HttpSession session) {
		
		
		Member member = memberService.getMemberInfo(mrId);
		
		if(member != null) {
			if(member.getMrPw().equals(mrPw)) {
				session.setAttribute("SID", member.getMrId());
				session.setAttribute("SNAME", member.getMrName());
				session.setAttribute("SLEVEL", member.getLevelNum());
				session.setAttribute("SLEVELNAME", member.getLevelName());
				
				return "index";
			}
		}
		
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String index() {
		return "login/login";
	}
	
	//1-4. 아이디 중복 검사
	@ResponseBody
	@RequestMapping("/WIOMemberIdCheck")
	public String WIOMemberIdCheck(@RequestParam(value = "mrId",required = false)String mrId
								 , @RequestParam(value = "mrPw",required = false)String mrPw) {
		
		
		String WIOIdCheck = memberService.WIOMemberIdCheck(mrId, mrPw);
		
		return WIOIdCheck;
	}
	
	//1-3. 구성원 등록. 등록 후, 등록 정보를 바로 넘겨서? 수납 처리할 것. 20.09.23.09:58
	
	@PostMapping("/addWIOMember")
	public String addWIOMember(Member member
								,@RequestParam(value = "mrId"  			,required = false) String mrId
								,@RequestParam(value = "mrPw"  			,required = false) String mrPw
								,@RequestParam(value = "mrName"			,required = false) String mrName
								,@RequestParam(value = "levelNum"		,required = false) int	   levelNum
								,@RequestParam(value = "mrPhone"		,required = false) String mrPhone
								,@RequestParam(value = "mrAddr"			,required = false) String mrAddr
								,@RequestParam(value = "mrTargetScore"	,required = false) int    mrTargetScore
								,@RequestParam(value = "pmRCode"		,required = false) String pmRCode
								,@RequestParam(value = "mrAccountNum"	,required = false) String mrAccountNum
								,@RequestParam(value = "shuttleNum"		,required = false) String shuttleNum
								,@RequestParam(value = "mrJoinDate"		,required = false) String mrJoinDate) {
		
		
		member.setMrId(mrId);
		member.setMrPw(mrPw);
		member.setMrName(mrName);
		member.setLevelNum(levelNum);
		member.setMrAddr(mrAddr);
		member.setMrTargetScore(mrTargetScore);
		member.setPmRCode(pmRCode);
		member.setMrAccountNum(mrAccountNum);
		
		//셔틀 신청 부분을 빈 칸으로 두면 에러가 발생하면서 '' 공백으로 값이 들어감. 그래서 조건문 처리.
		if(shuttleNum.equals("")||shuttleNum.equals(null)) {
			
			member.setShuttleNum(null);
			
		}else if(mrJoinDate.equals("") || mrJoinDate.equals(null)) {
			
			member.setMrJoinDate(null);
		}
		
		memberService.addWIOMember(member);
		
		// 권한이 학생일 경우 과정 선택 화면으로 이동
		if(levelNum == 4) {
			return "redirect:/getCourseSelection";
		}
		
		return "redirect:/getWIOMemberList";
	}

	@GetMapping("/addWIOMember")
	public String addWIOMember(Model model) {
		
		model.addAttribute("title", "구성원 정보 입력");
		
		// 구성원 등록 시, 결제 코드 입력창에 결제 수단이 보이도록.
		model.addAttribute("pmResourceList", memberMapper.getPmResourceList());
		
		return "member/addWIOMember";
	}
	

	//1-2. 상세 보기 page
	@RequestMapping("/getMemberInfo")
	public String getMemberInfo(Model model
							,	@RequestParam(value = "mrId",required = false)String mrId) {
		
		Member WIOMemberInfo = memberService.getMemberInfo(mrId);
		
		model.addAttribute("title", "상세 정보 보기");
		model.addAttribute("WIOMemberInfo", WIOMemberInfo);
		
		//상세 보기 정보 더 보여지게 하려면 새로 만드는 테이블 위 작업 똑같이
		
		return "member/MemberInfo";
	}
	

	//1. 리스트 가져오기
	@GetMapping("/getWIOMemberList")
	public String getWIOMemberList(Model model) {
		
		List<Member> WIOMemberList = memberService.getWIOMemberList();
		
		model.addAttribute("title", "구성원 목록 조회");
		model.addAttribute("WIOMemberList", WIOMemberList);
		
		return "member/WIOMemberList";
	}
	
}
