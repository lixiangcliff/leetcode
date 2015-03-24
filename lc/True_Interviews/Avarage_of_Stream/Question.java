package Avarage_of_Stream;

import java.util.LinkedList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AvgStream as = new AvgStream(3);
		as.add(1.0);
		System.out.println(as.getAvg());
		as.add(3);
		System.out.println(as.getAvg());
		as.add(3);
		System.out.println(as.getAvg());
		as.add(3);
		System.out.println(as.getAvg());
		as.add(3);
		System.out.println(as.getAvg());
		as.add(9);
		System.out.println(as.getAvg());
		
	}
	
	/**
	 * http://www.glassdoor.com/Interview/Implement-a-class-that-can-calculate-the-running-average-of-a-stream-of-input-numbers-up-to-a-maximum-of-N-numbers-QTN_877610.htm
	 * Implement a class that can calculate the running average of   a stream of input numbers up to a maximum of N numbers.
	 */
	
	

}

class AvgStream {
	private final int capacity; //一旦初始化 始终不变
	private double sum;
	private LinkedList<Double> queue;
	
	public AvgStream(int n) {
		this.capacity = n;
		sum = 0;
		queue = new LinkedList<Double>();
	}
	
	public void add(double num) {
		if (queue.size() < capacity) {
			sum += num;
		} else {
			Double head = queue.poll();
			sum = sum + num - head;
		}
		queue.offer(num);
	}
	
	public double getAvg() {
		if (capacity == 0) {
			return 0;
		} else {
			return sum / queue.size(); //【注】return sum / capacity 错误！
		}
	}
	
}
