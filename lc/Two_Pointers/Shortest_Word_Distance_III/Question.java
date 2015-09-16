package Shortest_Word_Distance_III;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		String word1 = "makes";
		String word2 = "makes";
		System.out.println(q.shortestDistance(words, word1, word2));
	}
	
	/**
	 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
		word1 and word2 may be the same and they represent two individual words in the list.
		For example,
		Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
		Given word1 = "makes", word2 = "coding", return 1. Given word1 = "makes", word2 = "makes", return 3.
		Note:
		You may assume word1 and word2 are both in the list.

	 */
	
	public int shortestDistance(String[] words, String word1, String word2) {
		if (words == null || words.length <= 1) {
			return Integer.MAX_VALUE;
		}
		int len = words.length;
		int p1 = -1;
		int p2 = -1;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < len; i++) {
			if (word1.equals(word2)) {
				if (words[i].equals(word1)) {
					if (p1 > p2) {
						p2 = i;
					} else {
						p1 = i;
					}
				}
			} else {
				if (words[i].equals(word1)) {
					p1 = i;
				} else if (words[i].equals(word2)){
					p2 = i;
				}
			}
			if (p1 != -1 && p2 != -1) {
				min = Math.min(min, Math.abs(p1 - p2));
			}
		}
		return min;
	}

}
