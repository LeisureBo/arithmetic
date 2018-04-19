package �����㷨;

import java.util.Stack;

//�ǵݹ��ʵ�ַ�ʽ��ͨ��ʹ��һ��ջ��ģ��ݹ�ջ��ʹ��
public class Test03 {
	public static void main(String[] args){
		Test03 tt = new Test03();
		int[] array = {13,5213,52,1,6,37,352,27,25,63,7};
		tt.sort(array);
		for(int i : array){
			System.out.print(i +" ");
		}
	}
	//�������Ҫ�����������������ģ��ݹ��еĵݹ�ջ�Ĳ���
	//�����ʵ���൱��ԭ�ݹ鷽���еݹ���ñ����������д���
	public void sort(int[] array){
		if(array == null || array.length == 0){
			return ;
		}
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		stack.push(array.length-1);
		while(!stack.isEmpty()){
			int right = stack.pop();
			int left = stack.pop();
			if(right <= left){
				continue;
			}
			int middle = getLocation(array,left,right);
			if(left < middle-1){
				stack.push(left);
				stack.push(middle-1);
			}
			if(right > middle+1){
				stack.push(middle+1);
				stack.push(right);
			}
		}
	}
	//�ҳ�����λ�õķ�����ԭ�ݹ����˼·��ͬ
	public int getLocation(int[] array,int left,int right){
		int i = left;
		int j = right;
		int temp = array[i];
		if(left< right){
			while(i<j){
				while(i<j && array[j] > temp){
					j--;
				}
				if(i<j){
					array[i] = array[j];
					i++;
				}
				while(i<j && array[i] < temp){
					i++;
				}
				if(i<j){
					array[j] = array[i];
					j--;
				}
			}
			array[i] = temp;
		}
		return i;
	}
}
