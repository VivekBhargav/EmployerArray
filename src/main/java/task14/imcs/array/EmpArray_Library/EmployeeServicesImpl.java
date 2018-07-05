package task14.imcs.array.EmpArray_Library;

public class EmployeeServicesImpl implements EmployeeServices {
	EmployeeArrayDAO empArrayDao = new EmployeeArrayDAOImpl();

	public void readFromFile() {
		empArrayDao.readFromFile();
	}

	public boolean addEmpChck() {
		return empArrayDao.addEmpChck();
	}

	public boolean addEmployee(Employee employee) {
		return empArrayDao.addEmployee(employee);
	}

	public boolean isExists(int id) throws EmployeeNotFoundException {
		return empArrayDao.isExists(id);
	}

	public String viewEmployee(int id) {
		return empArrayDao.viewEmployee(id);
	}

	public String viewAllEmployees() {
		return empArrayDao.viewAllEmployees();
	}

	public void updateEmployee(int id, Employee updateEmp) {
		empArrayDao.updateEmployee(id, updateEmp);
	}

	public void deleteEmployee(int id) {
		empArrayDao.deleteEmployee(id);
	}

	public double getHRASrvc(int hraId) {
		return empArrayDao.getHRA(hraId);
	}

	public double getGrossSrvc(int grossID) {
		return empArrayDao.getGross(grossID);
	}

	public boolean writeToFile() {
		return empArrayDao.writeToFile();

	}

}
