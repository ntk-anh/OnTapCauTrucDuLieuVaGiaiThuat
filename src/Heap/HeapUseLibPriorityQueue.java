package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class HeapUseLibPriorityQueue {

	 
	public static void main(String[] args) {
		//root là min
//		Queue<Integer> minHeap=new PriorityQueue<>(); 
//		minHeap.add(10);
//		minHeap.add(100);
//		minHeap.add(20);
//		minHeap.add(3);
//		minHeap.add(2);
//		minHeap.add(2);
//		
//		while (minHeap.isEmpty()==false) {
//			System.out.print(minHeap.poll()+" ");
//		}
		
		//root là max
		Queue<Integer> maxHeap=new PriorityQueue<>(Comparator.reverseOrder());
		maxHeap.add(10);
		maxHeap.add(100);
		maxHeap.add(20);
		maxHeap.add(3);
		maxHeap.add(2);
		maxHeap.add(2);
		
		while (maxHeap.isEmpty()==false) {
			System.out.print(maxHeap.poll()+" ");
		}
	}
}
