package cafe24.wio.bean;

public class LectureOpenSchedule {
	
	private String lecOsCode;
	private String lecName;
	private String mrTeacherId;
	private String lecTimeCode;
	private String lecRoomCode;
	private String lecDay;
	private String lecLevelCode;
	private String tfCode;
	private String lecStDate;
	private String lecFinDate;
	private String lecOsRegDate;
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
	public String getTfCode() {
		return tfCode;
	}
	public void setTfCode(String tfCode) {
		this.tfCode = tfCode;
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
		builder.append(", tfCode=");
		builder.append(tfCode);
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
