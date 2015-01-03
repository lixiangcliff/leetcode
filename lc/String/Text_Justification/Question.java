package Text_Justification;

import java.util.ArrayList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		ArrayList<String> result = q.fullJustify(words, 16);
		for(int i=0; i<result.size(); i++){
			System.out.println(result.get(i));
		}
	}
	
	/**
	 * https://oj.leetcode.com/problems/text-justification/
	 * Given an array of words and a length L, format the text such that each
	 * line has exactly L characters and is fully (left and right) justified.
	 * You should pack your words in a greedy approach; that is, pack as many
	 * words as you can in each line. Pad extra spaces ' ' when necessary so
	 * that each line has exactly L characters.
	 * Extra spaces between words should be distributed as evenly as possible.
	 * If the number of spaces on a line do not divide evenly between words, the
	 * empty slots on the left will be assigned more spaces than the slots on
	 * the right.
	 * For the last line of text, it should be left justified and no extra space
	 * is inserted between words.
	 * 
	 * For example, 
	 * words: ["This", "is", "an", "example", "of", "text", "justification."] 
	 * L: 16.
	 * 
	 * Return the formatted lines as: 
	 * [ 
	 * 	"This    is    an", 
	 * 	"example  of text",
	 * 	"justification.  " 
	 * ] 
	 * Note: Each word is guaranteed not to exceed L in length.
	 * 
	 * click to show corner cases.
	 * Corner Cases:
	 * A line other than the last line might contain only one word. 
	 * What should you do in this case? In this case, that line should be
	 * left-justified.
	 */
	
	//http://www.ninechapter.com/solutions/text-justification/
	//http://blog.csdn.net/linhuanmars/article/details/24063271
	public ArrayList<String> fullJustify(String[] words, int L) {
		ArrayList<String> result = new ArrayList<String>();
		if (words == null || words.length == 0) {
			return result;
		}
		int wordsCount = words.length; // 一共有几个单词
		int lastI = 0; // 上一行还没处理的单词的index
		int wordsLenSum = 0; // 当前行目前累积的单词长度和
		for (int i = 0; i <= wordsCount; i++) { // 【注】 i <= wordsCount, (i == wordsCount表示已经将最后一个单词累计入当前行)
			// 已经处理到最后一行，或者一斤凑够一行。具体说：算上当前word[i]的话就超出一行了，所以已经攒够一行的量了，开始处理攒好的字符串们(word[i]不被计入当前行)
			if (i == wordsCount || wordsLenSum + words[i].length() + (i - lastI) > L) { // i - last表示当前行有多少个单词(【注】每多一个单词就要多累积一个空格)
				int slotCount = i - lastI - 1; // 表示当前行有多少个单词间隔
				int spaceCount = L - wordsLenSum; // 当前行一共有多少空格待分配
				StringBuilder sb = new StringBuilder();
				if (slotCount == 0 || i == wordsCount) { // 当前行只有一个单词，或者已经将最后一个单词累计入当前行
                    for(int j = lastI; j < i; j++){ //【注】这两种情况可以统一理解为“向左对齐，单词间隔为1个空格（如果改行有多个单词的话），最右单词后面用空格补至本行最末”
                        sb.append(words[j]);
                        if (j != i - 1) { // 只要不是本行最后一个单词，就加1个空格
                            appendSpace(sb, 1);
                        }
                    }
                    appendSpace(sb, L - sb.length()); // 把改行剩余位置都填充为空格
				} else { // 常规分配空格情况
					int spaceEach = spaceCount / slotCount; // 每个slot初始分配几个空格
					int spaceExtra = spaceCount % slotCount; // 平均分完空格后，还剩几个空格
					for (int j = lastI; j < i; j++) { // word[i]不被计入当前行
                        sb.append(words[j]);
                        if (j != i - 1) { // 只要不是本行最后一个单词，就加相应的空格(最后一个单词后面不需要加空格)
                            appendSpace(sb, spaceEach + (j - lastI < spaceExtra ? 1 : 0)); // 如果j在从lastI计算起的前spaceExtra个，则空格多加1个，否则就只加平均个空格
                        }
                    }
				}
				result.add(sb.toString()); // 将已经分配好空格的本行加入结果集
				wordsLenSum = 0; // 重置本行单词长度和为0
				lastI = i; // 把lastI置为当前i
			} 
			if (i < wordsCount) { // 只要还没累加完最后一个单词
				wordsLenSum += words[i].length(); // 表明还没凑够一行，要继续累加单词
			}
		}
		return result;
	}
	
	//在sb后添加count个空格
    private void appendSpace(StringBuilder sb, int count) {
        for (int i = 0; i < count; i++)
            sb.append(' ');
    }

}
