package ����.��ʽ;

public class Main {
	public class Node {
		public int data;
		public Node next;
	}

	private Node front;// ͷָ��
	private Node rear;// βָ��

	private Node linkedList; // ȫ�ֲ�������

	// ��ʼ���ķ���
	public void init() {
		// ����һ����������front ��rearָ�����ͷ���,ͷ����в��洢��Ϣ
		linkedList = new Node();
		front = linkedList;
		rear = linkedList;
	}

	// ���
	public void push(int number) {
		Node n = new Node();
		n.data = number;
		n.next = null;
		// ����ǰ��ĩβ���ָ������²���Ľڵ�λ��
		rear.next = n;
		rear = n;
	}

	// �жϵ�ǰ�����Ƿ�Ϊ��
	public boolean isEmpty() {
		if (front == rear) {
			return true;
		} else {
			return false;
		}
	}

	// ����
	public int pop() {
		if (front == rear) {
			return -1; // ��ǰԪ��Ϊ�ջ�Ҫ��ջ�Ĵ�����
		} else {
			Node result = front.next;// �������ӵ�Ԫ��ָ��
			front.next = result.next;// ��ͷ���ָ��ָ����ӵ���һ��
			// �жϵ�ǰ�����Ƿ�ֻ��һ��Ԫ�أ����ֻ��һ���Ļ�rearҲ��Ҫ�����޸�
			if (front.next == null) {
				rear = front; // ����˿ն�����
			}
			return result.data;
		}
	}
	//��ǰ������Ԫ�ظ���
	public int length(){
		Node temp = front.next;
		int count = 0;
		while(temp!=null){
			count++;
			temp = temp.next;
		}
		return count;
	}
	@SuppressWarnings("unused")
	//����ǰ�����ÿ�
	public void clean(){
		Node temp = front.next;
		Node temp2 = temp;
		while(temp != null){
			temp = temp.next;
			temp2 = null;//����ǰ�ڵ��ÿ�
		}
		rear = front;
	}
	public static void main(String[] args){
		Main m = new Main();
		m.init();
		m.push(1);
		m.push(2);
		m.push(3);
		System.out.println(m.length());
		m.pop();
		m.pop();
		m.pop();
		System.out.println(m.isEmpty());
		m.push(1);
		m.push(2);
		m.push(3);
		m.clean();
		System.out.println(m.isEmpty());
	}
}
