//khởi tạo 1 cây
package Tree;

public class BinaryTree {

	private TreeNode root;

	public BinaryTree() {
		// TODO Auto-generated constructor stub
	}

	// khởi tạo node, link đế node
	public void init() {
		TreeNode n0 = new TreeNode(0);
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);

		n0.left = n1;
		n0.right = n2;
		n1.left = n3;
		n1.right = n4;
		n2.right = n5;

		root = n0;
	}
}
