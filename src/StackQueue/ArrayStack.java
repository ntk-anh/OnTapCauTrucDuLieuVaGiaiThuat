package StackQueue;

public class ArrayStack implements IStackQueue {

	private int[] array;
	private int size;
	private int topIndex;

	public ArrayStack(int size) {
		this.size = size;
		array = new int[this.size];
		topIndex = -1;// nghĩa là stack đang rỗng
	}

	@Override
	public boolean push(int value) {
		if (!isFull()) {//chưa đầy mới push được
			this.topIndex++;
			array[this.topIndex] = value;
			return true;
		}
		return false;//nghĩa là stack đã đầy
	}

	@Override
	public int pop() {
		if (!isEmpty()) {
			int value=array[this.topIndex];
			topIndex--;
			return value;
		}
		return -1;//nghĩa là chưa lấy được
	}

	@Override
	public boolean isFull() {
		return this.topIndex == this.size - 1;
	}

	@Override
	public boolean isEmpty() {
		return topIndex < 0;
	}

	@Override
	public void show() {
		if (isEmpty()) {
			System.out.println("Stack is Empty!");
		}else {
			for (int i = 0; i <= topIndex; i++) {
				System.out.print(array[i]+" ");
			}
			System.out.println();
		}
		
	}
	

}
