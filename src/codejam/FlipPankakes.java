package codejam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FlipPankakes extends CodeJamGenerics {

	public static final String FILENAME_in = "C:\\workspace\\workspace_exercises\\#java_exercises\\resources\\A-small-practice.in";
	public static final String FILENAME_out = "C:\\workspace\\workspace_exercises\\#java_exercises\\resources\\A-small-practice.out";

	public static void main(String[] args) throws Exception {

		List<String> readFile = readFile(FILENAME_in);

		int totalNumber = Integer.valueOf(readFile.get(0));

		// test count sign
		/*
		 * System.out.println(countSign("arr",'a'));
		 * System.out.println(countSign("aaarrraa",'a'));
		 * System.out.println(countSign("arraaarrraa",'a'));
		 * System.out.println(countSign("raaaa",'a'));
		 */

		// test sign recursive

		for (int i = 1; i < totalNumber; i++) {
			String row = readFile.get(i);
			String[] splitted = row.split(" ");
			String rowEvaluated = valuateRow(splitted[0], Integer.valueOf(splitted[1]));
			System.out.println("case" + i + ": " + rowEvaluated);
			System.out.println("");
			System.out.println("");
		}

	}

	private static String valuateRow(String row, int paletteSize) {

		int iterations = 0;
		int bestFlipIndex = 0;

		System.out.println("Dimensione Paletta: " + paletteSize);
		System.out.println("Dimensione riga: " + row.length());
		System.out.println("#Iterazione" + iterations + ": " + row);

		if (paletteSize > row.length()) {
			return "paletta troppo grossa";
		}

		for(int i=0; i<= row.length()-paletteSize; i++) {
			
			
		}

		return String.valueOf(iterations) + " Iterazioni necessarie";

	}

	// flip da fare per forza
	/*
	 * if (countSign(stringFlipped, '+') - countSign(row, '+') == paletteSize) {
	 * indexToReturn = index; combinationsEvaluated.add(stringFlipped); break; }
	 */

	private static int valuateNumberOfIterationForFlipInThisIndex(String row, Set<String> combinationsEvaluated,
			int paletteSize, int index, int iterations) {

		Map<Integer, Integer> mapIndex_numOfIterationToFinish = new HashMap<Integer, Integer>();

		while (index + paletteSize <= row.length()) {
			
			
			String stringFlipped = flip(row, index, paletteSize);
			combinationsEvaluated.add(stringFlipped);
			iterations++;

			// flip non gia valutato
			if (!combinationsEvaluated.contains(stringFlipped)) {
				mapIndex_numOfIterationToFinish.put(index, valuateNumberOfIterationForFlipInThisIndex(stringFlipped,
						combinationsEvaluated, paletteSize, index, iterations));

			}
			index++;
		}

		int minimum = 100;
		int indexOfMin = 0;
		for (Integer loop : mapIndex_numOfIterationToFinish.keySet()) {
			if (minimum > mapIndex_numOfIterationToFinish.get(loop)) 
			{
				minimum = mapIndex_numOfIterationToFinish.get(loop);
				indexOfMin = loop;
			}
		}
		return indexOfMin;
	}

	// questa e' merda...
	private static boolean isAllPlus(String row) {
		String plusRow = row.replaceAll("-", "+");
		if (row.compareTo(plusRow) == 0)
			return true;
		return false;
	}
	
	private static boolean isAllPlus2(String row) {
		return row.indexOf('-') == -1 ? true : false;
	}

	private static int countSign(String inputString, char sign) {
		return countSignRecursive(inputString, sign, 0, 0);
	}

	private static int countSignRecursive(String inputString, char sign, int numberOfOccurrences, int index) {
		index = inputString.indexOf(sign, index);
		if (index == -1)
			return numberOfOccurrences++;
		else {
			return countSignRecursive(inputString, sign, ++numberOfOccurrences, ++index);
		}
	}

	// torna il numero piu grande di adiacenze del carattere nella stringa
	private static int countAdiacentSign(String inputString, char sign) {

		int toReturn = 1;
		List<Integer> adiacences = new ArrayList<Integer>();
		adiacences.add(toReturn);
		for (int i = 0; i < inputString.length() - 1; i++) {
			if (inputString.charAt(i) == sign && inputString.charAt(i + 1) == sign) {
				toReturn++;
				adiacences.add(toReturn);
			} else {
				toReturn = 1;
			}
		}

		return Collections.max(adiacences);
	}

	

	private static String flip(String stringToFlip, int position, int paletteSize) {

		StringBuilder builder = new StringBuilder(stringToFlip);
		for (int i = position; i < position + paletteSize; i++) {
			if (stringToFlip.charAt(i) == '+') {
				builder.replace(i, i + 1, "-");
			} else if (stringToFlip.charAt(i) == '-') {
				builder.replace(i, i + 1, "+");
			}

		}
		return builder.toString();
	}

}
