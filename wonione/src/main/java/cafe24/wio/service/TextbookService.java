package cafe24.wio.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafe24.wio.bean.SupplyTextbook;
import cafe24.wio.bean.TextbookBasicInfo;
import cafe24.wio.bean.WhTextbook;
import cafe24.wio.mapper.TextbookMapper;

@Service
public class TextbookService {
	
	
	private static final Logger logger = LoggerFactory.getLogger(TextbookService.class);

	@Autowired
	private TextbookMapper textbookMapper;

	/**
	 * 가장 마지막에 등록한 입고정보 가져오기
	 * @return WhTextbook txbWhResult
	 */
	public WhTextbook getRecentTxbWhList() {
		
		WhTextbook txbWhResult = textbookMapper.getRecentTxbWhList();
		
		return txbWhResult;
	}
	
	/**
	 * 교재 지급내역 검색
	 * @param suppSk
	 * @param suppTxbSv
	 * @return List SupplyTextbook suppTxbSearchResult
	 */
	public List<SupplyTextbook> getSuppTxbSearch(String suppTxbSk, String suppTxbSv){
		
		List<SupplyTextbook> suppTxbSearchResult = textbookMapper.getSuppTxbSearch(suppTxbSk, suppTxbSv);
		return suppTxbSearchResult;
	}
	
	/**
	 * 교재 정보 검색
	 * @param infoTxbSk
	 * @param infoTxbSv
	 * @return List TextbookBasicInfo txbInfoSearchResult
	 */
	public List<TextbookBasicInfo> getTxbInfoSearch(String infoTxbSk, String infoTxbSv){
		
		List<TextbookBasicInfo> txbInfoSearchResult = textbookMapper.getTxbInfoSearch(infoTxbSk, infoTxbSv);
		return txbInfoSearchResult;
	}
	
	
	/**
	 * 교재 입고내역 검색
	 * @param whTxbSk
	 * @param whTxbSv
	 * @return List WhTextbook whTxbSearchResult
	 */
	public List<TextbookBasicInfo> getWhTxbSearch(String whTxbSk, String whTxbSv){
		List<TextbookBasicInfo> whTxbSearchResult = textbookMapper.getWhTxbSearch(whTxbSk, whTxbSv);
		return whTxbSearchResult;
	}
	
	/**
	 * 교재 지급내역 조회
	 * @return List SupplyTextbook getTextbookSuppList
	 */
	public List<SupplyTextbook> getTextbookSuppList(){
		List<SupplyTextbook> getTextbookSuppList = textbookMapper.getTextbookSuppList();
		return getTextbookSuppList;
	}
	
	/**
	 * 교재지급코드 maxcount
	 * 코드자동증가
	 * @return String supTxbCode
	 */
	public String getTxbSuppMaxCode() {
		String txbSuppMaxcode = textbookMapper.getTxbSuppMaxCode();
		String tempCode = null;
		String supTxbCode = null;
		int maxCode = 0;
		if(txbSuppMaxcode != null && !"".equals(txbSuppMaxcode)) {
			maxCode = Integer.parseInt(txbSuppMaxcode);
			if(maxCode <10) {
				tempCode = "suptxb_0000";
			}else if(10<=maxCode && maxCode <100) {
				tempCode = "suptxb_000";
			}else if(100<=maxCode && maxCode <1000) {
				tempCode = "suptxb_00";
			}
		}
		supTxbCode = tempCode + maxCode;
		
		return supTxbCode;
	}
	
	/**
	 * 교재입고코드 maxcount
	 * 코드자동증가
	 * @return String whEqCode
	 */
	public String getTxbWhMaxCode() {
		String txbWhMaxcode = textbookMapper.getTxbWhMaxCode();
		String tempCode = null;
		String whTxbCode = null;
		int maxCode = 0;
		if(txbWhMaxcode != null && !"".equals(txbWhMaxcode)) {
			maxCode = Integer.parseInt(txbWhMaxcode);
			if(maxCode <10) {
				tempCode = "wh_txb_code0000";
			}else if(10<=maxCode && maxCode <100) {
				tempCode = "wh_txb_code000";
			}else if(100<=maxCode && maxCode <1000) {
				tempCode = "wh_txb_code00";
			}
		}
		whTxbCode = tempCode + maxCode;
		
		return whTxbCode;
	}
	
