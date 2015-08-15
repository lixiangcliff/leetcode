package Text_Justification;

import java.util.ArrayList;
import java.util.List;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		List<String> result = q.fullJustify(words, 16);
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
	//http://www.cnblogs.com/yuzhangcmu/p/4127290.html
	//http://blog.csdn.net/linhuanmars/article/details/24063271
	public List<String> fullJustify(String[] words, int L) {
		List<String> result = new ArrayList<String>();
		if (words == null || words.length == 0) {
			return result;
		}
		int wordsCount = words.length; // 一共有几个单词
		int curStart = 0; // 当前行第一个元素的index（亦即：上一行还没处理的单词的index）
		int wordsLenSum = 0; // 当前行目前累积的单词长度和
		for (int i = 0; i <= wordsCount; i++) { // 【注】 i <= wordsCount, (i == wordsCount表示已经将最后一个单词累计入当前行)
			// 已经处理到最后一行，或者已经凑够一行。具体说：如果算上当前word[i]的话就超出一行了。所以不算word[i]的话，已经攒够一行的量了。开始处理攒好的字符串们(word[i]不被计入当前行)
			if (i == wordsCount || wordsLenSum + words[i].length() + (i - curStart) > L) { // 【注】i - curStart表示当前行，如果加上word[i]会有多少个单词间隔
				int slotCount = i - 1 - curStart; // 表示当前行实际有多少个单词间隔(不加word[i])
				int spaceCount = L - wordsLenSum; // 当前行一共有多少空格待分配
				StringBuilder sb = new StringBuilder();
				if (slotCount == 0 || i == wordsCount) { // 当前行只有一个单词，或者已经将最后一个单词累计入当前行
                    for (int j = curStart; j < i; j++) { //【注】这两种情况可以统一理解为“向左对齐，单词间隔为1个空格（如果该行有多个单词的话），最右单词的后面用空格补至该行最末”
                        sb.append(words[j]);
                        if (j != i - 1) { // 只要不是本行最后一个单词，就加1个空格
                            appendSpace(sb, 1);
                        }
                    }
                    appendSpace(sb, L - sb.length()); // 把该行剩余位置都填充为空格
				} else { // 常规分配空格情况
					int spaceEach = spaceCount / slotCount; // 每个slot初始分配几个空格
					int spaceExtra = spaceCount % slotCount; // 平均分完空格后，还剩几个空格
					for (int j = curStart; j < i; j++) { // word[i]不被计入当前行
                        sb.append(words[j]);
                        if (j != i - 1) { // 只要不是本行最后一个单词，就加相应的空格(最后一个单词后面不需要加空格)
                            appendSpace(sb, spaceEach + (j - curStart < spaceExtra ? 1 : 0)); // 如果j在从curStart计算起的前spaceExtra个，则空格多加1个，否则就只加平均个空格
                        }
                    }
				}
				result.add(sb.toString()); // 将已经分配好空格的本行加入结果集
				wordsLenSum = 0; // 重置本行单词长度和为0
				curStart = i; // 把curStart置为当前i，为下一行操作做准备
			} 
			if (i < wordsCount) { // 只要还没累加完最后一个单词【注】这个必须在第一个if之后。反例:Input:	["a"], 1; Output:	["","a"]; Expected:	["a"]
				wordsLenSum += words[i].length(); // 表明还没凑够一行，要继续累加单词
			}
		}
		return result;
	}
	
	//在sb后添加count个空格
    private void appendSpace(StringBuilder sb, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(' ');
        }
    }

}
