package tarun.com.arrangements;

public class Windows implements Seats {
	private int seatNo;

	public Windows() {
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
			return String.format("[W-%3d]", seatNo);
		} else {
			return String.format("[W-   ]");
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
