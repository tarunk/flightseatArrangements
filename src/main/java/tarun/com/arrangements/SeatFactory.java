package tarun.com.arrangements;

public class SeatFactory {
	public static Aisle[][] getAisle(int row, int col) {
		Aisle[][] aisle = new Aisle[row][col];
		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col; ++j) {
				aisle[i][j] = new Aisle();
			}
		}

		return aisle;
	}

	public static Windows[][] getWindows(int row, int col) {
		Windows[][] windows = new Windows[row][col];
		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col; ++j) {
				windows[i][j] = new Windows();
			}
		}

		return windows;
	}

	public static Middle[][] getMiddle(int row, int col) {
		Middle[][] middle = new Middle[row][col];
		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col; ++j) {
				middle[i][j] = new Middle();
			}
		}

		return middle;
	}

}
