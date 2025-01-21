package _08열거타입enum;

class Button2{
	
	enum Mode{
		LIGHT, DARK
	};
	enum Space{
		SINGLE, DOUBlE
	};
	
	private Mode mode = Mode.LIGHT;
	private Space space= Space.SINGLE;
	
	public void changeMode() {
		mode = mode == Mode.LIGHT ? Mode.DARK :Mode.LIGHT; 
	}

	public Mode getMode() {
		return mode;
	}

	public Space getSpace() {
		return space;
	}

	public void setSpace(Space Space) {
		this.space = Space;
	}
	
	
}


public class _02enum개념2 {

	public static void main(String[] args) {
		
		Button2 btn = new Button2();
		System.out.println(btn.getMode());
		System.out.println(btn.getSpace());
		btn.setSpace(Button2.Space.DOUBlE);
		System.out.println(btn.getSpace());
		
	}
}