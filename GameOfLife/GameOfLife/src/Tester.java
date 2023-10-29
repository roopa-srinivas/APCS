
public class Tester {
	public static void main(String[] args) {
		Life test = new Life("testinputs/life100.txt");
		Life answer = new Life("testinputs/life100answer.txt");
		
		test.step(5);
		System.out.println("---");
		System.out.print(test);
		System.out.println("---");
		
		System.out.println("");
		boolean[][] identical = isIdentical(test, answer);
		for (int i = 0; i < identical.length; i++) {
			for (int j = 0; j < identical[0].length; j++) {
				if (identical[i][j] == true) {
					System.out.print("t");
				} else {
					System.out.print("f");
				}
			}
			System.out.println();
		}
	}
	
	public static boolean[][] isIdentical(Life life1, Life life2) {
		boolean[][] result = new boolean[life1.getNumRows()][life1.getNumCols()];
		
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				result[i][j] = (life1.grid[i][j] == life2.grid[i][j]);
			}
		}
		return result;
	}
}
