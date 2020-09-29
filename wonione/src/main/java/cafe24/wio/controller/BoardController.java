package cafe24.wio.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	  //공지사항 작성 @Post
	  @PostMapping("/addNotice")
	  public String insertNotice(Board board
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
		  System.out.println("boardMenu -> " + boardMenu);
		  System.out.println("boardTitle -> " + boardTitle);
		  System.out.println("boardWriterId -> " + boardWriterId);
		  System.out.println("boardRegDate -> " + boardRegDate);
		  System.out.println("boardContents -> " + boardContents);
		  System.out.println("boardPicture -> " + boardPicture);
		  System.out.println("boardFile -> " + boardFile);
		  boardService.addNotice(board);
		  model.addAttribute("Board", board);
		 model.addAttribute("BoardUpload", "/notice");
		  return "redirect:/getNotice";
	  }
	  
	  //공지사항 작성 @Get
	   @GetMapping("/addNotice")
	   public String insertNotice(Model model) {
		  
		   String boardNum = boardService.getBoardNum();
		   System.out.println(boardNum + " <-- boardNum");
		   model.addAttribute("boardNum", boardNum);
	      return "board/noticeAdd";
	   }
	  
	// 공지사항 수정 (내용 칼럼에 기존에 저장된 값 가져오기 불가)
	@PostMapping("/modifyNotice")
	public String modifyNotice(Board board,Model model) {
		boardService.modifyNotice(board);
		model.addAttribute("Board", board);
		return "redirect:/getNotice";
	}
	
	// 공지사항 수정
	@GetMapping("/modifyNotice")
	public String modifyBoard(@RequestParam(value="boardNum", required = false) String boardNum
							,Model model) {
		Board board = boardService.readNotice(boardNum);
		System.out.println(board+"<--board");
		model.addAttribute("Board", board);
		return "board/noticeModify";
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
	
	//공지사항 삭제
	@GetMapping("/removeNotice")
	public String removeNotice(Model model
								,@RequestParam(value="boardNum", required = false) String boardNum) {
		boardService.removeNotice(boardNum);		
		System.out.println(boardNum + "boardNum");
		return "redirect:/getNotice";
	}

}
