package ��ת����;


/*
 * ����һ��������ת�����������������Ԫ�ء�
 * ˼·��
 * 1��һ�־��Ǵ洢��ջ��ȥȻ��ͨ����ջ�ķ�ʽ��������
 * 2��������ָ�룬ͨ�������л������а�ָ����
 */
public class Solution {
	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public ListNode ReverseList(ListNode head) {
//		if(head == null){
//			return null;
//		}else{
//			Stack<ListNode> stack = new Stack<ListNode>();
//			ListNode temp = head;
//			while(temp != null){
//				stack.push(temp);
//				temp = temp.next;
//			}
//			ListNode result = stack.pop(); // �µ�ͷ���
//			ListNode tempResult = result;
//			while(!stack.isEmpty()){
//				tempResult.next = stack.pop();
//				tempResult = tempResult.next;
//			}
//			return result;
//		}
		 ListNode pre = null;
	     ListNode next = null;
	     while (head != null) {
		        next = head.next;
		        head.next = pre;
		        pre = head;
		        head = next;
		 }
		 return pre;
	}
	public static void main(String[] args){
		Solution m = new Solution();
		ListNode l1 = m.new ListNode(1);
		ListNode l2 = m.new ListNode(2);
		ListNode l3 = m.new ListNode(3);
		ListNode l4 = m.new ListNode(4);
		ListNode l5 = m.new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		ListNode result = m.ReverseList(l1);
		if(result !=null){
			System.out.println(result.next.next.val);
		}else{
			System.out.println("��������");
		}
	}
}
