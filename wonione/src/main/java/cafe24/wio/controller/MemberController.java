package cafe24.wio.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import cafe24.wio.bean.Member;
import cafe24.wio.service.MemberService;

//구성원 컨트롤러 - 정진수

@Controller
public class MemberController {
	
@Autowired
	private MemberService memberService;

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
