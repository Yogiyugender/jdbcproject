package toy_mangment.dao;
import  toy_mangment.dto.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import toy_mangment.dto.Admin;

public class Toy_crud {
	 public Connection createTable() throws ClassNotFoundException, IOException, SQLException {
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   FileInputStream file=new FileInputStream("Toyconfig.properties");
		   Properties p=new Properties();
		   p.load(file);
		   Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/toy_mangment?createDatabaseIfNotExist=true", p);
//		  PreparedStatement s = c.prepareStatement("create table toys(id int primary key,name varchar(45),price int,quantity int,email varchar(45),color varchar(45))");
//	      s.execute();
//	      s.close();
//	      c.close();
	   return c;
	 }
	 public void insertToy() throws ClassNotFoundException, IOException, SQLException {
		 Connection c = createTable();
		 Scanner scan=new Scanner(System.in);
		 System.out.println("Enter the  TOY_ID:");
		    int id = scan.nextInt();
		    System.out.println("Enter the  TOY_NAME:");
		    String name = scan.next();
		    System.out.println("Enter the  TOY_PRICE:");
		    int price = scan.nextInt();
		    System.out.println("Enter the Toy_QUANTITY :");
		    int quantity = scan.nextInt();
		    System.out.println("Enter the Email :");
		    String email=scan.next();
		    System.out.println("Enter the TOY_color :");
		   String color= scan.next();
		   PreparedStatement s = c.prepareStatement("insert into toys values(?,?,?,?,?,?)");
		          s.setInt(1, id);
			      s.setString(2,name);
			      s.setInt(3,price);
			      s.setInt(4,quantity);
			      s.setString(5, email);
			      s.setString(6, color);
			     Toy t=new Toy(id,name,price,quantity,email,color);
			      s.execute();
			      s.close();
			      c.close();
		
	 }
	 public void fetchToy() throws ClassNotFoundException, IOException, SQLException {
		  Connection c = createTable();
		  PreparedStatement s = c.prepareStatement("select* from toys");
		    ResultSet rs = s.executeQuery();
		    System.out.println("-------------------------------- ");
		    while (rs.next()) {
		        System.out.print("** TOY_ID :: ");
				System.out.println(rs.getInt(1)+" ");
				System.out.print("** TOY_NAME :: ");
				System.out.println(rs.getString(2)+" ");
				System.out.print("** TOY_price :: ");
				System.out.println(rs.getInt(3)+" ");
				System.out.print("** TOY_QUANTITY :: ");
				System.out.println(rs.getInt(4)+" ");
				System.out.print("** TOY_EMAIL :: ");
				System.out.println(rs.getString(5)+" ");
				System.out.print("** TOY_COLOR :: ");
				System.out.println(rs.getString(6));
				System.out.println("---------------------------------");
				System.out.println();
			}
		  s.close();
		  c.close();
	   }
	 public void UpdateToy(int id1) throws SQLException, ClassNotFoundException, IOException {
		 Scanner scan=new Scanner(System.in);
		 Connection c = createTable();
		 System.out.println("Enter what you want to update: \n 1.id \n 2.name \n 3.price \n 4.Quantity \n 5.email \n 6.color");
		 int updateChoice=scan.nextInt();
		 switch (updateChoice) {
		case 1:
			PreparedStatement s = c.prepareStatement("update toys set id=? where id=?");
			System.out.println("Enter the UPDATED ID value here:");
			int id=scan.nextInt();
			
			s.setInt(1, id);
			s.setInt(2, id1);
			s.execute();
			s.close();
			c.close();
			break;
		case 2:
			PreparedStatement s1=c.prepareStatement("update toys set name=? where id=?");
			System.out.println("Enter the UPDATED NAME value here:");
		    String name=scan.next();
		    s1.setString(1, name);
		    s1.setInt(2, id1);
			s1.execute();
			s1.close();
			c.close();
			break;
			
		case 3:
			PreparedStatement s2=c.prepareStatement("update toys set price=? where id=?");
			System.out.println("Enter the UPDATED PRICE value here:");
		    int price=scan.nextInt();
		    s2.setInt(1,price);
		    s2.setInt(2, id1);
			s2.execute();
			s2.close();
			c.close();
			break;
		case 4:
			PreparedStatement s3=c.prepareStatement("update toys set quantity=? where id=?");
			System.out.println("Enter the UPDATED QUANTITY value here:");
		    int Quantity=scan.nextInt();
		    s3.setInt(1, Quantity);
		    s3.setInt(2, id1);
			s3.execute();
			s3.close();
			c.close();
			break;
		case 5:	
			PreparedStatement s4=c.prepareStatement("update toys set email=? where id=?");
			System.out.println("Enter the UPDATED EMAIL value here:");
		    String email=scan.next();
		    s4.setString(1, email);
		    s4.setInt(2, id1);
			s4.execute();
			s4.close();
			c.close();
			break;
		case 6:
			PreparedStatement s5=c.prepareStatement("update toys set color=? where id=?");
			System.out.println("Enter the UPDATED COLOR value here:");
		    String color=scan.next();
		    s5.setString(1, color);
		    s5.setInt(2, id1);
			s5.execute();
			s5.close();
			c.close();
			break;
		default:System.out.println("Entered ID was incorrect plz check it ....?");
			break;
		}
		   
	   }
	 public void DeleteToy() {
		   
	   }
}
