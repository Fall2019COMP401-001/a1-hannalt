package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		/* This sets up the arrays where information about items will be storied. 
		 * Each item will have a specific index in every array that stores information 
		 * about that item. 
		 */
		int numberOfItems = s.nextInt();
		String[] namesOfItems = new String[numberOfItems];
		double[] pricesOfItems = new double[numberOfItems];
		int[] numberOfEachItem = new int[numberOfItems];
		int[] numberOfEachCustomer = new int[numberOfItems];
		
		/* This for loop adds the names and prices of each item to the respective
		 * arrays at their specific indices.
		 */
		for (int i = 0; i < numberOfItems; i++) {
			namesOfItems[i] = s.next();
			pricesOfItems[i] = s.nextDouble();
		}
		
		/* This section sets up the arrays that will store information about customers. 
		 * Each customer will have a specific index in each array that will store their
		 * information.
		 */
		int numberOfCustomers = s.nextInt();
		String[] firstNames = new String[numberOfCustomers];
		String[] lastNames = new String[numberOfCustomers]; 
		int[] numberOfItemsBought = new int[numberOfCustomers];
		
		/* This for loop adds information about the customers to the arrays at the 
		 * customer's specific index.
		 */
		for (int i = 0; i < numberOfCustomers; i++) {
			firstNames[i] = s.next();
			lastNames[i] = s.next();
			numberOfItemsBought[i] = s.nextInt();
			
			/* This for loop works to count the number of customers who bought an item
			 * and how many times an item was bought.
			 */
			for (int j = 0; j < numberOfItemsBought[i]; j++) {
				// This line is not working.
				int numberOfJItem = s.nextInt();
				for (int k = 0; k < numberOfItems; k++) {
					String nameOfItem = s.next();
					if (nameOfItem.contentEquals(namesOfItems[k])) {
						numberOfEachItem[k] = numberOfEachItem[k] + numberOfJItem;
						// I don't think this next line will work
						numberOfEachCustomer[k] = numberOfEachCustomer[k] + 1;
					}
				}
			}
		}
		
		// This will print the output.
		for (int i = 0; i < namesOfItems.length; i++) {
			if (numberOfEachCustomer[i] == 0) {
				System.out.println( "No customers bought " + namesOfItems[i]);
			} else {
				System.out.println( numberOfEachCustomer[i] + " customers bought " + numberOfEachItem[i] + " " + namesOfItems[i]);
			}
		}
		
	}
}
