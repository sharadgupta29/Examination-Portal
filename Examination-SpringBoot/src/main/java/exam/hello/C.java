package exam.hello;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface C extends JpaRepository<registration, Integer> {
	//@Query(value="select * from registration where Email_Id=?1 and password=?2 ", nativeQuery=true)
	
	@Query("from registration where EmailId=?1 and Password=?2 ")
	Optional<registration> findByLogin(String email , String pass );

	
	@Query(value="select password from registration where Email_Id=?1", nativeQuery =true )
	String findPassword(String i);
	
}
