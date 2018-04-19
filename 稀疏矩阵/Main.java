package ϡ�����;

public class Main {
	// ��Ԫ���࣬����ÿ���ڵ�����б���Լ���¼�������Ϳ��Զ�λ��ĳһֵ��
	public class Triple {
		public int row;
		public int col;
		public int data;

		public Triple(int row, int col, int data) {
			this.row = row;
			this.col = col;
			this.data = data;
		}
	}

	// ���䷽ʽ
	// ��Ԫ������ڴ洢��Ԫ����ľ��󣬻�������ǰϡ�������к��У��Լ���ǰ��0Ԫ�ظ�����
	// ��¼��Щ����Ϊ��ͬ��ϡ�������ܾ�����ͬ����Ԫ���
	public class Matrix {
		public Triple[] data;
		public int rowNumber;
		public int colNumber;
		public int length;// ��0Ԫ�ظ���

		public Matrix(Triple[] data, int rowNumber, int colNumber, int length) {
			this.data = data;
			this.rowNumber = rowNumber;
			this.colNumber = colNumber;
			this.length = length;
		}
	}

	// ��Ԫ���ľ���ת����ʾ , ���н���ת��,aΪԭ��Ԫ���bΪת��֮�����Ԫ���
	// ʱ�临�Ӷ�Ϊ O(rowNumber * length) ��*Ԫ�ظ���
	public Matrix transMatrix(Matrix a, Matrix b) {
		// ��׳���ж�
		if (a == null || b == null) {
			return null;
		}
		if (a.data != null) {
			// 1:�ȶ���Ԫ����е�����ֵ����ת����0Ԫ�ظ�������
			b.colNumber = a.rowNumber;
			b.rowNumber = a.colNumber;
			b.length = a.length;
			b.data = new Triple[a.data.length];// ��ʼ�����������Ԫ������
			// ��Ϊ������������������Ҫ���н�һ����ʼ����Ҫ����ʼֵΪnull
			// ��һ����ʼ��Ϊ����ֵ��Ϊ0�Ľڵ�
			for (int i = 0; i < b.data.length; i++) {
				b.data[i] = new Triple(0, 0, 0);
			}
			// ����ΪB���鸳ֵ��������ʼֵΪ0
			int index = 0;
			// ������data���н�һ����ֵ������ת����ֵ,���н���ɨ�裬�ҵ���ǰ�в�Ϊ0��Ԫ�ظ�ֵ����
			for (int i = 0; i < b.rowNumber; i++) {
				for (int j = 0; j < a.data.length; j++) {
					// �ҵ���ǰ�в�Ϊ0��Ԫ�ظ���B
					if (a.data[j].col == i) {
						// ���и�ֵ�෴��Ԫ��ֵ��ͬ
						b.data[index].row = a.data[j].col;
						b.data[index].col = a.data[j].row;
						b.data[index].data = a.data[j].data;
						index++;
					}
				}
			}
		}
		return b;
	}
	// ����ת����ʽ ��ѯһ����Ԫ��������ת������������������number ��position������
	// number��ͳ�Ƶ�ǰ���ж��ٸ�Ԫ�أ�position��ͳ�Ƶ�ǰ�е�һ��Ԫ�����ڵ�λ��
	//ʱ�临�Ӷ�ΪO(colNumber + length) ��ǰ��+Ԫ�ظ���
	public Matrix fastTransMatrix(Matrix a,Matrix b){
		//��׳���ж�
		if(a == null || b == null){
			return null;
		}
		if(a.data != null){
			b.rowNumber = a.colNumber;
			b.colNumber = a.rowNumber;
			b.length = a.length;
			b.data = new Triple[a.data.length];// ��ʼ�����������Ԫ������
			// ��Ϊ������������������Ҫ���н�һ����ʼ����Ҫ����ʼֵΪnull
			// ��һ����ʼ��Ϊ����ֵ��Ϊ0�Ľڵ�
			for (int i = 0; i < b.data.length; i++) {
				b.data[i] = new Triple(0, 0, 0);
			} 
			int[] number = new int[a.colNumber];//��������Ϊ��Ԫ����г��ȵ���������¼ÿһ���з�0Ԫ�ظ���
			//Ϊ�丳ֵÿһ���з�0Ԫ�ظ���
			for(int i=0;i<number.length;i++){
				number[a.data[i].col]++; 
			}
			int[] position =new int[a.colNumber];//����λ����������¼ÿһ���е�һ��Ԫ������B�е�λ��
			//��ʼ��
			//��һ�еĵ�һ��Ԫ�ػ��ɵ�һ�����Բ��ö�����и�ֵ��ֱ�ӳ�ʼֵ0����
			for(int i=1;i<position.length;i++){
				//��ǰ��һ�е�һ��Ԫ������λ�ã�Ϊ��һ�е�һԪ������λ��+��һ��Ԫ�ظ���
				position[i] = position[i-1]+number[i-1];
			}
			//�������ò�����Ϊdata������ֵ
			for(int i=0;i<a.data.length;i++){
				//�ҵ���ǰԪ�ص���λ�ã���number��position������ȷ����λ��
				int col = a.data[i].col;
				int pos = position[col];//�ҵ���ǰλ��
				//Ϊ��������ø�ֵ
				b.data[pos].row = a.data[i].col;
				b.data[pos].col = a.data[i].row;
				b.data[pos].data = a.data[i].data;
				//++Ŀ������position֮ǰֻ��¼���ǵ�һ��Ԫ�������ֵ�λ�ã�
				//��ǰ��������ж��Ԫ�صĻ���ָ������ƶ�������һԪ�صĵ���
				position[col]++;
			}
		}
		return b;
	}
}
