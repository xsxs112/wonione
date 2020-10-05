package cafe24.wio.bean;

public class GradeReport {

	private String reportLecCode;
	private String openLecCode;
	private String gradeTestNum;
	private String mrId;
	private String mrName;
	private String workReport;
	private String gradeAverage;
	private int achievementRate;
	private String finLecRegDate;
	private String testNumber;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GradeReport [reportLecCode=");
		builder.append(reportLecCode);
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
	

	
}
