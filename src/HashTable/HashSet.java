package HashTable;

import java.util.ArrayList;

public class HashSet {

	private final int SIZE = 1000;
	private ArrayList<Integer> buckets[];

	public HashSet() {

		buckets = new ArrayList[SIZE];
		// khởi tạo arraylist cho riêng từng dòng
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new ArrayList<>();
		}
	}

	// return hashValue
	private int hashFunction(int key) {

		return key % SIZE;
	}

	public void add(int key) {
		int hashValueIndex = hashFunction(key);// băm
		var bucket = buckets[hashValueIndex];// tham chiếu đến bucket// bucket là kiểu arraylist
		int keyIndex = bucket.indexOf(key);// kiểm tra bucket đã tồn tại hay chưa
		if (keyIndex < 0) {// nếu chưa có thì add vào
			bucket.add(key);
		}
	}

	public void remove(int key) {

		int hashValueIndex = hashFunction(key);
		var bucket = buckets[hashValueIndex];
		int keyIndex = bucket.indexOf(key);
		if (keyIndex >= 0) {
			bucket.remove(keyIndex);
		}
		int x=1;

	}

	public boolean contains(int key) {

		int hashValueIndex = hashFunction(key);
		var bucket = buckets[hashValueIndex];
		int keyIndex = bucket.indexOf(key);
		return keyIndex >= 0;
	}

	public static void main(String[] args) {
		HashSet hashSet = new HashSet();
		hashSet.add(1);
		hashSet.add(1);
		hashSet.add(2);
		System.out.println(hashSet.contains(1));
		hashSet.remove(1);
		System.out.println(hashSet.contains(1));
	}
}
