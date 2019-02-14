import java.util.Scanner;

public class LinkedList<T> {
	
	//默认链表容量
	private final static Integer DEFAULT_CAPACITY = 5;
	//头结点
	private SNode<T> head;
	//链表长度
	private int length;
	//链表容量
	private Integer cap;
	//有头指针
	public LinkedList() {
		this.head = new SNode<>();
		this.cap = DEFAULT_CAPACITY;
		this.length = 0;
	}
	//有参的构造函数
	public LinkedList(int cap) {
		this.cap= cap;
		this.length = 0;
		this.head = new SNode<>();
	}
	//在链表头部插入节点
	private void insertHead(T data) {
		SNode next = head.next;
		head.setNext(new SNode(data,next)); 
		length++;
	}
	//删除尾节点
	private void deleteTail(){
		SNode node = head;
		if(head.getNext() == null) {
			return;
		}
		while(node.getNext().getNext()!=null) {
			node = node.getNext();
		}
		SNode temp = node.getNext();
		node.setNext(null);
		temp = null;
		length--;
	}
	//找到删除节点的前一个节点
	private SNode findPre(T data) {
		SNode node = head;
		while(node.getNext()!=null) {
			if(node.getNext().getElement()==data) {
				return node;
			}
			node = node.getNext();
		}
		return null;
	}
	//删除节点
	private void deleteNode(SNode pre) {
		SNode node = pre.getNext();
		pre.setNext(node.getNext());
		node = null;
		length--;
	}
	//添加节点
	private void add(T data) {
		if(findPre(data)==null) {
			if(length>=cap) {
				deleteTail();
			}
			insertHead(data);
		}else {
			deleteNode(findPre(data));
			insertHead(data);
		}
	}

	
	private void printAll() {
		SNode node = head.getNext();
		while(node!=null) {
			System.out.print(node.getElement()+",");
			node = node.getNext();
		}
		System.out.println();
	}
	
	public class SNode<T>{
		//泛型中的t就是指一类但这一类还没有确定类型， T主要表示泛指的一类
		private T element;
		private SNode next;
		//不确定next的节点
		public SNode(T element) {
			this.element = element;
		}
		//非头指针的构造函数
		public SNode(T element, SNode next) {
			this.element = element;
			this.next = next;
		}
		//头指针构造函数
		public SNode() {
			this.next = null;
		}
		public T getElement() {
			return element;
		}
		public void setElement(T element) {
			this.element = element;
		}
		public SNode getNext() {
			return next;
		}
		public void setNext(SNode next) {
			this.next = next;
		}
	}
	
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		Scanner sc = new Scanner(System.in);
		while(true) {
			ll.add(sc.next());
			ll.printAll();
		}
	}
}