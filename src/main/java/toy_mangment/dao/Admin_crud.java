package toy_mangment.dao;
import toy_mangment.dto.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class Admin_crud {
	 public Connection createTable() throws ClassNotFoundException, IOException, SQLException {
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    FileInputStream file=new FileInputStream("Adminconfig.properties");
		    Properties p=new Properties();
		    p.load(file);
		  Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/toy_mangment?createDatabaseIfNotExist=true",p );
//		  PreparedStatement s = c.prepareStatement("create table toy_admin?createTableIfNotExist=true(id int primary key,name varchar(30),email varchar(45) unique,passsword varchar(45))");
//		     s.execute();
//		     s.close();
//		     c.close();
		     return c;
	   }
	 public void insertAdmin() throws ClassNotFoundException, IOException, SQLException {
		 Connection c = createTable();
		 Scanner scan=new Scanner(System.in);
		 System.out.println("Enter the ADMIN ID:");
		    int id = scan.nextInt();
		    System.out.println("Enter the ADMIN NAME:");
		    String name = scan.next();
		    System.out.println("Enter the ADMIN EMAIL:");
		    String email = scan.next();
		    System.out.println("Enter the ADMIN PASSWORD:");
		    String password = scan.next();
		   PreparedStatement s = c.prepareStatement("insert into toy_admin values(?,?,?,?)");
		          s.setInt(1, id);
			      s.setString(2,name);
			      s.setString(3,email);
			      s.setString(4,password);
			      Admin a=new Admin(id,name,email,password);
			      s.execute();
			      s.close();
			      c.close();
		
	 }
	 public Admin fetchAdmin( String email) throws ClassNotFoundException, IOException, SQLException {
		    Connection c = createTable();
		PreparedStatement  s=c.prepareStatement("select * from toy_admin where email=?");
		                   s.setString(1, email);
		    ResultSet rs = s.executeQuery();
		    if (rs.next()) {
				int id = rs.getInt(1);
			   String	name=rs.getString(2);
			   String	email1=rs.getString(3);
				String password = rs.getString(4);
				Admin a=new Admin(id,name,email1,password);
				return a;
			}
		    return null;
		    
		   
	   }
	 public void  UpdateAdmin(int id1) throws ClassNotFoundException, IOException, SQLException {
		 Scanner scan=new Scanner(System.in);
		 Connection c = createTable();
		 System.out.println("Enter what you want to update: \n 1.id \n 2.name \n 3.email \n 4.password");
		 int updateChoice=scan.nextInt();
		 switch (updateChoice) {
		case 1:
			PreparedStatement s = c.prepareStatement("update toy_admin set id=? where id=?");
			System.out.println("Enter the UPDATED ID value here:");
			int id=scan.nextInt();
			
			s.setInt(1, id);
			s.setInt(2, id1);
			s.execute();
			s.close();
			c.close();
			break;
		case 2:
			PreparedStatement s1=c.prepareStatement("update toy_admin set name=? where id=?");
			System.out.println("Enter the UPDATED NAME value here:");
		    String name=scan.next();
		    s1.setString(1, name);
		    s1.setInt(2, id1);
			s1.execute();
			s1.close();
			c.close();
			break;
			
		case 3:
			PreparedStatement s2=c.prepareStatement("update toy_admin set email=? where id=?");
			System.out.println("Enter the UPDATED EMAIL value here:");
		    String email=scan.next();
		    s2.setString(1, email);
		    s2.setInt(2, id1);
			s2.execute();
			s2.close();
			c.close();
			break;
		case 4:
			PreparedStatement s3=c.prepareStatement("update toy_admin set password=? where id=?");
			System.out.println("Enter the UPDATED password value here");
		    String password=scan.next();
		    s3.setString(1, password);
		    s3.setInt(2, id1);
			s3.execute();
			s3.close();
			c.close();
			break;
		default:System.out.println("you CHOOSED UNKNOWN COLOUM to UPDATE  plz check it ....?");
			break;
		}
		   
	   }
	 public void DeleteAdmin(int id1) throws ClassNotFoundException, IOException, SQLException {
		   Connection c = createTable();
		 PreparedStatement  s=c.prepareStatement("delete from toy_admin where id=?");
		 s.setInt(1, id1);
		 s.execute();
		 s.close();
		 c.close();
		   
	   }
	public Admin fecthUserDataBasedOnEmail(String email) throws ClassNotFoundException, IOException, SQLException {
		Connection c = createTable();
		      PreparedStatement s = c.prepareStatement("select * from toy_admin where email=?");
		                  s.setString(1, email);
		                   ResultSet rs = s.executeQuery();
		                   if (rs.next()) {
							int id = rs.getInt(1);
							String name = rs.getString(2);
							String email1 = rs.getString(3);
							String password = rs.getString(4);
							Admin a=new Admin(id,name,email1,password);
							return a;
						}else {
							return null;	
						}
		    }
	
}
