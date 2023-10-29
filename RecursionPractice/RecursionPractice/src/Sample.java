
public class Sample {

	
	
	public static void countDownRecursive(int x) {
		if (x == 0) {  // Base case
			System.out.println(x);
			return;
		} else {  // Recursive case
			System.out.println(x);
			countDownRecursive(x-1);
		}
	}
	
	
	
	public static void countDownLooping(int x) {
		
		for (; x != 0; x = x - 1) {
			System.out.println(x);
		}
		
		System.out.println(x);
		
	}
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		countDownRecursive(7);
	}
	
	

}
