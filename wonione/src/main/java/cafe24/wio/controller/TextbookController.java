package cafe24.wio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cafe24.wio.bean.TextbookBasicInfo;
import cafe24.wio.bean.WhTextbook;
import cafe24.wio.service.TextbookService;


@Controller
public class TextbookController {

	@Autowired
	private TextbookService textbookService;
	
	@GetMapping("/textbookInfoRegister")
	public String textbookInfoRegister(Model model) {
		
		model.addAttribute("title", "교재기본정보등록  페이지");
		model.addAttribute("mainTitle", "교재기본정보등록 페이지");
		
		return "textbookresource/textbookInfoRegister";
	}	
	
	//교재 입고등록
	@PostMapping("/textbookWahoRegister")
	public String textbookWahoRegister(Model model
			 					, WhTextbook whTextbook
			 					,@RequestParam(value="txbCode", required = false)String txbCode
			 					,@RequestParam(value="whTxbQuantity", required = false)String whTxbQuantity
			 					,@RequestParam(value="stockTxbQuantity", required = false)String stockTxbQuantity
			 					,@RequestParam(value="whTxbRemark", required = false)String whTxbRemark) {
	System.out.println(txbCode + "  < -- txbCode");
	System.out.println(whTxbQuantity + "  < -- whTxbQuantity");
	System.out.println(stockTxbQuantity + "stockTxbQuantity");
	System.out.println(whTxbRemark + "  < -- whTxbRemark");
	textbookService.addWhTextbook(whTextbook);
	
	return "redirect:/textbookManage";
	} 
	
	//교재입고등록 
	@GetMapping("/textbookWahoRegister")
	public String textbookWahoRegister(Model model
									 , TextbookBasicInfo txbBasicInfo) {
		
		model.addAttribute("title", "교재입고등록  페이지");
		model.addAttribute("mainTitle", "교재입고등록 페이지");
		//교재 기본정보조회
		List<TextbookBasicInfo> textbookinfolist = textbookService.getTextbookInfoList(txbBasicInfo);
		model.addAttribute("textbookInfoList", textbookinfolist);
		//교재입고목록 조회
		List<WhTextbook> whTextbookList = textbookService.getWhTextbookList();
		model.addAttribute("whTextbookList", whTextbookList);
		
		return "textbookresource/textbookWahoRegister";
	}
	
	//교재등록선택페이지
	@GetMapping("/textbookRegister")
	public String textbookRegister(Model model) {
		
		model.addAttribute("title", "교재등록 선택 페이지");
		model.addAttribute("mainTitle", "교재등록 선택 페이지");
		
		return "textbookresource/textbookRegister";
	}
	
	//교재보유목록 
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
	
	//교재관리메인페이지
	@GetMapping("/textbookManage")
	public String textbookManage(Model model) {
		model.addAttribute("title", "교재관리페이지");
		model.addAttribute("mainTitle", "교재관리페이지");
		
		return "textbookresource/textbookManage";
		}
	
	//교재기본정보 리스트
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
