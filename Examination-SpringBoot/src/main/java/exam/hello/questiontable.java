package exam.hello;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class questiontable {

	@Id
	private int ques_id;
	private String question,Option1,Option2,Option3,Option4,correctoption;
	private int subject_id;
	
	
	@Override
	public String toString() {
		return "questiontable [ques_id=" + ques_id + ", question=" + question + ", Option1=" + Option1 + ", Option2="
				+ Option2 + ", Option3=" + Option3 + ", Option4=" + Option4 + ", correctoption=" + correctoption
				+ ", subject_id=" + subject_id + "]";
	}


	public questiontable(int ques_id, String question, String option1, String option2, String option3, String option4,
			String correctoption, int subject_id) {
		super();
		this.ques_id = ques_id;
		this.question = question;
		Option1 = option1;
		Option2 = option2;
		Option3 = option3;
		Option4 = option4;
		this.correctoption = correctoption;
		this.subject_id = subject_id;
	}


	public int getQues_id() {
		return ques_id;
	}


	public void setQues_id(int ques_id) {
		this.ques_id = ques_id;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public String getOption1() {
		return Option1;
	}


	public void setOption1(String option1) {
		Option1 = option1;
	}


	public String getOption2() {
		return Option2;
	}


	public void setOption2(String option2) {
		Option2 = option2;
	}


	public String getOption3() {
		return Option3;
	}


	public void setOption3(String option3) {
		Option3 = option3;
	}


	public String getOption4() {
		return Option4;
	}


	public void setOption4(String option4) {
		Option4 = option4;
	}


	public String getCorrectoption() {
		return correctoption;
	}


	public void setCorrectoption(String correctoption) {
		this.correctoption = correctoption;
	}


	public int getSubject_id() {
		return subject_id;
	}


	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}


	public questiontable() {
		// TODO Auto-generated constructor stub
	}

}
