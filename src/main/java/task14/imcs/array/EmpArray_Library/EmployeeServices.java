package task14.imcs.array.EmpArray_Library;

public interface EmployeeServices {

	public void readFromFile();
	
	public boolean addEmpChck();

	public boolean addEmployee(Employee employee);

	public String viewEmployee(int id);

	public String viewAllEmployees();

	public void updateEmployee(int id, Employee updateEmp);

	public void deleteEmployee(int id);

	public boolean isExists(int id) throws EmployeeNotFoundException;

	public double getHRASrvc(int hraId);

	public double getGrossSrvc(int grossID);

	public boolean writeToFile();

}
