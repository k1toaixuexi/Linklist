//清理缓存之先进先出策略 FIFO  （其余两种策略分别为LFU和LRU）
//LFU最少使用 需要利用hashmap进行次数统计
//LRU最近最少使用 利用单链表实现
//FIFO的单链表实现
public class FIFO<T> {
	
	//intialize the default capacity
	public final static Integer DEFAULT_CAPACITY = 10;
	// capacity
	private int cap;
	
	private int length;
	
	private Node<T> head;

	public FIFO(){
		this.cap = DEFAULT_CAPACITY;
		this.length=0;
		this.head = new Node();
	}
	
	public FIFO(int cap) {
		this.cap = cap;
		this.length =0;
		this.head = new Node();
	}
	
	public boolean isEmpty() {
		if(length!=0) {
			return false;
		}else {
			return true;
		}
	}
	
	public boolean isExist(T data) {
		if(isEmpty()) {
			return false;
		}
		Node temp = head;
		while(temp!=null) {
			if(data.equals(temp.value)) {
				return true;
			}
			temp = temp.getNext();
		}
		return false;
	}
	
	public void insert(T data) {
		if(isExist(data)) {
			return;
		}
		if(length>=cap) {
			deleteEnd();
		}
		Node node = new Node(data,head.getNext());
		head.setNext(node);
		length++;
	}
	
	private void deleteEnd() {

		Node temp = head;
		while(temp.getNext().getNext()!=null) {
			temp = temp.getNext();
		}
		temp.setNext(null);
		length--;
	}
	
	public void printAll() {
		if(isEmpty()) {
			System.out.println("This list is empty");
		}else {
			Node a = head.getNext();
			while(a!=null) {
				System.out.print(a.getElement()+",");
				a = a.getNext();
			}
		}
		System.out.println();
	}
	
	class Node<T>{
		T value;
		Node next;
	
		//initialize the head
		public Node() {
			this.next = null;
		}
		//initialize the node
		public Node(T data) {
			this.value = data;
		}
		//initialize the node with next node
		public Node(T data, Node next) {
			this.value = data;
			this.next = next;
		}
	
		public T getElement() {
			return value;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
	}
	
	public static void main(String[] args) {
		FIFO list = new FIFO(3);
		Scanner sc = new Scanner(System.in);
		while(true) {
			list.insert(sc.nextInt());
			list.printAll();
		}
	}
}

