package IMCSHibernate.DAO;

import IMCSHibernate.Entity.Employee;

public interface EmployeeOperations {
	
	Employee createEmployee(Employee employee);
	Employee viewRecordByCriteria();
	Employee viewRecordByHQL();

}
