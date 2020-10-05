package cafe24.wio.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cafe24.wio.bean.LectureOpenSchedule;
import cafe24.wio.service.LectureService;

@Controller
public class LectureController {

	@Autowired
	private LectureService lectureService;

	
	//강의개설 신청하기
	@GetMapping("/applyLectureOpen")
	public String applyLectureOpen(Model model
								,  HttpSession session) {

		List<Map<String,Object>> teacherList = lectureService.getTeacherList();
		List<Map<String,Object>> lectureLevel = lectureService.getLectureLevel();
		List<Map<String,Object>> lectureTime = lectureService.getLectureTime();
		List<Map<String,Object>> lectureRoom = lectureService.getLectureRoom();
		String sessionId = session.getAttribute("SID").toString();
		String sessionName = session.getAttribute("SNAME").toString();
		
		model.addAttribute("title", "강의개설 신청페이지");
		model.addAttribute("mainTitle", "강의개설 신청페이지");
		model.addAttribute("teacherList", teacherList);
		model.addAttribute("lectureLevel", lectureLevel);
		model.addAttribute("lectureRoom", lectureRoom);
		model.addAttribute("lectureTime", lectureTime);
		model.addAttribute("sessionId", sessionId);
		model.addAttribute("sessionName", sessionName);
		
		
		return "lecture/applyLectureOpen";
	}
	
	//강의관리메인페이지
	@GetMapping("/lectureManage")
	public String lectureManage(Model model) {
		
		model.addAttribute("title", "강의관리 메인페이지");
		model.addAttribute("mainTitle", "강의관리 메인페이지");
		
		
		return "lecture/lectureManage";
	}
	
	//강의예정리스트 조회
	@GetMapping("/lecOsList")
	public String lecOsList(Model model) {
		
		List<LectureOpenSchedule> lecOsCode =  lectureService.getLecOsCode();
		
		List<Map<String,Object>> lectureOsList
						= lectureService.getLectureOsList();
		
		model.addAttribute("title", "강의 예정 리스트");
		model.addAttribute("mainTitle", "강의 예정 리스트");
		model.addAttribute("lectureOsList", lectureOsList);
		
		return "lecture/lecOsList";
	}
	
	
	@GetMapping(value="/getApplyCount", produces = "application/json")
	@ResponseBody
	public int getApplyCount(@RequestParam(value="lecOsCode",required = false)String lecOsCode) {
		
		int result = lectureService.getApplyCount(lecOsCode);
		
		return result;
	}
}
