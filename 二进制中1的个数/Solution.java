package ��������1�ĸ���;

/*
 * ��Ŀ����

����һ��������������������Ʊ�ʾ��1�ĸ��������и����ò����ʾ��
 */
public class Solution {
	public int  NumberOf1(int n) {
         int count = 0;
    	 while(n != 0){
             count++;
             n = (n-1) & n;
         }
		 return count;
     }
	public static void main(String[] args){
		args = new String[10];
		System.out.println(args.length);
		double d1 =1.32323;
		double d2 =1.32323;
		if(d1 == d2){
			System.out.println("111");
		}
	}
}