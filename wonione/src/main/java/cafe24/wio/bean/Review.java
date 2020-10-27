package cafe24.wio.bean;

public class Review {

	public String reviewNum;
	public String reviewWriterId;
	public String reviewWriterName;
	public double reviewGrade;
	public String reviewComment;
	public String reviewRegDate;
	
	public String getReviewNum() {
		return reviewNum;
	}
	public void setReviewNum(String reviewNum) {
		this.reviewNum = reviewNum;
	}
	public String getReviewWriterId() {
		return reviewWriterId;
	}
	public void setReviewWriterId(String reviewWriterId) {
		this.reviewWriterId = reviewWriterId;
	}
	public String getReviewWriterName() {
		return reviewWriterName;
	}
	public void setReviewWriterName(String reviewWriterName) {
		this.reviewWriterName = reviewWriterName;
	}
	public double getReviewGrade() {
		return reviewGrade;
	}
	public void setReviewGrade(double reviewGrade) {
		this.reviewGrade = reviewGrade;
	}
	public String getReviewComment() {
		return reviewComment;
	}
	public void setReviewComment(String reviewComment) {
		this.reviewComment = reviewComment;
	}
	public String getReviewRegDate() {
		return reviewRegDate;
	}
	public void setReviewRegDate(String reviewRegDate) {
		this.reviewRegDate = reviewRegDate;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Review [reviewNum=");
		builder.append(reviewNum);
		builder.append(", reviewWriterId=");
		builder.append(reviewWriterId);
		builder.append(", reviewWriterName=");
		builder.append(reviewWriterName);
		builder.append(", reviewGrade=");
		builder.append(reviewGrade);
		builder.append(", reviewComment=");
		builder.append(reviewComment);
		builder.append(", reviewRegDate=");
		builder.append(reviewRegDate);
		builder.append("]");
		return builder.toString();
	}
	
}