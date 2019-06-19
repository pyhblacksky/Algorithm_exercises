package LeetCode;

import java.util.Stack;

/**
 * @Author: pyh
 * @Date: 2019/6/19 13:59
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 1
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 3
 * 进阶：
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution230_二叉搜索树中第K小的元素 {

    //中序遍历后取值
    static class Solution {
        public int kthSmallest(TreeNode root, int k) {
            if(root == null){
                return -1;
            }

            Stack<TreeNode> stack = new Stack<>();
            while(root != null){
                stack.push(root);
                root = root.left;
            }

            int count = 0;
            while(!stack.isEmpty()){
                TreeNode node = stack.pop();
                count++;
                if(count == k){
                    //找到第几小的，直接输出
                    return node.val;
                }
                if(node.right != null){
                    TreeNode temp = node.right;
                    while(temp != null){
                        stack.push(temp);
                        temp = temp.left;
                    }
                }
            }

            return -1;
        }
    }

    static class Solution1{

    }


    public static void main(String[] args){

    }

}
