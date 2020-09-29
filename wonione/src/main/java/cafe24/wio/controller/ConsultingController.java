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
	
	//상담작성페이지
	//상담작성 페이지 안에 상담자와 강의반을 database에서 데이터를 가져오기위해 코드작업
	@GetMapping("/consultingWrite")
	public String consultingWrite(Model model) {
		List<Map<String, Object>> consultingTeacherMap = consultingService.SelectTeacher();
		List<Map<String, Object>> consultingLecNameMap = consultingService.SelectLecName();
		model.addAttribute("Teacher",consultingTeacherMap);
		model.addAttribute("LecName",consultingLecNameMap);
		return "/consulting/consultingWrite";
	}
	//상담작성페이지
	//상담후 상담한 내용을 작성하여 database에 올리위한 코드작업
	@PostMapping("/consultingWrite")
	public String addConsultingWrite(Consulting consulting
									,@RequestParam(value="consultingTitle", required = false) String consultingTitle
									,@RequestParam(value="consultingTeacher", required = false) String consultingTeacher
									,@RequestParam(value="consultingClass", required = false) String consultingClass
									,@RequestParam(value="consultingStudent", required = false) String consultingStudent
									,@RequestParam(value="consultingData", required = false) String consultingData) {
		
		if(consulting != null) {
			consultingService.addConsultingWrite(consulting);
			return "redirect:/consultingList";
		}else {
			return "consulting/consultingWrite";
		}
	}
	//상담내역리스트
	//상담작성후 database에서 데이터를 가져와 그데이터를 바탕으로 페이징처리한 코드작업
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
	//상담내역리스트
	//상담내역리스트에서 제목을 클릭하여 하단에 해당정보가 나오게 ajax를 이용
	//ajax에서 controller를 들려 database에 데이터를 가져오기위한 코드작업
	@PostMapping(value = "/consultingInformation",produces = "application/json")
	@ResponseBody
	public Map<String, Object> consultingInformation(int csCode) {
		Map<String ,Object> consultingInformationMap = consultingService.consultingInformation(csCode);
		return consultingInformationMap;
	}
	//상담내역리스트
	//상담내역리스트에서 제목을 클릭후 해당정보를 삭제하는 ajax사용
	
	 @PostMapping(value = "/deleteConsulting",produces = "application/json")
	 @ResponseBody 
	 public int deleteConsulting(int csCode){ 
		 int result = consultingService.deleteConsulting(csCode); 
	 	return result; 
	 }
	 
	//상담내역리스트
	//database에 update를 하여 상담내역수정처리코드작업
	@RequestMapping(value="/upConsultingList", method=RequestMethod.POST)
	public String upConsultingList(Consulting cosulting
								  ,@RequestParam(value="consultingCode", required = false) String consultingCode
								  ,@RequestParam(value="consultingTitle", required = false) String consultingTitle
								  ,@RequestParam(value="consultingTeacher", required = false) String consultingTeacherCode
								  ,@RequestParam(value="consultingClass", required = false) String consultingClass
								  ,@RequestParam(value="consultingStudent", required = false) String consultingStudent
								  ,@RequestParam(value="consultingData", required = false) String consultingData) {
		consultingService.upconsultingList(cosulting);
		return "redirect:/consultingList";
	}
}
