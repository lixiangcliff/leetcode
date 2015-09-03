package Rectangle_Area;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * https://leetcode.com/problems/rectangle-area/
	 * Find the total area covered by two rectilinear rectangles in a 2D plane.
	 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
	 * 
	 * Rectangle Area https://leetcode.com/static/images/problemset/rectangle_area.png
	 * Assume that the total area is never beyond the maximum possible value of int.
	 */
	
	//http://www.cnblogs.com/grandyang/p/4563153.html
	//http://blog.csdn.net/foreverling/article/details/46411069
	//http://bookshadow.com/weblog/2015/06/08/leetcode-rectangle-area/
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int sum = (C - A) * (D - B) + (G - E) * (H - F);
        if (B >= H || E >= C || F >= D || A >= G) { // no overlap
        	return sum;
        } else {
        	return sum - (Math.min(C, G) - Math.max(A, E)) * (Math.min(D, H) - Math.max(B, F));
        }
    }
}
