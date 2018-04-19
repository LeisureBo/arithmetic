package ��������;



public class Solution {
	// ÿ����Ʒ������
	private static int[] weight;
	// ÿ����Ʒ�ļ�ֵ
	private static int[] value;
	// �洢�����Ͱ���DP��������
	private static int[][] dp;
	// ��ǰ���ܳ��ܵ���������ֵ
	private static int max;

	public static void main(String[] args) {
		// ������ֵ���г�ʼ��
		weight = new int[] { 1, 4, 5, 6, 8 };
		value = new int[] { 3, 4, 5, 1, 4 };
		max = 10;
		// DP���飬��ǰ���ĸ������Լ���ǰ���������������1����ΪҪ���ǵ�û�а�������Ϊ0�����
		dp = new int[weight.length + 1][max + 1];
		initDp(dp);
		// ȥ�ҵ�ǰ���������ֵΪmax�п��Դ洢���ٸ�����
		int result = find(weight.length, max);
		System.out.println(result);
	}

	// ���˺��ݻ�����Ϊ0��������඼Ϊ-1 �Ժ������ж�
	public static void initDp(int[][] dp) {
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				dp[i][j] = -1;
			}
		}
	}

	public static int find(int index, int max) {
		// ���Ǳ߽�ֵ
		if (dp[index][max] < 0) {
			if (weight[index - 1] > max) {
				dp[index][max] = find(index - 1, max);
			} else {
				//�ж�ѡ��Ͳ�ѡ��������Ǹ���ֵ�߸������ǵ�DP������󷵻�
				dp[index][max] = Math.max(
						find(index - 1, max),
						value[index - 1]
								+ find(index - 1, max - weight[index - 1]));
			}
		}
		return dp[index][max];
	}
}
