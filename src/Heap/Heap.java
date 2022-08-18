//CÂY MIN
package Heap;

import java.util.Iterator;

public class Heap {

	private static int MAX_SIZE = 100;
	private int[] arr = new int[MAX_SIZE + 1];
	private int size;

	public Heap() {

		size = 0;
	}

	// hàm kiểm tra heap có bị rỗng không
	public boolean isEmpty() {
		return size <= 0;// true khi size=0
	}

	// hàm lấy ra giá trị root nhưng k xóa nó -
	public int peek() {
		if (isEmpty()) {// vì list rỗng nên đâu thể làm được gì
			// throw exception!
			System.out.println("Error: Heap is empty!");
			return -1;
		}
		return arr[1];// root chính là p.tử đầu
	}

	// hàm add
	// ý tưởng: thêm p.tử vào cuối -> tìm cha nó so sánh -> so sánh : nếu cha>con
	// thì đổi chỗ
	public void add(int v) {
		size++;
		arr[size] = v;
		// heapify up (đi lên): đảm bảo tính chất đống khi add xong
		int curIndex = size;
		int parentIndex = curIndex / 2;

		while (parentIndex != 0 && arr[parentIndex] > arr[curIndex]) {
			swap(parentIndex, curIndex);
			curIndex = parentIndex;
			parentIndex = curIndex / 2;
		}
	}

	private void swap(int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	// hàm xóa root
	// ý tưởng: đem thằng cuối cây lên chỗ root đứng -> heapify down (so sánh nó với
	// 2 con nó: nếu lớn hơn thì đổi chỗ với con nhỏ nhất)
	public int poll() {
		if (isEmpty()) {
			System.out.println("Error: Heap is empty!");
			return -1;
		}
		
		//remove
		int minRoot = arr[1];
		arr[1] = arr[size];
		size--;
		
		// heapify-down
		int curIndex = 1;		
 		while ((2 * curIndex) <= size) {// leftChildIndex tồn tại
			int leftChildIndex = 2 * curIndex;
			int rightChildIndex = leftChildIndex + 1;
			
			int smallerChildIndex = leftChildIndex;
			if (rightChildIndex <= size && arr[rightChildIndex] < arr[leftChildIndex]) {// rightChildIndex có tồn tại
				smallerChildIndex = rightChildIndex;
			}
			
			// tìm xong rồi, bây giờ so sánh
			if (arr[curIndex] > smallerChildIndex) {// nếu cha > con
				swap(curIndex, smallerChildIndex);
				curIndex = smallerChildIndex;

			} else {
				// k làm gì cả
				break;
			}
		}

		return minRoot;
	}
	
	
	//hàm xóa 1 p.tử bất kì
	//ý tưởng: làm giống pull 1 root nhưng heapify từ 1 node cha
	public void remove(int v) {
		//tìm v ở đâu
		int curIndex=-1;
		for (int i = 0; i <= size; i++) {
			if (arr[i]==v) {
				curIndex=i;
				break;
			}
		}
		if (curIndex==-1) {//tức là k tìm thấy
			System.out.println("Error: Element is not exist");
			return;
		}
		
		//remove
		arr[curIndex]=arr[size];
		size--;
		
		// heapify-down
 		while ((2 * curIndex) <= size) {// leftChildIndex tồn tại
			int leftChildIndex = 2 * curIndex;
			int rightChildIndex = leftChildIndex + 1;
			
			int smallerChildIndex = leftChildIndex;
			if (rightChildIndex <= size && arr[rightChildIndex] < arr[leftChildIndex]) {// rightChildIndex có tồn tại
				smallerChildIndex = rightChildIndex;
			}
			
			// tìm xong rồi, bây giờ so sánh
			if (arr[curIndex] > smallerChildIndex) {// nếu cha > con
				swap(curIndex, smallerChildIndex);
				curIndex = smallerChildIndex;

			} else {
				// k làm gì cả
				break;
			}
		}
	}
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


