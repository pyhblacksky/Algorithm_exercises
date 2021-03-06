package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/4/21 19:48
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 */
public class Solution110_平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return true;
        }

        int left = countDepth(root.left);
        int right = countDepth(root.right);
        if(Math.abs(left-right) > 1){
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static int countDepth(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = countDepth(root.left) + 1;
        int right = countDepth(root.right) + 1;
        return Math.max(left, right);
    }

     public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
