package tarun.com.arrangements;

public class Middle implements Seats {
	private int seatNo;

	public Middle() {
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
			return String.format("[M-%3d]", seatNo);
		} else {
			return String.format("[M-   ]");
		}
	}

	public void show() {
		System.out.print(this);
	}
}
