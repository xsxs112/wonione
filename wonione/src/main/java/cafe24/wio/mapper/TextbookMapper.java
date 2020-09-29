package cafe24.wio.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cafe24.wio.bean.SupplyTextbook;
import cafe24.wio.bean.TextbookBasicInfo;
import cafe24.wio.bean.WhTextbook;

@Mapper
public interface TextbookMapper {
	
	/************************************************
	 * 교재지급
	 *************************************************/
	//가장 최근날짜의 재고수량 조회
	public int getStockTxbQuantity(String txbCode);
	
	//교재지급대상(학생)을 조회
	public List<Map<String,Object>> selectStudent();
	
	//교재지급등록
	public int addTxbSupply(SupplyTextbook suppTxb);
	
	//페이징을 위한 지급내역 카운팅
	public int countSuppTxb();
		
	//교재 지급내역 검색
	public List<SupplyTextbook> getSuppTxbSearch(String suppTxbSk, String suppTxbSv);
	
	//교재 지급내역 조회
	public List<SupplyTextbook> getTextbookSupp();
	
	//교재 지급내역 페이징
	public List<SupplyTextbook> getTextbookSuppList(Map<String,Object> txbMap);
	
	//교재지급코드 maxcount
	public String getTxbSuppMaxCode();

	
	/************************************************
	 * 교재입고
	 *************************************************/
	//페이징을 위한 입고내역 카운팅
	public int countWhTxb();
	
	//가장 마지막에 등록한 입고정보 가져오기
	public WhTextbook getRecentTxbWhList();
	
	//교재보유리스트(입고/재고)
	public List<Map<String, Object>> getTextbookOwnList(Map<String,Object> txbMap);
	
	//최초 입고등록
	public int addFirstWhTextbook(WhTextbook whTextbook);
	
	//교재 입고내역 검색
	public List<Map<String, Object>> getWhTxbSearch(String whTxbSk, String whTxbSv);
	
	//교재입고코드 maxcount
	public String getTxbWhMaxCode();
	
	//교재입고내역 존재유무 체크
	public Map<String,Object> wahoTextbookCheck(String txbCode);
	
	//교재입고등록
	public int addWhTextbook(WhTextbook whTextbook);
	
	//교재입고리스트
	public List<WhTextbook> getWhTextbookList();
	
	
	/************************************************
	 * 교재정보
	 *************************************************/
	//교재 정보 검색
	public List<TextbookBasicInfo> getTxbInfoSearch(String infoTxbSk, String infoTxbSv);
	
	//교재정보코드 maxcount
	public String getTxbInfoMaxCode();
	
	//교재코드로 교재정보 가져오기 
	public TextbookBasicInfo getOnlyTxbInfo(String txbCode);
	
	//교재정보등록시 삽입될 코드(PK) 가져오기 
	public String getAddTxbInfoCode();
	
	//페이징을 위한 교재정보 카운팅
	public int countTxb();
	
	//교재기초정보리스트
	public List<TextbookBasicInfo> getTextbookInfo();
	
	//교재기초정보리스트-페이징
	public List<TextbookBasicInfo> getTextbookInfoList(Map<String,Object> txbMap);
	
	//교재기초정보등록
	public int addTextbookInfo(TextbookBasicInfo txbBasicInfo);
	
	
	
}
