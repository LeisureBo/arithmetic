package ջ��Ԫ����ת;

import java.util.Stack;

/*
 * ���⣺��תջ�е�Ԫ�أ��������µĴ洢�ռ�
 * ˼·��ͨ���ݹ�ķ�ʽ��������ת���ݹ鱾����ǿ���һ���ݹ�ջ
 */
public class Main {
	//�Ե�ǰԪ�ؽ�������
	public static void reserve(Stack<Integer> stack){
		if(stack==null || stack.isEmpty()){
			return;
		}else{
			//ȡ��ջ��Ԫ��
			int temp = getAndRemove(stack);
			//�������еݹ�����ҵ�ջ��Ԫ��
			reserve(stack);
			//�ȵ����һ��Ԫ�ص�ʱ������Ԫ��push��ջ��ȥ
			stack.push(temp);
		}
	}
	//ȡ����ǰջ��Ԫ��
	public static int getAndRemove(Stack<Integer> stack){
		int result = stack.pop();
		if(stack.isEmpty()){
			return result;
		}else{
			int temp = getAndRemove(stack);
			stack.push(result);
			return temp;
		}
	}
	public static void main(String[] args){
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		reserve(stack);
		while(!stack.isEmpty()){
			System.out.print(stack.pop()+"-");
		}
	}
}
