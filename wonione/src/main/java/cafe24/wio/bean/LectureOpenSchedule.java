package cafe24.wio.bean;

public class LectureOpenSchedule {
	
	private String lecOsCode;		//강의개설예정코드
	private String lecName;			//강의명
	private String mrTeacherId;		//강사아이디
	private String mrTeacherName;	//강사이름
	private String lecTime;			//강의시간
	private String lecRoom;			//강의실
	private String lecDay;			//강의요일
	private String lecLevel;		//수업수준
	private String lecTuition;		//수업료
	private String claCapacity;		//수강정원
	private String lecStartDate;	//수업시작일자
	private String lecFinalDate;	//수업종료일자
	private String lecOsWriter;		//작성자아이디
	private String lecOsRegDate;	//등록일자
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
	public String getMrTeacherId() {
		return mrTeacherId;
	}
	public void setMrTeacherId(String mrTeacherId) {
		this.mrTeacherId = mrTeacherId;
	}
	public String getMrTeacherName() {
		return mrTeacherName;
	}
	public void setMrTeacherName(String mrTeacherName) {
		this.mrTeacherName = mrTeacherName;
	}
	public String getLecTime() {
		return lecTime;
	}
	public void setLecTime(String lecTime) {
		this.lecTime = lecTime;
	}
	public String getLecRoom() {
		return lecRoom;
	}
	public void setLecRoom(String lecRoom) {
		this.lecRoom = lecRoom;
	}
	public String getLecDay() {
		return lecDay;
	}
	public void setLecDay(String lecDay) {
		this.lecDay = lecDay;
	}
	public String getLecLevel() {
		return lecLevel;
	}
	public void setLecLevel(String lecLevel) {
		this.lecLevel = lecLevel;
	}
	public String getLecTuition() {
		return lecTuition;
	}
	public void setLecTuition(String lecTuition) {
		this.lecTuition = lecTuition;
	}
	public String getClaCapacity() {
		return claCapacity;
	}
	public void setClaCapacity(String claCapacity) {
		this.claCapacity = claCapacity;
	}
	public String getLecStartDate() {
		return lecStartDate;
	}
	public void setLecStartDate(String lecStartDate) {
		this.lecStartDate = lecStartDate;
	}
	public String getLecFinalDate() {
		return lecFinalDate;
	}
	public void setLecFinalDate(String lecFinalDate) {
		this.lecFinalDate = lecFinalDate;
	}
	public String getLecOsWriter() {
		return lecOsWriter;
	}
	public void setLecOsWriter(String lecOsWriter) {
		this.lecOsWriter = lecOsWriter;
	}
	public String getLecOsRegDate() {
		return lecOsRegDate;
	}
	public void setLecOsRegDate(String lecOsRegDate) {
		this.lecOsRegDate = lecOsRegDate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LectureOpenSchedule [lecOsCode=");
		builder.append(lecOsCode);
		builder.append(", lecName=");
		builder.append(lecName);
		builder.append(", mrTeacherId=");
		builder.append(mrTeacherId);
		builder.append(", mrTeacherName=");
		builder.append(mrTeacherName);
		builder.append(", lecTime=");
		builder.append(lecTime);
		builder.append(", lecRoom=");
		builder.append(lecRoom);
		builder.append(", lecDay=");
		builder.append(lecDay);
		builder.append(", lecLevel=");
		builder.append(lecLevel);
		builder.append(", lecTuition=");
		builder.append(lecTuition);
		builder.append(", claCapacity=");
		builder.append(claCapacity);
		builder.append(", lecStartDate=");
		builder.append(lecStartDate);
		builder.append(", lecFinalDate=");
		builder.append(lecFinalDate);
		builder.append(", lecOsWriter=");
		builder.append(lecOsWriter);
		builder.append(", lecOsRegDate=");
		builder.append(lecOsRegDate);
		builder.append("]");
		return builder.toString();
	}

	
	
	

	
}
