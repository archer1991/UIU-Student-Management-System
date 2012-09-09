package pk1;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import pk1.AddStudentEditor.CancelActionListener;

public class EditStudent extends JFrame {

	HashMap st1 = new HashMap();
	HashMap st2 = new HashMap();
	HashMap st3 = new HashMap();
	HashMap st4 = new HashMap();
	HashMap cr = new HashMap();
	Student student1;

	final String col1[] = { "Name", "Course", "Credits" };
	String data1[][] = new String[500][3];

	final String col2[] = { "Name", "Course", "Credits" };
	String data2[][] = new String[500][3];

	int cellno, cellno2;
	int j;
	JLabel enteridl = new JLabel("Enter ID:");
	JLabel entercoursel = new JLabel("Enter Course Type:");
	JLabel sname = new JLabel("Name");
	JLabel sid = new JLabel("Name");
	JLabel crof = new JLabel("Course Offered");
	JLabel crocom = new JLabel("Course Completed and Taken");
	JTextField enteridf = new JTextField();
	JComboBox coursetype = new JComboBox();
	JButton search = new JButton("Search");
	JButton add = new JButton("ADD");
	JButton editst = new JButton("Edit Student info");
	JButton addResult = new JButton("Add Result");
	JButton drop = new JButton("Drop Course");
	JButton cancel = new JButton("Cancel");
	JLabel availcourse = new JLabel("Available Courses");
	JLabel takencourse = new JLabel("Taken Courses");
	JPanel avpanel = new JPanel();
	JPanel tkpanel = new JPanel();
	String coursetypename;
	String ID;

