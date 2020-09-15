package cafe24.wio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cafe24.wio.bean.Board;
import cafe24.wio.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
		//공지사항 조회
		@GetMapping("/getNotice")
		public String boardList(Model model, Board board) {
			model.addAttribute("title", "공지사항 화면");
			List<Board> boardList = boardService.getBoardList(board);
			model.addAttribute("boardList", boardList);
			return "board/notice";
		}
		
		@GetMapping("/getData")
		public String dataList() {
			return "board/data";		
		}
		
		@GetMapping("/getReview")
		public String viewList() {
			return "board/view";			
		}
	
}
