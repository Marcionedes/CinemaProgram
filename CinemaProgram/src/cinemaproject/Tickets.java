package cinemaproject;

/**
 * @author Marcio
 *
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Date;

public class Tickets implements TicketsInterface{
	
	double ticketPrice= 10;
	double total;
	int tickets;
	BufferedReader brt = new BufferedReader(new InputStreamReader(System.in));
	String[] movies = new String [100];  
    int count = 1; 
	String optionMovie;
	
		@Override
		public void chooseMovie() { // reads the movies.txt file and prints to the user 
			                       // takes the chosen movie by the user and prints the option
			try { 
			
		        System.out.println("\n<<Please choose your movie by typing a number>>\n"); 
		        
	            @SuppressWarnings("resource")
				BufferedReader br = new BufferedReader(new FileReader("C:\\movies.txt"));
				
		        String Line = br.readLine();
		        movies [count] = Line;
		        while(Line!= null){	 	   
		        System.out.println(count + " " + Line);
		        Line = br.readLine();
		        count++;
		        movies[count] = Line;
	            }
	        
		        optionMovie = brt.readLine();
		        optionMovie = movies [Integer.parseInt(optionMovie)];
		        System.out.println("Movie chosen: " + optionMovie);
	 
	        } catch (Exception e) {System.err.print("You can choose a movie by typing a number\n");}
		 
       	
		}
		
		@Override
		public void getTickets() { //gets the user input number of tickets and prints to the screen 
		
			System.out.println("\nType the number of tickets:");

				try {
					
					tickets = Integer.parseInt(brt.readLine());
		            System.out.println("Tickets purchased: " + tickets);
		            
				} catch (Exception e) {System.err.print("Not found, type the right letter\n");}
		     
		}
	
		@Override
		public void movieList() {  // reads the movies.txt file and prints to the user 
			
			try {
				@SuppressWarnings("resource")
				BufferedReader br = new BufferedReader(new FileReader("C:\\movies.txt")); 
				String Line = br.readLine();
		        movies [count] = Line;
		        while(Line!= null){	 	   
		        System.out.println(Line);
		        Line = br.readLine();
		        movies[count] = Line;
		        }
	        
			} catch (Exception e) {} 
	     
		}
		@Override
		public void doCalc() { // based on the user input age applies a discount based on the if statement
		  
			try { 
	
				if(Customer.age > 0 &&  Customer.age <= 12) {
				    total = tickets * ticketPrice / 100 * 60; // takes  40% percentage off 
				    System.out.println("\n<<Your Order>>\n\n"
				    		            +"Name:" + Customer.name + "\n"
				    		            +"Movie:" + optionMovie + "\n"
				    		            +"Number of Tickets:" + tickets + "\n"
				                        +"Total:"+ total +"€"+ "\n");
				    
				} else if (Customer.age > 12 && Customer.age <= 64) {
				    total = tickets * ticketPrice; // normal price 
				    System.out.println("\n<<Your Order>>\n\n"
				    		            +"Name:" + Customer.name + "\n"
				    		            +"Movie:" + optionMovie + "\n"
				    		            +"Number of Tickets:" + tickets + "\n"
				                        +"Total:"+ total +"€"+ "\n");
				    
				} else if (Customer.age > 64 && Customer.age < 200) {
				    total = tickets * ticketPrice / 100 * 80; // takes percentage 20% off
				    System.out.println("\n<<Your Order>>\n\n"
				    		            +"Name: " + Customer.name + "\n"
				    		            +"Movie: " + optionMovie + "\n"
				    		            +"Number of Tickets:" + tickets + "\n"
				                        +"Total: "+ total +"€"+ "\n");
				}
	
	        } catch (Exception e) {} 

		}
		@Override
		public void writeToFile() { // writes to a txt file
		
			try { 
		    		
				 PrintWriter writer = new PrintWriter(new FileWriter("C:\\preorders.txt", true));  
	
				 Date now = new Date();
	
				 writer.println(now.toString());
				 writer.println("Name: " + Customer.name);
				 writer.println("Movie: " + optionMovie);
				 writer.println("Number of tickets: " + tickets);
				 writer.println("Total: " + total + "€");
				 writer.println("--------------------------------------------");
				 writer.close();
	
	        } catch (Exception e) {}
		
		}
	    @Override 
		public void readFromFile() { // reads from a txt file
		
			try { 
				 @SuppressWarnings("resource")
				 BufferedReader br = new BufferedReader(new FileReader("C:\\preorders.txt")); 
				 			
				 String line = br.readLine();
				 while(line!= null){
				 System.out.println(line);
				 line = br.readLine();
				 }
	
		    } catch (Exception e) {}
			 							
	   }
	
}
