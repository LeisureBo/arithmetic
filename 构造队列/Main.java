package �������;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	public static void main(String[] args){
		Long begin = System.currentTimeMillis();
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();//�ܹ��ж���������
		for(int i=0;i<T;i++){
			int n = sc.nextInt();
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(n);
			for(int j = n-1;j>=1;j--){
				list.add(0,j);//���뵱ǰԪ��
				list.add(0,list.remove(list.size()-1));//�����Ԫ�ز��뵽���������ǰ��ȥ
			}
//			System.out.print(list.get(0));
//			for(int k=1;k<list.size();k++){
//				System.out.print(" "+list.get(k));
//			}
//			System.out.println();
			StringBuffer sb = new StringBuffer();
			for(int result:list){
				sb.append(result+" ");
			}
			sb.deleteCharAt(sb.length()-1);
			System.out.println(sb.toString());
		}
		Long end = System.currentTimeMillis();
		System.out.println(end - begin);
		sc.close();
	}
}
