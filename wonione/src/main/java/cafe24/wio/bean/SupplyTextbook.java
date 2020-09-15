package cafe24.wio.bean;

public class SupplyTextbook {
	
	private String supTxbCode;		//교재지급코드
	private String txbCode;			//교재코드
	private int supTxbQuantity;		//지급수량
	private String txbReceiverId;	//지급대상
	private String supTxbDate;		//지급일자
	private String supTxbWriter;	//작성자아이디
	private String supTxbRegDate;	//등록일자
	public String getSupTxbCode() {
		return supTxbCode;
	}
	public void setSupTxbCode(String supTxbCode) {
		this.supTxbCode = supTxbCode;
	}
	public String getTxbCode() {
		return txbCode;
	}
	public void setTxbCode(String txbCode) {
		this.txbCode = txbCode;
	}
	public int getSupTxbQuantity() {
		return supTxbQuantity;
	}
	public void setSupTxbQuantity(int supTxbQuantity) {
		this.supTxbQuantity = supTxbQuantity;
	}
	public String getTxbReceiverId() {
		return txbReceiverId;
	}
	public void setTxbReceiverId(String txbReceiverId) {
		this.txbReceiverId = txbReceiverId;
	}
	public String getSupTxbDate() {
		return supTxbDate;
	}
	public void setSupTxbDate(String supTxbDate) {
		this.supTxbDate = supTxbDate;
	}
	public String getSupTxbWriter() {
		return supTxbWriter;
	}
	public void setSupTxbWriter(String supTxbWriter) {
		this.supTxbWriter = supTxbWriter;
	}
	public String getSupTxbRegDate() {
		return supTxbRegDate;
	}
	public void setSupTxbRegDate(String supTxbRegDate) {
		this.supTxbRegDate = supTxbRegDate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SupplyTextbook [supTxbCode=");
		builder.append(supTxbCode);
		builder.append(", txbCode=");
		builder.append(txbCode);
		builder.append(", supTxbQuantity=");
		builder.append(supTxbQuantity);
		builder.append(", txbReceiverId=");
		builder.append(txbReceiverId);
		builder.append(", supTxbDate=");
		builder.append(supTxbDate);
		builder.append(", supTxbWriter=");
		builder.append(supTxbWriter);
		builder.append(", supTxbRegDate=");
		builder.append(supTxbRegDate);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
