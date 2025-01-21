package _08열거타입enum;

// 열거 타입 enumeration type => 상수 모음집 

enum ButtonMode{
	LIGHT, DARK
}
enum ButtonSpace{
	SINGLE, DOUBlE
}

class Button{
	private ButtonMode buttonMode = ButtonMode.LIGHT;
	private ButtonSpace buttonSpace= ButtonSpace.SINGLE;
	
	public void changeButtonMode() {
		buttonMode = buttonMode == ButtonMode.LIGHT ? ButtonMode.DARK :ButtonMode.LIGHT; 
	}

	public ButtonMode getButtonMode() {
		return buttonMode;
	}

	public ButtonSpace getButtonSpace() {
		return buttonSpace;
	}

	public void setButtonSpace(ButtonSpace buttonSpace) {
		this.buttonSpace = buttonSpace;
	}
	
	
}

public class _01enum개념 {
	static final int num = 5;
	public static void main(String[] args) {
		
		
		Button btn = new Button();
		System.out.println(btn.getButtonMode());
		System.out.println(btn.getButtonSpace());
		
		btn.changeButtonMode();
		System.out.println(btn.getButtonMode());
		btn.setButtonSpace(ButtonSpace.DOUBlE);
		System.out.println(btn.getButtonSpace());

		String day ="MON1";
		
		if(day == "MON") {
			System.out.println("오늘은 월요일입니다");
		}
		
		Week day2 = Week.MON;
		
		if(day2 == Week.MON) {
			System.out.println("오늘은 월요일입니다");
		}
		
		System.out.println(Week.MON);
		
		Week today = Week.THR; 
		
		switch(today) {
		
		case MON: System.out.println("월요일입니다"); break;
		case TUE: System.out.println("화요일입니다"); break;
		case WED: System.out.println("수요일입니다"); break;
		case THR: System.out.println("목요일입니다"); break;
		case FIR: System.out.println("금요일입니다"); break;
		case SAT: System.out.println("토요일입니다"); break;
		case SUN: System.out.println("일요일입니다"); break;
			
		}
		
		
	}
}