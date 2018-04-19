package ����������;

/*
 * ����ͨ�Ķ��������н�һ���ָ��������˷ѣ���ΪҶ�ӽڵ������ָ�벢û��ָ���κεĽڵ�
 * ��������Ҫ���ǰ���Щ�ڵ��������������û�����ӵ�ʱ�����Ǿ���lnodeָ��ָ���Լ���ǰ��
 * ��û���Һ��ӵ�ʱ�����Ǿ���rnodeָ���Լ��ĺ������ڳ�ʼ��ÿ���ڵ��ʱ�������������ַ�
 * ������ַ�Ϊ1��ʱ��˵����ǰ��lnode��rnode�ֱ�ָ���Լ���ǰ���ͺ��
 * �Ե�ǰ�����б�����ʱ�����������
 */
public class Main {

	public class Node {
		public Node lNode;
		public Node rNode;
		public Node father;// ��������
		public int data;
		public int ltag;// ���ӵı�ǵ�û�����ӵ�ʱ����Ϊ1,�е�ʱ����Ϊ0����
		public int rtag;// �Һ��ӵı�ǵ�û���Һ��ӵ�ʱ����Ϊ1

		public Node(int data, Node lNode, Node rNode) {
			this.data = data;
			this.lNode = lNode;
			this.rNode = rNode;
		}
	}

	private Node root; // ���ڵ�

	private Node pre;// ������ʱ�������ǰһ�ڵ��ʼֵΪroot

