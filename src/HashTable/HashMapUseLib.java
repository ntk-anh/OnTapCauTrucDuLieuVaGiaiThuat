/*
 * bài toán1: đếm số lần xuất hiện của từng p.tử trong mảng arr
 * key: giá trị của p.tử trong mảng arr, value: số lần xuất hiện của p.tử đó
 * ý tưởng:
 * 	-kiểm tra xem p.tử đó tồn tại chưa
 * 	-nếu chưa: put vô map
 * 	-nếu rồi: tăng value của p.tử đó lên 1
 * 	-cuối cùng duyệt map in ra 
 */
/*
 * bài toán 2: nhập vào 1 chuỗi, tìm kí tự đầu tiên mà xuất hiện duy nhất
 * ý tưởng: tìm bảng hash table
 * duyệt để tìm index của kí tự đó
 */
package HashTable;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapUseLib {

	public static void main(String[] args) {
		/*
		 * bài toán 1 int[] arr= {1,2,3,1,1,2}; Map<Integer, Integer> myMap=new
		 * HashMap<>();
		 * 
		 * 
		 * for (int i : arr) { 
		 * if (myMap.containsKey(i)==false) { //i chưa xuất hiện trong map 
		 * myMap.put(i, 1); }else { //i đã xuất hiện 
		 * int soLanXuatHien=myMap.get(i); 
		 * soLanXuatHien++; 
		 * myMap.put(i, soLanXuatHien ); 
		 * }
		 * }
		 * 
		 * 
		 * for (Map.Entry entry : myMap.entrySet()) {//mỗi p.tử trong set là kiểu entry
		 * System.out.println(entry.getKey()+" xuất hiện "+entry.getValue()+" lần "); }
		 */

		/* bài toán 2 */

	}

	public int FirstUniqueCharacter(String s) {
		Map<Character, Integer> myMap = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			char c=s.charAt(i);
			if (myMap.containsKey(c)==false) {
				myMap.put(c, 1);
			}else {
				myMap.put(c, myMap.get(c)+1);
			}
		}
			
		for (int i = 0; i < s.length(); i++) {
			char c=s.charAt(i);
			if (myMap.get(c)==1) {
				return i;
			}
		}
		
		return -1;
	}
}
