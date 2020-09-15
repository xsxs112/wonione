package cafe24.wio.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cafe24.wio.bean.TextbookBasicInfo;

@Mapper
public interface TextbookMapper {
	
	public List<TextbookBasicInfo> getTextbookInfoList(TextbookBasicInfo txbBasicInfo);

	public List<TextbookBasicInfo> getTextbookOwnList(TextbookBasicInfo txbBasicInfo);
}
