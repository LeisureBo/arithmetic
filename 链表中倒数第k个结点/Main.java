package �����е�����k�����;

import java.util.Stack;

/*
 * ����һ����������������е�����k����㡣
 * ˼·���ŵ�һ��ջ��ͨ����ջ�ķ�ʽ����ȡֵ
 * ʡ�ռ临�Ӷȵ�˼·��ʹ������ָ�룬ͬʱָ��ͷ��㣬��һ��ָ�����ƶ�K-1��λ��֮��ڶ���ָ���ڽ����ƶ�
 * �ȵڶ���ָ�뵽��ײ�ʱ���һ��ָ����ָ���λ�þ��ǵ�����K���ڵ��ˡ�
 */
public class Main {
	public class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	public ListNode FindKthToTail(ListNode head,int k) {
		if(head == null || k <= 0){
			return null;
		}
		ListNode temp = head;//����һ��ָ��ָ��ǰ����ĵ�һ���ڵ�
		Stack<ListNode> stack = new Stack<ListNode>();//����һ��ջ���ڴ洢�ڵ�Ԫ��֮�����ȡֵ��
		while(temp != null){//��������Ԫ��ѹ��ջ��
			stack.push(temp);
			temp = temp.next;
		}
		try{
			ListNode result = null;
			while(k>0){
				result = stack.pop();
				k--;
			}
			return result;
		}catch(Exception e){
			return null;
		}
    }
	public static void main(String[] args){
//		Main m = new Main();
//		ListNode l1 = m.new ListNode(1);
//		ListNode l2 = m.new ListNode(2);
//		ListNode l3 = m.new ListNode(3);
//		ListNode l4 = m.new ListNode(4);
//		ListNode l5 = m.new ListNode(5);
//		l1.next = l2;
//		l2.next = l3;
//		l3.next = l4;
//		l4.next = l5;
//		ListNode result = m.FindKthToTail(l1, 6);
//		if(result !=null){
//			System.out.println(result.val);
//		}else{
//			System.out.println("��������");
//		}
	}
}
