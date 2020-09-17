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
	 * 교재 지급내역 조회
	 * @return List<SupplyTextbook> getTextbookSuppList
	 */
	public List<SupplyTextbook> getTextbookSuppList(){
		List<SupplyTextbook> getTextbookSuppList = textbookMapper.getTextbookSuppList();
		return getTextbookSuppList;
	}
	
	/**
	 * 교재코드로 교재정보 가져오기 
	 * @param txbInfoCode
	 * @return TextbookBasicInfo textbookBasicInfo
	 */
	public TextbookBasicInfo getOnlyTxbInfo(String txbInfoCode) {
		TextbookBasicInfo textbookBasicInfo = textbookMapper.getOnlyTxbInfo(txbInfoCode);
		
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
	 * @return List<TextbookBasicInfo> wahoTextbookCheck
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
	 * @return List<WhTextbook> whTextbookList
	 */
	public List<WhTextbook> getWhTextbookList(){
		
		List<WhTextbook> whTextbookList = textbookMapper.getWhTextbookList();
		
		return whTextbookList;
	}
	
	/**
	 * 교재 기초정보 조회
	 * @param txbBasicInfo
	 * @return List<TextbookBasicInfo> textbookinfolist
	 */
	public List<TextbookBasicInfo> getTextbookInfoList(TextbookBasicInfo txbBasicInfo){
		List<TextbookBasicInfo> textbookinfolist = textbookMapper.getTextbookInfoList(txbBasicInfo);
		
		return textbookinfolist;
	}
	
	/**
	 * 보유 교재리스트 조회
	 * @param whTextbook
	 * @return List<TextbookBasicInfo> textbookOwnList
	 */
	public List<TextbookBasicInfo> getTextbookOwnList(WhTextbook whTextbook){
		List<TextbookBasicInfo> textbookOwnList = textbookMapper.getTextbookOwnList(whTextbook);
		return textbookOwnList;
	}
	

}
