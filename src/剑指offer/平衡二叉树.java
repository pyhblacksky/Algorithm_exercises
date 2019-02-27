package 剑指offer;

/**
 * @Author: pyh
 * @Date: 2019/2/19 8:31
 * @Version 1.0
 * @Function:
 *      输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class 平衡二叉树 {

    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null){
            return true;
        }

        boolean[] judge = new boolean[1];
        judge[0] = true;

        depth(root, judge);
        return judge[0];
    }
    public int depth(TreeNode root, boolean[] judge){
        if(root == null){
            return 0;
        }

        int left = depth(root.left, judge);
        int right = depth(root.right, judge);
        //发现不平衡，剪枝操作
        if(Math.abs(left-right) > 1){
            judge[0] = false;
            return -1;
        }

        return Math.max(left, right) + 1;
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
