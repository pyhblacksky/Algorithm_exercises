package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: pyh
 * @Date: 2019/7/4 20:11
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution94_二叉树的中序遍历 {

    //递归
    class Solution {
        List<Integer> list = new ArrayList<>();
        public List<Integer> inorderTraversal(TreeNode root) {
            if(root == null)
                return list;

            mid(root);
            return list;
        }

        public void mid(TreeNode root){
            if(root == null)
                return;

            mid(root.left);
            list.add(root.val);
            mid(root.right);
        }
    }

    //迭代版，非递归
    class Solution1 {
        List<Integer> list = new ArrayList<>();
        public List<Integer> inorderTraversal(TreeNode root) {
            if(root == null)
                return list;

            Stack<TreeNode> stack = new Stack<>();
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            while(!stack.isEmpty()){
                TreeNode node = stack.pop();
                list.add(node.val);
                if(node.right != null){
                    TreeNode right  = node.right;
                    while(right != null){
                        stack.push(right);
                        right = right.left;
                    }
                }
            }

            return list;
        }
    }

}
