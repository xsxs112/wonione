package cafe24.wio.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cafe24.wio.service.QuestionService;

@Controller
public class QuestionController {
	

	@Autowired
	private QuestionService questionService;
	
	//문제리스트
	@GetMapping("/QuestionList")
	public String QuestionList(Model model
								,@RequestParam(value="currentPage", required = false, defaultValue = "1") int currentPage) {
			Map<String,Object> questionListMap = questionService.questionList(currentPage);
			model.addAttribute("lastPage", questionListMap.get("lastPage"));
			model.addAttribute("QuestionList", questionListMap.get("QuestionList"));
			model.addAttribute("startPageNum", questionListMap.get("startPageNum"));
			model.addAttribute("lastPageNum", questionListMap.get("lastPageNum"));
			model.addAttribute("currentPage",currentPage);         
		
		return "question/QuestionList";
	}
	//문제출제페이지
	@GetMapping("/Question")
	public String Question(Model model
							,@RequestParam(value="questionName", required = false) String questionName
							,@RequestParam(value="currentPage", required = false, defaultValue = "1") int currentPage) {
		
			Map<String,Object> questionMap = questionService.question(currentPage, questionName);
			model.addAttribute("lastPage", questionMap.get("lastPage"));
			model.addAttribute("Question", questionMap.get("Question"));
			model.addAttribute("startPageNum", questionMap.get("startPageNum"));
			model.addAttribute("lastPageNum", questionMap.get("lastPageNum"));
			model.addAttribute("currentPage",currentPage);         
		return "question/Question";
	}
	//정답체크ajax
	@GetMapping(value= "/QuestionScoreCheckdate" ,produces = "application/json")
	@ResponseBody
	public int QuestionScoreCheckdate(@RequestParam(value="qeAnswer",required = false) String qeAnswer
										,@RequestParam(value="qeCode",required = false) int qeCode
										,HttpSession session){
		String StudentName = (String) session.getAttribute("SID");
		questionService.QuestionScoreCheck(qeAnswer,StudentName,qeCode);
		return 0;
	}
	//점수체크페이지
	@GetMapping("/scoreCheck")
	public String scoreCheck() {
		return "question/scoreCheck";
		
	}
	//점수확인을 위한 아이디확인
	@PostMapping(value = "/ScoreCheck" ,produces = "application/json")
	@ResponseBody
	public Map<String, Object> ScoreCheck(@RequestParam(value="scoreSid",required = false) String scoreSid) {
		Map<String,Object>scoreSidMap = questionService.ScoreCheck(scoreSid);
		return scoreSidMap;
	}
	//한번푼문제에 대한 권한처리
	@PostMapping(value = "/QuestionSidCheck" ,produces = "application/json")
	@ResponseBody
	public String QuestionSidCheck(@RequestParam(value="questionSid",required = false) String questionSid
							   ,@RequestParam(value="questionName",required = false) String questionName) {
		String result = questionService.QuestionSidCheck(questionSid,questionName);
		return result;
	}
	//문제타이틀페이지
	@GetMapping("/insertQuestionTitle")
	public String insertQuestionTitle() {
		
		return "question/insertQuestionTitle";
	}
	//문제등록페이지
	@GetMapping("/insertQuestion")
	public String insertQuestion(Model model,
								@RequestParam(value="qtCodeName" ,required = false) String qtCodeName) {
		model.addAttribute("qtCodeName",qtCodeName);
		return "question/insertQuestion";
	}
	
