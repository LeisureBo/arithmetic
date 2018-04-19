package �ؼ�·��;

import java.util.Stack;

/*
 * ʹ���ڽӱ�ķ�ʽ�����д洢�����ڽӱ���Ļ����������ǰ����������
 * ����ǰ��֮��Ĺ�ϵ��������������������ֻ�а�ǰ��������֮�������������Ԫ��
 */
public class Main {
	private HeadNode[] headNode; // �ڵ����

	public int[] ve;// ÿ���ڵ����翪ʼʱ��
	public int[] vl;// ÿ���ڵ�����ʼʱ��

	private static final int MAX = Integer.MAX_VALUE; // ���ֵ��ʾ��ǰ����ʼʱ��ĳ�ʼ״̬

	public Stack<Integer> stack;// ���ڴ洢���˾����ջ

	public Stack<Integer> operatorStack;// �������·���д洢��ջ

	// ͷ�����Ϣ
	public class HeadNode {
		public char node; // ͷ�����Ϣ

		public NextNode next; // ��һ�����Ϣ

		public int inDegree; // ǰ���ĸ���
		public int weight; // ��ǰ�ߵ�Ȩֵ��Ϣ

		public HeadNode(char node, NextNode next, int inDegree, int weight) {
			this.node = node;
			this.next = next;
			this.inDegree = inDegree;
			this.weight = weight;
		}

	}

	// ��ͷ��������ӵ���һ�����Ϣ
	public class NextNode {
		public int index; // ��ǰ�ڵ����������е�λ��

		public NextNode next; // ��һ�����Ϣ

		public int weight; // ��ǰ�ߵ�Ȩֵ��Ϣ
		public int inDegree; // ���

		public NextNode(int index, NextNode next, int weight, int inDegree) {
			this.index = index;
			this.next = next;
			this.weight = weight;
			this.inDegree = inDegree;
		}
	}

	// ��ʼ��������
	public void initNode(char[] node) {
		if (node == null) {
			return;
		}
		headNode = new HeadNode[node.length];// ��ʼ��ͷ������鳤���봫��node������ͬ
		for (int i = 0; i < node.length; i++) {
			HeadNode head = new HeadNode(node[i], null, 0, 0);
			headNode[i] = head;
		}
		ve = new int[node.length];
		vl = new int[node.length];
		for (int i = 0; i < node.length; i++) {
			ve[i] = 0;
			ve[i] = MAX;
		}
	}

	// ��ʼ�������ڽӱ�
	public void initTable(char[][] edgs) {
		for (int i = 0; i < edgs.length; i++) {
			char begin = edgs[i][0];// ��ʼֵ
			char end = edgs[i][1];// ��ֵֹ
			int index = 0;// ��ֵֹ�ڳ�ʼ�������е�����λ��
			// �����鵱���ҵ�����λ��
			for (int j = 0; j < headNode.length; j++) {
				if (headNode[j].node == end) {
					index = j;
					break;
				}
			}
			NextNode next = new NextNode(index, null, 0, 0);// ������һ���ڵ�İ�װ��
			// Ϊ�����е�ͷ�����д���
			for (int j = 0; j < headNode.length; j++) {
				if (headNode[j].node == begin) {
					NextNode temp = headNode[j].next;// ��������
					headNode[index].inDegree++; // ��ǰ�ڵ���һ��ǰ���˽���++����
					// ���ͷ������һ�ڵ�Ϊ�յĻ����õ�ǰ���ɵİ�װ��ڵ㸳������ǵ���һ�ڵ�
					if (temp == null) {
						headNode[j].next = next;
					} else {
						// �жϵ�ǰͷ���������û�������������Ľڵ�
						while (temp.next != null) {
							temp = temp.next;
						}
						temp.next = next;
					}
				}
			}
		}
	}

	// ��ӡ����
	public void print(HeadNode[] head) {
		for (int i = 0; i < head.length; i++) {
			System.out.print(head[i].node);
			NextNode temp = head[i].next;
			while (temp != null) {
				System.out.print(" --> ");
				System.out.print(temp.index);
				temp = temp.next;
			}
			System.out.println();
		}
		System.out.println();
	}

	// ��ӡ��������ǰ������
	public void printDegree() {
		for (int i = 0; i < headNode.length; i++) {
			System.out.println("��ǰ�ڵ�Ϊ:" + headNode[i].node + "����ǰ����["
					+ headNode[i].inDegree + "]��");
		}
		System.out.println();
	}

