package cafe24.wio.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cafe24.wio.bean.TextbookBasicInfo;
import cafe24.wio.bean.WhTextbook;

@Mapper
public interface TextbookMapper {
	
	public List<TextbookBasicInfo> getTextbookInfoList(TextbookBasicInfo txbBasicInfo);

	public List<TextbookBasicInfo> getTextbookOwnList(WhTextbook whTextbook);
	
	public int addWhTextbook(WhTextbook whTextbook);
}
