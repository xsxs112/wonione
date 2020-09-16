package cafe24.wio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafe24.wio.bean.TextbookBasicInfo;
import cafe24.wio.bean.WhTextbook;
import cafe24.wio.mapper.TextbookMapper;

@Service
public class TextbookService {
	
	@Autowired
	private TextbookMapper textbookMapper;
	
	public List<TextbookBasicInfo> getTextbookInfoList(TextbookBasicInfo txbBasicInfo){
		List<TextbookBasicInfo> textbookinfolist = textbookMapper.getTextbookInfoList(txbBasicInfo);
		
		return textbookinfolist;
	}
	
	public List<TextbookBasicInfo> getTextbookOwnList(WhTextbook whTextbook){
		List<TextbookBasicInfo> textbookOwnList = textbookMapper.getTextbookOwnList(whTextbook);
		return textbookOwnList;
	}
	public int addWhTextbook(WhTextbook whTextbook) {
		
		int addWhTxbResult = textbookMapper.addWhTextbook(whTextbook);
		return addWhTxbResult;
	}
}
