package cafe24.wio.bean;

public class LectureOpen {

	private String lecOpCode;		//강의개설코드
	private String lecOsCode;		//강의개설예정코드
	private String lecStatus;		//강의상태
	private int claCapacity;		//수강정원
	private int claPeople;			//수강인원
	private int claLack;			//미달인원
	private String lecOpWriter;		//작성자아이디
	private String lecOpRegDate;	//등록일자
	public String getLecOpCode() {
		return lecOpCode;
	}
	public void setLecOpCode(String lecOpCode) {
		this.lecOpCode = lecOpCode;
	}
	public String getLecOsCode() {
		return lecOsCode;
	}
	public void setLecOsCode(String lecOsCode) {
		this.lecOsCode = lecOsCode;
	}
	public String getLecStatus() {
		return lecStatus;
	}
	public void setLecStatus(String lecStatus) {
		this.lecStatus = lecStatus;
	}
	public int getClaCapacity() {
		return claCapacity;
	}
	public void setClaCapacity(int claCapacity) {
		this.claCapacity = claCapacity;
	}
	public int getClaPeople() {
		return claPeople;
	}
	public void setClaPeople(int claPeople) {
		this.claPeople = claPeople;
	}
	public int getClaLack() {
		return claLack;
	}
	public void setClaLack(int claLack) {
		this.claLack = claLack;
	}
	public String getLecOpWriter() {
		return lecOpWriter;
	}
	public void setLecOpWriter(String lecOpWriter) {
		this.lecOpWriter = lecOpWriter;
	}
	public String getLecOpRegDate() {
		return lecOpRegDate;
	}
	public void setLecOpRegDate(String lecOpRegDate) {
		this.lecOpRegDate = lecOpRegDate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LectureOpen [lecOpCode=");
		builder.append(lecOpCode);
		builder.append(", lecOsCode=");
		builder.append(lecOsCode);
		builder.append(", lecStatus=");
		builder.append(lecStatus);
		builder.append(", claCapacity=");
		builder.append(claCapacity);
		builder.append(", claPeople=");
		builder.append(claPeople);
		builder.append(", claLack=");
		builder.append(claLack);
		builder.append(", lecOpWriter=");
		builder.append(lecOpWriter);
		builder.append(", lecOpRegDate=");
		builder.append(lecOpRegDate);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
