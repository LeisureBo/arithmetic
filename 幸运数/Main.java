package ������;

import java.math.BigInteger;
import java.util.Scanner;


public class Main {
	/*
	 * �ڶ�����������
	 * 
	 * ʱ�����ƣ�C/C++���� 1000MS���������� 3000MS �ڴ����ƣ�C/C++���� 65536KB���������� 589824KB
	 * 
	 * ��Ŀ������
	 * 
	 * 4��7�������������֣����Ƕ��壬ʮ���Ʊ�ʾ�У�ÿһλֻ��4��7�������������������������֡�
	 * ǰ�������������ǣ�4,7,44,47,74,77,444,447��
	 * 
	 * ��������һ������k�������k�������� ������������ˡ� 
	 * �������� 3 5 100 10000000 ������� 74 744747
	 * 44774447447477474444447
	 * 
	 * ����Ŀ���Ǹ����롭
	 */
	
	public static void lucky(BigInteger n){
		if(n.compareTo(BigInteger.ZERO) <= 0 ){
			return ;
		}
		if(n.equals(BigInteger.ONE)){
			System.out.print(4);
			return ;
		}else if(n.equals(new BigInteger("2"))){
			System.out.print(7);
			return ;
		}
		BigInteger pre = (n.subtract(BigInteger.ONE)).divide(new BigInteger("2"));
		BigInteger now = n.subtract(pre.multiply(new BigInteger("2")));
		if(pre.compareTo(BigInteger.ZERO) >0){
			lucky(pre);
		}
		if(now.compareTo(BigInteger.ZERO) > 0){
			lucky(now);
		}
	}
	
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T--> 0){
			BigInteger n = sc.nextBigInteger();
			lucky(n);
			System.out.println();
		}
		sc.close();
	}
//	 Arrays.sort(array, new Comparator<People>() {
//         public int compare(People p1, People p2) {
//             int result = Integer.compare(p1.height, p2.height);
//             if (result != 0)
//                 return result;
//             else
//                 return Integer.compare(p1.weight, p2.weight);
//         }
//     })
}
