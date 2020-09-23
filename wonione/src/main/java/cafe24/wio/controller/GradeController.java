package cafe24.wio.controller;

import java.util.List;
import java.util.Map;

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

	// 성적리스트조회
	@RequestMapping(value = "/getGradeList", method = RequestMethod.GET)
	public String getGradeList(Grade grade, Model model) {
		List<Grade> gradeList = gradeService.getGradeList(grade);
		List<Map<String, Object>> sName = gradeService.sName();
		List<Map<String, Object>> testNum = gradeService.testNum();
		String gradeCode = gradeService.gradeCode();

		System.out.println("gradeList-->" + gradeList);
		System.out.println("sName-->" + sName);
		System.out.println("testNum-->" + testNum);

		model.addAttribute("gradeList", gradeList);
		model.addAttribute("title", "성적리스트조회");
		model.addAttribute("sName", sName);
		model.addAttribute("testNum", testNum);
		model.addAttribute("gradeCode", gradeCode);

		return "grade/gradeList";

	}

	// 성적상세보기리스트
	@GetMapping("/gradePage")
	public String getGradeDetailList(Model model,
			@RequestParam(value = "gradeManCode", required = false) String gradeManCode) {
		List<Grade> grade = gradeService.getGradeDetailList(gradeManCode);
		System.out.println("getGradeDetailList-->" + grade);
		model.addAttribute("Grade", grade);
		model.addAttribute("title", "성적상세보기리스트");
		return "grade/gradePage";
	}

	// 조건검색
	@PostMapping("/serchGrade")
	public String serchGrade(Model model, @RequestParam(value = "lecGd", required = false) String lecGd,
			@RequestParam(value = "lecGds", required = false) String lecGds) {
		List<Grade> gradeList = gradeService.searchGrade(lecGd, lecGds);
		System.out.println("serchGrade gradeList-->" + gradeList);
		List<Map<String, Object>> sName = gradeService.sName();
		List<Map<String, Object>> testNum = gradeService.testNum();
		String gradeCode = gradeService.gradeCode();
		model.addAttribute("gradeList", gradeList);
		model.addAttribute("sName", sName);
		model.addAttribute("testNum", testNum);
		model.addAttribute("gradeCode", gradeCode);
		return "grade/gradeList";

	}

	// 조건검색
	@GetMapping(value = "/gradeList", produces = "application/json")
	@ResponseBody
	public List<Grade> searchGrade(Model model, @RequestParam(value = "lecGd", required = false) String lecGd,
			@RequestParam(value = "lecGds", required = false) String lecGds) {
		List<Grade> gradeList = gradeService.searchGrade(lecGd, lecGds);
		model.addAttribute("gradeList", gradeList);
		return gradeList;

	}

	// 성적입력하기
	@PostMapping(value = "/getGradeList")
	public String inputGrade(Grade grade, Model model,
			@RequestParam(value = "gradeManCode", required = false) String gradeManCode,
			@RequestParam(value = "mrName", required = false) String mrName,
			@RequestParam(value = "mrId", required = false) String mrId,
			@RequestParam(value = "testRounds", required = false) String testRounds,
			@RequestParam(value = "gradeManScore", required = false) String gradeManScore,
			@RequestParam(value = "gradeManRegDate", required = false) String gradeManRegDate) {
		int result  = gradeService.insertGrade(grade);
		model.addAttribute("Grade", grade);
		String gradeCode = gradeService.gradeCode();
		model.addAttribute("gradeCode", gradeCode);
		model.addAttribute("result", result);
		return "redirect:/getGradeList";
	}
	
	 
}
