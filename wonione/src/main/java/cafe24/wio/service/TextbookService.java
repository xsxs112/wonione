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
	
	//교재 입고 테이블 조회
	public List<WhTextbook> getWhTextbookList(){
		
		List<WhTextbook> whTextbookList = textbookMapper.getWhTextbookList();
		
		return whTextbookList;
	}
	
	//교재 기초정보 조회
	public List<TextbookBasicInfo> getTextbookInfoList(TextbookBasicInfo txbBasicInfo){
		List<TextbookBasicInfo> textbookinfolist = textbookMapper.getTextbookInfoList(txbBasicInfo);
		
		return textbookinfolist;
	}
	
	//보유 교재리스트 조회
	public List<TextbookBasicInfo> getTextbookOwnList(WhTextbook whTextbook){
		List<TextbookBasicInfo> textbookOwnList = textbookMapper.getTextbookOwnList(whTextbook);
		return textbookOwnList;
	}
	
	//교재 입고등록
	public int addWhTextbook(WhTextbook whTextbook) {
		
		int addWhTxbResult = textbookMapper.addWhTextbook(whTextbook);
		return addWhTxbResult;
	}
}
