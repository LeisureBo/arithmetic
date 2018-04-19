package �ϲ��������������;


/*
 * ���������������������������������ϳɺ������
 * ��Ȼ������Ҫ�ϳɺ���������㵥����������
 * ˼·�������������е�Ԫ�ظ��洢��һ��������ȥ��ע��һ��Ҫע�⴫ַ���õļ��ɡ�
 */
public class Solution {
	public class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	 public ListNode Merge(ListNode list1,ListNode list2) {
		 if(list1 == null && list2 == null){
			 return null;
		 }else if(list1 == null && list2!=null){
			 return list2;
		 }else if(list1 != null && list2 == null){
			 return list1;
		 }else{
			 ListNode result = new ListNode(list1.val > list2.val ? list2.val : list1.val);//��������������Ϊ�ս��бȽ�
			 ListNode temp = result;
			 while(list1!=null && list2!=null){
				 if(list1.val <= list2.val){
					 ListNode t = new ListNode(list1.val);
					 temp.next = t;
					 temp = t;
					 list1 = list1.next;
				 }else{
					 ListNode t = new ListNode(list2.val);
					 temp.next = t;
					 temp = t;
					 list2 = list2.next;
				 }
			 }
			 //��������1Ϊ����ֱ�Ӱ�����2��ӽ�ȥ
			 if(list1 == null){
				 while(list2 != null){
					 ListNode t = new ListNode(list2.val);
					 temp.next = t;
					 temp = t;
					 list2 = list2.next;
				 }
			 }
			 if(list2 == null){
				 while(list1 != null){
					 ListNode t = new ListNode(list1.val);
					 temp.next = t;
					 temp = t;
					 list1 = list1.next;
				 }
			 }
			 return result.next;
		 }
	 }
	 public void test(ListNode list1){
		 list1 = list1.next;
		 System.out.println(list1.val);
	 }
	 public static void main(String[] args){
		 Solution m = new Solution();
		ListNode l1 = m.new ListNode(1);
		ListNode l2 = m.new ListNode(3);
		ListNode l3 = m.new ListNode(5);
		ListNode l4 = m.new ListNode(7);
		ListNode l5 = m.new ListNode(9);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		ListNode p1 = m.new ListNode(2);
		ListNode p2 = m.new ListNode(4);
		ListNode p3 = m.new ListNode(6);
		ListNode p4 = m.new ListNode(8);
		ListNode p5 = m.new ListNode(10);
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		p4.next = p5;
		m.test(l1);
		
		ListNode ln = m.Merge(l1, p1);
		while(ln.next!=null){
			System.out.print(ln.val+" ");
			ln = ln.next;
		}
	 }
}
