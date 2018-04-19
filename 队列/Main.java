package ����;

public class Main {

	private static final int MaxSize = 100;

	public class Sequeue {
		public int[] data = new int[MaxSize];
		public int front;// ǰ���ָ��
		public int rear;// �����ָ��
	}

	private Sequeue s;// ������ȫ�ֱ�������

	// ��ʼ������
	public void init() {
		s = new Sequeue();
		s.front = -1;
		s.rear = -1;// ��ʼ״̬��ָ��-1λ��
	}

	// ���
	public void sequeueIn(int number) {
		// ��Ϊ��ǰ��������ѭ��������������ȡ����в���
		if ((s.rear + 1) % MaxSize == s.front) {
			System.out.println("��ǰ��������");
			return;
		} else {
			s.rear = (s.rear + 1) % MaxSize;
			s.data[s.rear] = number;
		}
	}

	// ����
	public int sequeueOut() {
		// ΪʲôҪ����+1��������Ϊ��ǰ������һ��ѭ�����У��м䱣����һ����Ԫ��δ���в�����
		// Ĭ����frontָ�������ָ��Ϊ�յ�Ԫ��λ��
		if (s.rear == s.front) {
			System.out.println("��ǰ����Ϊ��");
			return -1; // ��ǰ����Ϊ�յĴ��󷵻ر��
		} else {
			s.front = (s.front + 1) % MaxSize;
			return s.data[s.front];
		}
	}

	// �ж϶����Ƿ�Ϊ��
	public boolean sequeueEmpty() {
		if (s.front == s.rear) {
			return true;
		} else {
			return false;
		}
	}

	// �������Ԫ�ظ���
	public int sequeueLength() {
		return (s.rear - s.front + MaxSize) % MaxSize;
	}
	public static void main(String []args){
		Main m = new Main();
		m.init();
		m.sequeueIn(1);
		m.sequeueIn(2);
		m.sequeueIn(3);
		System.out.println(m.sequeueLength());
		m.sequeueOut();
		m.sequeueOut();
		m.sequeueOut();
		System.out.println(m.sequeueEmpty());
	}
}
