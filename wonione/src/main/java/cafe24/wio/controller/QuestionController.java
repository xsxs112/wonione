package cafe24.wio.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
			Map<String,Object> questionMap = questionService.question(currentPage);
			model.addAttribute("lastPage", questionMap.get("lastPage"));
			model.addAttribute("Question", questionMap.get("Question"));
			model.addAttribute("startPageNum", questionMap.get("startPageNum"));
			model.addAttribute("lastPageNum", questionMap.get("lastPageNum"));
			model.addAttribute("currentPage",currentPage);         
		return "question/Question";
	}

}
