package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/7/2 9:10
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 *
 * 示例 1:
 * 给定的树 s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 t：
 *
 *    4
 *   / \
 *  1   2
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 *
 * 示例 2:
 * 给定的树 s：
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *     /
 *    0
 * 给定的树 t：
 *
 *    4
 *   / \
 *  1   2
 * 返回 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subtree-of-another-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution572_另一颗树的子树 {
    class Solution {
        public boolean isSubtree(TreeNode s, TreeNode t) {
            if(s == null || t == null){
                return false;
            }

            return isSubtree(s.left, t) || isSubtree(s.right, t) || judge(s, t);
        }

        //题目要求两个都为空时，才返回true
        public boolean judge(TreeNode s, TreeNode t){
            if(t == null && s == null){
                return true;
            }
            if(t == null || s == null){
                return false;
            }

            if(s.val == t.val){
                return judge(s.left, t.left) && judge(s.right, t.right);
            } else{
                return false;
            }
        }
    }
}
