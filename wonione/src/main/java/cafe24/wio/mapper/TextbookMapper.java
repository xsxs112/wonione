package cafe24.wio.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cafe24.wio.bean.SupplyTextbook;
import cafe24.wio.bean.TextbookBasicInfo;
import cafe24.wio.bean.WhTextbook;

@Mapper
public interface TextbookMapper {
	
	//교재 지급내역 조회
	public List<SupplyTextbook> getTextbookSuppList();
	
	//교재코드로 교재정보 가져오기 
	public TextbookBasicInfo getOnlyTxbInfo(String txbInfoCode);
	
	//교재정보등록시 삽입될 코드(PK) 가져오기 
	public String getAddTxbInfoCode();
	
	//교재기초정보리스트
	public List<TextbookBasicInfo> getTextbookInfoList(TextbookBasicInfo txbBasicInfo);

	//교재보유리스트(입고/재고)
	public List<TextbookBasicInfo> getTextbookOwnList(WhTextbook whTextbook);
	
	//최초 입고등록
	public int addFirstWhTextbook(WhTextbook whTextbook);
	
	//교재입고내역 존재유무 체크
	public List<TextbookBasicInfo> wahoTextbookCheck(WhTextbook whTextbook);
	
	//교재입고등록
	public int addWhTextbook(WhTextbook whTextbook);
	
	//교재입고리스트
	public List<WhTextbook> getWhTextbookList();
	
	//교재기초정보등록
	public int addTextbookInfo(TextbookBasicInfo txbBasicInfo);
	
	
	
}
