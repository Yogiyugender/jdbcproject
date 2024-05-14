package toy_mangment.dto;

public class User {
	 private int id;
     private String name;
     private String email;
     private String password;
     private int wallet;
    
	public User(int id, String name, String email, String password, int wallet) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.wallet = wallet;
	}

	public User() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	 public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}

		public int getWallet() {
			return wallet;
		}

		public void setWallet(int wallet) {
			this.wallet = wallet;
		}

		
		public String toString() {
			
			System.out.println("MR."+this.getName()+"'s  DATA....!");
			return "==) ID:: " + id + " \n==) NAME:: " + name + " \n==) EMAIL:: " + email + " \n==) PASSWORD:: " + password + " \n==) WALLET::"
					+ wallet  ;
		}

   
     
}
