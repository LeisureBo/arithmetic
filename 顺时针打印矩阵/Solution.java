package ˳ʱ���ӡ����;

import java.util.ArrayList;

/*
 * ����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֣�
 * ���磬����������¾��� 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
 * �����δ�ӡ������1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
//˼· �������ά�������Ƕ��ԲǶ�������д�ӡ
//Ƕ�׵���������ʼ�ĵ��������������2��ֵ��С�ڵ�ǰά��
public class Solution {
	public ArrayList<Integer> printMatrix(int[][] matrix) {

		ArrayList<Integer> result = new ArrayList<Integer>();
		if (matrix.length == 0)
			return result;
		int n = matrix.length, m = matrix[0].length;
		if (m == 0)
			return result;
		int layers = (Math.min(n, m) - 1) / 2 + 1;// ����ǲ���
		for (int i = 0; i < layers; i++) {
			for (int k = i; k < m - i; k++)
				result.add(matrix[i][k]);// ������
			for (int j = i + 1; j <= n - i; j++)
				result.add(matrix[j][m - i - 1]);// ����������
			for (int k = m - i - 2; (k >= i) && (m - i - 1 != i); k--)
				result.add(matrix[n - i - 1][k]);// ������
			for (int j = n - i - 2; (j > i) && (n - i - 1 != i); j--)
				result.add(matrix[j][i]);// ����������
		}
		return result;
	}
}
