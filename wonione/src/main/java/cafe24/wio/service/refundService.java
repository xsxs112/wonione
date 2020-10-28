package cafe24.wio.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class refundService {
	
	@Autowired
	private cafe24.wio.mapper.refundMapper refundMapper;
	
	//환불신청페이지
	public Map<String, Object> refundApplication(int currentPage, String sessionId) {
		//보여줄 행의 갯수
	      final int ROW_PER_PAGE = 10;
	      
	      //보여줄 행의 시작점 초기화
	      int startRow = 0;
	      
	      //시작페이지번호, 끝페이지번호
	      int startPageNum = 1;
	      int lastPageNum = ROW_PER_PAGE;
	     
	      
	      //페이징 알고리즘
	      startRow = (currentPage - 1) * ROW_PER_PAGE ;
	      
	      Map<String,Object> parameterMap = new HashMap<String,Object>();
	            
	      parameterMap.put("startRow", startRow);
	      parameterMap.put("rowPerPage", ROW_PER_PAGE);
	      parameterMap.put("sessionId", sessionId);
	      
	      double totalRowCount = refundMapper.refundCount(sessionId);
	      System.out.println(sessionId+"<----sessionId----");
	      
	      int lastPage = (int)Math.ceil((totalRowCount / ROW_PER_PAGE));
	      
	      List<Map<String,Object>> refundList = refundMapper.refundList(parameterMap);
	      
	      if(currentPage >= (lastPage-4)) {
	         lastPageNum = lastPage;
	      }
	      
	      Map<String,Object> resultMap = new HashMap<String,Object>();
	      resultMap.put("refundList", refundList);
	      resultMap.put("lastPage", lastPage);
	      resultMap.put("startPageNum", startPageNum);
	      resultMap.put("lastPageNum", lastPageNum);
	      
	      return resultMap;
	}

}
