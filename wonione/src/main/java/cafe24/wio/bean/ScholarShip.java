package cafe24.wio.bean;

public class ScholarShip {

 private String pmInfoCode; 
 private String awardBmCode; 
 private String mrId; 
 private String pmInfoPayer; 
 private String pmInfoRegDate;
 private String awardBmPrice;
 private String mrName;
 private String pmInfoPayerName;

@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("ScholarShip [pmInfoCode=");
	builder.append(pmInfoCode);
	builder.append(", awardBmCode=");
	builder.append(awardBmCode);
	builder.append(", mrId=");
	builder.append(mrId);
	builder.append(", pmInfoPayer=");
	builder.append(pmInfoPayer);
	builder.append(", pmInfoRegDate=");
	builder.append(pmInfoRegDate);
	builder.append(", awardBmPrice=");
	builder.append(awardBmPrice);
	builder.append(", mrName=");
	builder.append(mrName);
	builder.append(", pmInfoPayerName=");
	builder.append(pmInfoPayerName);
	builder.append("]");
	return builder.toString();
}
public String getPmInfoCode() {
	return pmInfoCode;
}
public void setPmInfoCode(String pmInfoCode) {
	this.pmInfoCode = pmInfoCode;
}
public String getAwardBmCode() {
	return awardBmCode;
}
public void setAwardBmCode(String awardBmCode) {
	this.awardBmCode = awardBmCode;
}
public String getMrId() {
	return mrId;
}
public void setMrId(String mrId) {
	this.mrId = mrId;
}
public String getPmInfoPayer() {
	return pmInfoPayer;
}
public void setPmInfoPayer(String pmInfoPayer) {
	this.pmInfoPayer = pmInfoPayer;
}
public String getPmInfoRegDate() {
	return pmInfoRegDate;
}
public void setPmInfoRegDate(String pmInfoRegDate) {
	this.pmInfoRegDate = pmInfoRegDate;
}
public String getAwardBmPrice() {
	return awardBmPrice;
}
public void setAwardBmPrice(String awardBmPrice) {
	this.awardBmPrice = awardBmPrice;
}
public String getMrName() {
	return mrName;
}
public void setMrName(String mrName) {
	this.mrName = mrName;
}
public String getPmInfoPayerName() {
	return pmInfoPayerName;
}
public void setPmInfoPayerName(String pmInfoPayerName) {
	this.pmInfoPayerName = pmInfoPayerName;
}
	
}
