package cafe24.wio.bean;

public class Question {
	private int qeCode;
	private String qtCodeName;
	private String qcStudent;
	private String qeOid;
	private String qeData;
	private int qeScore;
	private String qeAnswer;
	private String qeDate;
	
	
	
	
	
	@Override
	public String toString() {
		return "Question [qeCode=" + qeCode + ", qtCodeName=" + qtCodeName + ", qcStudent=" + qcStudent + ", qeOid="
				+ qeOid + ", qeData=" + qeData + ", qeScore=" + qeScore + ", qeAnswer=" + qeAnswer + ", qeDate="
				+ qeDate + "]";
	}
	public String getQeDate() {
		return qeDate;
	}
	public void setQeDate(String qeDate) {
		this.qeDate = qeDate;
	}
	public int getQeCode() {
		return qeCode;
	}
	public void setQeCode(int qeCode) {
		this.qeCode = qeCode;
	}
	public String getQtCodeName() {
		return qtCodeName;
	}
	public void setQtCodeName(String qtCodeName) {
		this.qtCodeName = qtCodeName;
	}
	public String getQcStudent() {
		return qcStudent;
	}
	public void setQcStudent(String qcStudent) {
		this.qcStudent = qcStudent;
	}
	public String getQeOid() {
		return qeOid;
	}
	public void setQeOid(String qeOid) {
		this.qeOid = qeOid;
	}
	public String getQeData() {
		return qeData;
	}
	public void setQeData(String qeData) {
		this.qeData = qeData;
	}
	public int getQeScore() {
		return qeScore;
	}
	public void setQeScore(int qeScore) {
		this.qeScore = qeScore;
	}
	public String getQeAnswer() {
		return qeAnswer;
	}
	public void setQeAnswer(String qeAnswer) {
		this.qeAnswer = qeAnswer;
	}
	
	
}
