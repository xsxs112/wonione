package cafe24.wio.bean;

public class WorkAttendance {
	
	private String attCode;  //코드
	private String mrId;  //회원아이디
	private String attDate; //날짜
	private String attStartTime; //시작시간
	private String attEndTime; //끝난시간
	private String attTime; //일한 시간
	private String attNote; //비고
	
	
	
	public String getAttCode() {
		return attCode;
	}
	public void setAttCode(String attCode) {
		this.attCode = attCode;
	}
	public String getMrId() {
		return mrId;
	}
	public void setMrId(String mrId) {
		this.mrId = mrId;
	}
	public String getAttDate() {
		return attDate;
	}
	public void setAttDate(String attDate) {
		this.attDate = attDate;
	}
	public String getAttStartTime() {
		return attStartTime;
	}
	public void setAttStartTime(String attStartTime) {
		this.attStartTime = attStartTime;
	}
	public String getAttEndTime() {
		return attEndTime;
	}
	public void setAttEndTime(String attEndTime) {
		this.attEndTime = attEndTime;
	}
	public String getAttTime() {
		return attTime;
	}
	public void setAttTime(String attTime) {
		this.attTime = attTime;
	}
	public String getAttNote() {
		return attNote;
	}
	public void setAttNote(String attNote) {
		this.attNote = attNote;
	}
	@Override
	public String toString() {
		return "WorkAttendance [attCode=" + attCode + ", mrId=" + mrId + ", attDate=" + attDate + ", attStartTime="
				+ attStartTime + ", attEndTime=" + attEndTime + ", attTime=" + attTime + ", attNote=" + attNote + "]";
	}
	
	
	
	
	
}
