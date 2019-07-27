package exam.hello;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class B {
	
	private C obj1;				// create reference of registration interface
	private Isubject Isb;		// create reference of Isubject interface
	private IExam exm;			// create reference of Isubject interface
	private Iresult res;		// create reference of Iresult Interface
	private Iadmintable ad;
	private IQuestion qu; 
	
	@Autowired
	public void setQu(IQuestion qu) {
		this.qu = qu;
	}

	@Autowired
	public void setAd(Iadmintable ad) {
		this.ad = ad;
	}

	@Autowired
	public void setExm(IExam exm) {
		System.out.println("Exam wired to service ");
		this.exm = exm;
	}

	@Autowired
	public void setObj1(C obj1) {
		System.out.println("Rgistration wired to service ");
		this.obj1 = obj1;
	}
	
	@Autowired
	public void setIsb(Isubject isb) //  registering subject services
	{
		System.out.println("Subject Is registered");
		this.Isb = isb;
	}
	
	
	@Autowired
	public void setRes(Iresult res) {
		this.res = res;
		System.out.println("Result service is registered");
	}
	

	public B()
	{
		
		System.out.println("basics are never out of fashion");
	}
	
	/*  ///////////////   Working For Registration Table  /////////////////////////////////  */
	
	

	

	//single select scenario
	public registration singleStd(int mn) {
		// note obj1 here is a repository object
		
		Optional<registration> x = obj1.findById(mn);
		registration y =null;
		if(x.isPresent())
		{
			 y = x.get();  //get the mobile object
			
		}
		else
		{
			System.out.println("do right things");	
		}
		//logic is mobile object iemi no is zero then mobile no is not found.
		return y;		
	}

	public registration update(registration n) {
		
		// TODO Auto-generated method stub
		obj1.save(n); //change of failing is almost zero.
		System.out.println("update done");
		return n;
	}

	public String Del(int mn) {
		// note obj1 here is a repository object
		Optional<registration> x = obj1.findById(mn);
		 
		String y ="";
		if(x.isPresent())
		{	
			obj1.deleteById(mn);
			y="delete done";  //get the mobile object
			
		}
		else
		{
			y="dont";	
		}
		//logic is mobile object iemi no is zero then mobile no is not found.
		return y;
	
	}

	public List<registration> getAll() {
		// TODO Auto-generated method stub
		return obj1.findAll();
	}

	
	public registration login(String email , String pass){
		Optional<registration> x = obj1.findByLogin(email, pass);
		registration y;
		if(x.isPresent())
		{
			 y = x.get();  
			
		}
		else
		{
			y =new registration(0,"0","-","-","-","-","-","-");	
		}
		
		return y;
	}
	
	/*  /////////////////////  Working for Subject Tables ////////////////////////////////////////// */
	
	
	public subjecttable singleSub(int mn) 
	{	
		
		Optional<subjecttable> x= Isb.findById(mn);
		subjecttable data=null;
		
		if(x.isPresent()) 
		{
			data= x.get();
		}
		else
		{
			System.out.println("data not found");
		}
		return data;
	}
	
	public String subUpd(subjecttable up) 
	{
		Isb.save(up);
		return "Save Successful";
		
	}
	
	public List<subjecttable> SubAll() {
		// TODO Auto-generated method stub
		return Isb.findAll();
	}
	public String subDel(int mn) 
	{
		Optional<subjecttable> x= Isb.findById(mn);
		String y="";
		if(x.isPresent()) 
		{
			Isb.deleteById(mn);
			 y="Element Deleted successfuly";
		}
		else
		{
			y="Something went Wrong";
		}
		return y;
	}

	
	/*----------------------------------  FOR EXAM TABLE ------------------------------*/
	
	
	public examtable byId(int mn) 
	{
		Optional<examtable> x =exm.findById(mn);
		examtable y=null;
		if(x.isPresent())
		{
			y=x.get();
		}
		else
		{
			System.out.println("Not Found");
		}
		return y;
	}
	
	public List<examtable> bySub(int mn)
	{
		return exm.findBySubject_Id(mn);
		
		}
	
	/*-----------------------------------Result---------------------------------*/
	
	
	public List<Result> byUser(int i)
	{
		
		return res.findByUser(i);
				
	}
	
/*------------------------------------------Admin-------------------------------------*/
	
	public List<Admintable> AdLogin(int id, String pass){
		return ad.findByadLogin(id, pass);
		
	}

	/*------------------------------------------Questions-------------------------------------*/
	
	public Set<questiontable> getSubjectsQuestion(int j) {
		
		return qu.questionBySubject_Id(j);
	}
	/*..................................forget password.....................................*/
	
	public HashMap getPassword(String email) {
		HashMap hp=new HashMap();
		
		String ret="Email Id is not registered";
		String pass=obj1.findPassword( email);
		
		System.out.println("check password"+pass+email);
		if(pass!=null) {
			
		ret= SendMail.call(email,pass);
		}
		hp.put("fpresult", ret);
		return hp;
}
	/*..................................Store result.....................................*/
	public HashMap storeResult(String course, int percentage, String result, int userId, int wrongAns, String date) {
		HashMap hp=new HashMap();
		String ret="false";
		System.out.println("function store result 2"+ret);
		int i=res.insertResult(wrongAns,userId,percentage,result,course,date);
		System.out.println("function store result 3"+ret);
		if(i>0) {
			ret="true";
			System.out.println("function store result 4"+ret);
		}
		return (HashMap) hp.put("resultresponse", ret);
	}


}








