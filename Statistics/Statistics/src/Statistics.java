import java.util.Arrays;

public class Statistics {

	public static void main(String[] args) {
		// Create a DataSet object
		DataSet data = new DataSet();
		// Call the readData method to get data from the file
		data.readData("data\\numbers3.txt");
		// Optionally, print the DataSet object to validate that data was read correctly
		System.out.println(data.toString());
		// Compute statistics and print the results
		
		System.out.println(data.findAverage());
		System.out.println(Arrays.toString(data.findModes()));
		System.out.println(data.findStandardDeviation());
		
		data.removeVal(0);	
		
		System.out.println(data.toString());
		System.out.println(data.findAverage());
		System.out.println(Arrays.toString(data.findModes()));
		System.out.println(data.findStandardDeviation());
	}

}
