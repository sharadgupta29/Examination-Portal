package exam.hello;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Iadmintable extends JpaRepository<Admintable, Integer>{

	@Query(value="select * from admintable where id=?1 and password=?2", nativeQuery =true )
	List<Admintable> findByadLogin(int id , String pa );
}