	// ��ͨ����ӽڵ�ķ���
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
				node.father = father;
			} else {
				father.rNode = node;
				node.father = father;
			}
		}
	}

	// ��������������Ĺ���
	public void initDLR(Node node) {
		// ��׳���ж�
		if (node == null) {
			return;
		} else {
			Node temp = node;// ��������
			// ���統ǰ�ڵ���ָ��Ϊ�գ�������ָ��ָ��ǰ��,�����ǰ��������pre�ڵ�
			if (temp.lNode == null) {
				temp.lNode = pre;
				temp.ltag = 1;
			}
			// ����pre�ڵ����ָ��Ϊ�գ���������ָ��ָ���̣�����ĺ��������temp�ڵ�
			if (pre != null && pre.rtag == 1) {
				pre.rNode = temp;
			}
			// �õ�ǰ���ε�ѭ����Ҫ����εı���޸ģ�����ȵ���һ�ε�ʱ������޸���ᵼ�����һ���ڵ�û�б��޸�
			if (temp.rNode == null) {
				temp.rtag = 1;
			}
			pre = temp;
			// ��ǰ�������ӵ�ʱ���ڵݹ鴦��
			if (temp.ltag != 1) {
				initDLR(temp.lNode);
			}
			if (temp.rtag != 1) {
				initDLR(temp.rNode);
			}
		}
	}

	// �����������������Ĺ���
	public void initLDR(Node node) {
		// ��׳���ж�
		if (node == null) {
			return;
		} else {
			// �ҵ���ǰ��֧������˽ڵ�
			initLDR(node.lNode);
			// ��������Ϊ��
			if (node.lNode == null) {
				node.lNode = pre;
				node.ltag = 1;
			}
			// �����Һ���Ϊ��
			if (pre != null && pre.rtag == 1) {
				pre.rNode = node;
			}
			if (node.rNode == null) {
				node.rtag = 1;
			}
			// ��pre����node֮��ȥ��ѯ����Ľڵ�
			pre = node;
			initLDR(node.rNode);
		}
	}

	// �����������������Ĺ���
	public void initLRD(Node node) {
		// ��׳���ж�
		if (node == null) {
			return;
		} else {
			// �ҵ���ǰ�ʼ�Ľڵ�
			initLRD(node.lNode);
			initLRD(node.rNode);
			// ��������Ϊ��
			if (node.lNode == null) {
				node.lNode = pre;
				node.ltag = 1;
			}
			// ����pre���Һ���Ϊ��
			if (pre != null && pre.rtag == 1) {
				pre.rNode = node;
			}
			if (node.rNode == null) {
				node.rtag = 1;
			}
			// ��ֵ�뵱ǰ�ڵ����
			pre = node;
		}
	}

	// ��������������������ĳһ�ڵ�ǰ��
	public Node search_DLR_Before(Node node) {
		// ��׳���ж�
		if (node == null) {
			return null;
		} else {
			// ����Ǹ��ڵ�Ļ�
			if (node == root) {
				return null;
			} else {
				// ��������ӵĻ���ǰ�������丸�ڵ�
				if (node.ltag == 0) {
					return node.father;
					// ����־Ϊ1��ʱ�����ʱ��leftָ����ָ�����ǰ��
				} else {
					return node.lNode;
				}
			}
		}
	}

	// ��������������������ĳһ�ڵ����
	public Node search_DLR_After(Node node) {
		// ��׳���ж�
		if (node == null) {
			return null;
		} else {
			// �����ǰ�����ӣ����Ӿ��ǵ�ǰ�ڵ��ǰ������ΪDLR�Ĺ���
			if (node.rtag == 0) {
				return node.lNode;
				// ��û�����ӵ�ʱ����ʱ��leftָ��ָ�����ǰ����rightָ��ָ����Ǻ��
			} else {
				return node.rNode;
			}
		}
	}

	// �����������������������ĳһ�ڵ�ǰ��
	public Node search_LDR_Before(Node node) {
		if (node == null) {
			return null;
		} else {
			// �����ӵ�ʱ��ǰ��������������е����Ҷ�Ԫ�� ��Ϊ��LDR
			if (node.ltag == 0) {
				Node temp = node.lNode; // ��ʱ����holdס��������
				// �ҵ���ǰ�������е����Ҷ�Ԫ��
				while (temp.rNode != null) {
					temp = temp.rNode;
				}
				return temp;
				// ��û�����ӵ�ʱ��ǰ�����ֱ�Ӿ���leftָ��ָ���Ԫ��
			} else {
				return node.lNode;
			}
		}

	}

	// �����������������ҵ�ĳһ�ڵ�ĺ��
	public Node search_LDR_After(Node node) {
		// ��׳���ж�
		if (node == null) {
			return null;
		} else {
			// ����Һ��Ӵ��ڣ���ǰ���Ϊ�������������Ԫ��
			if (node.rtag == 0) {
				Node temp = node.rNode;
				// �ҵ���ǰ�������е������Ԫ��
				while (temp.lNode != null) {
					temp = temp.lNode;
				}
				return temp;
				// ����Һ���Ϊ�յĻ���rightָ����ָԪ��Ϊ���
			} else {
				return node.rNode;
			}
		}
	}

	// �����������������ҵ�ĳһ�ڵ��ǰ��
	public Node search_LRD_Before(Node node) {
		// ��׳���ж�
		if (node == null) {
			return null;
		} else {
			// ���統ǰ�ڵ����Һ��ӵĻ���ǰ�ڵ���Һ��Ӿ��ǵ�ǰ�ڵ��ǰ����ΪLRD��ԭ��
			if (node.rtag == 0) {
				return node.rNode;
				// ���統ǰ�ڵ�û���Һ��ӵĻ���ǰ�ڵ��leftָ��ָ��ľ���ǰ��,�˴�����leftָ�뵱ǰ�Ƿ�ָ������
			} else {
				return node.lNode;
			}
		}
	}

	// �����������������ҵ�ĳһ�ڵ�ĺ��
	public Node search_LRD_After(Node node) {
		// ��׳���ж�
		if (node == null) {
			return null;
		} else {
			// �����ǰ�ڵ��Ǹ��ڵ�Ļ�����ָ���
			if (node == root) {
				return null;
				// �����ǰ�ڵ���˫�׽ڵ���Һ��ӵĻ������ĺ�̾��ǵ�ǰ�ڵ��˫�׽ڵ�
			} else if (node == node.father.rNode) {
				return node.father;
				// �����ǰ�ڵ���˫�׽ڵ�����ӵĻ����Ҵ�ʱ�����ֵܣ����̾����������е�һ���������Ľڵ�
			} else if (node == node.father.lNode && node.father.rNode != null
					&& node.father.rtag == 0) {
				// ���������е�һ���������Ľڵ�
				Node temp = node.father.rNode;
				while (temp.lNode != null && temp.ltag == 0) {
					temp = temp.lNode;
				}
				while (temp.rNode != null && temp.rtag == 0) {
					temp = temp.rNode;
				}
				return temp;
				// �����ǰ�ڵ���˫�׽ڵ�������������ֵܣ�������Ϊ˫�׽ڵ�
			} else {
				return node.father;
			}
		}
	}

	// ���������������������
	public void DLR(Node node) {
		Node temp = node;
		while (temp != null) {
			while (temp.ltag == 0) {
				System.out.print(temp.data + " ");
				temp = temp.lNode;
			}
			while (temp != null && temp.rtag == 1) {
				System.out.print(temp.data + " ");
				temp = temp.rNode;
			}
		}
	}

	// �����������������
	public void LDR(Node node) {
		Node temp = node;
		while (temp != null) {
			while (temp.ltag == 0) {
				temp = temp.lNode;
			}
			System.out.print(temp.data + " ");
			while (temp != null && temp.rtag == 1) {
				temp = temp.rNode;
				// ��ֹû�к�̽ڵ���ֿ�ָ���쳣
				if (temp != null) {
					System.out.print(temp.data + " ");
				}
			}
			if (temp != null) {
				temp = temp.rNode;
			}
		}
	}

	public void print(Node node) {
		if (node != null) {
			if (node.ltag != 1) {
				print(node.lNode);
			} else {
				if (node.lNode != null) {
					System.out.println("ǰ��:" + node.lNode.data);
				}
			}
			if (node.father != null) {
				System.out.println(" ���ڵ���:" + node.father.data);
			}
			if (node.rtag != 1) {
				print(node.rNode);
			} else {
				if (node.rNode != null) {
					System.out.println("����:" + node.rNode.data);
				}
			}
			System.out.println("ֵ:" + node.data);
		}
	}

	public static void main(String[] args) {
		Main m = new Main();
		Node n1 = m.new Node(5, null, null);
		Node n2 = m.new Node(3, null, null);
		Node n3 = m.new Node(7, null, null);
		Node n4 = m.new Node(2, null, null);
		Node n5 = m.new Node(4, null, null);
		Node n6 = m.new Node(6, null, null);
		Node n7 = m.new Node(8, null, null);
		m.add(n1);
		m.add(n2);
		m.add(n3);
		m.add(n4);
		m.add(n5);
		m.add(n6);
		m.add(n7);
		
//		//ǰ�������� ǰ�����
//		m.initDLR(m.root);
//		System.out.println("ǰ�����ǰ����������");
//		m.DLR(m.root);
//		System.out.println();
//		System.out.println("ǰ��ڵ����ǰ���ͺ��");
//		System.out.println("�ڵ�: "+n5.data+"ǰ��: "+m.search_DLR_Before(n5).data+" ���: "+m.search_DLR_After(n5).data);
		
//		//���������� �������
//		m.initLDR(m.root);
//		System.out.println("�������������������");
//		m.LDR(m.root);
//		System.out.println();
//		System.out.println("����ڵ����ǰ���ͺ��");
//		System.out.println("�ڵ�: "+n5.data+"ǰ��: "+m.search_DLR_Before(n5).data+" ���: "+m.search_DLR_After(n5).data);

		//���������� 
		m.initLRD(m.root);
		System.out.println("����ڵ����ǰ���ͺ��");
		System.out.println("�ڵ�: "+n5.data+"ǰ��: "+m.search_DLR_Before(n5).data+" ���: "+m.search_DLR_After(n5).data);
	}
}
