package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: pyh
 * @Date: 2019/7/5 11:27
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution98_验证二叉搜索树 {

    //递归,推荐，具有通用性
    class Solution {
        public boolean isValidBST(TreeNode root) {
            if(root == null || (root.left == null && root.right == null))
                return true;

            return judge(root, null, null);
        }

        private boolean judge(TreeNode node, Integer min, Integer max){
            if(node == null)
                return true;

            if(min != null && node.val <= min){
                return false;
            }

            if(max != null && node.val >= max){
                return false;
            }

            return judge(node.left, min, node.val) && judge(node.right, node.val, max);
        }
    }

    //中序遍历后的结果进行判断
    class Solution1 {
        List<Integer> list = new ArrayList<>();
        public boolean isValidBST(TreeNode root) {
            if(root == null || (root.left == null && root.right == null))
                return true;

            midOrder(root);

            for(int i = 1; i < list.size(); i++){
                if(list.get(i) <= list.get(i-1))
                    return false;
            }
            return true;
        }

        private void midOrder(TreeNode node){
            if(node == null)
                return;

            midOrder(node.left);
            list.add(node.val);
            midOrder(node.right);
        }
    }

}
