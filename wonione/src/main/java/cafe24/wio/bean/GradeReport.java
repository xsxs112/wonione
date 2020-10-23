package cafe24.wio.bean;

public class GradeReport {

	private String reportLecCode;
	private String lecOpenCode;
	private String openLecCode;
	private String gradeTestNum;
	private String mrId;
	private String mrName;
	private String workReport;
	private String gradeAverage;
	private int achievementRate;
	private String finLecRegDate;
	private String testNumber;
	private String lecName;
	private String lecTarget;
	private int claPeople;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GradeReport [reportLecCode=");
		builder.append(reportLecCode);
		builder.append(", lecOpenCode=");
		builder.append(lecOpenCode);
		builder.append(", openLecCode=");
		builder.append(openLecCode);
		builder.append(", gradeTestNum=");
		builder.append(gradeTestNum);
		builder.append(", mrId=");
		builder.append(mrId);
		builder.append(", mrName=");
		builder.append(mrName);
		builder.append(", workReport=");
		builder.append(workReport);
		builder.append(", gradeAverage=");
		builder.append(gradeAverage);
		builder.append(", achievementRate=");
		builder.append(achievementRate);
		builder.append(", finLecRegDate=");
		builder.append(finLecRegDate);
		builder.append(", testNumber=");
		builder.append(testNumber);
		builder.append(", lecName=");
		builder.append(lecName);
		builder.append(", lecTarget=");
		builder.append(lecTarget);
		builder.append(", claPeople=");
		builder.append(claPeople);
		builder.append("]");
		return builder.toString();
	}
	public String getReportLecCode() {
		return reportLecCode;
	}
	public void setReportLecCode(String reportLecCode) {
		this.reportLecCode = reportLecCode;
	}
	public String getOpenLecCode() {
		return openLecCode;
	}
	public void setOpenLecCode(String openLecCode) {
		this.openLecCode = openLecCode;
	}
	public String getGradeTestNum() {
		return gradeTestNum;
	}
	public void setGradeTestNum(String gradeTestNum) {
		this.gradeTestNum = gradeTestNum;
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
	public String getWorkReport() {
		return workReport;
	}
	public void setWorkReport(String workReport) {
		this.workReport = workReport;
	}
	public String getGradeAverage() {
		return gradeAverage;
	}
	public void setGradeAverage(String gradeAverage) {
		this.gradeAverage = gradeAverage;
	}
	public int getAchievementRate() {
		return achievementRate;
	}
	public void setAchievementRate(int achievementRate) {
		this.achievementRate = achievementRate;
	}
	public String getFinLecRegDate() {
		return finLecRegDate;
	}
	public void setFinLecRegDate(String finLecRegDate) {
		this.finLecRegDate = finLecRegDate;
	}
	public String getTestNumber() {
		return testNumber;
	}
	public void setTestNumber(String testNumber) {
		this.testNumber = testNumber;
	}
	public String getLecName() {
		return lecName;
	}
	public void setLecName(String lecName) {
		this.lecName = lecName;
	}
	public String getLecTarget() {
		return lecTarget;
	}

	public void setLecTarget(String lecTarget) {
		this.lecTarget = lecTarget;
	}

	public int getClaPeople() {
		return claPeople;
	}
	public void setClaPeople(int claPeople) {
		this.claPeople = claPeople;
	}
	public String getLecOpenCode() {
		return lecOpenCode;
	}
	public void setLecOpenCode(String lecOpenCode) {
		this.lecOpenCode = lecOpenCode;
	}
	
}
