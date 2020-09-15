package cafe24.wio.bean;

public class PaymentResource {
	
	private String pmRCode; //결제수단관리코드
	private String pmRTitle; //결제수단타이틀
	private String pmRGroupId; //결제수단그룹아이디 
	private String pmRGroupName; //결제수단그룹명
	private int pmRGroupSort; //결제수단정렬
	
	public String getPmRCode() {
		return pmRCode;
	}
	public void setPmRCode(String pmRCode) {
		this.pmRCode = pmRCode;
	}
	public String getPmRTitle() {
		return pmRTitle;
	}
	public void setPmRTitle(String pmRTitle) {
		this.pmRTitle = pmRTitle;
	}
	public String getPmRGroupId() {
		return pmRGroupId;
	}
	public void setPmRGroupId(String pmRGroupId) {
		this.pmRGroupId = pmRGroupId;
	}
	public String getPmRGroupName() {
		return pmRGroupName;
	}
	public void setPmRGroupName(String pmRGroupName) {
		this.pmRGroupName = pmRGroupName;
	}
	public int getPmRGroupSort() {
		return pmRGroupSort;
	}
	public void setPmRGroupSort(int pmRGroupSort) {
		this.pmRGroupSort = pmRGroupSort;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PaymentResource [pmRCode=");
		builder.append(pmRCode);
		builder.append(", pmRTitle=");
		builder.append(pmRTitle);
		builder.append(", pmRGroupId=");
		builder.append(pmRGroupId);
		builder.append(", pmRGroupName=");
		builder.append(pmRGroupName);
		builder.append(", pmRGroupSort=");
		builder.append(pmRGroupSort);
		builder.append("]");
		return builder.toString();
	}		
}
