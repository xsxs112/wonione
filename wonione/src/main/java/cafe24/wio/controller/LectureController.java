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

import cafe24.wio.bean.LectureOpen;
import cafe24.wio.bean.LectureOpenSchedule;
import cafe24.wio.service.LectureService;

@Controller
public class LectureController {

	@Autowired
	private LectureService lectureService;

	//강의예정리스트 날짜로 체크 ajax
	@PostMapping(value="/lecOsCheckDate", produces="application/json")
	@ResponseBody
	public List<Map<String,Object>> getLecOsListDate(
						 @RequestParam(value="lecStDate",required = false)String lecStDate
						,@RequestParam(value="lecFinDate",required = false)String lecFinDate){
		
		List<Map<String,Object>> lecOsListDate = 
						lectureService.getLecOsListDate(lecStDate, lecFinDate);
		return lecOsListDate;
	}
	
	//강의예정코드를 사용해 강의리스트에 등록하기
	@PostMapping(value="/addLectureOpen", produces = "application/json")
	@ResponseBody
	public int addLectureOpen(LectureOpen lectureOpen
							,@RequestParam(value="lecOsCode" ,required = false)String lecOsCode
							,@RequestParam(value="lecOpWriter" ,required = false)String lecOpWriter
							,@RequestParam(value="lecOpCode" ,required = false)String lecOpCode) {
		int addResult = lectureService.addLectureOpen(lectureOpen);
		
		return addResult;
	}
	
	//강의예정코드로 중복개설되었는지 확인
	@PostMapping(value="/checkLecOpen",produces = "application/json")
	@ResponseBody
	public int checkLecOpen(@RequestParam(value="lecOsCode",required = false)String lecOsCode) {
			int checkResult = lectureService.checkLecOpen(lecOsCode);
		return checkResult;
	}
	
	
	//개설된 강의상태 변경하기 ajax
	@PostMapping(value="/changeLecStatus", produces = "application/json")
	@ResponseBody
	public int changeLecStatus(  @RequestParam(value="lecOpCode", required = false)String lecOpCode
								,@RequestParam(value="selectLecStatusVal", required = false)String changeLecStatus) {
								
		int changeResult = lectureService.changeLecStatus(changeLecStatus, lecOpCode);
		
		return changeResult;
	}
	
	
	//강의예정리스트 1개만 조회 ajax
	@PostMapping(value="/getLecOsListOnly",produces = "application/json")
	@ResponseBody
	public List<Map<String, Object>> getLecOsListOnly(
									@RequestParam(value="lecOsCode",required = false) String lecOsCode){
		
		List<Map<String, Object>> lecOsList = lectureService.getLecOsListOnly(lecOsCode);
		return lecOsList;
	}
	
	//강의리스트 조회
	@GetMapping("/lectureList")
	public String getLectureList(Model model) {
		
		List<Map<String, Object>> lectureList = lectureService.getLectureList();
		List<Map<String,Object>> lectureStatus = lectureService.getLectureStatus();
		model.addAttribute("title", "강의 리스트");
		model.addAttribute("mainTitle", "강의 리스트");
		model.addAttribute("lectureList", lectureList);
		model.addAttribute("lectureStatus", lectureStatus);
		
		return "lecture/lectureList";
	}
	
	//강의개설 신청하기
	@PostMapping("/addLectureOpenSchedule")
	public String addLectureOpenSchedule(Model model
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
		lectureService.addLectureOpenSchedule(lectureOs);
		
		return "redirect:/lectureOpenScheduleList";
	}
	
	//강의개설 신청하기
	@GetMapping("/addLectureOpenSchedule")
	public String addLectureOpenSchedule(Model model
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
		
		
		return "lecture/addLectureOpenSchedule";
	}
	
	//강의관리메인페이지
	@GetMapping("/lectureManage")
	public String lectureManage(Model model) {
		
		
		model.addAttribute("title", "강의관리 메인페이지");
		model.addAttribute("mainTitle", "강의관리 메인페이지");
		
		return "lecture/lectureManage";
	}
	
	//강의예정리스트 조회
	@GetMapping("/lectureOpenScheduleList")
	public String lectureOpenScheduleList(Model model
							,HttpSession session) {
		
		/* List<Object> lecApplyCount = lectureService.getApplyCount(); */
		String lecOpCode = lectureService.getLecOpenCode();
		List<Map<String,Object>> lectureOsList
						= lectureService.getLectureOsList();
		
		model.addAttribute("title", "강의 예정 리스트");
		model.addAttribute("mainTitle", "강의 예정 리스트");
		model.addAttribute("lectureOsList", lectureOsList);
		model.addAttribute("lecOpCode", lecOpCode);
		model.addAttribute("sessionId", session.getAttribute("SID").toString());
		
		return "lecture/lectureOpenScheduleList";
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
