package binarytree;

public class LijingBinaryTree {
	private Node root;
	
	public LijingBinaryTree() {
		
	}
	
	public Node add(int data) {
		if(this.root == null) {
			this.root = new Node(data,null,null,null);
			return this.root;
		}else {
			return add(this.root,data);
		}
			
	}
	
	private Node add(Node parent, int data) {
		if(data<parent.data) {
			if(parent.left == null) {
				Node node = new Node(data,parent,null,null);
				parent.left = node;
				return node;
			}else {
				return add(parent.left,data);
			}
			
		}else if(data>parent.data) {
			if(parent.right == null) {
				Node node = new Node(data,parent,null,null);
				parent.right = node;
				return node;
			}else {
				return add(parent.right,data);
			}
		
		}else {
			System.out.println("元素重复");
			return null;			
		}
	}

	public Node remove(int data) throws Exception {
		if (root == null) {
			throw new Exception("此树为null");
		}else {
			return remove(root, data);
		}
	}
	
	private Node remove(Node currNode, int data) throws Exception {
		if (data<currNode.data) {
			if (currNode.left != null) {
				return remove(currNode.left,data);
			}else {
				throw new Exception("该元素不存在");
			}
			
		}else if (data>currNode.data) {
			if (currNode.right != null) {
				return remove(currNode.right, data);
			}else {
				throw new Exception("该元素不存在");
			}
		}else if (currNode.left != null && currNode.right != null) {
			currNode.data = findMin(currNode.right).data;
			return remove(currNode.right, currNode.data);
		}else {
			currNode = currNode.left == null?currNode.right : currNode.left;
			return currNode;
		}
	}
	
	private Node findMin(Node root) {
		if (root == null) {
			throw new NullPointerException("被查找的元素为 null");
		}
		if (root.left == null) {
			return root;
		}else {
			return root.left;
		}
	}
}
