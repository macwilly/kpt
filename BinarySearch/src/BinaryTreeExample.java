import java.util.Arrays;

class Node{
	Node left;
	Node right;
	int value;
	
	public Node(int value){
		this.value = value;
	}
}
public class BinaryTreeExample {
	Node root;
	
	public BinaryTreeExample(){
		
	}
	//make the tree balanced
	public BinaryTeeExample(int[] keys){
		Arrays.sort(keys);
		int start = 0;
		int end = keys.length-1;
		int mid = (start+end)/2;
		Node r = new Node(keys[mid]);
		root = r;
		add(r, keys, start, mid-1);
		add(r, keys, mid+1, end);
	}
	
	public void add(Node n, int[] A, int start, int end){
		if(start<=end){
			int mid = (start+end)/2;
			if(A[mid]<n.value){
				n.left = new Node(A[mid]);
				add(n.left,A,start,mid-1);
				add(n.left,A,mid+1,end);
			}
			else{
				n.right = new Node(A[mid]);
				add(n.right,A,start,mid-1);
				add(n.right,A,mid+1,end);
			}
		}
	}
	
	
	public void insert(Node node, int value){
		if(value<node.value){
			if(node.left !=null)
				insert(node.left, value);
			else
				System.out.println("Inserted "+value+" to left of node "+node.value);
				node.left = new Node(value);
		}
		
		else if(value node.value){
			if(node.right !=null)
				insert(node.right, value);
			else
				System.out.println("Inserted "+value+" to right of node "+node.value);
				node.right = new Node(value);
		}
	}
//the search
	public Node search(Node n, int key){
		if(n==null)
			return null;
		if(n.value==key)
			return n;
		//will skip all of the right tree
		else if(n.value>key)
			return search(n.left,key);
		//this will skip the left side of the tree
		else
			return search(n.right,key);
	}
///	

	public void run(){
		Node rootnode = new Node(25);
		System.out.println("Building tree with rootvalue "+rootnode.value);
		System.out.println("===================");
		insert(rootnode,11);
		insert(rootnode,15);
		insert(rootnode,16);
		insert(rootnode,23);
		insert(rootnode,79);
		printInOrder(rootnode);
	}
	public void printInOrder(Node node){
		if(node!=null){
			printInOrder(node.left);
			System.out.println("Traversed "+node.value);
			printInOrder(node.right);
		}
	}
	public static void main(String[] args){
		new BinaryTreeExample().run();
		int[] values = {11,15,16,25,23,70};
		BinaryTreeExample bt = new BinaryTreeExample(values);
		System.out.println("Print new Tree!");
		bt.printInOrder(bt.root);
		Node n = bt.search(bt.root, 90);
		if(n!null)
			System.out.println(n.value);
		else
			System.out.println("No match!");
	}
}

