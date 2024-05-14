package toy_mangment.controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.*;
import toy_mangment.dao.*;
import toy_mangment.dto.*;
public class Toys {
     static Scanner scan=new Scanner(System.in);
	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
		Admin_crud ac = new Admin_crud();
//		ac.createTable();//
//		System.out.println("creation of admin table done...!");
		Toy_crud tc=new Toy_crud();
//		tc.createTable();
//		
//		System.out.println("table creation of toys donee....!");
		User_crud tu=new User_crud();
//		User u=new User();
		//tu.createTable();
//		tu.insertUser();
//      System.out.println("table creation of user completes...!");
		System.out.print("                          ");
		System.out.println("------> WELCOME TO TOY_MANAGMENT.....! <-----");
		boolean c1=true;
		do {
			System.out.println("Choose Your Charecter: \n 1.Admin \n 2.User \n 3.exit");
			int charecter=scan.nextInt();
			switch (charecter) {
//----------------------------------ADMIN---------------------------------------			
			case 1:
				System.out.print("                          ");
				System.out.println("===========) WELCOME MR.ADMIN (============");
				 boolean adminboolean=true;
				    do {
				    	System.out.println("Choose the Step: \n 1.Register \n 2.Login \n 3.Exit ");
				    	  int Step=scan.nextInt();
				    	switch (Step) {
						case 1:
							 ac.insertAdmin();
							 System.out.println("REGISTRATION Done MR.ADMIN.....successfully");
							 break;
						case 2:
							loginAdmin();
							      boolean adminFetch=true;
							      do {
							    	  System.out.println("Successfully LOGIN done MR.ADMIN....!");
							    	  System.out.println("Now pick one: \n 1.PROFILE \n 2.TOY-STORE \n 3.EXIT");
							    	  int pick=scan.nextInt();
							    	  switch (pick) {
									case 1:
										boolean adminProfileFetch=true;
										     do {
										    	System.out.println("MR.ADMIN your Selection: \n 1.FETCH-profile \n 2.UPDATE-profile \n 3.DELETE-profile \n 0.EXIT");
										    	  int select=scan.nextInt();
										    	 switch (select) {
												case 1:
													System.out.println("Enter your Email for DISPLAY PROFILE....?");
													String email=scan.next();
													Admin s = ac.fetchAdmin(email);
													if (s!=null) {
														System.out.print("                          ");
														System.out.println("*********YOUR PROFILE**********");
														System.out.println(s);
													}else {
														System.out.println("Enterd Email was WRONG plzz check it and RE-ENTER....?");
													}
													break;
												case 2:
													System.out.println("Enter Your ID to Update:");
													int id=scan.nextInt();
													     ac.UpdateAdmin(id);
													     System.out.println("UPDATION DONE SUCCESSFULLY....");
													break;
												case 3:
													System.out.println("Enter Your ID to DELETE:");
													int id1=scan.nextInt();
													ac.DeleteAdmin(id1);
													System.out.println("DELETION done SUCCESSFULLY....");
													adminProfileFetch=false;
													adminFetch=false;
													adminboolean=false;
													break;
											    case 0:
										    		    adminProfileFetch=false;
														adminFetch=false;
														adminboolean=false;
														break;
										    	 default:System.out.println("You CHOOSED UNKNOWN OPTION RATHER than GIVEN CHOICE plz checkit and RE_ENTER it....?");
													break;
										    	 }
										     }while(adminProfileFetch);
										break;
//--------------------------------------ADMIN TOY-STORE--------------------------------------------------										
									case 2:
										boolean alltoy=true;
										do {
											System.out.print("                          ");
											System.out.println(">>>>>>>>>>> WELCOME TO TOY-STORE <<<<<<<<<<");
											System.out.println("MR.ADMIN click your choice: \n 1.UPLOAD TOY \n 2.UPDATE TOY \n 3.FETCH ALL TOYS \n 4.EXIT");
										int	click=scan.nextInt();
										switch (click) {
										case 1:
											System.out.println("Are you ready to INSERT a new TOY....?");
											tc.insertToy();
											System.out.println("INSERTION OF NEW TOY WAS DONE......!");
											break;
										case 2:
											System.out.println("To UPDATE a Toy you need TO enter the ID of an TOY...plz ENTER the ID:");
											int id=scan.nextInt();
											     tc.UpdateToy(id);
											     System.out.println("UPDATION OF TOY WAS DONE....!");
											     break;
										case 3:
											tc.fetchToy();
											System.out.println("THESE are the TOYS .............!");
											break;
										case 4:
											alltoy=false;
											break;
										default:System.out.println("You CHOOSED UNKNOWN OPTION RATHER than GIVEN CHOICE plz checkit and RE_ENTER it....?");
										break;
										 }
										} while (alltoy);
										break;
									case 3:
										adminFetch=false;
										break;
										default:System.out.println("You CHOOSED UNKNOWN OPTION RATHER than GIVEN CHOICE plz checkit and RE_ENTER it....?");
									    break;
							    	  }
							      }while(adminFetch);
						case 3:
							adminboolean=false;						
						}
				  }while(adminboolean);
				break;
//-------------------------------------USER-------------------------------------				
			case 2:
				boolean c2=true;
				 do {
					 System.out.print("                          ");
					 System.out.println("########> WELCOME MR.USER <#############");
					System.out.println("Enter your choice: \n 1.Register \n 2.Login \n 3.Exit");
					int choice=scan.nextInt();
					switch (choice) {
					case 1 :
						tu.insertUser();
						System.out.println("REGISTRATION Done MR.USER......THANK YOU...!");
						break;
					case 2 :
						login();
						System.out.print("                          ");
						System.out.println(" =====> WELCOME TO THE TOYSTORE.....! <=====");
						boolean c3=true;
						do {
                           System.out.println("select the option: \n 1.PROFILE \n 2.TOYSTORE \n 3.EXIT");
						        int option = scan.nextInt();
						        switch (option) {
								case 1:
										boolean userp=true;
										do {
											System.out.println("ENTER your OPTION MR.USER: \n 1.FETCH-profile \n 2.UPDATE-profile \n 3.DELETE-profile  \n 0.EXIT");
											  int option1=scan.nextInt();
											  switch (option1) {
											case 1:
												System.out.println("Enter your Email to FETCH your PROFILE:");
												String email=scan.next();
												User f = tu.fetchUser(email);
												if (f!=null) {
													System.out.print("                ");   
													System.out.println("*********** HERE IS YOUR PROFILE ***********");
													System.out.println(f);
												}else {
													System.out.println("Entered EMAIL was INCORRECT plz CHECK and RE-ENTER it......?");
												}
												break;
											case 2:
												System.out.println("To Update You should Enter your ID so,plz ENTER YOUR ID:");
												     int id=scan.nextInt();
												     tu.UpdateUser(id);
												     System.out.println("UPDATION SUCCESSFULLY DONE......!");
												break;
											case 3:
												System.out.println("ENTER your ID for DELETION...!");
												int id1=scan.nextInt();
												tu.DeleteUser(id1);
												System.out.println("DELETION done Successfully....!");
												userp=false;
												c3=false;
												c2=false;
												break;
											case 0:
												userp=false;
												break;
											default:System.out.println("You CHOOSED UNKNOWN OPTION RATHER than GIVEN CHOICE plz checkit and RE_ENTER it....?");
											break;
											}
										} while (userp);
										break;
//------------------------------------USER TOY-STORE-------------------------------------										
								case 2:
									System.out.print("                            ");
									System.out.println("~~~~~~~~~~ Welcome to TOY-STORE ~~~~~~~~~~~~~");
									tc.fetchToy();
									System.out.println("THESE ARE THE TOYS AVALIABLE HERE IN OUR SHOP.....!");
									
									     boolean toyboolean=true;
									     do {
									    	 System.out.println("Choose pick one:\n 1.BUY A TOY \n 2.EXIT");
										     int pick=scan.nextInt();
									    	 switch (pick) {
									    	 
				                             case 1:
				                            	 System.out.println("To BUY a TOY plz Enter the ID of an TOY which YOU WANT TO BUY...?");
				                            	 int idOfToy=scan.nextInt();
				                            	   int totalBill = tu.cartDisplay(idOfToy);
				                            	   System.out.println("YOUR TOTAL SHOPPING BILL IS : "+totalBill);
				                            	   System.out.println("For FINAL BILL enter YOUR Email:");
				                            	   String email = scan.next();
				                            	   System.out.println("For FINAL BILL enter your PASSWORD:");
				                            	   String pwd=scan.next();
				                            	        User result = tu.fecthUserDataBasedOnEmail(email);
						                            		if (result!=null) {
						                            			if (result.getPassword().equals(pwd)) {
						                            		    if (totalBill<=result.getWallet()) {
						                            					System.out.println("YOUR BILLING HAS done.....!");
						                            					int remWallet=result.getWallet()-totalBill;
						                            					System.out.println("Your REMAINING PULSE is: "+remWallet);
						                            					tu.setWallet(result.getPassword(),remWallet);
						                            					 result.setWallet(remWallet);
						                            					System.out.print("                            ");
						                            					System.out.println("**************** THANK YOU....VISIT AGAIN......! *******************");
						                            					toyboolean=false;
						                            					c3=false;
																		c2=false;
						                            				}else{
						                            					System.out.println("Your WALLET MONEY is INSUFFICENT....plz UPDATE your WALLET..MINIMUM 100/-");
						                            				 boolean buy=true;
						                            					do {
						                            					System.out.println("TO update WALLET \n 1.UPDATE 2.EXIT");
						                            					int w=scan.nextInt();
						                            					switch (w) {
						                            					case 1:
						                            						System.out.println("Enter Email to FETCH your DATA:");
						                            						String email1=scan.next();
						                            						User s = tu.fetchUser(email1);
						                            						System.out.println(s);
						                            						System.out.println("ENTER YOUR ID FOR UPDATION OF WALLET:");
						                            						int id=scan.nextInt();
						                            						tu.UpdateUser(id);
						                            						break;
						                            					case 2:
						                            						buy=false;
						                            						break;
						                            					default:System.out.println("choose CORRECT OPTION...?");
						                            						break;
						                            					}
						                            				}while (buy);
						                            			}
						                            		}else {
						                            			System.out.println("ENTERD Password was WRONG plz Check and RE_ENTER it....!");
						                            			login();
						                            		}
						                            } else {
						                            	System.out.println("Entered EMAIL was WRONG plz Check it And RE_ENTER it...!");
						                            	login();
						                            }
													break;
											case 2:
												toyboolean=false;
												break;
											default:System.out.println("You CHOOESD UNKNOWN OPTION RATHER THAN GIVEN CHOICE plz checkit and RE_ENTER it....?");
												break;
										   } 
										} while (toyboolean);
 									break;
								case 3:
									c3=false;
									break;
								default:System.out.println("You CHOOSED UNKNOWN OPTION RATHER than GIVEN CHOICE plz checkit and RE_ENTER it....?");
								break;
								}
					       }
						    while (c3) ;
							break;
					case 3:
						c2=false;
						break;
					default:System.out.println("You CHOOSED UNKNOWN OPTION RATHER than GIVEN CHOICE plz checkit and RE_ENTER it....?");
					break;
					 }
				 }
				 while(c2);
			     break;
			case 3:
				c1=false;
			default:System.out.println("You CHOOSED UNKNOWN OPTION RATHER than GIVEN CHOICE plz checkit and RE_ENTER it....?");
			break;
			}
		}
		while(c1);
	}	
