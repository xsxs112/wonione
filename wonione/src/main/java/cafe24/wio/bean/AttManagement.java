package cafe24.wio.bean;

public class AttManagement {

	
	String attCode;
	String attDate;
	String mrId;
	String attStTime;
	String attEndTime;
	String attTime;
	String attNote;
	String goingOut;
	String goingOutStTime;
	String goingOutEndTime;
	
	
	
	public String getAttCode() {
		return attCode;
	}
	public void setAttCode(String attCode) {
		this.attCode = attCode;
	}
	public String getAttDate() {
		return attDate;
	}
	public void setAttDate(String attDate) {
		this.attDate = attDate;
	}
	public String getMrId() {
		return mrId;
	}
	public void setMrId(String mrId) {
		this.mrId = mrId;
	}
	public String getAttStTime() {
		return attStTime;
	}
	public void setAttStTime(String attStTime) {
		this.attStTime = attStTime;
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
	public String getGoingOut() {
		return goingOut;
	}
	public void setGoingOut(String goingOut) {
		this.goingOut = goingOut;
	}
	public String getGoingOutStTime() {
		return goingOutStTime;
	}
	public void setGoingOutStTime(String goingOutStTime) {
		this.goingOutStTime = goingOutStTime;
	}
	public String getGoingOutEndTime() {
		return goingOutEndTime;
	}
	public void setGoingOutEndTime(String goingOuEndTime) {
		this.goingOutEndTime = goingOuEndTime;
	}
	
	
	@Override
	public String toString() {
		return "AttManagement [attCode=" + attCode + ", attDate=" + attDate + ", mrId=" + mrId + ", attStTime="
				+ attStTime + ", attEndTime=" + attEndTime + ", attTime=" + attTime + ", attNote=" + attNote
				+ ", goingOut=" + goingOut + ", goingOutStTime=" + goingOutStTime + ", goingOuEndTime=" + goingOutEndTime
				+ "]";
	}
	
	
	
	


	
	
	
	
	
}
