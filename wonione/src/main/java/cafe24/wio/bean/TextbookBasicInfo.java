package cafe24.wio.bean;


public class TextbookBasicInfo {

	private String txbCode;			//교재코드
	private String txbName;			//교재명
	private String txbPublisher;	//출판사
	private String txbAuthor;		//저자
	private String txbWriter;		//작성자아이디
	private String txbRegDate;		//등록일자
	private String txbRemark;		//비고
	
	public String getTxbCode() {
		return txbCode;
	}
	public void setTxbCode(String txbCode) {
		this.txbCode = txbCode;
	}
	public String getTxbName() {
		return txbName;
	}
	public void setTxbName(String txbName) {
		this.txbName = txbName;
	}
	public String getTxbPublisher() {
		return txbPublisher;
	}
	public void setTxbPublisher(String txbPublisher) {
		this.txbPublisher = txbPublisher;
	}
	public String getTxbAuthor() {
		return txbAuthor;
	}
	public void setTxbAuthor(String txbAuthor) {
		this.txbAuthor = txbAuthor;
	}
	public String getTxbWriter() {
		return txbWriter;
	}
	public void setTxbWriter(String txbWriter) {
		this.txbWriter = txbWriter;
	}
	public String getTxbRegDate() {
		return txbRegDate;
	}
	public void setTxbRegDate(String txbRegDate) {
		this.txbRegDate = txbRegDate;
	}
	public String getTxbRemark() {
		return txbRemark;
	}
	public void setTxbRemark(String txbRemark) {
		this.txbRemark = txbRemark;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TextbookBasicInfo [txbCode=");
		builder.append(txbCode);
		builder.append(", txbName=");
		builder.append(txbName);
		builder.append(", txbPublisher=");
		builder.append(txbPublisher);
		builder.append(", txbAuthor=");
		builder.append(txbAuthor);
		builder.append(", txbWriter=");
		builder.append(txbWriter);
		builder.append(", txbRegDate=");
		builder.append(txbRegDate);
		builder.append(", txbRemark=");
		builder.append(txbRemark);
		builder.append("]");
		return builder.toString();
	}

	
	
	
}
