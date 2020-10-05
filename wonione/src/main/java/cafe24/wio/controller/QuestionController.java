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
	@GetMapping(value= "/QuestionScoreCheckdate" ,produces = "application/json")
	@ResponseBody
	public int QuestionScoreCheckdate(@RequestParam(value="qeAnswer",required = false) String qeAnswer
										,@RequestParam(value="qeCode",required = false) int qeCode
										,HttpSession session){
		String StudentName = (String) session.getAttribute("SID");
		questionService.QuestionScoreCheck(qeAnswer,StudentName,qeCode);
		return 0;
	}
	@GetMapping("/scoreCheck")
	public String scoreCheck() {
		return "question/scoreCheck";
		
	}
	@PostMapping(value = "/ScoreCheck" ,produces = "application/json")
	@ResponseBody
	public Map<String, Object> ScoreCheck(@RequestParam(value="scoreSid",required = false) String scoreSid) {
		Map<String,Object>scoreSidMap = questionService.ScoreCheck(scoreSid);
		return scoreSidMap;
	}
	
	@PostMapping(value = "/QuestionSidCheck" ,produces = "application/json")
	@ResponseBody
	public int QuestionSidCheck(@RequestParam(value="questionSid",required = false) String questionSid
							   ,@RequestParam(value="questionName",required = false) String questionName) {
		int result = questionService.QuestionSidCheck(questionSid,questionName);
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
		questionService.insertQuestionTitle(question);
		return 0; 
	}
	//문제등록
	@PostMapping("/insertQuestion")
	public void insertQuestion(cafe24.wio.bean.Question question
								,HttpServletResponse response) throws IOException {
		questionService.insertQuestion(question);
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<script>alert('등록되었습니다.'); location.href='secondsPage';</script>");
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
		questionService.deleteQuestionTitle(questionName);
		return 0;
	}
	@GetMapping("/deleteQuestionTitle")
	public String deleteQuestionTitle() {
		
		return "redirect:/QuestionList";
	}
	//타이틀안 문제등록전 리스트
	@RequestMapping(value="/modifyQuestionList", method=RequestMethod.GET)
	public String modifyQuestionList(Model model
									,@RequestParam(value="qtCodeName",required = false) String qtCodeName
									,@RequestParam(value="currentPage", required = false, defaultValue = "1") int currentPage) {
		Map<String,Object> modifyQuestionMap = questionService.modifyQuestionList(currentPage, qtCodeName);
		model.addAttribute("lastPage", modifyQuestionMap.get("lastPage"));
		model.addAttribute("modifyQuestionList", modifyQuestionMap.get("modifyQuestionList"));
		model.addAttribute("startPageNum", modifyQuestionMap.get("startPageNum"));
		model.addAttribute("lastPageNum", modifyQuestionMap.get("lastPageNum"));
		model.addAttribute("currentPage",currentPage); 
		return "question/modifyQuestionList";
	}
	//문제등록전 리스트상세보기
	@PostMapping(value="/modifyQuestionListView",produces = "application/json")
	@ResponseBody
	public Map<String, Object> modifyQuestionListView(@RequestParam(value="qeCode",required = false) String qeCode){
		Map<String, Object> modifyQuestionListViewResult = questionService.modifyQuestionListView(qeCode);
		return modifyQuestionListViewResult;
	}
	
}
