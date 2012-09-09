package pk1;

import java.io.Serializable;

public class CourseList implements Serializable{
	public String cname="";
	public String ccode="";
	public String credit="";
	public String semester="";
	public int year;
	public String decepline="";
	public int indexcode;
	public CourseList(String ccode,String cname,String credit,String semester,String dec,int year,int indexcode){
		this.ccode=ccode;
		this.cname=cname;
		this.credit=credit;
		this.year=year;
		this.semester=semester;
		this.decepline=dec;
		this.indexcode=indexcode;
	}

}
