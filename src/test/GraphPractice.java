package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class GraphPractice {
	private static int timer = 1;
  
	public static void main(String[] args) {
//		   int V = 5;
//	        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
//	        int[][] edges =  {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};
//
//	        for (int i = 0; i < V; i++) {
//	            adj.add(new ArrayList<ArrayList<Integer>>());
//	        }
//
//	        for (int i = 0; i < 6; i++) {
//	            int u = edges[i][0];
//	            int v = edges[i][1];
//	            int w = edges[i][2];
//
//	            ArrayList<Integer> tmp1 = new ArrayList<Integer>();
//	            ArrayList<Integer> tmp2 = new ArrayList<Integer>();
//	            tmp1.add(v);
//	            tmp1.add(w);
//
//	            tmp2.add(u);
//	            tmp2.add(w);
//
//	            adj.get(u).add(tmp1);
//	            adj.get(v).add(tmp2);
//	        }
//
//	        int sum = spanningTreePrims(V, adj);
//	        System.out.println("The sum of all the edge weights: " + sum);
		
//		Disjointset ds = new Disjointset(7);
//        ds.unionByRank(1, 2);
//        ds.unionByRank(2, 3);
//        ds.unionByRank(4, 5);
//        ds.unionByRank(6, 7);
//        ds.unionByRank(5, 6);
//
//        // if 3 and 7 same or not
//        if (ds.getParent(3) == ds.getParent(7)) {
//            System.out.println("Same");
//        } else
//            System.out.println("Not Same");
//
//        ds.unionByRank(3, 7);
//        if (ds.getParent(3) == ds.getParent(7)) {
//            System.out.println("Same");
//        } else
//            System.out.println("Not Same");
		
		
//		 int n = 5;
//	        int[][] edges = {
//	            {1, 0}, {0, 2},
//	            {2, 1}, {0, 3},
//	            {3, 4}
//	        };
//	        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//	        for (int i = 0; i < n; i++) {
//	            adj.add(new ArrayList<Integer>());
//	        }
//	        for (int i = 0; i < n; i++) {
//	            adj.get(edges[i][0]).add(edges[i][1]);
//	        }
//	        int ans = kosaraju(n, adj);
//	        System.out.println("The number of strongly connected components is: " + ans);
//		
		
//		   int n = 4;
//	        int[][] edges = {
//	            {0, 1}, {1, 2},
//	            {2, 0}, {1, 3}
//	        };
//	        List<List<Integer>> connections = new ArrayList<>();
//	        for (int i = 0; i < n; i++) {
//	            connections.add(new ArrayList<Integer>());
//	        }
//	        for (int i = 0; i < n; i++) {
//	            connections.get(i).add(edges[i][0]);
//	            connections.get(i).add(edges[i][1]);
//	        }
//
//	        List<List<Integer>> bridges = criticalConnections(n, connections);
//
//	        int size = bridges.size();
//	        for (int i = 0; i < size; i++) {
//	            int u = bridges.get(i).get(0);
//	            int v = bridges.get(i).get(1);
//	            System.out.print("[" + u + ", " + v + "] ");
//	        }
//	        System.out.println("");\
		
		
		 int n = 5;
	        int[][] edges = {
	            {0, 1}, {1, 4},
	            {2, 4}, {2, 3}, {3, 4}
	        };
	        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
	        for (int i = 0; i < n; i++) {
	            adj.add(new ArrayList<Integer>());
	        }
	        for (int i = 0; i < n; i++) {
	            int u = edges[i][0], v = edges[i][1];
	            adj.get(u).add(v);
	            adj.get(v).add(u);
	        }

	        ArrayList<Integer> nodes = articulationPoints(n, adj);

	        int size = nodes.size();
	        for (int i = 0; i < size; i++) {
	            int node = nodes.get(i);
	            System.out.print(node + " ");
	        }
	        System.out.println("");
	    
	}
	
	
	// Plane BFS
	public static ArrayList<Integer> bfs(int v, ArrayList<ArrayList<Integer>> adj) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		boolean[] visited = new boolean[v];
		
		queue.add(0);
		visited[0] = true;
		
		while(!queue.isEmpty()) {
			
			int key = queue.poll();
			res.add(key);
			
			for(int subNode : adj.get(key)) {
				if(!visited[subNode]) {
				queue.add(subNode);
				visited[subNode]= true;
				}
			}
		}
		return res;
	}
	
	// Plane DFS
	public static ArrayList<Integer> dfs(int node, ArrayList<Integer> res, ArrayList<ArrayList<Integer>> adj,
			boolean[] visited) {
		visited[node] = true;
		if(res!=null) {
		res.add(node);
		}
		for (int key : adj.get(node)) {
			if (!visited[key]) {
				dfs(key, res, adj, visited);
			}
		}
		return res;
	}
	
	
	 public static ArrayList<Integer> dfs(int V, ArrayList<ArrayList<Integer>> adj) {
	        //boolean array to keep track of visited vertices
	        boolean vis[] = new boolean[V+1];
	        vis[0] = true; 
	        ArrayList<Integer> ls = new ArrayList<>();
	        dfs(0, ls, adj, vis); 
	        return ls; 
	    }
	
	// Detect Cycle using BFS in undirected Graph
	 public static boolean cycleDetectionUsingbfs(int s , boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
			
			Queue<Node> queue = new LinkedList<Node>();
			visited[s] = true;
			queue.add(new Node(s,-1));
			
			
			while(!queue.isEmpty()) {
				int node = queue.peek().first;
				int par = queue.peek().second;
				queue.poll();
				for(int key : adj.get(node)) {
					if(!visited[key]) {
					queue.add(new Node(key,node));
					visited[key] = true;
					}
					else if(key != par) return true;
				}
				
			}
			
			return false; 
		}
		
	 public static boolean cycleDetectionUsingbfs(ArrayList<ArrayList<Integer>> adj, int v) {
			boolean[] visited = new boolean[v];
			for(int i=0;i<v;i++) {
				if(!visited[i]) {
				if(cycleDetectionUsingbfs(i,visited,adj)) {
					return true;
				}}
			}
			return false;
		}
	
	 // Detect Cycle using DFS in undirected Graph
	 public static boolean detectCycleDfs(int node,int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
			visited[node] = true;
			for(int key : adj.get(node)) {
				if(!visited[key]) {
					if(detectCycleDfs(key, node,visited,adj)) return true;
				}
				else if(node!=parent) {
					return true;
				}
			}
			return false;
		}
		
	public static boolean detectCycleDfs(ArrayList<ArrayList<Integer>> adj , int v) {
			boolean[] visited = new boolean[v];
			for(int i=0;i<v;i++) {
				if(visited[i]) {
					if(detectCycleDfs(i, -1 , visited, adj)) return true;
				}
			}
			return false;
		}

	// Detect cycle using DFS in Directed Graph 
	
	public static boolean detectCycleDfsDirected(int node, int parent, boolean[] visited,boolean[] path, ArrayList<ArrayList<Integer>> adj) {
		visited[node] = true;
		path[node]= true;
		
		for(int key : adj.get(node)) {
			if(!visited[key]) {
				visited[key] = true;
				if(detectCycleDfsDirected(key,node, visited, path,adj)) return true;
			} else if(path[key]) {
				return true;
			}
		}
		path[node] = false;
		return false;
	}
	
	public static boolean detectCycleDfsDirected(int v , ArrayList<ArrayList<Integer>> adj) {
		boolean[] visited = new boolean[v];
		boolean[] path = new boolean[v];
		
		for(int i=0; i<v; i++) {
			if(visited[i]==false) {
			if(detectCycleDfsDirected(i,-1, visited,path, adj)) {
				return true;
			}}
		}
		return false;
	}
	
    // Topo sort using dfs
	public static void topoSort(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack) {
		
		visited[node]= true;
		for(int key : adj.get(node)) {
			if(!visited[key]) {
				topoSort(key, visited, adj, stack);
			}
		}
		stack.push(node);
	}
	
	public static int[] topoSort(int v,ArrayList<ArrayList<Integer>> adj) {
		boolean[] visited = new boolean[v];
		Stack<Integer> stack= new Stack<Integer>();
		for(int i=0;i<v;i++) {
			if(!visited[i]) {
				topoSort(i, visited, adj, stack);
			}
		}
		
		int i=0;  int[] ans = new int[v];
		while(!stack.isEmpty()) {
			ans[i++]= stack.pop();
		}
		return ans; 
 	}

	
	// Topo sort using bfs (kahn's Algorithm)
	public static ArrayList<Integer> topoSortbfs(int v, ArrayList<ArrayList<Integer>> adj) {
		int[] indegree = new int[v];
		
		for(int i=0;i<v;i++) {
			for(int key : adj.get(i)) {
				indegree[key]++;
			}
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=0; i<v ; i++) {
			if(indegree[i]==0) {
				queue.add(i);
			}
		}
		ArrayList<Integer> ans = new ArrayList<Integer>();
//		int[] topo = new int[v]; int i=0;
		while(!queue.isEmpty()) {
			int node = queue.poll();
			ans.add(node);
			
			for(int key : adj.get(node)) {
				indegree[key]--;
				
				if(indegree[key]==0) {
					queue.add(key);
				}
			}
			
		}
		return ans;
	}
	
	
	// Detect Cycle in directed graph with topo sort (BFS)
	public static boolean topoSortCyclicBfs(int v, ArrayList<ArrayList<Integer>> adj) {
		int[] inorder = new int[v];
		
		for(int i=0;i<v;i++) {
			for(int key: adj.get(i)) {
				inorder[key]++;
			}
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i =0; i<v;i++) {
			if(inorder[i]==0) queue.add(i);
		}
		int count =0;
		while(!queue.isEmpty()) {
			int key = queue.poll();
			count++;
			for(int k : adj.get(key)) {
				inorder[k]--;
				if(inorder[k]==0) queue.add(k);
			}
		}
		if(count==v) return false;
		return true;
		
	}

	// find the order of the dictionary using topo sort
	public static String alienDictionary(String[] dist, int k) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		
		for(int i =0 ; i<k;i++) {
			adj.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<dist.length-1;i++) {
			String s1 = dist[i];
			String s2 = dist[i+1];
			int min = Math.min(s1.length(), s2.length());
			
			for(int j=0; j<min;j++) {
				if(s1.charAt(j)!=s2.charAt(j)) {
					adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) -'a');
					break;
				}
			}
			
		}
		
		ArrayList<Integer> topo = topoSortbfs(k, adj);
		
		String ans = "";
		
		for(int i = 0; i<topo.size();i++) {
			ans += (char) (topo.get(i) + (int)'a');
		}
		
