import java.util.Scanner;

public class LinkedList<T> {
	
	//Ĭ����������
	private final static Integer DEFAULT_CAPACITY = 5;
	//ͷ���
	private SNode<T> head;
	//������
	private int length;
	//��������
	private Integer cap;
	//��ͷָ��
	public LinkedList() {
		this.head = new SNode<>();
		this.cap = DEFAULT_CAPACITY;
		this.length = 0;
	}
	//�вεĹ��캯��
	public LinkedList(int cap) {
		this.cap= cap;
		this.length = 0;
		this.head = new SNode<>();
	}
	//������ͷ������ڵ�
	private void insertHead(T data) {
		SNode next = head.next;
		head.setNext(new SNode(data,next)); 
		length++;
	}
	//ɾ��β�ڵ�
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
	//�ҵ�ɾ���ڵ��ǰһ���ڵ�
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
	//ɾ���ڵ�
	private void deleteNode(SNode pre) {
		SNode node = pre.getNext();
		pre.setNext(node.getNext());
		node = null;
		length--;
	}
	//��ӽڵ�
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
		//�����е�t����ָһ�൫��һ�໹û��ȷ�����ͣ� T��Ҫ��ʾ��ָ��һ��
		private T element;
		private SNode next;
		//��ȷ��next�Ľڵ�
		public SNode(T element) {
			this.element = element;
		}
		//��ͷָ��Ĺ��캯��
		public SNode(T element, SNode next) {
			this.element = element;
			this.next = next;
		}
		//ͷָ�빹�캯��
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