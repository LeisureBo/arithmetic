package ƽ�������;


public class Main {
	//�ڵ��� ��������,ƽ������,���Ӻ��Һ���
	public class Node{
		public int data;
		public Node left;
		public Node right;
		public int bf;//ƽ������
		public Node(int data,Node left, Node right,int bf){
			this.data = data;
			this.left = left;
			this.right = right;
			this.bf = bf;
		}
	}
	//ƽ��������ĸ��ڵ�
	public Node root;
	
	//����ڵ���㷨
	/*
	 * 1���ҵ�������ڵ�
	 * 2���޸ĵ�ǰ��ӽ�����ڵ��ƽ�����Ӳ�Ϊ0�Ľڵ�BF
	 * 3���޸ĵ�ǰ·���ϵ�����ڵ������нڵ��ƽ������
	 * 4���ж��Ƿ��ƻ���ƽ��������Ĺ��ɽ����ع�
	 */
	public void add(Node node){
		//��׳���ж�
		if(node == null){
			return ;
		}
		//�����ǰΪ����ֱ���ø��ڵ�Ϊ��ǰ����ڵ�
		if(root == null){
			root = node;
		}else{
			Node current = root;//��ǰ������Ľڵ�λ��
			Node father = root;//��ǰ������ڵ�λ�õĸ�λ��
			Node bdNode = root; //��ӽ���ǰ����ڵ���ƽ�����Ӳ�Ϊ�յĽڵ�
			boolean flag = false;//�жϲ���ڵ��ǲ���������λ�û����Һ���λ��
			while(current != null){//�ҵ�������λ�õĹ���
				if(current.bf != 0){  //��¼��ǰ�������ڵ�����Ĳ�Ϊ0�Ľڵ㣬Ϊ�������ж��Ƿ���ƽ�������������
					bdNode = current;
				}
				father = current;
				if(current.data > node.data){
					current = current.left;
					flag = false;
				}else if(current.data < node.data){
					current = current.right;
					flag = true;
				}else{
					return ;
				}
			}
			//��Ԫ�ز����ȥ
			if(!flag){
				father.left = node;
			}else{
				father.right = node;
			}
			Node temp = root;//�޸ĵ�ǰbdNode��������ڵ�·�������нڵ��ƽ������
			//�޸ĵ�ǰbdNode��ƽ������
			if(bdNode.data > node.data){
				temp = bdNode.left;
				bdNode.bf = bdNode.bf + 1;
			}else{
				temp = bdNode.right;
				bdNode.bf = bdNode.bf - 1;
			}
			//�޸�bdNode������ڵ�·��������ƽ�����ӵı仯
			current = temp; // ��current�����д�������Ϊ֮��Ĳ���Ҫ��temp�����ж��Ƿ��ƻ���ƽ��������Ĺ���
			while(current != node){
				if(current.data > node.data){
					current.bf = 1;
					current = current.left;
				}else{
					current.bf = -1;
					current = current.right;
				}
			}
			Node father02 = root;
			Node t = root;
			while(t.data != bdNode.data){
				father02 = t;
				if(bdNode.data < t.data){
					t = t.left;
					
				}else if(bdNode.data > t.data){
					t = t.right;
					
				}
			}
			
			//�жϲ���ڵ�֮���Ƿ񻹷���ƽ��������Ĺ���
			if(bdNode.bf == 2 && temp.bf == 1){  // LL��
				this.LL(bdNode,father02);
			}else if(bdNode.bf == 2 && temp.bf == -1){ // LR��
				this.LR(bdNode,father02);
			}else if(bdNode.bf == -2 && temp.bf == -1){ //RR��
				this.RR(bdNode,father02);
			}else if(bdNode.bf == -2 && temp.bf == 1){  //RL��
				this.RL(bdNode,father02);
			}
		}
	}
	
	
	//LL��   
	/*
	 * node   O             temp    O
	 *       /                     / \
	 * temp O       ====>   node  O   O
	 *     /   
	 *    O
	 */
	public void LL(Node node,Node father){
		Node temp = node.left; //����ڵ㼴����ת���м�ȥ
		node.left = temp.right;
		temp.right = node;
		node.bf = 0;
		temp.bf = 0;
		if(node == root){
			root = temp;
		}else{
			father.left = temp;
		}
	}
	
	
	//LR��
	/*
	 *   node       O                                 temp2     O
	 *             / \                                         / \
	 *   temp1    O   O         ====== >              temp1   O   O  <- node 
	 *           / \                                         / \   \   
	 *          O   O  <- temp2                             O   O   O
	 *               \
	 *                O
	 */
	
