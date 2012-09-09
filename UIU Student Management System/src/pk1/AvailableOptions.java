package pk1;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.util.HashMap;

import javax.swing.plaf.FontUIResource;

public class AvailableOptions extends JFrame {

	// Student data field and course data field who gets value from the password
	// window using parameter
	HashMap st1 = new HashMap();
	HashMap st2 = new HashMap();
	HashMap st3 = new HashMap();
	HashMap st4 = new HashMap();
	HashMap cr = new HashMap();
	HashMap admin = new HashMap();
	HashMap loghistory = new HashMap();

	IDClass rollindex = new IDClass();
	// initializing component
	ImageIcon addImage = new ImageIcon("addstud.jpg");
	ImageIcon addImage2 = new ImageIcon("buildcourse.PNG");
	ImageIcon addImage3 = new ImageIcon("editstudent.PNG");
	ImageIcon addImage4 = new ImageIcon("viewRes.jpg");
	ImageIcon mylogo = new ImageIcon("mylogo.PNG");
	ImageIcon adminset = new ImageIcon("adminset.PNG");
	ImageIcon viewstat = new ImageIcon("viewstatus.PNG");
	ImageIcon unilogo = new ImageIcon(
			"United_International_University_Logo.gif");
	ImageIcon gitlogo = new ImageIcon("github.jpeg");
	JButton addStu = new JButton(addImage);
	JButton addSub = new JButton(addImage2);
	JButton viewStudent = new JButton(addImage3);
	JButton viewResult = new JButton(addImage4);
	JButton adminsettings = new JButton(adminset);
	JButton buildcourselist = new JButton(viewstat);
	JLabel mylg = new JLabel(mylogo);
	JLabel unilg = new JLabel(unilogo);
	JLabel gitlg = new JLabel(gitlogo);
	String str = "To Download the repositories click:"
			+ " https://github.com/saimoom92/UIU-Student-Management-System.git";
	JLabel hyperlink = new JLabel(str);

	public AvailableOptions(int height, int width, int x, int y, HashMap st1,
			HashMap st2, HashMap st3, HashMap st4, HashMap cr,
			IDClass rollindex, HashMap admin, HashMap loghistory) {
		setSize(height, width);
		setLayout(null);

		// here we get the all the datas from password window using this
		// constructor

		this.st1 = st1;
		this.st2 = st2;
		this.st3 = st3;
		this.st4 = st4;
		this.cr = cr;
		this.rollindex = rollindex;
		this.admin = admin;
		this.loghistory = loghistory;

		if (StaticGlobal.y == 0 || StaticGlobal.currentSem == null) {
			JOptionPane
					.showMessageDialog(null,
							"Please First of All set Current Year and Semester From Admin Settings");
		}
		add(addStu);
		add(addSub);
		add(viewStudent);
		add(viewResult);
		add(mylg);
		add(unilg);
		add(adminsettings);
		add(buildcourselist);
		add(gitlg);
		add(hyperlink);
		mylg.setSize(50, 40);
		mylg.setLocation(10, 520);
		unilg.setSize(50, 40);
		unilg.setLocation(840, 520);
		addStu.setSize(x, y);
		addSub.setSize(x, y);
		viewStudent.setSize(x, y);
		viewResult.setSize(x, y);
		addStu.addActionListener(new AvaActionListener());
		adminsettings.addActionListener(new AvaActionListener());
		addSub.addActionListener(new AvaActionListener());
		viewStudent.addActionListener(new AvaActionListener());
		viewResult.addActionListener(new AvaActionListener());
		buildcourselist.addActionListener(new AvaActionListener());
		adminsettings.setBounds(150, 250, x, y);
		buildcourselist.setBounds(500, 250, x, y);
		gitlg.setBounds(410, 370, 75, 75);
		hyperlink.setBounds(95, 450, 900, 30);
		hyperlink.setFont(new Font("Ubuntu Light", Font.PLAIN, 16));
		show();
	}

	class AvaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			// firing add student window

			if (evt.getSource() == addStu) {
				AddStudentEditor stduin = new AddStudentEditor("Add Student",
						600, 500, st1, st2, st3, st4, rollindex);

			}
			if (evt.getSource() == addSub) {
				CourseListWindow course = new CourseListWindow(cr);
				course.show();
			}
			if (evt.getSource() == viewStudent) {
				EditStudent editstu = new EditStudent(st1, st2, st3, st4, cr);
				editstu.show();
			}
			if (evt.getSource() == adminsettings) {
				AdminSettingWindow adminwin = new AdminSettingWindow(rollindex,
						admin, loghistory);
				adminwin.show();
			}
			if (evt.getSource() == viewResult) {
				ViewResult viewstures = new ViewResult(st1, st2, st3, st4, cr);

			}
			if (evt.getSource() == buildcourselist) {
				ViewStatus viewstatus = new ViewStatus(900, 600, 100, 30,
						rollindex);
			}
		}

	}

}
