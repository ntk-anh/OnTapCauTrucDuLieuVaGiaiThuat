package LinkedList;

public class LinkedList {

	public static class Node {
		int value;
		Node next;

		public Node(int value) {
			this.value = value;
		}
	}

	public static void printLinkedList(Node head) {
		if (head == null) {
			System.out.println("List is empty");
		} else {
//			Node temp=head;
			while (head != null) {
				System.out.print(head.value);
				head = head.next;
				if (head != null) {// phần tử tiếp theo khác null thì in mũi tên
					System.out.print("->");
				}
			}
			System.out.println();
		}
	}

	public static Node addToHead(Node headNode, int value) {

		Node newNode = new Node(value);
		if (headNode == null) {// node mới chỉ có 1 node mới thêm
			return newNode;
		} else {
			newNode.next = headNode;
			return newNode;
		}
	}

	public static Node addToTail(Node headNode, int value) {
		Node newNode = new Node(value);
		if (headNode == null) {
			return newNode;
		} else {
			// xác định last
			Node lastNode = headNode;
			while (lastNode.next != null) {
				lastNode = lastNode.next;
			}
			// gán next cho lastNode = newNode
			lastNode.next = newNode;
		}
		return headNode;
	}

	public static Node addToIndex(Node headNode, int value, int index) {
		if (index == 0) {
			return addToHead(headNode, value);
		} else {
			// tìm vị trí cần thêm
			Node newNode = new Node(value);
			Node curNode = headNode;
			int count = 0;
			while (curNode.next != null) {
				count++;// chỉ mới ++
				if (count == index) {
					// thực hiện add
					newNode.next = curNode.next;
					curNode.next = newNode;
					break;
				}
				curNode = curNode.next;
			}
		}
		return headNode;
	}

	public static Node removeAtHead(Node headNode) {
		if (headNode != null) {// ngược lại list rỗng thì k cần xóa
			return headNode.next;
		}
		return headNode;
	}

	public static Node removeAtTail(Node headNode) {
		if (headNode == null) {
			return null;
		}
		// xác định last và previous
		Node lastNode = headNode;
		Node prevNode = null;

		while (lastNode.next != null) {
			prevNode = lastNode;// ý tưởng hay
			lastNode = lastNode.next;
		}
		if (prevNode == null) {// chứng tỏ chỉ có 1 node thôi
			return null;// vì chỉ có 1 node thôi mà chúng ta lại remove nó
		} else {
			prevNode.next = null;
		}

		return headNode;
	}

	public static Node removeAtIndex(Node headNode, int index) {
		if (headNode == null || index < 0) {
			return null;
		}
		if (index == 0) {
			return removeAtHead(headNode);
		}
		Node curNode = headNode;
		Node prevNode = null;
		int count = 0;

		while (curNode != null) {
			if (count == index) {
				// remove curNode
				if (prevNode == null) {// curNode là lastNode
					return null;
				} else {
					if (curNode == null) {

					} else {
						prevNode.next = curNode.next;
					}
				}
				break;
			}
			prevNode = curNode;
			curNode = curNode.next;

			count++;
		}

		return headNode;
	}

	public static Node reverseNode(Node head) {
		Node curNode = head;

		while (curNode != null && curNode.next != null) {
			Node nextNode = curNode.next;
			curNode.next = nextNode.next;
			nextNode.next=head;
			head = nextNode;
		}
		return head;
	}

	public static void main(String[] args) {
		// tạo 4 node
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);

		// nối các node lại để thành linked list
		n1.next = n2;
		n2.next = n3;

//		duyệt linked list k dùng hàm
//		Node head = n1;
//		while (head != null) {
//			System.out.print(head.value);
//			head = head.next;
//			if (head != null) {
//				System.out.print("->");
//			}
//		}


//		thêm p.tử vô đầu list
//		n0= addToHead(n1, 0);
//		printLinkedList(n0);

//		thêm phần tử vô cuối
//		n1=addToTail(n1, 9);
//		printLinkedList(n1);

//		thêm p.tử
//		n1= addToIndex(n1, 9, 1);
//		printLinkedList(n1);
//		n1= addToIndex(n1, 9, 4);
//		printLinkedList(n1);

//		xóa p.tử đầu list
//		n1=removeAtHead(n1);
//		printLinkedList(n1);

//		xóa p.tử ở cuối list
//		n1= removeAtTail(n1);
//		printLinkedList(n1);

//		xóa p.tử ở giữa list
//		n1 = removeAtIndex(n1, 0);
//		printLinkedList(n1);
//		n1 = removeAtIndex(n1, 1);
//		printLinkedList(n1);
//		n1 = removeAtIndex(n1, 1);
//		printLinkedList(n1);
		
//		duyệt linked list
		printLinkedList(n1);
		
//		đảo linked list
		Node n0=reverseNode(n1);
		printLinkedList(n0);
	}
}

