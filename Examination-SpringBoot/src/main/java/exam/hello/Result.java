package exam.hello;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Result {
	
	@Id
	private int result_Id;
	private int wrongAns, userId,percentage;
	private String result,course,date;
	
	@Override
	public String toString() {
		return "Result [result_Id=" + result_Id + ", wrongAns=" + wrongAns + ", examId=" + ", userId=" + userId
				+ ", percentage=" + percentage + ", result=" + result + ", course=" + course + ", date=" + date + "]";
	}

	public Result(int result_Id, int wrongAns, int userId, int percentage, String result, String course,
			String date) {
		super();
		this.result_Id = result_Id;
		this.wrongAns = wrongAns;
		
		this.userId = userId;
		this.percentage = percentage;
		this.result = result;
		this.course = course;
		this.date = date;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	public Result() {
		
	}

	public int getResult_Id() {
		return result_Id;
	}
	public void setResult_Id(int resultId) {
		this.result_Id = resultId;
	}
	public int getWrongAns() {
		return wrongAns;
	}
	public void setWrongAns(int wrongAns) {
		this.wrongAns = wrongAns;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
	
	
	
	
}
