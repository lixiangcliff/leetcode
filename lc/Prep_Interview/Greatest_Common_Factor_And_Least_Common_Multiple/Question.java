package Greatest_Common_Factor_And_Least_Common_Multiple;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		System.out.println(q.gcf(20, 7));
		System.out.println(q.lcm(30, 40));
	}

	/**
	 * http://stackoverflow.com/questions/4201860/how-to-find-gcf-lcm-on-a-set-of-numbers
	 */
	
	//greatest common factor
	//思想：“大” % “小”，直到 “小” == 0，返回当时的“大”
	public int gcf(int a, int b) { //即使期初a < b，经过一轮循环之后 就可以a > b了
		while (b > 0) {
			int tmp = b;
			b = a % b;
			a = tmp;
		}
		return a;
	}
	
	//least common multiple
	public int lcm(int a, int b) {
		return a * b / gcf(a, b);
	}
}
