package ϴ��;

import java.util.Scanner;

public class Main {
	
	public static void washPorker(int[] array){//��ĳһ����ϴ���ٴ�
		int[] temp = new int[array.length];
		int index = array.length-1;
		for(int i=array.length-1;i>=array.length/2;i--){
			temp[index--] = array[i];
			temp[index--] = array[i-array.length/2];
		}
		for(int i=0;i<array.length;i++){
			array[i] = temp[i];
		}
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();//��ǰ�ж���������
		for(int i=0;i<T;i++){ // ���뵱ǰ�����������
			int n = sc.nextInt();//�ܹ��ж�����������һ�������
			int k = sc.nextInt();//Ҫϴ�ƵĴ���
			int[] array = new int[2*n];//���Ƶ�����
			for(int j=0;j<n*2;j++){ 
				array[j] = sc.nextInt();
			}
			for(int t=0;t<k;t++){ //ϴK����
				washPorker(array);
			}
			System.out.print(array[0]);
			for(int z = 1;z<n*2;z++){//���
				System.out.print(" "+array[z]);
			}
			System.out.println();
		}
		sc.close();
	}
}
