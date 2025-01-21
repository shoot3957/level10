package _12콜랙션멤버;

import java.util.Scanner;

public class Utils {
	private Utils() {};
	
	private static Utils instance;
	
	public static Utils getInstance() {
		if(instance == null) instance = new Utils();
		return instance;
	} 
	
	private Scanner sc = new Scanner(System.in);
	private final String CUR_PATH = System.getProperty("user.dir") + "//src//"+Utils.class.getPackageName()+"//";

	public String getCurPath() {
		return CUR_PATH;
	}

	public int getIntValue(String msg, int start, int end) {
		System.out.print(msg);
		int sel = -1;
		try {
			sel = sc.nextInt();
			if(sel < start  || sel > end) {
				System.out.println("범위 오류");
				return -1;
			}
		}catch (Exception e) {
			System.out.println("숫자를 입력해 주세요");
		}
		return sel;
	}
	
	public String getStrValue(String msg) {
		System.out.print(msg);
		return sc.next();
	}
	public void closeScanner() {
		sc.close();
	}
}