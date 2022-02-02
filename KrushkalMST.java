import java.util.*;

public class KrushkalMST {

   private Queue<Edge> mst = new Queue<Edge>();

   public KrushkalMST(EdgeWeightedGraph G) {
   	MinPriorityQueue<Edge> pq = new MinPriorityQueue<Edge>();

	for(Edge e : G.edges()) {
	    pq.insert(e);
	}

	UF uf = new UF(G.V());
	while(!pq.isEmpty() && mst.size() < G.V() - 1) {
	    Edge e = pq.poll();
	    int v = e.either();
	    int w = e.other(v);

	    if(!uf.connected(v, w)) {
	    	uf.union(v, w);
		mst.enqueue(e);
	    }
	}
   }

   public Iterable<Edge> edges(){
   	return mst;
   }

}
