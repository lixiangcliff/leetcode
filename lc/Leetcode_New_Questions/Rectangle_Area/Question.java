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
	
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        //if ()
    	return 0;
    }
}

class Point {
	int x;
	int y;
	Pos p;
	Pos op;
	Point(int x, int y, Pos p) {
		this.p = p;
		//this.op = 3 - p;
		this.x = x;
		this.y = y;
	}
}


//http://stackoverflow.com/questions/8811815/is-it-possible-to-assign-numeric-value-to-an-enum-in-java
enum Pos {
	UL,
	UR,
	BL,
	BR;
}
