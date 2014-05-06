
public class Generator {
	public static void main(String args[]){
		//3 coins
		//6 times
		Coin c1 = new Coin();
		Coin c2 = new Coin();
		Coin c3 = new Coin();
		
		Yao[] yaos = new Yao[6];
		for(int i=0;i<6;i++){
			yaos[i] = new Yao(c1, c2, c3);
		}
		
		Gua gua = new Gua(yaos);
		System.out.println(gua.name);
		
	}
}
