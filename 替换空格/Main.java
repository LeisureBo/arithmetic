package �滻�ո�;

import java.util.Scanner;

public class Main {
	static int[] outWay = new int[2]; // ����λ��
	static int time = 0; //���ʴ˴���¼
	static int fastTime = Integer.MAX_VALUE;//���ֵ����֤���ᳬ�����ޣ��˴�Ϊ���ֵ
	static boolean[][] res; // ��������·��

	// �����������
	static void dfs(int[][] a, boolean[][] v, int x, int y, int time) {
		int[][] b = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };//ƥ������еĿ���
		if (x == outWay[0] && y == outWay[1]) { // ������ڣ����ж��Ƿ����·��
			v[x][y] = true;
			if ((time + 1) <= fastTime) {
				fastTime = time + 1; //
				res = v;
				printPath(v);//���������Ϣ����䣬�����л�
			}
			return;
		}
		if ((a[x][y] == 0 && !v[x][y])) { // �����ߣ���û�з��ʹ�
			for (int j = 0; j < 4; j++) {
				if (a[x + b[j][0]][y + b[j][1]] != 3) { // �жϱ߽�
					v[x][y] = true;// ��Ƿ��ʱ�־
					dfs(a, v, x + b[j][0], y + b[j][1], time++);
					v[x][y] = false; //��Ƿ��ʱ�־
				}
			}
		}
	}

	// ��ӡ·����
	private static void printPath(boolean[][] v) {
		for (int i = 0; i < v.length; i++) {
			for (int j = 0; j < v[i].length; j++) {
				if (v[i][j] == true) {
					System.out.println((i - 1) + "," + (j - 1));
				}
			}
		}
	}

	// ���������е���
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String string = sc.nextLine();
		String strings[] = string.split(" ");
		int n = strings.length;
		int m = n;
		int a[][] = new int[n + 2][n + 2];
		for (int j = 1; j <= n; j++) {
			a[1][j] = Integer.parseInt(strings[j - 1]);
		}
		for (int i = 2; i <= n; i++) {
			string = sc.nextLine();
			String[] strs = string.split(" ");
			for (int j = 1; j <= n; j++) {
				a[i][j] = Integer.parseInt(strs[j - 1]);
			}
		}

		for (int i = 0; i <= m; i++) { // �����Թ���Χ
			a[n + 1][i] = 3;
			a[0][i] = 3;
		}
		for (int i = 0; i <= n; i++) { // �����Թ���Χ
			a[i][m + 1] = 3;
			a[i][0] = 3;
		}
		outWay[0] = n;// ���ں�����
		outWay[1] = n;// ����������
		boolean[][] v = new boolean[a.length][a.length];
		boolean[][] res = new boolean[a.length][a.length];
		dfs(a, v, 1, 1, time);
		System.out.println(fastTime + 2); //�����л�������Ŀ������������Ŀ�����������
		 printPath(res);//����������·���ķ���
	}
}
