package cafe24.wio.bean;

public class OfficersPay {
	
	private String opcCode;			//직원 급여계산번호
	private String mrId;			//아이디
	private String mrName;			//구성원 이름
	private int opcHourlyWage;		//시급
	private int opcTotalHour;		//근무시간
	private int opcBasePay;			//직원급여 기본급(시급*근무시간)
	private int opcFoodExpenses;	//직원급여 식비
	private int opcTransportation;	//직원급여 교통비
	private int opcWelfare;			//직원급여 복지후생
	private int opcBonus;			//직원급여 상여금
	private int opcEct;				//직원급여 기타
	private int opcTotal;			//직원급여계산 총액
	private String opcRegDate;		//직원급여계산 작성일자
	private String opcWriter;		//직원급여계산 작성자	
	
	private String opdCode;						//직원급여공제번호
	private int iyCode;							//보험 요율 시행년도
	private int opdIncomeTax;					//소득세
	private int opdResidentIncomTax;			//주민소득세
	private int opdEmploymentInsurance;			//고용보험료
	private int opdNationalPension;				//국민연급
	private int opdHealthInsurance;				//건강보험료
	private int opdLongtermNursingInsurance;	//장기요양보험료
	private int opdTotal;						//공제계총액
	private String opdRegDate;					//직원공제계산 작성일자
	private String opdWriter;					//직원공제계산 작성자
	
	private String opCode;						//직원급여지급번호
	private float pRTitle;						//급여자원테이블(title)	
	private String opDate;						//지급일자
	private int opPay;							//직원급여여실지급액
	private String opRegDate;					//직원급여지급 작성일자
	private String opWriter;					//직원급여지급 작성자
	
	private String pMRTitle;					//결제자원테이블
	private String mrJoinDate;					//직원입사일
	private String mrAccountNum;				//직원계좌번호
	
	private String pREct;						//급여자원테이블(비고)	
	

