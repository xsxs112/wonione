package cafe24.wio.bean;

public class Course {
	
	// 수업 과정 Bean
	
	private String 	courseNum;		// 과정 테이블 PK
	private String 	lecOsCode;		// 강의 개설 예정 코드
	private String 	lecName;		// 강의명
	private String 	lecDay;			// 진행 요일
	private String 	lecStartTime;	// 수업 시작 시간
	private String 	lecEndTime;		// 수업 종료 시간
	private int 	lecTuition;		// 단가
	private int 	claCapacity;	// 수강 정원
	private String 	appSid;			// 신청 학생 아이디
	private String 	appGroupSid; 	// 그룹화 코드
	
	
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
	public String getLecName() {
		return lecName;
	}
	public void setLecName(String lecName) {
		this.lecName = lecName;
	}
	public String getLecDay() {
		return lecDay;
	}
	public void setLecDay(String lecDay) {
		this.lecDay = lecDay;
	}
	public String getLecStartTime() {
		return lecStartTime;
	}
	public void setLecStartTime(String lecStartTime) {
		this.lecStartTime = lecStartTime;
	}
	public String getLecEndTime() {
		return lecEndTime;
	}
	public void setLecEndTime(String lecEndTime) {
		this.lecEndTime = lecEndTime;
	}
	public int getLecTuition() {
		return lecTuition;
	}
	public void setLecTuition(int lecTuition) {
		this.lecTuition = lecTuition;
	}
	public int getClaCapacity() {
		return claCapacity;
	}
	public void setClaCapacity(int claCapacity) {
		this.claCapacity = claCapacity;
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
		builder.append(", lecName=");
		builder.append(lecName);
		builder.append(", lecDay=");
		builder.append(lecDay);
		builder.append(", lecStartTime=");
		builder.append(lecStartTime);
		builder.append(", lecEndTime=");
		builder.append(lecEndTime);
		builder.append(", lecTuition=");
		builder.append(lecTuition);
		builder.append(", claCapacity=");
		builder.append(claCapacity);
		builder.append(", appSid=");
		builder.append(appSid);
		builder.append(", appGroupSid=");
		builder.append(appGroupSid);
		builder.append("]");
		return builder.toString();
	}
	
}
