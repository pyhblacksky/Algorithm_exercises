package 剑指offer;

/**
 * @Author: pyh
 * @Date: 2019/2/18 21:45
 * @Version 1.0
 * @Function:
 *      输入一棵二叉树，求该树的深度。
 *      从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class 二叉树的深度 {

    //方法一：递归深搜
    public static int TreeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }

    //方法二：层次遍历，统计层数

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args){
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);

        r1.left = r2;
        r1.right = r3;
        r2.left = r4;
        r2.right = r5;

        System.out.println(TreeDepth(r1));
    }
}
