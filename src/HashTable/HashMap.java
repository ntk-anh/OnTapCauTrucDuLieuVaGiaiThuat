package HashTable;

import java.io.ObjectOutputStream.PutField;
import java.util.ArrayList;

public class HashMap {

	// tạo 1 obj chứa key:value => để tiện add vào map
	private class Data {
		int key;
		int value;

		public Data(int key, int value) {
			this.key = key;
			this.value = value;
		}

		//mình tự set 2 obj là giống nhau nếu trùng key
		public boolean equals(Object obj) {
			if (obj instanceof Data) {
				return this.key == ((Data) obj).key;
			}
			return false;
		}

	}

	private final int SIZE = 1000;
	private ArrayList<Data> buckets[];

	public HashMap() {
		buckets = new ArrayList[SIZE];// khai báo số p.tử mảng này
		for (int i = 0; i < buckets.length; i++) {// khai báo từng p.tử trong mảng này
			buckets[i] = new ArrayList<>();
		}
	}

	public int hashFunction(int key) {// chuyen key sang hashvalue
		return key % 1000;
	}

	public void put(int key, int value) {// nhét 1 cặp key:value vào map
		int hashValueIndex = hashFunction(key);// đuôi index vì bản thân thằng hashValue là 1 index của buckets thôi
		var bucket = buckets[hashValueIndex]; // tìm đến bucket có index đó
		Data newData = new Data(key, value);//tạo 1 obj cùng key p.tử
		int keyIndex = bucket.indexOf(newData);// vì là obj
		if (keyIndex >= 0) {// nếu tồn tại rồi, thì update lại value thôi
			bucket.get(keyIndex).value = value;
		} else {// còn k thì thêm mới vào
			bucket.add(newData);
		}
		int x = 19;
	}

	public void remove(int key) {// remove cặp key:value có key=
		int hashValueIndex=hashFunction(key);
		var bucket=buckets[hashValueIndex];
		Data deleteData=new Data(key, 0);//tạo 1 obj cùng key p.tử muốn xóa ,thay vì đi tìm index của key của remove index của key đó
		bucket.remove(deleteData);
		int x=8;
	}

	public int get(int key) {// trả về value của p.tử có khóa là key
		int hashValueIndex=hashFunction(key);
		var bucket=buckets[hashValueIndex];
		Data findData=new Data(key, 0);
		int keyIndex=bucket.indexOf(findData);
		if (keyIndex>=0) {
			return bucket.get(keyIndex).value;
		}
		return -1;//nếu k tìm thấy trả ra -1
	}

	public static void main(String[] args) {
		HashMap hashMap = new HashMap();
		hashMap.put(1, 1);
		hashMap.put(1, 2);
		hashMap.put(1, 3);
		hashMap.put(10, 2);

		System.out.println(hashMap.get(1));
		System.out.println(hashMap.get(2));
		hashMap.remove(1);
		System.out.println(hashMap.get(1));
		System.out.println(hashMap.get(10));
	}
}
