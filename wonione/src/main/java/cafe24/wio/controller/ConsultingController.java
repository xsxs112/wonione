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

import cafe24.wio.bean.Consulting;
import cafe24.wio.service.ConsultingService;

@Controller
public class ConsultingController {
	
	@Autowired
	private ConsultingService consultingService;
	
	@GetMapping("/consultingWrite")
	public String consultingWrite(Model model) {
		List<Map<String, Object>> consultingTeacherMap = consultingService.SelectTeacher();
		List<Map<String, Object>> consultingLecNameMap = consultingService.SelectLecName();
		model.addAttribute("Teacher",consultingTeacherMap);
		model.addAttribute("LecName",consultingLecNameMap);
		return "/consulting/consultingWrite";
	}
	@PostMapping("/consultingWrite")
	public String addConsultingWrite(Consulting consulting
									,@RequestParam(value="consultingTitle", required = false) String consultingTitle
									,@RequestParam(value="consultingTeacher", required = false) String consultingTeacher
									,@RequestParam(value="consultingClass", required = false) String consultingClass
									,@RequestParam(value="consultingStudent", required = false) String consultingStudent
									,@RequestParam(value="consultingData", required = false) String consultingData) {
		consultingService.addConsultingWrite(consulting);
		return "redirect:/consultingList";
	}
	
	@RequestMapping(value="/consultingList", method=RequestMethod.GET)
	   public String consultingList(Model model
	               ,@RequestParam(value="currentPage", required = false, defaultValue = "1") int currentPage) {
	         Map<String,Object> consultingListMap = consultingService.consultingList(currentPage);
	                  
	         model.addAttribute("title", "상담내역");
	         model.addAttribute("lastPage", consultingListMap.get("lastPage"));
	         model.addAttribute("consultingList", consultingListMap.get("consultingList"));
	         model.addAttribute("startPageNum", consultingListMap.get("startPageNum"));
	         model.addAttribute("lastPageNum", consultingListMap.get("lastPageNum"));
	         model.addAttribute("currentPage",currentPage);         
	         
	         return "/consulting/consultingList";
	   } 
	@PostMapping(value = "/consultingInformation",produces = "application/json")
	@ResponseBody
	public Map<String, Object> consultingInformation(int csCode) {
		Map<String ,Object> consultingInformationMap = consultingService.consultingInformation(csCode);
		System.out.println(consultingInformationMap);
		return consultingInformationMap;
	}
	@PostMapping("/consultingList")
	public String upConsultingList(@RequestParam(value="consultingCode", required = false) String consultingCode
								  ,@RequestParam(value="consultingTitle", required = false) String consultingTitle
								  ,@RequestParam(value="consultingTeacher", required = false) String consultingTeacher
								  ,@RequestParam(value="consultingClass", required = false) String consultingClass
								  ,@RequestParam(value="consultingStudent", required = false) String consultingStudent
								  ,@RequestParam(value="consultingData", required = false) String consultingData) {
		System.out.println(consultingCode);
		System.out.println(consultingTitle);
		System.out.println(consultingTeacher);
		System.out.println(consultingClass);
		System.out.println(consultingStudent);
		System.out.println(consultingData);
		return "redirect:/consultingList";
	}
}
