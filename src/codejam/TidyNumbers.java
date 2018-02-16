package codejam;

import java.io.PrintWriter;
import java.util.List;

public class TidyNumbers extends CodeJamGenerics {

	public static final String FILENAME_in = "C:\\workspace\\workspace_exercises\\#java_exercises\\resources\\B-small-practice.in";
	public static final String FILENAME_out = "C:\\workspace\\workspace_exercises\\#java_exercises\\resources\\B-small-practice.out";

	public static final String FILENAME_in_large = "C:\\workspace\\workspace_exercises\\#java_exercises\\resources\\B-large-practice.in";
	public static final String FILENAME_out_large = "C:\\workspace\\workspace_exercises\\#java_exercises\\resources\\B-large-practice.out";

	public static void main(String[] args) throws Exception {

		List<Long> readFile = readFileLong(FILENAME_in_large);
		readFile.remove(0);

		PrintWriter writer = new PrintWriter(FILENAME_out_large);

		int index = 9;
		for (Long row : readFile) {
			index++;

			// shit for large DataSet
			// long tidy = findFirstTidyWithCounter(row);

			long tidy = findFirstTidyChar(row);
			
			//long tidy2 = findFirstTidyWithCounter(row);
			
			System.out.println("ROW: " + row + " TIDY1-dafixare: " + tidy);
			//System.out.println("ROW: " + row + " TIDY2-corretto: " + tidy2);
			//System.out.println(tidy == tidy2 ? "" : "##########################");
			writer.println("Case #" + index + ": " + tidy);
		}

		writer.close();
	}

	private static long findFirstTidyChar(Long row) {
		char[] array = String.valueOf(row).toCharArray();

		int index = 0;
		for (index = 0; index < array.length - 1; index++) {
			if (array[index] > array[index + 1]) {
				array[index] = decrementChar(array[index]);
				for (int i = index+1; i < array.length; i++) {
					array[i] = '9';
				}
				//se e' stato decrementato bisogna controllare anche i precedenti
				index = index <= 1 ? 0 : index-1;
				
				//-1 perche' il ciclo for fa la somma prima di eseguire
				index--;
			}
		}

		return Long.valueOf(new String(array));
	}

	private static char decrementChar(char c) {
		if (c == '9') {
			return '8';
		}
		if (c == '8') {
			return '7';
		}
		if (c == '7') {
			return '6';
		}
		if (c == '6') {
			return '5';
		}
		if (c == '5') {
			return '4';
		}
		if (c == '4') {
			return '3';
		}
		if (c == '3') {
			return '2';
		}
		if (c == '2') {
			return '1';
		}
		if (c == '1') {
			return '0';
		} else {
			throw new NumberFormatException();
		}
	}

	@SuppressWarnings("unused")
	private static long findFirstTidyWithCounter(long bynbe) {
		long i = bynbe;
		while (!isTidy(i)) {
			i--;
		}
		return i;
	}

	private static boolean isTidy(long bynbe) {
		char[] array = String.valueOf(bynbe).toCharArray();
		return isTidy(array);
	}
	
	private static boolean isTidy(char[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i + 1]) {
				return false;
			}
		}
		return true;
	}

}
