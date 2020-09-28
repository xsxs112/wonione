package cafe24.wio.bean;

public class StaffPay {
	
	private String spcCode;			//강사 급여계산번호
	private String mrId;			//아이디
	private String mrName;			//구성원 이름
	private int spcHourlyWage;		//시급
	private int spcTotalHour;		//근무시간
	private int spcBasePay;			//강사급여 기본급(시급*근무시간)
	private float spcIncentivePer;	//강사급여 인센티브%
	private int spcIncentive;		//강사급여 인센티브
	private int spcTotal;			//강사급여계산 총액
	private String spcRegDate;		//강사급여계산 작성일자
	private String spcWriter;		//강사급여계산 작성자	
	
	private String spdCode;						//강사급여공제번호
	private int iyCode;							//보험 요율 시행년도
	private int spdTheBusinessTax;				//원천징수(사업소득세)
	private int spdTotal;						//공제계총액
	private String spdRegDate;					//강사공제계산 작성일자
	private String spdWriter;					//강사공제계산 작성자
	
	private String spCode;						//강사급여지급번호
	private float pRTitle;						//급여자원테이블(title)	
	private String spDate;						//지급일자
	private int spPay;							//강사급여실지급액
	private String spRegDate;					//강사급여지급 작성일자
	private String spWriter;					//강사급여지급 작성자
	
	private String pmRTitle;					//결제자원테이블
	private String mrAccountNum;				//강사계좌번호
	
	private String pREct;						//급여자원테이블(비고)	
	
	
	public float getSpcIncentivePer() {
		return spcIncentivePer;
	}

	public void setSpcIncentivePer(float spcIncentivePer) {
		this.spcIncentivePer = spcIncentivePer;
	}

	public String getSpcCode() {
		return spcCode;
	}

	public void setSpcCode(String spcCode) {
		this.spcCode = spcCode;
	}

	public String getMrId() {
		return mrId;
	}

	public void setMrId(String mrId) {
		this.mrId = mrId;
	}

	public String getMrName() {
		return mrName;
	}

	public void setMrName(String mrName) {
		this.mrName = mrName;
	}

	public int getSpcHourlyWage() {
		return spcHourlyWage;
	}

	public void setSpcHourlyWage(int spcHourlyWage) {
		this.spcHourlyWage = spcHourlyWage;
	}

	public int getSpcTotalHour() {
		return spcTotalHour;
	}

	public void setSpcTotalHour(int spcTotalHour) {
		this.spcTotalHour = spcTotalHour;
	}

	public int getSpcBasePay() {
		return spcBasePay;
	}

	public void setSpcBasePay(int spcBasePay) {
		this.spcBasePay = spcBasePay;
	}

	public int getSpcIncentive() {
		return spcIncentive;
	}

	public void setSpcIncentive(int spcIncentive) {
		this.spcIncentive = spcIncentive;
	}

	public int getSpcTotal() {
		return spcTotal;
	}

	public void setSpcTotal(int spcTotal) {
		this.spcTotal = spcTotal;
	}

	public String getSpcRegDate() {
		return spcRegDate;
	}

	public void setSpcRegDate(String spcRegDate) {
		this.spcRegDate = spcRegDate;
	}

	public String getSpcWriter() {
		return spcWriter;
	}

	public void setSpcWriter(String spcWriter) {
		this.spcWriter = spcWriter;
	}

	public String getSpdCode() {
		return spdCode;
	}

	public void setSpdCode(String spdCode) {
		this.spdCode = spdCode;
	}

	public int getIyCode() {
		return iyCode;
	}

	public void setIyCode(int iyCode) {
		this.iyCode = iyCode;
	}

	public int getSpdTheBusinessTax() {
		return spdTheBusinessTax;
	}

	public void setSpdTheBusinessTax(int spdTheBusinessTax) {
		this.spdTheBusinessTax = spdTheBusinessTax;
	}

	public int getSpdTotal() {
		return spdTotal;
	}

