import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Program1 {
	private static Scanner scanner;
	static int findLowIndex (List<Integer> arr, int key) {
	    int low = 0;
	    int high = arr.size() - 1;
	    int mid = high / 2;
	  
	    while (low <= high) 
	    {
	      int mid_elem = arr.get(mid);
	      if (mid_elem < key)
	    	  low = mid + 1;
	      else
	    	  high = mid - 1;
	      mid = low + (high - low) / 2;
	    }

	    if (arr.get(low) == key)
	    	return low;

	    return -1;
	  }

	  static int findHighIndex(List<Integer> arr, int key) {
	    int low = 0;
	    int high = arr.size() - 1;
	    int mid = high / 2;

	    while (low <= high) {
	    	int mid_elem = arr.get(mid);
	    	if (mid_elem <= key)
	    		low = mid + 1;
	    	else
	    		high = mid - 1;
	    	mid = (high + low)/ 2;
	    }
	    if(high == -1)
	    	return high;
	    if (arr.get(high) == key)
	    	return high;

	    return -1;
	  }
	  public static void main(String[] args) throws IOException {
		  File input = new File("/home/pelatro/random.txt");
		  try (Scanner scan = new Scanner(input)) {
			List<Integer> lines = new ArrayList<Integer>();
			  while(scan.hasNextInt())
			  {
			      int num = scan.nextInt();
			      lines.add(num); 
			  }
				System.out.println("Before Sorting :"+ lines);
				Collections.sort(lines); 
				System.out.println("After Sorting :"+ lines);
				while(true) {
					System.out.print("\nEnter Key number :");  
					scanner = new Scanner(System.in);
					int key= scanner.nextInt();  
					if(lines.contains(key)) {
						int low = findLowIndex(lines, key);
						int high = findHighIndex(lines, key);
						System.out.println("Low Index of " + key + ": " + low);
						System.out.println("High Index of " + key + ": " + high);
					}
					else
						System.out.println("Entered key isnt present.");
				}
		  }   
	  }
}
