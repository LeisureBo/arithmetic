package �滻�ո�;

import java.util.ArrayList;
<<<<<<< HEAD
import java.util.Stack;
=======
>>>>>>> 11ed81fa09fa0c4efe13ded27b218a9c191a29fc

public class Solution {
	//����˼·ʱ�临�Ӷ�ΪO��N^2��
    public String replaceSpace(StringBuffer str) {
        StringBuffer result = new StringBuffer();
    	String s = str.toString();
        char[] st = s.toCharArray();
        for(int i =0;i<st.length;i++){
        	if(st[i] == ' '){
            	result.append("%20");    
            }else{
                result.append(st[i]);
            }
        }
        return result.toString();
    }
    //�Ӻ���ǰ���м�������Ч�ʸ��Ӹ�Чʱ�临�Ӷ�O��N��
    public String replaceSpace2(StringBuffer str) {
        String s = str.toString();
        int count = 0;
        char[] c1 = s.toCharArray();
        for(int i=0;i<c1.length;i++){
            if(c1[i] == ' '){
                count++;
            }
        }
        char[] c2 = new char[c1.length+count*2];
        int index = c2.length-1;
  	  for(int i=c1.length-1;i>=0;i--){
            if(c1[i]!=' '){
                c2[index--] = c1[i];
            }else{
                c2[index--] = '0';
                c2[index--] = '2';
                c2[index--] = '%';
            }
        }
        String result = new String(c2);
        ArrayList al = new ArrayList();
        Stack st = new Stack();
<<<<<<< HEAD
=======
        st.i
>>>>>>> 11ed81fa09fa0c4efe13ded27b218a9c191a29fc
        return result;
    }
}
