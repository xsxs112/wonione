package cafe24.wio.bean;

public class WhEquipment {
	
	private String whEqCode;		//비품입고코드
	private String eqCode;			//비품코드
	private String whEqName;		//품명
	private String whEqUnitPrice;	//단가
	private String whEqQuantity;	//수량
	private String whEqTotal;		//총구매액
	private String whEqDate;		//입고일자
	private String whEqWriter;		//작성자아이디
	private String whEqRegDate;		//등록일자
	private String whEqRemark;		//비고
	
	public String getWhEqCode() {
		return whEqCode;
	}
	public void setWhEqCode(String whEqCode) {
		this.whEqCode = whEqCode;
	}
	public String getEqCode() {
		return eqCode;
	}
	public void setEqCode(String eqCode) {
		this.eqCode = eqCode;
	}
	public String getWhEqName() {
		return whEqName;
	}
	public void setWhEqName(String whEqName) {
		this.whEqName = whEqName;
	}
	public String getWhEqUnitPrice() {
		return whEqUnitPrice;
	}
	public void setWhEqUnitPrice(String whEqUnitPrice) {
		this.whEqUnitPrice = whEqUnitPrice;
	}
	public String getWhEqQuantity() {
		return whEqQuantity;
	}
	public void setWhEqQuantity(String whEqQuantity) {
		this.whEqQuantity = whEqQuantity;
	}
	public String getWhEqTotal() {
		return whEqTotal;
	}
	public void setWhEqTotal(String whEqTotal) {
		this.whEqTotal = whEqTotal;
	}
	public String getWhEqDate() {
		return whEqDate;
	}
	public void setWhEqDate(String whEqDate) {
		this.whEqDate = whEqDate;
	}
	public String getWhEqWriter() {
		return whEqWriter;
	}
	public void setWhEqWriter(String whEqWriter) {
		this.whEqWriter = whEqWriter;
	}
	public String getWhEqRegDate() {
		return whEqRegDate;
	}
	public void setWhEqRegDate(String whEqRegDate) {
		this.whEqRegDate = whEqRegDate;
	}
	public String getWhEqRemark() {
		return whEqRemark;
	}
	public void setWhEqRemark(String whEqRemark) {
		this.whEqRemark = whEqRemark;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WhEquipment [whEqCode=");
		builder.append(whEqCode);
		builder.append(", eqCode=");
		builder.append(eqCode);
		builder.append(", whEqName=");
		builder.append(whEqName);
		builder.append(", whEqUnitPrice=");
		builder.append(whEqUnitPrice);
		builder.append(", whEqQuantity=");
		builder.append(whEqQuantity);
		builder.append(", whEqTotal=");
		builder.append(whEqTotal);
		builder.append(", whEqDate=");
		builder.append(whEqDate);
		builder.append(", whEqWriter=");
		builder.append(whEqWriter);
		builder.append(", whEqRegDate=");
		builder.append(whEqRegDate);
		builder.append(", whEqRemark=");
		builder.append(whEqRemark);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
