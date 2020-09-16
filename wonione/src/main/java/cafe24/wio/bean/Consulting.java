package cafe24.wio.bean;

public class Consulting {
	
	private int	   ConsultingCode;		//상담코드
	private String ConsultingTitle; 	//상담제목
	private String ConsultingTeacher; 	//상담진행선생님
	private String ConsultingDate;		//상담일자
	private String ConsultingClass;		//상담받는학생의반
	private String ConsultingStudent;	//상담받는학생의이름
	private String ConsultingData;		//상담내용
	
	@Override
	public String toString() {
		return "Consulting [ConsultingCode=" + ConsultingCode + ", ConsultingTitle=" + ConsultingTitle
				+ ", ConsultingTeacher=" + ConsultingTeacher + ", ConsultingDate=" + ConsultingDate
				+ ", ConsultingClass=" + ConsultingClass + ", ConsultingStudent=" + ConsultingStudent
				+ ", ConsultingData=" + ConsultingData + "]";
	}
	public int getConsultingCode() {
		return ConsultingCode;
	}
	public void setConsultingCode(int consultingCode) {
		ConsultingCode = consultingCode;
	}
	public String getConsultingTitle() {
		return ConsultingTitle;
	}
	public void setConsultingTitle(String consultingTitle) {
		ConsultingTitle = consultingTitle;
	}
	public String getConsultingTeacher() {
		return ConsultingTeacher;
	}
	public void setConsultingTeacher(String consultingTeacher) {
		ConsultingTeacher = consultingTeacher;
	}
	public String getConsultingDate() {
		return ConsultingDate;
	}
	public void setConsultingDate(String consultingDate) {
		ConsultingDate = consultingDate;
	}
	public String getConsultingClass() {
		return ConsultingClass;
	}
	public void setConsultingClass(String consultingClass) {
		ConsultingClass = consultingClass;
	}
	public String getConsultingStudent() {
		return ConsultingStudent;
	}
	public void setConsultingStudent(String consultingStudent) {
		ConsultingStudent = consultingStudent;
	}
	public String getConsultingData() {
		return ConsultingData;
	}
	public void setConsultingData(String consultingData) {
		ConsultingData = consultingData;
	}
	
	
	
	
}
