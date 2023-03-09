// Synchronized 사용 예 
// 공유 집계판 사례를 코딩 

public class SynchroonizedEx {
	public static void main(String[] args) {
		SharedBoard board = new SharedBoard();
		Thread th1 = new StudentThread("Kitae", board);
		Thread th2 = new StudentThread("hyosoo", board);
		th1.start();
		th2.start();
	}
}

//class SharedBoard {
//	private int sum = 0;		// 집계판의 합 
//	synchronized public void add() {
//		int n = sum;
//		Thread.yield(); 		// 현재 실행중인 스레드 양보 
//		n += 10; 				// 10 증가 
//		sum = n; 				// 증가한 값을 집계합에 기록 
//		System.out.println(Thread.currentThread().getName() + " : " + sum);
//	}
//	public int getSum() {return sum;}
//}

class SharedBoard {
	private int sum = 0;		// 집계판의 합 
	public void add() {
		int n = sum;
		// Thread.yield(); 		// 현재 실행중인 스레드 양보 
		n += 10; 				// 10 증가 
		sum = n; 				// 증가한 값을 집계합에 기록 
		System.out.println(Thread.currentThread().getName() + " : " + sum);
	}
	public int getSum() {return sum;}
}

class StudentThread extends Thread{
	private SharedBoard board; 		// 집계판의 주소 
	public StudentThread(String name, SharedBoard board) {
		super(name);
		this.board = board;
	}
	@Override
	public void run() {
		for(int i = 0; i < 10; i++)
			board.add();
	}
}
