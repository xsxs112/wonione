package cafe24.wio.bean;

public class Course {
	
	// 수업 과정 Bean
	
	private String courseNum;	// 과정 테이블 PK
	private String lecOsCode;	// 강의 개설 예정 코드
	private String appSid;		// 신청 학생 아이디
	private String appGroupSid; // 그룹화 짓는 코드
	
	
	public String getCourseNum() {
		return courseNum;
	}
	public void setCourseNum(String courseNum) {
		this.courseNum = courseNum;
	}
	public String getLecOsCode() {
		return lecOsCode;
	}
	public void setLecOsCode(String lecOsCode) {
		this.lecOsCode = lecOsCode;
	}
	public String getAppSid() {
		return appSid;
	}
	public void setAppSid(String appSid) {
		this.appSid = appSid;
	}
	public String getAppGroupSid() {
		return appGroupSid;
	}
	public void setAppGroupSid(String appGroupSid) {
		this.appGroupSid = appGroupSid;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Course [courseNum=");
		builder.append(courseNum);
		builder.append(", lecOsCode=");
		builder.append(lecOsCode);
		builder.append(", appSid=");
		builder.append(appSid);
		builder.append(", appGroupSid=");
		builder.append(appGroupSid);
		builder.append("]");
		return builder.toString();
	}
	
}
