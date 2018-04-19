package ջ��ʵ��.��ʽ;

public class Main {
	
	public LinkedList top; //ȫ�ֱ���ָ��
	
	//ÿ�����ڵ�
	public class LinkedList{
		public int data;
		public LinkedList next;
	}
	//��ʼ����һ��ָ��ָ���
	public LinkedList LinkedListInit(){
		top = null;
		return top;
	}
	//�ж�ջ��
	public boolean LinkedListEmpty(){
		if(top == null){
			return true;
		}else{
			return false;
		}
	}
	//��ջ
	public void LinkedStackPush(int number){
		//������Ӧ�ڵ��next��Ϊ֮ǰtop�ڵ���ָ������topָ���²���ڵ�
		LinkedList temp = new LinkedList();
		temp.data = number;
		temp.next = top;
		top = temp;
	}
	//��ջ
	public int LinkedStackPop(){
		if(top == null){
			return -1;//��ǰջ�յĴ����־
		}else{
			int result = top.data;
			top = top.next;
			return result;
		}
	}
	//ȡջ��Ԫ��
	public int LinkedStackTop(){
		if(top == null){
			return -1;//��ǰջ�յĴ����־
		}else{
			return top.data;
		}
	}
	//��յ�ǰջ
	@SuppressWarnings("unused")
	public void LinkedListClean(){
		while(top != null){
			LinkedList temp = top;
			temp = null;
			top = top.next;
		}
	}
	//ջԪ�ظ���
	public int LinkedListSize(){
		if(top == null){
			return -1;//��ǰջ�յĴ����־
		}else{
			int count = 0;
			LinkedList temp = top;
			while(temp != null){
				count++;
				temp = temp.next;
			}
			return count;
		}
	}
	
	public static void main(String[] args){
		Main m = new Main();
		m.LinkedListInit();//��ʼ������
		System.out.println(m.LinkedListEmpty());//�ж�ջ�Ƿ�Ϊ��
		m.LinkedStackPush(10);//���Ԫ��
		m.LinkedStackPush(20);
		System.out.println(m.LinkedListSize());//�󳤶�
		System.out.println(m.LinkedStackPop());//��ջ
		System.out.println(m.LinkedListSize());//�󳤶�
		System.out.println(m.LinkedListEmpty());//�ж�ջ�Ƿ�Ϊ��
		System.out.println(m.LinkedStackTop());//��ջ��Ԫ��
		m.LinkedListClean();//��յ�ǰջ
		System.out.println(m.LinkedListSize());//�󳤶�
		System.out.println(m.LinkedListEmpty());//�ж�ջ�Ƿ�Ϊ��
	}
}	
