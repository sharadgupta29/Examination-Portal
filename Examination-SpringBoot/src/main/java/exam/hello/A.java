package exam.hello;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class A {
	
	private B obj1;				// reference for registration table
	private B sub;				// reference for subject table
	private B exm;				// reference for subject table
	private B res;				// reference for result
	private B adm;
	
	@Autowired
	public void setRes(B res) {
		this.res = res;
		System.out.println("result can be call now");
	}
	@Autowired
	public void setObj1(B obj1) {
		System.out.println("basics are never out of fashion ... dont get ocnfused");
		this.obj1 = obj1;
	}
	@Autowired
	public void setSub(B sub) {
		this.sub = sub;
		System.out.println("Subject Methods can be call now");
	}

	@Autowired
	public void setExm(B exm) {
		
		this.exm = exm;
		System.out.println("Exam Methods can be call now");
	}
//http:localhost:8080?x=1
	
//http://localhost:8080/pw?x=1
	
//http://localhost:8080/pw?x=10, you will get mobile no as zero
	
	
/* ---------------------FOR REGISTRATION----------------------------------*/


	
	
	@GetMapping("/del")
	public String f4(@RequestParam("x")int mn)//Delete by Id Of Student
	{
		System.out.println("function pw is getting called");
		String m =obj1.Del(mn);
		return m;
		
	}
	
		
	@GetMapping("/ms") //multiselect
	public List<registration> get()
	{
		List<registration> x =obj1.getAll();
		return x;
		
	}
	
	@GetMapping("/log") //Login
	public registration login(@RequestParam("x") String email,@RequestParam("y") String pass)
	{
		registration x =obj1.login(email, pass);
		return x;
		
	}
	
/*-------------------------------------------FOR SUBJECT TABLE--------------------------------------------------*/
	
	@GetMapping("/ssig")
	public subjecttable Subdata(@RequestParam("x")int mn ) 
	{
		System.out.println("Subject single select call ");
		subjecttable m= sub.singleSub(mn);
		
		return m;
	}
	
	@PostMapping("/Subupd")
	public String SubjUpd(@RequestBody subjecttable sp)//Update the Details Of student
	{
		String m =sub.subUpd(sp);
		return m;
		
	}
			// ---------------Subject All------------
	
	@GetMapping("/SubMs") //multiselect
	public List<subjecttable> Subget(@RequestParam ("n") String s)
	{	
		List<subjecttable> x=null;
		if(s.contains("user-") ) { 
		x =sub.SubAll();
		}
		return x;
		}
	
	
	@GetMapping("/Subdel") 
	public String subdel(int mn)
	{
		String y=sub.subDel(mn);
		return y;
	}
	
	/*-----------------------------FOR EXAM TABLE---------------------------------*/
	
	@GetMapping("/Exsig")
	public examtable Exmdata(@RequestParam("x")int mn ) 
	{
		System.out.println("Subject single select call ");
		examtable m= exm.byId(mn);
		return m;
	}
	
	@GetMapping("/ExSub")
	public List<examtable> ExmdataBySub(@RequestParam("x")int  mn ) 
	{
		System.out.println("Subject single select call ");
		List<examtable> m= exm.bySub(mn);
		return m;
	}
	
	
	/*-------------------------------------Result------------------------------------------------*/
	
	
	@GetMapping("/result")
	public List<Result> result(@RequestParam ("n") String i)//Update the Details Of student
	{	
		int j=Integer.parseInt(i.substring(5));
		System.out.println(j);
		//int i=n.getUserId();
		List<Result> m =res.byUser(j);
		return m;
		
	}
	/*---------------------------------------Admin-----------------------------------*/
	
	@GetMapping("/adlog")
	public List<Admintable> Adlogin(@RequestParam("x") int i,@RequestParam("y") String pass)
	{
		List<Admintable> z =adm.AdLogin(i, pass);
		return z;
		
	}
	/* ...........................fetch exam.....................................*/
	
	@GetMapping("/getquestion")
	public Set<questiontable> exam(@RequestParam ("u") String i,@RequestParam ("s") int j)//Update the Details Of student
	{	
		if(i.contains("user-")) {
		System.out.println(i);
		//int i=n.getUserId();
		Set<questiontable> m =res.getSubjectsQuestion(j);
		return m;
		}
		else {
			return null;
		}
	}
	
	
	/*........................Fetch Password...............................*/
	@GetMapping("/getPassword") //Login
	public HashMap login(@RequestParam("x") String email)
	{
		HashMap x =obj1.getPassword(email);
		return x;
		
	}
	
	
/* ---------------------Get Profile----------------------------------*/

	
	@GetMapping("/getProfile")
	public registration f1(@RequestParam("x")String user)//assume single select
	{	
		int j=Integer.parseInt(user.substring(5));
		System.out.println("function getProfile is getting called"+j);
		registration m =obj1.singleStd(j);
		return m;
		
	}
	
/*......................update profile..................................*/
	
	@PostMapping("/updProfile")
	public registration f2(@RequestBody registration n)//Update the Details Of student
	{
		registration m =obj1.update(n);
		return m;
		
	}
	
	/*........................Store Exam Result..............................*/
	@GetMapping("/storeResult") //Login
	public HashMap storeRes(@RequestParam("cor") String cor,@RequestParam("per") int per,@RequestParam("res") String res,@RequestParam("uid") int uid,@RequestParam("wans") int wans,@RequestParam("date") String date)
	{	
		System.out.println("function store result 1");
		HashMap x =obj1.storeResult(cor,per,res,uid,wans,date);
		System.out.println("function store result 5"+x);
		return x;
		
	}
	
	
}
