package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/9/17 9:08
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个二叉树，计算整个树的坡度。
 *
 * 一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
 *
 * 整个树的坡度就是其所有节点的坡度之和。
 *
 * 示例:
 *
 * 输入:
 *          1
 *        /   \
 *       2     3
 * 输出: 1
 * 解释:
 * 结点的坡度 2 : 0
 * 结点的坡度 3 : 0
 * 结点的坡度 1 : |2-3| = 1
 * 树的坡度 : 0 + 0 + 1 = 1
 * 注意:
 *
 * 任何子树的结点的和不会超过32位整数的范围。
 * 坡度的值不会超过32位整数的范围。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-tilt
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution563_二叉树的坡度 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    //效率很低
    class Solution {
        //是和的差值
        public int findTilt(TreeNode root) {
            if(root == null || (root.left == null && root.right == null))
                return 0;

            int now = Math.abs((root.left == null ? 0 :sumOfRoot(root.left)) - (root.right == null ? 0 : sumOfRoot(root.right)));
            return findTilt(root.left) + findTilt(root.right) + now;
        }

        int sumOfRoot(TreeNode root){
            if(root == null)
                return 0;

            return sumOfRoot(root.left) + sumOfRoot(root.right) + root.val;
        }
    }

}
