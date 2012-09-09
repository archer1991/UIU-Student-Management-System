package pk1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Event;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;

public class AddStudentEditor extends JFrame {
	// Student data field and course data field who gets value from the
	// available options window using parameter

	HashMap st1 = new HashMap();
	HashMap st2 = new HashMap();
	HashMap st3 = new HashMap();
	HashMap st4 = new HashMap();
	HashMap cr = new HashMap();

	IDClass rollindex = new IDClass();
	public Student student1;

	public int i = 0, j = 0;
	public Student st;
	public String coursetypename, id;
	public boolean isCalled = false;
	JLabel basic = new JLabel("Enter Basic Informations");
	JTextField name = new JTextField();
	JTextField father = new JTextField();
	JTextField mother = new JTextField();
	JTextField presentadd = new JTextField();
	JTextField bday = new JTextField();
	JComboBox coursetype = new JComboBox();
	JTextField yearf = new JTextField();
	JLabel yearl = new JLabel("Year of Admission:");
	JComboBox semtext = new JComboBox();
	JLabel semesterl = new JLabel("Semester:");

	// JTextField academicinfo= new JTextField();
	// JTextField hscgpa= new JTextField();

	JLabel nameLabel = new JLabel("Student Name:");
	JLabel fatherLabel = new JLabel("Father's Name:");
	JLabel motherLabel = new JLabel("Mother's Name:");
	JLabel presentaddLabel = new JLabel("Present Address:");
	JLabel academic = new JLabel("Academic Informations:");
	JLabel enterbday = new JLabel("Enter Birthday");
	JLabel coursenameLabel = new JLabel("Select Course Type:");
	// JLabel hscgpaLabel = new JLabel("HSC GPA:");

	ImageIcon addp = new ImageIcon("edit_add.png");
	ImageIcon cancelp = new ImageIcon("cancel.png");
	JButton add = new JButton(addp);
	JButton cancel = new JButton(cancelp);

