package pk1;

import java.io.Serializable;

public class LogHistory implements Serializable{
	public String username;
	public int i=0;
	public String lastlogged;

	public LogHistory(){
		
	}
	
	public LogHistory(String username,String lastlogged){
		this.username=username;
		this.lastlogged=lastlogged;
		i++;
	}

}
