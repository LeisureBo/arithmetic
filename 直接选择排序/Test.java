package ֱ��ѡ������;

public class Test {
	
	public void select_Sort(int[] array){//4,3,52,63,14,13,0,1,9,88
		//�����������ѯ������СԪ��
		for(int i=0;i<array.length;i++){
			//��ʱ�����洢��ǰarray[i] ����Ϊ����Ƚϵ��ж���ʾ
			int temp = array[i];
			//��ǰ��ѯ����СԪ�ص�����
			int index = i;
			//���бȽ�
			for(int j=i;j<array.length-1;j++){
				//����һ��Ԫ���Ƿ�С����ʱ���� ���С��������ʱ���������� 
				//���ñ�ʾ�������ڵ�ǰԪ�ص�����
				if(array[j+1]<temp){
					temp = array[j+1];
					index = j+1;
				}
			}
			//������ǰ��ʼԪ���뵱ǰ��ѯ�е���СԪ��
			array[index] = array[i];
			array[i] = temp;
		}
	}
	
<<<<<<< HEAD
	public void test(){
		int d = 1;
		synchronized("a"){
			int a = 1;
			int b = 1;
			int c = a+b;
			System.out.println(c);
		}
	}
=======
	
>>>>>>> 11ed81fa09fa0c4efe13ded27b218a9c191a29fc
	public static void main(String[] args){
		//��������
		int[] array = {4,3,52,63,14,13,0,1,9,88};
		Test tt = new Test();
		tt.select_Sort(array);
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
<<<<<<< HEAD
		System.out.println("----------------");
		System.out.println(2 | 2);
		System.out.println(2 ^ 2);
=======
>>>>>>> 11ed81fa09fa0c4efe13ded27b218a9c191a29fc
	}
}
