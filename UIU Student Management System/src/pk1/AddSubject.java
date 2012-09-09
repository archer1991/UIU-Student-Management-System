package pk1;

import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class AddSubject {
	Student[] st1 = new Student[1000];

	public AddSubject(Student[] st1) {
		this.st1 = st1;

		System.out.print("" + st1[0].name + "\n" + st1[0].father);

	}
}
