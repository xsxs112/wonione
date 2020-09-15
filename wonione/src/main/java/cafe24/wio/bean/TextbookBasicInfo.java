package cafe24.wio.bean;

public class TextbookBasicInfo {

	private String txbCode;
	private String txbName;
	private String txbPublisher;
	private String txbAuthor;
	private String txbWriter;
	private String txbRegDate;
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
		builder.append("]");
		return builder.toString();
	}
	
	
}
