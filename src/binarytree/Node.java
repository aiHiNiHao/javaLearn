package binarytree;

public class Node {
	public Node parent;
	public Node left;
	public Node right;
	public int data;
	public Node(int data, Node parent, Node left, Node right) {
		this.data = data;
		this.parent = parent;
		this.left = left;
		this.right = right;
	}
}
