package cafe24.wio.bean;

public class Board {
	
	public String boardNum;
	public String boardMenu;
	public String boardTitle;
	public String boardWriterId;
	public String boardWriterName;
	public String boardRegDate;
	public String boardContents;
	public String boardPicture;
	public String boardFile;

	
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
	public String getBoardWriterName() {
		return boardWriterName;
	}
	public void setBoardWriterName(String boardWriterName) {
		this.boardWriterName = boardWriterName;
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
		builder.append(", boardWriterName=");
		builder.append(boardWriterName);
		builder.append(", boardRegDate=");
		builder.append(boardRegDate);
		builder.append(", boardContents=");
		builder.append(boardContents);
		builder.append(", boardPicture=");
		builder.append(boardPicture);
		builder.append(", boardFile=");
		builder.append(boardFile);
		builder.append("]");
		return builder.toString();
	}
	
}
