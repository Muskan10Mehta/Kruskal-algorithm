import java.util.*;
import java.io.*;

public class MinPriorityQueue {
    
    private Integer[] pq;
    private int n;
    
    // initializes an empty priority queue
    public MinPriorityQueue(){
    	this(1);
    }

    //initializes an empty priority queue with given initial capacity
    public MinPriorityQueue(int initCapacity){
	pq = new Integer[initCapacity + 1];
	n = 0;
    }

    public boolean isEmpty() {
    	return n == 0;
    }

    public int size() {
    	return n;
    }

    public int min() {
    	if(isEmpty()){
	    System.out.println("Priority Queue is empty.");
	    System.exit(1);
	} 
	return pq[1];
    }

    public void add(int key) {
    	pq[++n] = key;
	swim(n);
    }

    public int poll() {
    	
	if(isEmpty()) {
	    System.out.println("Priority queue is empty.");
	    System.exit(1);
	}

	int min = pq[1];
	swap(1, n--);
	sink(1);
	pq[n + 1] = null; // to help with garbage collection

	return min;
    }

    // helper functions
   

    private void swim(int k) {
    	while(k > 1 && pq[k / 2] > pq[k]) {
	    swap(k, k / 2);
	    k = k / 2;
	}
    }

    private void sink(int k) {
    	while(2 * k <= n) {
	    int j = 2 * k;
	    if(j < n && pq[j] > pq[j + 1]) j++;
	    if(!(pq[k] > pq[j])) break;
	    swap(k, j);
	    k = j;
	
	}
    
    }

    private void swap(int i, int j) {
    	int swap = pq[i];
	pq[i] = pq[j];
	pq[j] = swap;
    }


    /*public static void main(String[] args){

    	MinPriorityQueue mpq = new MinPriorityQueue(5);
	mpq.add(6);
	mpq.add(3);
	mpq.add(7);

	System.out.println(mpq.poll());
	System.out.println(mpq.min());
    
    }*/
}

