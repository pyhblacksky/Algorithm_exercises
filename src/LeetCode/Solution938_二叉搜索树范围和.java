package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: pyh
 * @Date: 2019/6/28 11:24
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
 *
 * 二叉搜索树保证具有唯一的值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
 * 输出：32
 * 示例 2：
 *
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * 输出：23
 *  
 *
 * 提示：
 *
 * 树中的结点数量最多为 10000 个。
 * 最终的答案保证小于 2^31。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-of-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution938_二叉搜索树范围和 {

    //中序遍历后取值，非递归
    class Solution {
        public int rangeSumBST(TreeNode root, int L, int R) {
            if(root == null || L > R){
                return 0;
            }

            Deque<TreeNode> stack = new ArrayDeque<>();
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            int count = 0;
            while(!stack.isEmpty()){
                TreeNode node = stack.pop();
                if(node.val >= L && node.val <= R){
                    count += node.val;
                }
                if(node.val > R){
                    break;
                }
                if(node.right != null){
                    TreeNode temp = node.right;
                    while(temp != null){
                        stack.push(temp);
                        temp = temp.left;
                    }
                }
            }
            return count;
        }
    }

    //递归，速度反而比较快？
    class Solution1 {
        int res = 0;
        public int rangeSumBST(TreeNode root, int L, int R) {
            if(root == null){
                return 0;
            }

            rangeSumBST(root.left, L, R);
            if(root.val >= L && root.val <= R){
                res += root.val;
            }
            if(root.val > R){
                return res;
            }
            rangeSumBST(root.right, L, R);
            return res;
        }
    }

    //另外一种递归，速度更快。。。
    class Solution2 {
        public int rangeSumBST(TreeNode root, int L, int R) {
            if(root == null){
                return 0;
            }

            if(root.val < L){
                return rangeSumBST(root.right, L, R);
            } else if(root.val > R){
                return rangeSumBST(root.left, L, R);
            } else{
                return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
            }
        }
    }
}
