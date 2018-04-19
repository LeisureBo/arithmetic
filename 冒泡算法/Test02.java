package ð���㷨;

//˫��ð������
public class Test02 {
	public static void main(String[] args) {
		Test02 tt = new Test02();
		int[] array = { 131, 42, 525, 5221, 4, 15, 53, 63, 1, 53 };
		tt.sort(array);
		for (int i : array) {
			System.out.print(i + " ");
		}
	}

	// ��������ָ�룬��һ���Ǵ������������޸�rightָ��ָ�򣬵ڶ����Ǵ������������޸�leftָ��ָ��
	// ֮��ͬ����ֹ������left��right������left<right����ѭ��������������
	public void sort(int[] array) {
		int left = 0;
		int right = array.length - 1;
		int temp = 0;
		while (left < right) {
			for (int i = left; i < right; i++) {
				if (array[i] > array[i + 1]) {
					array[i] = array[i] ^ array[i + 1];
					array[i + 1] = array[i] ^ array[i + 1];
					array[i] = array[i] ^ array[i + 1];
					temp = i;
				}
			}
			right = temp;
			for (int i = right; i > left; i--) {
				if (array[i] < array[i - 1]) {
					array[i] = array[i] ^ array[i - 1];
					array[i - 1] = array[i] ^ array[i - 1];
					array[i] = array[i] ^ array[i - 1];
					temp = i;
				}
			}
			left = temp;
		}
	}
}