	public EditStudent(HashMap st1, HashMap st2, HashMap st3, HashMap st4,
			HashMap cr) {

		this.st1 = st1;
		this.st2 = st2;
		this.st3 = st3;
		this.st4 = st4;
		this.cr = cr;
		setSize(900, 650);
		setTitle("Edit Student's Informations");
		setLayout(null);
		setLocation(250, 70);
		add(enteridl);
		add(enteridf);
		add(entercoursel);
		add(coursetype);
		add(search);
		add(sname);
		add(sid);
		add(add);
		add(drop);
		add(addResult);
		add(cancel);
		add(editst);
		add(crocom);
		add(crof);

		enteridl.setBounds(0, 5, 100, 30);
		enteridf.setBounds(105, 5, 110, 30);
		entercoursel.setLocation(230, 5);
		entercoursel.setSize(150, 30);
		search.setBounds(590, 5, 100, 30);
		cancel.setBounds(710, 5, 100, 30);
		cancel.addActionListener(new CancelActionListener(this));
		search.addActionListener(new SearchActionListener());
		// avpanel.setBounds(0, 70, 900, 200);
		// tkpanel.setBounds(0,290,900,200);

		coursetype.setBounds(400, 5, 150, 30);
		coursetype.insertItemAt("BSc in EEE", 0);
		coursetype.insertItemAt("BSc in CSE", 1);
		coursetype.insertItemAt("BBA", 2);
		coursetype.insertItemAt("MSc in CSE", 3);

		final JTable table1 = new JTable(data1, col1);
		// table1.setPreferredSize(new Dimension(900, 1000));
		// tablecontainer.add(table);
		// add(tablecontainer);
		table1.setPreferredScrollableViewportSize(new Dimension(880, 200));
		table1.setFillsViewportHeight(true);
		avpanel.add(new JScrollPane(table1));
		/*
		 * table1.setPreferredScrollableViewportSize(new Dimension(880, 200));
		 * table1.setFillsViewportHeight(true);
		 */
		avpanel.setBounds(0, 120, 900, 200);
		add(avpanel);

		crof.setBounds(0,90,200,30);
		add.setBounds(790, 330, 100, 30);
		add.addActionListener(new AddActionListener());
		sname.setBounds(0, 80, 200, 20);
		sid.setBounds(220, 80, 200, 20);
		table1.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {
						cellno = table1.getSelectedRow();
					}
				});

		final JTable table2 = new JTable(data2, col2);
		// table2.setPreferredSize(new Dimension(900, 1000));
		// tablecontainer.add(table);
		// add(tablecontainer);
		// table2.setPreferredScrollableViewportSize(new Dimension(890, 1000));
		table2.setFillsViewportHeight(true);
		tkpanel.add(new JScrollPane(table2));
		table2.setPreferredScrollableViewportSize(new Dimension(880, 200));
		table2.setFillsViewportHeight(true);
		tkpanel.setBounds(0, 370, 900, 200);
		add(tkpanel);
		crocom.setBounds(0,340,250,30);
		addResult.setBounds(570, 580, 150, 50);
		editst.setBounds(410, 580, 150, 50);
		editst.addActionListener(new EditActionListener());
		drop.setBounds(740, 580, 150, 50);

		addResult.setVisible(false);
		drop.setVisible(false);
		editst.setVisible(false);

		table2.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {
						cellno2 = table2.getSelectedRow();
						System.out.print(cellno2);
						addResult.setVisible(true);
						drop.setVisible(true);
					}
				});

		addResult.addActionListener(new AddresActionListener());
		drop.addActionListener(new DropActionListener());

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

	class EditActionListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			IDClass rollindex = new IDClass();
			AddStudentEditor stduin = new AddStudentEditor("Edit Student", 600,
					500, st1, st2, st3, st4, rollindex);
			if (coursetypename.equals("BSc in CSE"))
				stduin.reedit(st1, st2, st3, st4, ID, coursetypename);
			if (coursetypename.equals("MSc in CSE"))
				stduin.reedit(st1, st2, st3, st4, ID, coursetypename);
			if (coursetypename.equals("BSc in EEE"))
				stduin.reedit(st1, st2, st3, st4, ID, coursetypename);
			if (coursetypename.equals("BBA"))
				stduin.reedit(st1, st2, st3, st4, ID, coursetypename);
		}

	}

	class AddActionListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {

			student1.addCourse(data1[cellno][1], data1[cellno][0],
					data1[cellno][2], "N/A");
			student1.currentsemester = StaticGlobal.currentSem;
			student1.currentyear = StaticGlobal.y;
			for (int k = 0; k < student1.i; k++) {
				data2[k][0] = student1.crs[k].cid;
				data2[k][1] = student1.crs[k].cname;
				data2[k][2] = student1.crs[k].credits;
			}

			if (coursetypename.equals("BSc in CSE")) {
				st1.put(ID, student1);

			} else if (coursetypename.equals("MSc in CSE")) {
				st2.put(ID, student1);

			} else if (coursetypename.equals("BBA")) {
				st4.put(ID, student1);
			} else if (coursetypename.equals("EEE")) {
				st4.put(ID, student1);
			}
			tkpanel.validate();
			tkpanel.repaint();
		}

	}

	class SearchActionListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			editst.setVisible(true);
			coursetypename = (String) coursetype.getSelectedItem();
			ID = enteridf.getText();

			// j = search();
			if (coursetypename.equals("BSc in CSE")) {

				student1 = (Student) st1.get(ID);
				sid.setText(student1.id);
				sname.setText(student1.name);
			} else if (coursetypename.equals("MSc in CSE")) {
				student1 = (Student) st2.get(ID);
				sid.setText(student1.id);
				sname.setText(student1.name);
			} else if (coursetypename.equals("BBA")) {
				student1 = (Student) st4.get(ID);
				sid.setText(student1.id);
				sname.setText(student1.name);
			} else if (coursetypename.equals("EEE")) {
				student1 = (Student) st3.get(ID);
				sid.setText(student1.id);
				sname.setText(student1.name);
			}

			int indexofdata = 0;
			Set set = cr.entrySet();
			Iterator i = set.iterator();
			while (i.hasNext()) {
				Map.Entry me = (Map.Entry) i.next();
				CourseList crdem = (CourseList) me.getValue();
				if (coursetypename.equals("BSc in CSE")
						|| coursetypename.equals("BSc in EEE")
						|| coursetypename.equals("MSc in CSE")) {
					// System.out.println("True=\n"+cr[k].semester.equals(StaticGlobal.currentSem));
					if (crdem.semester.equals(StaticGlobal.currentSem)
							&& crdem.year == StaticGlobal.y
							&& crdem.decepline.equals("Engineering")) {
						data1[indexofdata][0] = crdem.ccode;
						data1[indexofdata][1] = crdem.cname;
						data1[indexofdata][2] = crdem.credit;
						indexofdata++;
					}
				} else {
					if (crdem.semester.equals(StaticGlobal.currentSem)
							&& crdem.year == StaticGlobal.y
							&& crdem.decepline.equals("Business")) {
						data1[indexofdata][0] = crdem.ccode;
						data1[indexofdata][1] = crdem.cname;
						data1[indexofdata][2] = crdem.credit;
						indexofdata++;
						// System.out.print(" Cname "+st1[0].crs[0].cname);
					}
				}
			}

			avpanel.repaint();

			for (int k = 0; k < student1.i; k++) {
				data2[k][0] = student1.crs[k].cid;
				data2[k][1] = student1.crs[k].cname;
				data2[k][2] = student1.crs[k].credits;
			}

			tkpanel.repaint();

		}
	}

	class AddresActionListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			AddResult addresultwin = new AddResult(cellno2, ID, coursetypename,
					st1, st2, st3, st4);

		}
	}

	class DropActionListener implements ActionListener {
		public void actionPerformed(ActionEvent evt2) {

			int index = 0;

			for (int m = 0; m <= student1.i - 1; m++) {
				if (student1.crs[m].cname.equals(data2[cellno2][1])) {
					index = m;
					break;
				}
			}

			for (int m = index; m < student1.i - 1; m++) {

				student1.crs[m].cid = student1.crs[m + 1].cid;
				student1.crs[m].cname = student1.crs[m + 1].cname;
				student1.crs[m].credits = student1.crs[m + 1].credits;
				student1.crs[m].result = student1.crs[m + 1].result;

			}
			student1.crs[student1.i - 1].cid = "";
			student1.crs[student1.i - 1].cname = "";
			student1.crs[student1.i - 1].credits = "";
			student1.crs[student1.i - 1].result = "";

			student1.i = student1.i - 1;

			for (int m = 0; m < 500; m++) {

				data2[m][0] = null;
				data2[m][1] = null;
				data2[m][2] = null;
			}

			for (int m = 0; m <= student1.i - 1; m++) {
				data2[m][0] = student1.crs[m].cid;
				data2[m][1] = student1.crs[m].cname;
				data2[m][2] = student1.crs[m].credits;
			}

			tkpanel.repaint();
			if (coursetypename.equals("BSc in CSE")) {
				st1.put(ID, student1);
			}
			if (coursetypename.equals("MSc in CSE")) {
				st2.put(ID, student1);
			}
			if (coursetypename.equals("BSc in EEE")) {
				st3.put(ID, student1);
			}
			if (coursetypename.equals("BBA")) {
				st4.put(ID, student1);
			}
		}
	}

}