package test;

import java.util.ArrayList;

public class Disjointset {

	ArrayList<Integer> parent = new ArrayList<Integer>();
	ArrayList<Integer> rank = new ArrayList<Integer>();
	
	Disjointset(int size) {
		for(int i=0; i<=size; i++) {
			parent.add(i);
			rank.add(0);
		}
	}
	
	public int getParent(int node) {
		if(node == parent.get(node)) {
			return node;
		}
		
		int ulp = getParent(parent.get(node));
		
		parent.set(node, ulp);
		return parent.get(node);
	}
	
	public void unionByRank(int u, int v) {
		int ulp_u = getParent(u);
		int ulp_v = getParent(v);
		if(u==v) return;
		
		if(rank.get(ulp_u)< rank.get(ulp_v)) {
			parent.set(ulp_u, ulp_v);
		}else if(rank.get(ulp_u)> rank.get(ulp_v) ){
			parent.set(ulp_v, ulp_u);
		}
		else {
			parent.set(ulp_v, ulp_u);
            rank.set(ulp_u, rank.get(ulp_u)+1);
		}
	}
	
}
