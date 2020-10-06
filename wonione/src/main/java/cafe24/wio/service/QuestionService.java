package cafe24.wio.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafe24.wio.bean.Question;
import cafe24.wio.mapper.QuestionMapper;

@Service
public class QuestionService {
	@Autowired
	private QuestionMapper questionMapper;
		
	


	public Map<String, Object> questionList(int currentPage) {
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
	      
	      double totalRowCount = questionMapper.QuestionListCount();
	      
	      int lastPage = (int)Math.ceil((totalRowCount / ROW_PER_PAGE));
	      
	      List<Map<String,Object>> QuestionList = questionMapper.QuestionList(parameterMap);
	      
	      if(currentPage >= (lastPage-4)) {
	         lastPageNum = lastPage;
	      }
	      
	      Map<String,Object> resultMap = new HashMap<String,Object>();
	      resultMap.put("QuestionList", QuestionList);
	      resultMap.put("lastPage", lastPage);
	      resultMap.put("startPageNum", startPageNum);
	      resultMap.put("lastPageNum", lastPageNum);
	      
	      return resultMap;
	}

	public Map<String, Object> question(int currentPage, String questionName) {
			//보여줄 행의 갯수
	      final int ROW_PER_PAGE = 1;
	      
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
	      parameterMap.put("questionName", questionName);
	      
	      double totalRowCount = questionMapper.QuestionCount(questionName);
	      
	      int lastPage = (int)Math.ceil((totalRowCount / ROW_PER_PAGE));
	      
	      List<Map<String,Object>> Question = questionMapper.Question(parameterMap);
	      
	      if(currentPage >= (lastPage-20)) {
	         lastPageNum = lastPage;
	      }
	      
	      Map<String,Object> resultMap = new HashMap<String,Object>();
	      resultMap.put("Question", Question);
	      resultMap.put("lastPage", lastPage);
	      resultMap.put("startPageNum", startPageNum);
	      resultMap.put("lastPageNum", lastPageNum);
	      
	      return resultMap;
	}

	public int QuestionScoreCheck(String qeAnswer, String studentName, int qeCode) {
		int result= questionMapper.QuestionScoreCheck(qeAnswer,qeCode,studentName);
		
		return result;
	}

	public Map<String, Object> ScoreCheck(String scoreSid) {
		Map<String, Object> scoreSidMap = questionMapper.ScoreCheck(scoreSid);
		return scoreSidMap;
	}

	public String QuestionSidCheck(String questionSid, String questionName) {
		String result = questionMapper.QuestionSidCheck(questionSid,questionName);
		return result;
	}

	

	public int insertQuestionTitle(Question question) {
		int insertQuestionTitleResultResult = questionMapper.insertQuestionTitle(question);
		return insertQuestionTitleResultResult;
	}

	public int deleteQuestionTitle(String questionName) {
		int deleteQuestionTitleResult = questionMapper.deleteQuestionTitle(questionName);
		return deleteQuestionTitleResult;
	}

	public Map<String, Object> titleQuestionList(int currentPage, String qtCodeName) {
		//보여줄 행의 갯수
	    final int ROW_PER_PAGE = 5;
	      
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
	    parameterMap.put("qtCodeName", qtCodeName);
	    
	    double totalRowCount = questionMapper.titleQuestionListCount(qtCodeName);
	      
	    int lastPage = (int)Math.ceil((totalRowCount / ROW_PER_PAGE));
  
	    List<Map<String,Object>> titleQuestionList = questionMapper.titleQuestionList(parameterMap);
  
		if(currentPage >= (lastPage-4)) {
		lastPageNum = lastPage;
		}
  
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("titleQuestionList", titleQuestionList);
		resultMap.put("lastPage", lastPage);
		resultMap.put("startPageNum", startPageNum);
		resultMap.put("lastPageNum", lastPageNum);
	
		return resultMap;
	}

	public Map<String, Object> titleQuestionListView(String qeCode) {
		Map<String, Object> titleQuestionListViewRsult = questionMapper.titleQuestionListView(qeCode);
		return titleQuestionListViewRsult;
	}

	public int insertQuestion(Question question) {
		int result = questionMapper.insertQuestion(question);
		return result;
	}

	public void modifyQuestion(Question question) {
		questionMapper.modifyQuestion(question);
	}

	public int deleteQuestion(int qeCode) {
		int deleteQuestionResult = questionMapper.deleteQuestion(qeCode);
		return deleteQuestionResult;
	}

	public int modifyQuestionTitle(String questionCodeName, String questionTitle, String qtCodeSubName) {
		int modifyQuestionTitleResult = questionMapper.modifyQuestionTitle(questionCodeName,questionTitle,qtCodeSubName);
		return modifyQuestionTitleResult;
	}

	public int QuestionTitleNameCheck(String questionCodeName) {
		int QuestionTitleNameCheckResult = questionMapper.QuestionTitleNameCheck(questionCodeName);
		return QuestionTitleNameCheckResult;
	}
	//인원확인
	public Map<String, Object> candidateQuestionList(int currentPage, String qtCodeName) {
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
	    parameterMap.put("qtCodeName", qtCodeName);
	    
	    double totalRowCount = questionMapper.candidateQuestionListCount(qtCodeName);
	      
	    int lastPage = (int)Math.ceil((totalRowCount / ROW_PER_PAGE));
  
	    List<Map<String,Object>> candidateQuestionList = questionMapper.candidateQuestionList(parameterMap);
  
		if(currentPage >= (lastPage-4)) {
		lastPageNum = lastPage;
		}
  
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("candidateQuestionList", candidateQuestionList);
		resultMap.put("lastPage", lastPage);
		resultMap.put("startPageNum", startPageNum);
		resultMap.put("lastPageNum", lastPageNum);
	
		return resultMap;
	}

	public Map<String, Object> questionScoreCheck(String questionSid, String questionCodeName) {
		Map<String, Object> questionScoreCheckResult = questionMapper.questionScoreCheck(questionSid,questionCodeName);
		return questionScoreCheckResult;
	}

	
}
