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

	//강의예정리스트 수정하기
	@PostMapping("/modifyLecOpenSchedule")
	public String modifylecOs(	LectureOpenSchedule lectureOs
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
								,@RequestParam(value="lecRemark",required = false)String lecRemark) {
		
		lectureService.modifyLecOs(lectureOs);
		
		return "redirect:/lectureOpenScheduleList";
	}
	
	
	//강의예정리스트 수정하기
	@GetMapping("/modifyLecOpenSchedule")
	public String modifylecOs(Model model
							,HttpSession session
							, @RequestParam(value="lecOsCode", required = false) String lecOsCode) {
		Map<String,Object> lectureOsList = 
									lectureService.getLecOsListOnly(lecOsCode);
		List<Map<String,Object>> teacherList = lectureService.getTeacherList();
		List<Map<String,Object>> lectureLevel = lectureService.getLectureLevel();
		List<Map<String,Object>> lectureTime = lectureService.getLectureTime();
		List<Map<String,Object>> lectureRoom = lectureService.getLectureRoom();
		String sessionId = session.getAttribute("SID").toString();
		String sessionName = session.getAttribute("SNAME").toString();
		String sessionLevel = session.getAttribute("SLEVEL").toString();
		
		model.addAttribute("title", "강의예정 수정하기");
		model.addAttribute("mainTitle", "강의예정 수정하기");
		model.addAttribute("lectureOsList", lectureOsList);
		model.addAttribute("teacherList", teacherList);
		model.addAttribute("lectureLevel", lectureLevel);
		model.addAttribute("lectureRoom", lectureRoom);
		model.addAttribute("lectureTime", lectureTime);
		model.addAttribute("sessionId", sessionId);
		model.addAttribute("sessionName", sessionName);
		model.addAttribute("sessionLevel", sessionLevel);
		
		return "lecture/modifyLecOpenSchedule";
	}
	
	//검색결과 유무 조회
	@PostMapping(value="/checkSearchResult", produces = "application/json")
	@ResponseBody
	public int checkSearchResult(@RequestParam(value="startPeriod",	 required = false)String startPeriod
								,@RequestParam(value="endPeriod",	 required = false)String endPeriod
								,@RequestParam(value="lecStartDate", required = false)String lecStartDate
								,@RequestParam(value="lecFinalDate", required = false)String lecFinalDate
								,@RequestParam(value="selectlecOsSk",required = false)String selectlecOsSk
								,@RequestParam(value="lecOsSv",		 required = false)String lecOsSv) {
		
		/*원석이형...♥*/
		int checkResult = lectureService.checkSearchResult(startPeriod
														 , endPeriod
														 , lecStartDate
														 , lecFinalDate
														 , selectlecOsSk
														 , lecOsSv);
		
		return checkResult;
	}
	
	//강의예정리스트 기간별검색
	@GetMapping("/lecOsSearchPeriod")
	public String getLecOsSearchPeriod(Model model
									, @RequestParam(value="lecStartDate",required = false)String lecStartDate
									, @RequestParam(value="lecFinalDate",required = false)String lecFinalDate
									, @RequestParam(value="startPeriod",required = false)String startPeriod
									, @RequestParam(value="endPeriod",required = false)String endPeriod) {
		List<Map<String,Object>>lectureOsList = 
								lectureService.lecOsSearchPeriod(lecStartDate, lecFinalDate, startPeriod, endPeriod);
		
		model.addAttribute("title", "강의 예정리스트 검색결과");
		model.addAttribute("mainTitle", "검색결과는 다음과 같습니다.");
		model.addAttribute("lectureOsList", lectureOsList);
		model.addAttribute("href", "/lectureOpenScheduleList");
		
		return "lecture/lectureOpenScheduleList";
	}
	
	//강의예정리스트 검색
	@GetMapping("/lecOsSearch")
	public String getLecOsSearch(Model model
								,@RequestParam(value="lecOsSk",required = false)String lecOsSk
								,@RequestParam(value="lecOsSv",required = false)String lecOsSv) {
		List<Map<String,Object>> lectureOsList = 
								lectureService.getLecOsSearch(lecOsSk, lecOsSv);
		
		model.addAttribute("title", "강의 예정리스트 검색결과");
		model.addAttribute("mainTitle", "검색결과는 다음과 같습니다.");
		model.addAttribute("lectureOsList", lectureOsList);
		model.addAttribute("href", "/lectureOpenScheduleList");
		
		return "lecture/lectureOpenScheduleList";
	}
	
	//강의예정리스트 날짜로 체크 ajax
	@PostMapping(value="/lecOsCheckDate", produces="application/json")
	@ResponseBody
	public List<Map<String,Object>> getLecOsListDate(
						 @RequestParam(value="lecStartDate",required = false)String lecStartDate
						,@RequestParam(value="lecFinalDate",required = false)String lecFinalDate){
		
		List<Map<String,Object>> lecOsListDate = 
						lectureService.getLecOsListDate(lecStartDate, lecFinalDate);
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
	public Map<String, Object> getLecOsListOnly(
									@RequestParam(value="lecOsCode",required = false) String lecOsCode){
		
		Map<String, Object> lecOsList = lectureService.getLecOsListOnly(lecOsCode);
		return lecOsList;
	}
	
	//강의리스트 조회
	@GetMapping("/lectureList")
	public String getLectureList(Model model
								,HttpSession session) {
		List<Map<String, Object>> lectureList = lectureService.getLectureList();
		List<Map<String,Object>> lectureStatus = lectureService.getLectureStatus();
		String sessionLevel = session.getAttribute("SLEVEL").toString();
		model.addAttribute("SLEVEL", sessionLevel);
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
		String sessionLevel = session.getAttribute("SLEVEL").toString();
		
		model.addAttribute("title", "강의개설 신청페이지");
		model.addAttribute("mainTitle", "강의개설 신청페이지");
		model.addAttribute("lecOsCode", lecOsCode);
		model.addAttribute("teacherList", teacherList);
		model.addAttribute("lectureLevel", lectureLevel);
		model.addAttribute("lectureRoom", lectureRoom);
		model.addAttribute("lectureTime", lectureTime);
		model.addAttribute("sessionId", sessionId);
		model.addAttribute("sessionName", sessionName);
		model.addAttribute("sessionLevel", sessionLevel);
		
		
		return "lecture/addLectureOpenSchedule";
	}
		
	//강의예정리스트 조회
	@GetMapping("/lectureOpenScheduleList")
	public String lectureOpenScheduleList(Model model
							,HttpSession session
							,@RequestParam(
									  value="currentPage"
									, required = false
									, defaultValue = "1") int currentPage) {
		
		String lecOpCode = lectureService.getLecOpenCode();
		Map<String,Object> resultMap
						= lectureService.getLectureOsList(currentPage);
		System.out.println(resultMap.get("lectureOsList"));
		
		String sessionId = session.getAttribute("SID").toString();
		String sessionLevel = session.getAttribute("SLEVEL").toString();
		model.addAttribute("SLEVEL", sessionLevel);
		model.addAttribute("title", "강의 예정 리스트");
		model.addAttribute("mainTitle", "강의 예정 리스트");
		model.addAttribute("lecOpCode", lecOpCode);
		model.addAttribute("sessionId", sessionId);
		model.addAttribute("currentPage",currentPage);
		model.addAttribute("lectureOsList", resultMap.get("lectureOsList"));
		model.addAttribute("lastPage", resultMap.get("lastPage"));
		model.addAttribute("startPageNum", resultMap.get("startPageNum"));
		model.addAttribute("lastPageNum", resultMap.get("lastPageNum"));
		
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
