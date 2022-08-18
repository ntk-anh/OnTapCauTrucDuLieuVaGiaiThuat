package Tree;

public class BinaySearchTree {

	public TreeNode root;

	public BinaySearchTree() {

	}

	// thêm 1 node vào cây dùng vòng lặp
	// Trả root node
	public TreeNode insertNode(TreeNode root, int val) {
		TreeNode newNode = new TreeNode(val);
		// TH1: root=null
		if (root == null) {
			root = newNode;

			// TH2: root != null
		} else {
			TreeNode temp = root;
			while (true) {
				if (val > root.val) {// node lớn hơn root, sẽ dời qua phải
					if (temp.right == null) {
						temp.right = newNode;
					} else {
						temp = temp.right;
					}
				} else {// node nhỏ hơn root, sẽ dời qua trái
					if (temp.left == null) {
						temp.left = newNode;
					} else {
						temp = temp.left;
					}

				}
			}

		}
		return root;
	}

	// cách 2://thêm 1 node vào cây dùng đệ qui
	public TreeNode insertToBST(TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);
		}
		if (val < root.val) {
			if (root.left == null) {// bên trái root chưa có node nào
				root.left = new TreeNode(val);
			} else {
				insertToBST(root.left, val);
			}
		} else {
			if (root.right == null) {// bên phải root chưa có node nào
				root.right = new TreeNode(val);
			} else {
				insertToBST(root.right, val);
			}
		}
		return root;
	}

	// xóa 1 node key trong cây
	// trả ra cây mơi đã được xóa node key
	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		// bước 1: đi tìm node có value là key
		if (key < root.val) {
			root.left = deleteNode(root.left, key);
		} else if (key > root.val) {
			root.right = deleteNode(root.right, key);
		} else {// root.val=key => xoá root
			// bước 2:xóa node root
			// TH1:root là nút lá
			if (root.left == null && root.right == null) {
				return null;
			}
			// TH2: chỉ có 1 con bên trái
			if (root.left != null && root.right == null) {
				return root.left;
			}
			// TH2: chỉ có 1 con bên phải
			if (root.right != null && root.left == null) {
				return root.right;
			}
			// TH3: tồn tại 2 con
			// tìm node trái cùng của cây con bên phải
			TreeNode leftModeNode = findLeftModeNode(root.right);
			root.val = leftModeNode.val;
			// thực hiện xóa
			root.right = deleteNode(root.right, leftModeNode.val);
		}
		return root;
	}

	// hàm tìm node trái cùng của 1 cây
	// trả về node trái cùng
	public TreeNode findLeftModeNode(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode leftMostNode = root;
		while (leftMostNode.left != null) {
			leftMostNode = leftMostNode.left;
		}
		return leftMostNode;
	}

	// hàm tìm kiếm 1 node có value là key
	public TreeNode searchBST(TreeNode root, int key) {

		if (root == null) {// cây k có p.tử nào
			return null;
		}

		if (root.val == key) {// cây có 1 nút là root
			return root;
		} else if (key < root.val) {
			return searchBST(root.left, key);
		} else {// key>root.val
			return searchBST(root.right, key);
		}
	}

	// hàm duyệt in ra màn hình NODE - LEFT - RIGHT , dùng đệ qui
	public void nodeLeftRight(TreeNode currentNode) {
		if (currentNode == null)
			return;

		// duyệt currentNode trước
		System.out.print(currentNode.val + " ");

		// duyệt bên trái
		nodeLeftRight(currentNode.left);

		// duyệt bên trái
		nodeLeftRight(currentNode.right);
	}

	// hàm duyệt in ra màn hình LEFT - NODE - RIGHT , dùng đệ qui
	public void leftNodeRight(TreeNode currentNode) {
		if (currentNode == null)
			return;

		// duyệt bên trái
		leftNodeRight(currentNode.left);

		// duyệt currentNode
		System.out.print(currentNode.val + " ");

		// duyệt bên trái
		leftNodeRight(currentNode.right);
	}

	// hàm tính chiều cao của 1 cây dùng đệ qui
	public int maxDepth(TreeNode root) {
		// bước 1:điều kiện dừng
		if (root == null) {
			return 0;
		}
		// bước 2: công thức đệ qui
		int chieuCaoCayBenTrai = maxDepth(root.left);
		int chieuCaoCayBenPhai = maxDepth(root.right);

		int result = Math.max(chieuCaoCayBenTrai, chieuCaoCayBenPhai) + 1;
		return result;
	}

	// hàm duyệt tìm đường đi xem có thỏa đk hay k
	public boolean duyet(TreeNode curNode, int curSum, int target) {
		// b1: điều kiện dừng
		if (curNode == null) {// là nút rỗng hoặc nút lá
			return false;
		}

		curSum += curNode.val;
		if (isLeaf(curNode) == true) {
			if (curSum == target) {
				return true;
			}
		}

		//duyệt sang 2 cây con bên để kiểm tra
		boolean kqBenTrai = duyet(curNode.left, curSum, target);
		boolean kqBenPhai = duyet(curNode.right, curSum, target);
		
		return kqBenPhai || kqBenTrai;
	}
	
	public boolean hasPathSum(TreeNode root, int targetSum) {
		return duyet(root, 0, targetSum); 
	}

	// hàm kiểm tra lá hay k
	public boolean isLeaf(TreeNode node) {
		return node.left == null && node.right == null;
	}
}
