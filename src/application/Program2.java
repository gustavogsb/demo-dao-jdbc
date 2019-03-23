package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		//Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("===== TEST 1: Department findById =====");
		Department department = departmentDao.findById(3);
		System.out.println(department);
/*		
		System.out.println("\n===== TEST 2: Department findByDepartment =====");
		Department department = new Department(2, null);
		List<Department> departments = departmentDao.findByDepartment(department);	
		
		for(Department sel: departments){
			System.out.println(sel);
		}
		
		System.out.println("\n===== TEST 3: Department findAll =====");
		departments = departmentDao.findAll();	
		
		for(Department sel: departments){
			System.out.println(sel);
		}
		
		System.out.println("\n===== TEST 4: Department insert =====");
		Department newDepartment = new Department(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		System.out.println("\n===== TEST 5: Department update =====");
		department = departmentDao.findById(1);
		department.setName("Marta Waine");
		departmentDao.update(department);
		System.out.println("Update Completed");
		
		System.out.println("\n===== TEST 6: Department Delete =====");	
		System.out.println("Enter ID for delete test");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed!");
*/		
		//sc.close();
		
		
		
	}

}
