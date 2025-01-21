package _08열거타입enum;

public class PizzaStore {

	PizzaMenu[] menues = PizzaMenu.values();
	
	void printAllMenus() {
		for(PizzaMenu pizza : menues) {
			System.out.println(pizza);
		}
	}
	
	void takeOrder(String name) {
		PizzaMenu menu = PizzaMenu.getMenu(name);
		if(menu == null) {
			System.out.println("해당 피자는 존재하지않습니다");
			return;
		}
		
		System.out.println(name+"는 " + menu.getPrice() +"원입니다~");
		
	}
	
}