	public void LR(Node node,Node father){
		Node temp1 = node.left;
		Node temp2 = temp1.right;
		node.left = temp2.right; //��node����ָ��ָ��temp2������
		temp1.right = temp2.left;//��temp1����ָ��ָ��temp2������
		temp2.left = temp1;//��temp2�������Ľڵ㣬�����temp1
		temp2.right = node;//�ұ���node�ڵ�
		//�ж�temp2��ƽ������
		switch(temp2.bf){
		case 0 : 
			node.bf = 0; 
			temp1.bf = 0;
			break;
		case 1 : 
			node.bf = 0; 
			temp1.bf = -1; 
			break;
		case -1 : 
			node.bf = 1; 
			temp1.bf = 0;
			break;
		}
		temp2.bf = 0;
		if(node == root){
			root = temp2;
		}else{
			father.left = temp2;
		}
	}
	
	//RR��
	
	/*
	 *  node O                 temp    O
	 *        \                       / \
	 *  temp   O     =======>  node  O   O
	 *          \
	 *           O
	 */
	
	public void RR(Node node,Node father){
		Node temp =  node.right; //������ת���м�Ľڵ�
		node.right = temp.left;
		temp.left = node;
		temp.bf = 0;
		node.bf = 0;
		if(node == root){
			root = temp;
		}else{
			father.right = temp;
		}
	}
	
	//RL��
	/*
	 *          O    <-  node             temp02 ->    O
	 *         / \                                    / \
	 *        O   O    <-  temp1      ==>   node ->  O   O     <-   temp1
	 *           / \                                / \   \
	 * temp2->  O   O                              O   O   O
	 *         /
	 *        O  
	 */ 
	
	public void RL(Node node,Node father){
		Node temp1 = node.right;
		Node temp2 = temp1.left;
		node.right = temp2.left;
		temp1.left = temp2.right;
	    temp2.right =  temp1;
		temp2.left = node;
		switch(temp2.bf){
		case 0:
			node.bf = 0;
			temp1.bf = 0;
			break;
		case 1:
			node.bf = -1;
			temp1.bf = 0;
			break;
		case -1:
			node.bf = 0;
			temp1.bf = 1;
			break;
		}
		temp2.bf = 0;
		if(node == root){
			root = temp2;
		}else{
			father.right = temp2;
		}
	}
	//ǰ�����
	public void DLR(Node node) {
		if (node != null) {
			System.out.print(node.data + "  ");
			DLR(node.left);
			DLR(node.right);
		}
	}
	public static void main(String[] args){
		Main m = new Main();
		Node node1 = m.new Node(5,null,null,0);
		Node node2 = m.new Node(3,null,null,0);
		Node node3 = m.new Node(4,null,null,0);
		Node node4 = m.new Node(9,null,null,0);
		Node node5 = m.new Node(1,null,null,0);
		Node node6 = m.new Node(0,null,null,0);
		Node node7 = m.new Node(8,null,null,0);
		Node node8 = m.new Node(7,null,null,0);
		m.add(node1);
		m.add(node2);
		m.add(node3);
		m.add(node4);
		m.add(node5);
		m.add(node6);
		m.add(node7);
		m.add(node8);
		System.out.println("�ڵ����˳��Ϊ:  ");
		System.out.println("5  3  4  9  1  0  8  7");
		System.out.println("����������");
		m.DLR(m.root);
	}
}
