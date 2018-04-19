package �������������������;

public class Main {
	// �ڵ���
	public class Node {
		public int weight; // Ȩֵ
		public Node lNode;
		public Node rNode;
		public Node father;
		public String data;

		public Node(String data, int weight, Node lNode, Node rNode, Node father) {
			this.data = data;
			this.weight = weight;
			this.lNode = lNode;
			this.rNode = rNode;
			this.father = father;
		}
	}

	// ������
	public class Code {
		public String data; 
		public String coding;
	}

	public Node[] tree;// ���չ����õĹ�������
	public Code[] codes;// ��������

	// ����huffman�� �����ǵ�ǰҶ�ڵ����,��ǰ��������һ��λ�ýڵ��Ȩֵ���ǵ�ǰ������������СȨֵ
	public void createHuffman(Node[] nodes) {
		// ���н�׳���ж�
		if (nodes == null || nodes.length <= 1) {
			return;
		}
		// ��ʼ��������Ľڵ�
		tree = new Node[nodes.length * 2 - 1];
		int index = 0;
		// ΪǰN���ڵ���г�ʼ��������Ľڵ��ʼ��Ϊ0
		for (int i = 0; i < tree.length; i++) {
			Node n = new Node(null, Integer.MAX_VALUE, null, null, null);
			if (index < nodes.length) {
				n.data = nodes[index].data;
				n.weight = nodes[index++].weight;
			}
			tree[i] = n;
		}
		// Ϊʣ��λ���Ͻ��и�ֵ
		for (int i = nodes.length; i < tree.length; i++) {
			// �ҳ���ǰ��С�������ڵ�
			Node[] temp = tree; // ��ʱ�������飬������ Node temp = root ����
			// ð������
			for (int j = 0; j < temp.length; j++) {
				for (int k = temp.length - 1; k > j; k--) {
					if (temp[k].weight < temp[k - 1].weight) {
						Node t = temp[k];
						temp[k] = temp[k - 1];
						temp[k - 1] = t;
					}
				}
			}
			// ���Һ���ָ��
			int left = -1;
			int right = -1;
			// �ѵ�ǰ��С�������ڵ�λ�ø�����������
			for (int j = 0; j < temp.length; j++) {
				// ˵����ǰ�ڵ�û�б�����
				if (temp[j].father == null) {
					if (left == -1) {
						left = j;
					} else if (right == -1) {
						right = j;
						break;
					}
				}
			}
			// �������ڵ�Ϊ��С���ڵ�֮��
			Node father = new Node(null,
					tree[left].weight + tree[right].weight, tree[left],
					tree[right], null);
			// ������ϵ
			tree[i] = father;
			tree[left].father = father;
			tree[right].father = father;
		}
	}

	// ����huffman����
	public void createHuffmanCoding(Node[] nodes) {
		//��׳���ж�
		if(nodes== null || nodes.length ==0){
			return;
		}
		codes = new Code[nodes.length];
		for(int i=0;i<codes.length;i++){
			codes[i] = new Code();
		}
		for(int i=0;i<nodes.length;i++){
			codes[i].data = nodes[i].data;
			String temp = "";
			//�ڹ����������ҵ���ǰ���Ԫ��λ�ò���¼��ǰ�Ĺ��������������
			for(int j=0;j<tree.length;j++){
				Node t = null;
				if(tree[j].data!=null && tree[j].data.equals(codes[i].data)){
					t = tree[j];
					//�����и��ڵ�
					while(t.father != null){
						//��¼0����ָ����ڸ��ڵ�
						if(t.father.lNode == t){
							temp += "0";
							t = t.father;
						}else {
							temp += "1";
							t = t.father;
						}
					}
					break;
				}
			}
			String coding = new String();
			for(int j=temp.length()-1;j>=0;j--){
				coding += temp.charAt(j);
			}
			codes[i].coding = coding;
		}
	}
	
	public void huffman(){
		int sum = 0;
		for(int i=0;i<codes.length;i++){
			String temp = codes[i].data;
			int weight = 0;
			for(int j =0;j<tree.length;j++){
				if(tree[j].data != null &&tree[j].data.equals(temp)){
					weight = tree[j].weight;
					break;
				}
			}
			sum += weight * codes[i].coding.length();
		}
		System.out.println("������ֵ:"+sum);
	}
	public static void main(String[] args) {
		Main m = new Main();
		Node[] nodes = { m.new Node("a", 3, null, null, null),
				m.new Node("b", 5, null, null, null),
				m.new Node("c", 6, null, null, null),
				m.new Node("d", 9, null, null, null), };
		m.createHuffman(nodes);
		for (int i = 0; i < m.tree.length; i++) {
			System.out.print(m.tree[i].data+" "+m.tree[i].weight + " ");
		}
		System.out.println();
		m.createHuffmanCoding(nodes);
		for(int i=0;i<m.codes.length;i++){
			System.out.println(m.codes[i].data+" "+m.codes[i].coding);
		}
		m.huffman();
	}
}
