import java.util.*;

public class Bag<Item> implements Iterable<Item> {

    private Node<Item> first;
    private int n;

    private static class Node<Item> {
    	private Item item;
	private Node<Item> next;
    }

    public Bag() {
    	first = null;
	n = 0;
    }

    public void add(Item item) {
    	 Node<Item> oldFirst = first;
	 first = new Node<Item>();
	 first.item = item;
	 first.next = oldFirst;
	 n++;
    }

    public boolean isEmpty() {
    	return first == null;
    }

    public int size() {
        return n;
    }

    public Iterator<Item> iterator() {
    	return new CustomIterator(first);
    }


    private class CustomIterator implements Iterator<Item> {
    	private Node<Item> current;

	public CustomIterator(Node<Item> first) {
	     current = first;
	}

	public boolean hasNext() {
	    return current != null;
	}

	public void remove() {
	    throw new UnsupportedOperationException(); 
	}

	public Item next() {
	    if(!hasNext()) throw new NoSuchElementException();
	    Item item = current.item;
	    current = current.next;
	    return item;
	}
    }
}