	public void setSpdTotal(int spdTotal) {
		this.spdTotal = spdTotal;
	}

	public String getSpdRegDate() {
		return spdRegDate;
	}

	public void setSpdRegDate(String spdRegDate) {
		this.spdRegDate = spdRegDate;
	}

	public String getSpdWriter() {
		return spdWriter;
	}

	public void setSpdWriter(String spdWriter) {
		this.spdWriter = spdWriter;
	}

	public String getSpCode() {
		return spCode;
	}

	public void setSpCode(String spCode) {
		this.spCode = spCode;
	}

	public float getpRTitle() {
		return pRTitle;
	}

	public void setpRTitle(float pRTitle) {
		this.pRTitle = pRTitle;
	}

	public String getSpDate() {
		return spDate;
	}

	public void setSpDate(String spDate) {
		this.spDate = spDate;
	}

	public int getSpPay() {
		return spPay;
	}

	public void setSpPay(int spPay) {
		this.spPay = spPay;
	}

	public String getSpRegDate() {
		return spRegDate;
	}

	public void setSpRegDate(String spRegDate) {
		this.spRegDate = spRegDate;
	}

	public String getSpWriter() {
		return spWriter;
	}

	public void setSpWriter(String spWriter) {
		this.spWriter = spWriter;
	}

	public String getPmRTitle() {
		return pmRTitle;
	}

	public void setPmRTitle(String pmRTitle) {
		this.pmRTitle = pmRTitle;
	}

	public String getMrAccountNum() {
		return mrAccountNum;
	}

	public void setMrAccountNum(String mrAccountNum) {
		this.mrAccountNum = mrAccountNum;
	}

	public String getpREct() {
		return pREct;
	}

	public void setpREct(String pREct) {
		this.pREct = pREct;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("=====강사급여계 시작=====");
		builder.append("StaffPay [spcCode=");
		builder.append(spcCode);
		builder.append(", mrId=");
		builder.append(mrId);
		builder.append(", mrName=");
		builder.append(mrName);
		builder.append(", spcHourlyWage=");
		builder.append(spcHourlyWage);
		builder.append(", spcTotalHour=");
		builder.append(spcTotalHour);
		builder.append(", spcBasePay=");
		builder.append(spcBasePay);
		builder.append(", spcIncentive=");
		builder.append(spcIncentive);
		builder.append(", spcTotal=");
		builder.append(spcTotal);
		builder.append(", spcRegDate=");
		builder.append(spcRegDate);
		builder.append(", spcWriter=");
		builder.append(spcWriter);
		builder.append(", spdCode=");
		builder.append("=====강사급여계 끝=====");
		
		builder.append("=====강사공제계 시작=====");
		builder.append(spdCode);
		builder.append(", iyCode=");
		builder.append(iyCode);
		builder.append(", spdTheBusinessTax=");
		builder.append(spdTheBusinessTax);
		builder.append(", spdTotal=");
		builder.append(spdTotal);
		builder.append(", spdRegDate=");
		builder.append(spdRegDate);
		builder.append(", spdWriter=");
		builder.append(spdWriter);
		builder.append("=====강사공제계 끝=====");
		
		builder.append("=====강사지급계 시작=====");
		builder.append(", spCode=");
		builder.append(spCode);
		builder.append(", pRTitle=");
		builder.append(pRTitle);
		builder.append(", spDate=");
		builder.append(spDate);
		builder.append(", spPay=");
		builder.append(spPay);
		builder.append(", spRegDate=");
		builder.append(spRegDate);
		builder.append(", spWriter=");
		builder.append(spWriter);
		builder.append("=====강사지급끝 시작=====");
		
		builder.append(", pmRTitle=");
		builder.append(pmRTitle);
		builder.append(", mrAccountNum=");
		builder.append(mrAccountNum);
		builder.append(", pREct=");
		builder.append(pREct);
		builder.append("]");
		return builder.toString();
	}
		
}
