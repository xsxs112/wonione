package cafe24.wio.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		return "/consulting/consultingList";
	}
	@GetMapping("/consultingList")
	public String consultingList() {
		return "/consulting/consultingList";
	}
}
