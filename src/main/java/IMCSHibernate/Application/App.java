package IMCSHibernate.Application;

import java.util.Arrays;
import java.util.HashSet;

import IMCSHibernate.DAO.EmployeeOperations;
import IMCSHibernate.DAO.EmployeeOperationsImpl;
import IMCSHibernate.Entity.Address;
import IMCSHibernate.Entity.Employee;
import IMCSHibernate.Entity.Salary;
import IMCSHibernate.Utils.SessionUtils;

public class App {
	public static void main(String[] args) {
		SessionUtils.getSessionFactory();
		EmployeeOperations empOps = new EmployeeOperationsImpl();
		Employee newemployee = new Employee("Dhanush", "Prabha", "Gundu@gmail.com");
		Address address = new Address("1046 San Jacinto Dr", "Irving", "TX", 76864, "USA");
		Salary employeesalary = new Salary(10000.00);
		address.setEmployee(newemployee);
		newemployee.setAddress(new HashSet<Address>(Arrays.asList(address)));
		employeesalary.setEmployee(newemployee);
		newemployee.setSalary(employeesalary);

		empOps.createEmployee(newemployee);
		
		System.out.println("Name: ");
		System.out.println(empOps.viewRecordByCriteria().getFirstName() + " "
				+ empOps.viewRecordByCriteria().getLastName());
		System.out.println("Salary: ");
		System.err.println(empOps.viewRecordByCriteria().getSalary().getSalary());
		System.out.println(
				empOps.viewRecordByHQL().getFirstName() + " " + empOps.viewRecordByHQL().getLastName());
	}
}
