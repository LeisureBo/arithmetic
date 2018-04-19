package �ڽӱ�;

public class Main {
	
	private HeadNode[] headNode; //�ڵ����
	
	//ͷ�����Ϣ
	public class HeadNode{
		public char node; // ͷ�����Ϣ
		
		public NextNode next; // ��һ�����Ϣ
		
		public HeadNode(char node,NextNode next){
			this.node = node;
			this.next = next;
		}
	}
	//��ͷ��������ӵ���һ�����Ϣ
	public class NextNode{
		public int index; //��ǰ�ڵ����������е�λ��
		
		public NextNode next; // ��һ�����Ϣ
		
		public int weight; //��ǰ�ߵ�Ȩֵ��Ϣ
		
		public NextNode(int index ,NextNode next ,int weight){
			this.index = index;
			this.next = next;
			this.weight = weight;
		}
	}
	//��ʼ��������
	public void initNode(char[] node){
		if(node == null){
			return ;
		}
		headNode = new HeadNode[node.length];//��ʼ��ͷ������鳤���봫��node������ͬ
		for(int i=0;i<node.length;i++){
			HeadNode head = new HeadNode(node[i],null);
			headNode[i] = head;
		}
	}
	//��ʼ�������ڽӱ�
	public void initTable(char[][]edgs){
		for(int i=0;i<edgs.length;i++){
			char begin = edgs[i][0];//��ʼֵ
			char end = edgs[i][1];//��ֵֹ
			int index = 0;//��ֵֹ�ڳ�ʼ�������е�����λ��
			//�����鵱���ҵ�����λ��
			for(int j=0;j<headNode.length;j++){
				if(headNode[j].node == end){
					index = j;
					break;
				}
			}
			NextNode next = new NextNode(index,null,0);//������һ���ڵ�İ�װ��
			//Ϊ�����е�ͷ�����д���
			for(int j=0;j<headNode.length;j++){
				if(headNode[j].node == begin){
					NextNode temp = headNode[j].next;//��������
					//���ͷ������һ�ڵ�Ϊ�յĻ����õ�ǰ���ɵİ�װ��ڵ㸳������ǵ���һ�ڵ�
					if(temp == null){
						headNode[j].next = next; 
					}else{
						//�жϵ�ǰͷ���������û�������������Ľڵ�
						while(temp.next!=null){
							temp = temp.next;
						}
						temp.next = next;
					}
				}
			}
		}
	}
	//��ӡ����
	public void print(HeadNode[] head){
		for(int i=0;i<head.length;i++){
			System.out.print(head[i].node);
			NextNode temp = head[i].next;
			while(temp!= null){
				System.out.print(" --> ");
				System.out.print(temp.index);
				temp = temp.next;
			}
			System.out.println();
		}
	}
	public static void main(String[] args){
		char[] node = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        char[][] edgs = new char[][]{
            {'A', 'B'}, 
            {'B', 'C'}, 
            {'B', 'E'}, 
            {'B', 'F'}, 
            {'C', 'E'}, 
            {'D', 'C'}, 
            {'E', 'B'}, 
            {'E', 'D'}, 
            {'F', 'G'}
        };
        Main m = new Main();
        //��ʼ������ͷ���Ĺ���
        m.initNode(node);
        //��ʼ���ڽӱ�Ĺ���
        m.initTable(edgs);
        //��ӡ���
        m.print(m.headNode);
	}
	
}
