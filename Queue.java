import java.util.*;
import java.io.*;

public class Queue {

    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    Queue(int initCapacity) {

    	queue = new int[initCapacity];
	capacity = initCapacity;
	front = 0;
	rear = -1;
	size = 0;
    }

    public int size(){
    	return size;
    }

    public boolean isEmpty() {
    	return size == 0;
    
    }

    public boolean isFull() {
    	return rear == capacity - 1;
    }

    public void enqueue(int value) {
    	
	if(isFull()) System.exit(-1);
        
	rear = rear + 1;
	queue[rear] = value;
	size++;
	    
    }

    public int dequeue() {
    	
	if(isEmpty()) System.exit(-1);

	int value = queue[front];

	front++;
	size--;
	

	return value;
    }

    public int peek() {
    	if(isEmpty()){
	   System.out.println("overflow.");
	   System.out.println(-1);
	}

	return queue[front];
    }

}
