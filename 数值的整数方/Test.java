package ��ֵ��������;

public class Test {
	private static int number = 1;
	public void finalize(){
		System.out.println("������"+ number++ +"������");
	}
	public static void main(String[] args){
		int i = 1;
		while(true){
			Test t = new Test();
			System.out.println("������"+ i++ +"������");
			
		}
	}
}
