package CRUD_EME_Package.folder;

public class Employee {
	int empid;
	String ename, job, department;
	double salary;

	public Employee(int empid, String ename, String job, double salary, String department) {
		super();
		this.empid = empid;
		this.ename = ename;
		this.job = job;
		this.department = department;
		this.salary = salary;
	}

	public String toString() {
		return empid + " -- " + ename + " -- " + job + " -- " + department + " -- " + salary;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
}