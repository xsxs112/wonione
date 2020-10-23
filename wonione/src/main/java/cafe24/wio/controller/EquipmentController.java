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

import cafe24.wio.bean.Equipment;
import cafe24.wio.bean.WhEquipment;
import cafe24.wio.service.EquipmentService;

@Controller
public class EquipmentController {

	
	@Autowired
	private EquipmentService equipmentService;
	
	//비품코드로 비품정보 조회 ajax 
	@PostMapping("/getEquipListOnly")
	@ResponseBody
	public Map<String,Object> getEquipListOnly(
						@RequestParam(value="eqCode",required = false)String eqCode){
		
		Map<String,Object> eqListOnly = 
							equipmentService.getEquipListOnly(eqCode);
		return eqListOnly;
	}
	
	//비품 입고 검색 후 리스트객체를 비품입고내역 리스트로 forward
	@GetMapping("/equipWhSearch")
	public String getEquipWhSearchList(Model model
							,@RequestParam(value="equipWhSk", required = false) String equipWhSk
							,@RequestParam(value="equipWhSv", required = false) String equipWhSv) {
		model.addAttribute("title", "비품입고내역 검색결과");
		model.addAttribute("mainTitle", "검색결과는 아래와 같습니다");
		List<Map<String,Object>> getEquipWhSearchList = equipmentService.getEquipWhSearchList(equipWhSk, equipWhSv);
		model.addAttribute("equipWhList", getEquipWhSearchList);
		model.addAttribute("href", "/equipWhList");
		
		return "equipment/equipWhList";
	}
	
	//비품 정보 검색 후 리스트객체를 비품정보 리스트로 forward
	@GetMapping("/equipSearch")
	public String getEquipSearchList(Model model
							,@RequestParam(value="equipSk", required = false) String equipSk
							,@RequestParam(value="equipSv", required = false) String equipSv) {
		model.addAttribute("title", "비품 리스트 검색결과");
		model.addAttribute("mainTitle", "검색결과는 아래와 같습니다");
		List<Equipment> getEquipSearchList =
							equipmentService.getEquipSearchList(equipSk, equipSv);
		model.addAttribute("equipmentList", getEquipSearchList);
		model.addAttribute("href", "/equipmentList");
		
		return "equipment/equipmentList";
	}
	
	//비품 입고내역조회 view로 forward
	@GetMapping("/equipWhList")
	public String equipWhList(Model model) {
		
		model.addAttribute("title", "비품입고내역 조회");
		model.addAttribute("mainTitle", "비품입고내역 조회");
		List<Map<String,Object>> equipWhList = equipmentService.getEquipWhList();
		model.addAttribute("equipWhList", equipWhList);
		
		return "equipment/equipWhList";
	}
	
	//비품 정보조회 view로 forward
	@GetMapping("/equipmentList")
	public String equipmentList(Model model
						,@RequestParam
						(	value="currentPage"
						, 	required = false
						, 	defaultValue = "1") int currentPage) {

		Map<String,Object> equipmentList = equipmentService.getEquipmentList(currentPage);

		model.addAttribute("title", "등록비품 조회");
		model.addAttribute("mainTitle", "등록비품 조회");
		model.addAttribute("currentPage",currentPage);
		model.addAttribute("equipmentList", equipmentList.get("equipmentList"));
		model.addAttribute("lastPage", equipmentList.get("lastPage"));
		model.addAttribute("startPageNum", equipmentList.get("startPageNum"));
		model.addAttribute("lastPageNum", equipmentList.get("lastPageNum"));	
		
		return "equipment/equipmentList";
	}

	//비품정보등록
	@PostMapping("/addEquipment")
	public String addEquipment(Equipment equipment
							,@RequestParam(value="eqCode",required = false)String eqCode) {

		equipmentService.addEquipment(equipment);
		
		return "redirect:/equipmentList";
	}
	
	//비품 정보등록 페이지 view로 forward
	@GetMapping("/addEquipment")
	public String addEquipment(Model model
							,   HttpSession session) {
		String sessionId = session.getAttribute("SID").toString();
		String eqCode = equipmentService.equipMaxCode();
		List<Equipment> equipmentCategory = equipmentService.getEquipCategory();
		model.addAttribute("title", "비품 정보등록 페이지");
		model.addAttribute("mainTitle", "비품 정보등록 페이지");
		model.addAttribute("sessionId", sessionId);
		model.addAttribute("eqCode", eqCode);
		model.addAttribute("equipmentCategory", equipmentCategory);
		
		return "equipment/addEquipment";
	}

}
