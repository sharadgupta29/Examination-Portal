package exam.hello;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Isubject extends JpaRepository<subjecttable, Integer> {
	

}