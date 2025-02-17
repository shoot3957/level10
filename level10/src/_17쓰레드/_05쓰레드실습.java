package _17쓰레드;

import java.text.SimpleDateFormat;
import java.util.Scanner;

class InputMachine implements Runnable { // 입력기

	private Scanner scan = new Scanner(System.in);

	public static char input;

	public InputMachine() {
		System.out.println("input");
	}

	@Override
	public void run() {
		System.out.println(">>>>");
		while (true) {
			input = scan.next().charAt(0);

			if (input == 'q') {
				scan.close();
				return;
			}
		}
	}
}

class StopWatch implements Runnable { // 시간을 출력, 입력값에 따른 동작 제어

	private SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
	private int time; // 소요시간 초 출력하는 타임
	public StopWatch() {
		System.out.println("stopWatch");
	}

	@Override
	public void run() {
		System.err.println("[q] quit [h] hold [x] return");
		while(true) {
			
			if(InputMachine.input != 'h' && InputMachine.input != 'q') {
				long preTime = System.currentTimeMillis();
				System.out.printf("%s [%d sec]\n", sdf.format(preTime), ++this.time);
			}
			if(InputMachine.input == 'q') {
				System.out.printf("소요시간 : %d분 %d초 \n", this.time/60, this.time%60);
				return;
			}			
			if(InputMachine.input == 'h') {
				
			}			
			if(InputMachine.input == 'x') {
				System.out.println("강제 종료");
				return;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

public class _05쓰레드실습 {
	public static void main(String[] args) {

		new Thread(new InputMachine()).start();
		new Thread(new StopWatch()).start();

	}
}