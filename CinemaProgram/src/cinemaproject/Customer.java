/**
 * 
 */
package cinemaproject;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Marcio
 *
 */
public class Customer implements CustomerInterface{
	
	BufferedReader brc = new BufferedReader(new InputStreamReader(System.in));
    static int age;
    static String name;
    
	    @Override
	    public void getCustomerName () { //gets the user input name and prints to the screen 
    	
	    	System.out.println("\nType your full name:");
    	
		    	try {
		    		
		  	    	name = brc.readLine();
		  	    	System.out.println("\nCustomer name: " + name);
		
		  	    } catch (Exception e) {}
  	      
    	
	    }
	    @Override
		public void getCustomerAge(){ //gets the user input age and prints to the screen 
		
	    	System.out.println("\n<<Ticket price 10€ (each)>>\n\n"
	                       	   +"  0-12   - years old  (40% discount)\n"
	                       	   +" 13-64   - years old  (normal price)\n"
	                       	   +" over 65 - years old  (20% discount)\n"
	                       	   +"\nType your age:");
	    
			    try {
		
			    	age = Integer.parseInt(brc.readLine());
			    	System.out.println("Customer(s) age: " + age);
		
			    } catch (Exception e) {System.err.print("Not found, type the right value\n");}
	    
	    

	    }
	
    
}
