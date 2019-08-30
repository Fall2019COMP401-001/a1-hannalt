package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		/* These first few lines create the arrays that the information will be stored in
		 * Each Customer will have one specific index so that the of information 
		 * pertaining to that one customer can be found at that index in the array that is 
		 * holding the information needed.
		 */
		int numberOfCustomers = s.nextInt();
		String[] firstNames = new String[numberOfCustomers];
		String[] lastNames = new String[numberOfCustomers];
		double[] totals = new double[numberOfCustomers];
		
		/* This for loop adds each customer's first name and last name to the respective 
		 * arrays at that customer's index. numberOfItems is also specific to the customer
		 * but it does not need to be saved, thus it is initialized every time we go through
		 * the for loop.
		 */
		for (int i = 0; i < numberOfCustomers; i++){
			firstNames[i] = s.next();
			lastNames[i] = s.next();
			int numberOfItems = s.nextInt(); 
			
			/* This for loop creates the total for each customer. It is repeated for every item.
			 * nameOfThisJItem is not necessary for the code, but because it is an input it 
			 * is a crucial part of the code.
			 */
			for (int j = 0; j < numberOfItems; j++) {
				double numberOfThisJItem = s.nextDouble();
				String nameOfThisJItem = s.next();
				double costOfThisJItem = s.nextDouble();
				totals[i] = totals[i] + (numberOfThisJItem * costOfThisJItem);
			}
		}
		
		// This prints the output for each customer.
		for (int i = 0; i < firstNames.length; i++) {
			System.out.println(firstNames[i].charAt(0) + ". " + lastNames[i] + ": " + String.format("%.2f", totals[i]));
		}
		
	}

}
