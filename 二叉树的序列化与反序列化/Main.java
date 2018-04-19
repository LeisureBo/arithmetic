package �����������л��뷴���л�;

import java.util.Stack;

public class Main {
	public static class Node{
		public int val;
		public Node left;
		public Node right;
		public Node(int val){
			this.val = val;
		}
	}
	public static String preSerialize(Node root){
		String result = "";
		if(root == null){
			result += "#";
			return result;
		}else{
			Node temp = root;
			Stack<Node> stack = new Stack<Node>();
			while(temp!=null || !stack.isEmpty()){
				//��ǰ�ڵ㲻Ϊ��
				if(temp!=null){
					//���л���ǰ�ڵ�
					result+=temp.val+"!";
					//�ѵ�ǰ�ڵ�ѹ��ջ��
					stack.push(temp);
					//ȥ�ҵ�ǰ�ڵ������ȥ��
					temp = temp.left;
				}else{
					temp = stack.pop().right;
				}
			}
			return result;
		}
	}
	
	public static void preUnSerialize(String node){
		String[] temp = node.split("!");
		
	}
	public static void main(String[] args){
		Node n1 = new Main.Node(1);
		Node n2 = new Main.Node(2);
		Node n3 = new Main.Node(3);
		Node n4 = new Main.Node(4);
		Node n5 = new Main.Node(5);
		n1.left = n2;
		n2.right = n3;
		n2.left = n4;
		n4.left = n5;
		String result = Main.preSerialize(n1);
		System.out.println(result);
	}
}
