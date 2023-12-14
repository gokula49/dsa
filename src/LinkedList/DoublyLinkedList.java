package LinkedList;

public class DoublyLinkedList {
	public static void main(String[] args) {

		Node head  = new Node(1);
		Node temp1 = new Node(2);
		Node temp2 = new Node(3);
		
		head.next = temp1;
		temp1.prev = head;
		temp1.next = temp2;
		temp2.prev = temp1;
		
	}
	
	public static Node insertFirst(Node head, int data) {
		Node temp = new Node(data);
		temp.next = head;
		if(head!=null) {
			head.prev = temp;
		}
		return temp;
	}
	
	public static Node insertLast(Node node, int data) {
		Node temp = new Node(data);
		Node curr = node;
		if(node==null) {
			return temp;
		}
		
		while(curr.next!=null) {
			curr = curr.next;
		}
		
		curr.next = temp;
		temp.prev = curr;
		return node;
	}
	
	
	public static Node reverseDll(Node head) {
		
		if(head==null || head.next== null) return head;
		
		Node  prev= null, curr = null;
		while(curr!=null) {
			prev = curr.next;
			curr.prev = curr.next;
			curr.next = prev;
			curr = curr.prev;
		}
		
		
		
		return prev.prev;
		
	}
	
	public static Node delHead(Node node) {
		if(node==null) return null;
		if(node.next==null) return null;
		
		else {
			node = node.next;
			node.prev = null;
			return node;
		}
	}
	
	public static Node delTail(Node node) {
		if(node==null) {
			return null;
		}
		if(node.next == null) return null;
		
		Node curr = node;
		while(curr.next!=null) {
			curr =  curr.next;
		}
		curr.prev.next = null;
		return node;
	}
}
