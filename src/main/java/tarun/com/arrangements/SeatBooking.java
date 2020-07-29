package tarun.com.arrangements;

import java.util.LinkedList;
import java.util.Queue;


public class SeatBooking {
	private int maxRows;
	private int noOfArng;

	private SeatsArrangements[] seatsArng;
	private Queue<Seats> windowsQ;
	private Queue<Seats> aisleQ;
	private Queue<Seats> middleQ;

	public SeatBooking(SeatsArrangements[] seatsArng, int arrCols, int maxrow) {
		this.seatsArng = seatsArng;
		this.noOfArng = arrCols;
		this.maxRows = maxrow;

		windowsQ = new LinkedList<>();
		aisleQ = new LinkedList<>();
		middleQ = new LinkedList<>();
	}

	public void arrangeSeats() {
		for (int row = 0; row < maxRows; ++row) {
			for (int index = 0; index < noOfArng; ++index) {
				seatsArng[index].addAisle(row, aisleQ);
			}
		}

		for (int row = 0; row < maxRows; ++row) {
			for (int index = 0; index < noOfArng; ++index) {
				seatsArng[index].addWindows(row, windowsQ);
			}
		}

		for (int row = 0; row < maxRows; ++row) {
			for (int index = 0; index < noOfArng; ++index) {
				seatsArng[index].addMiddle(row, middleQ);
			}
		}
	}

	public void fillSeats(int number) {
		if (!aisleQ.isEmpty()) {
			Seats a = aisleQ.poll();
			a.setSeatNo(number);
		} else if (!windowsQ.isEmpty()) {
			Seats a = windowsQ.poll();
			a.setSeatNo(number);
		} else if (!middleQ.isEmpty()) {
			Seats a = middleQ.poll();
			a.setSeatNo(number);
		}
	}

	public void showSeatsStatus() {
		for (int row = 0; row < maxRows; ++row) {
			for (int index = 0; index < noOfArng; ++index) {
				seatsArng[index].show(row);
				if (index != noOfArng - 1) {
					System.out.print(" <--> ");
				}
			}
			System.out.println(" ");
		}
	}

}
