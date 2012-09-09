package pk1;

import javax.swing.*;

public class StudentPanel extends JFrame{
	JLabel search = new JLabel("Search");
	JLabel enterID = new JLabel("Please Enter ID");
	JTextField idfield = new JTextField();
	
	public StudentPanel(String Title,int height,int width){
		setLayout(null);
		setTitle(Title);
		setSize(height,width);
		setLocation(250,90);
		setResizable(false);
		add(search);
		add(enterID);
		add(idfield);
		search.setSize(50,30);
		search.setLocation(0,0);
		enterID.setSize(200,30);
		enterID.setLocation(0,20);
		
		show();
		
	}

}
