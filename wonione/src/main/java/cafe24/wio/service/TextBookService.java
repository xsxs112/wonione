package cafe24.wio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafe24.wio.bean.TextbookBasicInfo;
import cafe24.wio.mapper.TextbookMapper;

@Service
public class TextBookService {
	
	@Autowired
	private TextbookMapper textbookMapper;
	
	public List<TextbookBasicInfo> getTextbookInfoList(TextbookBasicInfo txbBasicInfo){
		textbookMapper.getTextbookInfoList(txbBasicInfo);
		
		
		return null;
	}
}
