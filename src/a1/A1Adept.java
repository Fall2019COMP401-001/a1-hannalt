package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		/* This part sets up the arrays where information will be stored. Each item will have
		 * a specific index.
		 */
		int numberOfItems = s.nextInt();
		String[] items = new String[numberOfItems];
		double[] prices = new double[numberOfItems];
		
		// This for loop stores the item names and their prices.
		for (int i = 0; i < numberOfItems; i++) {
			items[i] = s.next();
			prices[i] = s.nextDouble();
		}
		
		/* This section sets up the arrays that will store the information for each customer.
		 * Each customer will have a specific array where all the information relating to 
		 * them will be held in each respective array.
		 */
		int numberOfCustomers = s.nextInt();
		String[] firstNames = new String[numberOfCustomers];
		String[] lastNames = new String[numberOfCustomers]; 
		double[] totals = new double[numberOfCustomers];
		
		/* This for loop puts the customers' first and last names into their respective arrays 
		 * at each customers' specific index.
		 */
		for (int i = 0; i < numberOfCustomers; i++) {
			firstNames[i] = s.next();
			lastNames[i] = s.next();
			int numberOfItemsForICustomer = s.nextInt();
			
			// This for loop looks at each item each customer got specifically. 
			for (int j = 0; j < numberOfItemsForICustomer; j++) {
				int numberOfJItem = s.nextInt();
				String nameOfJItem = s.next();
				int idxOfJItem = 0;
				
				/* Uses the number of times the customer bought this specific (or J) Item and then
				 * adds that to the index of that customer in the totals array.
				 */
				for (int k = 0; k < numberOfJItem; k++) {
					
					/* But before we can add the price of the item we have to find it. This for 
					 * loop does that. It goes through the items array to find which index equals
					 * the nameOfJItem string. When it finds this index, it saves that index in 
					 * idxOfJItem. This index is then used to add to the total of this i customer.
					 */
					for (int n = 0; n < numberOfItems; n++) {
						if (items[n].contentEquals(nameOfJItem)) {
							idxOfJItem = n;
							break;
						}	
					}
					totals[i] = totals[i] + prices[idxOfJItem];
				}
			}	
		}
		
		/* This part finds the totals array by comparing the total to the biggest variable. The 
		 * biggest variable is initialized as the smallest value in Java. Once the index of the 
		 * biggest is found it is saved as idxOfBiggest.
		 */
		double biggest = Long.MIN_VALUE;
		int idxOfBiggest = 0; 
		for (int i = 0; i < totals.length; i++) {
			if (totals[i] > biggest) {
				biggest = totals[i];
				idxOfBiggest = i;
			}
		}
		
		/* This part finds the totals array by comparing the total to the smallest variable. The 
		 * smallest variable is initialized as the largest value in Java. Once the index of the 
		 * biggest is found it is saved as idxOfSmallest.
		 */
		double smallest = Long.MAX_VALUE;
		int idxOfSmallest = 0;
		for (int i = 0; i < totals.length; i++) {
			if (totals[i] < smallest) {
				smallest = totals[i];
				idxOfSmallest = i;
			}
		}
		
		/* This part finds the average of the totals. The for loop adds all the totals in the totals array
		 * together and saves it to the variable total. The variable average is then assigned to that total
		 * variable divided by the length of the totals array. 
		 */
		double average = 0;
		double total = 0;
		for (int i = 0; i < totals.length; i++) {
			total = total + totals[i]; 
		}
		average = total / totals.length;
		
		// This section prints the output
		System.out.println( "Biggest: " + firstNames[idxOfBiggest] + " " + lastNames[idxOfBiggest] + " (" + totals[idxOfBiggest] +")");
		System.out.println( "Smallest: " + firstNames[idxOfSmallest] + " " + lastNames[idxOfSmallest] + " (" + totals[idxOfSmallest] +")");
		System.out.println( "Average: " + average);
		
		// Honestly I could have used a class for this and it might have been easier.
		
	}
}
