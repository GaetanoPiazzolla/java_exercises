package codejam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class CodeJamGenerics {
	protected static List<String> readFile(String FILENAME_in) {
		List<String> result = new ArrayList<String>();
		BufferedReader stream = null;
		try {
			Reader input = new FileReader(FILENAME_in);
			stream = new BufferedReader(input);
			String row = null;
			while ((row = stream.readLine()) != null) {
				result.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stream != null)
					stream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	protected static List<Long> readFileLong(String FILENAME_in) {
		List<Long> result = new ArrayList<Long>();
		BufferedReader stream = null;
		try {
			Reader input = new FileReader(FILENAME_in);
			stream = new BufferedReader(input);
			String row = null;
			while ((row = stream.readLine()) != null) {
				result.add(Long.valueOf(row));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stream != null)
					stream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
