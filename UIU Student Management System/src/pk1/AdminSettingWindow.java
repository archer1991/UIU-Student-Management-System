package pk1;

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

public class AdminSettingWindow extends JFrame {
	IDClass rollindex = new IDClass();
	HashMap admin = new HashMap();
	HashMap loghistory = new HashMap();

	JLabel enteryear = new JLabel("Enter Current Year");
	JLabel loghis = new JLabel("Admin Log History");
	JTextField yeartext = new JTextField("");
	JComboBox semtext = new JComboBox();
	JLabel entersmter = new JLabel("Select Semester");
	JButton ok = new JButton("Ok");
	JButton addAdmin = new JButton("Add New Admin");
	JPanel avpanel = new JPanel();
	String sem;
	int y;
	final String col1[] = { "AdminName", "Date and Time" };
	String data1[][] = new String[500][3];

	public AdminSettingWindow(IDClass rollindex, HashMap admin,
			HashMap loghistory) {
		this.rollindex = rollindex;
		this.admin = admin;
		this.loghistory = loghistory;
		setSize(900, 600);
		setTitle("Admin Settings");
		setLayout(null);
		setLocation(250, 50);
		add(yeartext);
		add(semtext);
		add(entersmter);
		add(enteryear);
		add(loghis);
		add(addAdmin);
		add(ok);

		yeartext.setBounds(160, 30, 200, 30);
		entersmter.setBounds(370, 20, 150, 50);
		enteryear.setBounds(0, 20, 150, 50);
		semtext.setBounds(500, 30, 150, 30);
		semtext.insertItemAt("Spring", 0);
		semtext.insertItemAt("Summer", 1);
		semtext.insertItemAt("Fall", 2);
		ok.setBounds(800, 500, 100, 50);
		addAdmin.setBounds(600, 500, 150, 50);
		addAdmin.addActionListener(new AddAdminActionListener());
		loghis.setBounds(0, 180, 150, 30);

		final JTable table1 = new JTable(data1, col1);
		table1.setPreferredScrollableViewportSize(new Dimension(880, 200));
		table1.setFillsViewportHeight(true);
		avpanel.add(new JScrollPane(table1));
		avpanel.setBounds(0, 200, 900, 200);
		add(avpanel);

		Set set = loghistory.entrySet();
		Iterator i = set.iterator();

		int indexofdata = 0;
		while (i.hasNext()) {
			Map.Entry me = (Map.Entry) i.next();
			LogHistory lg = (LogHistory) me.getValue();

			data1[indexofdata][0] = lg.username;
			data1[indexofdata][1] = lg.lastlogged;
			indexofdata++;

		}

		semtext.addActionListener(new SemActionListener());

		ok.addActionListener(new OkActionListener(this));

		show();

	}

	class SemActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			StaticGlobal.currentSem = (String) semtext.getSelectedItem();
		}

	}

	class OkActionListener implements ActionListener {
		private JFrame toBeClose;

		public OkActionListener(JFrame toBeClose) {
			this.toBeClose = toBeClose;
		}

		public void actionPerformed(ActionEvent e) {
			this.toBeClose = toBeClose;
			StaticGlobal.y = Integer.parseInt(yeartext.getText());
			rollindex.csid = 0;
			rollindex.eeeid = 0;
			rollindex.mscsid = 0;
			rollindex.bbaid = 0;
			try {
				FileOutputStream fileout = new FileOutputStream(
						"database//globals.txt");
				ObjectOutputStream out = new ObjectOutputStream(fileout);
				Global g = new Global(StaticGlobal.currentSem, StaticGlobal.y,
						StaticGlobal.csin, StaticGlobal.mscsin,
						StaticGlobal.bbain, StaticGlobal.eeein,
						StaticGlobal.cindex, StaticGlobal.des,
						StaticGlobal.loggedin);
				out.writeObject(g);
				out.close();
				fileout.close();
			} catch (IOException e1) {

			}
			toBeClose.setVisible(false);
			toBeClose.dispose();

		}

	}

	class AddAdminActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			AddAdminWindow adminwin = new AddAdminWindow(admin);
		}
	}

}
