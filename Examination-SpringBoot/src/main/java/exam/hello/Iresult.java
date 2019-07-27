package exam.hello;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface Iresult extends JpaRepository<Result, Integer> {
	@Query(value="select * from result where user_id=?1 ORDER BY result_id DESC", nativeQuery =true )
	List<Result> findByUser(int i);
	
	/*@Query("insert into Result (wrongAns,userId,percentage,result,course,date) select :wrongAns,:userId,:percentage,:result,:course,:date")
	public int insertResult(int wrongAns,int userId,int percentage,String result,String course,String date);


	@Modifying
	@Query(value="insert into result (Wrong_Ans,User_Id,percentage,Result,course,date) values(:Wrong_Ans,:User_Id,:percentage,:Result,:course,:date)",nativeQuery =true)
	public int insertResult(int Wrong_Ans,int User_Id,int percentage,String Result,String course,String date);
*/
	@Modifying
	@Transactional
	@Query(value="insert into result (Wrong_Ans,User_Id,percentage,Result,course,date) values(?1,?2,?3,?4,?5,?6)",nativeQuery =true)
	public int insertResult(int Wrong_Ans,int User_Id,int percentage,String Result,String course,String date);
}
