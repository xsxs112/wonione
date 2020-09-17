package cafe24.wio.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cafe24.wio.bean.SupplyTextbook;
import cafe24.wio.bean.TextbookBasicInfo;
import cafe24.wio.bean.WhTextbook;
import cafe24.wio.service.TextbookService;


@Controller
public class TextbookController {

	@Autowired
	private TextbookService textbookService;
	
	
	private static final Logger logger = LoggerFactory.getLogger(TextbookController.class);

	
	 //입고내역유무 체크
	  
	 @PostMapping(value="/whTxbCheck", produces="application/json") 
	 @ResponseBody 
	 public int wahoTextbookCheck(Model model
			 			,@RequestParam(value="txbCode", required = false)String txbCode	) { 
		 logger.info("==============================");
		 logger.info("교재지급내역페이지 getTextbookSuppList 포스트매핑!!!!");
		 logger.info("==============================");
		 TextbookBasicInfo whTxbCodeCheck = textbookService.wahoTextbookCheck(txbCode); 
		 
		 int result = 1;
		 if(whTxbCodeCheck == null) {
			result = 0;
		 }else {
			logger.info(whTxbCodeCheck.toString());
		 }
		 return result;
	 }
	 
	
	//입고내역유무 체크
	@GetMapping("/whTxbCheck")
	public String wahoTextbookCheck() {
	
		return "/whTxbCheck";
	}

	/*
	 * @GetMapping(value="/whTxbCheck", produces="application/json") public int
	 * wahoTextbookCheck(WhTextbook whTextbook) { List<TextbookBasicInfo>
	 * wahoTextbookCheck = textbookService.wahoTextbookCheck(whTextbook);
	 * System.out.println(wahoTextbookCheck.size() + " < -- size"); int result = 0;
	 * if(wahoTextbookCheck != null) { String txbCode = null; for(int i=0;
	 * i<wahoTextbookCheck.size(); i++) {
	 * logger.info(wahoTextbookCheck.get(i).toString());
	 * logger.info(wahoTextbookCheck.get(i).getTxbCode()); txbCode =
	 * wahoTextbookCheck.get(i).getTxbCode(); if(txbCode !=null &&
	 * txbCode.equals("")) { result = 1; } } } return result; }
	 */	
	
	//교재 지급내역 조회
	@GetMapping("/textbookSupplyList")
	public String getTextbookSuppList(Model model
								,SupplyTextbook supplyTextbook) {
		logger.info("==============================");
		logger.info("교재지급내역페이지 getTextbookSuppList 포스트매핑!!!!");
		logger.info("==============================");
		
		model.addAttribute("title", "교재지급내역 페이지");
		model.addAttribute("mainTitle", "교재지급내역 페이지");
		List<SupplyTextbook> getTextbookSuppList = textbookService.getTextbookSuppList();
		model.addAttribute("getTextbookSuppList", getTextbookSuppList);
		return "textbookresource/textbookSupplyList";
	}
	
	//교재 기초정보 등록
	@PostMapping("/textbookInfoRegister")
	public String textbookInfoRegister(Model model
									,TextbookBasicInfo txbBasicInfo) {
		logger.info("==============================");
		logger.info("교재정보등록페이지 textbookInfoRegister 포스트매핑!!!!");
		logger.info("==============================");
		
		textbookService.addTextbookInfo(txbBasicInfo);
		String txbInfoCode = textbookService.getAddTxbInfoCode();
		TextbookBasicInfo textbookBasicInfo = textbookService.getOnlyTxbInfo(txbInfoCode);
		logger.info("==============================");
		logger.info(txbInfoCode);
		logger.info(textbookBasicInfo.toString());
		logger.info("==============================");
		model.addAttribute("title", "교재등록 완료  페이지");
		model.addAttribute("mainTitle", "교재등록 완료 페이지");
		model.addAttribute("regResult", "다음과 같은 정보로 등록되었습니다");
		model.addAttribute("txbInfoCode", txbInfoCode);
		model.addAttribute("textbookBasicInfo", textbookBasicInfo);
		return "textbookresource/textbookRegResult";
	}
	
	//교재 기초정보 등록
	@GetMapping("/textbookInfoRegister")
	public String textbookInfoRegister(Model model) {
		
		logger.info("==============================");
		logger.info("교재정보등록페이지 textbookInfoRegister 겟매핑!!!!");
		logger.info("==============================");
		
		model.addAttribute("title", "교재기본정보등록  페이지");
		model.addAttribute("mainTitle", "교재기본정보등록 페이지");
		
		return "textbookresource/textbookInfoRegister";
	}	
	//교재 최초입고등록
	@PostMapping("/textbookFirstWahoRegister")
	public String textbookFirstWahoRegister(Model model
			 					, WhTextbook whTextbook
			 					,@RequestParam(value="txbCode", required = false)String txbCode
			 					,@RequestParam(value="whTxbQuantity", required = false)String whTxbQuantity
			 					,@RequestParam(value="whTxbRemark", required = false)String whTxbRemark) {
	System.out.println(txbCode + "  < -- txbCode");
	System.out.println(whTxbQuantity + "  < -- whTxbQuantity");
	System.out.println(whTxbRemark + "  < -- whTxbRemark");

	textbookService.addFirstWhTextbook(whTextbook);
	
	return "redirect:/textbookManage";
	} 
	
	//교재 최초입고등록 
	@GetMapping("/textbookFirstWahoRegister")
	public String textbookFirstWahoRegister(Model model
									 , TextbookBasicInfo txbBasicInfo) {
		
		model.addAttribute("title", "교재최초입고등록  페이지");
		model.addAttribute("mainTitle", "교재최초입고등록 페이지");
		//교재 기본정보조회
		List<TextbookBasicInfo> textbookinfolist = textbookService.getTextbookInfoList(txbBasicInfo);
		model.addAttribute("textbookInfoList", textbookinfolist);
		
		return "textbookresource/textbookFirstWahoRegister";
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
		logger.info("==============================");
		logger.info("교재관리페이지 textbookManage 겟매핑!!!!");
		logger.info("==============================");
		
		
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
