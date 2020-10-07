package cafe24.wio.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cafe24.wio.bean.LectureOpenSchedule;
import cafe24.wio.service.LectureService;

@Controller
public class LectureController {

	@Autowired
	private LectureService lectureService;

	//강의예정리스트 1개만 조회 ajax
	@PostMapping(value="/getLecOsListOnly",produces = "application/json")
	@ResponseBody
	public List<Map<String, Object>> getLecOsListOnly(
									@RequestParam(value="lecOsCode",required = false) String lecOsCode){
		
		List<Map<String, Object>> lecOsList = lectureService.getLecOsListOnly(lecOsCode);
		return lecOsList;
	}
	
	//강의리스트 조회
	@GetMapping("/lecList")
	public String getLectureList(Model model) {
		
		List<Map<String, Object>> lectureList = lectureService.getLectureList();
		List<Map<String,Object>> lectureStatus = lectureService.getLectureStatus();
		model.addAttribute("title", "강의 리스트");
		model.addAttribute("mainTitle", "강의 리스트");
		model.addAttribute("lectureList", lectureList);
		model.addAttribute("lectureStatus", lectureStatus);
		
		return "lecture/lecList";
	}
	
	//강의개설 신청하기
	@PostMapping("/applyLectureOpen")
	public String applyLectureOpen(Model model
								, LectureOpenSchedule lectureOs
								,@RequestParam(value="lecOsCode",required = false)String lecOsCode
								,@RequestParam(value="lecName",required = false)String lecName
								,@RequestParam(value="mrTeacherId",required = false)String mrTeacherId
								,@RequestParam(value="lecTime",required = false)String lecTime
								,@RequestParam(value="lecRoom",required = false)String lecRoom
								,@RequestParam(value="lecDay",required = false)String lecDay
								,@RequestParam(value="lecLevel",required = false)String lecLevel
								,@RequestParam(value="lecTuition",required = false)String lecTuition
								,@RequestParam(value="claCapacity",required = false)String claCapacity
								,@RequestParam(value="lecStartDate",required = false)String lecStartDate
								,@RequestParam(value="lecFinalDate",required = false)String lecFinalDate
								,@RequestParam(value="lecOsWriter",required = false)String lecOsWriter
								
								) {
		lectureService.applyLectureOpen(lectureOs);
		
		return "redirect:/lecOsList";
	}
	
	//강의개설 신청하기
	@GetMapping("/applyLectureOpen")
	public String applyLectureOpen(Model model
								,  HttpSession session) {

		List<Map<String,Object>> teacherList = lectureService.getTeacherList();
		List<Map<String,Object>> lectureLevel = lectureService.getLectureLevel();
		List<Map<String,Object>> lectureTime = lectureService.getLectureTime();
		List<Map<String,Object>> lectureRoom = lectureService.getLectureRoom();
		String lecOsCode = lectureService.getLecOsMaxCode();
		String sessionId = session.getAttribute("SID").toString();
		String sessionName = session.getAttribute("SNAME").toString();
		
		model.addAttribute("title", "강의개설 신청페이지");
		model.addAttribute("mainTitle", "강의개설 신청페이지");
		model.addAttribute("lecOsCode", lecOsCode);
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
		
		/* List<Object> lecApplyCount = lectureService.getApplyCount(); */
		
		List<Map<String,Object>> lectureOsList
						= lectureService.getLectureOsList();
		
		model.addAttribute("title", "강의 예정 리스트");
		model.addAttribute("mainTitle", "강의 예정 리스트");
		/* model.addAttribute("lecApplyCount", lecApplyCount); */
		model.addAttribute("lectureOsList", lectureOsList);
		
		return "lecture/lecOsList";
	}
	
	//강의예정리스트 비고사항 가져오기 ajax
	@PostMapping(value="/getLecOsRemark", produces = "application/json")
	@ResponseBody
	public List<Map<String,Object>> getLecOsRemark(Model model
								,@RequestParam(value="lecOsCode",required = false)String lecOsCode) {
		List<Map<String,Object>> getLecOsRemark = lectureService.getLecOsRemark(lecOsCode);
		return getLecOsRemark;
	}
	
	
}
