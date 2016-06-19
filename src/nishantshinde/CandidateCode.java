package nishantshinde;
import java.util.Arrays;

public class CandidateCode {

	public static int maxTreeDestroyed(int input1, int input2, int input3, String input4) {

		// Check invalid inputs
		if (input1 < 1 || input1 > 100 || input2 < 1 || input2 > 100 || input3 < 3 || input3 > (input1 * input2)) {
			return -1;
		}

		int maxLengthPossible = Math.max(input1, input2);

		int[][] field = new int[input1][input2];

		// Initialize field
		int index = 1;
		String s1, s2;
		int i1, i2;
		try {
			for (int i = 0; i < input3; i++) {
				index = input4.indexOf('(', index);
				s1 = input4.substring(index + 1, index = input4.indexOf(',', index));
				s2 = input4.substring(index + 1, index = input4.indexOf(')', index));
				// System.out.println(s1 + " " + s2);
				i1 = Integer.parseInt(s1) - 1;
				i2 = Integer.parseInt(s2) - 1;
				if (i1 < 0 || i1 >= input1 || i2 < 0 || i2 >= input2) {
					return -1;
				}
				field[i1][i2] = 1; // Destroyed
			}
		} catch (Exception e) {
			return -1;
		}

		// printArray(field);
		int length = -1, maxLength = -1;
		int maxRowStep = input1 / 3 + 1;
		int maxColumnStep = input2 / 3 + 1;

		for (int r = 0; r < input1; r++) {
			for (int c = 0; c < input2; c++) {
				if (field[r][c] == 1) { // destroyed
					for (int rs = 0; rs <= maxRowStep; rs++) { // steps row
						for (int cs = -maxColumnStep; cs <= maxColumnStep; cs++) { // steps
																					// column
							if (rs == 0 && cs == 0) {
								continue;
							}
							length = getLength(field, r, c, rs, cs);
							// System.out.println(r + " " + c +" " + rs +" " +
							// cs + " - " + length);
							if (length > maxLength) {
								maxLength = length;
								if (maxLength == maxLengthPossible) {
									return maxLength;
								}
							}
						}
					}
				}
			}
		}

		return maxLength;
	}

	private static int getLength(int[][] field, final int r, final int c, int rs, int cs) {
		int indexr = r + rs;
		int indexc = c + cs;
		int length = 1;
		while (indexr > 0 && indexr < field.length && indexc > 0 && indexc < field[0].length) {
			if (field[indexr][indexc] == 1) { // destroyed
				length++;
			} else { // Not destroyed, invalid path
				return -1;
			}
			indexr += rs;
			indexc += cs;
		}

		rs *= -1;
		cs *= -1;
		indexr = r + rs;
		indexc = c + cs;
		while (indexr > 0 && indexr < field.length && indexc > 0 && indexc < field[0].length) {
			if (field[indexr][indexc] == 1) { // destroyed
				length++;
			} else { // Not destroyed, invalid path
				return -1;
			}
			indexr += rs;
			indexc += cs;
		}

		/// Found a path
		return length;
	}

	@SuppressWarnings("unused")
	private static void printArray(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(Arrays.toString(array[i]));
		}
	}

}
