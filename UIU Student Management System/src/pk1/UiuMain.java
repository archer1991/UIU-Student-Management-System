package pk1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import javax.swing.plaf.FontUIResource;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

class PasswordWindow extends JFrame {
	// Make static Student class for dynamic data assign facility.here we save
	// the information of students.

	public static HashMap st1 = new HashMap();
	public static HashMap st2 = new HashMap();
	public static HashMap st3 = new HashMap();
	public static HashMap st4 = new HashMap();
	public static HashMap cr = new HashMap();
	public static HashMap loghistory = new HashMap();
	public static HashMap admin = new HashMap();
	public static IDClass rollindex = new IDClass();
	public Admin ad;
	public LogHistory log;
	Global g = new Global();

	// initializing component

	JLabel name = new JLabel("United International University");
	JLabel instruction = new JLabel(
			"Please Enter Admin User ID and Password to Login");
	ImageIcon uiuImage = new ImageIcon(
			"United_International_University_Logo.gif");
	ImageIcon enterImage = new ImageIcon("enter.png");
	JButton check = new JButton(enterImage);
	JLabel imageLabel = new JLabel(uiuImage);
	JLabel user = new JLabel("User ID:");
	JLabel pa = new JLabel("Password:");

	final JPasswordField password = new JPasswordField();
	final JPasswordField username = new JPasswordField();

	// passwindow constructor

	public PasswordWindow(int height, int width) {
		setTitle("UIU Student Management System");
		setSize(width, height);
		setLocation(400, 200);
		setLayout(null);
		add(check);
		add(name);
		add(instruction);
		add(password);
		add(username);
		add(imageLabel);
		add(user);
		add(pa);
		user.setBounds(100, 135, 70, 30);
		pa.setBounds(100, 165, 100, 30);
		check.addActionListener(new CheckButtonActionListener());
		Admin ad = new Admin("mast", "1");
		admin.put("mast", ad);

		initialization();
		// password.addActionListener(new PasswordBoxActionListener());
		show();

	}

	class CheckButtonActionListener implements ActionListener {
		private String a;
		private String p;

		public void actionPerformed(ActionEvent evt) {

			a = (String) username.getText();
			p = (String) password.getText();

			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();

			ad = (Admin) admin.get(a);

			if (p.equals(ad.password)) {
				// JOptionPane.showMessageDialog(null, "Verified");

				// method for retrieve data using serialization (Students,Global
				// VAriables,Courselist etc

				g.loggedin = 0;
				initialization();

				log = new LogHistory(a, dateFormat.format(date));

				// g.loggedin = (request.getParameter("g.loggedin") == null) ? 0
				// : Integer.parseInt(request.getParameter("counter"));

				loghistory.put(g.loggedin, log);

				// Call Available option window (next window)

				AvailableOptions options = new AvailableOptions(900, 600, 250,
						50, st1, st2, st3, st4, cr, rollindex, admin,
						loghistory);
				options.setTitle("United International University-Admin Panel");
				options.setResizable(false);
				options.setLocation(250, 90);
				options.addStu.setLocation(150, 50);
				options.addSub.setLocation(500, 50);
				options.viewStudent.setLocation(150, 150);
				options.viewResult.setLocation(500, 150);
				// options.show();

				// when Available options window is closing then save all index
				// and global variables in a file (important)

				options.addWindowListener(new java.awt.event.WindowAdapter() {
					public void windowClosing(WindowEvent winEvt) {
						try {
							FileOutputStream fileout = new FileOutputStream(
									"database//ID.txt");
							ObjectOutputStream out = new ObjectOutputStream(
									fileout);

							out.writeObject(rollindex);
							out.close();
							fileout.close();
						} catch (IOException e) {

						}
						try {
							FileOutputStream fileout = new FileOutputStream(
									"database//Log.txt");
							ObjectOutputStream out = new ObjectOutputStream(
									fileout);

							out.writeObject(loghistory);
							out.close();
							fileout.close();
						} catch (IOException e) {

						}
						try {
							FileOutputStream fileout = new FileOutputStream(
									"database//courselist.txt");
							ObjectOutputStream out = new ObjectOutputStream(
									fileout);

							out.writeObject(cr);
							out.close();
							fileout.close();

						} catch (IOException e2) {

						}
						try {
							FileOutputStream fileout = new FileOutputStream(
									"database//Admin.txt");
							ObjectOutputStream out = new ObjectOutputStream(
									fileout);

							out.writeObject(admin);
							out.close();
							fileout.close();

						} catch (IOException e2) {

						}
						try {
							FileOutputStream fileout = new FileOutputStream(
									"database//globals.txt");
							ObjectOutputStream out = new ObjectOutputStream(
									fileout);
							Global g = new Global(StaticGlobal.currentSem,
									StaticGlobal.y, StaticGlobal.csin,
									StaticGlobal.mscsin, StaticGlobal.bbain,
									StaticGlobal.eeein, StaticGlobal.cindex,
									StaticGlobal.des, ++StaticGlobal.loggedin);
							out.writeObject(g);
							out.close();
							fileout.close();
						} catch (IOException e1) {

						}
						try {

							FileOutputStream fileout = new FileOutputStream(
									"database//CSEStudent.txt");
							ObjectOutputStream out = new ObjectOutputStream(
									fileout);

							out.writeObject(st1);
							out.close();
							fileout.close();
						} catch (IOException e) {

						}
						try {

							FileOutputStream fileout = new FileOutputStream(
									"database//MSCSEStudent.txt");
							ObjectOutputStream out = new ObjectOutputStream(
									fileout);

							out.writeObject(st2);
							out.close();
							fileout.close();
						} catch (IOException e) {

						}
						try {

							FileOutputStream fileout = new FileOutputStream(
									"database//BBAStudent.txt");
							ObjectOutputStream out = new ObjectOutputStream(
									fileout);

							out.writeObject(st4);
							out.close();
							fileout.close();
						} catch (IOException e) {

						}
						try {

							FileOutputStream fileout = new FileOutputStream(
									"database//EEEStudent.txt");
							ObjectOutputStream out = new ObjectOutputStream(
									fileout);

							out.writeObject(st3);
							out.close();
							fileout.close();
						} catch (IOException e) {

						}
						System.out.print("Thank u for using this software");
						System.exit(0);
					}
				});
				// method for hiding and close password window
				setVisible(false);

			}

			// password.setEnabled(true);
		}

	}