//		 for (int it : topo) {
//	            ans = ans + (char)(it + (int)('a'));
//	        }
//		
		return ans;
		
	}
	
	
	// Shortest path using Topological sort
	public static int[] topoSortforShortestPath(int n, int m, int[][] edges) {
		ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
		for(int i=0; i<n;i++) {
			ArrayList<Pair> temp = new ArrayList<Pair>();
			adj.add(temp);
		}
		
		for(int j =0;j<m;j++) {
			int u = edges[j][0];
			int v= edges[j][1];
			int wt = edges[j][2];
		
			adj.get(u).add(new Pair(v, wt));
		}
		boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<Integer>();
		for(int i=0; i<n; i++) {
			if(!visited[i]) {
				topoSortforShortestPath(i, adj, stack, visited);
			}
		}
		
		int[] dist = new int[n];
		
		for(int i=0; i<n ; i++) {
			dist[i] = (int) 1e9;
		}
		dist[0] = 0;
		while(!stack.isEmpty()) {
			int node = stack.pop();
			for(Pair i : adj.get(node)) {
				int v = i.first;
				int wt = i.second;
				if(dist[node]+wt < dist[v]) {
					dist[v] = dist[node]+wt;
				}
			}
		}
		 for (int i = 0; i < n; i++) {
		      if (dist[i] == 1e9) dist[i] = -1;
		    }
		
		return dist;
		
		
	}

	private static void topoSortforShortestPath(int i, ArrayList<ArrayList<Pair>> adj, Stack<Integer> stack,
			boolean[] visited) {

		visited[i] = true;
		
		for(Pair key : adj.get(i)) {
			int v = key.first;
			if(!visited[v]) {
				topoSortforShortestPath(v, adj, stack, visited);
			}
			
		}
		stack.add(i);
		
	}
	
	// shortestpath in undirected graph
	private static int[] sortestDistance(int[][] edges, int n , int m, int src) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<n ; i++) {
			adj.add(new ArrayList<Integer>());
		}
		for(int i=0 ; i<m ;i++) {
			adj.get(edges[i][0]).add(edges[i][1]);
			adj.get(edges[i][1]).add(edges[i][0]);
		}
		int[] dist = new int[n];
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=0; i<n ; i++) {
			dist[i] = (int) 1e9;
		}
		dist[src] =0;
		queue.add(src);
		
		while(!queue.isEmpty()) {
			int node = queue.poll(); 
			for(int key : adj.get(node) ) {
				if(dist[node]+1 <dist[key]) {
					dist[key] = dist[node]+1;
					queue.add(key);
				}
			}
		}
		
		for(int i=0; i<n;i++) {
			if(dist[i]==1e9) {
				dist[i]=-1;
			}
		}
		
		return dist;
		
	}



    //  dijkstra Algorithm (BFS - > TO find the shortest path)
	public static int[] dijkstra(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj, int s) {
	   PriorityQueue<Pair> queue = new PriorityQueue<Pair>((x,y)->x.first-y.first);
	   queue.add(new Pair(0, s));
	   
	   int[] dist = new int[v];
	   Arrays.fill(dist, (int) 1e9);
	   dist[s]= 0;
	   
	   while(!queue.isEmpty()) {
		   int dis = queue.peek().first;
		   int node = queue.peek().second;
		   queue.poll();
		   
		   for(int i=0;i<adj.get(i).size();i++) {
			   int wt1 = adj.get(node).get(i).get(1);
			   int adjEdge = adj.get(node).get(i).get(0);
			   
			   if(dist[adjEdge] > dis+wt1) {
				   dist[adjEdge] = dis+wt1;
				   queue.add(new Pair(dist[adjEdge], adjEdge));
			   }
			   
		   }
	   }
	   
	   return dist;
	   
	   
	}
 
   // Bellman ford Algorithm to find shortest distest , it will work in negatice cycle also
   public static int[] bellmanfordAlgo(int v, ArrayList<ArrayList<Integer>> edges, int s) {
	   int[] dist = new int[v];
	   
	   for(int i=0; i<v;i++) {
		   dist[i]= (int) 1e9;
		   
	   }
	   
	   dist[s]=0;
	   
	   for(int i=0; i<v;i++) {
		   for(ArrayList<Integer> key : edges) {
			   int u = key.get(0);
			   int v1 = key.get(1);
			   int wt = key.get(2);
			   
			   if(dist[u]!= (int) 1e9 && dist[u]+wt<dist[v1]) {
				   dist[v1]= dist[u] + wt;
			   }
			   
		   }
	   }
	   
	   for(ArrayList<Integer> key : edges) {
		   int u = key.get(0);
		   int v1 = key.get(1);
		   int wt = key.get(2);
		   
		   if(dist[u]!= (int) 1e9 && dist[u]+wt<dist[v1]) {
			   int[] temp = new int[] {-1};
			   return temp;
		   } 
	   }
	   
	   return dist;
   }
  
   // Floyd Warshall Algorithm (to find shortest distance between one point to another point)
   public static int[][] floydAlgorithm(int[][] matrix) {
	   for(int i=0; i<matrix.length;i++) {
		   for(int j=0;j<matrix.length;j++) {
			   if(matrix[i][j]==-1) {
				   matrix[i][j] = (int) 1e9;
			   }
			   if(i==j) matrix[i][j] = 0; 
		   }
	   }
	   
	   
	   for(int k=0;k<matrix.length;k++) {
		   for(int i =0; i<matrix.length;i++) {
			   for(int j=0;j<matrix.length;j++) {
				   matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
			   }
		   }
	   }
	   
	   for(int i=0; i<matrix.length;i++) {
		   for(int j=0;j<matrix.length;j++) {
			   if(matrix[i][j]== (int) 1e9) {
				   matrix[i][j] = -1;
			   }
		   }
	   }
	   
	   return matrix;
	   
	   
   }

   // prims Algorithm
   public static int spanningTreePrims(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
	   int sum =0;
	   
	   boolean[] visited = new boolean[v];
	   
	   PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y)->x.second-y.second);
	   
	   pq.add(new Pair(0, 0));
	   
	   while(!pq.isEmpty()) {
		   Pair pair = pq.poll();
		   int wt = pair.second;
		   int node = pair.first;
		   
		   if(visited[node]) continue;
		   sum += wt;
		   visited[node] = true;
		   
		   for(int i=0; i<adj.get(node).size();i++) {
			   int wt2 = adj.get(node).get(i).get(1);
			   int aDj = adj.get(node).get(i).get(0);
			   
			   if(!visited[aDj]) {
				   pq.add(new Pair(aDj, wt2));
			   }
		   }
		   
	   }
	   
	   
	   
	   
	   return sum;
   }

   
   // kosaraju Algorithm (Strongly Connected Components)
   public static int kosaraju(int v, ArrayList<ArrayList<Integer>> adj) {
	   boolean[] visited = new boolean[v];
	   Stack<Integer> stack = new Stack<Integer>();
	   
	   for(int i=0;i<v;i++) {
		   if(!visited[i]) {
		     topoSort(i,visited,adj,stack);
		   }
		}
	   
	   ArrayList<ArrayList<Integer>> adjT = new ArrayList<ArrayList<Integer>>();
	
	   for(int i=0;i<v;i++) {
		  visited[i]= false;
		  adjT.add(new ArrayList<Integer>());
		}
	   for(int i=0;i<v;i++) {
		   for(int key : adj.get(i)) {
			   adjT.get(key).add(i);
		   }
		}
	   int start =0 ; 
	   while(!stack.isEmpty()) {
		   int node = stack.pop();
		   
			   if(!visited[node]) {
				   start++;
				   dfs3(node, adjT, visited);
			   }
		   
	   }
	   return start;
	   
   }
   
   
   public static void dfs3(int node,  ArrayList<ArrayList<Integer>> adj,
			boolean[] visited) {
		visited[node] = true;
		
		for (int key : adj.get(node)) {
			if (!visited[key]) {
				dfs3(key, adj, visited);
			}
		}
		
	}
 
   //Tarjans algorithm (Bridges in a graph) -> DFS
   public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
	
	   ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
	   
	   for(int i=0; i<n ;i++) {
		   adj.add(new ArrayList<Integer>());
	   }
	   
	   for(List<Integer> it : connections) {
		   int u = it.get(0);
		   int v = it.get(1);
		   adj.get(u).add(v);
		   adj.get(v).add(u);
	   }
	   
	   boolean[] visited = new boolean[n];
	   int[] tm = new int[n];
	   int[] low = new int[n];
	   List<List<Integer>> briges = new ArrayList<>();
	   
	   dfs(0,-1,visited, tm , low , adj, briges);
	   
	   return briges;   
   }


	private static void dfs(int i, int j, boolean[] visited, int[] tm, int[] low, ArrayList<ArrayList<Integer>> adj,
			List<List<Integer>> briges) {
		visited[i] = true;
		tm[i] = low[i] = timer;
		timer++;
		for(int key : adj.get(i)) {
			if(key==j) continue;
			
			if(visited[key]==false) {
				dfs(key, i, visited, tm , low, adj,briges);
				
				low[i] = Math.min(low[i], low[key]);
				
				if(low[key]>tm[i]) {
					briges.add(Arrays.asList(i,key));
				}
				
			}else {
				low [i] = Math.min(low[i], low[key]);
			}
			
		}

	}
	
	// Articulation point -> DFS
	public static ArrayList<Integer> articulationPoints(int n, ArrayList<ArrayList<Integer>> adj) {
         int[] tm = new int[n];
         int[] low = new int[n];
         boolean[] mark = new boolean[n];
         boolean[] visited = new boolean[n];
         for(int i=0; i<n;i++) {
         for(int key : adj.get(i)) {
        	if(!visited[key]) {
        		dfs(key,-1 , tm , low , adj , mark , visited);
        	}
         }
         }
         
         ArrayList<Integer> list = new ArrayList<Integer>();
         for(int i=0;i<n;i++) {
        	 if(mark[i]) {
        		list.add(i); 
        	 }
         }
         return list;
	}
	


	private static void dfs(int node, int parent, int[] tm, int[] low, ArrayList<ArrayList<Integer>> adj, boolean[] mark,
			boolean[] visited) {
		visited[node] = true;
		tm[node]= low[node] = timer;
		timer++;int count=0;
		for(int key : adj.get(node)) {
			count++;
			if(key==parent) continue;
			if(!visited[key]) {
				dfs(key, node, tm,low, adj,mark,visited);
				low[node] = Math.min(low[node], low[key]);
				if(low[key]>=tm[node] && parent!=-1) {
					mark[node] = true;
				}
			}else {
				low[node] = Math.min(low[node], low[key]);
			}
			if(parent==-1 && count>1) {
				mark[node] = true;
			}
		}
		
		
	}
   
}
