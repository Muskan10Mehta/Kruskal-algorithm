import java.util.*;

public class UnionFind {
    
     private int[] parent;
     private byte[] rank;
     private int count;
     
     public UnionFind(int n) {
     	if(n < 0)
	{
	   System.out.println("Invalid number of elements");
	   System.exit(1);
	}
	count = n;
	parent = new int[n];
	rank = new byte[n];

	for(int i = 0; i < n; i++){
	   parent[i] = i;
	   rank[i] = 0;
	}
     }     

     public int find(int p) {
 	while(p != parent[p]) {
	   parent[p] = parent[parent[p]];
	   p = parent[p];
	}
	return p;
     }


     public int count() {
     	return count;
     }

     @Deprecated
     public boolean connected(int p, int q) {
     	return find(p) == find(q);
     }

     public void union(int p, int q) {
     	int rootP = find(p);
	int rootQ = find(q);
	if(rootP == rootQ) return;

	if (rank[rootP] < rank[rootQ]) parent[rootP] = rootQ;
	else if (rank[rootP] > rank[rootQ]) parent[rootQ] = rootP;
	else {
	    parent[rootQ] = rootP;
	    rank[rootP]++;
	}
	count--;
     }

     private void validate(int p) {
     	int n = parent.length;
	if(p < 0 || p >= n) {
	   System.out.println("Index is not between 0 and " + (n - 1));
	   System.exit(1);
	}
     }
}
