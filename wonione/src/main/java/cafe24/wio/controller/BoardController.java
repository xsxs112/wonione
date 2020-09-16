package cafe24.wio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import cafe24.wio.bean.Board;
import cafe24.wio.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
		//공지사항 조회
		@RequestMapping(value = "/getNotice", method = RequestMethod.GET)
		public String getNotice(Model model, Board board) {
			
			List<Board> noticeList = boardService.getNotice(board);
			System.out.println(noticeList + "noticeList");
			
			model.addAttribute("title", "공지사항");
			model.addAttribute("noticeList", noticeList);
			
			return "board/notice";
		}

	/*
	 * //공지사항 상세보기
	 * 
	 * @GetMapping("/noticePage") public String getNoticeDetailList(Model model) {
	 * Report report = boardService.getNoticeDetailList(model);
	 * System.out.println(board + "board"); model.addAttribute("Board", board);
	 * model.addAttribute("title", "공지사항 상세목록조회");
	 * 
	 * return "board/noticePage";
	 * 
	 * }
	 */
		
		//자료게시판 조회
		
		
		//수강후기 조회
		@GetMapping("/getReview")
		public String viewList() {
			return "board/view";			
		}
	
}
