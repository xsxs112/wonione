package cafe24.wio.bean;


public class WhTextbook {
	private String whTxbCode;			//교재입고코드
	private String txbCode;				//교재코드
	private int whTxbQuantity;			//입고수량
	private String whTxbDate;
	private String whTxbDateTime;		//입고일자시간
	private int stockTxbQuantity;		//재고수량
	private String whTxbWriter;			//작성자아이디
	private String whTxbRegDate;		//등록일자
	private String whTxbRemark;			//비고
	private String whTxbModifier;		//수정자
	private String whTxbModifyDate;		//수정일자
	
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
	public String getWhTxbDateTime() {
		return whTxbDateTime;
	}
	public void setWhTxbDateTime(String whTxbDateTime) {
		this.whTxbDateTime = whTxbDateTime;
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
	public String getWhTxbRemark() {
		return whTxbRemark;
	}
	public void setWhTxbRemark(String whTxbRemark) {
		this.whTxbRemark = whTxbRemark;
	}
	public String getWhTxbModifier() {
		return whTxbModifier;
	}
	public void setWhTxbModifier(String whTxbModifier) {
		this.whTxbModifier = whTxbModifier;
	}
	public String getWhTxbModifyDate() {
		return whTxbModifyDate;
	}
	public void setWhTxbModifyDate(String whTxbModifyDate) {
		this.whTxbModifyDate = whTxbModifyDate;
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
		builder.append(", whTxbDateTime=");
		builder.append(whTxbDateTime);
		builder.append(", stockTxbQuantity=");
		builder.append(stockTxbQuantity);
		builder.append(", whTxbWriter=");
		builder.append(whTxbWriter);
		builder.append(", whTxbRegDate=");
		builder.append(whTxbRegDate);
		builder.append(", whTxbRemark=");
		builder.append(whTxbRemark);
		builder.append(", whTxbModifier=");
		builder.append(whTxbModifier);
		builder.append(", whTxbModifyDate=");
		builder.append(whTxbModifyDate);
		builder.append("]");
		return builder.toString();
	}
	
	
	

}
