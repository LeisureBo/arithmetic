package ��ɫ����;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String origin = sc.nextLine();// ԭʼ���Ѹ��ߵ�n��M��ɫ�ʷֲ�
			String first = sc.nextLine();// ��һ���ѵ�ʱ�򿴵���ɫ�ʷֲ�
			String second = sc.nextLine();// �ڶ����ѵ�ʱ�򿴵���ɫ�ʷֲ�
			//�������벻��ȷ������ʱ�����������
			if (origin == null || first == null || second == null
					|| origin.contains(first) == false
					|| origin.contains(second) == false) {
				System.out.println("invalid");
			}
			int[] f = new int[1024];
			int[] s = new int[1024];
			for(int i = 0;i<f.length;i++){
				f[i] = -1;
			}
			for(int i = 0;i<s.length;i++){
				s[i] = -1;
			}
			String temp = origin;
			int indexFirst = 0;
			int count = 0;
			while(temp.contains(first)){
				f[indexFirst++] = temp.indexOf(first)+count;
				count += temp.indexOf(first)+first.length();
				temp = temp.substring(temp.indexOf(first)+first.length(),temp.length());
			}
			temp = origin;
			int indexSecond = 0;
			count = 0;
			while(temp.contains(second)){
				s[indexSecond++] = temp.indexOf(second)+count;
				count += temp.indexOf(second)+second.length();
				temp = temp.substring(temp.indexOf(second)+second.length(),temp.length());
			}
			
			if(s[0] != -1 && f[0] != -1 && s[0] < f[0]){
				boolean flag = false;
				for(int i =1;i<s.length;i++){
					if(s[i] > f[0] && s[i]!= -1){
						flag = true;
						System.out.println("both");
						break;
					}
				}
				if(!flag){
					System.out.println("backward");
				}
			}else if(s[0] != -1 && f[0] != -1 && s[0] > f[0]){
				boolean flag = false;
				for(int i = 1;i<f.length;i++){
					if(f[i] < s[0] && f[i] != -1){
						flag = true;
						System.out.println("both");
						break;
					}
				}
				if(!flag){
					System.out.println("forward");
				}
			}
			for(int i =0;i<f.length;i++){
				boolean flag = false;
				for(int j=0;j<s.length;j++){
					if(s[j] == f[i] && s[j]!= -1 && f[i] != -1){
						System.out.println("both");
						flag = true;
						break;
					}
				}
				if(flag){
					break;
				}
			}
		}
		sc.close();
	}
}
