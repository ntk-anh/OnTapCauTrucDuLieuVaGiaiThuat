package Tree;

public class Main {
	public static void main(String[] args) {

		/*
		BinaryTree binaryTree=new BinaryTree();
		binaryTree.init();
		System.out.println("Done");
		*/
		
		/*
		BinaySearchTree myTree=new BinaySearchTree();
		myTree.root=myTree.insertNode(myTree.root, 5);
		myTree.root=myTree.insertNode(myTree.root, 1);
		myTree.root=myTree.insertNode(myTree.root, 6);
		myTree.root=myTree.insertNode(myTree.root, 0);
		myTree.root=myTree.insertNode(myTree.root, 3);
		myTree.root=myTree.insertNode(myTree.root, 7);
		myTree.root=myTree.insertNode(myTree.root, 2);
		myTree.root=myTree.insertNode(myTree.root, 4);
		
		myTree.deleteNode(myTree.root, 1);
		System.out.println("Done");
		*/
		TreeNode n0=new TreeNode(0);
		TreeNode n1=new TreeNode(1);
		TreeNode n2=new TreeNode(2);
		TreeNode n3=new TreeNode(3);
		TreeNode n4=new TreeNode(4);
		TreeNode n5=new TreeNode(5);
		TreeNode n6=new TreeNode(6);
		TreeNode n7=new TreeNode(7);
		
		n0.left=n1;n0.right=n2;
		n1.left=n3;n1.right=n4;
		n2.right=n5;
		n4.left=n6;n4.right=n7;		

		BinaySearchTree binaySearchTree=new BinaySearchTree();
		binaySearchTree.nodeLeftRight(n0);
		System.out.println();
		binaySearchTree.leftNodeRight(n0);
	}
}
