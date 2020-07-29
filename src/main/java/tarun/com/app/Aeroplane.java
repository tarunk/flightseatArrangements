package tarun.com.app;


import tarun.com.arrangements.SeatBooking;
import tarun.com.arrangements.SeatsArrangements;
import tarun.com.config.Configuration;

public class Aeroplane {
	private SeatsArrangements[]seats;
	private int colOfArr;
	private int totalNoOfSeats = 0;
	private int totalNoOfcols = 0;
	private int maxRows = 0;
	
	Aeroplane(int [][]seatArng) {
		int N = seatArng.length;
		colOfArr = N;
		
		seats = new SeatsArrangements[N];
		for (int i = 0; i < N; ++i) {
			seats[i] = new SeatsArrangements(i, seatArng[i][0], seatArng[i][1]);
			if (i == 0) {
				seats[i].setFirst();
			} else if (i == N - 1) {
				seats[i].setLast();
			} else {
				seats[i].setMiddle();
			}
			totalNoOfSeats += seatArng[i][0] * seatArng[i][1];
			totalNoOfcols += seatArng[i][0];
			if (maxRows < seatArng[i][1]) {
				maxRows = seatArng[i][1];
			}
		}
	}
	
	public void defineSeats() {
		for (int i = 0; i < colOfArr; ++i) {
			seats[i].defineSeat();
		}
	}
	
	public SeatsArrangements[] getSeats() {
		return seats;
	}

	public int getMaxRows() {
		return maxRows;
	}
	
	public int getColOfArr() {
		return colOfArr;
	}

	// for debug purpose
	public void fillSeats(int persons) {
		System.out.println("Total no of Seats: " + totalNoOfSeats);
		System.out.println("Total no of cols: " + totalNoOfcols);
		System.out.println("maxRow: " + maxRows);
	}

	public static void main(String[] args) {
		Configuration config = new Configuration();
		int [][]arrangement = config.getArrangements();
		Aeroplane ap = new Aeroplane(arrangement);
		ap.defineSeats();
		SeatBooking sb = new SeatBooking(ap.getSeats(), ap.colOfArr, ap.maxRows);
		sb.arrangeSeats();
		
		for (int i = 1; i <= config.getNoOfQueuePassanger(); ++i) {
			sb.fillSeats(i);
		}
		sb.showSeatsStatus();
	}

}
