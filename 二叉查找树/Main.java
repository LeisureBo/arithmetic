package ���������;

import java.util.LinkedList;
import java.util.Scanner;


public class Main {
	class Node {
		private int data;
		private Node lNode;
		private Node rNode;

		public Node() {

		}

		public Node(int data, Node lNode, Node rNode) {
			this.data = data;
			this.lNode = lNode;
			this.rNode = rNode;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getlNode() {
			return lNode;
		}

		public void setlNode(Node lNode) {
			this.lNode = lNode;
		}

		public Node getrNode() {
			return rNode;
		}

		public void setrNode(Node rNode) {
			this.rNode = rNode;
		}
	}

	// ͨ��ջ�ķ�ʽ�����а�����б���������ڵ� ��Ŀ��������û�и���������Ǻ��ķ����������
	public void search_Level(Node root) {
		if (root != null) {
			Node temp = root;
			LinkedList<Node> list = new LinkedList<Node>();
			list.add(temp);
			while (!list.isEmpty()) {
				temp = list.poll();
				System.out.print(temp.getData() + " ");
				if (temp.getlNode() != null) {
					list.add(temp.getlNode());
				}
				if (temp.getrNode() != null) {
					list.add(temp.getrNode());
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String first = sc.nextLine();
			String second = sc.nextLine();
			String[] f = first.split(" ");
			int[] ff = new int[f.length];
			String[] s = second.split(" ");
			int[] ss = new int[s.length];
			for (int i = 0; i < f.length; i++) {
				ff[i] = Integer.parseInt(f[i]);
			}
			for (int i = 0; i < s.length; i++) {
				ss[i] = Integer.parseInt(s[i]);
			}
		}
		sc.close();
	}
}