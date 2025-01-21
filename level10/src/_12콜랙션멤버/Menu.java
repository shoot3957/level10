package _12콜랙션멤버;

public enum Menu {
	INSERT("insert"), DELETE("delete"),UPDATE("update"),PRINT("print"),
	SAVE("save"),LOAD("load");
	
	private String order;
	Menu(String order){
		this.order = order;
	}
	public String getOrder() {
		return order;
	}
	static Menu getMenu(String name) {
		for(Menu menu : Menu.values())
			if(name.equals(menu.getOrder()))
				return menu;
		return null;
	}
}