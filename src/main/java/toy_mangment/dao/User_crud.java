package toy_mangment.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import toy_mangment.dto.*;
import com.mysql.cj.jdbc.Driver;
import java.util.*;
public class User_crud {
	 public Connection createTable() throws SQLException, IOException {
		   DriverManager.registerDriver(new Driver());
		   FileInputStream file=new FileInputStream("toy_userconfig.properties");
		   Properties p=new Properties();
		   p.load(file);
		   Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/toy_mangment?createDatabaseIfNotExist=true", p);
//		   PreparedStatement s = c.prepareStatement("create table toy_user(id int primary key,name varchar(45),email varchar(45) unique,password varchar(45),wallet int)");
//		   s.execute();
//		   s.close();
//		   c.close();
		   return c;
	   }
	 public void insertUser() throws SQLException, IOException {
		 Scanner scan=new Scanner(System.in);
		 System.out.println("Enter the USERID:");
		    int id = scan.nextInt();
		    System.out.println("Enter the USER NAME:");
		    String name = scan.next();
		    System.out.println("Enter the USER EMAIL:");
		    String email = scan.next();
		    System.out.println("Enter the USER PASSWORD:");
		    String password = scan.next();
		    System.out.println("Enter your WALLET money:");
		    int wallet=scan.nextInt();
		   Connection c = createTable();
		   PreparedStatement s = c.prepareStatement("insert into toy_user values(?,?,?,?,?)");
		          s.setInt(1, id);
			      s.setString(2,name);
			      s.setString(3,email);
			      s.setString(4,password);
			      s.setInt(5, wallet);
			      User u=new User(id,name,email,password,wallet);
			      s.execute();
			      s.close();
			      c.close();
		
 }
	 public User fetchUser(String email) throws SQLException, IOException {
		   Connection c = createTable();
		PreparedStatement s=c.prepareStatement("select* from toy_user where email=?");
		s.setString(1, email);
	    ResultSet rs = s.executeQuery();
	    if (rs.next()) {
			int id = rs.getInt(1);
		   String	name=rs.getString(2);
		   String	email1=rs.getString(3);
			String password = rs.getString(4);
			int wallet = rs.getInt(5);
			User a=new User(id,name,email1,password,wallet);
			return a;
		}
	    return null;
	 }
	 public void UpdateUser(int id1) throws SQLException, IOException {
		 Scanner scan=new Scanner(System.in);
		 Connection c = createTable();
		 System.out.println("Enter what you want to Update: \n 1.Id \n 2.Name \n 3.Email \n 4.Password \n 5.Wallet");
		 int updateChoice=scan.nextInt();
		 switch (updateChoice) {
		case 1:
			PreparedStatement s = c.prepareStatement("update toy_user set id=? where id=?");
			System.out.println("Enter the UPDATED ID value here:");
			int id=scan.nextInt();
			
			s.setInt(1, id);
			s.setInt(2, id1);
			s.execute();
			s.close();
			c.close();
			break;
		case 2:
			PreparedStatement s1=c.prepareStatement("update toy_user set name=? where id=?");
			System.out.println("Enter the UPDATED NAME value here:");
		    String name=scan.next();
		    s1.setString(1, name);
		    s1.setInt(2, id1);
			s1.execute();
			s1.close();
			c.close();
			break;
			
		case 3:
			PreparedStatement s2=c.prepareStatement("update toy_user set email=? where id=?");
			System.out.println("Enter the UPDATED EMAIL value here:");
		    String email=scan.next();
		    s2.setString(1, email);
		    s2.setInt(2, id1);
			s2.execute();
			s2.close();
			c.close();
			break;
		case 4:
			PreparedStatement s3=c.prepareStatement("update toy_user set password=? where id=?");
			System.out.println("Enter the UPDATED password value here:");
		    String password=scan.next();
		    s3.setString(1, password);
		    s3.setInt(2, id1);
			s3.execute();
			s3.close();
			c.close();
			break;
		case 5:
			PreparedStatement s4=c.prepareStatement("update toy_user set WALLET=? where id=?");
			System.out.println("Enter the UPDATED WALLET value here:");
		    String wallet=scan.next();
		    s4.setString(1, wallet);
		    s4.setInt(2, id1);
			s4.execute();
			s4.close();
			c.close();
			break;
		default:System.out.println("Entered ID was incorrect plz check it ....?");
			break;
		}
	   }
	 public void DeleteUser(int id1) throws SQLException, IOException {
		  Connection c = createTable();
			 PreparedStatement  s=c.prepareStatement("delete from toy_user where id=?");
			 s.setInt(1, id1);
			 s.execute();
			 s.close();
			 c.close();
	   }
	public User fecthUserDataBasedOnEmail(String email) throws SQLException, IOException {
	
		 Connection c = createTable();
		  PreparedStatement s = c.prepareStatement("select * from toy_user where email=?");
		  s.setString(1, email);
		  ResultSet rs = s.executeQuery();
		  if (rs.next()) {
			int id = rs.getInt(1);
		  String name=rs.getString(2);
		  String email1=rs.getString(3);
		  String password=rs.getString(4);
		      int wallet = rs.getInt(5);
			User u=new User(id,name,email1,password,wallet);
			return u;
		}else {
			return null;
		}
		  
	}
	int bill=0;
	ArrayList<Cart> al=new ArrayList<Cart>();
	public int cartDisplay(int id) throws SQLException, IOException {
		Scanner scan=new Scanner(System.in);
		Cart c1=new Cart();
		Toy t1=new Toy();
		 Connection c = createTable();
		PreparedStatement ps = c.prepareStatement("Select * from toys where id=?");
		 ps.setInt(1,id);
		 ResultSet rs = ps.executeQuery();
		 if (rs.next()) {
			System.out.println("MR.USER How many {"+ rs.getString(2)+"}'s you want to ADD to CART Enter the COUNT:");
			int countOfToys = scan.nextInt();
		   if (countOfToys<=rs.getInt(4)) {
			     c1.setToy_id(rs.getInt(1));
				 c1.setToy_name(rs.getString(2));
				 c1.setToy_price(rs.getInt(3)*countOfToys);
			     c1.setToy_quantity(countOfToys);
			     PreparedStatement s = c.prepareStatement("update toys set quantity=? where id=?");
			     int add = rs.getInt(4)-countOfToys;
			     s.setInt(1,add);
			     s.setInt(2,id);
			        s.execute();
			     t1.setQuantity(t1.getQuantity()-countOfToys);
			     System.out.println("=====>PURCHASED TOY's details.....!");
			     System.out.println ("---------------------------------------------");
			      System.out.println("TOY_ID : "+c1.getToy_id()+" ");
			      System.out.println("TOY_NAME : "+c1.getToy_name()+" ");
			      System.out.println("TOY_PRICE : "+c1.getToy_price()+" ");
			      System.out.println("TOY_QUANTITY :"+c1.getToy_quantity()+" ");
			      System.out.println("----------------------------------------------");
			      bill=bill+c1.getToy_price();
			      al.add(c1);
			      System.out.println("$$$$$-- Total TOY COST up To now is:: "+bill);
			     System.out.println("{"+c1.getToy_name()+"}'s Succesfully ADDED TO CART...hurehhhhh...!");
				}else{
				System.out.println("SORRY "+ rs.getString(2)  +" OUT OF STOCK.....!");
			}
		   boolean cart=true;
			 do{
		     System.out.println("Select and PRESS: \n 1.BUY NEW TOYS \n 2.DISPLAY-CART \n 3.press EXIT completion of choosing toys");
			 int press=scan.nextInt();
			 switch (press) {
			  case 1:
				System.out.println("Enter the ID of an TOY you Want to BUY:");
				int id1=scan.nextInt();
				 cart=false;
				 cartDisplay(id1);
				break;
			  case 2:
				  System.out.println("YOUR CART COLLECTION: ");
				  System.out.println("*************************");
				  System.out.println(al);
				  break;
			  case 3:
				  cart=false;
				   break;
			 default:System.out.println("You CHOOSED UNKNOWN OPTION RATHER THAN GIVEN CHOICE plz checkit and RE_ENTER it....?");
					break;
			  }
	    }while (cart);
			 ps.close();
			 c.close(); 
	} 
	return bill;
	}
	public void setWallet(String password, int remWallet) throws SQLException, IOException {
		Connection c = createTable();
		  PreparedStatement s = c.prepareStatement("update toy_user set wallet=? where password=?");
		    s.setInt(1,remWallet);
		    s.setString(2, password);
		    s.execute();
		    s.close();
		    c.close();
		}
}
