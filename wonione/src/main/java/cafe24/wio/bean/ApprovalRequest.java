package cafe24.wio.bean;

public class ApprovalRequest {
	
	private String reCode; //요청코드
	private String reSortation; //요청구분
	private String mrId; //아이디
	private String mrName; //이름
	private String reDate; //요청날짜
	private String reStartDate; //시작날짜
	private String reEndDate; //종료날짜
	private String reOuttingTime; //외출시간
	private String reReason; //사유
	private String sortation; //구분
	private String reSupervisor; //승인자
	private String reProcessingDate; //승인날짜
	private String reState; //상태
	private String refuseReason; //거절 사유
	public String getReCode() {
		return reCode;
	}
	public void setReCode(String reCode) {
		this.reCode = reCode;
	}
	public String getReSortation() {
		return reSortation;
	}
	public void setReSortation(String reSortation) {
		this.reSortation = reSortation;
	}
	public String getMrId() {
		return mrId;
	}
	public void setMrId(String mrId) {
		this.mrId = mrId;
	}
	public String getMrName() {
		return mrName;
	}
	public void setMrName(String mrName) {
		this.mrName = mrName;
	}
	public String getReDate() {
		return reDate;
	}
	public void setReDate(String reDate) {
		this.reDate = reDate;
	}
	public String getReStartDate() {
		return reStartDate;
	}
	public void setReStartDate(String reStartDate) {
		this.reStartDate = reStartDate;
	}
	public String getReEndDate() {
		return reEndDate;
	}
	public void setReEndDate(String reEndDate) {
		this.reEndDate = reEndDate;
	}
	public String getReOuttingTime() {
		return reOuttingTime;
	}
	public void setReOuttingTime(String reOuttingTime) {
		this.reOuttingTime = reOuttingTime;
	}
	public String getReReason() {
		return reReason;
	}
	public void setReReason(String reReason) {
		this.reReason = reReason;
	}
	public String getSortation() {
		return sortation;
	}
	public void setSortation(String sortation) {
		this.sortation = sortation;
	}
	public String getReSupervisor() {
		return reSupervisor;
	}
	public void setReSupervisor(String reSupervisor) {
		this.reSupervisor = reSupervisor;
	}
	public String getReProcessingDate() {
		return reProcessingDate;
	}
	public void setReProcessingDate(String reProcessingDate) {
		this.reProcessingDate = reProcessingDate;
	}
	public String getReState() {
		return reState;
	}
	public void setReState(String reState) {
		this.reState = reState;
	}
	public String getRefuseReason() {
		return refuseReason;
	}
	public void setRefuseReason(String refuseReason) {
		this.refuseReason = refuseReason;
	}
	@Override
	public String toString() {
		return "ApprovalRequest [reCode=" + reCode + ", reSortation=" + reSortation + ", mrId=" + mrId + ", mrName="
				+ mrName + ", reDate=" + reDate + ", reStartDate=" + reStartDate + ", reEndDate=" + reEndDate
				+ ", reOuttingTime=" + reOuttingTime + ", reReason=" + reReason + ", sortation=" + sortation
				+ ", reSupervisor=" + reSupervisor + ", reProcessingDate=" + reProcessingDate + ", reState=" + reState
				+ ", refuseReason=" + refuseReason + "]";
	}
	
	
	

}