	public String getOpcCode() {
		return opcCode;
	}
	public void setOpcCode(String opcCode) {
		this.opcCode = opcCode;
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
	public int getOpcHourlyWage() {
		return opcHourlyWage;
	}
	public void setOpcHourlyWage(int opcHourlyWage) {
		this.opcHourlyWage = opcHourlyWage;
	}
	public int getOpcTotalHour() {
		return opcTotalHour;
	}
	public void setOpcTotalHour(int opcTotalHour) {
		this.opcTotalHour = opcTotalHour;
	}
	public int getOpcBasePay() {
		return opcBasePay;
	}
	public void setOpcBasePay(int opcBasePay) {
		this.opcBasePay = opcBasePay;
	}
	public int getOpcFoodExpenses() {
		return opcFoodExpenses;
	}
	public void setOpcFoodExpenses(int opcFoodExpenses) {
		this.opcFoodExpenses = opcFoodExpenses;
	}
	public int getOpcTransportation() {
		return opcTransportation;
	}
	public void setOpcTransportation(int opcTransportation) {
		this.opcTransportation = opcTransportation;
	}
	public int getOpcWelfare() {
		return opcWelfare;
	}
	public void setOpcWelfare(int opcWelfare) {
		this.opcWelfare = opcWelfare;
	}
	public int getOpcBonus() {
		return opcBonus;
	}
	public void setOpcBonus(int opcBonus) {
		this.opcBonus = opcBonus;
	}
	public int getOpcEct() {
		return opcEct;
	}
	public void setOpcEct(int opcEct) {
		this.opcEct = opcEct;
	}
	public int getOpcTotal() {
		return opcTotal;
	}
	public void setOpcTotal(int opcTotal) {
		this.opcTotal = opcTotal;
	}
	public String getOpcRegDate() {
		return opcRegDate;
	}
	public void setOpcRegDate(String opcRegDate) {
		this.opcRegDate = opcRegDate;
	}
	public String getOpcWriter() {
		return opcWriter;
	}
	public void setOpcWriter(String opcWriter) {
		this.opcWriter = opcWriter;
	}
	public String getOpdCode() {
		return opdCode;
	}
	public void setOpdCode(String opdCode) {
		this.opdCode = opdCode;
	}
	public int getIyCode() {
		return iyCode;
	}
	public void setIyCode(int iyCode) {
		this.iyCode = iyCode;
	}
	public int getOpdIncomeTax() {
		return opdIncomeTax;
	}
	public void setOpdIncomeTax(int opdIncomeTax) {
		this.opdIncomeTax = opdIncomeTax;
	}
	public int getOpdResidentIncomTax() {
		return opdResidentIncomTax;
	}
	public void setOpdResidentIncomTax(int opdResidentIncomTax) {
		this.opdResidentIncomTax = opdResidentIncomTax;
	}
	public int getOpdEmploymentInsurance() {
		return opdEmploymentInsurance;
	}
	public void setOpdEmploymentInsurance(int opdEmploymentInsurance) {
		this.opdEmploymentInsurance = opdEmploymentInsurance;
	}
	public int getOpdNationalPension() {
		return opdNationalPension;
	}
	public void setOpdNationalPension(int opdNationalPension) {
		this.opdNationalPension = opdNationalPension;
	}
	public int getOpdHealthInsurance() {
		return opdHealthInsurance;
	}
	public void setOpdHealthInsurance(int opdHealthInsurance) {
		this.opdHealthInsurance = opdHealthInsurance;
	}
	public int getOpdLongtermNursingInsurance() {
		return opdLongtermNursingInsurance;
	}
	public void setOpdLongtermNursingInsurance(int opdLongtermNursingInsurance) {
		this.opdLongtermNursingInsurance = opdLongtermNursingInsurance;
	}
	public int getOpdTotal() {
		return opdTotal;
	}
	public void setOpdTotal(int opdTotal) {
		this.opdTotal = opdTotal;
	}
	public String getOpdRegDate() {
		return opdRegDate;
	}
	public void setOpdRegDate(String opdRegDate) {
		this.opdRegDate = opdRegDate;
	}
	public String getOpdWriter() {
		return opdWriter;
	}
	public void setOpdWriter(String opdWriter) {
		this.opdWriter = opdWriter;
	}
	public String getOpCode() {
		return opCode;
	}
	public void setOpCode(String opCode) {
		this.opCode = opCode;
	}
	public float getpRTitle() {
		return pRTitle;
	}
	public void setpRTitle(float pRTitle) {
		this.pRTitle = pRTitle;
	}
	public String getOpDate() {
		return opDate;
	}
	public void setOpDate(String opDate) {
		this.opDate = opDate;
	}
	public int getOpPay() {
		return opPay;
	}
	public void setOpPay(int opPay) {
		this.opPay = opPay;
	}
	public String getOpRegDate() {
		return opRegDate;
	}
	public void setOpRegDate(String opRegDate) {
		this.opRegDate = opRegDate;
	}
	public String getOpWriter() {
		return opWriter;
	}
	public void setOpWriter(String opWriter) {
		this.opWriter = opWriter;
	}
	public String getpMRTitle() {
		return pMRTitle;
	}
	public void setpMRTitle(String pMRTitle) {
		this.pMRTitle = pMRTitle;
	}
	public String getMrJoinDate() {
		return mrJoinDate;
	}
	public void setMrJoinDate(String mrJoinDate) {
		this.mrJoinDate = mrJoinDate;
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
		builder.append("===========급여계산테이블 start===========");
		builder.append("OfficersPay [opcCode=");
		builder.append(opcCode);
		builder.append(", mrId=");
		builder.append(mrId);
		builder.append(", mrName=");
		builder.append(mrName);
		builder.append(", opcTotalHour=");
		builder.append(opcTotalHour);
		builder.append(", opcHourlyWage=");
		builder.append(", opcBasePay=");
		builder.append(opcBasePay);
		builder.append(opcHourlyWage);
		builder.append(", opcFoodExpenses=");
		builder.append(opcFoodExpenses);
		builder.append(", opcTransportation=");
		builder.append(opcTransportation);
		builder.append(", opcWelfare=");
		builder.append(opcWelfare);
		builder.append(", opcBonus=");
		builder.append(opcBonus);
		builder.append(", opcEct=");
		builder.append(opcEct);
		builder.append(", opcTotal=");
		builder.append(opcTotal);
		builder.append(", opcRegDate=");
		builder.append(opcRegDate);
		builder.append(", opcWriter=");
		builder.append(opcWriter);
		builder.append(", opdCode=");		
		builder.append("===========급여계산테이블 end===========");
		
		builder.append("===========급여공제테이블 start===========");
		builder.append(opdCode);
		builder.append(", iyCode=");
		builder.append(iyCode);
		builder.append(", opdIncomeTax=");
		builder.append(opdIncomeTax);
		builder.append(", opdResidentIncomTax=");
		builder.append(opdResidentIncomTax);
		builder.append(", opdEmploymentInsurance=");
		builder.append(opdEmploymentInsurance);
		builder.append(", opdNationalPension=");
		builder.append(opdNationalPension);
		builder.append(", opdHealthInsurance=");
		builder.append(opdHealthInsurance);
		builder.append(", opdLongtermNursingInsurance=");
		builder.append(opdLongtermNursingInsurance);
		builder.append(", opdTotal=");
		builder.append(opdTotal);
		builder.append(", opdRegDate=");
		builder.append(opdRegDate);
		builder.append(", opdWriter=");
		builder.append(opdWriter);
		builder.append("===========급여공제테이블 end===========");
		
		builder.append("===========급여지급테이블 start===========");
		builder.append(", opCode=");
		builder.append(opCode);
		builder.append(", pRTitle=");
		builder.append(pRTitle);
		builder.append(", opDate=");
		builder.append(opDate);
		builder.append(", opPay=");
		builder.append(opPay);
		builder.append(", opRegDate=");
		builder.append(opRegDate);
		builder.append(", opWriter=");
		builder.append(opWriter);
		builder.append(", mrJoinDate=");
		builder.append(mrJoinDate);
		builder.append(", mrAccountNum=");
		builder.append(mrAccountNum);
		builder.append(", pMRTitle=");
		builder.append(pMRTitle);
		builder.append("]");
		builder.append("===========급여지급테이블 end===========");
		
		builder.append("===========자원관리비고 시작===========");
		builder.append(", pREct=");
		builder.append(pREct);
		builder.append("]");
		builder.append("===========자원관리비고 끝===========");
		return builder.toString();
	}
	
	
}
