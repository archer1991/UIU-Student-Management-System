package pk1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.*;

public class AddResult extends JFrame {
	HashMap st1 = new HashMap();
	HashMap st2 = new HashMap();
	HashMap st3 = new HashMap();
	HashMap st4 = new HashMap();
	HashMap cr = new HashMap();
	Student student1;
	String coursetype;
	String ID;
	int cellno2;
	int studentin;
	JLabel selectGrade = new JLabel("Select Grade");
	JComboBox grades = new JComboBox();
	JButton add = new JButton("Add");

	public AddResult(int cellno2, String ID, String coursetype, HashMap st1,
			HashMap st2, HashMap st3, HashMap st4) {
		setSize(400, 200);
		setLayout(null);
		setLocation(500, 200);
		this.coursetype = coursetype;
		this.st1 = st1;
		this.st2 = st2;
		this.st3 = st3;
		this.st4 = st4;
		this.cellno2 = cellno2;
		this.ID = ID;
		add(selectGrade);
		selectGrade.setBounds(0, 50, 100, 50);
		add(grades);
		grades.setBounds(120, 50, 100, 40);
		grades.insertItemAt("A", 0);
		grades.insertItemAt("A-", 1);
		grades.insertItemAt("B+", 2);
		grades.insertItemAt("B", 3);
		grades.insertItemAt("B-", 4);
		grades.insertItemAt("C+", 5);
		grades.insertItemAt("C", 6);
		grades.insertItemAt("D+", 7);
		grades.insertItemAt("D", 8);
		grades.insertItemAt("F", 9);
		add(add);
		add.setBounds(250, 50, 100, 40);
		add.addActionListener(new AddActionListener(this));
		show();

	}

	class AddActionListener implements ActionListener {
		JFrame close;

		public AddActionListener(JFrame close) {
			this.close = close;
		}

		public void actionPerformed(ActionEvent evt) {
			String res = (String) grades.getSelectedItem();

			if (coursetype.equals("BSc in CSE")) {
				student1 = (Student) st1.get(ID);
				student1.crs[cellno2].result = res;
				st1.put(ID, student1);
				// System.out.print(st1[studentin].crs[cellno2].cname+"  \n"+st1[studentin].crs[cellno2].result);
			}
			if (coursetype.equals("MSc in CSE")) {
				student1 = (Student) st2.get(ID);
				student1.crs[cellno2].result = res;
				st2.put(ID, student1);
			}
			if (coursetype.equals("BSc in EEE")) {
				student1 = (Student) st3.get(ID);
				student1.crs[cellno2].result = res;
				st3.put(ID, student1);
			}
			if (coursetype.equals("BBA")) {
				student1 = (Student) st1.get(ID);
				student1.crs[cellno2].result = res;
				st3.put(ID, student1);
			}
			close.dispose();
		}
	}
}
