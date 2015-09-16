package Shortest_Word_Distance;

import java.util.ArrayList;
import java.util.HashMap;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		String word1 = "coding";
		String word2 = "practice";
		System.out.println(q.shortestDistance(words, word1, word2));

	}
	
	/**
	 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

		For example,
		Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
		
		Given word1 = "coding", word2 = "practice", return 3.
		Given word1 = "makes", word2 = "coding", return 1.
		
		Note:
		You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
	 */
	
	//yelong's way : two pointers. NB!
	public int shortestDistance(String[] words, String word1, String word2) {
		if (words == null || words.length <= 1) {
			return Integer.MAX_VALUE;
		}
		int len = words.length;
		int p1 = -1;
		int p2 = -1;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < len; i++) {
			if (words[i].equals(word1)) {
				p1 = i;
			} else if (words[i].equals(word2)){
				p2 = i;
			}
			if (p1 != -1 && p2 != -1) {
				min = Math.min(min, Math.abs(p1 - p2));
			}
		}
		return min;
	}
	
	//my way: hashmap(can be used directly in Shortest_Word_Distance_II)
	public int shortestDistance2(String[] words, String word1, String word2) {
		if (words == null || words.length <= 1) {
			return Integer.MAX_VALUE;
		}
		HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			if (map.containsKey(word)) {
				map.get(word).add(i);
			} else {
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(i);
				map.put(word, list);
			}
		}
		ArrayList<Integer> l1 = map.get(word1);
		ArrayList<Integer> l2 = map.get(word2);
		int min = Integer.MAX_VALUE;
		int i = 0;
		int j = 0;
		while (i < l1.size() && j < l2.size()) {
			int idx1 = l1.get(i);
			int idx2 = l2.get(j);
			min = Math.min(min, Math.abs(idx1 - idx2));
			if (idx1 < idx2) {
				i++;
			} else {
				j++;
			}
		}
		return min;
	}
	

}
