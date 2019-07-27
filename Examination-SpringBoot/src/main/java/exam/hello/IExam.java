package exam.hello;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IExam extends JpaRepository<examtable, Integer> {
	@Query("from examtable where Subject_Id=?1 ")
	List<examtable> findBySubject_Id(int mn);

}
