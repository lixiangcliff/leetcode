package Compare_Version_Numbers;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		String v1 = "1.0";
		String v2 = "01.0.0.00";
		String[] strArr1 = v1.split("\\.");
		System.out.println(q.compareVersion(v1, v2));
		/*for (String str : strArr1) {
			System.out.println(str);
		}*/
		
	}
	
	/**
	 * https://leetcode.com/problems/compare-version-numbers/
	 * Compare two version numbers version1 and version2.
		If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
		
		You may assume that the version strings are non-empty and contain only digits and the . character.
		The . character does not represent a decimal point and is used to separate number sequences.
		For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
		
		Here is an example of version numbers ordering:
		
		0.1 < 1.1 < 1.2 < 13.37
	 */
	
	//【注】 1.5 < 1.50; 1.5 == 1.5.0
	//neat code
	public int compareVersion(String version1, String version2) {
    	if (version1 == null && version2 == null || version1.length() == 0 && version2.length() == 0) {
    		return 0;
    	}
    	if (version1 == null || version1.length() == 0) {
    		return -1;
    	}
    	if (version2 == null || version2.length() == 0) {
    		return 1;
    	}
    	String[] strs1 = version1.split("\\."); //【注】 在java中，以“.”split的regex
    	String[] strs2 = version2.split("\\.");
    	int len = Math.max(strs1.length, strs2.length);
    	for (int i = 0; i < len; i++) {
    		int val1 = i < strs1.length ? Integer.parseInt(strs1[i]) : 0;
    		int val2 = i < strs2.length ? Integer.parseInt(strs2[i]) : 0;
    		if (val1 > val2) {
    			return 1;
    		} else if (val1 < val2) {
    			return -1;
    		}
    	}
    	return 0;
	}
	
	
	//too tedious
    public int compareVersion2(String version1, String version2) {
    	if (version1 == null && version2 == null || version1.length() == 0 && version2.length() == 0) {
    		return 0;
    	}
    	if (version1 == null || version1.length() == 0) {
    		return -1;
    	}
    	if (version2 == null || version2.length() == 0) {
    		return 1;
    	}
    	String[] strArr1 = version1.split("\\.");
    	String[] strArr2 = version2.split("\\.");
    	if (strArr1 == null && strArr2 == null || strArr1.length == 0 && strArr2.length == 0) {
    		return 0;
    	}
    	if (strArr1 == null || strArr1.length == 0) {
    		return -1;
    	}
    	if (strArr2 == null || strArr2.length == 0) {
    		return 1;
    	}
    	int len1 = strArr1.length;
    	int len2 = strArr2.length;
    	int i = 0;
    	while (i < len1 && i < len2) {
    		int v1 = Integer.parseInt(strArr1[i]);
    		int v2 = Integer.parseInt(strArr2[i]);
    		if (v1 < v2) {
    			return -1;
    		} else if (v1 > v2) {
    			return 1;
    		} else {
    			i++;
    		}
    	}
    	if (len1 < len2) {
    		if (getSum(strArr2, i) == 0) {
    			return 0;
    		} else {
    			return -1;
    		}
		} else if (len1 > len2) {
			if (getSum(strArr1, i) == 0) {
    			return 0;
    		} else {
    			return 1;
    		}
		} else {
			return 0;
		}
    }
    
    private int getSum(String[] strs, int idx) {
    	int sum = 0;
    	for (int i = idx; i < strs.length; i++) {
    		sum += Integer.parseInt(strs[i]); 
    	}
    	return sum;
    }

}
