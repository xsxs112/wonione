package cafe24.wio.bean;

public class Board {
	
	public String boardNum;
	public String boardMenu;
	public String boardTitle;
	public String boardWriterId;
	public String boardRegDate;
	public String boardContents;
	public String boardPicture;
	public String boardFile;
	public String boardLec;
	public int boardGrade;
	public String getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(String boardNum) {
		this.boardNum = boardNum;
	}
	public String getBoardMenu() {
		return boardMenu;
	}
	public void setBoardMenu(String boardMenu) {
		this.boardMenu = boardMenu;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardWriterId() {
		return boardWriterId;
	}
	public void setBoardWriterId(String boardWriterId) {
		this.boardWriterId = boardWriterId;
	}
	public String getBoardRegDate() {
		return boardRegDate;
	}
	public void setBoardRegDate(String boardRegDate) {
		this.boardRegDate = boardRegDate;
	}
	public String getBoardContents() {
		return boardContents;
	}
	public void setBoardContents(String boardContents) {
		this.boardContents = boardContents;
	}
	public String getBoardPicture() {
		return boardPicture;
	}
	public void setBoardPicture(String boardPicture) {
		this.boardPicture = boardPicture;
	}
	public String getBoardFile() {
		return boardFile;
	}
	public void setBoardFile(String boardFile) {
		this.boardFile = boardFile;
	}
	public String getBoardLec() {
		return boardLec;
	}
	public void setBoardLec(String boardLec) {
		this.boardLec = boardLec;
	}
	public int getBoardGrade() {
		return boardGrade;
	}
	public void setBoardGrade(int boardGrade) {
		this.boardGrade = boardGrade;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Board [boardNum=");
		builder.append(boardNum);
		builder.append(", boardMenu=");
		builder.append(boardMenu);
		builder.append(", boardTitle=");
		builder.append(boardTitle);
		builder.append(", boardWriterId=");
		builder.append(boardWriterId);
		builder.append(", boardRegDate=");
		builder.append(boardRegDate);
		builder.append(", boardContents=");
		builder.append(boardContents);
		builder.append(", boardPicture=");
		builder.append(boardPicture);
		builder.append(", boardFile=");
		builder.append(boardFile);
		builder.append(", boardLec=");
		builder.append(boardLec);
		builder.append(", boardGrade=");
		builder.append(boardGrade);
		builder.append("]");
		return builder.toString();
	}
	
}
