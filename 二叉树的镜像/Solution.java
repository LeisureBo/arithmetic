package �������ľ���;

/*
 * ���������Ķ�����������任ΪԴ�������ľ��� 
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

	public void Mirror(TreeNode root) {
		if(root == null){
			return;
		}
		//�������ҵĽڵ�
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		//�ݹ���ñ������ж����ҽڵ�
		Mirror(root.left);
		Mirror(root.right);
	}
}
