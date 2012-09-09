package pk1;
import javax.swing.*;

public class ViewStatus extends JFrame{
	IDClass rollindex = new IDClass();
	JLabel sets= new JLabel("Student Enroll in this semester:");
	JLabel eic=new JLabel("Enrolled in BSc in CSE");
	JLabel eimscs= new JLabel("Enrolled in MSc in CSE");
	JLabel eieee= new JLabel("Enrolled in EEE");
	JLabel eibba= new JLabel("Enrolled in BBA");
	JLabel tnos= new JLabel("Total no of Student");
	JLabel tnocs= new JLabel("CSE");
	JLabel tnomscs= new JLabel("MSCSE");
	JLabel tnoeee= new JLabel("EEE");
	JLabel tnobba = new JLabel("BBA");
	JLabel setsl=new JLabel("");
	JLabel eicl = new JLabel("");
	JLabel eimscsl = new JLabel("");
	JLabel eieeel = new JLabel("");
	JLabel eibbal = new JLabel("");
	JLabel tnosl = new JLabel("");
	JLabel tnocsl = new JLabel("");
	JLabel tnoeeel = new JLabel("");
	JLabel tnobbal = new JLabel("");
	JButton ok = new JButton("OK");
	
	public ViewStatus(int width, int height, int x, int y,IDClass rollindex){
		this.rollindex=rollindex;
		setSize(width, height);
		setLayout(null);
        setLocation(250,90);
        setTitle("View Status");
        
        add(sets);
    	add(eic);
        add(eimscs);
    	add(eieee);
    	add(eibba);
    	add(tnos);
    	add(tnocs);
    	add(tnomscs);
    	add(tnoeee);
    	add(tnobba);
        add(setsl);
    	add(eicl);
    	add(eimscsl);
    	add(eieeel);
    	add(eibbal);
    	add(tnosl);
    	add( tnocsl);
    	add(tnoeeel);
    	add(tnobbal);
    	add(ok);
    	sets.setBounds(0, 5,250, 20);
    	eic.setBounds(0,35,250,20);
    	eimscs.setBounds(0,60,250,20);
    	eieee.setBounds(0,85,250,20);
    	eibba.setBounds(0,110,250,20);
    	setsl.setBounds(270, 5, 30, 20);
    	setsl.setText(Integer.toString(rollindex.csid+rollindex.eeeid+rollindex.mscsid+rollindex.bbaid));
    	eicl.setBounds(270,35,30,20);
    	eimscsl.setBounds(270, 60, 30, 20);
    	eieeel.setBounds(270,85,30,20);
    	eibbal.setBounds(270,110,30,20);
    	eicl.setText(Integer.toString(rollindex.csid));
    	eimscsl.setText(Integer.toString(rollindex.mscsid));
    	eieeel.setText(Integer.toString(rollindex.eeeid));
    	eibbal.setText(Integer.toString(rollindex.bbaid));
    	show();
	}
	
	
	

}