	//문제타이틀등록
	@PostMapping(value="/insertQuestionTitle", produces = "application/json")
	@ResponseBody
	public int insertQuestionTitle(cafe24.wio.bean.Question question) {
		int result = 0;
		if(question != null){
			int insertQuestionTitleResult = questionService.insertQuestionTitle(question);
			return insertQuestionTitleResult; 
		}else{
			return result;
		}
	}
	//문제등록
	@PostMapping("/insertQuestion")
	public void insertQuestion(cafe24.wio.bean.Question question
								,HttpServletResponse response) throws IOException {
		questionService.insertQuestion(question);
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<script>alert('등록되었습니다.');opener.document.location.reload();self.close();</script>");
        out.flush();
	}
	//0.3초간 있을 페이지
	//바로 넘기면 값이 안넘어가기때문에 잠시동안 있을 페이지를 만든다.
	@GetMapping("/secondsPage")
	public String secondsPage() {
		return "question/secondsPage";
	}
	//타이틀삭제
	@PostMapping(value="/deleteQuestionTitle", produces = "application/json")
	@ResponseBody
	public int deleteQuestionTitle(@RequestParam(value="questionName",required = false) String questionName) {
		int deleteQuestionTitleResult = questionService.deleteQuestionTitle(questionName);
		return deleteQuestionTitleResult;
	}
	//타이틀내 문제등록전 리스트
	@RequestMapping(value="/titleQuestionList", method=RequestMethod.GET)
	public String modifyQuestionList(Model model
									,@RequestParam(value="qtCodeName",required = false) String qtCodeName
									,@RequestParam(value="currentPage", required = false, defaultValue = "1") int currentPage) {
		Map<String,Object> titleQuestionListMap = questionService.titleQuestionList(currentPage, qtCodeName);
		model.addAttribute("qtCodeName",qtCodeName);
		model.addAttribute("lastPage", titleQuestionListMap.get("lastPage"));
		model.addAttribute("titleQuestionList", titleQuestionListMap.get("titleQuestionList"));
		model.addAttribute("startPageNum", titleQuestionListMap.get("startPageNum"));
		model.addAttribute("lastPageNum", titleQuestionListMap.get("lastPageNum"));
		model.addAttribute("currentPage",currentPage); 
		return "question/titleQuestionList";
	}
	//문제등록전 리스트상세보기
	@PostMapping(value="/titleQuestionListView",produces = "application/json")
	@ResponseBody
	public Map<String, Object> titleQuestionListView(@RequestParam(value="qeCode",required = false) String qeCode){
		Map<String, Object> titleQuestionListViewViewResult = questionService.titleQuestionListView(qeCode);
		return titleQuestionListViewViewResult;
	}
	//타이틀내 문제수정
	@PostMapping("/modifyQuestion")
	public String modifyQuestion(cafe24.wio.bean.Question question
								,@RequestParam(value="qtCodeName",required = false) String qtCodeName){
		questionService.modifyQuestion(question);
		return "redirect:/titleQuestionList?qtCodeName="+qtCodeName;
	}
	//타이틀내 문제삭제
	@PostMapping(value="/deleteQuestion",produces = "application/json")
	@ResponseBody
	public int deleteQuestion(@RequestParam(value="deleteQeCode",required = false) int qeCode){
		int deleteQuestionResult = questionService.deleteQuestion(qeCode);
		return deleteQuestionResult;
	}
	//타이틀수정 ajax
	@PostMapping(value="/modifyQuestionTitle",produces = "application/json")
	@ResponseBody
	public int modifyQuestionTitle(@RequestParam(value="qtCodeName",required = false) String questionCodeName
								  ,@RequestParam(value="qtTitle",required = false) String questionTitle
							  	  ,@RequestParam(value="qtCodeSubName",required = false) String qtCodeSubName){
		int modifyQuestionTitleResult = questionService.modifyQuestionTitle(questionCodeName,questionTitle,qtCodeSubName);
		return modifyQuestionTitleResult;
	}
	//타이틀수정페이지
	@GetMapping("/modifyQuestionTitle")
	public String modifyQuestionTitle(Model model
									,@RequestParam(value="questionCodeName",required = false) String questionCodeName
									,@RequestParam(value="questionTitle",required = false) String questionTitle) {
		model.addAttribute("questionCodeName",questionCodeName);
		model.addAttribute("questionTitle",questionTitle);
		return "question/modifyQuestionTitle";
	}
	//타이틀수정전 이름체크
	@PostMapping(value="/QuestionTitleNameCheck",produces = "application/json")
	@ResponseBody
	public int QuestionTitleNameCheck(@RequestParam(value="qtCodeName",required = false) String questionCodeName){
		int QuestionTitleNameCheckResult = questionService.QuestionTitleNameCheck(questionCodeName);
		return QuestionTitleNameCheckResult;
	}
	//인원확인
	@GetMapping("/candidateQuestionList")
	public String candidateQuestionList(Model model
										,@RequestParam(value="qtCodeName", required = false) String qtCodeName
										,@RequestParam(value="currentPage", required = false, defaultValue = "1") int currentPage) {

		Map<String,Object> candidateQuestionListMap = questionService.candidateQuestionList(currentPage, qtCodeName);
		model.addAttribute("lastPage", candidateQuestionListMap.get("lastPage"));
		model.addAttribute("candidateQuestionList", candidateQuestionListMap.get("candidateQuestionList"));
		model.addAttribute("startPageNum", candidateQuestionListMap.get("startPageNum"));
		model.addAttribute("lastPageNum", candidateQuestionListMap.get("lastPageNum"));
		model.addAttribute("currentPage",currentPage);
		return "question/candidateQuestionList";
	}
	//학생시점 점수확인
	@PostMapping(value="/questionScoreCheck",produces = "application/json")
	@ResponseBody
	public Map<String, Object> questionScoreCheck(@RequestParam(value="questionSid",required = false) String questionSid
												 ,@RequestParam(value="questionCodeName",required = false) String questionCodeName){
		Map<String, Object> questionScoreCheckResult = questionService.questionScoreCheck(questionSid,questionCodeName);
		return questionScoreCheckResult;
	}
	
}
