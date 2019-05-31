package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/5/31 10:31
 * @Version: 1.0
 * @Function:
 * @Description:
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
public class Solution226_翻转二叉树 {

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        help(root);
        return root;
    }
    static void help(TreeNode node){
        if(node == null){
            return;
        }
        help(node.left);
        help(node.right);
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}
