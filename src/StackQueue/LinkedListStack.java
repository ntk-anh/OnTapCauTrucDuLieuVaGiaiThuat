package StackQueue;

import java.util.ArrayList;

public class LinkedListStack implements IStackQueue {

	private class Node {
		int value;
		Node next;

		public Node(int value) {
			this.value = value;
		}
	}

	Node topNode;//node nằm ở top

	public LinkedListStack() {
		this.topNode = null;
	}

	@Override
	public boolean push(int value) {
		if (!isFull()) {// chưa đầy mới push được
			// thêm 1 p.tử vô top linked list
			Node newNode = new Node(value);
			newNode.next = topNode;
			topNode = newNode;
			return true;
		}

		return false;
	}

	@Override
	public int pop() {
		if (isEmpty()) {
			return -1;
		}
		int value = topNode.value;
		topNode = topNode.next;
		return value;
	}

	@Override
	public boolean isFull() {
		return false;// để mặc định vì k biết bao giờ nó tràn bộ nhớ
	}

	@Override
	public boolean isEmpty() {
		return topNode == null;// true
	}

	@Override
	public void show() {//duyệt linked list từ trên đi xuống
		if (isEmpty()) {
			System.out.println("Stack is empty");
			return;//để nó k chạy xuống dưới mặc dù đây là hàm main
		}
		//in từ trên xuống dưới
		Node tempNode = topNode;
//		while (tempNode != null) {
//			System.out.println(tempNode.value + " ");
//			tempNode = tempNode.next;
//		}
		ArrayList<Integer> tempList=new ArrayList<>();
		while (tempNode!=null) {
			tempList.add(tempNode.value);
			tempNode=tempNode.next;
		}
		//đảo ngược lại để in từ dưới lên
		for (int i = tempList.size()-1;i>=0;i--) {
			System.out.print(tempList.get(i)+"  ");
		}
		System.out.println();
	}

}
