package StackQueue;

public class LinkedListQueue implements IStackQueue {
	private class Node {
		int value;
		Node next;

		public Node(int value) {
			this.value = value;
		}
	}

	Node headNode, tailNode;

	public LinkedListQueue() {
		headNode = tailNode = null;
	}

	@Override
	public boolean push(int value) {
		if (isFull()) {
			return false;
		}

		Node newNode = new Node(value);
		if (isEmpty()) {// trường hợp đặc biệt: chưa có node nào
			headNode = tailNode = newNode;
		} else {// làm như thao tác thêm 1 node vào node cuối
			tailNode.next = newNode;// gán đuôi của tailNode vào newNode
			tailNode = newNode;
		}
		return true;
	}

	@Override
	public int pop() {

		if (isEmpty()) {
			return -1;
		}
		int value = headNode.value;
		if (headNode == tailNode) {// trường hợp đặc biệt: chỉ có đúng 1 node
			headNode = tailNode = null;
		} else {
			headNode = headNode.next;
		}

		return value;
	}

	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public boolean isEmpty() {
		return (headNode == null && tailNode == null);
	}

	@Override
	public void show() {
		if (isEmpty()) {
			System.out.println("Queue is Empty!");
			return;
		}

		Node curNode = headNode;// đặt 1 biến tạm vì k muốn nó ảnh hưởng đến headNode và tailNode
		while (curNode != null) {
			System.out.print(curNode.value + " ");
			curNode = curNode.next;
		}
		System.out.println();
	}
}
