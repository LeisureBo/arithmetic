package ��������˳��洢;

public class Main {
	private  int[] array = new int[100]; // ��ǰ��������˳��洢�Ŀռ䵱Ϊ-1��ʱ��˵��û��Ԫ��

	public Main() {
		// �ѵ�ǰ�����ʼ��Ϊ-1��ʾ��ǰλ��û��Ԫ��
		for (int i = 0; i < array.length; i++) {
			array[i] = -1;
		}
	}

	public  void add(int number) {
		// �����ǰ��Ϊ����ֱ�������number���ڵ�ǰ�ĸ��ڵ�
		if (array[0] == -1) {
			array[0] = number;
		} else {
			int temp = array[0];
			int index = 0;
			while (temp != -1) {
				if (temp > number) {
					//���С�ڵĻ��õ�ǰtempΪ��������λ��Ԫ�ز�holdס��������
					temp = array[index * 2 + 1];
					index = index * 2 + 1;
				} else if (temp < number) {
					//������ڵĻ��õ�ǰtempΪ�Һ�������λ��Ԫ�ز�holdס�Һ�������
					temp = array[index * 2 + 2];
					index = index * 2 + 2;
				} else {
					// ��ȵĻ�ֱ��return������
					return;
				}
			}
			if(index < 100){
				array[index] = number;
			}else{
				System.out.println("��ǰ�ڴ治��");
				return ;
			}
		}

	}
	public  void print(){
		if(array[0] != -1){
			System.out.println(array[0]);
			int index = 0;
			for(int i=1;i<array.length;i++){
				if(array[i] != -1){
					index ++;
					System.out.print(array[i]+" ");
					if(index % 2 == 0 ){
						System.out.println();
					}
				}
			}
		}else{
			System.out.println("����");
			return ;
		}
	}
	public static void main(String[] args) {
		Main m = new Main();
		m.add(10);
		m.add(7);
		m.add(13);
		m.add(3);
		m.add(8);
		m.add(11);
		m.add(16);
		m.add(1);
		m.add(9);
		m.print();
	}
}
