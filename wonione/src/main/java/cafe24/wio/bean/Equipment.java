package cafe24.wio.bean;

public class Equipment {

	public String eqCode;
	public String eqCategory;
	public String eqName;
	public String eqModelName;
	public String eqWriter;
	public String eqReg_date;
	public String eqRemark;
	public String getEqCode() {
		return eqCode;
	}
	public void setEqCode(String eqCode) {
		this.eqCode = eqCode;
	}
	public String getEqCategory() {
		return eqCategory;
	}
	public void setEqCategory(String eqCategory) {
		this.eqCategory = eqCategory;
	}
	public String getEqName() {
		return eqName;
	}
	public void setEqName(String eqName) {
		this.eqName = eqName;
	}
	public String getEqModelName() {
		return eqModelName;
	}
	public void setEqModelName(String eqModelName) {
		this.eqModelName = eqModelName;
	}
	public String getEqWriter() {
		return eqWriter;
	}
	public void setEqWriter(String eqWriter) {
		this.eqWriter = eqWriter;
	}
	public String getEqReg_date() {
		return eqReg_date;
	}
	public void setEqReg_date(String eqReg_date) {
		this.eqReg_date = eqReg_date;
	}
	public String getEqRemark() {
		return eqRemark;
	}
	public void setEqRemark(String eqRemark) {
		this.eqRemark = eqRemark;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Equipment [eqCode=");
		builder.append(eqCode);
		builder.append(", eqCategory=");
		builder.append(eqCategory);
		builder.append(", eqName=");
		builder.append(eqName);
		builder.append(", eqModelName=");
		builder.append(eqModelName);
		builder.append(", eqWriter=");
		builder.append(eqWriter);
		builder.append(", eqReg_date=");
		builder.append(eqReg_date);
		builder.append(", eqRemark=");
		builder.append(eqRemark);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
