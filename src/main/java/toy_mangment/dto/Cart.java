package toy_mangment.dto;

public class Cart {
	
    private	 int toy_id;
    	private  String toy_name;
    	private int toy_price;
    	private int toy_quantity;
		public Cart(int toy_id, String toy_name, int toy_price, int toy_quantity) {
			super();
			this.toy_id = toy_id;
			this.toy_name = toy_name;
			this.toy_price = toy_price;
			this.toy_quantity = toy_quantity;
		}
		
		
		public Cart() {
			// TODO Auto-generated constructor stub
		}


		public int getToy_id() {
			return toy_id;
		}


		public void setToy_id(int toy_id) {
			this.toy_id = toy_id;
		}


		public String getToy_name() {
			return toy_name;
		}


		public void setToy_name(String toy_name) {
			this.toy_name = toy_name;
		}


		public int getToy_price() {
			return toy_price;
		}


		public void setToy_price(int toy_price) {
			this.toy_price = toy_price;
		}


		public int getToy_quantity() {
			return toy_quantity;
		}


		public void setToy_quantity(int toy_quantity) {
			this.toy_quantity = toy_quantity;
		}


		public String toString() {
			return  "==)toy_id=" + toy_id + " \n==)toy_name=" + toy_name + "\n==) toy_price=" + toy_price + "\n==) toy_quantity="
					+ toy_quantity +"\n**************************\n";
		}
}
