package application;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import db.DB;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) throws SQLException {
		
		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("===== TEST 1: Department findById =====");
		Department department = departmentDao.findById(3);
		System.out.println(department);
		
		System.out.println("\n===== TEST 2: Department findAll =====");
		List<Department> departments = departmentDao.findAll();
		
		for(Department dep: departments){
			System.out.println(dep);
		}
		
		System.out.println("\n===== TEST 3: Department insert =====");
		Department newDepartment = new Department(null, "TI");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		System.out.println("\n===== TEST 4: Department update =====");
		department = departmentDao.findById(4);
		department.setName("Books");
		departmentDao.update(department);
		System.out.println("Update Completed");

		System.out.println("\n===== TEST 5: Department Delete =====");	
		System.out.println("Enter ID for delete test");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed!");
		sc.close();
		
		if(!DB.getConnection().isClosed()){
			DB.closeConnection();
			System.out.println("Connection closed now!");
		}else{
			System.out.println("Connection closed already!");
		}		
		
	}

}
