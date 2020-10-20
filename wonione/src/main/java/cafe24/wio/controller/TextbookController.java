package cafe24.wio.controller;

import java.util.List;
import java.util.Map;

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
	
	//교재 기본 정보 수정하기
	@PostMapping("/textbookInfoModify")
	public String txbInfoModify( TextbookBasicInfo textbookBasicInfo
								,@RequestParam(value="txbCode",required = false) String txbCode
								,@RequestParam(value="txbName",required = false) String txbName
								,@RequestParam(value="txbPublisher",required = false) String txbPublisher
								,@RequestParam(value="txbAuthor",required = false) String txbAuthor
								,@RequestParam(value="txbRemark",required = false) String txbRemark
								,@RequestParam(value="txbModifier",required = false) String txbModifier
								,@RequestParam(value="txbModDate",required = false) String txbModDate) {
		
		return "redirect:/textbookInfoList";
	}
	
	//교재기본정보 수정하기
	@GetMapping("/textbookInfoModify")
	public String textbookInfoModify(Model model
									,HttpSession session
									,@RequestParam(value="txbCode", required = false) String txbCode) {
		TextbookBasicInfo textbookBasicInfo = textbookService.getOnlyTxbInfo(txbCode);
		String txbModifierId = session.getAttribute("SID").toString();
		String txbModifierName = session.getAttribute("SNAME").toString();
		model.addAttribute("title", "교재기본정보 수정페이지");
		model.addAttribute("mainTitle", "교재기본정보 수정페이지");
		model.addAttribute("textbookBasicInfo", textbookBasicInfo);
		model.addAttribute("txbModifierId", txbModifierId);
		model.addAttribute("txbModifierName", txbModifierName);
		
		
		return "textbookresource/textbookInfoModify";
	}
	
	//교재지급등록 시 교재명을 선택하면 현재 재고수량을 조회하는 ajax
	@GetMapping(value="/getTxbStock", produces="application/json")
	@ResponseBody
	public int getTxbStock(@RequestParam
							( value="txbCode"
							, required = false)String txbCode) {
		
		int stockResult = textbookService.getStockTxbQuantity(txbCode);
		
		return stockResult;
	}
	
	//교재지급등록
	@PostMapping("/textbookSupplyRegister")
	public String textbookSupplyRegister(Model model
										,SupplyTextbook suppTxb) {
		
		textbookService.addTxbSupply(suppTxb);
		
		return "textbookresource/textbookRegResult";
	}
	
	//교재지급등록
	@GetMapping("/textbookSupplyRegister")
	public String textbookSupplyRegister(Model model
										,HttpSession session) {
		List<Map<String,Object>> txbReceiverId = textbookService.selectStudent();
		String sessionId = session.getAttribute("SID").toString();
		String sessionName = session.getAttribute("SNAME").toString();
		List<TextbookBasicInfo> textbookinfolist = textbookService.getTextbookInfo();
		String supTxbCode = textbookService.getTxbSuppMaxCode();
		
		
		model.addAttribute("title", "교재지급내역 등록페이지");
		model.addAttribute("mainTitle", "교재지급내역 등록페이지");
		model.addAttribute("txbReceiverId", txbReceiverId);
		model.addAttribute("sessionId", sessionId);
		model.addAttribute("sessionName", sessionName);
		model.addAttribute("supTxbCode", supTxbCode);
		model.addAttribute("textbookinfolist", textbookinfolist);
		System.out.println(textbookinfolist.toString());
		
		return "textbookresource/textbookSupplyRegister";
	}
	
	//교재 지급내역 검색
	@GetMapping("/getSuppTxbSearch")
	public String getSuppTxbSearch(Model model
			,@RequestParam(value="suppSk", required=false) String suppTxbSk
			,@RequestParam(value="suppTxbSv", required=false) String suppTxbSv) {
		List<SupplyTextbook> suppTxbSearchResult = textbookService.getSuppTxbSearch(suppTxbSk, suppTxbSv);
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
		List<Map<String, Object>> whTxbSearchResult= textbookService.getWhTxbSearch(whTxbSk, whTxbSv);
		model.addAttribute("title", "교재입고검색결과 페이지");
		model.addAttribute("mainTitle", "검색하신내용은 아래와 같습니다.");
		model.addAttribute("getTextbookList", whTxbSearchResult);
		return "textbookresource/textbookOwnlist";
	}
	
	//입고내역유무 체크
	@PostMapping(value="/whTxbCheck", produces="application/json") 
	@ResponseBody 
	public int wahoTextbookCheck(Model model
					,@RequestParam(value="txbCode", required = false)String txbCode	) { 
		List<Map<String,Object>> whTxbCodeCheck = textbookService.wahoTextbookCheck(txbCode); 
		int result = 1;
		if(whTxbCodeCheck.size()<1) {
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
									, @RequestParam(
													  value="currentPage"
													, required = false
													, defaultValue = "1") int currentPage) {
		
		Map<String,Object> getTextbookSuppList = textbookService.getTextbookSuppList(currentPage);
		
		model.addAttribute("title", "교재지급내역 페이지");
		model.addAttribute("mainTitle", "교재지급내역 페이지");
		model.addAttribute("currentPage",currentPage);
		model.addAttribute("getTextbookSuppList", getTextbookSuppList.get("getTextbookSuppList"));
		model.addAttribute("lastPage", getTextbookSuppList.get("lastPage"));
		model.addAttribute("startPageNum", getTextbookSuppList.get("startPageNum"));
		model.addAttribute("lastPageNum", getTextbookSuppList.get("lastPageNum"));	
		
		return "textbookresource/textbookSupplyList";
	}
	
	//교재 기초정보 등록
	@PostMapping("/textbookInfoRegister")
	public String textbookInfoRegister(Model model
									,TextbookBasicInfo txbBasicInfo
									,HttpSession session) {
		
		textbookService.addTextbookInfo(txbBasicInfo);
		String txbInfoCode = textbookService.getAddTxbInfoCode();
		TextbookBasicInfo textbookBasicInfo = textbookService.getOnlyTxbInfo(txbInfoCode);
		String sessionName = session.getAttribute("SNAME").toString();
		logger.info(txbInfoCode);
		logger.info(textbookBasicInfo.toString());
		model.addAttribute("title", "교재등록 완료  페이지");
		model.addAttribute("mainTitle", "교재등록 완료 페이지");
		model.addAttribute("regResult", "다음과 같은 정보로 등록되었습니다");
		model.addAttribute("txbInfoCode", txbInfoCode);
		model.addAttribute("textbookBasicInfo", textbookBasicInfo);
		model.addAttribute("sessionName", sessionName);
		return "textbookresource/textbookRegResult";
	}
	
	//교재 기초정보 등록
	@GetMapping("/textbookInfoRegister")
	public String textbookInfoRegister(Model model
									,HttpSession session) {
		
		String txbCode = textbookService.getTxbInfoMaxCode();
		String sessionId = session.getAttribute("SID").toString();
		String sessionName = session.getAttribute("SNAME").toString();
		logger.info(txbCode + " < -- txbCode");
		logger.info(sessionId + " < -- sessionId");
		model.addAttribute("title", "교재기본정보등록  페이지");
		model.addAttribute("mainTitle", "교재기본정보등록 페이지");
		model.addAttribute("txbCode", txbCode);
		model.addAttribute("sessionId", sessionId);
		model.addAttribute("sessionName", sessionName);
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
		List<TextbookBasicInfo> textbookinfolist = textbookService.getTextbookInfo();
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
	
	/*
	 * //교재등록선택페이지
	 * 
	 * @GetMapping("/textbookRegister") public String textbookRegister(Model model)
	 * {
	 * 
	 * model.addAttribute("title", "교재등록 선택 페이지"); model.addAttribute("mainTitle",
	 * "교재등록 선택 페이지");
	 * 
	 * return "textbookresource/textbookRegister"; }
	 */
	
	//교재보유목록 
	@GetMapping("/textbookOwnList")
	public String getTextbookOwnList(Model model
									,@RequestParam(
												  value="currentPage"
												, required = false
												, defaultValue = "1") int currentPage) {
		
		Map<String, Object> textbookOwnList = textbookService.getTextbookOwnList(currentPage);
		model.addAttribute("title", "교재보유현황 페이지");
		model.addAttribute("mainTitle", "교재보유현황 페이지");
		model.addAttribute("getTextbookList", textbookOwnList.get("textbookOwnList"));
		model.addAttribute("currentPage",currentPage);
		model.addAttribute("lastPage", textbookOwnList.get("lastPage"));
		model.addAttribute("startPageNum", textbookOwnList.get("startPageNum"));
		model.addAttribute("lastPageNum", textbookOwnList.get("lastPageNum"));
		
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
	public String getTextbookInfoList(Model model
								,@RequestParam(
											  value="currentPage"
											, required = false
											, defaultValue = "1") int currentPage) {
			Map<String,Object> textbookinfolist = textbookService.getTextbookInfoList(currentPage);
			model.addAttribute("title", "교재목록페이지");
			model.addAttribute("mainTitle", "교재목록페이지");
			model.addAttribute("currentPage",currentPage);
			model.addAttribute("textbookInfoList", textbookinfolist.get("textbookinfolist"));
			model.addAttribute("lastPage", textbookinfolist.get("lastPage"));
			model.addAttribute("startPageNum", textbookinfolist.get("startPageNum"));
			model.addAttribute("lastPageNum", textbookinfolist.get("lastPageNum"));
			
		return "textbookresource/textbookInfoList";
	}
	
}
