import java.util.*;
import java.lang.*;

public class EdgeWeightedGraph {

    private final int V;
    private int E;
    private Bag<Edge>[] adj;

    public EdgeWeightedGraph(int V) {

    	if(V < 0) 
	    throw new IllegalArugmentException("Number of vertices should be non-negative integer.");
	this.V = V;
	this.E = 0;
	adj = (Bag<Edge>[]) new Bag[V];
	for(int i = 0; i < V; i++){
	    adj[i] = new Bag<Edge>();
	}
    }

    public EdgeWeightedGraph(int V, int E) {
    	this(V);
	if(E < 0) throw new IllegalArgumentException("Number of edges should be non-negative integer.");
	for(int i = 0; i < E;i++){
	    int v = V;
	    int w = V;
	    double weight = 0;
	    Edge e = new Edge(v, w, weight);
	    addEdge(e); 
	}
    }

    public int V() {
	return V;
    }
    public int E() { 
	return E;
    }
    
    public void addEdge(Edge e) {
    	int v = e.either();
	int w = e.other(v);

	adj[v].add(e);
	adj[w].add(e);
	E++;
    
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    public int degree(int v) {
    	return adj[v].size();
    }

    public Iterable<Edge> edges() {
    
    	Bag<Edge> list = new Bag<Edge>();

	for(int v = 0; v < V; v++){
	    
	    int selfLoops = 0;

	    for(Edge e: adj(v)){

	    	if(e.other(v) > v){
		    list.add(e);
		}

		else if(e.other(v) == v){
		    if(selfLoops % 2 == 0) list.add(e);
		    selfLoops++;
		}
	    
	    }
	
	}

	return list;
    }
}
