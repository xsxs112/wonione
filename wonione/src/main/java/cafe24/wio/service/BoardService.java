package cafe24.wio.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cafe24.wio.bean.Board;
import cafe24.wio.mapper.BoardMapper;

@Service
public class BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	//공지사항 조회
	public List<Board> getNotice(Board board){
		System.out.println(board + " <-- board");
		List<Board> noticeList = boardMapper.getNotice(board);
		return noticeList;
	}
	
	//공지사항 읽기
	public Board readNotice(String boardNum) {
		Board board = boardMapper.readBoard(boardNum);
		return board;
	}
	
	//공지사항 작성
	public int addNotice(Board board) {
		int write = boardMapper.addNotice(board);
		return write;		
	}
	
	//글번호 자동증가
	public String getBoardNum() {
		
		Map<String, Object> boardNumMax = boardMapper.getBoardNum();
		
		String tempCode = "board_000";
		
		int getMax = Integer.parseInt(boardNumMax.get("max").toString());
		
		if(getMax<10) {
			tempCode = "board_0000";
		}else if(getMax<100) {
			tempCode = "board_000";
		}else if(getMax<1000) {
			tempCode = "board_00";
		}else if(getMax<10000) {
			tempCode = "board_0";
		}
		String boardNum = tempCode + String.valueOf(boardNumMax.get("max"));
		
		return boardNum;
	}
	
	//공지사항 수정
	public int modifyNotice(Board board) {
		int modify = boardMapper.modifyBoard(board);
		return modify;
	}
	
	//공지사항 삭제
	public int removeNotice(String boardNum) {
		int remove = boardMapper.removeBoard(boardNum);
		return remove;
	}

	//공지사항 검색
	public List<Board> getNoticeSearch(String bdSk, String bdSv){
		List<Board> noticeList = boardMapper.getSearch(bdSk, bdSv);
		return noticeList;
	}	

	//자료게시판 조회
	public List<Board> getDataLibrary(Board board){
		System.out.println(board + " <-- board");
		List<Board> dataList = boardMapper.getDataLibrary(board);
		return dataList;
	}

	//자료게시판 읽기
	public Board readDataLibrary(String boardNum) {
		Board board = boardMapper.readBoard(boardNum);
		return board;
	}
	
}
