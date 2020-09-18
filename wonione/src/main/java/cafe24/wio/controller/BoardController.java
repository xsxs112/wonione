package cafe24.wio.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cafe24.wio.bean.Board;
import cafe24.wio.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	

	// 공지사항 조회
	@RequestMapping(value = "/getNotice", method = RequestMethod.GET)
	public String getNotice(Model model, Board board) {

		List<Board> noticeList = boardService.getNotice(board);
		System.out.println(noticeList + "noticeList");

		model.addAttribute("noticeList", noticeList);
		model.addAttribute("title", "공지사항");

		return "board/notice";
	}
	
	  //공지사항 읽기
	  @GetMapping("/readNotice")
	  public String readNotice(Model model,
			  					@RequestParam(value="boardNum", required = false) String boardNum) {
		  Board board = boardService.readNotice(boardNum);
		  System.out.println(board + "board");
		  model.addAttribute("Board", board);		  
		  model.addAttribute("readNotice", "공지사항 읽기");
		  
		  return "board/noticeRead";		  
	  }
	
	  //공지사항 작성 PostMapping 필요
	  public String getNoticeAdd(Board board
			  					,Model model
			  					,@RequestParam(value="boardNum", required = false) String boardNum
			  					,@RequestParam(value="boardMenu", required = false) String boardMenu
			  					,@RequestParam(value="boardTitle", required = false) String boardTitle
			  					,@RequestParam(value="boardWriterId", required = false) String boardWriterId
			  					,@RequestParam(value="boardRegDate", required = false) String boardRegDate
			  					,@RequestParam(value="boardContents", required = false) String boardContents
			  					,@RequestParam(value="boardPicture", required = false) String boardPicture
			  					,@RequestParam(value="boardFile", required = false) String boardFile	  					
			  					) {
		  System.out.println("boardNum -> " + boardNum);
		  System.out.println("boardNum -> " + boardMenu);
		  System.out.println("boardNum -> " + boardTitle);
		  System.out.println("boardNum -> " + boardWriterId);
		  System.out.println("boardNum -> " + boardRegDate);
		  System.out.println("boardNum -> " + boardContents);
		  System.out.println("boardNum -> " + boardPicture);
		  System.out.println("boardNum -> " + boardFile);
		  boardService.insertNotice(board);
		  model.addAttribute("Board", board);
		/* model.addAttribute("BoardUpload", "/searchNotice"); */
		  return "redirect:/getNotice";  
	  }
	  
	  //공지사항 작성 
	   @GetMapping("/addNotice")
	   public String getNoticeadd(Model model) {
		  
	      return "board/noticeAdd";
	   }
	  
	// 자료게시판 조회
	@RequestMapping(value = "/getDataLibrary", method = RequestMethod.GET)
	public String getDataLibrary(Model model, Board board) {
		
		List<Board> dataList = boardService.getDataLibrary(board);
		System.out.println(dataList + "dataList");
		
		model.addAttribute("title", "자료게시판");
		model.addAttribute("dataList", dataList);
		
		return "board/dataLibrary";
	}

	//자료게시판 읽기
	@GetMapping("/readDataLibrary")
	public String readDataLibrary(Model model,
			@RequestParam(value="boardNum", required = false) String boardNum) {
		Board board = boardService.readDataLibrary(boardNum);
		System.out.println(board + "board");
		model.addAttribute("Board", board);		  
		model.addAttribute("readDataLibrary", "자료게시판 읽기");
		
		return "board/dataLibraryRead";		  
	}
	
	// 수강후기 조회
	@GetMapping("/getReview")
	public String viewList() {
		return "board/view";
	}

}