//----------------------------METHODS-----------------------------//
private static void loginAdmin() throws ClassNotFoundException, IOException, SQLException {
	Admin_crud tu=new Admin_crud();
	System.out.println("Enter the EMAIL:");
	String email=scan.next();
	System.out.println("Enter the PASSWORD:");
	String password=scan.next();
	Admin u = tu.fecthUserDataBasedOnEmail(email);
	if (u!=null) {
		if (u.getPassword().equals(password)) {
			System.out.println("LOGIN SUCCESSFULLY DONEEEEE....!");
		}else {
			System.out.println("Entered PASSWORD was INCORRECT plz check and re-enter it....?");
			login();
		}
		}else {
			System.out.println("Entered EMAIL was INCORRECT plz check and re-enter it....?");
			login();
			}
}
	private static void login() throws SQLException, IOException {
		User_crud tu=new User_crud();
		System.out.println("Enter the EMAIL:");
		String email=scan.next();
		System.out.println("Enter the PASSWORD:");
		String password=scan.next();
		User u = tu.fecthUserDataBasedOnEmail(email);
		if (u!=null) {
			if (u.getPassword().equals(password)) {
				System.out.println("LOGIN SUCCESSFULLY DONEEEEE....!");
			}else {
				System.out.println("Entered PASSWORD was INCORRECT plz check and re-enter it....?");
				login();
			}
			}else {
				System.out.println("Entered EMAIL was INCORRECT plz check and re-enter it....?");
				login();
				}
		
	}
		
}	
		
	


