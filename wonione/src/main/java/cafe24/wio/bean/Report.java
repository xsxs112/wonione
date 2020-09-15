package cafe24.wio.bean;

public class Report {
	
	private String lecOpenCode;
	private String lecOpenScheCode;
	private String lecTuition;
	private String mrId;
	private String lecTarget;
	private String lecPlan;
	private String lecEtc;
	private String openLecRegDate;
	private String mrName;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Report [lecOpenCode=");
		builder.append(lecOpenCode);
		builder.append(", lecOpenScheCode=");
		builder.append(lecOpenScheCode);
		builder.append(", lecTuition=");
		builder.append(lecTuition);
		builder.append(", mrId=");
		builder.append(mrId);
		builder.append(", lecTarget=");
		builder.append(lecTarget);
		builder.append(", lecPlan=");
		builder.append(lecPlan);
		builder.append(", lecEtc=");
		builder.append(lecEtc);
		builder.append(", openLecRegDate=");
		builder.append(openLecRegDate);
		builder.append(", mrName=");
		builder.append(mrName);
		builder.append("]");
		return builder.toString();
	}
	public String getLecOpenCode() {
		return lecOpenCode;
	}
	public void setLecOpenCode(String lecOpenCode) {
		this.lecOpenCode = lecOpenCode;
	}
	public String getLecOpenScheCode() {
		return lecOpenScheCode;
	}
	public void setLecOpenScheCode(String lecOpenScheCode) {
		this.lecOpenScheCode = lecOpenScheCode;
	}
	public String getLecTuition() {
		return lecTuition;
	}
	public void setLecTuition(String lecTuition) {
		this.lecTuition = lecTuition;
	}
	public String getMrId() {
		return mrId;
	}
	public void setMrId(String mrId) {
		this.mrId = mrId;
	}
	public String getLecTarget() {
		return lecTarget;
	}
	public void setLecTarget(String lecTarget) {
		this.lecTarget = lecTarget;
	}
	public String getLecPlan() {
		return lecPlan;
	}
	public void setLecPlan(String lecPlan) {
		this.lecPlan = lecPlan;
	}
	public String getLecEtc() {
		return lecEtc;
	}
	public void setLecEtc(String lecEtc) {
		this.lecEtc = lecEtc;
	}
	public String getOpenLecRegDate() {
		return openLecRegDate;
	}
	public void setOpenLecRegDate(String openLecRegDate) {
		this.openLecRegDate = openLecRegDate;
	}
	public String getMrName() {
		return mrName;
	}
	public void setMrName(String mrName) {
		this.mrName = mrName;
	}
}
