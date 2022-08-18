package StackQueue;

import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicScrollPaneUI.VSBChangeListener;

public class ArrayQueue implements IStackQueue {

	private int[] array;
	private int size;
	private int headIndex;
	private int tailIndex;

	public ArrayQueue(int size) {
		this.size = size;
		array = new int[size];
		headIndex = tailIndex = -1;
	}

	@Override
	public boolean push(int value) {
		if (!isFull()) {// rỗng thì mới thêm được
			if (isEmpty()) {// khi queue chưa có gì nên phải tăng cả 2,head index=0
				headIndex++;
			}
			tailIndex++;
			array[tailIndex] = value;
			return true;
		}
		return false;
	}

	//hàm tính số p.tử
	public int count() {
		if (isEmpty()) {
			return 0;
		}
		return tailIndex - headIndex + 1;
	}

	@Override
	public int pop() {
		int value=-1;
		if (!isEmpty()) {
			value=array[headIndex];
			headIndex++;
			if (headIndex>tailIndex) {//vì sẽ có trường hợp vượt quá số p.tử mảng
				headIndex=tailIndex=-1;
			}
		}
		return value;
	}

	@Override
	public boolean isFull() {
		if (tailIndex == this.size - 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		if (headIndex == -1 && tailIndex == -1) {
			return true;
		}
		return false;
	}

	@Override
	public void show() {

		if (isEmpty()) {
			System.out.println("Queue is empty");
		}else {
			for (int i = headIndex;i<=tailIndex; i++) {
				System.out.print(array[i]+"\t");
			}
			System.out.println();
		}
	}

}
