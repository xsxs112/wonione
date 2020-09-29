package cafe24.wio.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	@GetMapping("/insertQuestionTitle")
	public String insertQuestionTitle() {
		
		return "question/insertQuestionTitle";
	}
	@GetMapping("/insertQuestion")
	public String insertQuestion() {
		
		return "question/insertQuestion";
	}
	@PostMapping(value="/selectIdQuestion" , produces = "application/json")
	@ResponseBody
	public int selectIdQuestion(@RequestParam(value="questionSid",required = false) String questionSid) {
		int result = questionService.selectIdQuestion(questionSid);
		return result;
	}
	@PostMapping(value="/insertQuestionTitle", produces = "application/json")
	@ResponseBody
	public int insertQuestionTitle(cafe24.wio.bean.Question question) {
		questionService.insertQuestion(question);
		return 0; 
	}

}