	/*
	 * �������� ˼·��ÿ�ΰ�ǰ��Ϊ0�Ľ��������ȥ��Ȼ�����֮�����ı�ȫ��ȥ����֮�����ظ�����
	 * �ڽӱ��������жϽ���е�inDegree���ԣ����Ϊ0�������ȥ��������ߵ�ʱ����ǰ���������ֱ��������
	 * ����е�inDegree��һ�������ظ������ж�
	 */

	public void topological() {
		// ΪʲôҪ���������������Ϊ����Ҫȥ�޸Ľڵ��ǰ�����������ֱ�Ӳ����ڵ�ᵼ�����������ͼ�Ľṹ���ı���
		// ����ֵ�ĽṹҲ����ÿ���ڵ��е�ԭʼǰ������
		int[] inDegree = new int[headNode.length];// ����ÿ�������������
		int count = 0;// ��ǰ�ѱ����ڵ�ĸ���
		// ����Ĵ洢������ͷ�������
		stack = new Stack<Integer>();
		// ��ѯ����������鵱ǰ��Ϊ0��ʱ��������ջ
		for (int i = 0; i < headNode.length; i++) {
			inDegree[i] = headNode[i].inDegree;// �ѵ�ǰ�ڵ��ǰ��������������ǵ����鵱��ȥ
			if (inDegree[i] == 0) {
				stack.push(i);
				operatorStack.push(i);
			}
		}
		while (!stack.isEmpty()) {
			int index = stack.pop();// ������㲢���
			count++;// ����һ���ڵ��˼ӼӲ���
			System.out.print(headNode[index].node + " ");
			// ���뵱ǰ�ڵ������Ľڵ���Ⱦ���һ��������Ϊ0˵���ɽ���ջ��
			for (NextNode next = headNode[index].next; next != null; next = next.next) {
				int k = next.index;
				if (--inDegree[k] == 0) {
					stack.push(next.index);
					operatorStack.push(next.index);
				}
				// ���ǰһ���ڵ���ϵ�ǰ�ڵ��Ȩֵ�ȵ�ǰ�ڵ����翪ʼʱ���Ļ����� ���õ�ǰ�ڵ�����翪ʼֵΪ���
				if (ve[index] + next.weight > ve[k]) {
					ve[k] = ve[index] + next.weight;
				}
			}
		}
		if (count < headNode.length) {
			System.out.println("��ǰ�����ܹ�������������Ϊ�нڵ㲢û���������ڵ�����");
		}
	}

	// ��ȡ�ؼ�·���ķ���
	public void getCriticalPath() {
		// �������˾��󷽷�����ʼ��ÿ���ڵ�����翪ʼʱ�䣬ջ�б���Ԫ��
		topological();
		int lastIndex = operatorStack.peek();// ��ǰ�Ļ��,�鿴��ǰ�㵫�����Ƴ�
		vl[lastIndex] = ve[lastIndex];// �������翪ʼʱ�������ʼʱ����ͬ����Ϊ�˵�Ϊ�ؼ�·���ϵĵ�
		while (!operatorStack.isEmpty()) {
			int current = operatorStack.pop();// ȡ����ǰ��������
			// �ҳ���ǰ���������ӵĵ�
			for (NextNode next = headNode[current].next; next != null; next = next.next) {
				int after = next.index; // �����������
				// ���ǰһ���ڵ�����ʼʱ���ȥǰһ���ڵ��Ȩֵ�ȵ�ǰ����ʼʱ��ҪС���޸�
				if (vl[after] - next.weight < vl[current]) {
					vl[current] = vl[after] - next.weight;
				}
			}
		}
		// �ж������ڵ�����翪ʼʱ�������ʼʱ���Ƿ���ͬ�������ͬ��Ϊ�ؼ�·���ϵĽڵ�
		for (int i = 0; i < ve.length; i++) {
			for (NextNode next = headNode[i].next; next != null; next = next.next) {
				int k = next.index;
				int ee = ve[i];
				int el = vl[k] - next.weight;
				if (ee == el) {
					System.out.print(i + "," + k + "     ");
				}
			}
		}
	}

	public static void main(String[] args) {
		char[] node = { 'A', 'B', 'C', 'D', 'E', 'F' };
		char[][] edgs = new char[][] { { 'A', 'B' }, { 'A', 'C' },
				{ 'A', 'D' }, { 'B', 'E' }, { 'C', 'E' }, { 'C', 'F' },
				{ 'D', 'E' }, { 'D', 'F' }, };
		Main m = new Main();
		// ��ʼ������ͷ���Ĺ���
		m.initNode(node);
		// ��ʼ���ڽӱ�Ĺ���
		m.initTable(edgs);
		// ��ӡ���
		m.print(m.headNode);
		// ��ӡÿ������ǰ������
		m.printDegree();
		// ��������
		m.topological();
	}
}
