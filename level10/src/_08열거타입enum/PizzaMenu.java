package _08열거타입enum;

public enum PizzaMenu {

	PP("페페로니피자" , 10000, 0),
	CP("치즈피자", 12000, 0),
	SP("스파이시소세지피자", 14000,2),
	MP("마라피자", 13400, 3),
	HP("하와이안피자",13000,0),
	BP("바베큐피자", 13000,1);
	
	
	private String name;
	private int price;
	private int spicyLevel;
	
	private PizzaMenu(String name, int price, int spicyLevel) {
		this.name = name;
		this.price = price;
		this.spicyLevel = spicyLevel;
	}

	public String getName() {
		return name;
	}


	public int getPrice() {
		return price;
	}


	public int getSpicyLevel() {
		return spicyLevel;
	}

	public void setSpicyLevel(int spicyLevel) {
		this.spicyLevel = spicyLevel;
	}
	
	public String getDesc() {
		String data ="";
		if(spicyLevel >0) {
			data = "🌶️".repeat(spicyLevel); 
		}
		return String.format("%s %s원 %s",name,price, data);
	}

	public static PizzaMenu getMenu(String name) {
		
		for(PizzaMenu pizza : PizzaMenu.values() ) {
			if(name.equals(pizza.getName())) {
				return pizza;
			}
		}
		
		
		return null;
	}
	
	
	
}