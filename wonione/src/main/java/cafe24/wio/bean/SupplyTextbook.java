package cafe24.wio.bean;

public class SupplyTextbook {
	
	private String supTxbCode;
	private String txbCode;
	private int supTxbQuantity;
	private String txbReceiverId;
	private String supTxbDate;
	private String supTxbWriter;
	private String supTxbRegDate;
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
