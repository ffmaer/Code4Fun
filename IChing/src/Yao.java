
public class Yao{
	
	Coin c1, c2, c3;
	
	public Yao(Coin c1, Coin c2, Coin c3){
		this.c1 = c1;
		this.c2 = c2;
		this.c3 = c3;
	}
	
	public int toss() {
		int result1= c1.headOrTail();
		int result2= c2.headOrTail();
		int result3= c3.headOrTail();
		
		int sum = result1 + result2 + result3;
		
		if(sum == 0){
			return 1; // tail tail tail
		}else if(sum == 1){
			return 0; // tail tail head
		}else if(sum == 2){
			return 1; // head head tail
		}else{ // sum = 3
			return 0; //head head head
		}
		
	}

}
