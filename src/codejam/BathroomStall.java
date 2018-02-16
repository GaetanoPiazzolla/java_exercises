package codejam;

import java.util.Arrays;
import java.util.List;

public class BathroomStall extends CodeJamGenerics {

	public static final String FILENAME_in = "C:\\workspace\\workspace_exercises\\#java_exercises\\resources\\C-small-practice-1.in";
	public static final String FILENAME_out = "C:\\workspace\\workspace_exercises\\#java_exercises\\resources\\C-small-practice-1.out";

	public static void main(String[] args) {

		List<String> rows = readFile(FILENAME_in);
		rows.remove(0);

		int index = 1;
		for (String row : rows) {
			String[] splitted = row.split(" ");
			String numberOfStalls = splitted[0];
			String numberOfPeople = splitted[1];

			boolean[] stalls = generateArray(Integer.valueOf(numberOfStalls),
					Integer.valueOf(numberOfPeople));
			int max = calculateMax(stalls);
			int min = calculateMin(stalls);
			
			System.out.println("ROW" + index + ": " + row);
			System.out.println("MAX:" + max + " - MIN:" + min);
			index++;
		}

	}

	private static int calculateMin(boolean[] stalls) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static int calculateMax(boolean[] stalls) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static boolean[] generateArray(int numberOfStalls, int numberOfPeople) {

		boolean[] stalls = new boolean[numberOfPeople];
		Arrays.fill(stalls, Boolean.FALSE);
		
		for (int i = 0; i < stalls.length; i++) {
			
		}

		return stalls;
	}

}
