package cafe24.wio.bean;

public class InsuranceYear {
	
	private int iyCode;							//시행년도
	private float iyResidentIncomeTax; 			//주민소득세
	private float iyEmploymentInsurance; 		//고용보험세율
	private float iyNationalPension; 			//국민연금세율
	private float iyHealthInsurance; 			//건강보험세율
	private float iyLongtermNursingInsurance;	//장기요양보험세율
	private float iyTheBusiness; 				//사업소득세율(원천징수)
	private String iyWriter;					//작성자
	private String iyRegDate; 					//작성일시	
	
	public int getIyCode() {
		return iyCode;
	}
	public void setIyCode(int iyCode) {
		this.iyCode = iyCode;
	}
	public float getIyResidentIncomeTax() {
		return iyResidentIncomeTax;
	}
	public void setIyResidentIncomeTax(float iyResidentIncomeTax) {
		this.iyResidentIncomeTax = iyResidentIncomeTax;
	}
	public float getIyEmploymentInsurance() {
		return iyEmploymentInsurance;
	}
	public void setIyEmploymentInsurance(float iyEmploymentInsurance) {
		this.iyEmploymentInsurance = iyEmploymentInsurance;
	}
	public float getIyNationalPension() {
		return iyNationalPension;
	}
	public void setIyNationalPension(float iyNationalPension) {
		this.iyNationalPension = iyNationalPension;
	}
	public float getIyHealthInsurance() {
		return iyHealthInsurance;
	}
	public void setIyHealthInsurance(float iyHealthInsurance) {
		this.iyHealthInsurance = iyHealthInsurance;
	}
	public float getIyLongtermNursingInsurance() {
		return iyLongtermNursingInsurance;
	}
	public void setIyLongtermNursingInsurance(float iyLongtermNursingInsurance) {
		this.iyLongtermNursingInsurance = iyLongtermNursingInsurance;
	}
	public float getIyTheBusiness() {
		return iyTheBusiness;
	}
	public void setIyTheBusiness(float iyTheBusiness) {
		this.iyTheBusiness = iyTheBusiness;
	}
	public String getIyWriter() {
		return iyWriter;
	}
	public void setIyWriter(String iyWriter) {
		this.iyWriter = iyWriter;
	}
	public String getIyRegDate() {
		return iyRegDate;
	}
	public void setIyRegDate(String iyRegDate) {
		this.iyRegDate = iyRegDate;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InsuranceYear [iyCode=");
		builder.append(iyCode);
		builder.append(", iyResidentIncomeTax=");
		builder.append(iyResidentIncomeTax);
		builder.append(", iyEmploymentInsurance=");
		builder.append(iyEmploymentInsurance);
		builder.append(", iyNationalPension=");
		builder.append(iyNationalPension);
		builder.append(", iyHealthInsurance=");
		builder.append(iyHealthInsurance);
		builder.append(", iyLongtermNursingInsurance=");
		builder.append(iyLongtermNursingInsurance);
		builder.append(", iyTheBusiness=");
		builder.append(iyTheBusiness);
		builder.append(", iyWriter=");
		builder.append(iyWriter);
		builder.append(", iyRegDate=");
		builder.append(iyRegDate);
		builder.append("]");
		return builder.toString();
	}	
}
