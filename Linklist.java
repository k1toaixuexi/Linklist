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
		this.head = new SNode();
	}
	//单链表的反转
	public SNode reverse(SNode list) {
		SNode head = null;
		SNode currentNode = list;
		SNode previousNode = null;
		while(currentNode.getNext()!=null) {
			SNode nextNode = currentNode.getNext();
			currentNode.setNext(previousNode);
			previousNode = currentNode;
			currentNode = nextNode;
		}
		head = currentNode;
		return head;
	}
	//检测环
	public boolean checkCircle(SNode list) {
		if (list == null) return false;
		SNode slow = list;
		SNode fast = list;
		while(fast.getNext()!=null&&fast.getNext().getNext()!=null) {
			fast = fast.getNext().getNext();
			slow = slow.getNext();
			if(fast == slow) {
				return false;
			}			
		}
		return true;
	}
	//连接有序链表，小到大
	public SNode mergeList(SNode a, SNode b) {
		if(b==null) return a;
		if(a==null) return b;
		SNode head;
		if(a.getElement()>b.getElement()) {
			head = b;
			b=b.getNext();
		}else {
			head = a;
			a=a.getNext();
		}
		SNode r = head;
		while(a.getNext()!=null&&b.getNext()!=null) {
			if(a.getElement()>b.getElement()) {
				r.setNext(b);
				b= b.getNext();
			}else {
				r.setNext(a);
				a = a.getNext();
			}
			r = r.getNext();
		}
		if(a == null) {
			r.setNext(b);
		}else {
			r.setNext(a);
		}
		return head;
	}
	//找出并删除队列倒数第K小的元素
	public SNode deleteLastMinK(SNode list,int k) {
		SNode fast = list;
		int i = 1;
		while(fast.getNext()!=null&&i<k) {
			fast= fast.getNext();
			++i; 
		}
		if(fast==null) return null;
		SNode slow = list;
		SNode previous = null;
		while(fast.getNext()!=null) {
			fast = fast.getNext();
			previous = slow;
			slow = slow.getNext();
		}
		previous.setNext(slow.getNext());
		return slow;
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
}
