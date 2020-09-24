package cafe24.wio.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
	
	//교재 지급내역 검색
	@GetMapping("/getSuppTxbSearch")
	public String getSuppTxbSearch(Model model
			,@RequestParam(value="suppSk", required=false) String suppTxbSk
			,@RequestParam(value="suppTxbSv", required=false) String suppTxbSv) {
		List<SupplyTextbook> suppTxbSearchResult = textbookService.getSuppTxbSearch(suppTxbSk, suppTxbSv);
		logger.info(suppTxbSearchResult.toString());
		model.addAttribute("getTextbookSuppList", suppTxbSearchResult);
		return "textbookresource/textbookSupplyList";
	}
	
	//교재 정보 검색
	@GetMapping("/getTxbInfoSearch")
	public String getTxbInfoSearch(Model model
			,@RequestParam(value="infoTxbSk", required=false) String infoTxbSk
			,@RequestParam(value="infoTxbSv", required=false) String infoTxbSv) {
		List<TextbookBasicInfo> txbInfoSearchResult = textbookService.getTxbInfoSearch(infoTxbSk, infoTxbSv);
		logger.info(txbInfoSearchResult.toString());
		model.addAttribute("textbookInfoList", txbInfoSearchResult);
		return "textbookresource/textbookInfoList";
	}
	
	//교재 입고내역 검색
	@GetMapping("/getWhTxbSearch")
	public String getWhTxbSearch(Model model
							,@RequestParam(value="whTxbSk", required=false) String whTxbSk
							,@RequestParam(value="whTxbSv", required=false) String whTxbSv) {
		List<TextbookBasicInfo> whTxbSearchResult= textbookService.getWhTxbSearch(whTxbSk, whTxbSv);
		model.addAttribute("getTextbookList", whTxbSearchResult);
		return "textbookresource/textbookOwnlist";
	}
	
	//입고내역유무 체크
	@PostMapping(value="/whTxbCheck", produces="application/json") 
	@ResponseBody 
	public int wahoTextbookCheck(Model model
					,@RequestParam(value="txbCode", required = false)String txbCode	) { 
		logger.info("==============================");
		logger.info("입고내역체크 wahoTextbookCheck 포스트매핑!!!!");
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
	
		return "whTxbCheck";
	}

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
	public String textbookInfoRegister(Model model
									,HttpSession session) {
		
		logger.info("==============================");
		logger.info("교재정보등록페이지 textbookInfoRegister 겟매핑!!!!");
		logger.info("==============================");
		String txbCode = textbookService.getTxbInfoMaxCode();
		String sessionId = session.getAttribute("SID").toString();
		logger.info(txbCode + " < -- txbCode");
		logger.info(sessionId + " < -- sessionId");
		model.addAttribute("title", "교재기본정보등록  페이지");
		model.addAttribute("mainTitle", "교재기본정보등록 페이지");
		model.addAttribute("txbCode", txbCode);
		model.addAttribute("sessionId", sessionId);
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
		WhTextbook txbWhResult = textbookService.getRecentTxbWhList();
		model.addAttribute("title", "교재등록 완료  페이지");
		model.addAttribute("mainTitle", "교재등록 완료 페이지");
		model.addAttribute("regResult", "다음과 같은 정보로 등록되었습니다");
		model.addAttribute("txbWhResult", txbWhResult);
		
		return "textbookresource/textbookRegResult";
	} 
	
	//교재 최초입고등록 
	@GetMapping("/textbookFirstWahoRegister")
	public String textbookFirstWahoRegister(Model model
										,	HttpSession session
										,@RequestParam(value="txbCode", required = false) String txbCode) {
		
		String sessionId = session.getAttribute("SID").toString();
		logger.info(sessionId);
		logger.info(txbCode);
		//교재 기본정보조회
		TextbookBasicInfo textbookBasicInfo = textbookService.getOnlyTxbInfo(txbCode);
		//교재입고코드 자동증가
		String whTxbCode = textbookService.getTxbWhMaxCode();
		
		model.addAttribute("title", "교재최초입고등록  페이지");
		model.addAttribute("mainTitle", "교재최초입고등록 페이지");
		model.addAttribute("sessionId", sessionId);
		model.addAttribute("whTxbCode", whTxbCode);
		model.addAttribute("textbookBasicInfo", textbookBasicInfo);
		
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
		WhTextbook txbWhResult = textbookService.getRecentTxbWhList();
		model.addAttribute("title", "교재등록 완료  페이지");
		model.addAttribute("mainTitle", "교재등록 완료 페이지");
		model.addAttribute("regResult", "다음과 같은 정보로 등록되었습니다");
		model.addAttribute("txbWhResult", txbWhResult);
		
		return "textbookresource/textbookRegResult";
	} 
	
	//교재입고등록 
	@GetMapping("/textbookWahoRegister")
	public String textbookWahoRegister(Model model
									,  HttpSession session) {
		String sessionId = session.getAttribute("SID").toString();
		logger.info(sessionId);
		//교재 기본정보조회
		List<TextbookBasicInfo> textbookinfolist = textbookService.getTextbookInfoList();
		//교재입고목록 조회
		List<WhTextbook> whTextbookList = textbookService.getWhTextbookList();
		//코드자동증가
		String whTxbCode = textbookService.getTxbWhMaxCode();
		
		model.addAttribute("title", "교재입고등록  페이지");
		model.addAttribute("mainTitle", "교재입고등록 페이지");
		model.addAttribute("sessionId", sessionId);
		model.addAttribute("textbookInfoList", textbookinfolist);
		model.addAttribute("whTextbookList", whTextbookList);
		model.addAttribute("whTxbCode", whTxbCode);
		
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
	public String getTextbookOwnList(Model model) {
		
		List<TextbookBasicInfo> textbookOwnList = textbookService.getTextbookOwnList();
		System.out.println(textbookOwnList);
		model.addAttribute("getTextbookList", textbookOwnList);
		model.addAttribute("title", "교재보유현황 페이지");
		model.addAttribute("mainTitle", "교재보유현황 페이지");
		
		return "textbookresource/textbookOwnList";
	}
	
	//교재관리메인페이지
	@GetMapping("/textbookManage")
	public String textbookManage(Model model) {
		logger.info("==============================");
		logger.info("교재관리페이지 textbookManage 겟매핑!!!!");
		logger.info("==============================");
		model.addAttribute("title", "교재관리페이지");
		model.addAttribute("mainTitle", "교재관리페이지");
		
		return "textbookresource/textbookManage";
		}
	
	//교재기본정보 리스트
	@GetMapping("/textbookInfoList")
	public String getTextbookInfoList(Model model) {
			List<TextbookBasicInfo> textbookinfolist = textbookService.getTextbookInfoList();
			model.addAttribute("textbookInfoList", textbookinfolist);
			System.out.println(textbookinfolist);
			model.addAttribute("title", "교재목록페이지");
			model.addAttribute("mainTitle", "교재목록페이지");
			
		return "textbookresource/textbookInfoList";
	}
	
}
