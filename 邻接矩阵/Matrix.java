package �ڽӾ���;

public class Matrix {
<<<<<<< HEAD
	
	private char[] node;//�ڽӾ���ĵ�
	
=======
	private char[] node;//�ڽӾ���ĵ�
>>>>>>> 11ed81fa09fa0c4efe13ded27b218a9c191a29fc
	private int[][] edgs;//�ڽӾ���ıߵļ���
	
	//��ʼ�������ڽӾ���ķ���
	public Matrix(char[] node,char[][]edgs){
		int nLength = node.length;//��ȡ�ڵ�ĳ���
		int eLength = edgs.length;//��ȡ�ߵĳ���
		this.node = new char[nLength];//��ʼ���ڽӾ���ĵ�
		for(int i =0;i<nLength;i++){
			this.node[i] = node[i];
		}
		this.edgs = new int[nLength][nLength];//��ʼ���ڽӾ���ߵļ���
		for(int i =0;i<eLength;i++){	//ѭ��������ȡ���бߵ�����Լ��յ�
			int temp01 = position(edgs[i][0]);	//��ȡ�ߵ����
			int temp02 = position(edgs[i][1]);	//��ȡ�ߵ��յ�
			this.edgs[temp01][temp02] = 1;
		}
	}
<<<<<<< HEAD
	
=======
>>>>>>> 11ed81fa09fa0c4efe13ded27b218a9c191a29fc
	//���ҵ�ǰ�ڵ�����λ��
	public int position(char t){
		int result = 0;
		//�жϵ�ǰ�ڵ��ڽڵ����������ڵ�λ�ð�λ����Ϣ���ػ�ȥ
		for(int i=0;i<node.length;i++){
			if(t == node[i]){
				result = i;
			}
		}
		return result;
	}
	//���
	public void print(char[] node,int[][]edgs){
		for(int i=0;i<node.length;i++){
			System.out.print("  ");
			System.out.print(node[i]+"  ");
		}
		System.out.println();
		for(int i=0;i<node.length;i++){
			System.out.print(node[i]+" ");
			for(int j=0;j<node.length;j++){
				System.out.print(edgs[i][j]+"    ");
			}
			System.out.println();
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
            {'F', 'G'}};
        Matrix m = new Matrix(node,edgs);
        m.print(node, m.edgs);
	}
}
