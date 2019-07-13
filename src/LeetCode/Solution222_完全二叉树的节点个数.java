package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: pyh
 * @Date: 2019/7/12 16:12
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 给出一个完全二叉树，求出该树的节点个数。
 *
 * 说明：
 *
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 * 示例:
 *
 * 输入:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-complete-tree-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution222_完全二叉树的节点个数 {

    //方法1，遍历计算节点个数
    class Solution {
        List<Integer> list = new ArrayList<>();
        public int countNodes(TreeNode root) {
            if(root == null)
                return 0;
            midOrder(root);
            return list.size();
        }

        void midOrder(TreeNode root){
            if(root == null)
                return;

            list.add(root.val);
            midOrder(root.left);
            midOrder(root.right);
        }
    }

    //
    class Solution1{
        public int countNodes(TreeNode root){
            return root == null ? 0 : countNodes(root.left) + countNodes(root.right) + 1;
        }
    }

}
