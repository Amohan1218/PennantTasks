package tasks.awtTask;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class EmployeeMasterEntry {

	static int k = -1;

	static int decr() {
		return --k;
	}

	static int incr() {
		return ++k;
	}

	static EmployeeList addObj(String Line) {
		String s[] = Line.split(",");
		return new EmployeeList(s[0], s[1], s[2], s[3], s[4]);
	}

	static void updateFile(ArrayList<EmployeeList> P) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(
				"C:\\Users\\mohansai.a\\eclipse-workspace\\JavaTasks\\src\\awtTask\\EmployeeDetails.csv"))) {
			for (EmployeeList i : P) {
				String l = i.getEmpID() + "," + i.getName() + "," + i.getDesignation() + "," + i.getSalary() + ","
						+ i.getDepartment();
				bw.write(l);
				bw.newLine();
				bw.flush();
			}
			bw.close();
		} catch (Exception ae) {
			ae.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ArrayList<EmployeeList> A = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(
					"C:\\Users\\mohansai.a\\eclipse-workspace\\JavaTasks\\src\\awtTask\\EmployeeDetails.csv"));
			String line;
			while ((line = br.readLine()) != null) {
				A.add(addObj(line)); // adding a object in string format
			}
			br.close();
			updateFile(A); // Update file
		} catch (IOException ea) {
			ea.printStackTrace();
		}

		Frame frame = new Frame("Homepage");
		frame.setSize(850, 650);
		frame.setLayout(null);
		frame.setVisible(true);
		/* **********************************************************************/
		Label l = new Label("Employee Master Entry");
		l.setBounds(290, 30, 300, 50);
		frame.add(l);
		Font f = new Font("Time new Roman", Font.PLAIN, 25);
		l.setFont(f);

		Label l1 = new Label("Employee ID.");
		l1.setBounds(40, 80, 100, 60);
		frame.add(l1);

		Label l2 = new Label("Name");
		l2.setBounds(40, 130, 100, 60);
		frame.add(l2);

		Label l3 = new Label("Designation");
		l3.setBounds(40, 180, 100, 60);
		frame.add(l3);

		Label l4 = new Label("Salary");
		l4.setBounds(40, 230, 100, 60);
		frame.add(l4);

		Label l5 = new Label("Department");
		l5.setBounds(380, 230, 80, 60);
		frame.add(l5);

		/* **********************************************************************/
		Label m = new Label("Mode");
		m.setBounds(500, 80, 100, 60);
		frame.add(m);

		Choice c = new Choice();
		c.setBounds(600, 100, 100, 30);
		frame.add(c);
		c.add("Read");
		c.add("Edit");
		/* **********************************************************************/

		// Text fields..
		TextField t1 = new TextField();
		t1.setBounds(140, 90, 200, 30);
		frame.add(t1);

		TextField t2 = new TextField();
		t2.setBounds(140, 140, 200, 30);
		frame.add(t2);

		TextField t3 = new TextField();
		t3.setBounds(140, 190, 200, 30);
		frame.add(t3);

		TextField t4 = new TextField();
		t4.setBounds(140, 240, 200, 30);
		frame.add(t4);

		TextField t5 = new TextField();
		t5.setBounds(480, 240, 200, 30);
		frame.add(t5);

		TextArea t6 = new TextArea();
		t6.setBounds(50, 460, 630, 150);
		frame.add(t6);
		/* **********************************************************************/
		// Buttons
		Button b1 = new Button("First");
		b1.setBounds(60, 300, 70, 40);
		frame.add(b1);

		Button b2 = new Button("Next>>>");
		b2.setBounds(140, 300, 70, 40);
		frame.add(b2);

		Button b3 = new Button("<<<Prev");
		b3.setBounds(220, 300, 70, 40);
		frame.add(b3);

		Button b4 = new Button("Last");
		b4.setBounds(300, 300, 70, 40);
		frame.add(b4);

		Button b5 = new Button("Add");
		b5.setBounds(60, 350, 70, 40);
		frame.add(b5);

		Button b6 = new Button("Edit");
		b6.setBounds(140, 350, 70, 40);
		frame.add(b6);

		Button b7 = new Button("Delete");
		b7.setBounds(220, 350, 70, 40);
		frame.add(b7);

		Button b8 = new Button("Save");
		b8.setBounds(300, 350, 70, 40);
		frame.add(b8);

		Button b9 = new Button("Search");
		b9.setBounds(60, 400, 70, 40);
		frame.add(b9);

		Button b10 = new Button("Clear");
		b10.setBounds(140, 400, 70, 40);
		frame.add(b10);

		Button b11 = new Button("Exit");
		b11.setBounds(220, 400, 70, 40);
		frame.add(b11);

		/* ********************************************************************* */
		// First Button
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.select(0);
				k = 0;
				System.out.println("Record: 1");
				t1.setText(A.get(0).getEmpID());
				t2.setText(A.get(0).getName());
				t3.setText(A.get(0).getDesignation());
				t4.setText(A.get(0).getSalary());
				t5.setText(A.get(0).getDepartment());
			}
		});
		// Next Button
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.select(0);
				if (k < A.size() - 1) {
					int j = incr();
					System.out.println("Record: " + (j + 1));
					t1.setText(A.get(j).getEmpID());
					t2.setText(A.get(j).getName());
					t3.setText(A.get(j).getDesignation());
					t4.setText(A.get(j).getSalary());
					t5.setText(A.get(j).getDepartment());
				} else {
					System.out.println("Reached Last Record.");
				}
			}
		});
		// Prev Button
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.select(0);
				if (k > 0) {
					int j = decr();
					System.out.println("Record: " + (j + 1));
					t1.setText(A.get(j).getEmpID());
					t2.setText(A.get(j).getName());
					t3.setText(A.get(j).getDesignation());
					t4.setText(A.get(j).getSalary());
					t5.setText(A.get(j).getDepartment());
				} else {
					System.out.println("Already you reached first record.");
				}
			}
		});
		// Last Button
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.select(0);
				k = A.size() - 1;
				System.out.println("Record: " + A.size());
				t1.setText(A.get(k).getEmpID());
				t2.setText(A.get(k).getName());
				t3.setText(A.get(k).getDesignation());
				t4.setText(A.get(k).getSalary());
				t5.setText(A.get(k).getDepartment());
			}
		});
		// Add button
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.select(1);
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t1.requestFocus(); // Cursor focus when the button is clicked
			}
		});
		// Edit button
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.select(1);
				t1.setEditable(false);
			}
		});
		// Delete button
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.select(1);
				for (EmployeeList i : A) {
					if (t1.getText().equals(i.getEmpID())) {
						A.remove(i);
						updateFile(A);
						break;
					}
				}
				System.out.println("\nRecord Deleted.");
			}
		});
		// Save button
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.select(1);
				for (EmployeeList j : A) {
					if (t1.getText().equals(j.empID)) {
						j.setName(t2.getText());
						j.setDesignation(t3.getText());
						j.setSalary(t4.getText());
						j.setDepartment(t5.getText());
						updateFile(A);
						break;
					} else {
						String l = t1.getText() + "," + t2.getText() + "," + t3.getText() + "," + t4.getText() + ", "
								+ t5.getText();
						A.add(addObj(l));
						updateFile(A);
						break;
					}
				}
				System.out.println("Record Saved Sucessfully");
			}
		});
		// Search Button
		b9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.select(0);
				t1.setEditable(true);
				t6.setText("Employee ID -- Name -- Designation -- Salary -- Department");
				for (EmployeeList i : A) {
					if (t1.getText().equals(i.getEmpID())) {
						t2.setText(i.getName());
						t3.setText(i.getDesignation());
						t4.setText(i.getSalary());
						t5.setText(i.getDepartment());
						t6.append("\n" + i.getEmpID() + "                  -- " + i.getName() + " -- "
								+ i.getDesignation() + " -- " + i.getSalary() + " -- " + i.getDepartment());
						break;
					}
				}
				t6.setEditable(false);
			}
		});
		// Clear Button
		b10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
			}
		});
		// Exit Button
		b11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		/* ********************************************************************* */

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent ae) {
				System.exit(0);
			}
		});

	}
}

class EmployeeList {
	String empID, name, designation, department, salary;

	EmployeeList(String empID, String name, String designation, String salary, String department) {
		this.empID = empID;
		this.name = name;
		this.designation = designation;
		this.salary = salary;
		this.department = department;
	}

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}
}