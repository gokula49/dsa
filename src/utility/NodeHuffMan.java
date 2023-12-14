package utility;

public class NodeHuffMan {

	char ch;
	int freq;
	NodeHuffMan left;
	NodeHuffMan right;
	
	

	public NodeHuffMan(char ch, int freq, NodeHuffMan left, NodeHuffMan right) {
		super();
		this.ch = ch;
		this.freq = freq;
		this.left = left;
		this.right = right;
	}

	public char getCh() {
		return ch;
	}

	public void setCh(char ch) {
		this.ch = ch;
	}

	public int getFreq() {
		return freq;
	}

	public void setFreq(int freq) {
		this.freq = freq;
	}

	public NodeHuffMan getLeft() {
		return left;
	}

	public void setLeft(NodeHuffMan left) {
		this.left = left;
	}

	public NodeHuffMan getRight() {
		return right;
	}

	public void setRight(NodeHuffMan right) {
		this.right = right;
	}

}
