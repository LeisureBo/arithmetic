package ��β��ͷ��ӡ����;

import java.util.*;
public class Solution {
	
   public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
           this.val = val;
        }
    }
<<<<<<< HEAD
   ArrayList<Integer> list=new ArrayList<Integer>();
=======
	
>>>>>>> 11ed81fa09fa0c4efe13ded27b218a9c191a29fc
	//ͨ��ջ�ķ�ʽ������ʵ��
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
       Stack<Integer> stack = new Stack<Integer>();
       ArrayList<Integer> al = new ArrayList<Integer>();
       if(listNode!=null){
           while(listNode!=null){
               stack.push(listNode.val);
               listNode = listNode.next;
           }
           while(!stack.isEmpty()){
               al.add(stack.pop());
           }
       }
       return al;
    }
    //�ݹ�ķ�ʽ
<<<<<<< HEAD
    public void printListFromTailToHead2(ListNode listNode) {
        ListNode pNode=listNode;
        if(pNode!=null){
            if(pNode.next!=null){
                printListFromTailToHead2(pNode.next);
            }
            list.add(pNode.val);
        }
=======
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        
        ListNode pNode=listNode;
        if(pNode!=null){
            if(pNode.next!=null){
                list=printListFromTailToHead(pNode.next);
            }
            list.add(pNode.val);
        }
        
        return list;
>>>>>>> 11ed81fa09fa0c4efe13ded27b218a9c191a29fc
    }
}