	// initialize all Student data from file
	public void initialization() {

		try {

			FileInputStream fileIn = new FileInputStream(
					"database//globals.txt");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			g = (Global) in.readObject();
			StaticGlobal.y = g.year;
			StaticGlobal.currentSem = g.semester;
			StaticGlobal.csin = g.cin;
			System.out.print(g.cin);
			StaticGlobal.mscsin = g.msin;
			StaticGlobal.bbain = g.bbin;
			StaticGlobal.cindex = g.cindex;
			StaticGlobal.des = g.des;
			StaticGlobal.loggedin = g.loggedin;
			System.out.print("\nHello " + StaticGlobal.cindex);
			in.close();
			fileIn.close();
		} catch (Exception e) {

		}
		try {
			FileInputStream fileIn = new FileInputStream("database//Admin.txt");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			admin = (HashMap) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException e) {

		} catch (ClassNotFoundException e) {

		}
		try {
			FileInputStream fileIn = new FileInputStream("database//Log.txt");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			loghistory = (HashMap) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException e) {

		} catch (ClassNotFoundException e) {

		}

		try {
			FileInputStream fileIn = new FileInputStream(
					"database//CSEStudent.txt");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			st1 = (HashMap) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException e) {

		} catch (ClassNotFoundException e) {

		}
		try {
			FileInputStream fileIn = new FileInputStream("database//ID.txt");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			rollindex = (IDClass) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException e) {

		} catch (ClassNotFoundException e) {

		}

		try {
			FileInputStream fileIn = new FileInputStream(
					"database//courselist.txt");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			cr = (HashMap) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException e) {

		} catch (ClassNotFoundException e) {

		}

		try {
			FileInputStream fileIn = new FileInputStream(
					"database//EEEStudent.txt");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			st3 = (HashMap) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException e) {

		} catch (ClassNotFoundException e) {

		}

		try {
			FileInputStream fileIn = new FileInputStream(
					"database//BBAStudent.txt");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			st4 = (HashMap) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException e) {

		} catch (ClassNotFoundException e) {

		}

		try {
			FileInputStream fileIn = new FileInputStream(
					"database//MSCSEStudent.txt");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			st2 = (HashMap) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException e) {

		} catch (ClassNotFoundException e) {

		}

	}

}

// Main Class

public class UiuMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
		} catch (Exception e) {
		}

		// setting attributes of the password window and its component
		PasswordWindow p = new PasswordWindow(350, 550);
		p.setLayout(null);
		p.setTitle("United Internatioanl University");
		p.check.setLocation(220, 210);
		p.check.setSize(109, 90);
		p.name.setLocation(160, 40);
		p.name.setSize(400, 50);
		p.name.setFont(new Font("Ubuntu", Font.BOLD, 18));
		p.instruction.setSize(400, 50);
		p.instruction.setFont(new Font("Ubuntu Light", Font.BOLD, 14));
		p.instruction.setLocation(100, 70);
		p.password.setSize(170, 20);
		p.password.setLocation(190, 170);
		p.username.setBounds(190, 140, 170, 20);
		p.imageLabel.setSize(110, 100);
		p.imageLabel.setLocation(80, 10);

		p.setResizable(false);

		p.show();

		// when password window is closing then save all index and global
		// variables in a file (important)

		p.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(WindowEvent winEvt) {
				/*
				 * try { FileOutputStream fileout = new FileOutputStream(
				 * "database//globals.txt"); ObjectOutputStream out = new
				 * ObjectOutputStream(fileout); Global g = new
				 * Global(StaticGlobal.currentSem, StaticGlobal.y,
				 * StaticGlobal.csin, StaticGlobal.mscsin, StaticGlobal.bbain,
				 * StaticGlobal.eeein, StaticGlobal.cindex, StaticGlobal.des,
				 * StaticGlobal.loggedin); out.writeObject(g); out.close();
				 * fileout.close(); } catch (IOException e1) {
				 * 
				 * }
				 */

				System.out.print("Thank u for using this software");
				System.exit(0);
			}
		});

	}

}