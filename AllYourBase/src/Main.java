import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

//https://code.google.com/codejam/contest/189252/dashboard#s=p0
public class Main {
	public static void main(String args[]) {
		// find the number of different characters
		// convert the string from highest digit
		// calculate the value of the new string
		Scanner scan = new Scanner(System.in);
		int numCase = Integer.parseInt(scan.nextLine());
		for (int num = 1; num <= numCase; num++) {
			String input = scan.nextLine();
			int base = base(input);
			BigInteger result = calculate(input, BigInteger.valueOf(base));
			System.out.format("Case #%d: %d%n", num, result);
		}

	}

	public static int base(String input) {
		// input: 11001001
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int base = 2;
		for (int i = 0; i < input.length(); i++) {
			String s = input.charAt(i) + "";
			if (!map.containsKey(s)) {
				// char to String
				map.put(s, new Integer(1));
			}
		}
		if (map.size() > 2) {
			base = map.size();
		}
		return base;
	}

	public static BigInteger calculate(String input, BigInteger base) {
		// cats
		// base = 4
		// 1023
		// 3 + 2*4 + 0 * 4^2 +1 * 4^3 = 64 + 8 + 3 = 75
		// covert the highest digit to 1
		// find the next digit that hasn't been converted yet
		// convert that to 0
		// convert the next digit to 2, 3

		BigInteger sum = BigInteger.ZERO;
		BigInteger power = BigInteger.valueOf(input.length() - 1);

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		Integer toDigit = 1;
		for (int i = 0; i < input.length(); i++) {

			String s = input.charAt(i) + "";

			if (!map.containsKey(s)) {
				map.put(s, toDigit);
				if (toDigit.equals(1)) {
					toDigit = 0;
				} else if (toDigit.equals(0)) {
					toDigit = 2;
				} else {
					toDigit++;
				}
			}

			sum = sum.add(BigInteger.valueOf(map.get(s)).multiply(
					pow(base, power)));

			power = power.subtract(BigInteger.valueOf(1));

		}
		return sum;

	}

	private static BigInteger pow(BigInteger base, BigInteger exponent) {
		BigInteger result = BigInteger.ONE;
		while (exponent.signum() > 0) {
			if (exponent.testBit(0))
				result = result.multiply(base);
			base = base.multiply(base);
			exponent = exponent.shiftRight(1);
		}
		return result;
	}

}
