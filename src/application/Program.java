package application;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import db.DB;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws SQLException {
		
		Scanner sc = new Scanner(System.in);

		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("===== TEST 1: Seller findById =====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n===== TEST 2: Seller findByDepartment =====");
		Department department = new Department(2, null);
		List<Seller> sellers = sellerDao.findByDepartment(department);	
		
		for(Seller sel: sellers){
			System.out.println(sel);
		}
		
		System.out.println("\n===== TEST 3: Seller findAll =====");
		sellers = sellerDao.findAll();	
		
		for(Seller sel: sellers){
			System.out.println(sel);
		}
		
		System.out.println("\n===== TEST 4: Seller insert =====");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("\n===== TEST 5: Seller update =====");
		seller = sellerDao.findById(1);
		seller.setName("Marta Waine");
		sellerDao.update(seller);
		System.out.println("Update Completed");
		
		System.out.println("\n===== TEST 6: Seller Delete =====");	
		System.out.println("Enter ID for delete test");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed!");
		
		sc.close();
		
		if(!DB.getConnection().isClosed()){
			DB.closeConnection();
			System.out.println("Conection closed now!");
		}else{
			System.out.println("Conection closed already!");
		}
		
	}

}
