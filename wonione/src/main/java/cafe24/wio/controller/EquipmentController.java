package cafe24.wio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EquipmentController {

	@GetMapping("/equipmentManage")
	public String equipmentMain(Model model) {
		
		return "equipment/equipmentManage";
	}
}