	/**
	 * 교재정보코드 maxcount
	 * 코드자동증가
	 * @return String txbCode
	 */
	public String getTxbInfoMaxCode() {
		String txbInfoMaxcode = textbookMapper.getTxbInfoMaxCode();
		String tempCode = null;
		String txbCode = null;
		int maxCode = 0;
		if(txbInfoMaxcode != null && !"".equals(txbInfoMaxcode)) {
			maxCode = Integer.parseInt(txbInfoMaxcode);
			if(maxCode <10) {
				tempCode = "txb_0000";
			}else if(10<=maxCode && maxCode <100) {
				tempCode = "txb_000";
			}else if(100<=maxCode && maxCode <1000) {
				tempCode = "txb_00";
			}
		}
		txbCode = tempCode + maxCode;
		
		return txbCode;
	}
	
	/**
	 * 교재코드로 교재정보 가져오기 
	 * @param txbInfoCode
	 * @return TextbookBasicInfo textbookBasicInfo
	 */
	public TextbookBasicInfo getOnlyTxbInfo(String txbCode) {
		TextbookBasicInfo textbookBasicInfo = textbookMapper.getOnlyTxbInfo(txbCode);
		return textbookBasicInfo;
	}
	
	/**
	 * 교재정보등록시 삽입될 코드(PK) 가져오기 
	 * @return String txbInfoCode
	 */
	public String getAddTxbInfoCode() {
		
		String txbInfoCode = textbookMapper.getAddTxbInfoCode();
		
		return txbInfoCode;
	}
	
	/**
	 * 교재 기초정보 등록
	 * @param txbBasicInfo
	 * @return int addTxbInfoResult
	 */
	public int addTextbookInfo(TextbookBasicInfo txbBasicInfo) {
			int addTxbInfoResult = textbookMapper.addTextbookInfo(txbBasicInfo);
		return addTxbInfoResult;
	}
	
	/**
	 * 교재 최초입고등록
	 * @param whTextbook
	 * @return int addFirstWhTxbResult
	 */
	public int addFirstWhTextbook(WhTextbook whTextbook) {
		
		int addFirstWhTxbResult = textbookMapper.addFirstWhTextbook(whTextbook);
		
		return addFirstWhTxbResult;
	}
	
	/**
	 * 교재입고내역 존재유무 체크
	 * @param whTextbook
	 * @return TextbookBasicInfo wahoTextbookCheck
	 */
	public TextbookBasicInfo wahoTextbookCheck(String txbCode){
		
		TextbookBasicInfo wahoTextbookCheck = textbookMapper.wahoTextbookCheck(txbCode);
		
		return wahoTextbookCheck;
	}
	
	/**
	 * 교재 입고등록
	 * @param whTextbook
	 * @return int addWhTxbResult
	 */
	public int addWhTextbook(WhTextbook whTextbook) {
		
		int addWhTxbResult = textbookMapper.addWhTextbook(whTextbook);
		
		return addWhTxbResult;
	}
	
	/**
	 * 교재 입고 테이블 조회
	 * @return List WhTextbook whTextbookList
	 */
	public List<WhTextbook> getWhTextbookList(){
		
		List<WhTextbook> whTextbookList = textbookMapper.getWhTextbookList();
		
		return whTextbookList;
	}
	
	/**
	 * 교재 기초정보 조회
	 * @param txbBasicInfo
	 * @return List TextbookBasicInfo textbookinfolist
	 */
	public List<TextbookBasicInfo> getTextbookInfoList(){
		List<TextbookBasicInfo> textbookinfolist = textbookMapper.getTextbookInfoList();
		
		return textbookinfolist;
	}
	
	/**
	 * 보유 교재리스트 조회
	 * @param whTextbook
	 * @return List TextbookBasicInfo textbookOwnList
	 */
	public List<TextbookBasicInfo> getTextbookOwnList(){
		List<TextbookBasicInfo> textbookOwnList = textbookMapper.getTextbookOwnList();
		return textbookOwnList;
	}
	

}
