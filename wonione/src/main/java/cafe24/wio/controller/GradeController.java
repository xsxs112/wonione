package cafe24.wio.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger logger = LoggerFactory.getLogger(GradeController.class);

	// 성적리스트조회
	@RequestMapping(value = "/getGradeList", method = RequestMethod.GET)
	public String getGradeList(Grade grade, Model model
								,@RequestParam( value="currentPage", required = false, defaultValue = "1") int currentPage
								,@RequestParam(value = "lecName", required = false) String lecOsCode) {
		List<Map<String, Object>> sName = gradeService.sName();
		List<Map<String, Object>> testNum = gradeService.testNum();
		List<Map<String, Object>> className = gradeService.gradeClassId();
		List<Map<String, Object>> gradeClassId = gradeService.gradeClassId();
		String gradeCode = gradeService.gradeCode();
		Map<String,Object> countGradeList = gradeService.countGradeList(currentPage);
		model.addAttribute("title", "성적리스트조회");
		model.addAttribute("gradeClassId", gradeClassId);
		model.addAttribute("className", className);
		model.addAttribute("sName", sName);
		model.addAttribute("testNum", testNum);
		model.addAttribute("gradeCode", gradeCode);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("countGradeList",countGradeList.get("listGrade"));
		model.addAttribute("lastPage", countGradeList.get("lastPage"));
		model.addAttribute("lastPageNum", countGradeList.get("lastPageNum"));
		model.addAttribute("startPageNum", countGradeList.get("startPageNum"));
		
		return "grade/gradeList";

	}
	
	//ajax호출
	@PostMapping(value="/gradeClassId", produces = "application/json")
	@ResponseBody
	public List<Map<String, Object>> idName(Model model
										,@RequestParam(value = "lecName", required = false) String lecOsCode){
		List<Map<String, Object>> idName = gradeService.idName(lecOsCode);
		
		return idName;
		
	}

	
	// 성적상세보기리스트
	@GetMapping("/gradePage")
	public String getGradeDetailList(Model model,
			@RequestParam(value = "gradeManCode", required = false) String gradeManCode) {
		Grade grade = gradeService.getGradeDetailList(gradeManCode);
		logger.info("getGradeDetailList-->" + grade);
		model.addAttribute("Grade", grade);
		model.addAttribute("title", "성적상세보기리스트");
		return "grade/gradeDetail";
	}

	// 조건검색
	@PostMapping("/serchGrade")
	public String serchGrade(Model model,
							@RequestParam(value = "lecGd", required = false) String lecGd,
							@RequestParam(value = "lecGds", required = false) String lecGds) {
		List<Grade> gradeList = gradeService.searchGrade(lecGd, lecGds);
		logger.info("serchGrade gradeList-->" + gradeList);
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
	public List<Grade> searchGrade(Model model,
									@RequestParam(value = "lecGd", required = false) String lecGd,
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
			@RequestParam(value = "testNumber", required = false) String testNumber,
			@RequestParam(value = "gradeManScore", required = false) String gradeManScore,
			@RequestParam(value = "gradeManRegDate", required = false) String gradeManRegDate) {
		int result  = gradeService.insertGrade(grade);
		model.addAttribute("Grade", grade);
		String gradeCode = gradeService.gradeCode();
		model.addAttribute("gradeCode", gradeCode);
		model.addAttribute("result", result);
		model.addAttribute("title", "성적입력하기");
		return "redirect:/getGradeList";
	}
	
	
	//성적 수정하기
	@GetMapping("/updateGrade")
	public String updateGrade(Model model,
							@RequestParam(value="gradeManCode", required= false) String gradeManCode) {
		Grade grade = gradeService.getGradeDetailList(gradeManCode);
		logger.info("===============================");
		logger.info("@GetMapping updateGrade");
		logger.info("===============================");
		logger.info("성적수정" + grade);
		model.addAttribute("Grade", grade);
		return "grade/updateGrade";
	
	}
	
	//성적수정하기
	@PostMapping("/updateGrade")
	public String updateGrade(Grade grade) {
		logger.info("===============================");
		logger.info("@PostMapping updateGrade");
		logger.info("===============================");
		logger.info("성적수정" + grade);
		gradeService.updateGrade(grade);
		return "redirect:/getGradeList";
	}
	
	
	
	 
}
