package shopingWebsite;

//Creating InsufficientBalenceException

class InsufficientBalenceException extends Exception{
	public InsufficientBalenceException(String msg) {
		super(msg);
	}
}

//Creating OutOfStockException
class OutOfStackException extends Exception{
	String msg;

	public OutOfStackException(String msg) {
		super(msg);
		
	}
	
}

//Customer Details

class Customer{
	int id;
	String name;
	int walletBalence;
	String address;
	public Customer(int id, String name, int walletBalence, String address) {
		super();
		this.id = id;
		this.name = name;
		this.walletBalence = walletBalence;
		this.address = address;
	}
	
	
}
class Item{
    int id;
    String name;
    String companyName;
    boolean inStack;
    int price;
	public Item(int id, String name, String companyName, boolean inStack , int price) {
		super();
		this.id = id;
		this.name = name;
		this.companyName = companyName;
		this.inStack = inStack;
		this.price = price;
	}
}

//Exception

class ShopingException{
	public String purchaseItem(Item i , Customer c) throws InsufficientBalenceException,OutOfStackException {
		if(!i.inStack) {
			throw new OutOfStackException("Out Of Stack");
		}
		else if (i.price > c.walletBalence) {
			throw new InsufficientBalenceException("Insuccifient Balence");
		}
		else {
			return "Order Succesfull!";
		}
	}
}


public class ShopingWebsite {

	public static void main(String[] args) {
		Customer c = new Customer(01, "vinay", 5000, "Hyderabad");
		Item i = new Item(1, "T-shirt", "MAX", true, 4200);
		ShopingException se = new ShopingException();
      try {
		String obj = se.purchaseItem(i, c);
		System.out.println(obj);
	} catch (InsufficientBalenceException | OutOfStackException e) {
		System.out.println(e.getMessage());
	}
	}

}
