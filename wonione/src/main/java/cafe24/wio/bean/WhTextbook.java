package cafe24.wio.bean;

public class WhTextbook {
	private String whTxbCode;
	private String txbCode;
	private int whTxbQuantity;
	private String whTxbDate;
	private int stockTxbQuantity;
	private String whTxbWriter;
	private String whTxbRegDate;
	private String whTxb_remark;
	public String getWhTxbCode() {
		return whTxbCode;
	}
	public void setWhTxbCode(String whTxbCode) {
		this.whTxbCode = whTxbCode;
	}
	public String getTxbCode() {
		return txbCode;
	}
	public void setTxbCode(String txbCode) {
		this.txbCode = txbCode;
	}
	public int getWhTxbQuantity() {
		return whTxbQuantity;
	}
	public void setWhTxbQuantity(int whTxbQuantity) {
		this.whTxbQuantity = whTxbQuantity;
	}
	public String getWhTxbDate() {
		return whTxbDate;
	}
	public void setWhTxbDate(String whTxbDate) {
		this.whTxbDate = whTxbDate;
	}
	public int getStockTxbQuantity() {
		return stockTxbQuantity;
	}
	public void setStockTxbQuantity(int stockTxbQuantity) {
		this.stockTxbQuantity = stockTxbQuantity;
	}
	public String getWhTxbWriter() {
		return whTxbWriter;
	}
	public void setWhTxbWriter(String whTxbWriter) {
		this.whTxbWriter = whTxbWriter;
	}
	public String getWhTxbRegDate() {
		return whTxbRegDate;
	}
	public void setWhTxbRegDate(String whTxbRegDate) {
		this.whTxbRegDate = whTxbRegDate;
	}
	public String getWhTxb_remark() {
		return whTxb_remark;
	}
	public void setWhTxb_remark(String whTxb_remark) {
		this.whTxb_remark = whTxb_remark;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WhTextbook [whTxbCode=");
		builder.append(whTxbCode);
		builder.append(", txbCode=");
		builder.append(txbCode);
		builder.append(", whTxbQuantity=");
		builder.append(whTxbQuantity);
		builder.append(", whTxbDate=");
		builder.append(whTxbDate);
		builder.append(", stockTxbQuantity=");
		builder.append(stockTxbQuantity);
		builder.append(", whTxbWriter=");
		builder.append(whTxbWriter);
		builder.append(", whTxbRegDate=");
		builder.append(whTxbRegDate);
		builder.append(", whTxb_remark=");
		builder.append(whTxb_remark);
		builder.append("]");
		return builder.toString();
	}
	
	

}
