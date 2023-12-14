package LinkedList;

import java.util.HashMap;

public class SinglyLinkedList {

	public static void main(String[] args) {

		Node node = new Node(10);
		node.next =  new Node(20);
		node.next.next = new Node(30);
		node.next.next.next = new Node(40);
		node.next.next.next.next = new Node(50);
		Node head =insertMiddle(node,8,3);
		
//		 head = insertFirst(node, 8);
//		head = insertLast(head, 60);
		
		
		printNodeRecursive(head);
		System.out.println(searchKeyIterative(node,99));
	}
	
	public static void printNodeItrative(Node node) {
		Node temp = node;
		while(temp!=null) {
			System.out.println(temp.data + "  ");
			temp = temp.next;
		}
		
	}
	
	public static void printNodeRecursive(Node node) {
		if(node==null) return;
		System.out.println(node.data);
		printNodeRecursive(node.next);
	}
	
	public static Node insertFirst(Node node, int i) {
		Node temp = new Node(i);
		if(node == null) return temp;
		
		temp.next = node ;
		return temp;
	}
	
	public static Node insertLast(Node node , int i) {
		Node temp = new Node(i);
		Node curr = node;
		while(curr.next!=null) {
			curr = curr.next;
		}
		curr.next = temp;
		return node;
	}
	
	public static Node insertMiddle(Node node, int i , int pos) {
		Node temp = new Node(i);
		Node curr = node;
		for(int j=pos;j>2;j--) {
			curr =  curr.next;
		}
		temp.next = curr.next;
		curr.next=temp;
		return node;
	}
	
	public static Node deleteFirst(Node node) {
		if(node==null) return null;
		
		return node.next;
	}
	
	public static Node deleteLast(Node node) {
		Node curr =  node;
		while(curr.next.next!=null) {
			curr = curr.next;
		}
		curr.next = null;
		
		return node;
	}
	
	public static boolean searchKeyIterative(Node node, int i) {
		Node curr = node;
		
		while(curr!=null) {
			if(curr.data == i) return true;
			else {
				curr = curr.next;
			}
		}
		return false;
	}
	
	public static Node sortedInsert(Node head, int data) {
	  Node temp = new Node(data);
	  Node curr = head;
	  while(curr.next!=null && curr.next.data < data) {
		  curr = curr.next;
	  }
	  temp.next = curr.next;
	  curr.next = temp;
	  
	  return head;
	}
	
	public static Node printMidle(Node node) {
		Node fast = node, slow = node;
		
		while(fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}
	
	public static Node printNthEndNode(Node node, int n) {
		Node first = node; 
		Node second = node;
		
		for (int i=0; i<n;i++) {
			first = first.next;
		}
		
		while(first!=null) {
			first = first.next;
			second = second.next;
		}
		
		return second;
		
	}
	
	public static Node reverseANodeIterative(Node node) {
		Node curr = node;
		Node prev = null;
		
		while(curr!=null) {
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		 return prev;
	}
	
	public static Node removeDuplicate(Node node) {
		Node curr = node;
		
		while(curr!=null && curr.next!=null) {
			if(curr.data == curr.next.data) {
				curr.next =  curr.next.next;
			}else {
				curr = curr.next;
			}
		}
		return node;
	}
	 
	
	public static boolean cyclicDetection(Node node) {
		Node fast = node, slow =node;
		while(fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow==fast) return true;
			
		} 
		
		return false;
	}
	
	public static Node cycleRemoval(Node node) {
		Node fast = node, slow = node;
		
		while(fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) break;
		}
		if(slow !=  fast) return node;
		
	    slow = node;
	    while(slow.next!=fast.next) {
	    	slow = slow.next;
	    	fast = fast.next;
	    }
	    
	    fast.next = null;
	    return node;
	}
	
	public static void deleteNode(Node node) {
		Node temp = node.next;
		node.data = temp.data;
		node.next = temp.next;
	}
	
	
	public static Node segregate(Node node) {
		Node os = null, oe = null, es = null, ee = null;
		
		for(Node curr = node ; curr!=null;curr = curr.next) {
			int x = curr.data;
			
			if(x%2==0) {
				if(es==null) {
					es = ee = curr;
				}else {
					ee.next = curr;
					ee = ee.next;
				}
			}else {
				if(os==null) {
					os=oe=curr;
				}else {
					oe.next = curr;
					oe = oe.next; 
				}
			}
		}
		
		if(os ==null || es ==null) {
			return node;
		}
		ee.next = os;
		oe.next = null;
		return es;
	}
	
	public static Node pairWiseSwap(Node head) {
		if(head==null || head.next == null) {
			return head;
		}
		
		Node curr = head.next.next;
		Node prev= head;
		head = head.next;
		head.next = prev;
		
		while(curr!=null && curr.next != null) {
			prev.next = curr.next;
			prev = curr;
			Node next = curr.next.next;
			curr.next.next = curr;
			curr = next;
		}
		
		prev.next = curr;
		return head;
	}
	
	
	public static Node cloneLLwithRandom(Node h1) {
		HashMap<Node,Node> map = new HashMap<>();
		
		for(Node curr = h1;curr!=null;curr = curr.next) {
			map.put(curr, new Node(curr.data));
		}
		
		for(Node curr = h1;curr!=null;curr = curr.next) {
			Node clone = map.get(curr);
			clone.next = map.get(curr.next);
			clone.random = map.get(curr.random);
		}
		
		return map.get(h1);
		
	}
	
	public static Node cloneLLwithRandom2(Node h1) {
        Node curr = h1;
		while(curr!=null) {
			Node next = curr.next;
			curr.next = new Node(curr.data);
			curr.next.next = next;
			curr = next;
		}
		
		for( curr = h1; curr!=null;curr= curr.next) {
			curr.next.random = curr.random!=null?curr.random.next:null;
		}
		
		Node h2 = curr.next;
		Node clone = h2;
		
		for(Node curr1 = h1; curr1!=null;curr1= curr1.next) {
			curr.next= curr.next.next;
		    clone.next= clone.next!=null?clone.next.next:null;
		    clone = clone.next;
		  
		}
		
		return h2;
	}
	
	public static Node mergeSorted(Node a, Node b) {
		if(a==null) return b;
		if(b==null) return a;
		Node head =null, tail = null;
		if(a.data<b.data) {
		  head = tail = a;a= a.next;
		}else {
			head = tail = b; b= b.next;
		}
		
		while(a!=null && b!=null) {
			if(a.data<b.data) {
				tail.next = a; tail = a; a = a.next;
			}else {
				tail.next = b; tail =b; b = b.next;
			}
		}
		
		if(a==null) tail.next=b;
		else tail.next = a;
		
		return head;
		
	}
	
	public static boolean palindromeLinkedList(Node head) {
		Node slow = head, fast = head;
		
		while(fast.next!=null && fast.next.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		Node rev = reverseANodeIterative(slow.next);
		Node curr = head;
		while(rev!=null) {
			if(curr.data!=rev.data) return false; 
			curr = curr.next;
			rev = rev.next;
		}
		return true;
	}

}
