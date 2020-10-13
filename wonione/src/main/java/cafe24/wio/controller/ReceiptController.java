package cafe24.wio.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cafe24.wio.bean.Course;
import cafe24.wio.bean.Member;
import cafe24.wio.mapper.ReceiptMapper;
import cafe24.wio.service.MemberService;
import cafe24.wio.service.ReceiptService;

	// 과정 선택, 수납 컨트롤러

@Controller
public class ReceiptController {

	@Autowired
	private ReceiptService receiptServeice;
	@Autowired
	private ReceiptMapper receiptMapper;
	@Autowired
	private MemberService memberService;
	
	
	private static final Logger log = LoggerFactory.getLogger(ReceiptController.class);

	// 1. 과정 선택 리스트 가져오기.
	@GetMapping("/getCourseSelection")
	public String getCourseSelection(Model model) {
		
		//학생 이름 뽑아오기 - HTML에서 처리하려면 Controller 코드 적어줘야할까?(10.13)
		
		//과정 뽑아오는 코드 작성해줘야함. 1013
		model.addAttribute("title", "과정 선택");
		
		//개설 예정 강의 리스트 목록
		model.addAttribute("getOpenLecList", receiptMapper.getOpenLecList());
		
		return "coursePayment/course";
	}
}
