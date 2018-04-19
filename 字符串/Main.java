package �ַ���;

//˼·���������ǰ�ַ��������еĻ����ִ�������Щ�ִ����ҳ����ǰ׺���
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	//�����ǰ���������л����ִ�
	public static List<String> getString(String s) {
		if (s==null || s.length() == 0) {
			return null;
		}
		//��ǰ�ַ�������
		int length = s.length();
		List<String> results = new ArrayList<String>(length);
		// �ӵ�i��λ�ÿ�ʼ�����л����Ӵ��Ľ���λ��.
		int[] end = new int[length + 1];
		// endIndice����Ч���ݵĳ���.
		int index = 1;
		// ������Ӵ��ĳ���. ���ڷǿմ����ٿ����ҵ�����Ϊ1�Ļ����Ӵ�.
		int maxLength = 1;
		// ����ӵ�i��λ�ÿ�ʼ�����л����Ӵ�. �������Ӵ���Ϊ����:
		// 1. �ڴӵ�i+1��λ�ÿ�ʼ�Ļ����Ӵ��Ļ�����, �����˼�����ͬ���ַ�;
		// 2. ����Ϊ1�Ļ����Ӵ�;
		// 3. �մ�.
		for (int i = length - 2; i >= 0; i--) {
			int j = 0, k = 0;
			while (j < index) {
				if (s.charAt(i) == s.charAt(end[j])) {
					end[k] = end[j] + 1;
					int newLength = end[k] - i;
					if (newLength >= maxLength) {
						if (newLength > maxLength) {
							maxLength = newLength;
							results.clear();
						}
						results.add(s.substring(i, end[k]));
					}
					if (end[k] < length) {
						k++;
					}
				}
				j++;
			}
			end[k++] = i + 1;
			if (maxLength == 1) {
				results.add(s.substring(i, i + 1));
			}
			end[k++] = i;
			index = k;
		}
		return results;
	}
	//��ӡ���л��ļ����ж��ҳ���ǰ����ǰ׺Ҫ����ַ���
	public static void print(List<String> list,String s) {
		if(list == null || s == null || s.length() == 0){
			return ;
		}
		String result = String.valueOf(s.charAt(0));
		for (String temp : list) {
			if(s.indexOf(temp) == 0 && temp.length() > result.length()){
				result = temp;
			}
		}
		System.out.println(result.length());
	}
	
	public static void main(String[] args) {
		//������ӡ���������
//		print(getString("gabcecbaefd"),"gabcecbaefd");
//		print(getString("bbcbaefccfg"),"bbcbaefccfg");
//		print(getString("aaaaaaaaaaa"),"aaaaaaaaaaa");
//		print(getString("abcdefghijk"),"abcdefghijk");
//		print(getString(null),"");
//		print(getString("aabbaa"),"aabbaa");
//		 Scanner sc = new Scanner(System.in);
//	        while(sc.hasNext()){
//	             String s = sc.next();
//	             print(getString(s),s);
//	        }
//	        sc.close();
		 try {  
			 BufferedReader strin=new BufferedReader(new InputStreamReader(System.in));
	            String s = "";
	            while( (s = strin.readLine()) != null){
	                  print(getString(s),s);
	            }
	      } catch (IOException e) {  
	            e.printStackTrace();  
	      }  
	}
}




