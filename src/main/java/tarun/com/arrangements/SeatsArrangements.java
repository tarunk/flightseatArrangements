package tarun.com.arrangements;

import java.util.Queue;


public class SeatsArrangements {
	private int index;
	private boolean isFirst  = false;
	private boolean isLast   = false;
	private boolean isMiddle = false;
	private int cols;
	private int rows;
	private Seats [][] windows;
	private Seats [][] middle;
	private Seats [][] leftAisle;
	private Seats [][] rightAisle;
	
	
	public SeatsArrangements(int index, int cols, int rows) {
		this.index = index;
		this.cols = cols;
		this.rows = rows;
	}
	
	public void setFirst() {
		this.isFirst = true;
	}
	
	public void setLast() {
		this.isLast = true;
	}
	
	public void setMiddle() {
		this.isMiddle = true;
	}
	
	//for debug purpose
	public String status() {
		if (isFirst) {
			return "FIRST";
		} else if (isLast) {
			return "LAST";
		}
		return "MIDDLE";
	}
	
	public void defineSeat() {
		defineFirstSeats();
		defineLastSeats();
		defineMiddleSeats();
	}
	
	public void addAisle(int row, Queue<Seats> queue) {
		if (row < this.rows && leftAisle != null) {
			queue.add(leftAisle[row][0]);
		}
		
		if (row < this.rows && rightAisle != null) {
			queue.add(rightAisle[row][0]);
		}	
	}
	
	public void addWindows(int row, Queue<Seats> queue) {
		if (row < this.rows && windows != null) {
				queue.add(windows[row][0]);
		}	
	}
	
	public void addMiddle(int row, Queue<Seats> queue) {
		if (row < this.rows && middle != null) {
			for (int i = 0; i < middle[0].length; ++i) {
				queue.add(middle[row][i]);
			}
		}
	}
	
	
	
	public void show(int row) {
		if (row < this.rows) {
			if (this.isFirst) {
				windows[row][0].show();
				showMiddle(row);
				if (rightAisle != null) {
					rightAisle[row][0].show();
				}
			} else if(this.isLast) {
				if (leftAisle != null) {
					leftAisle[row][0].show();
				}
				showMiddle(row);
				windows[row][0].show();
			} else {
				if (leftAisle != null) {
					leftAisle[row][0].show();
				}
				showMiddle(row);
				if (rightAisle != null) {
					rightAisle[row][0].show();
				}
			}
		} else {
			for (int i = 0; i < this.cols; ++i) {
				System.out.print("       ");
			}
		}
	}
	
	private void defineFirstSeats() {
		if (isFirst == true) {
			if (cols == 1) {
				windows = SeatFactory.getWindows(rows, 1);
			} else if (cols == 2) {
				windows = SeatFactory.getWindows(rows, 1);
				rightAisle = SeatFactory.getAisle(rows,  1);
			} else {
				windows = SeatFactory.getWindows(rows, 1);
				rightAisle = SeatFactory.getAisle(rows,  1);
				middle = SeatFactory.getMiddle(rows, cols - 2);
			}
		}
	}
	
	private void defineLastSeats() {
		if (isLast == true) {
			if (cols == 1) {
				windows = SeatFactory.getWindows(rows, 1);
			} else if (cols == 2) {
				windows = SeatFactory.getWindows(rows, 1);
				leftAisle = SeatFactory.getAisle(rows,  1);
			} else {
				windows = SeatFactory.getWindows(rows, 1);
				leftAisle = SeatFactory.getAisle(rows,  1);
				middle = SeatFactory.getMiddle(rows, cols - 2);
			}
		}
	}
	
	private void defineMiddleSeats() {
		if (isMiddle == true) {
			if (cols == 1) {
				leftAisle = SeatFactory.getAisle(rows,  1);
			} else if (cols == 2) {
				leftAisle = SeatFactory.getAisle(rows,  1);
				rightAisle = SeatFactory.getAisle(rows,  1);
			} else {
				leftAisle = SeatFactory.getAisle(rows,  1);
				rightAisle = SeatFactory.getAisle(rows,  1);
				middle = SeatFactory.getMiddle(rows, cols - 2);
			}
		}
	}

	private void showMiddle(int row) {
		if (row < this.rows && middle != null) {
			for (int i = 0; i < middle[0].length; ++i) {
				middle[row][i].show();
			}
		} 
	}
}
