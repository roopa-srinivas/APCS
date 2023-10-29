public class RecursionPractice {
	
	private static int iterations;
	
	public static int factorial (int n) {
		if (n >= 1) {
			return n*factorial(n-1);
		}
		else {
			return 1;
		}
	}


	public static int squareNumber(int n) {
		if (n >= 1) {
			return squareNumber(n-1) + (2*n) -1;
		}
		else {
			return 1;
		}
	}


	public static int logBase2(int n) {
		if (n >= 1) {
			return 1 + logBase2(n/2);
		}
		else {
			return 1;
		}
	}


	public static int pow(int n) {
		if (n>=1) {
			return 2*pow(n-1);
		}
		else {
			return 1;
		}
	}


	public static int pentagonalNumber(int n) {
		if (n>=1) {
			return 1+3*(n-1)+pentagonalNumber(n-1);
		}
		else {
			return 0;
		}
	}
	
	public static int findTriangle(int n) {
		if (n >= 1) {
			return n+findTriangle(n-1);
		}
		else {
			return 0;
		}
	}

	public static int findPyramid(int n) {
		if (n >= 1) {
			return findTriangle(n) + findPyramid(n-1);
		}
		else {
			return 0;
		}
	}
	
	public static int fibonacciSequence(int n) {
		iterations++;
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return fibonacciSequence(n-1) + fibonacciSequence(n-2);
		}
	}
	
	public static int fibonacciSequenceLooping(int n) {
		int t1 = 0;
		int t2 = 1;
		int sum = 0;

        for (int i = 1; i <= n; i++)
        {
        	iterations++;
        	sum = t1 + t2;
            t1 = t2;
            t2 = sum;
        }
        return sum;
	}



	public static void main(String[] args) {
		for (int i = 1; i <= 10; i+=1) {
			iterations = 0;
			long start = System.nanoTime();
			int test = fibonacciSequenceLooping(i);
			long end = System.nanoTime();
			System.out.println("Output was " + test + " and it took " + (end-start) + " nanoseconds, and it took " + iterations + " iterations");
		}
	}


}