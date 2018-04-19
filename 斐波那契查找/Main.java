package 쳲���������;

//��������Ϊ��������
/*
 * ˼·�����ҵ���ӽ���ǰ���鳤�ȵ�쳲���������������ǵ������鳤�ȼ�һ�ġ������������������������һЩ����
 * ���в�λ������ѡ��Ĳ�λ�����ǵ�ǰ��������һλ��ֵ��֮���ʼ��һ���µ�����copy����ԭ�����鲢��������в�λ
 * ֮�����������н��в���Ԫ�أ������滹��ȡ�м�Ԫ�ؽ��бȽϵ��������м�Ԫ�ؾͲ���ԭ�������֣�left+right��/2����ʽ��
 * ���Ǹ���쳲��������е���ʽ������ѡȡ����ʼΪmid = low + fibo[k-1];֮����д�С�Ƚ��жϣ�����ȴ���Ԫ�ش�
 * ����ǰ����high = mid -1; k -= 1 쳲�������������ǰȡһλ�����С�ڴ���Ԫ��˵����ǰ���ҷ�Χ�ں�������low=mid+1
 * ֮����fibo�ķ�Χ��ǰ��С��λ����ΪҪ����Сһλ�Ļ���ֱ���ǵ�ǰԪ�������ĩβֵ�ˣ���С��λ����һ���ƽ�������м�λ��
 * �������Ͻ����жϣ�����ͬ��ʱ���������������1���Ǵ���С�����鳤����ֱ�ӷ�Χ��������ڵ�ǰ����������������һλԪ��
 * ���left>right˵����ǰԪ�ز��������ǵ�ȡֵ��Χ���С�
 * �ŵ����ƽ������ʱ��Ҫ�Ż����۰���ң�������������֮��Ҫ�����۰���ң���������mid��ʱ��ʹ�õ��ǼӼ��ķ�ʽ������
 * �˳��ķ�ʽ��һ��Ҳ��һ���Ż�
 */

public class Main {
	
	private static final int max_size = 20;  
	
	//��һ������ʼ��쳲����������������ҵĵ�һ�����ҵ�λ��
	public int[] Fibon(){
		int[] result = new int[max_size];
		result[0] = 0;
		result[1] = 1;
		for(int i=2;i<max_size;i++){
			result[i] = result[i-1]+result[i-2];
		}
		return result;
	}
	public int search(int[] array,int number){
		if(array == null || array.length == 0){
			return -1;
		}
		//��֤��ǰ����ķ�Χ��������ָ��֮��
		//��ָ��
		int low = 0;
		//��ָ��
		int high = array.length-1;
		int[] fibon = this.Fibon();
		int k = 0;
		//�ҵ��˵�ǰ�����鳤�ȴ�һ����쳲�����������k
		for(int i=0;i<fibon.length;i++){
			k++;
			if(fibon[i] > array.length){
			     break;	
			}
		}
		//������鳤�Ȳ�����С��쳲�����������ֵ��һ�Ļ�������������Ĳ���
		int[] operator = new int[fibon[k]];
		for(int i=0;i<array.length;i++){
			operator[i] = array[i];
		}
		for(int i= array.length;i<fibon[k];i++){
			operator[i] = array[array.length-1];
		}
		while(low <= high){
			//���Ƚϵ��м�ֵ low��ֵ���������������һ�������ĸ�����ʼ����Ϊ0֮�����ݵ�ǰ���ݵ�
			//��С�����е���
			int mid = low + fibon[k-1];
			//����м�Ԫ�ش��ڴ���Ԫ�������high�ķ�Χ������ǰһλ쳲����������бȽ�
			if(number < operator[mid]){
				high = mid-1;
				k-= 1;
			}else if(number > operator[mid]){   //���м�Ԫ�ش��ʱ�򣬵�����ָ��ʹ�õ�ַ��Ϊ�м�ֵ+1
				low = mid+1;
				k-=2;
			}
			else{
				if(mid < array.length){
					return mid;
				}else{
					return array.length-1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args){
		int a[] = {0,16,24,35,47,59,62,73,88,99};
		Main m = new Main();
		int index = m.search(a,59);
		System.out.println(index);
	}
}
