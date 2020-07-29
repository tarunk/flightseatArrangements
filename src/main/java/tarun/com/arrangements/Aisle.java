package tarun.com.arrangements;

public class Aisle implements Seats {
	private int seatNo;

	public Aisle() {
		this.seatNo = 0;
	}

	public int getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}

	@Override
	public String toString() {
		if (seatNo != 0) {
			return String.format("[A-%3d]", seatNo);
		} else {
			return String.format("[A-   ]");
		}
	}
	
	public void show() {
		if (seatNo != 0) {
			System.out.printf(this.toString());
		} else {
			System.out.print(this.toString());
		}
	}
}
