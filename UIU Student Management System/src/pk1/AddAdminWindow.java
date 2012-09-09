package pk1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddAdminWindow extends JFrame {
	HashMap admin = new HashMap();
	JTextField name = new JTextField();
	JTextField password = new JTextField();
	JLabel namel = new JLabel("Enter name :");
	JLabel passl = new JLabel("Enter Password");
	JButton addadmin = new JButton("Add");
	Admin ad;

	public AddAdminWindow(HashMap admin) {

		this.admin = admin;
		setTitle("Add Admin");
		setSize(400, 200);
		setLayout(null);
		setLocation(500, 200);
		add(name);
		add(password);
		add(namel);
		add(passl);
		add(addadmin);
		namel.setBounds(20, 20, 100, 20);
		passl.setBounds(20, 50, 120, 20);
		name.setBounds(140, 20, 120, 30);
		password.setBounds(140, 50, 120, 30);
		addadmin.setBounds(250, 80, 100, 30);
		addadmin.addActionListener(new AddnewActionListener());
		show();
	}

	class AddnewActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			String n = (String) name.getText();
			String p = (String) password.getText();
			ad = new Admin(n, p);
			admin.put(n, ad);

		}
	}

}