package cafe24.wio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cafe24.wio.bean.Grade;
import cafe24.wio.service.GradeService;
@Controller
public class GradeController {
	@Autowired
	private GradeService gradeService;
	
	//성적리스트조회
	//@GetMapping("/getGradeList")
	@RequestMapping(value="/getGradeList" ,method= RequestMethod.GET)
	public String getGradeList(Grade grade, Model model) {
		List<Grade> gradeList = gradeService.getGradeList(grade);
		System.out.println("gradeList-->"+gradeList);
		
		model.addAttribute("gradeList", gradeList);
		model.addAttribute("title", "성적리스트조회");
		
		return "grade/gradeList";
		
	}

	//성적상세보기리스트
	@GetMapping("/gradePage")
	public String getGradeDetailList(Grade grade, Model model) {
		List<Grade> gradeList = gradeService.getGradeDetailList(grade);
		System.out.println("getGradeDetailList-->"+gradeList);
		model.addAttribute("gradeList", gradeList);
		model.addAttribute("title", "성적상세보기리스트");
		return "grade/gradePage";
	}
	
	
	
	
}
