package Text_Justification;

import java.util.ArrayList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		ArrayList result = fullJustify(words, 16);
		for(int i=0; i<result.size(); i++){
			System.out.println(result.get(i));
		}
	}
	
	//http://blog.csdn.net/linhuanmars/article/details/24063271
    public static ArrayList<String> fullJustify(String[] words, int L) {
    	ArrayList<String> result = new ArrayList<String>();
        if(words == null || words.length == 0){
        	return result;
        }
        int last = 0;
        int count = 0;
        for(int i=0; i<words.length;i++){
        	//if(count + words[i].length() > L){//wrong! //i-last keeps increasing as i++
        	if(count + words[i].length() + (i-last) > L){
        		int spaceNum = 0;
        		int extraNum = 0;
        		//i-last-1 means the number of separators in current line 
        		if(i-last-1>0){
        			spaceNum = (L-count)/(i-last-1);
        			extraNum = (L-count)%(i-last-1);
        		}
        		StringBuilder sb = new StringBuilder();
        		for(int j=last; j<i;j++){//words[i] will be excluded
        			sb.append(words[j]);
        			if(j<i-1){//j is not last one in current line. i.e.j has separator after it
        				//add normal space
        				for(int k=0; k<spaceNum; k++){
        					sb.append(" ");
        				}
        				//add extra space if there is
        				if(extraNum > 0){
        					sb.append(" ");
        					extraNum--;
        				}
        			}
        		}
    			//this is only for when there is only one word in current line
    			//and that only word.length < L
    			for(int j=sb.length(); j<L;j++){
    				sb.append(" ");
    			}
    			result.add(sb.toString());
    			count = 0;
    			last = i;
        	}
        	count += words[i].length();
        }
        //to process last line
        StringBuilder sb = new StringBuilder();
        for(int i=last; i<words.length;i++){
        	sb.append(words[i]);
        	if(sb.length() < L){// don't forget this!
        		sb.append(" "); 
        	}
        }
        for(int i=sb.length(); i<L; i++){
        	sb.append(" ");
        }
        result.add(sb.toString());
        return result;
    }

}
