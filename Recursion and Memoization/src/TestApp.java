import java.util.HashMap;
import java.util.Map;

public class TestApp {

	static Map<String, Integer> cache = new HashMap<>(); //here we are creating cache memory which stores "key-value" pair
	
	
	public static void main(String[] args) {
		
		int row = 6; //till this row we get pascal triangle
		
		//outer loop is used to iterate Rows 
		for(int i=1; i<=row; i++)
		{
			//inner loop is used to iterate columns(elements) of particular row
			for(int j=1; j<=i; j++)
			{
				int result  = element(i, j); //here we are getting element of particular row and column 
				System.out.print(result + " ");
			}
			System.out.println();
		}
		

	}
	
	public static int element(int row, int column)
	{
		String key = row + "," + column; //5,3 (we generating key here)
		
		if(column == 1 || column == row)
			return 1;
		
		
		if(cache.containsKey(key)) //here we are checking if particular key is present in cache memory
			cache.get(key); // here we are getting value of a key from cache
		
		int element = element(row-1,column-1) + element(row-1,column); //here we are getting element using recursion method 
		
		cache.put(key, element); //here we are inserting value to cache with particular key
		
		return element; // element(5,3)  =  element(4,2) + element(4,3)
	} 

}
