package cafe24.wio.bean;

public class Receipt {
	
	// 수납 Bean
	
	private String 	arCode;		// 수납 테이블 PK
	private String 	arGSid;		// 과정 테이블의 그룹화 아이디
	private int 	arAmount;	// 총 합 금액
	private int 	arFsAmount; // 실제 결제 예상 금액
	private String 	arDate;		// 결제일
	private String 	arManager;	// 결제 담당자
	
	
	public String getArCode() {
		return arCode;
	}
	public void setArCode(String arCode) {
		this.arCode = arCode;
	}
	public String getArGSid() {
		return arGSid;
	}
	public void setArGSid(String arGSid) {
		this.arGSid = arGSid;
	}
	public int getArAmount() {
		return arAmount;
	}
	public void setArAmount(int arAmount) {
		this.arAmount = arAmount;
	}
	public int getArFsAmount() {
		return arFsAmount;
	}
	public void setArFsAmount(int arFsAmount) {
		this.arFsAmount = arFsAmount;
	}
	public String getArDate() {
		return arDate;
	}
	public void setArDate(String arDate) {
		this.arDate = arDate;
	}
	public String getArManager() {
		return arManager;
	}
	public void setArManager(String arManager) {
		this.arManager = arManager;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Receipt [arCode=");
		builder.append(arCode);
		builder.append(", arGSid=");
		builder.append(arGSid);
		builder.append(", arAmount=");
		builder.append(arAmount);
		builder.append(", arFsAmount=");
		builder.append(arFsAmount);
		builder.append(", arDate=");
		builder.append(arDate);
		builder.append(", arManager=");
		builder.append(arManager);
		builder.append("]");
		return builder.toString();
	}
}
