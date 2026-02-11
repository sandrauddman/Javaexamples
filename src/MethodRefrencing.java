package src;

//Functional interface means that the interface only have one method in it. 
@FunctionalInterface
interface Register{
	void register();
	
}


@FunctionalInterface
interface Login{
	void login(String name, String password);
}
@FunctionalInterface
interface Taxes{
	double getAmount(double amount);
}

class Authentication{
	
	static void registerUser() {
		System.out.println("User is beeing registred ....");
	}

	void loginUser(String userName, String password) {
		if(userName.equals("Sandra") && password.equals("pass123")) {
			System.out.println("User login successful");
		}else {
			System.out.println("User login failed");
		}
	}
	double getFinalAmount(double amount) {
		return amount-= amount*0.18;
	}
}

class BookMovieTicket{
	static void bookTicket() {
		System.out.println(" 1. please pay 200");
		System.out.println(" 2. Ticket for movie booked");
		System.out.println(" 3. Email confirmation sent");
	}
}

class Message{
	Message(String text, String phonenumber){
		System.out.println("thank you");
		System.out.println("message has been setn to phonenumber: "+phonenumber);
		
	}
}

interface Notification{
	void notifi(String message, String phone);
}



public class MethodRefrencing {

	public static void main(String[] args) {
		
		//anonymous class By lambda expression that uses the interface Register. The body is used as the declared method for using interface Register
		Register ref= ()->{
			System.out.println("user is being registered ...");
			
		};
		ref.register();
		
		//Example of static method referencing. the body of registerUser is used to declare the register method from the interface Register  
		Register ref2= Authentication::registerUser;
		ref2.register();
		
		// error -> Login log= Authentication::loginUser;  
		//the method is not static so w can't refer to it via the class name, we need an object instance.
		
		//Creating object and then use the object for non static method referencing. 
		Authentication auth= new Authentication();
		Login log= auth::loginUser;
		log.login("Sandra","pass123");
		
		//You can also create the instance of the object directly inine with a polymorphic statement
		Taxes tax= new Authentication()::getFinalAmount;
		System.out.println("Final amount to pay :" +tax.getAmount(2000));
		
		//Possible to do this with the runnable class, the method refrence will be refrering to the run method.
		Runnable th1= BookMovieTicket::bookTicket; 
		new Thread(th1).start();
		
		//since the constructor has the same amount of argument(same signature) we can create a method reference to the contructor.
		Notification not= Message::new;
		not.notifi("message...", "+46 25852888556");

		
		
		
	}

}
