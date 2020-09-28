package cafe24.wio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;


import cafe24.wio.service.ScholarshipService;
import cafe24.wio.bean.ScholarShip;

@Controller
public class ScholarshipController {

	@Autowired
	private ScholarshipService scholarshipService;
	
	//장학금지급내역 리스
	@GetMapping("/getScholarList")
	public String getScholarList(Model model, ScholarShip  scholarship) {
		List<ScholarShip> scholarshipList = scholarshipService.getScholarList(scholarship);
		model.addAttribute("scholarshipList", scholarshipList) ;
		return "grade/scholarship";
		
	}
	
	
}
