package cafe24.wio.bean;

public class PayResource {
	
	private String p_r_code; //급여관련코드
	private float p_r_title; //급여관련타이틀
	private String p_r_group_id; //급여관련그룹아이디
	private String p_r_group_name; //급여관련그룹명
	private int p_r_group_sort; //급여관련정렬
	private String p_r_ect; //급여관련비고
	public String getP_r_code() {
		return p_r_code;
	}
	public void setP_r_code(String p_r_code) {
		this.p_r_code = p_r_code;
	}
	public float getP_r_title() {
		return p_r_title;
	}
	public void setP_r_title(float p_r_title) {
		this.p_r_title = p_r_title;
	}
	public String getP_r_group_id() {
		return p_r_group_id;
	}
	public void setP_r_group_id(String p_r_group_id) {
		this.p_r_group_id = p_r_group_id;
	}
	public String getP_r_group_name() {
		return p_r_group_name;
	}
	public void setP_r_group_name(String p_r_group_name) {
		this.p_r_group_name = p_r_group_name;
	}
	public int getP_r_group_sort() {
		return p_r_group_sort;
	}
	public void setP_r_group_sort(int p_r_group_sort) {
		this.p_r_group_sort = p_r_group_sort;
	}
	public String getP_r_ect() {
		return p_r_ect;
	}
	public void setP_r_ect(String p_r_ect) {
		this.p_r_ect = p_r_ect;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PayResource [p_r_code=");
		builder.append(p_r_code);
		builder.append(", p_r_title=");
		builder.append(p_r_title);
		builder.append(", p_r_group_id=");
		builder.append(p_r_group_id);
		builder.append(", p_r_group_name=");
		builder.append(p_r_group_name);
		builder.append(", p_r_group_sort=");
		builder.append(p_r_group_sort);
		builder.append(", p_r_ect=");
		builder.append(p_r_ect);
		builder.append("]");
		return builder.toString();
	}	
}
