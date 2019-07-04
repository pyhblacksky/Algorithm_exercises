package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: pyh
 * @Date: 2019/7/4 17:27
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution102_二叉树的层次遍历 {

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if(root == null)
                return res;

            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode pre = root;
            TreeNode last = root;
            queue.add(root);

            List<Integer> list = new ArrayList<>();
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                list.add(node.val);

                if(node.left != null){
                    queue.add(node.left);
                    last = node.left;
                }
                if(node.right != null){
                    queue.add(node.right);
                    last = node.right;
                }

                if(node == pre){
                    pre = last;
                    List<Integer> temp = new ArrayList<>(list);
                    res.add(temp);
                    list = new ArrayList<>();
                }
            }

            return res;
        }
    }

}
