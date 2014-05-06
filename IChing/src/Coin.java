import java.util.Random;


public class Coin {
	public int headOrTail(){
		Random rnd = new Random();
		float result = rnd.nextFloat();
		if(result > 0.5){
			return 1; //head
		}
		else{
			return 0; //tail
		}
	}
}
