package exam.hello;


import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IQuestion extends JpaRepository<questiontable, Integer> {
	
	@Query("from questiontable where subject_id=?1 ")
	Set<questiontable> questionBySubject_Id(int mn);
}
