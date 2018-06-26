/**
 * 
 */
package cinemaproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Marcio
 *
 */
class Menu {
	
	Customer c2 = new Customer(); // Customer.Class instantiation
	Tickets t2 = new Tickets (); // Tickets.Class instantiation
	BufferedReader brm = new BufferedReader(new InputStreamReader(System.in));
	String optionMenu;
	
    	public void welcomeMessage() { // prints the welcome message to the user 
		
    		System.out.println("Welcome to Cinemax\n");
		
    	}
	
    	public void chooseMenuOptions() { // based on the user input calls the methods from the other classes
		
    		System.out.println("<<Choose the following options>>\n\n"
    				      + "[a] See the movies list\n"
				          + "[b] Make a new order\n"
				          + "[c] View previous orders\n"
				          + "[d] Quit the program");
		
    			try {
		   
    				optionMenu = brm.readLine();
	
			        if(optionMenu.equalsIgnoreCase("a")) {
			        	t2.movieList();
			    	    quitProgram();
				
			        } else if (optionMenu.equalsIgnoreCase("b")) {
			        	 t2.chooseMovie();
				    	 c2.getCustomerName();
				    	 c2.getCustomerAge();
				    	 t2.getTickets();
				    	 t2.doCalc();
				    	 t2.writeToFile();
				    	 quitProgram();
			    	    
			        } else if (optionMenu.equalsIgnoreCase("c")) {
			        	 t2.readFromFile();
				    	 quitProgram();
			        	    
			        } else if (optionMenu.equalsIgnoreCase("d")) {
			    	    quitProgram();
				   
			        } else {
			    	    System.err.print("Not found, type the right letter\n");
			    	    chooseMenuOptions();
			    	   
			    	   }
	   
    			} catch (IOException e) {}
	
    	}
	
    	public void quitProgram() { // closes the program 
    	
    		System.out.println("\nWould like to close the program?\n"
		                 + "[y] Yes / [n] No");
    	
		    	try {
		    		
					optionMenu = brm.readLine();
					
					if (optionMenu.equalsIgnoreCase("y")) {
						 System.out.println("Thank you for using Cinemax, " + Customer.name);
						 System.exit(0);
						
					} else if (optionMenu.equalsIgnoreCase("n")) {
						chooseMenuOptions();
						
					} else {
						System.err.print("Not found, type the right letter\n");
						quitProgram();
						
						}
				
			} catch (IOException e) {}
    	
    	
       }
}
