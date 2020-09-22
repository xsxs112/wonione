package cafe24.wio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String getGradeDetailList(Model model,
									@RequestParam(value="gradeManCode", required = false) String gradeManCode) {
		List<Grade> grade = gradeService.getGradeDetailList(gradeManCode);
		System.out.println("getGradeDetailList-->"+grade);
		model.addAttribute("Grade", grade);
		model.addAttribute("title", "성적상세보기리스트");
		return "grade/gradePage";
	}
	
	//조건검색
	@PostMapping("/serchGrade")
	public String serchGrade(Model model
							,@RequestParam(value="lecGd", required = false)String lecGd
							,@RequestParam(value="lecGds", required = false)String lecGds) {
		List<Grade> gradeList = gradeService.searchGrade(lecGd, lecGds);
		System.out.println("serchGrade gradeList-->"+gradeList);
		model.addAttribute("gradeList",gradeList );
		
		return "grade/gradeList" ;
		
	}
	
	//조건검색
	@GetMapping(value="/gradeList" , produces="application/json")
	@ResponseBody
	public List<Grade> searchGrade(Model model
							,@RequestParam(value="lecGd", required = false)String lecGd
							,@RequestParam(value="lecGds", required = false)String lecGds) {
		List<Grade> gradeList = gradeService.searchGrade(lecGd, lecGds);
		model.addAttribute("gradeList", gradeList);
		return gradeList;
		
	}
	
	
}
