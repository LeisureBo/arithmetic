package �����г��ִ�������һ�������;

import java.util.ArrayList;

/*
 * ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡�
 * ��������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}��
 * ��������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2����������������0��
 */
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length == 0){
            return 0;
        }
        int number = array[0];
        int count = 1;
        for(int i = 1 ;i<array.length;i++){
            if(count == 0){
                number = array[i];
                count ++;
            }
            if(array[i] == number){
                count ++;
            }else{
                count --;
            }
        }
        if(count < 1){
            return 0;
        }else{
            int count2 = 0;
            for(int i =0;i<array.length;i++){
                if(array[i] == number){
                    count2++;
                }
            }
            if(count2 > array.length/2){
                return number;
            }else{
                return 0;
            }
        }
    }
    public static void main(String[] args){
    	int[] a = {5,4,32,2,1};
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    }
}
