package ������ܺ�;
//˼·������ѭ��Ƕ�ף���ѭ���ǽ�Сż������ѭ���ǽϴ�ż������ѭ��������0��ʼ++����ѭ������ѭ���±�+1��ʼ����
//������֤��ÿ����Ԫ�ض������˱Ƚϣ�Ȼ��ѭ�������������Χ�е����е��������ۼ����
//AC 71%����Ϊ��õ�����û�кܺõĸ��ã�ÿ�ζ������¼���һ������Ԫ��֮�������������ʱ�������㷨���Ǻ�����
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	//�������ķ���
	public static List<Integer> search(int start, int end) {
		List<Integer> numbers = new ArrayList<Integer>();
		int temp = 0;
		boolean flag = true;
		for (int i = start; i < end; i++) {
			flag = true;
			if (i > 3) {
				temp = (int) Math.sqrt(i);
				for (int j = 2; j <= temp; j++) {
					if (i % j == 0) {
						flag = false;
					}
				}
			} else if (i < 2) {
				flag = false;
			} else {
				flag = true;
			}
			if (flag) {
				numbers.add(i);
			}
		}
		return numbers;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int[] array = new int[number];
		for (int i = 0; i < array.length; i++) {
			array[i] = sc.nextInt();
		}
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				// ������
				count += search(array[i], array[j]).size();
			}
		}
		System.out.println(count);
		sc.close();
		
		
	}
}


/*
 * ������������2��ż��֮��ľ��룬Ϊ��������֮�������ĸ�������С��������n������2��ż����
 * �������������֮�������ܺͣ�Ӧ����n*(n-1)/2�����룬����ܺ;ͺ�)��
 ����
 ��һ��������ż���ĸ�������СΪ2�������ܵ�����֮��ÿ��Ϊһ��ż������С��4��
 �������Ǽ����򣬲��ظ����������С�
 ���
 �������������������ܺͣ���Ӧ����һ����С��0��������

 ��������
 3
 4
 6
 12
 �������
 6
 */