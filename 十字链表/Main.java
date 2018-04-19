package ʮ������;

public class Main {

	private HeadNode[] headNode; // �洢ͷ�ڵ������

	// ����
	public class HeadNode {
		public char data; // ���ڵ��д洢����Ϣ
		public NextNode firstIn; // �Ըýڵ�Ϊ��ͷ�ĵ�һ���ڵ�
		public NextNode firstOut;// �Ըýڵ�Ϊ��β�ĵ�һ���ڵ�

		public HeadNode(char data, NextNode firstIn, NextNode firstOut) {
			this.data = data;
			this.firstIn = firstIn;
			this.firstOut = firstOut;
		}
	}

	// ���ڵ�
	public class NextNode {
		public int tvex; // ��ǰ��β����ʼλ��
		public int hvex;// ��ǰ��ͷ����ֹλ��
		public NextNode hlink;// ��ǰ��β��������һ����
		public NextNode tlink; // ��ǰ��ͷ����һ����
		public int info; // ��ǰ����Я������Ϣ����Ȩֵ

		public NextNode(int hvex, int tvex, NextNode hlink, NextNode tlink,
				int info) {
			this.hvex = hvex;
			this.tvex = tvex;
			this.hlink = hlink;
			this.tlink = tlink;
			this.info = info;
		}

	}

	// ��ʼ���ڵ�����
	public void initNode(char[] node) {
		if (node == null) {
			return;
		}
		this.headNode = new HeadNode[node.length];
		for (int i = 0; i < node.length; i++) {
			HeadNode temp = new HeadNode(node[i], null, null);
			headNode[i] = temp;
		}
	}

	// ��ʼ������ʮ������
	public void initEdge(char[][] edgs) {
		if (edgs == null) {
			return;
		}// ��׳���ж�
		for (int i = 0; i < edgs.length; i++) {
			// ��ȡ��ʼ����ֹ���λ��
			int begin = getPosition(edgs[i][0]);
			int end = getPosition(edgs[i][1]);
			// ������һ�ڵ�Ԫ��
			NextNode temp = new NextNode(begin, end, null, null, 0);
			// �Ըû��Ļ�ͷΪ��ͷ����һ���� ,Ҳ���ǵ�ǰ�ڵ�ǰ������һ����
			temp.hlink = headNode[begin].firstIn;
			// �Ըû��Ļ�βΪ��β����һ������Ҳ���ǵ�ǰ�ڵ����һ����
			temp.tlink = headNode[end].firstOut;
			// �޸Ķ��������е�������ֵ
			headNode[begin].firstIn = temp;
			headNode[end].firstOut = temp;
		}

	}

	// �ҵ���ǰԪ��λ�õķ���
	public int getPosition(char node) {
		int index = -1;
		for (int i = 0; i < headNode.length; i++) {
			if (headNode[i].data == node) {
				index = i;
				break;
			}
		}
		return index;
	}

	public void print() {
		System.out.println("�ڽӱ�����");
		for (int i = 0; i < headNode.length; i++) {
			NextNode temp = headNode[i].firstIn;
			if(temp == null){
				System.out.println(headNode[i].data+"---->"+"null");
				continue;
			}
			while(temp!= null){
				System.out.print(headNode[i].data+"---->"+headNode[temp.tvex].data+"  ");
				temp = temp.hlink;
			}
			System.out.println();
		}
		System.out.println("���ڽӱ�����");
		for(int i=0;i<headNode.length;i++){
			NextNode temp = headNode[i].firstOut;
			if(temp == null){
				System.out.println(headNode[i].data+"<----"+"null");
				continue;
			}
			while(temp!=null){
				System.out.print(headNode[i].data+"<----"+headNode[temp.hvex].data+" ");
				temp = temp.tlink;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		char[] node = { 'A', 'B', 'C', 'D', };
		char[][] edgs = new char[][] { 
				{ 'A', 'B' }, 
				{ 'A', 'D' },
				{ 'A', 'C' },
				{ 'B', 'C' }, 
				{ 'B', 'D' }, 
				{ 'C', 'D' }, };
		Main m = new Main();
		// ��ʼ��ͷ���
		m.initNode(node);
		// ��ʼ�����ڵ�
		m.initEdge(edgs);
		// ���
		m.print();
	}
}
