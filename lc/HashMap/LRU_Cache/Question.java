package LRU_Cache;

import java.util.HashMap;

public class Question {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache ca = new LRUCache(1);
		ca.set(2,1);
		System.out.println(ca.get(2));
	}
}

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It
 * should support the following operations: get and set.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1. 
 * 
 * set(key, value) - Set or insert the value if the key is not already present. 
 * When the cache reached its capacity, 
 * it should invalidate the least recently used item before inserting a new item.
 */
//最新访问（添加）的node放在尾巴；最旧的从头删除。
//1.对于set和get，当被访问的key在cache中已经存在，则要把该key所指node从当前LinkedList的位置上删去（delete()）
//2.对于set和get都会有key被访问，所以一定需要有把被访问key所对应node的放在tail的操作（insertTail()）（除非这个node本来就已经在tail了）
//3.对于set，当增加新的key时（即cache里不存在的key），则要更新map  
//【注】看图。 head和tail为dummy node，方便添加和删除。并且增加delete()和insert2Tail()的方法，方便调用和理清思路。
//http://blog.csdn.net/linhuanmars/article/details/21310633
class LRUCache {
	//Node class相当于一个wrapper包含了如下信息。同时用诸多这样的node来实现一个doubly LinkedList。
	public class DNode{ 
		int key;
		int val;
		DNode next;
		DNode pre;
		DNode(int k, int v){
			this.key = k;
			this.val = v;
			this.next = null;
			this.pre = null;
		}
	}
	
	//private variables
	private HashMap<Integer, DNode> map; //<key, node>即key以及key对应的node(其中node中包涵了所有信息包括key, val, pre, next)
	private int capacity; // LRU cache 的容量 （通过map.size()和capacity的比较来获知cache是否已经存满）
	private DNode head = new DNode(0, 0); // 标记最旧访问key所指向的node 即Least Recently Used
	private DNode tail = new DNode(0, 0); // 标记最新访问key所指向的node
	
	//constructor
	public LRUCache(int cap) {
		this.map = new HashMap<Integer, DNode>();
		this.capacity = cap;
		head.next = tail; //【注】dummy node的便捷得到体现
		tail.pre = head;
		
	}
  
	public int get(int key) {
		if (!map.containsKey(key)) { // cache中不存在该key
			return -1;
		}
		DNode node = map.get(key);
		delete(node);
		insert2Tail(node);
		return node.val;
	}
	
	public void set(int key, int value) {
		if (map.containsKey(key)) { // 如果key已经在cache里了，那么不用担心超过capacity的问题
			DNode node = map.get(key);
			delete(node);
			node.val = value;
			insert2Tail(node);
		} else { // cache里还没有该key
			DNode node = new DNode(key, value);
			if (map.size() >= capacity) { // 如果已经超过cache的capacity了
				DNode lruNode = head.next;// 【注】要记得head是dummy，head所指向的并不是最旧的的，head.next才是最旧的
				map.remove(lruNode.key);
				delete(lruNode);
			}
			insert2Tail(node);
			map.put(key, node);
		}
		
	}
	
	//从LinkedList中删去某node
	private void delete(DNode node) {
		DNode next = node.next;
		DNode pre = node.pre;
		pre.next = next;
		next.pre = pre;
		node.pre = null;
		node.next = null;
	}
	
	//把最近访问node放入tail
	private void insert2Tail(DNode node) {
		DNode mruNode = tail.pre; // 原来的最近被访问node
		mruNode.next = node;
		node.pre = mruNode;
		tail.pre = node;
		node.next = tail;
	}
}