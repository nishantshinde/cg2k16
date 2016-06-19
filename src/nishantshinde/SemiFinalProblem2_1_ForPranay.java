package nishantshinde;

public class SemiFinalProblem2_1_ForPranay {

	static int DESTROYED_INDICATOR = -1;
	
	public static int maxTreeDestroyed(int input1, int input2, int input3, String input4) {

		if (	input1 < 1 || input1 > 100 || 
				input2 < 1 || input2 > 100 || 
				input3 < 3 || input3 > (input1 * input2)) {
			return -1;
		}

		int counter = 1, rowIndex, columnIndex, j;
		int[][] trees = new int[input1][input2];
		int longestPathPossible = (input1>input2)?input1:input2;
		String rowString, columnString;

		try {
			for (j=0; j < input3; j++) {
				counter = input4.indexOf('(', counter);
				rowString = input4.substring(counter + 1, counter = input4.indexOf(',', counter));
				columnString = input4.substring(counter + 1, counter = input4.indexOf(')', counter));
				// System.out.println(s1 + " " + s2);
				rowIndex = Integer.parseInt(rowString) - 1;
				columnIndex = Integer.parseInt(columnString) - 1;
				if (rowIndex < 0 || rowIndex >= input1 || columnIndex < 0 || columnIndex >= input2) {
					return -1;
				}
				trees[rowIndex][columnIndex] = DESTROYED_INDICATOR; 
			}
		} catch (Exception e) {
			return -1;
		}

		int maxRowJump = input1 / 2, maxColumnJump = input2 / 2;
		int pathLength = -1, longestPathSoFar = -1;

		for (int row_counter = 0; row_counter < input1; row_counter++) {
			for (int column_counter = 0; column_counter < input2; column_counter++) {
				if (trees[row_counter][column_counter] == DESTROYED_INDICATOR) { 
					for (int row_jump = 0; row_jump <= maxRowJump; row_jump++) { 
						for (int column_jump = -maxColumnJump; column_jump <= maxColumnJump; column_jump++) { 
							if (row_jump == 0 && column_jump == 0) continue;
							pathLength = getMonkeyPathLength(trees, row_counter, column_counter, row_jump, column_jump);
							if (pathLength > longestPathSoFar) {
								longestPathSoFar = pathLength;
								if (longestPathSoFar == longestPathPossible) return longestPathSoFar;
							}
						}
					}
				}
			}
		}
		return longestPathSoFar;
	}

	private static int getMonkeyPathLength(int[][] trees, final int row, final int column, int row_step, int column_step) {
		int ir = row + row_step;
		int ic = column + column_step;
		int lengthOfPath = 1;
		while (ir > 0 && ir < trees.length && ic > 0 && ic < trees[0].length) {
			if (trees[ir][ic] == DESTROYED_INDICATOR) {
				lengthOfPath++;
			} else { 
				return -1;
			}
			ir += row_step; ic += column_step;
		}

		row_step *= -1; column_step *= -1;
		ir = row + row_step; ic = column + column_step;
		while (ir > 0 && ir < trees.length && ic > 0 && ic < trees[0].length) {
			if (trees[ir][ic] == DESTROYED_INDICATOR) { // Is the tree destroyed
				lengthOfPath++;
			} else { 
				return -1;
			}
			ir += row_step; ic += column_step;
		}

		return lengthOfPath;
	}

}
