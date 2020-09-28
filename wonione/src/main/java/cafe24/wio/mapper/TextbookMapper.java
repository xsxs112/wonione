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
	//교재 지급내역 검색
	public List<SupplyTextbook> getSuppTxbSearch(String suppTxbSk, String suppTxbSv);
	
	//교재 지급내역 조회
	public List<SupplyTextbook> getTextbookSuppList();
	
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
	public List<TextbookBasicInfo> getWhTxbSearch(String whTxbSk, String whTxbSv);
	
	//교재입고코드 maxcount
	public String getTxbWhMaxCode();
	
	//교재입고내역 존재유무 체크
	public TextbookBasicInfo wahoTextbookCheck(String txbCode);
	
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
	
	//교재기초정보리스트
	public List<TextbookBasicInfo> getTextbookInfoList();
	
	//교재기초정보등록
	public int addTextbookInfo(TextbookBasicInfo txbBasicInfo);
	
	
	
}
