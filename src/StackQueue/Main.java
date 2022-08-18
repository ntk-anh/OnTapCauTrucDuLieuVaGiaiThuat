package StackQueue;

public class Main {

	public static void main(String[] args) {

		/*
		ArrayStack stack=new ArrayStack(3);
		System.out.println(stack.push(1));
		System.out.println(stack.push(2));
		System.out.println(stack.push(3));
		System.out.println(stack.push(4));
		stack.show();
		
		stack.pop();
		stack.show();
		stack.pop();
		stack.show();
		stack.pop();
		stack.show();
		stack.pop();
		stack.show();
		*/
		
		/*
		ArrayQueue queue=new ArrayQueue(3);
		System.out.println(queue.push(1));
		System.out.println(queue.push(2));
		System.out.println(queue.push(3));
		System.out.println(queue.push(4));
		queue.show();
		
		System.out.println(queue.pop());
		queue.show();
		System.out.println(queue.pop());
		queue.show();
		System.out.println(queue.pop());
		queue.show();
		*/
		
		/*
		LinkedListStack stack=new LinkedListStack();
		
		System.out.println(stack.push(1));
		System.out.println(stack.push(2));
		System.out.println(stack.push(3));
		stack.show();
		
		System.out.println(stack.pop());
		stack.show();
		System.out.println(stack.pop());
		stack.show();
		System.out.println(stack.pop());
		stack.show();
		System.out.println(stack.pop());
		stack.show();
		*/
		
		LinkedListQueue queue=new LinkedListQueue();
		queue.push(1);
		queue.push(2);
		queue.push(3);
		queue.show();
		
		queue.pop();
		queue.show();
		queue.pop();
		queue.show();
		queue.pop();
		queue.show();
		queue.pop();
		queue.show();
	}

}
