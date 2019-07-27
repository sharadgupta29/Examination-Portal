package exam.hello;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class subjecttable {
	
	@Id
	private int SubjectId;
	private String Subject,Description;
	public subjecttable() {
		
	}
	public subjecttable(int subjectId, String subject, String description) {
		super();
		SubjectId = subjectId;
		Subject = subject;
		Description = description;
	}
	public int getSubjectId() {
		return SubjectId;
	}
	public void setSubjectId(int subjectId) {
		SubjectId = subjectId;
	}
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	@Override
	public String toString() {
		return "subjecttable [SubjectId=" + SubjectId + ", Subject=" + Subject + ", Description=" + Description + "]";
	}
	
	
	
	
}
