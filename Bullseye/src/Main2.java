import java.math.BigInteger;
import java.util.Scanner;

//https://code.google.com/codejam/contest/2418487/dashboard


public class Main2 {
	public static void main(String[] args) {
		BigInteger n, r, t, front, back;

		Scanner input = new Scanner(System.in);
		int numCases = Integer.parseInt(input.nextLine());// 5
		for (int i = 1; i <= numCases; i++) {
			String[] line = input.nextLine().split(" ");
			r = new BigInteger(line[0]);
			t = new BigInteger(line[1]);

			front = BigInteger.ONE;
			back = t.divide(r);
			n = k(front, back, r, t);
			System.out.format("Case #%d: %d", i, n);
			System.out.println();
		}

	}

	private static BigInteger ink(BigInteger x, BigInteger r) {
		// amount of ink needed
		return x.multiply(r.add(x.subtract(BigInteger.ONE)))
				.multiply(BigInteger.valueOf(2)).add(x);
	}

	//use binarySearch
	private static BigInteger k(BigInteger front, BigInteger back,
			BigInteger r, BigInteger t) {
		BigInteger mid = front.add(back).divide(BigInteger.valueOf(2));
		if (ink(mid, r).compareTo(t) <= 0
				&& ink(mid.add(BigInteger.ONE), r).compareTo(t) > 0) {
			return mid;
		} else {
			if (ink(mid, r).compareTo(t) > 0) {
				return k(front, mid, r, t);
			} else if (ink(mid, r).compareTo(t) < 0) {
				return k(mid, back, r, t);
			}
		}
		return BigInteger.ONE;
	}

}
