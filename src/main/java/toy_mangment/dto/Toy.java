package toy_mangment.dto;

public class Toy {
 private int id;
 private String name;
 private double price;
 private int quantity;
 private String email;
 private String color;
public Toy(int id, String name, double price, int quantity, String email, String color) {
	super();
	this.id = id;
	this.name = name;
	this.price = price;
	this.quantity = quantity;
	this.email = email;
	this.color = color;
}
public Toy() {
	
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
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
@Override
public String toString() {
	return "Toy [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", email=" + email
			+ ", color=" + color + "]";
}
 
}
