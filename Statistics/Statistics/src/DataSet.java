public class DataSet {

	private final int STARTING_SIZE = 50;
	private int[] data;
	private double average;
	private double standardDev;
	private int numValues;
	
	public DataSet() {
		//data = new int[MAX_FILE_SIZE];
		data = new int[STARTING_SIZE];
		average = 0;
		numValues = 0;
		standardDev = 0;
	}
	
	public void readData(String filename) {
		ArrayReader reader = new ArrayReader(filename);
		numValues = reader.fillArray(this);
	}
	
	public String toString() {
		String dataString = "[";
		for (int i = 0; i < numValues; i++) {
			if (i == numValues-1) {
				dataString += data[i];
			} else {
			dataString += data[i] + ", ";
			}
		}
		dataString += "]";
		return dataString;
	}
	
	public double findAverage() {
		average = 0;
		for (int i = 0; i < numValues; i++) {
			average += data[i];
		}
		
		average /= numValues;
		return average;
	}
	
	public int[] findModes() {
		int[] occurrences = new int[numValues];
		int maxCount = 0;
		int count = 0;
		int numOfModes = 0;
		int numOfNums = 0;
		
		for (int i = 0; i < numValues; i++) {
			occurrences[data[i]]++;
		}
		
		for (int i = 0; i < occurrences.length; i++) {
			if (occurrences[i] > maxCount) {
				maxCount = occurrences[i];
				numOfModes = 1;
				continue;
			}
			if (occurrences[i] == maxCount) {
				numOfModes++;
			}
		}
		
		int[] modes = new int[numOfModes];
		
		for (int i = 0; i < occurrences.length; i++) {
			if (occurrences[i] == maxCount) {
				modes[count] = i;
				count++;
			}
		}
		
		return modes;
	}
	
	public double findStandardDeviation() {
		standardDev = 0;
		for (int i = 0; i < numValues; i++) {
			standardDev += Math.pow(data[i] - average, 2); 
		}
		standardDev = standardDev/(numValues-1);
		standardDev = Math.sqrt(standardDev);
		return standardDev;
	}
	
	public int removeVal(int val) {
		int count = 0;
		for (int i = 0; i < numValues; i++) {
			if (data[i] == val) {
				count++;
			} else {
				data[i-count] = data[i];
			}
		}
		numValues -= count;
		return numValues;
	}
	
	public void insert(int val, int i) {
		while (data.length == numValues) {
			resize();
		}
		for (int j = numValues; j >= i; j--) {
		     data[j+1] = data[j];
		}
		data[i] = val;
		numValues++;
	}	
	
	public void add(int val) {
		while (data.length == numValues) {
			resize();
		}
		data[numValues] = val;
		numValues++;
	}
	
	/**
	 * 
	 * @param i index to access - must be (i >= 0 && i < number of values stored)
	 * @return
	 */
	public int get(int i) {
		if (i < 0 || i >= numValues) {
			throw new IllegalArgumentException("index out of bounds");
		}
		return data[i];
	}
	
	/**
	 * 
	 * @param i index to access - must be (i >= 0 && i < number of values stored)
	 * @return
	 */
	public void set(int i, int val) {
		if (i < 0 || i >= numValues) {
			throw new IllegalArgumentException("index out of bounds");
		}
		data[i] = val;
	}
	
	private void resize() {
		int[] tempArray = new int[data.length*2];
		for (int i = 0; i < numValues; i++) {
			tempArray[i] = data[i];
		}
		data = tempArray;
	}
}
