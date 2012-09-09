package pk1;

import java.io.*;

public class Course implements Serializable {
	public String cname="";
	public String cid="";
	public String result="" ;
	public String credits="";

	public Course(){
		
	}
	public Course(String cname, String cid, String credits, String result) {
		this.cname = cname;
		this.cid = cid;
		this.result = result;
		this.credits = credits;
	}

}