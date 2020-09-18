package cafe24.wio.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cafe24.wio.bean.ApprovalRequest;
import cafe24.wio.service.ApprRequestService;

//황미현 - 출퇴근 컨트롤러

@Controller
public class WorkController {

	// @Autowired private ApprovalRequest approvalRequest;

	@Autowired
	private ApprRequestService apprRequestService;


	
	//휴가 중복 체크
	@ResponseBody
	@GetMapping("/holidayCk")
	public int holidayCk(@RequestParam(value = "startDate", required = false) String startDate,
							@RequestParam(value = "endDate", required = false) String endDate) {
		
		// 쿼리에서 불러온 List
		List<Map<String, Object>> listMap = apprRequestService.getHolidayListTest();
		
		
		
		//숫자 연산을 하기 위해 가져온 문자형식에서(Ex 2020-19-18) -를 지우고 숫자형으로 변환
		int numStDate = Integer.parseInt(startDate.replace("-", ""));
		int numEndDate = Integer.parseInt(endDate.replace("-", ""));
		//휴가 중복이 있는지 확인하기 위한 변수 선언 초기값은 1, 중복이 있으면 0
		int resultDate = 1;
		
		for(int i = 0; i<listMap.size();i++) {
			//List를 풀어서 
			//DB에 있던 휴가 시작 날짜와 끝나는 날짜를 가져와서 데이터타입 String으로 담음
			String reStartDate = listMap.get(i).get("reStartDate").toString().replace("-", "");
			String reEndDate = listMap.get(i).get("reEndDate").toString().replace("-", "");
			System.out.println(reStartDate);
			System.out.println(reEndDate);
			//숫자 연산을 하기 위해 가져온 문자형식에서(Ex 2020-19-18) -를 지우고 숫자형으로 변환
			int numListStDate = Integer.parseInt(reStartDate);
			int numListEndDate = Integer.parseInt(reEndDate);
			
			if((numStDate >= numListStDate && numStDate <= numListEndDate) || (numEndDate >= numListStDate && numEndDate <= numListEndDate)) {
				//숫자 비교 연산해서 중복이 되면 resultDate에 0을 대입
				resultDate = 0;
			}
			
			 
		}
		System.out.println(resultDate +"resultDate");
		return resultDate;

	}

	@ResponseBody
	@GetMapping("/startDayCk")
	public int startDayCk(@RequestParam(value = "startDate", required = false) String startDate) {
		int getStartDate = apprRequestService.getStartDayCk(startDate);

		return getStartDate;

	}

	@PostMapping("/holidayRequest")
	public String holidayRequest(ApprovalRequest approvalRequest,
			@RequestParam(value = "reStartDate", required = false) String reStartDate,
			@RequestParam(value = "reEndDate", required = false) String reEndDate,
			@RequestParam(value = "mrId", required = false) String mrId,
			@RequestParam(value = "mrName", required = false) String mrName,
			@RequestParam(value = "reReason", required = false) String reReason,
			@RequestParam(value = "holidaySt", required = false) String holidaySt) {
		System.out.println("mrId--------------" + mrId);
		approvalRequest.setMrId(mrId);
		approvalRequest.setReStartDate(reStartDate);
		approvalRequest.setReEndDate(reEndDate);
		approvalRequest.setSortation(holidaySt);
		approvalRequest.setReReason(reReason);
		apprRequestService.addholidayApproval(approvalRequest);

		return "redirect:/holidayApproval";

	}

	// 휴가요청 리스트
	@GetMapping("/holidayApproval")
	@PostMapping("/holidayApproval")
	public String getHolidayList(Model model) {

		List<ApprovalRequest> holidayList = apprRequestService.getHolidayList();
		model.addAttribute("holidayList", holidayList);

		return "workmanagment/holidayApproval";
	}

}
