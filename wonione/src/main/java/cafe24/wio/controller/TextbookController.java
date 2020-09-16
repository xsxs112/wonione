package cafe24.wio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cafe24.wio.bean.TextbookBasicInfo;
import cafe24.wio.bean.WhTextbook;
import cafe24.wio.service.TextbookService;


@Controller
public class TextbookController {

	@Autowired
	private TextbookService textbookService;
	
	@GetMapping("/textbookRegister")
	public String textbookRegister(Model model) {
		
		model.addAttribute("title", "교재등록 선택 페이지");
		model.addAttribute("mainTitle", "교재등록 선택 페이지");
		
		return "textbookresource/textbookRegister";
	}
	
	@GetMapping("/textbookOwnList")
	public String getTextbookOwnList(Model model
									, WhTextbook whTextbook) {
		
		List<TextbookBasicInfo> textbookOwnList = textbookService.getTextbookOwnList(whTextbook);
		System.out.println(textbookOwnList);
		model.addAttribute("textbookOwnList", textbookOwnList);
		model.addAttribute("title", "교재보유현황 페이지");
		model.addAttribute("mainTitle", "교재보유현황 페이지");
		
		return "textbookresource/textbookOwnlist";
	}
	
	@GetMapping("/textbookManage")
	public String textbookManage(Model model) {
		model.addAttribute("title", "교재관리페이지");
		model.addAttribute("mainTitle", "교재관리페이지");
		
		return "textbookresource/textbookManage";
		}
	
	@GetMapping("/textbookInfoList")
	public String getTextbookInfoList(Model model
									,TextbookBasicInfo txbBasicInfo ) {
		
			List<TextbookBasicInfo> textbookinfolist = textbookService.getTextbookInfoList(txbBasicInfo);
			model.addAttribute("textbookInfoList", textbookinfolist);
			System.out.println(textbookinfolist);
			model.addAttribute("title", "교재목록페이지");
			model.addAttribute("mainTitle", "교재목록페이지");
			
		return "textbookresource/textbookInfoList";
	}
	
}
