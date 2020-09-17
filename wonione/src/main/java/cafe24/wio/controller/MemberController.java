package cafe24.wio.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
	
	// 2-1. 로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/";
	}

	/*
	 * //2. 로그인 처리
	 * 
	 * @GetMapping("/login") 
	 * public String login(Model model) {
	 * 
	 * model.addAttribute("title", "로그인");
	 * 
	 * return "member/login"; 
	 * }
	 * 
	 */
	// 2. 로그인 처리
	@PostMapping("/login")
	public String login(Model model
					   ,@RequestParam(value = "mrId",required = false)String mrId
					   ,@RequestParam(value = "mrPw",required = false)String mrPw
					   ,HttpSession session) {
		System.out.println(mrId + "<--mrId MemberController 변수");
		System.out.println(mrPw + "<--mrPw MemberController 변수");
		
		Member member = memberService.getMemberInfo(mrId, mrPw);
		System.out.println(mrId + "<-- 2. 로그인memberController");
		System.out.println(mrPw + "<-- 2. 로그인memberController");
		
		if(member != null) {
			if(member.getMrPw().equals(mrPw)) {
				session.setAttribute("SID", member.getMrId());
				session.setAttribute("SNAME", member.getMrName());
				session.setAttribute("SLEVELNAME", member.getLevelName());
				
				return "redirect:/";
			}
		}
		
		return "redirect:/login";
	}
	

	//1-2. 상세 보기 page
	@ResponseBody
	@RequestMapping("/getMemberInfo")
	public String getMemberInfo(Model model
							,	@RequestParam(value = "mrId",required = false)String mrId
							,	@RequestParam(value = "mrPw",required = false)String mrPw) {
		
		Member WIOMemberInfo = memberService.getMemberInfo(mrId, mrPw);
		System.out.println(WIOMemberInfo + "<-- 상세 보기 / controller");
		System.out.println(mrId + "<-- mrId 상세보기 controller");
		
		model.addAttribute("title", "상세 정보 보기");
		model.addAttribute("WIOMemberInfo", WIOMemberInfo);
		
		//상세 보기 정보 더 보여지게 하려면 새로 만드는 테이블 위 작업 똑같이
		
		return "member/MemberInfo";
	}

	//1. 리스트 가져오기
	@GetMapping("/getWIOMemberList")
	public String getWIOMemberList(Model model) {
		
		List<Member> WIOMemberList = memberService.getWIOMemberList();
		System.out.println(WIOMemberList + "<-- memberList / controller");
		
		model.addAttribute("title", "구성원 목록 조회");
		model.addAttribute("WIOMemberList", WIOMemberList);
		
		return "member/WIOMemberList";
	}
	
	
	
}
