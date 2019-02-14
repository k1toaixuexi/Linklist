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
		this.head = new SNode();
	}
	//������ķ�ת
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
	//��⻷
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
	//������������С����
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
	//�ҳ���ɾ�����е�����KС��Ԫ��
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
}
