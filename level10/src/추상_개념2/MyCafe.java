package 추상_개념2;

public class MyCafe extends MyBrand{
	
	// 테이크아웃점인지 아닌지 
	// 테이크아웃점이 아니면 매장에서 드시겠습니까? 추가하기 
	
	private static int myNum=0;
	private boolean isTakeOut;
	
	
	public MyCafe( String name, boolean isTakeOut) {
		super(++myNum, name);
		this.isTakeOut = isTakeOut;
	}
	
	public static String getSlogan() {
		return String.format(SLOGAN, "연미 커피");
	}

	@Override
	public void takeOrder() {

		System.out.printf("연미 카페 %s 음료를 주문했습니다 \n" , super.info());
		if(!isTakeOut) System.out.println("매장에서 드시겠습니까?");
		
	}
	
	
	

}
