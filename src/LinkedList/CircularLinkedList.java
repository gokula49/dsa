package LinkedList;

public class CircularLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void printList(Node head) {
		if(head==null) return;
		Node r = head;
		
		do {
			System.out.println(r.data);
			r = r.next;
		} while(r!=head);
	}
	
	public static Node insertHead(Node node, int x) {

		Node temp = new Node(x);

		if (node == null) {
			temp.next = temp;
			return temp;
		} else {
			temp.next = node.next;
			node.next = temp;
			int tem = node.data;
			node.data = temp.data;
			temp.data = tem;
			return node;
		}
	}
	
	public static Node insertEnd(Node node, int x) {

		Node temp = new Node(x);

		if (node == null) {
			temp.next = temp;
			return temp;
		} else {
			temp.next = node.next;
			node.next = temp;
			int tem = node.data;
			node.data = temp.data;
			temp.data = tem;
			return temp;
		}
	}
	
	public static Node deleteHead(Node node) {
		if(node==null) return null;
		if(node.next==node) return null;
		
		node.data = node.next.data;
		node.next = node.next.next;
		return node;
		
	}

}
