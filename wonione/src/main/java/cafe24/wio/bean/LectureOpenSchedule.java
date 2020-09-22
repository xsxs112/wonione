package cafe24.wio.bean;

public class LectureOpenSchedule {
	
	private String lecOsCode;		//강의개설예정코드
	private String lecName;			//강의명
	private String mrTeacherId;		//강사아이디
	private String lecTimeCode;		//강의시간
	private String lecRoomCode;		//강의실
	private String lecDay;			//강의요일
	private String lecLevelCode;	//수업수준
	private String lecStDate;		//수업시작일자
	private String lecFinDate;		//수업종료일자
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
	public String getLecTimeCode() {
		return lecTimeCode;
	}
	public void setLecTimeCode(String lecTimeCode) {
		this.lecTimeCode = lecTimeCode;
	}
	public String getLecRoomCode() {
		return lecRoomCode;
	}
	public void setLecRoomCode(String lecRoomCode) {
		this.lecRoomCode = lecRoomCode;
	}
	public String getLecDay() {
		return lecDay;
	}
	public void setLecDay(String lecDay) {
		this.lecDay = lecDay;
	}
	public String getLecLevelCode() {
		return lecLevelCode;
	}
	public void setLecLevelCode(String lecLevelCode) {
		this.lecLevelCode = lecLevelCode;
	}
	public String getLecStDate() {
		return lecStDate;
	}
	public void setLecStDate(String lecStDate) {
		this.lecStDate = lecStDate;
	}
	public String getLecFinDate() {
		return lecFinDate;
	}
	public void setLecFinDate(String lecFinDate) {
		this.lecFinDate = lecFinDate;
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
		builder.append(", lecTimeCode=");
		builder.append(lecTimeCode);
		builder.append(", lecRoomCode=");
		builder.append(lecRoomCode);
		builder.append(", lecDay=");
		builder.append(lecDay);
		builder.append(", lecLevelCode=");
		builder.append(lecLevelCode);
		builder.append(", lecStDate=");
		builder.append(lecStDate);
		builder.append(", lecFinDate=");
		builder.append(lecFinDate);
		builder.append(", lecOsRegDate=");
		builder.append(lecOsRegDate);
		builder.append("]");
		return builder.toString();
	}
	
	
}
