package pk1;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.*;

public class ViewResult extends JFrame {

	HashMap st1 = new HashMap();
	HashMap st2 = new HashMap();
	HashMap st3 = new HashMap();
	HashMap st4 = new HashMap();
	HashMap cr = new HashMap();
	Student student1;
	String coursetypename = "", ID;
	int j;
	final String col1[] = { "Cr. Name", "Course", "GRADE" };
	String data1[][] = new String[500][3];

	JLabel enteridl = new JLabel("Enter ID:");
	JLabel entercoursel = new JLabel("Enter Course Type:");
	JLabel sname = new JLabel("Name");
	JLabel sid = new JLabel("ID");
	JTextField enteridf = new JTextField();
	JComboBox coursetype = new JComboBox();
	JButton search = new JButton("Search");
	ImageIcon okimage = new ImageIcon("ok.png");
	JButton ok = new JButton(okimage);
	JPanel avpanel = new JPanel();

	public ViewResult(HashMap st1, HashMap st2, HashMap st3,
			HashMap st4, HashMap cr) {

		this.st1 = st1;
		this.st2 = st2;
		this.st3 = st3;
		this.st4 = st4;
		this.cr = cr;
		setSize(900, 650);
		setTitle("View Results");
		setLayout(null);
		setLocation(250, 70);
		add(enteridl);
		add(enteridf);
		add(entercoursel);
		add(coursetype);
		add(search);
		add(sname);
		add(sid);
		add(ok);

		enteridl.setBounds(0, 5, 100, 30);
		enteridf.setBounds(105, 5, 110, 30);
		entercoursel.setLocation(230, 5);
		entercoursel.setSize(150, 30);
		search.setBounds(590, 5, 100, 30);
		sname.setBounds(0, 70, 200, 40);
		sid.setBounds(300, 70, 200, 40);
		ok.setBounds(800, 350, 60, 60);
		ok.addActionListener(new OkActionListener(this));
		coursetype.setBounds(400, 5, 150, 30);
		coursetype.insertItemAt("BSc in EEE", 0);
		coursetype.insertItemAt("BSc in CSE", 1);
		coursetype.insertItemAt("BBA", 2);
		coursetype.insertItemAt("MSc in CSE", 3);

		search.addActionListener(new SearchActionListener());

		final JTable table1 = new JTable(data1, col1);
	//	table1.setPreferredSize(new Dimension(900, 1000));
		table1.setPreferredScrollableViewportSize(new Dimension(880, 200));
		table1.setFillsViewportHeight(true);
		avpanel.add(new JScrollPane(table1));
		avpanel.setBounds(0, 120, 900, 200);
		add(avpanel);

		show();

	}

	class OkActionListener implements ActionListener {
		JFrame okframe;

		public OkActionListener(JFrame okframe) {
			this.okframe = okframe;
		}

		public void actionPerformed(ActionEvent evt) {
			okframe.dispose();
		}
	}

	class SearchActionListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			coursetypename = (String) coursetype.getSelectedItem();
			ID = enteridf.getText();
		//	j = search();

			if (coursetypename.equals("BSc in CSE")) {
				student1 = (Student) st1.get(ID);
                 System.out.print("Hey:"+student1.name);
				sname.setText(student1.name);
				sid.setText(student1.id);
				for (int k = 0; k <= student1.i - 1; k++) {
					data1[k][0] = student1.crs[k].cid;
					data1[k][1] = student1.crs[k].cname;
					data1[k][2] = student1.crs[k].result;
				}
			} else if (coursetypename.equals("MSc in CSE")) {
				student1 = (Student) st2.get(ID);
				sname.setText(student1.name);
				sid.setText(student1.id);
				for (int k = 0; k <= student1.i - 1; k++) {
					data1[k][0] = student1.crs[k].cid;
					data1[k][1] = student1.crs[k].cname;
					data1[k][2] = student1.crs[k].result;
				}
			} else if (coursetypename.equals("BBA")) {
				student1 = (Student) st3.get(ID);
				sname.setText(student1.name);
				sid.setText(student1.id);
				for (int k = 0; k <= student1.i - 1; k++) {
					data1[k][0] = student1.crs[k].cid;
					data1[k][1] = student1.crs[k].cname;
					data1[k][2] = student1.crs[k].result;
				}
			} else if (coursetypename.equals("EEE")) {
				student1 = (Student) st1.get(ID);
				sname.setText(student1.name);
				sid.setText(student1.id);
				for (int k = 0; k <= student1.i - 1; k++) {
					data1[k][0] = student1.crs[k].cid;
					data1[k][1] = student1.crs[k].cname;
					data1[k][2] = student1.crs[k].result;
				}
			}

			avpanel.repaint();

		}
	}

	
}
