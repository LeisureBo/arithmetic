package �����ӽṹ;

/*
 * �������ö�����A��B���ж�B�ǲ���A���ӽṹ��
 * ��ps������Լ��������������һ�������ӽṹ��
 */
public class Solution {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	//����B�нڵ��Ƿ���A�г���
	 public boolean HasSubtree(TreeNode root1,TreeNode root2) {
		 //�����ʶ
		 boolean result = false;
		 if(root1 != null && root2 != null){
			 //��������ڵ�ֵ��ͬ�Ļ���ȥ��������Ľṹ�Ƿ�һ��
			 if(root1.val == root2.val){
				 result = judgeSonTree(root1,root2);
			 }
			 //���û���ҵ���ȥroot1���������н��в���
			 if(!result){
				 result = HasSubtree(root1.left,root2);
			 }
			 //���û�ҵ���ȡ���ǵ����������в���
			 if(!result){
				 result = HasSubtree(root1.right,root2);
			 }
		 }
		 return result;
	 }
	 //�õݹ�˼��ȥ���ӽṹ
	 public boolean judgeSonTree(TreeNode root1,TreeNode root2){
		 //����������Ϊ����˵���������Ѿ��ж�����������������
		 if(root2 == null){
			 return true;
		 }
		 //���������ûΪ��������Ϊ�����򲻳�����
		 if(root1 == null){
			 return false;
		 }
		 //������ڵ�1��ֵ����ڵ�2��ֵ�������򲻳���
		 if(root1.val != root2.val){
			 return false;
		 }
		 return judgeSonTree(root1.left,root2.left) && judgeSonTree(root1.right,root2.right);
	 }
	 public static void main(String[] args){
		 Solution s = new Solution();
		 TreeNode t1 = s.new TreeNode(3);
		 TreeNode t2 = s.new TreeNode(2);
		 TreeNode t3 = s.new TreeNode(4);
		 TreeNode t4 = s.new TreeNode(1);
		 t1.left = t2;
		 t1.right = t3;
		 t2.left = t4;
		 TreeNode p1 = s.new TreeNode(2);
		 TreeNode p2 = s.new TreeNode(1);
		 p1.left = p2;
		 System.out.println(s.HasSubtree(t1,p1));
	 }
}
