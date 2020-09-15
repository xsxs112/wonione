package cafe24.wio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cafe24.wio.bean.TextbookBasicInfo;
import cafe24.wio.service.TextbookService;


@Controller
public class TextbookController {

	@Autowired
	private TextbookService textbookService;
	
	@GetMapping("/textbookmanage")
	public String textbookManage(Model model) {
		model.addAttribute("title", "교재관리페이지");
		model.addAttribute("mainTitle", "교재관리페이지");
		
		return "textbookresource/textbookmanage";
		}
	
	@GetMapping("/textbookinfolist")
	public String getTextbookInfoList(Model model
									,TextbookBasicInfo txbBasicInfo ) {
		
			List<TextbookBasicInfo> textbookinfolist = textbookService.getTextbookInfoList(txbBasicInfo);
			model.addAttribute("textbookinfolist", textbookinfolist);
			System.out.println(textbookinfolist);
			model.addAttribute("title", "교재목록페이지");
			model.addAttribute("mainTitle", "교재목록페이지");
			
		return "textbookresource/textbookinfolist";
	}
	
}
