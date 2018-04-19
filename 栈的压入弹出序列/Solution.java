package ջ��ѹ�뵯������;

import java.util.Stack;

/*
 * ��Ŀ����

���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ�Ϊ��ջ�ĵ���˳��
����ѹ��ջ���������־�����ȡ���������1,2,3,4,5��ĳջ��ѹ��˳��
����4��5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У�
��4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С���ע�⣺���������еĳ�������ȵģ�
 */
public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA == null || popA == null || pushA.length == 0|| popA.length == 0){
            return false;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int index = 0;
        for(int i =0;i<pushA.length;i++){
            stack.push(pushA[i]);
            if(stack.peek() == popA[index]){
                stack.pop();
                index++;
            }              
        }
        while(!stack.isEmpty()){
            if(stack.peek() == popA[index]){
                stack.pop();
                index++;
            }else{
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
    	Solution s = new Solution();
    	int[] pushA = {1,2,3,4,5};
    	int[] popA = {4,5,3,2,1};
    	System.out.println(s.IsPopOrder(pushA, popA));
    }
}
