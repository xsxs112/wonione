package cafe24.wio.bean;

public class LectureOpen {

	private String lecOpCode;
	private String lecOsCode;
	private String lecStatus;
	private int claCapacity;
	private int claPeople;
	private int claLack;
	private String lecOpWriter;
	private String lecOpRegDate;
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
