package src;

import java.util.concurrent.*;

class MovieTicket{
	
	String seatNumber;
	String movieName;
	boolean isBooked;
	String userEmail;
	
	public MovieTicket(String seatNumber, String movieName, boolean isBooked, String userEmail) {
		
		this.seatNumber = seatNumber;
		this.movieName = movieName;
		this.isBooked = isBooked;
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return "MovieTicket [seatNumber=" + seatNumber + ", movieName=" + movieName + ", isBooked=" + isBooked
				+ ", userEmail=" + userEmail + "]";
	}
	
	
}

class BookTicket implements Callable<String> {
	
	MovieTicket ticket;
	
	BookTicket(MovieTicket ticket){
		this.ticket=ticket;
		
	}
	
	
	
	
	public String call () throws Exception{
		
		//staging dummy payment
		System.out.println("Commencing payment for movie "+ticket.movieName+ ", Seat: " +ticket.seatNumber);
		Thread.sleep(4000);
		
		//Assuming payment went through
		ticket.isBooked=true;
		System.out.println("Ticket has been booked for user "+ticket.userEmail);
		
		
		
		return "Is it booked?:"+ticket.isBooked;
		
	}
}


public class MovieCallableEx {
	

	

	public static void main(String[] args) {
		
		
		System.out.println("Movieapp started");
		
		
		//Create tickets for a movie
		MovieTicket t1= new MovieTicket("A1", "Avengers", false, "john@email.com");
		MovieTicket t2= new MovieTicket("A2", "Avengers", false, "jane@email.com");
		MovieTicket t3= new MovieTicket("A3", "Avengers", false, "rob@email.com");
		MovieTicket t4= new MovieTicket("A4", "Avengers", false, "maria@email.com");
		MovieTicket t5= new MovieTicket("A5", "Avengers", false, "roy@email.com");
		
		//you can use polymorphism with Callable if you want
		Callable<String> task1= new BookTicket(t1);
		Callable<String> task2= new BookTicket(t2);
		BookTicket task3= new BookTicket(t3);
		BookTicket task4= new BookTicket(t4);
		BookTicket task5= new BookTicket(t5);
		
		
		
		ExecutorService service = Executors.newFixedThreadPool(2);
		
		Future<String> f1= service.submit(task1);
		Future<String> f2= service.submit(task2);
		Future<String> f3= service.submit(task3);
		Future<String> f4= service.submit(task4);
		Future<String> f5= service.submit(task5);
		
		try {
			System.out.println("Result of task 1: " +f1.get());
			System.out.println("Result of task 2: " +f2.get());
			System.out.println("Result of task 3: " +f3.get());
			System.out.println("Result of task 4: " +f4.get());
			System.out.println("Result of task 5: " +f5.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Processors " +Runtime.getRuntime().availableProcessors());
		System.out.println("MovieApp finished");
	}

}
