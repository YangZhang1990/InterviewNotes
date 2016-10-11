class LRUCache{
	class Node{
		Integer key;
		Integer value;
		Node prev;
		Node next;

		Node(Integer key, Integer value){
			this.key = key;
			this.value=value;
			prev=null;
			next = null;
		}
	}
	private HashMap<Integer,Node>map;
	private int capacity;
	private Node head;
	private Node tail;

	public LRUCache(int capacity){
		map = new HashMap<Integer,Node>();
		this.capacity=capacity;
		head = new Node(null, null);
		tail = new Node(null, null);
		head.prev=tail;
		head.next=tail;
		tail.prev=head;
		tail.next=head;
	}

	public Integer get(int key){
		Node node= map.get(key);
		//2 bugs
		if(node !=null){
			//update LRU order
			detach(node);
			attach(node);
		}
		return node=null?null:node.value;
	}

	public void set(int key, int value){
		Node node = map.get(key);
		if(node==null){
			if(map.size()==capacity){
				map.remove(head.next.key);
				detach(head.next);
			}
			node= new Node(key,value);
			map.put(key,node);
			attach(node);
		}else {
			node.value= value;
			detach(node);
			attach(node);
		}
	}

	void detach(Node node){
			node.prev.next= node.next;
			node.next.prev= node.prev;
			node.prev = null;
			node.next=null;
	}
	void attach(Node node){
		node.next=tail;
		node.prev=tail.prev;
		tail.prev.next=node;
		tail.prev=node;
	}

}

//java LinkedHashMap?
class LRUCache<K,V> extends LinkedHashMap<K,V>{
	private int capacity;
	LRUCache(int capacity){
		super(128,0.75f,true);
		this.capacity=capacity;
	}
	@Override
	public boolean removeEldestEntry(Map.Entry<K,V> eldest){
		return size()>capacity;
	}
}
import java.io.*;
import java.util.*;

public class Solution{
	public static void public static void main(String[] args) {
		Scanner in = new Scanner(new File("input.txt"));
		//read input process
		int n = in.nextInt();

		while(n!=-1){
			LRUCache cache = new LRUCache(n);
			int m = in.nextInt();
			while(m--!=0){
				int.nextLine();
				String op = in.next();
				if(op.equals("SET")){
					cache.put(int.nextInt(),int.nextInt());
				}else{
					System.out.println(cache.get(in.nextInt()));
				}
			}
			n=in.nextInt();

		}
	}

}