package Heap;

public class Main {

	public static void main(String[] args) {
		Heap heap=new Heap();
		heap.add(10);
		heap.add(5);
		heap.add(1);
		heap.add(6);
		
		
		System.out.println(heap.peek());
		heap.remove(1);
		
		while (heap.isEmpty()==false) {
			System.out.println(heap.poll());
		}
	}

}
