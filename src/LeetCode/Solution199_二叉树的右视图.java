package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: pyh
 * @Date: 2019/7/5 17:17
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution199_二叉树的右视图 {

    //层次遍历的时候只记边节点
    class Solution {
        List<Integer> list = new ArrayList<>();
        public List<Integer> rightSideView(TreeNode root) {
            if(root == null)
                return list;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            TreeNode pre = root;
            TreeNode last = root;
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.add(node.left);
                    last = node.left;
                }
                if(node.right != null){
                    queue.add(node.right);
                    last = node.right;
                }

                if(pre == node){
                    pre = last;
                    list.add(node.val);
                }
            }

            return list;
        }
    }

}
