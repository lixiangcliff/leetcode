package Shortest_Word_Distance_II;

import java.util.ArrayList;
import java.util.HashMap;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words 
	 * and your method will be called repeatedly many times with different parameters. How would you optimize it?
	 * 
	 * Design a class which receives a list of words in the constructor, and implements a method 
	 * that takes two words word1 and word2 and return the shortest distance between these two words in the list.
		For example,
		Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
		Given word1 = "coding”, word2 = "practice”, return 3.
		Given word1 = "makes", word2 = "coding", return 1.
		
		Note:
		You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
	 */
	
	// Your WordDistance object will be instantiated and called as such:
	// WordDistance wordDistance(words);
	// wordDistance.shortest("word1", "word2");
	// wordDistance.shortest("anotherWord1", "anotherWord2");
	public class WordDistance {
		private HashMap<String, ArrayList<Integer>> map;
		
		WordDistance(String[] words) {
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
		}
		
		public int shortest(String word1, String word2) {
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

}
