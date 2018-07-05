package task14.imcs.array.EmpArray_Library;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class EmployeeArrayDAOImpl implements EmployeeArrayDAO {
	int curIndex, i = 0;
	Employee[] emp;

	public void readFromFile() {

		try {
			CSVFileReader csvFileReader = new CSVFileReader();
			this.emp = csvFileReader.readEmployees(new File("c:\\temp\\test.csv"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			for (i = 0; i < emp.length; i++) {
				if (emp[i] != null) {
					curIndex++;
				}
			}
		}
	}

	public boolean addEmpChck() {
		boolean status = false;
		if (curIndex < 20) {
			status = true;
		}
		return status;
	}

	public boolean addEmployee(Employee employee) {
		boolean status = false;
		for (i = 0; i < 20; i++) {
			if (emp[i] == null) {
				emp[i] = employee;
				curIndex++;
				status = true;
				break;
			}
		}
		return status;
	}

	public String viewEmployee(int id) {
		String view = null;
		for (i = 0; i <= curIndex; i++) {
			if (emp[i].getId() == id) {
				view = emp[i].toString();
				break;
			}
		}
		return view;
	}

	public String viewAllEmployees() {
		String viewAll = "\n";
		if (emp[0] != null) {
			for (i = 0; i < emp.length; i++) {
				if (emp[i] != null) {
					viewAll = viewAll + emp[i].toString();
				}
			}
		} else
			viewAll = null;
		return viewAll;
	}

	public void updateEmployee(int id, Employee updateEmp) {
		for (i = 0; i < emp.length; i++) {
			if (emp[i].getId() == id) {
				emp[i].setGender(updateEmp.getGender());
				emp[i].setAge(updateEmp.getAge());
				emp[i].setName(updateEmp.getName());
				emp[i].setSalary(updateEmp.getSalary());
				break;
			}
		}
	}

	public void deleteEmployee(int id) {
		int j, temp = 0;
		for (i = 0; i <= curIndex; i++) {
			if (emp[i].getId() == id) {
				emp[i] = null;
				temp = i;
				curIndex--;
				break;
			}
		}
		for (j = temp; j < (curIndex - 1); j++) {
			emp[j] = emp[j + 1];
		}
		emp[curIndex] = null;
	}

	public boolean isExists(int id) throws EmployeeNotFoundException {
		boolean a = false;
		if (emp[0] != null) {
			for (int i = 0; i < emp.length; i++) {
				if (emp[i].getId() == id) {
					a = true;
					break;
				}
			}
		}
		if (a == false) {
			throw new EmployeeNotFoundException("Given id is Invalid. Please provide valid employee id");
		}
		return a;
	}

	public double getHRA(int hraId) {
		double hra = 0;
		for (int i = 0; i < emp.length; i++) {
			if (emp[i].getId() == hraId) {
				hra = EmployeeUtil.calHRA(emp[i]);
				break;
			}
		}
		return hra;
	}

	public double getGross(int grossID) {
		double gross = 0;
		for (int i = 0; i < emp.length; i++) {
			if (emp[i].getId() == grossID) {
				gross = EmployeeUtil.calGross(emp[i]);
			}
		}
		return gross;
	}

	public boolean writeToFile() {
		boolean status = false;
		Writer fw = null;
		BufferedWriter bw = null;

		try {
			File file = new File("c:\\temp\\test.csv");
			if (!file.exists()) {
				file.createNewFile();
			}

			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);

			String line = null;

			for (i = 0; i < curIndex; i++) {
				line = parseLine(emp[i]);
				if (line != null) {
					bw.write(line);
					bw.newLine();
					status = true;
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return status;
	}

	private static String parseLine(Employee emp) {
		String token = emp.getId() + "," + emp.getName() + "," + emp.getSalary() + "," + emp.getAge() + ","
				+ emp.getGender();
		return token;
	}

}
