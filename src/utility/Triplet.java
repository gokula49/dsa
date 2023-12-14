package utility;

public class Triplet implements Comparable<Triplet>{

	public int val;
	public int aPos;
	public int vPos;
	
	
	
	public Triplet(int val, int aPos, int vPos) {
		super();
		this.val = val;
		this.aPos = aPos;
		this.vPos = vPos;
	}



	@Override
	public int compareTo(Triplet o) {
		
		if(o.val>=val) return -1;
		else return 1;
	}

}
