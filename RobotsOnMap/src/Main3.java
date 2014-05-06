/**
Using other's solution just to see the time limits.
This soln was accepted by JUDGE when it was used during contest.
 */

import java.io.*;
import java.util.*;

public class Main3 {
	static BufferedReader input;

	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new InputStreamReader(System.in));
		int numCases = Integer.parseInt(input.readLine());
		while (numCases-- > 0) {
			int numMapas = Integer.parseInt(input.readLine());
			max = new int[numMapas + 1];
			NodeCount tree = new NodeCount();
			for (int i = 0; i < numMapas; i++)
				tree.traverse(new Mapa().getNode(1));
			tree.findMax(0);
			normalize(max);
			for (int i = 1; i < numMapas + 1; i++) {
				if (i > 1)
					System.out.print(" ");
				System.out.print(max[i]);
			}
			System.out.println();
		}

	}

	static void normalize(int[] data) {
		int best = 0;
		for (int i = data.length - 1; i >= 0; i--) {
			if (best > data[i])
				data[i] = best;
			else if (data[i] > best)
				best = data[i];
		}
	}

	static class Node {
		Node izq, der;
	}

	static class Mapa {
		HashMap<Integer, Node> nodos = new HashMap<Integer, Node>();

		private Node getNode(int x) {
			Node nd = nodos.get(x);
			if (nd == null)
				nodos.put(x, nd = new Node());
			return nd;
		}

		public Mapa() throws IOException {
			int N = Integer.parseInt(input.readLine());
			for (int i = 0; i < N - 1; i++) {
				StringTokenizer stk = new StringTokenizer(input.readLine(), " ");
				Node padre = getNode(Integer.parseInt(stk.nextToken()));
				String lado = stk.nextToken();
				Node hijo = getNode(Integer.parseInt(stk.nextToken()));
				if (lado.equals("L"))
					padre.izq = hijo;
				else
					padre.der = hijo;
			}
		}
	}

	static int[] max;

	static class NodeCount {
		NodeCount izq, der;
		int count;

		void traverse(Node nd) {
			count++;
			if (nd.izq != null) {
				if (izq == null)
					izq = new NodeCount();
				izq.traverse(nd.izq);
			}
			if (nd.der != null) {
				if (der == null)
					der = new NodeCount();
				der.traverse(nd.der);
			}
		}

		void findMax(int height) {
			if (height > max[count])
				max[count] = height;
			if (izq != null)
				izq.findMax(height + 1);
			if (der != null)
				der.findMax(height + 1);
		}
	}
}