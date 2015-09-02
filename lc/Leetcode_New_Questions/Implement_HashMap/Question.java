package Implement_HashMap;
import java.io.*;
import java.util.*;


public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


//http://codereview.stackexchange.com/questions/62049/simple-implementation-of-hashmap
class MyHashtable<K, V> {
    private final static int SIZE = 31; 
    private ArrayList<HashEntry<K, V>> table = new ArrayList<HashEntry<K, V>>();
    
    MyHashtable(){
	    for (int i = 0; i < SIZE; i++) {
	        table.add(null);
	    }
    }
        
  
    public static void main(String args[]) throws Exception {
        new TestHarness(new MyHashtable<String, String>()).run();
    }
    
    public void put(K key, V value) {
        // TODO implement
    	//【注】也可以自己制造hash function 比如下面的方法
    	//http://stackoverflow.com/questions/2624192/good-hash-function-for-strings
        int hash = key.hashCode() % SIZE;
        while(table.get(hash) != null && table.get(hash).getKey() != key) {
            hash = (hash + 1) % SIZE;
        }
        table.set(hash, new HashEntry(key, value)); 
        
    }

    public V get(K key) {
        // TODO implement
        int hash = key.hashCode() % SIZE;
        while(table.get(hash) != null && table.get(hash).getKey() != key) {
            hash = (hash + 1) % SIZE;
        }
        if (table.get(hash) == null) {
            return null;
        } else {
            return table.get(hash).getValue();
        }
    }

    /**
     * A helper class that tests MyHashtable by feeding it puts and gets from STDIN.
     */
    public static class TestHarness implements Runnable {
        final MyHashtable<String, String> hashtable;

        public TestHarness(MyHashtable<String, String> hashtable) {
            this.hashtable = hashtable;
        }

        public void run() {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                String k = scanner.next();
                String v = null;
                if (k.contains("=")) {
                    String[] split = k.split("\\=");
                    k = split[0];
                    v = split[1];
                }
                if (v == null) {
                    System.out.println(hashtable.get(k));
                } else {
                    hashtable.put(k, v);
                }
            }
        }
    }
}

class HashEntry<K, V>{ 
    private K key;
    private V value;

    HashEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}
}
