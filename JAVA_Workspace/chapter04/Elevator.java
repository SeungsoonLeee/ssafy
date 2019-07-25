package chapter04;

public class Elevator {
	int maxFloor;
	int minFloor;
	int currentFloor;
	boolean isOpen;
	int request;

	public Elevator() {
	}

	public Elevator(int currentFloor, int maxFloor, int minFloor, boolean isOpen) {
		this.maxFloor = maxFloor;
		this.minFloor = minFloor;
		setCurrentFloor(currentFloor);
		this.isOpen = isOpen;
	}

	public int getMaxFloor() {
		return maxFloor;
	}

	public void setMaxFloor(int maxFloor) {
		this.maxFloor = maxFloor;
	}

	public int getMinFloor() {
		return minFloor;
	}

	public void setMinFloor(int minFloor) {
		this.minFloor = minFloor;
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public int getRequest() {
		return request;
	}

	public void setRequest(int request) {
		if (request < this.minFloor || request > this.maxFloor)
			System.out.println("잘못된 층을 요청했습니다.");
		else
			this.request = request;
	}

	public void choose(int Floor) {
		if (this.currentFloor == Floor)
			System.out.println("현재층과 동일한 층입니다.");
		else if (Floor < this.minFloor || Floor > this.maxFloor)
			System.out.println("잘못된 층을 요청했습니다.");
		else {
			this.request = Floor;
			move();
		}
	}

	public void move() {
		if (isOpen)
			close();
		String msg = "올라가고";
		while (true) {
			if (this.currentFloor < this.request) {
				this.currentFloor++;
			} else if (this.currentFloor > this.request) {
				msg = "내려가고";
				this.currentFloor--;
			} else {
				System.out.println(this.request + "층에 도착했습니다.");
				break;
			}
			if (this.currentFloor == 0)
				continue;
			System.out.println(this.currentFloor + "층으로 " + msg + " 있습니다.");
		}
		open();
	}

	public void open() {
		System.out.println("문이 열립니다.");
	}

	public void close() {
		System.out.println("문이 닫힙니다.");
	}
}
