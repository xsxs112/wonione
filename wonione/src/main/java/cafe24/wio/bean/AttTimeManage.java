package cafe24.wio.bean;

public class AttTimeManage {

	String attTimeCode;
	String mrId;
	String attStTime;
	String attEndTime;
	String mealStTime;
	String mealEndTime;
	
	
	public String getAttTimeCode() {
		return attTimeCode;
	}
	public void setAttTimeCode(String attTimeCode) {
		this.attTimeCode = attTimeCode;
	}
	public String getMrId() {
		return mrId;
	}
	public void setMrId(String mrId) {
		this.mrId = mrId;
	}
	public String getAttStTime() {
		return attStTime;
	}
	public void setAttStTime(String attStTime) {
		this.attStTime = attStTime;
	}
	public String getAttEndTime() {
		return attEndTime;
	}
	public void setAttEndTime(String attEndTime) {
		this.attEndTime = attEndTime;
	}
	public String getMealStTime() {
		return mealStTime;
	}
	public void setMealStTime(String mealStTime) {
		this.mealStTime = mealStTime;
	}
	public String getMealEndTime() {
		return mealEndTime;
	}
	public void setMealEndTime(String mealEndTime) {
		this.mealEndTime = mealEndTime;
	}
	@Override
	public String toString() {
		return "AttTimeManage [attTimeCode=" + attTimeCode + ", mrId=" + mrId + ", attStTime=" + attStTime
				+ ", attEndTime=" + attEndTime + ", mealStTime=" + mealStTime + ", mealEndTime=" + mealEndTime + "]";
	}
	
	
	
	


}
