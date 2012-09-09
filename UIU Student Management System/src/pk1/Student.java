package pk1;

import java.io.*;

public class Student implements Serializable {
	public String name;
	public String id;
	public String presentAd;
	public String bday;
	public String father;
	public String mother;
	public String coursetype;
	public String semesterofenroll;
	public int yearoenroll;
	public int i = 0;
	public int currentyear = 0;
	public String currentsemester = "";
	Course[] crs = new Course[10];

	public Student() {

	}

	public Student(String name, String id, String semesterofenroll,
			int yearoenroll, String presentAd, String bday, String father,
			String mother, String coursetype) {
		this.name = name;
		this.coursetype = coursetype;
		this.father = father;
		this.mother = mother;
		this.bday = bday;
		this.id = id;
		this.yearoenroll = yearoenroll;
		this.semesterofenroll = semesterofenroll;
	}

	public void addCourse(String cname, String cid, String credits,
			String result) {
		crs[i] = new Course(cname, cid, credits, result);
		i++;
	}

}
