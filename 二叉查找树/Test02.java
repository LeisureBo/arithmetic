package ���������;

import java.util.LinkedList;
import java.util.Stack;

<<<<<<< HEAD
public class Test02 {
	public class Node {
		private int data;
		private Node lNode;
		private Node rNode;

		public Node() {

		}

		public Node(int data, Node lNode, Node rNode) {
=======
import ƽ�������.BalenceTree.Node;

public class Test02 {
	public class Node{
		private int data;
		private Node lNode;
		private Node rNode;
		public Node(){
			
		}
		public Node(int data,Node lNode,Node rNode){
>>>>>>> 11ed81fa09fa0c4efe13ded27b218a9c191a29fc
			this.data = data;
			this.lNode = lNode;
			this.rNode = rNode;
		}
<<<<<<< HEAD

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

=======
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
>>>>>>> 11ed81fa09fa0c4efe13ded27b218a9c191a29fc
		public void setrNode(Node rNode) {
			this.rNode = rNode;
		}
	}
<<<<<<< HEAD

	public Node root;

	public void add(int data) {

		Node node = new Node(data, null, null);
		Node current = root;
		Node father = root;

		boolean flag = false;
		if (root == null) {
			root = node;
		} else {
			while (current != null) {
				father = current;
				if (current.getData() > data) {
					current = current.getlNode();
					flag = false;
				} else if (current.getData() < data) {
					current = current.getrNode();
					flag = true;
				} else {
					return;
				}
			}
			if (!flag) {
				father.setlNode(node);
			} else {
=======
	public Node root;
	public void add(int data){
		
		Node node = new Node(data,null,null);
		Node current = root;
		Node father = root;
		
		boolean flag = false;
		if(root == null){
			root = node;
		}else{
			while(current != null){
				father = current;
				if(current.getData() > data){
					current = current.getlNode();
					flag = false;
				}else if(current.getData() < data){
					current = current.getrNode();
					flag = true;
				}else{
					return ;
				}
			}
			if(!flag){
				father.setlNode(node);
			}else{
>>>>>>> 11ed81fa09fa0c4efe13ded27b218a9c191a29fc
				father.setrNode(node);
			}
		}
	}
<<<<<<< HEAD

	public void add(Node node) {
		Node current = root;
		Node father = root;
		boolean flag = false;
		if (root == null) {
			root = node;
		} else {
			while (current != null) {
				father = current;
				if (current.data > node.data) {
					current = current.lNode;
					flag = false;
				} else if (current.data < node.data) {
					current = current.rNode;
					flag = true;
				} else {
					return;
				}
			}
			if (!flag) {
				father.lNode = node;
			} else {
				father.rNode = node;
			}
		}
	}

	public void DLR(Node node) {
		if (node != null) {
			System.out.print(node.getData() + "  ");
=======
	
	public void DLR(Node node){
		if(node != null){
			System.out.print(node.getData()+"  ");
>>>>>>> 11ed81fa09fa0c4efe13ded27b218a9c191a29fc
			DLR(node.getlNode());
			DLR(node.getrNode());
		}
	}
<<<<<<< HEAD

	public void LDR(Node node) {
		if (node != null) {
			LDR(node.getlNode());
			System.out.print(node.getData() + "  ");
			LDR(node.getrNode());
		}
	}

	public void DLR_2(Node root) {
		if (root != null) {
			Node temp = root;
			Stack<Node> stack = new Stack<Node>();
			while (temp != null || !stack.isEmpty()) {
				if (temp != null) {
					// �����ǰλ�õ���ֵ
					System.out.print(temp.getData() + " ");
					stack.push(temp);
					temp = temp.getlNode();
				} else {
=======
	public void LDR(Node node){
		if(node != null){
			LDR(node.getlNode());
			System.out.print(node.getData()+"  ");
			LDR(node.getrNode());
		}
	}
	
	public void DLR_2(Node root){
		if(root != null){
			Node temp = root;
			Stack<Node> stack = new Stack<Node>();
			while(temp != null || !stack.isEmpty()){
				if(temp != null){
					//�����ǰλ�õ���ֵ
					System.out.print(temp.getData()+" ");
					stack.push(temp);
					temp = temp.getlNode();
				}else{
>>>>>>> 11ed81fa09fa0c4efe13ded27b218a9c191a29fc
					temp = stack.pop();
					temp = temp.getrNode();
				}
			}
		}
	}
<<<<<<< HEAD

	public void LRD_2(Node root) {
		if (root != null) {
			Stack<Node> stack = new Stack<Node>();
			Stack<Node> outStack = new Stack<Node>();
			Node temp = root;
			while (temp != null || !stack.isEmpty()) {
				if (temp != null) {
					stack.push(temp);
					outStack.push(temp);
					temp = temp.getrNode();
				} else {
=======
	
	public void LRD_2(Node root){
		if(root != null){
			Stack<Node> stack = new Stack<Node>();
			Stack<Node> outStack = new Stack<Node>();
			Node temp = root;
			while( temp!= null || !stack.isEmpty() ){
				if(temp!=null){
					stack.push(temp);
					outStack.push(temp);
					temp = temp.getrNode();
				}else{
>>>>>>> 11ed81fa09fa0c4efe13ded27b218a9c191a29fc
					temp = stack.pop();
					temp = temp.getlNode();
				}
			}
<<<<<<< HEAD
			while (!outStack.isEmpty()) {
				System.out.print(outStack.pop().getData() + " ");
			}
		}
	}

	

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
=======
			while(!outStack.isEmpty()){
				System.out.print(outStack.pop().getData()+" ");
			}
		}
	}
	
	public int search_deap(Node root){
		if(root == null){
			return 0;
		}else{
			int left = 1;
			int right = 1;
			left += search_deap(root.getlNode());
			right += search_deap(root.getrNode());
			return left>right?left:right;
		}
	}
	public void search_Level(Node root){
		if(root != null){
			Node temp = root;
			LinkedList<Node> list = new LinkedList<Node>();
			list.add(temp);
			while(!list.isEmpty()){
				temp = list.poll();
				System.out.print(temp.getData()+" ");
				if(temp.getlNode()!=null){
					list.add(temp.getlNode());
				}
				if(temp.getrNode()!=null){
>>>>>>> 11ed81fa09fa0c4efe13ded27b218a9c191a29fc
					list.add(temp.getrNode());
				}
			}
		}
	}
<<<<<<< HEAD

	public int search_deap(Node root) {
		if (root == null) {
			return 0;
		} else {
			int left = 1;
			int right = 1;
			left += search_deap(root.getlNode());
			right += search_deap(root.getrNode());
			return left > right ? left : right;
		}
	}
	
	// ��һ�������ǣ�Ҫ��ӡ������һ���� �ڶ����������洢��ֵ����ֵ���������ǵ�ǰ·���ĳ���
	// ���������õĶ���ͬһ������洢�ó��������Ƶ�ǰ��·������
	public void print(Node root, int[] path, int size) {
		if (root == null) {
			return;
		} else {
			path[size++] = root.getData();
			// ˵����ʱ��ΪҶ�ӽ��
			if (root.getlNode() == null && root.getrNode() == null) {
				for (int i = 0; i < size; i++) {
					System.out.print(path[i] + " ");
				}
				System.out.println();
			} else {
				print(root.getlNode(), path, size);
				print(root.getrNode(), path, size);
			}
		}
	}

	public int judgeFactor(Node node) {
		if (node == null) {
			return 0;
		} else {
=======
	//��һ�������ǣ�Ҫ��ӡ������һ���� �ڶ����������洢��ֵ����ֵ���������ǵ�ǰ·���ĳ���
	//���������õĶ���ͬһ������洢�ó��������Ƶ�ǰ��·������
	public void print(Node root,int[] path,int size){
		if(root == null){
			return ;
		}else{
			path[size++] = root.getData();
			//˵����ʱ��ΪҶ�ӽ��
			if(root.getlNode() == null && root.getrNode() == null){
				for(int i=0;i<size;i++){
					System.out.print(path[i]+" ");
				}
				System.out.println();
			}else{
				print(root.getlNode(),path,size);
				print(root.getrNode(),path,size);
			}
		}
	}
	
	public int judgeFactor(Node node){
		if(node == null){
			return 0;
		}else{
>>>>>>> 11ed81fa09fa0c4efe13ded27b218a9c191a29fc
			int left = judgeChildren(node.getlNode());
			int right = judgeChildren(node.getrNode());
			return left - right;
		}
	}
<<<<<<< HEAD

	public int judgeChildren(Node node) {
		if (node != null) {
=======
	public int judgeChildren(Node node){
		if(node!=null){
>>>>>>> 11ed81fa09fa0c4efe13ded27b218a9c191a29fc
			int left = 1;
			int right = 1;
			left += judgeChildren(node.getlNode());
			right += judgeChildren(node.getrNode());
<<<<<<< HEAD
			return left > right ? left : right;
		} else {
			return 0;
		}
	}

	// ɾ���ڵ�ķ���
	public void deleteNode(Node node) {
		// ɾ��Ԫ��Ϊ��ֱ�ӷ���
		if (node == null || root == null) {
			return;
		}
		// ��һ����ȥԭ���������Ƿ���ڵ�ǰԪ��
		Node temp = root;// ��ʱ��������
		Node father = temp;// ��ǰ��������ĸ����󣬸��ڵ㸸����Ĭ��Ϊ�Լ�
		boolean flag = false;
		// ��Ѱ��ǰ�����Ƿ����Լ�Ԫ��
		while (temp != null) {
			if (node.data == temp.data) {
				flag = true;
				break;
			} else if (node.data > temp.data) {
				father = temp;
				temp = temp.rNode;
			} else {
				father = temp;
				temp = temp.lNode;
			}
		}
		// ���û��ֱ�ӷ���
		if (!flag) {
			return;
		}
		// �����ǰԪ�ش��ڽ����ж�
		// �����������һ���ǵ�ǰԪ��û�����ӵ������ֱ�Ӱѵ�ǰɾ��Ԫ�صĸ��ڵ�ָ���Һ���
		// �ڶ�������������ӣ����������ҳ�һ�����Ԫ�ظ���ǰɾ��Ԫ�ز��޸�ָ��ָ��
		if (temp.lNode == null) {//��ǰ����Ϊ��
			if (temp == root) {//���統ǰҪɾ��Ԫ��Ϊ���ڵ㣬ֱ���ø��ڵ�����Һ���
				root = root.rNode;
			} else {
				if (father.lNode == temp) {//���Ҫɾ�����ǵ�ǰ���ڵ�����ӵĻ����������ӵ��ڵ�ǰԪ�ص��Һ���
					father.lNode = temp.rNode;
				} else {//���Ҫɾ�����ǵ�ǰ���ڵ���Һ��ӵĻ��������Һ��ӵ��ڵ�ǰԪ�ص��Һ���
					father.rNode = temp.rNode;
				}
			}
		} else {
			Node q = temp;// ��ǰ�Ĵ�ɾԪ��
			Node s = temp.lNode;// ��ǰ��ɾԪ������
			while (s.rNode != null) {// �ڵ�ǰԪ���Һ����������Ԫ��
				q = s; // qָ����ǵ�ǰ����Һ����еĸ��ڵ�
				s = s.rNode;
			}
			temp.data = s.data;//�ѵ�ǰ��ɾԪ���������е����ֵ�������ǵĴ�ɾԪ��
			if (q != temp) {//�����temp����˵����ǰ�������в������ҷ�֦
				q.rNode = s.lNode;//�õ�ǰ�����������Ԫ�ؽڵ�ĸ��ڵ���Һ���ָ��ǰ�����������Ԫ�ؽڵ������
			} else {
				temp.lNode = s.lNode;//���統ǰ��������û���ҷ�֦��ֱ���õ�ǰ��ɾԪ�ص����ӵ������ӵ�����
				//��Ϊ��ʱtemp �Ѿ�������s��ֵ��
			}
		}
	}

	public static void main(String[] args) {
		Test02 tt = new Test02();
		Node node1 = tt.new Node(6, null, null);
		Node node2 = tt.new Node(3, null, null);
		Node node3 = tt.new Node(4, null, null);
		Node node4 = tt.new Node(2, null, null);
		Node node5 = tt.new Node(7, null, null);
		Node node6 = tt.new Node(1, null, null);
		Node node7 = tt.new Node(8, null, null);
		Node node8 = tt.new Node(5, null, null);
		tt.add(node1);
		tt.add(node2);
		tt.add(node3);
		tt.add(node4);
		tt.add(node5);
		tt.add(node6);
		tt.add(node7);
		tt.add(node8);
//		tt.add(6);
//		tt.add(3);
//		tt.add(4);
//		tt.add(2);
//		tt.add(7);
//		tt.add(1);
//		tt.add(8);
//		tt.add(5);
		Node node = tt.new Node(100, null, null);
		tt.deleteNode(node);
=======
			return left>right?left:right;
		}else{
			return 0;
		}
	}
	
	public static void main(String[] args){
		Test02 tt = new Test02();
		tt.add(6);
		tt.add(3);
		tt.add(4);
		tt.add(2);
		tt.add(7);
		tt.add(1);
		tt.add(8);
		tt.add(5);
>>>>>>> 11ed81fa09fa0c4efe13ded27b218a9c191a29fc
		tt.DLR(tt.root);
		System.out.println();
		tt.LDR(tt.root);
		System.out.println();
		System.out.println("�ǵݹ�ǰ�����");
		tt.DLR_2(tt.root);
		System.out.println();
		System.out.println("�ǵݹ�������");
		tt.LRD_2(tt.root);
		System.out.println();
		System.out.println("�������");
		tt.search_Level(tt.root);
		System.out.println();
		System.out.println("��ǰ��������");
		System.out.println(tt.search_deap(tt.root));
		System.out.println("��ǰ����·��");
		int[] path = new int[100];
		tt.print(tt.root, path, 0);
		System.out.println();
		System.out.println("����");
		System.out.println(tt.judgeFactor(tt.root.getlNode()));
<<<<<<< HEAD

		// LinkedList<Integer> list = new LinkedList<Integer>();
		// list.add(1);
		// list.add(2);
		// list.add(3);
		// System.out.println(list.poll());
		// System.out.println(list.poll());
		// System.out.println(list.poll());
		// System.out.println(list.poll());
		// System.out.println(list.size());

=======
		
//		LinkedList<Integer> list = new LinkedList<Integer>();
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		System.out.println(list.poll());
//		System.out.println(list.poll());
//		System.out.println(list.poll());
//		System.out.println(list.poll());
//		System.out.println(list.size());
		
>>>>>>> 11ed81fa09fa0c4efe13ded27b218a9c191a29fc
	}
}
