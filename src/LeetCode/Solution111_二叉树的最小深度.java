package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/2/28 19:51
 * @Version 1.0
 * @Function:
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 *
 * 特例： [1, 2]  最小深度是2！
 */
public class Solution111_二叉树的最小深度 {

    //解法1
    public int minDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        //必须是叶子节点到根的深度, [1, 2]  最小深度是2！
        if(root.left != null && root.right != null){
            return 1+ Math.min(minDepth(root.left), minDepth(root.right));
        } else{
            return 1 + Math.max(minDepth(root.right), minDepth(root.left));
        }
    }

    //解法二
    public int minDepth1(TreeNode root) {
        if(root==null) return 0;
        int left = minDepth1(root.left);
        int right = minDepth1(root.right);
        if(left > 0 && right>0){
            return Math.min(left,right) +1 ;
        }else{
            return 1+left + right;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
