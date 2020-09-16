package cafe24.wio.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cafe24.wio.bean.TextbookBasicInfo;
import cafe24.wio.bean.WhTextbook;

@Mapper
public interface TextbookMapper {
	
	//교재기초정보리스트
	public List<TextbookBasicInfo> getTextbookInfoList(TextbookBasicInfo txbBasicInfo);

	//교재보유리스트(입고/재고)
	public List<TextbookBasicInfo> getTextbookOwnList(WhTextbook whTextbook);
	
	//최초 입고등록
	public int addFirstWhTextbook(WhTextbook whTextbook);
	
	public List<TextbookBasicInfo> wahoTextbookCheck(WhTextbook whTextbook);
	
	//교재입고등록
	public int addWhTextbook(WhTextbook whTextbook);
	
	//교재입고리스트
	public List<WhTextbook> getWhTextbookList();
	
	//교재기초정보등록
	public int addTextbookInfo(TextbookBasicInfo txbBasicInfo);
	
	
	
}
