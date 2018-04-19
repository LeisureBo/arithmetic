package ����������������洢;

public class Main {
	// �ڵ�İ�װ��
	public class Node {
		public int data;
		public Node left;
		public Node right;
		public Node father;

		public Node() {

		}

		public Node(int data, Node left, Node right, Node father) {
			this.data = data;
			this.left = left;
			this.right = right;
			this.father = father;
		}
	}

	// ���ڵ�
	private Node root;

	public void add(Node node) {
		// ��׳���ж�
		if (node == null) {
			return;
		}
		// �����ǰΪ������ǰ����ڵ���Ǹ��ڵ����Һ���father��Ϊnull
		if (root == null) {
			root = node;
		} else {
			// ��ǰ����ڵ�ĸ��ڵ��ʼֵΪroot
			Node father = root;
			// ��ǰ����ڵ�λ�ó�ʼֵΪroot
			Node temp = root;
			// �жϵ�ǰ�ڵ������ӻ����Һ���
			boolean flag = false;
			while (temp != null) {
				father = temp;
				// �Ȳ���ڵ������ӱȽ�
				if (temp.data > node.data) {
					flag = false;// ����
					temp = temp.left;
					// �Ȳ���ڵ�С���Һ��ӱȽ�
				} else if (temp.data < node.data) {
					flag = true;// �Һ���
					temp = temp.right;
				} else {
					// ���ֱ�ӷ���
					return;
				}
			}
			if (flag) {
				// ��ǰ�ڵ�����Һ���λ��
				father.right = node;
				node.father = father;
			} else {
				// ��ǰ�ڵ��������λ��
				father.left = node;
				node.father = father;
			}
		}
	}

	public void print(Node root) {
		if (root != null) {
			//�������ʱ��ֱ��ʹ����λ�������ʱ��һ��Ҫ����һ��������Ϊ�����ʱ������λ������������Ը��ƻ���
			System.out.println("��ǰֵΪ��" + root.data + " ���׽ڵ�Ϊ��"+ (root.father == null ? null: root.father.data));
			print(root.left);
			print(root.right);
		}
	}

	public static void main(String[] args) {
		Main m = new Main();
		m.add(m.new Node(10, null, null, null));
		m.add(m.new Node(7, null, null, null));
		m.add(m.new Node(13, null, null, null));
		m.add(m.new Node(3, null, null, null));
		m.add(m.new Node(8, null, null, null));
		m.add(m.new Node(11, null, null, null));
		m.add(m.new Node(16, null, null, null));
		m.add(m.new Node(1, null, null, null));
		m.add(m.new Node(9, null, null, null));
		m.print(m.root);
	}

}
