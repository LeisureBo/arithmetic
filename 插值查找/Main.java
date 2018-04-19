package ��ֵ����;

//˼·��������������в��Ҳ��������ҵ�λ������Ϊһ���ؼ���Ԥ�ڵķֲ�ֵ
//�����м����㷨Ϊ  
//(����ؼ���-��ǰ�ж�����С�ؼ���)*(�������-��С����)/(��ǰ�ж����ؼ���-��ǰ�ж���С�ؼ���)
//��Ϊ�漰�����������Ե�������Сֵ��ͬ��ʱ����Ҫ����һ���жϣ������ǰֵ���õ��ڴ���Ԫ����ֱ�ӷ��أ�
//����ǰ����Ԫ�ز�����

public class Main {
	
	public int search(int[] array,int key){
		if(array == null || array.length == 0 ){
			return -1;
		}
		int low = 0;
		int high = array.length-1;
		int mid = 0;
		while(low <= high && key>= array[low] && key <=array[high]){
			if(low == high){
				if(array[low] == key){
					return low;
				}else{
					return -1;
				}
			}else{
				mid = low + (key-array[low])*(high-low)/(array[high] - array[low]);
				if(key > array[mid]){
					low = mid+1;
				}else if(key < array[mid]){
					high = mid-1;
				}else{
					return mid;
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args){
		int[] array = {12,24,36,47,58,79,80};
		Main m = new Main();
		int result = m.search(array, 80);
		System.out.println(result);
	}
	
}
