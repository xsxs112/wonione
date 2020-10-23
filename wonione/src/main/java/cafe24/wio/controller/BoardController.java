package cafe24.wio.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import cafe24.wio.bean.Board;
import cafe24.wio.bean.Review;
import cafe24.wio.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	private static final Logger logger = LoggerFactory.getLogger(WorkReportController.class);
	
	//공지사항 리스트 조회
	@RequestMapping(value = "/getNotice", method = RequestMethod.GET)
	public String getNotice(Model model, Board board) {

		List<Board> noticeList = boardService.getNotice(board);
		System.out.println(noticeList + "noticeList");

		model.addAttribute("noticeList", noticeList);
		model.addAttribute("title", "공지사항");

		return "board/noticeList";
	}
	
	//공지사항 읽기
	@GetMapping("/readNotice")
	public String readNotice(Model model,
			  					@RequestParam(value="boardNum", required = false) String boardNum) {
		  Board board = boardService.readNotice(boardNum);
		  System.out.println(board + "board");
		  model.addAttribute("Board", board);
		  model.addAttribute("readNotice", "공지사항 읽기");
		  
		  return "board/noticeDetail";
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
	public String insertNotice(Model model, HttpSession session) {
		
		   session.getAttribute("SID");	//세션 아이디 받기
		   String boardNum = boardService.getBoardNum();
		   System.out.println(boardNum + " <-- boardNum");
		   model.addAttribute("boardNum", boardNum);
	      return "board/addNotice";
	   }
	  
	//공지사항 수정 @Post
	@PostMapping("/modifyNotice")
	public String modifyNotice(Board board,Model model) {
		boardService.modifyNotice(board);
		model.addAttribute("Board", board);
		return "redirect:/getNotice";
	}
	//공지사항 수정 @Get
	@GetMapping("/modifyNotice")
	public String modifyNotice(@RequestParam(value="boardNum", required = false) String boardNum
							,Model model) {
		Board board = boardService.readNotice(boardNum);
		System.out.println(board+"<--board");
		model.addAttribute("Board", board);
		return "board/modifyNotice";
	}
	
	//공지사항 삭제
	@GetMapping("/removeNotice")
	public String removeNotice(Model model
								,@RequestParam(value="boardNum", required = false) String boardNum) {
		boardService.removeNotice(boardNum);		
		System.out.println(boardNum + "boardNum");
		return "redirect:/getNotice";
	}
	
	//공지사항 조건 검색
	@GetMapping("/getSearchNotice")
	public String getSearchNotice(Model model
			,@RequestParam(value="bdSk", required=false) String bdSk
			,@RequestParam(value="bdSv", required=false) String bdSv) {
		List<Board> noticeList = boardService.getNoticeSearch(bdSk, bdSv);
		logger.info(noticeList.toString());
		model.addAttribute("noticeList", noticeList);
		return "board/noticeList";
	}
	
	//자료게시판 리스트 조회
	@RequestMapping(value = "/getDataLibrary", method = RequestMethod.GET)
	public String getDataLibrary(Model model, Board board) {
		
		List<Board> dataList = boardService.getDataLibrary(board);
		System.out.println(dataList + "dataList");
		
		model.addAttribute("title", "자료게시판");
		model.addAttribute("dataList", dataList);
		
		return "board/dataLibraryList";
	}
	
	//자료게시판 읽기
	@GetMapping("/readDataLibrary")
	public String readDataLibrary(Model model,
			@RequestParam(value="boardNum", required = false) String boardNum) {
		Board board = boardService.readDataLibrary(boardNum);
		System.out.println(board + "board");
		model.addAttribute("Board", board);
		model.addAttribute("readDataLibrary", "자료게시판 읽기");
		
		return "board/dataLibraryDetail";
	}
	
	//자료게시판 작성 @Post
	@PostMapping("/addDataLibrary")
	public String insertDataLibrary(Board board
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
		  boardService.addDataLibrary(board);
		  model.addAttribute("Board", board);
		  model.addAttribute("BoardUpload", "/dataLibrary");
		  return "redirect:/getDataLibrary";
	}	  
	//자료게시판 작성 @Get
	@GetMapping("/addDataLibrary")
	public String insertDataLibrary(Model model, HttpSession session) {
		
		   session.getAttribute("SID");	//세션 아이디 받기
		   String boardNum = boardService.getBoardNum();
		   System.out.println(boardNum + " <-- boardNum");
		   model.addAttribute("boardNum", boardNum);
	      return "board/addDataLibrary";
	   }
	
	//자료게시판 수정 @Post
	@PostMapping("/modifyDataLibrary")
	public String modifyDataLibrary(Board board,Model model) {
		boardService.modifyDataLibrary(board);
		model.addAttribute("Board", board);
		return "redirect:/getDataLibrary";
	}
	//자료게시판 수정 @Get
	@GetMapping("/modifyDataLibrary")
	public String modifyDataLibrary(@RequestParam(value="boardNum", required = false) String boardNum
			,Model model) {
		Board board = boardService.readDataLibrary(boardNum);
		System.out.println(board+"<--board");
		model.addAttribute("Board", board);
		return "board/modifyDataLibrary";
	}
	
	//자료게시판 삭제
	@GetMapping("/removeDataLibrary")
	public String removeDataLibrary(Model model
								,@RequestParam(value="boardNum", required = false) String boardNum) {
		boardService.removeDataLibrary(boardNum);
		System.out.println(boardNum + "boardNum");
		return "redirect:/getDataLibrary";
	}
	
	//자료게시판 조건 검색
	@GetMapping("/getSearchDataLibrary")
	public String getSearchDataLibrary(Model model
			,@RequestParam(value="bdSk", required=false) String bdSk
			,@RequestParam(value="bdSv", required=false) String bdSv) {
		List<Board> dataList = boardService.getDataLibrarySearch(bdSk, bdSv);
		logger.info(dataList.toString());
		model.addAttribute("dataList", dataList);
		return "board/dataLibraryList";
	}

	//수강 후기 리스트 조회
	@RequestMapping(value = "/getReview", method = RequestMethod.GET)
	public String getReview(Model model, Review review) {

		List<Review> reviewList = boardService.getReview(review);
		System.out.println(reviewList + "reviewList");

		model.addAttribute("reviewList", reviewList);
		model.addAttribute("title", "수강후기");

		return "board/reviewList";
	}
	
	//수강 후기 작성 @Post
	@PostMapping("/addReview")
	public String insertReview(Review review
			  					,Model model
			  					,@RequestParam(value="reviewNum", required = false) String reviewNum
			  					,@RequestParam(value="reviewWriterId", required = false) String reviewWriterId
			  					,@RequestParam(value="reviewGrade", required = false) int reviewGrade
			  					,@RequestParam(value="reviewRegDate", required = false) String reviewRegDate
			  					,@RequestParam(value="reviewComment", required = false) String reviewComment	  					
			  					) {
		  System.out.println("reviewNum -> " + reviewNum);
		  System.out.println("reviewWriterId -> " + reviewWriterId);
		  System.out.println("reviewGrade -> " + reviewGrade);
		  System.out.println("reviewRegDate -> " + reviewRegDate);
		  System.out.println("reviewComment -> " + reviewComment);
		  boardService.addReview(review);
		  model.addAttribute("Review", review);
		  model.addAttribute("ReviewUpload", "/review");
		  return "redirect:/getReview";
	}	  
	//수강 후기 작성 @Get
	@GetMapping("/addReview")
	public String insertReview(Model model, HttpSession session) {
	
	   session.getAttribute("SID");	//세션 아이디 받기
	   String reviewNum = boardService.getReviewNum();
	   System.out.println(reviewNum + " <-- reviewNum");
	   model.addAttribute("reviewNum", reviewNum);
      return "board/addReview";
   }
	
	//수강 후기 삭제
	@GetMapping("/removeReview")
	public String removeReview(Model model
			,@RequestParam(value="reviewNum", required = false) String reviewNum) {
		boardService.removeReview(reviewNum);
		System.out.println(reviewNum + "reviewNum");
		return "redirect:/getReview";
	}
}