package krukal�㷨;

public class Main {
	private static final int MAX = Integer.MAX_VALUE; //��ʾ��ǰ���㲻����

	public static void main(String[] args){
		int[][] graph = new int[][] {
				{ MAX, 10, MAX, MAX, MAX, 11, MAX, MAX, MAX },
				{ 10, MAX, 18, MAX, MAX, MAX, 16, MAX, 12 },
				{ MAX, MAX, MAX, 22, MAX, MAX, MAX, MAX, 8 },
				{ MAX, MAX, 22, MAX, 20, MAX, MAX, 16, 21 },
				{ MAX, MAX, MAX, 20, MAX, 26, MAX, 7, MAX },
				{ 11, MAX, MAX, MAX, 26, MAX, 17, MAX, MAX },
				{ MAX, 16, MAX, MAX, MAX, 17, MAX, 19, MAX },
				{ MAX, MAX, MAX, 16, 7, MAX, 19, MAX, MAX },
				{ MAX, 12, 8, 21, MAX, MAX, MAX, MAX, MAX } };
		kruskal(graph);
	}
	public static void kruskal(int[][] graph){
		int num = graph.length;//�ҳ���ǰ�Ľڵ����
		//��ʾ��ǰ�ڵ��Ƿ���ͬһ��ͨͼ�У������ֵ��ͬ���ʾ��ͬһ��ͨͼ�У�
		//��ʼֵʱ��0����ʾ��ǰ�ڵ㻹Ϊ�����жϣ����Դ����ʱ��Ҫ����һ������
		int[] group = new int[num];
		boolean finished = false;//�����������Ƿ�ִ����ϵ��ж�����
		int sum = 0;//��ǰ��С��������Ȩֵ��
		int start = 0; //��ǰ�ҵ��ķ�����������СȨֵ·������ʼ�������
		int end = 0;//��ǰ������������СȨֵ����ֹ�������
		int groupNumber = 1;//��ǰ�����жϽ���Ƿ���ͬһ��ͨͼ�ı�ǣ����ֵ��ͬ�Ļ�˵������ͬһ��ͨͼ����
		//�����ǰ���򻹿��Լ���ִ�еĻ�
		while(!finished){
			/*
			 * ��һ�����ҳ���ǰȨֵ���е���Сֵ�����ұ�Ǹ�Ȩֵ����ʼ������ֹ���
			 */
			int min = MAX; // ��Сֵ����ʼ����¸��������
			for(int i=0;i<graph.length;i++){
				for(int j=i;j<graph[i].length;j++){
					//�����ǰȨֵ�����ǵ���СֵҪС�Ļ����ж����жϣ��жϵ�ǰ�Ƿ���ͬһ��ͨͼ�У�
					//�����ͬһ��ͨͼ�������ǲ�����ѡ���
					if(graph[i][j] < min){
						//������������һ�����ɣ������ʼ������ֹ���λ�õ����Ų�һ������ͬһ��ͨͼ
						//�ڶ��������������������0˵����ǰ����û�н��д������Ԫ��
						if(group[i] != group[j] || (group[i] == 0 && group[j] == 0)){
							min = graph[i][j];//����Сֵ�������
							start = i;//������ʼֵ
							end = j;//������ֵֹ
						}
					}
				}
			}
			//�����ǰ��Сֵ����MAX�Ļ�˵����ǰ�ڵ�û�����κνڵ������ӣ����ͼ��һ��ɭ�֣�
			//ֻ�ܹ�����һ����С��������һ��û�б���֮�����ӵĽ��
			if(min == MAX){
				continue;
			}
			System.out.println(start+"---->"+end+" Ȩֵ: "+min);
			sum += min; //�ѵ�ǰȨֵ���뵽��СȨֵ��ȥ
			/*
			 * �ڶ�����ʼ�޸ķ���group�����ֵ
			 */
			//���������㶼��0�Ļ������Ǹ����Ǹ�ֵΪ1�飬���Ұ���Ž���++��������ž�����ͨͼ����
			if(group[start] == 0 && group[end] == 0){
				group[start] = groupNumber;
				group[end] = groupNumber;
				groupNumber++;
			}
			//�������ֵ������0˵����ǰ�����������,����Ҫ���������������ͬ
			else if(group[start] > 0 && group[end] > 0 ){
				int temp = group[end];
				for(int i = 0;i<group.length;i++){
					//�ҵ��յ����ţ������޸ĺ���ʼ���������ͬ��Ҳ����1
					if(group[i] == temp){
                        group[i] = group[start];
                    }
				}
			}
			//������һ������0һ��С��0��˵����ǰ��һ��������ģ�����һ����û�����
			//��ô����û�������ŵ�����������
			else{
				if(group[start] == 0){
					group[start] = group[end];
				}else{
					group[end] = group[start];
				}
			}
			//�жϵ�ǰ�Ƿ�������Ƿ񶼱�������
			for(int i=0 ; i<group.length;i++){
				//�����һ�����ͳ�ʼ����ֵ��һ��˵����ǰ���б������
				if(group[i] != group[0]){
					finished = false;
					break;
				}else{
					finished = true;
				}
			}
			//��������˳����������˳�
			if(finished){
				break;
			}
		}
		System.out.println("��СȨֵΪ: "+sum);
	}
}
