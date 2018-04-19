package dijkstra�㷨;

public class Main {
	private static final int MAX = 10000;//��ʾ��ǰ���㲻����
	/*�Ͻ�˹���㷨˼·������һ���������ڱ��浱ǰ�ڵ��Ƿ��Ѿ������ж���
	��һ���ڵ���Ϊ��ʼ�ڵ㣬Ȼ���������ڵ�������������С����Ȩֵ��
	�ҳ���ǰ��֮��������СȨֵ֮�󣬰Ѻ�����������СȨֵ�ڵ���Ϊtrue��ʾ�Ѿ����ж��ˡ�
	֮�����޸�����ڵ����Ѿ��жϽ��ľ����Сֵ
	*/
	public static void dijkstra(int[][] graph){
		char[] node = {'A','B','C','D','E','F'}; //�ڵ�Ԫ������
		int[] D = new int[node.length]; //�洢ÿ��û�б����Ľڵ����ѱ����ڵ�֮�����С����
		boolean[] isVisited = new boolean[node.length];//�жϵ�ǰ�ڵ��Ƿ��Ѿ���������
		isVisited[0] = true;//��ǰ�ӵ�һ���ڵ㿪ʼ����
		int[] start = new int[node.length];//��ʼ�ڵ����� ��ʼ��ʼ�ڵ㶼��0�Žڵ�
		for(int i = 0;i<node.length;i++){
			D[i] = graph[0][i]; //������ʼ�ڵ������ĵ�Ȩֵ���븳���D����
		}
		//ִ��N-1�ˣ��ҳ���ǰ���нڵ�
		for(int i=0;i<node.length-1;i++){
			int min = MAX;//��Сֵ
			int index = 0;//��Сֵ������
			//�ҳ����ѱ����ڵ���������СȨֵ�ڵ�
			for(int j=0;j<D.length;j++){
				//�����ǰ�ڵ�û�б�������,�������ѱ����ڵ�����ȨֵС����Сֵ
				if(!isVisited[j] && D[j] < min){
					min = D[j];
					index = j;
				}
			}
			if(min == 10000){
				continue;
			}
			System.out.println(node[start[index]]+"--->"+node[index]+" "+min); //���Ч��
			isVisited[index] = true;//��ʾ��ǰ�ڵ㱻������
			//���µ���D���飬��Ϊ��ʱ�����ʽڵ��ж���һ��
			for(int j = 0;j<D.length;j++){
				//���統ǰ�ڵ�û�з��ʹ��ҵ�ǰ���¼��뱻���ʼ����еĽڵ��ԭ��С�ڵ�ҪС���޸ĸ�ֵ
				if( !isVisited[j] && min+graph[index][j] < D[j] ){
					D[j] = min+graph[index][j];
					start[j] = index; //�޸ĵ�ǰλ�õ���ʼ�ڵ�
				}
			}
		}
	}
	public static void main(String []args){
		int[][] graph = {{MAX,50,10,MAX,55,MAX},
						 {MAX,MAX,15,MAX,10,MAX},
						 {20,MAX,MAX,15,MAX,MAX},
						 {MAX,20,MAX,MAX,20,MAX},
						 {MAX,MAX,MAX,30,MAX,MAX},
						 {MAX,MAX,MAX,3,MAX,MAX}};
		dijkstra(graph);
	}
}
