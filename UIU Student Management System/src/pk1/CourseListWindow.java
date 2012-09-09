package pk1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import pk1.AddStudentEditor.CancelActionListener;

public class CourseListWindow extends JFrame {
	HashMap cr = new HashMap();
	JTextField ccodef = new JTextField();
	JTextField cnamef = new JTextField();
	JTextField cdtf = new JTextField();
	JLabel ccodel = new JLabel("Enter CourseCode:");
	JLabel cnamel = new JLabel("Enter Course Name:");
	JLabel cdtl = new JLabel("Enter Credit Hour");
	JLabel des = new JLabel("Select Decepline->");
	JButton add = new JButton("Add");
	JButton cancel = new JButton("Cancel");
	JButton delete = new JButton("Delete this Subject");
	JPanel tablecontainer = new JPanel();
	JComboBox decepline = new JComboBox();
	String dec;
	final String col[] = { "Name", "Course", "Credits" };
	String data[][] = new String[500][3];
	int cellno, indexofdata = 0;

	public CourseListWindow(HashMap cr) {
		this.cr = cr;
		setSize(900, 600);
		setLayout(null);
		setTitle("Create and Edit Course Offering List");
		setLocation(250, 90);
		setResizable(false);
		add(ccodel);
		add(cnamel);
		add(cdtl);
		add(cdtf);
		add(ccodef);
		add(cnamef);
		add(add);
		add(cancel);
		add(decepline);
		add(des);
		add(delete);

		ccodel.setBounds(0, 0, 200, 30);
		ccodef.setBounds(220, 0, 200, 30);
		cnamel.setBounds(0, 50, 200, 30);
		cnamef.setBounds(220, 50, 200, 30);
		cdtl.setBounds(0, 100, 200, 30);
		cdtf.setBounds(220, 100, 200, 30);
		decepline.setBounds(220, 150, 150, 30);
		decepline.insertItemAt("Engineering", 0);
		decepline.insertItemAt("Business", 1);
		des.setBounds(0, 150, 150, 30);
		add.setBounds(450, 170, 100, 40);
		cancel.setBounds(570, 170, 100, 40);
		cancel.addActionListener(new CancelActionListener(this));

		final JTable table = new JTable(data, col);
		// table.setPreferredSize(new Dimension(900, 700));
		// tablecontainer.add(table);
		// add(tablecontainer);
		table.setPreferredScrollableViewportSize(new Dimension(850, 200));
		table.setFillsViewportHeight(true);
		tablecontainer.add(new JScrollPane(table));
		// table.setPreferredScrollableViewportSize(new Dimension(850, 2000));
		table.setFillsViewportHeight(true);

		tablecontainer.setBounds(0, 250, 900, 200);
		add(tablecontainer);
		delete.setBounds(700, 500, 200, 40);
		delete.setVisible(false);
		delete.addActionListener(new DeleteActionListener());
		table.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {
						cellno = table.getSelectedRow();
						delete.setVisible(true);
					}
				});

		Set set = cr.entrySet();
		Iterator i = set.iterator();

		// int indexofdata=0;
		while (i.hasNext()) {
			Map.Entry me = (Map.Entry) i.next();
			CourseList crdem = (CourseList) me.getValue();
			if (crdem.semester.equals(StaticGlobal.currentSem)
					&& crdem.year == StaticGlobal.y) {
				data[indexofdata][0] = crdem.ccode;
				data[indexofdata][1] = crdem.cname;
				data[indexofdata][2] = crdem.credit;
				indexofdata++;
			}

		}

		add.addActionListener(new AddActionListener());
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

	class DeleteActionListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			String temp1;
			String temp2;
			String temp3;
			int index = 0;

			cr.remove(data[cellno][1]);

			for (int j = 0; j < 500; j++) {

				data[j][0] = null;
				data[j][1] = null;
				data[j][2] = null;
			}

			StaticGlobal.cindex = StaticGlobal.cindex - 1;
			indexofdata = 0;
			Set set = cr.entrySet();
			Iterator i = set.iterator();

			int indexofdata = 0;
			while (i.hasNext()) {
				Map.Entry me = (Map.Entry) i.next();
				CourseList crdem = (CourseList) me.getValue();
				if (crdem.semester.equals(StaticGlobal.currentSem)
						&& crdem.year == StaticGlobal.y) {
					data[indexofdata][0] = crdem.ccode;
					data[indexofdata][1] = crdem.cname;
					data[indexofdata][2] = crdem.credit;
					indexofdata++;
				}

			}

			tablecontainer.repaint();
			getContentPane().repaint();
		}
	}

	class AddActionListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			String name = cnamef.getText();
			String ccode = ccodef.getText();
			String credit = cdtf.getText();
			dec = (String) decepline.getSelectedItem();
			StaticGlobal.des = dec;
			System.out.print(name + " " + ccode + " " + credit);
			try {
				FileOutputStream fileout = new FileOutputStream(
						"database//courselist.txt");
				ObjectOutputStream out = new ObjectOutputStream(fileout);
				int i = StaticGlobal.cindex;
				CourseList crs = new CourseList(ccode, name, credit,
						StaticGlobal.currentSem, dec, StaticGlobal.y,
						StaticGlobal.cindex);
				cr.put(crs.cname, crs);
				out.writeObject(cr);
				StaticGlobal.cindex++;
				data[indexofdata][0] = crs.ccode;
				data[indexofdata][1] = crs.cname;
				data[indexofdata][2] = crs.credit;
				indexofdata++;
				System.out.println("***==" + indexofdata);
				out.close();
				fileout.close();
				System.out.print("saved : " + crs.cname);
				tablecontainer.repaint();
			} catch (IOException e1) {

			}
		}

	}
}
