package cafe24.wio.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafe24.wio.bean.Consulting;
import cafe24.wio.mapper.ConsultingMapper;

@Service
public class ConsultingService {
		
	@Autowired
	private ConsultingMapper consultingMapper;
	
	
	public List<Map<String, Object>> SelectTeacher() {
		List<Map<String, Object>> TeacherName = consultingMapper.SelectTeacher();
		System.out.println(TeacherName);
		return TeacherName;
	}
	public List<Map<String, Object>> SelectLecName() {
		List<Map<String, Object>> SelectLecName = consultingMapper.SelectLecName();
		System.out.println(SelectLecName);
		return SelectLecName;
	}
	public int addConsultingWrite(Consulting consulting) {
		int result = consultingMapper.addConsultingWrite(consulting);
		return result;
		
	}
	public Map<String, Object> consultingList(int currentPage) {
		   
	      //보여줄 행의 갯수
	      final int ROW_PER_PAGE = 10;
	      
	      //보여줄 행의 시작점 초기화
	      int startRow = 0;
	      
	      //시작페이지번호, 끝페이지번호
	      int startPageNum = 1;
	      int lastPageNum = ROW_PER_PAGE;
	      
	      //6번째 가운데 위치
	      if(currentPage > (ROW_PER_PAGE/2)) {
	         startPageNum = currentPage - ((lastPageNum/2)-1);
	         lastPageNum += startPageNum;
	      }
	      
	      //페이징 알고리즘
	      startRow = (currentPage - 1) * ROW_PER_PAGE ;
	      
	      Map<String,Object> parameterMap = new HashMap<String,Object>();
	            
	      parameterMap.put("startRow", startRow);
	      parameterMap.put("rowPerPage", ROW_PER_PAGE);
	      
	      double totalRowCount = consultingMapper.consultingListCount();
	      
	      int lastPage = (int)Math.ceil((totalRowCount / ROW_PER_PAGE));
	      
	      List<Map<String,Object>> consultingList = consultingMapper.consultingList(parameterMap);
	      
	      if(currentPage >= (lastPage-4)) {
	         lastPageNum = lastPage;
	      }
	      
	      Map<String,Object> resultMap = new HashMap<String,Object>();
	      resultMap.put("consultingList", consultingList);
	      resultMap.put("lastPage", lastPage);
	      resultMap.put("startPageNum", startPageNum);
	      resultMap.put("lastPageNum", lastPageNum);
	      
	      return resultMap;     
	}

}
