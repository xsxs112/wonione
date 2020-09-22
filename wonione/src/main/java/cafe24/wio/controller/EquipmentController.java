package cafe24.wio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EquipmentController {

	
	@GetMapping("/equipRegister")
	public String equipRegister(Model model) {
		
		model.addAttribute("title", "비품 정보등록 페이지");
		model.addAttribute("mainTitle", "비품 정보등록 페이지");
		
		return "equipment/equipRegister";
	}
	
	@GetMapping("/equipRegisterMain")
	public String equipRegMain(Model model) {
		
		model.addAttribute("title", "등록 메인페이지");
		model.addAttribute("mainTitle", "등록 메인페이지");
		
		return "equipment/equipRegisterMain";
	}
	
	@GetMapping("/equipmentManage")
	public String equipmentMain(Model model) {
		
		model.addAttribute("title", "비품관리 메인페이지");
		model.addAttribute("mainTitle", "비품관리 메인페이지");
		return "equipment/equipmentManage";
	}
}
