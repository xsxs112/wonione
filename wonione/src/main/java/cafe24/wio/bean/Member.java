package cafe24.wio.bean;

//Member Bean - 정진수

public class Member {
	private String  mrId;			//구성원 아이디
	private String  mrPw;			//구성원 비밀번호
	private String  mrName;			//구성원 이름
	private int 	levelNum;		//권한 번호
	private String  levelName;		//권한명
	private String  mrPhone;		// 연락처
	private String  mrAddr;			// 주소
	private int 	mrTargetScore;	// 목표 점수
	private String  pmRCode;		// 은행 코드
	private String  mrAccountNum;	// 계좌 번호
	private String  shuttleNum;		// 셔틀 번호
	private String  mrRegDate;		// 등록 일자
	
	
	public String getMrId() {
		return mrId;
	}
	public void setMrId(String mrId) {
		this.mrId = mrId;
	}
	public String getMrPw() {
		return mrPw;
	}
	public void setMrPw(String mrPw) {
		this.mrPw = mrPw;
	}
	public String getMrName() {
		return mrName;
	}
	public void setMrName(String mrName) {
		this.mrName = mrName;
	}
	public int getLevelNum() {
		return levelNum;
	}
	public void setLevelNum(int levelNum) {
		this.levelNum = levelNum;
	}
	public String getLevelName() {
		return levelName;
	}
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	public String getMrPhone() {
		return mrPhone;
	}
	public void setMrPhone(String mrPhone) {
		this.mrPhone = mrPhone;
	}
	public String getMrAddr() {
		return mrAddr;
	}
	public void setMrAddr(String mrAddr) {
		this.mrAddr = mrAddr;
	}
	public int getMrTargetScore() {
		return mrTargetScore;
	}
	public void setMrTargetScore(int mrTargetScore) {
		this.mrTargetScore = mrTargetScore;
	}
	public String getPmRCode() {
		return pmRCode;
	}
	public void setPmRCode(String pmRCode) {
		this.pmRCode = pmRCode;
	}
	public String getMrAccountNum() {
		return mrAccountNum;
	}
	public void setMrAccountNum(String mrAccountNum) {
		this.mrAccountNum = mrAccountNum;
	}
	public String getShuttleNum() {
		return shuttleNum;
	}
	public void setShuttleNum(String shuttleNum) {
		this.shuttleNum = shuttleNum;
	}
	public String getMrRegDate() {
		return mrRegDate;
	}
	public void setMrRegDate(String mrRegDate) {
		this.mrRegDate = mrRegDate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Member [mrId=");
		builder.append(mrId);
		builder.append(", mrPw=");
		builder.append(mrPw);
		builder.append(", mrName=");
		builder.append(mrName);
		builder.append(", levelNum=");
		builder.append(levelNum);
		builder.append(", levelName=");
		builder.append(levelName);
		builder.append(", mrPhone=");
		builder.append(mrPhone);
		builder.append(", mrAddr=");
		builder.append(mrAddr);
		builder.append(", mrTargetScore=");
		builder.append(mrTargetScore);
		builder.append(", pmRCode=");
		builder.append(pmRCode);
		builder.append(", mrAccountNum=");
		builder.append(mrAccountNum);
		builder.append(", shuttleNum=");
		builder.append(shuttleNum);
		builder.append(", mrRegDate=");
		builder.append(mrRegDate);
		builder.append("]");
		return builder.toString();
	}
}
