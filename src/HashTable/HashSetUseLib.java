/*
 * giải bài toán contains duplicate
 */
package HashTable;

import java.util.HashSet;
import java.util.Set;

public class HashSetUseLib {

	public boolean containsDuplicate(int[] nums) {
		Set<Integer> mySet=new HashSet<>();
		for (Integer i : nums) {
			if (mySet.contains(i)==true) {//đã tồn tại trong Set, mất O(1) 
				return true;
			}else {//chưa tồn tại
				mySet.add(i);
			}
		}
		return false;//nếu chạy hết set mà chưa có p.tử nào lặp lại
	}
	public static void main(String[] args) {
		
		
		
	}

}
