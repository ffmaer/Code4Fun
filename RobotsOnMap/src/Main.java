//http://www.codechef.com/problems/TR2
//timeout the example cases are alright

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	// read input
	// build trees
	// make a map
	// go through trees and fill the map
	// convert the map into useful results
	// return the results

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int numCases = Integer.parseInt(input.nextLine());// 2
		while (numCases-- > 0) {
			// the map <String, Integer>
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			int numMaps = Integer.parseInt(input.nextLine());// 3
			// ith integer denotes the length of the longest valid control
			// string she can obtain assuming she can choose i maps.
			int[] output = new int[numMaps + 1];
			while (numMaps-- > 0) {
				int numCities = Integer.parseInt(input.nextLine());// 5
				Node[] nodes = new Node[numCities];// stores the tree
				// initialization
				for (int i = 0; i < numCities; i++) {
					nodes[i] = new Node();
				}
				// build a tree
				String[] edge;
				int numLines = numCities - 1;
				while (numLines-- > 0) {
					edge = (input.nextLine()).split(" ");
					// city one is stored at nodes[0]
					int parent = Integer.parseInt(edge[0]) - 1;
					int child = Integer.parseInt(edge[2]) - 1;
					if (edge[1].equals("L")) {
						nodes[parent].leftNode = nodes[child];
					} else {
						nodes[parent].rightNode = nodes[child];
					}
				}
				// go through the tree
				Node root = nodes[0];
				String path = "";
				traverse(root, path, map);
			}
			// print out the result
			for (String key : map.keySet()) {
				Integer pathLength = key.length();
				Integer inNumMaps = map.get(key);
				if (pathLength > output[inNumMaps]) {
					output[inNumMaps] = pathLength;
				}
			}
			for (int i = 1; i < output.length; i++) {
				System.out.print(Integer.toString(output[i]));
				// print formatting stuff
				if (i < output.length - 1) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	private static void traverse(Node root, String path,
			HashMap<String, Integer> map) {
		String newPath;
		if (root.leftNode != null) {
			newPath = path + "L";
			if (map.containsKey(newPath)) {
				map.put(newPath, map.get(newPath) + 1);
			} else {
				map.put(newPath, 1);
			}
			traverse(root.leftNode, newPath, map);
		}
		if (root.rightNode != null) {
			newPath = path + "R";
			if (map.containsKey(newPath)) {
				map.put(newPath, map.get(newPath) + 1);
			} else {
				map.put(newPath, 1);
			}
			traverse(root.rightNode, newPath, map);
		}
	}
}

class Node {
	Node leftNode;
	Node rightNode;

	Node() {
		leftNode = null;
		rightNode = null;
	}
}