package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/2/26 14:55
 * @Version 1.0
 * @Function:   112、路径总和
 *
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 */
public class Solution112_路径总和 {

    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }

        return hasPath(root, sum, 0);
    }
    private static boolean hasPath(TreeNode root, int sum, int res){
        //相等且左右子树为空，才为真
        if(root == null){
            return false;
        }
        res += root.val;
        if(res == sum && root.left == null && root.right == null){
            return true;
        }

        return hasPath(root.left, sum, res) || hasPath(root.right, sum, res);
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args){
        TreeNode r1 = new TreeNode(5);
        TreeNode r2 = new TreeNode(4);
        TreeNode r3 = new TreeNode(8);
        TreeNode r4 = new TreeNode(11);
        TreeNode r5 = new TreeNode(13);
        TreeNode r6 = new TreeNode(4);
        TreeNode r7 = new TreeNode(7);
        TreeNode r8 = new TreeNode(2);
        TreeNode r9 = new TreeNode(1);

        r1.left = r2;
        r1.right = r3;
        r2.left = r4;
        r3.left = r5;
        r3.right = r6;
        r6.right = r9;
        r4.left = r7;
        r4.right = r8;

        System.out.println(hasPathSum(r1, 22));

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        n1.right = n2;
        System.out.println(hasPathSum(n1, 1));
    }
}
