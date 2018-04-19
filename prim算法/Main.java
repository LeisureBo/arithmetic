package prim�㷨;

/*
 * ˼·����ͼ�ֳ����������ϣ���һ��������U�ڶ�����V����ʼ״̬U��ֻ��һ���ڵ�V0,V�д洢�ų�
 * V0֮������нڵ㣬��V���ҳ���U�нڵ�������Ȩֵ��С�Ľڵ㣬�����뵽prims�����У����Ѹýڵ�
 * �������ǵ�U�У�����V�нڵ�ȫ����ѯ����㷨����
 * Ϊ���ʵ����һ˼·��������Ҫһ��lowcost�������洢��ǰ��Ȩֵ��Ҳ����V�нڵ���U�нڵ�������
 * ��С��Ȩֵ����lowcost��ֵΪ0��ʱ��˵����ǰ����ڵ��Ѿ������뵽��U�����������ټ�������
 * �ж���
 */
public class Main {

	private int[] lowcost;// �洢U��V�нڵ���С��Ȩֵ

	private static final int MAX = Integer.MAX_VALUE; // ��û��Ȩֵʱ����������

	private int[] mst;// ��ǰ�ĸ�����ʶ�ڵ㣬��ʶ��ǰ<v,w>����ʼ�ڵ��������ʲô

	/*
	 * ��С���� �� prim�㷨
	 */

	public void prim(int[][] graph,int start) {
		char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I' };
		this.mst = new int[vertex.length];
		this.lowcost = new int[vertex.length];
		int sum = 0; // ��С��������Ȩֵ��
		// ��ʼ����һ�ε�lowcost�����¼��start����������ڵ��Ȩֵ������������max
		//start�ڵ㲻�ñ�Ĭ����0��ʾ��ǰ�ڵ��Ѿ���������
		for (int i = 0; i < vertex.length; i++) {
			// �����ǰ�ڵ㲻��startλ�ýڵ�Ļ����Ǿ���������СȨֵΪ��ǰȨֵ��
			// ��Ϊ���ǵ�һ�εĸ�ֵ������Ҫ����U��������СȨֵ�Ĳ��֣���Ϊ��ǰU������ֻ��һ��ֱֵ�Ӹ�ֵ���ɡ�
			if (i != start) {
				lowcost[i] = graph[start][i];
			}
		}
		// ��ѯ�Ĵ������ܹ���ѯN-1�Σ��ҳ�N-1�����㣬��Ϊ��ʼ�ڵ����
		for (int i = 1; i < vertex.length; i++) {
			int temp = 0;// �ҳ���ǰV��������U�����нڵ�����Ȩֵ��С��Ԫ��
			int min = MAX;// �жϱ�ʾ
			// �ҳ���ǰȨֵ��С�Ľڵ�<V,W>
			for (int j = 0; j < vertex.length; j++) {
				// ���統ǰֵ����V�����в��ҵ�ǰȨֵ�ȵ�ǰ��СֵҪС
				if (lowcost[j] != 0 && lowcost[j] < min) {
					min = lowcost[j]; // ��¼����СȨֵ�Լ���С�ڵ�λ��
					temp = j;
				}
			}
			System.out.println("���:"+vertex[mst[temp]]+"--->"+"���:"+vertex[temp]+" Ȩֵ:"+ min +" ");
			sum += min;
			lowcost[temp] = 0;// ���丳ֵΪ0��ʾ��ǰ�Ѿ������ǵ�U������
			// ����������lowcost
			for (int j = 0; j < vertex.length; j++) {
				// ���統ǰ��ֵ����V�����У����ҵ�ǰ����ӵ�U�����еĵ�Ϊ��㣬
				// JΪ�յ��ֵ��Ȩֵ��ԭ����ҪС�����
				if (lowcost[j] != 0 && graph[temp][j] < lowcost[j]) {
					lowcost[j] = graph[temp][j];
					mst[j] = temp;
				}
			}
		}
		System.out.println("��С������ȨֵΪ:"+sum);
	}

	public static void main(String[] args) {
		int[][] graph = new int[][] {
				{ 0, 10, MAX, MAX, MAX, 11, MAX, MAX, MAX },
				{ 10, 0, 18, MAX, MAX, MAX, 16, MAX, 12 },
				{ MAX, MAX, 0, 22, MAX, MAX, MAX, MAX, 8 },
				{ MAX, MAX, 22, 0, 20, MAX, MAX, 16, 21 },
				{ MAX, MAX, MAX, 20, 0, 26, MAX, 7, MAX },
				{ 11, MAX, MAX, MAX, 26, 0, 17, MAX, MAX },
				{ MAX, 16, MAX, MAX, MAX, 17, 0, 19, MAX },
				{ MAX, MAX, MAX, 16, 7, MAX, 19, 0, MAX },
				{ MAX, 12, 8, 21, MAX, MAX, MAX, MAX, 0 } };
		Main m = new Main();
		m.prim(graph,0);
	}
}
