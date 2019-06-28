package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/6/28 16:24
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diameter-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution543_二叉树的直径 {

    //求左右子树的深度之差
    class Solution {
        public int diameterOfBinaryTree(TreeNode root) {
            if(root == null || (root.left == null && root.right == null)){
                return 0;
            }

            int left = getDepth(root.left);
            int right = getDepth(root.right);

            int leftLen = diameterOfBinaryTree(root.left);
            int rightLen = diameterOfBinaryTree(root.right);

            return Math.max(Math.max(left+right, leftLen),rightLen);
        }

        int getDepth(TreeNode root){
            if(root == null){
                return 0;
            }

            int left = getDepth(root.left);
            int right = getDepth(root.right);
            return Math.max(left, right)+1;
        }
    }

}
