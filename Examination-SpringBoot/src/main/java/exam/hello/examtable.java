package exam.hello;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class examtable {
	@Id
	private int ExamId;
	private int TotalQuestion,TotalMarks,Subject_Id;
	private String Description;
	public examtable() {
		
	}
	public examtable(int examId, int totalQuestion, int totalMarks, int subject_Id, String description) {
		super();
		ExamId = examId;
		TotalQuestion = totalQuestion;
		TotalMarks = totalMarks;
		Subject_Id = subject_Id;
		Description = description;
	}
	public int getExamId() {
		return ExamId;
	}
	public void setExamId(int examId) {
		ExamId = examId;
	}
	public int getTotalQuestion() {
		return TotalQuestion;
	}
	public void setTotalQuestion(int totalQuestion) {
		TotalQuestion = totalQuestion;
	}
	public int getTotalMarks() {
		return TotalMarks;
	}
	public void setTotalMarks(int totalMarks) {
		TotalMarks = totalMarks;
	}
	public int getSubject_Id() {
		return Subject_Id;
	}
	public void setSubject_Id(int subject_Id) {
		Subject_Id = subject_Id;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	@Override
	public String toString() {
		return "result [ExamId=" + ExamId + ", TotalQuestion=" + TotalQuestion + ", TotalMarks=" + TotalMarks
				+ ", Subject_Id=" + Subject_Id + ", Description=" + Description + "]";
	}
	
	
}
