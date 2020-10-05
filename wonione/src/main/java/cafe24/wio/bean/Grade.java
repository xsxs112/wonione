package cafe24.wio.bean;

public class Grade {

	private String gradeManCode;
	private String mrId;
	private String testRound;
	private String gradeManScore; 
	private String gradeManRegDate;
	private String mrName;
	private String testNumber;
	private String lecName;
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Grade [gradeManCode=");
		builder.append(gradeManCode);
		builder.append(", mrId=");
		builder.append(mrId);
		builder.append(", testRound=");
		builder.append(testRound);
		builder.append(", gradeManScore=");
		builder.append(gradeManScore);
		builder.append(", gradeManRegDate=");
		builder.append(gradeManRegDate);
		builder.append(", mrName=");
		builder.append(mrName);
		builder.append(", testNumber=");
		builder.append(testNumber);
		builder.append(", lecName=");
		builder.append(lecName);
		builder.append("]");
		return builder.toString();
	}
	public String getGradeManCode() {
		return gradeManCode;
	}
	public void setGradeManCode(String gradeManCode) {
		this.gradeManCode = gradeManCode;
	}
	public String getMrId() {
		return mrId;
	}
	public void setMrId(String mrId) {
		this.mrId = mrId;
	}
	public String getTestRound() {
		return testRound;
	}
	public void setTestRound(String testRound) {
		this.testRound = testRound;
	}
	public String getGradeManScore() {
		return gradeManScore;
	}
	public void setGradeManScore(String gradeManScore) {
		this.gradeManScore = gradeManScore;
	}
	public String getGradeManRegDate() {
		return gradeManRegDate;
	}
	public void setGradeManRegDate(String gradeManRegDate) {
		this.gradeManRegDate = gradeManRegDate;
	}
	public String getMrName() {
		return mrName;
	}
	public void setMrName(String mrName) {
		this.mrName = mrName;
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

}
