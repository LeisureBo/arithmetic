package �˿���˳��;

/*
 * LL���������ر��,��Ϊ��ȥ����һ���˿���,
 * ���������Ȼ��2������,2��С��(һ����ԭ����54��^_^)...
 * ��������г����5����,�����Լ�������,�����ܲ��ܳ鵽˳��,
 * ����鵽�Ļ�,������ȥ��������Ʊ,�ٺ٣���������A,����3,С��,����,��Ƭ5��,
 * ��Oh My God!������˳��.....LL��������,��������,������\С �����Կ����κ�����,
 * ����A����1,JΪ11,QΪ12,KΪ13�������5���ƾͿ��Ա�ɡ�1,2,3,4,5��(��С���ֱ���2��4),
 * ��So Lucky!����LL����ȥ��������Ʊ���� ����,Ҫ����ʹ�������ģ������Ĺ���,
 * Ȼ���������LL��������Ρ�Ϊ�˷������,�������Ϊ��С����0��
 */
public class Solution {
    public boolean isContinuous(int [] numbers) {
		if(numbers == null || numbers.length == 0){
            return false;
        }
		for(int i =0 ;i<numbers.length;i++){
			for(int j = numbers.length-1;j>i;j--){
                if(numbers[j] < numbers[j-1]){
                    int temp = numbers[j];
                    numbers[j] = numbers[j-1];
                    numbers[j-1] = temp;
                }
            }
        }
        int count = 0;
        for(int i = 0;i<numbers.length;i++){
            if(numbers[i] == 0){
                count ++;
            }
        }
        for(int i =0;i<numbers.length -1;i++){
            int temp = numbers[i];
			if(temp == 0){
                continue;
            }else{
                if(numbers[i+1] - temp != 1){
                    if(numbers[i+1]== temp){
                        return false;
                    }else{
                    	int sub = numbers[i+1] - temp;
                    	if(sub > count+1){
                        	return false;
                    	}else{
                        	count -= sub-1;
                        	continue;
                    	}
                	}
                }else{
                    continue;
                }
            }
        }
        return true;
    }
}
