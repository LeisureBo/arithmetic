package floyd�㷨;

public class Main {

	private static final int MAX = 1000;//����֮���Բ���MAX_VALUE����Ϊ�����Ļ�����++�����ͻ���ֳ����������ָ�ֵ

	/*
	 * floyd�㷨˼·���ҳ���ǰ��������֮�����̾��룬��ʼ��ʱ����̾���Ϊ��ǰ����֮�������ľ��룬
	 * ֮�󲻶�������֮�䲻�ϼ������������ж��Ƿ��ԭ���Ľڵ㳤��С�����С�Ļ����޸ľ���ֵ
	 */
	public static void floyd(int[][] graph) {
		char[] node = { 'A', 'B', 'C' };
		int[][] D = new int[node.length][node.length];// ����洢����������֮�����̾���
		// ΪD������и�ֵ����ʼ��������ֱ�������ľ���
		for (int i = 0; i < node.length; i++) {
			for (int j = 0; j < node.length; j++) {
				D[i][j] = graph[i][j];
			}
		}
		// �����㷨�������������м��ֵ��ÿһ��ѭ������һ���ڵ㣬
		for (int k = 0; k < node.length; k++) {
			for (int i = 0; i < node.length; i++) {
				for (int j = 0; j < node.length; j++) {
					//���������ǰ����ڵ�֮��ľ���С��֮ǰ�ľ��룬��ô�޸�ԭֵ
					if(D[i][k] + D[k][j] < D[i][j]){
						D[i][j] = D[i][k] + D[k][j];
					}
				}
			}
		}
		//�����ǰ���������ֵ
		for(int i=0;i<node.length;i++){
			for(int j=0;j<node.length;j++){
				if(D[i][j] != MAX && i!=j){ //�����ֹ��ͬ�ڵ��������Ϊ��ǰ����ͼ�п��ܳ��ֻ���
					System.out.println(node[i]+"----->"+node[j]+" "+D[i][j]);
				}
			}
		}
	}

	public static void main(String[] args) {
		int[][] graph = { { MAX, 4, 11 }, { 6, MAX, 2 }, { 3, MAX, MAX } };
		floyd(graph);
	}
}