	public AddStudentEditor(String Title, int height, int width, HashMap st1,
			HashMap st2, HashMap st3, HashMap st4, IDClass rollindex) {
		setTitle(Title);
		setSize(height, width);
		setLayout(null);
		setLocation(400, 150);
		setResizable(false);
		add(name);
		add(father);
		add(mother);
		add(presentadd);
		add(academic);
		add(bday);
		add(add);
		add(coursetype);
		add(yearf);
		add(yearl);
		add(semtext);
		add(semesterl);
		add(cancel);

		// add(hscgpa);
		this.st1 = st1;
		this.st2 = st2;
		this.st3 = st3;
		this.st4 = st4;
		this.rollindex = rollindex;

		add(basic);
		add(nameLabel);
		add(fatherLabel);
		add(motherLabel);
		add(presentaddLabel);
		add(academic);
		add(enterbday);
		add(coursenameLabel);

		// add(hscgpaLabel);

		basic.setLocation(0, 0);
		basic.setSize(200, 20);
		nameLabel.setLocation(0, 30);
		nameLabel.setSize(200, 20);
		fatherLabel.setLocation(0, 60);
		fatherLabel.setSize(200, 20);
		motherLabel.setLocation(0, 90);
		motherLabel.setSize(200, 20);
		presentaddLabel.setLocation(0, 120);
		presentaddLabel.setSize(200, 20);
		enterbday.setLocation(0, 170);
		enterbday.setSize(200, 20);
		coursenameLabel.setSize(200, 20);
		coursenameLabel.setLocation(0, 210);
		// hscgpaLabel.setLocation(0,180);
		// hscgpaLabel.setSize(200,20);

		name.setLocation(210, 30);
		name.setSize(200, 25);
		father.setLocation(210, 60);
		father.setSize(200, 25);
		mother.setLocation(210, 90);
		mother.setSize(200, 25);
		presentadd.setLocation(210, 120);
		presentadd.setSize(200, 40);
		bday.setLocation(210, 170);
		bday.setSize(200, 25);
		coursetype.setSize(120, 25);
		coursetype.setLocation(210, 210);
		yearf.setBounds(210, 260, 100, 30);
		yearl.setBounds(0, 260, 150, 30);
		semtext.setBounds(210, 310, 200, 30);
		semtext.insertItemAt("Spring", 0);
		semtext.insertItemAt("Summer", 1);
		semtext.insertItemAt("Fall", 2);
		semesterl.setBounds(0, 310, 150, 30);
		coursetype.insertItemAt("BSc in EEE", 0);
		coursetype.insertItemAt("BSc in CSE", 1);
		coursetype.insertItemAt("BBA", 2);
		coursetype.insertItemAt("MSc in CSE", 3);
		coursetype.setSelectedItem(Integer.valueOf(0));
		coursetype.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coursetypename = (String) coursetype.getSelectedItem();

			}

		});

		add.setLocation(320, 430);
		add.setSize(120, 50);
		cancel.setBounds(460, 430, 120, 50);
		cancel.addActionListener(new CancelActionListener(this));
		name.setFont(new Font("Ubuntu", Font.BOLD, 14));
		father.setFont(new Font("Ubuntu", Font.BOLD, 14));
		mother.setFont(new Font("Ubuntu", Font.BOLD, 14));
		presentadd.setFont(new Font("Ubuntu", Font.BOLD, 14));
		bday.setFont(new Font("Ubuntu", Font.BOLD, 14));
		coursetype.setFont(new Font("Ubuntu", Font.BOLD, 14));
		basic.setFont(new Font("Ubuntu", Font.BOLD, 16));
		nameLabel.setFont(new Font("Ubuntu", Font.BOLD, 16));
		fatherLabel.setFont(new Font("Ubuntu", Font.BOLD, 16));
		motherLabel.setFont(new Font("Ubuntu", Font.BOLD, 16));
		presentaddLabel.setFont(new Font("Ubuntu", Font.BOLD, 16));
		academic.setFont(new Font("Ubuntu", Font.BOLD, 16));
		enterbday.setFont(new Font("Ubuntu", Font.BOLD, 16));
		coursenameLabel.setFont(new Font("Ubuntu", Font.BOLD, 16));
		semtext.setFont(new Font("Ubuntu", Font.BOLD, 16));
		yearf.setFont(new Font("Ubuntu", Font.BOLD, 16));
		semesterl.setFont(new Font("Ubuntu", Font.BOLD, 16));
		yearl.setFont(new Font("Ubuntu", Font.BOLD, 16));
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isCalled == false) {
					id = generateId(coursetypename);
					storeStudent(coursetypename, id);
				} else {
					storedited(coursetypename);
				}
				JOptionPane
						.showMessageDialog(null, "ID of the student = " + id);
				redraw();

			}
		});
		// hscgpaLabel.setFont(new Font("Ubuntu",Font.BOLD,16));
		show();
	}

	class CancelActionListener implements ActionListener {
		private JFrame toBeClose;

		public CancelActionListener(JFrame toBeClose) {
			this.toBeClose = toBeClose;
		}

		public void actionPerformed(ActionEvent e) {
			toBeClose.dispose();

		}

	}

	// generate student id not completed

	public String generateId(String coursetypename) {
		String id = "";
		String semid = "";
		if (((String) semtext.getSelectedItem()).equals("Spring"))
			semid = "1";
		if (((String) semtext.getSelectedItem()).equals("Summer"))
			semid = "2";
		if (((String) semtext.getSelectedItem()).equals("Fall"))
			semid = "3";
		if (coursetypename == "BSc in CSE") {
			id = id + "011";
			id = id + Integer.parseInt(yearf.getText()) % 100 + semid
					+ (++rollindex.csid);
		} else if (coursetypename == "BSc in EEE") {
			id = id + "021";
			id = id + Integer.parseInt(yearf.getText()) % 100 + semid
					+ (++rollindex.eeeid);
		} else if (coursetypename == "BBA") {
			id = id + "012";
			id = id + Integer.parseInt(yearf.getText()) % 100 + semid
					+ (++rollindex.bbaid);
		} else if (coursetypename == "MSc in CSE") {
			id = id + "013";
			id = id + Integer.parseInt(yearf.getText()) % 100 + semid
					+ (++rollindex.mscsid);
		}
		return id;
	}

	public void redraw() {
		name.setText("");
		father.setText("");
		mother.setText("");
		presentadd.setText("");
		bday.setText("");
		yearf.setText("");
		// coursetype.setSelectedItem(Integer.valueOf(0));

	}

	public void reedit(HashMap st1, HashMap st2, HashMap st3, HashMap st4,
			String ID, String ctype) {
		this.id = ID;
		this.st1 = st1;
		this.st2 = st2;
		this.st3 = st3;
		this.st4 = st4;
		isCalled = true;
		if (ctype.equals("BSc in CSE")) {
			student1 = (Student) st1.get(ID);
			name.setText(student1.name);
			father.setText(student1.father);
			mother.setText(student1.mother);
			presentadd.setText(student1.presentAd);
			bday.setText(student1.bday);
			semtext.setSelectedIndex(0);
			yearf.setText(Integer.toString(student1.yearoenroll));
			// coursetype.setSelectedItem("");
			id = student1.id;
		}
		if (ctype.equals("MSc in CSE")) {
			student1 = (Student) st2.get(ID);
			name.setText(student1.name);
			father.setText(student1.father);
			mother.setText(student1.mother);
			presentadd.setText(student1.presentAd);
			bday.setText(student1.bday);
			semtext.setSelectedIndex(0);
			yearf.setText(Integer.toString(student1.yearoenroll));
			// coursetype.setSelectedItem("");
			id = student1.id;
		}
		if (ctype.equals("BSc in EEE")) {
			student1 = (Student) st3.get(ID);
			name.setText(student1.name);
			father.setText(student1.father);
			mother.setText(student1.mother);
			presentadd.setText(student1.presentAd);
			bday.setText(student1.bday);
			semtext.setSelectedIndex(0);
			yearf.setText(Integer.toString(student1.yearoenroll));
			// coursetype.setSelectedItem("");
			id = student1.id;
		}
		if (ctype.equals("BBA")) {
			student1 = (Student) st4.get(ID);
			name.setText(student1.name);
			father.setText(student1.father);
			mother.setText(student1.mother);
			presentadd.setText(student1.presentAd);
			bday.setText(student1.bday);
			semtext.setSelectedIndex(0);
			yearf.setText(Integer.toString(student1.yearoenroll));
			// coursetype.setSelectedItem("");
			id = student1.id;

		}
	}

	public void storedited(String Coursetype) {
		if (Coursetype == "BSc in CSE") {
			student1.name = name.getText();
			System.out.println("" + name.getText());
			student1.father = father.getText();
			student1.mother = mother.getText();
			student1.semesterofenroll = (String) semtext.getSelectedItem();
			student1.yearoenroll = Integer.parseInt(yearf.getText());
			student1.presentAd = presentadd.getText();
			student1.bday = bday.getText();
			st1.put(student1.id, student1);

		}
		if (Coursetype == "MSc in CSE") {

			student1.name = name.getText();
			student1.father = father.getText();
			student1.mother = mother.getText();
			student1.semesterofenroll = (String) semtext.getSelectedItem();
			student1.yearoenroll = Integer.parseInt(yearf.getText());
			student1.presentAd = presentadd.getText();
			student1.bday = bday.getText();
			st2.put(student1.id, student1);
		}
		if (Coursetype == "BSc in EEE") {
			student1.name = name.getText();
			student1.father = father.getText();
			student1.mother = mother.getText();
			student1.semesterofenroll = (String) semtext.getSelectedItem();
			student1.yearoenroll = Integer.parseInt(yearf.getText());
			student1.presentAd = presentadd.getText();
			student1.bday = bday.getText();
			st3.put(student1.id, student1);
		}
		if (Coursetype == "BBA") {
			student1.name = name.getText();
			student1.father = father.getText();
			student1.mother = mother.getText();
			student1.semesterofenroll = (String) semtext.getSelectedItem();
			student1.yearoenroll = Integer.parseInt(yearf.getText());
			student1.presentAd = presentadd.getText();
			student1.bday = bday.getText();
			st4.put(student1.id, student1);
		}
	}

	// store stduent data into a file

	public void storeStudent(String Coursetype, String id) {

		if (Coursetype == "BSc in CSE") {
			try {
				if (isCalled == false)
					i = StaticGlobal.csin;
				else
					i = j;
				FileOutputStream fileout = new FileOutputStream(
						"database//CSEStudent.txt");
				ObjectOutputStream out = new ObjectOutputStream(fileout);
				if (isCalled == false) {
					student1 = new Student(name.getText(), id,
							(String) semtext.getSelectedItem(),
							Integer.parseInt(yearf.getText()),
							presentadd.getText(), bday.getText(),
							father.getText(), mother.getText(), Coursetype);
				}

				st1.put(student1.id, student1);

				out.writeObject(st1);
				if (isCalled == false)
					StaticGlobal.csin++;
				out.flush();
				fileout.close();
			} catch (IOException e) {

			}
		} else if (Coursetype == "BSc in EEE") {
			try {
				if (isCalled == false)
					i = StaticGlobal.eeein;
				else
					i = j;
				FileOutputStream fileout = new FileOutputStream(
						"database//EEEStudent.txt");
				ObjectOutputStream out = new ObjectOutputStream(fileout);
				if (isCalled == false) {
					student1 = new Student(name.getText(), id,
							(String) semtext.getSelectedItem(),
							Integer.parseInt(yearf.getText()),
							presentadd.getText(), bday.getText(),
							father.getText(), mother.getText(), Coursetype);
				}
				st3.put(student1.id, st3);
				out.writeObject(st3);
				if (isCalled == false)
					StaticGlobal.eeein++;
				out.close();
				fileout.close();
			} catch (IOException e) {

			}
		} else if (Coursetype == "MSc in CSE") {
			try {
				if (isCalled == false)
					i = StaticGlobal.mscsin;
				else
					i = j;
				FileOutputStream fileout = new FileOutputStream(
						"database//MSCSEStudent.txt");
				ObjectOutputStream out = new ObjectOutputStream(fileout);
				if (isCalled == false) {
					student1 = new Student(name.getText(), id,
							(String) semtext.getSelectedItem(),
							Integer.parseInt(yearf.getText()),
							presentadd.getText(), bday.getText(),
							father.getText(), mother.getText(), Coursetype);
				}
				st2.put(student1.id, st2);
				out.writeObject(st2);
				if (isCalled == false)
					StaticGlobal.mscsin++;
				out.close();
				fileout.close();
			} catch (IOException e) {

			}
		} else if (Coursetype == "BSc in BBA") {
			try {
				if (isCalled == false)
					i = StaticGlobal.bbain;
				else
					i = j;
				FileOutputStream fileout = new FileOutputStream(
						"database//BBAStudent.txt");
				ObjectOutputStream out = new ObjectOutputStream(fileout);
				if (isCalled == false) {
					student1 = new Student(name.getText(), id,
							(String) semtext.getSelectedItem(),
							Integer.parseInt(yearf.getText()),
							presentadd.getText(), bday.getText(),
							father.getText(), mother.getText(), Coursetype);
				}
				st4.put(student1.id, st4);
				out.writeObject(st4);
				if (isCalled == false)
					StaticGlobal.bbain++;
				out.close();
				fileout.close();
			} catch (IOException e) {

			}
		}

	}

}
