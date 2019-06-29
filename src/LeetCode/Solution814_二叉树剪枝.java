package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/6/28 16:44
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定二叉树根结点 root ，此外树的每个结点的值要么是 0，要么是 1。
 *
 * 返回移除了所有不包含 1 的子树的原二叉树。
 *
 * ( 节点 X 的子树为 X 本身，以及所有 X 的后代。)
 *
 * 示例1:
 * 输入: [1,null,0,0,1]
 * 输出: [1,null,0,null,1]
 *
 * 解释:
 * 只有红色节点满足条件“所有不包含 1 的子树”。
 * 右图为返回的答案。
 *
 *
 * 示例2:
 * 输入: [1,0,1,0,0,0,1]
 * 输出: [1,null,1,null,1]
 *
 *
 *
 * 示例3:
 * 输入: [1,1,0,1,1,0,1,0]
 * 输出: [1,1,0,1,1,null,1]
 *
 *
 *
 * 说明:
 *
 * 给定的二叉树最多有 100 个节点。
 * 每个节点的值只会为 0 或 1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-pruning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution814_二叉树剪枝 {

    //递归，对左右子树分别判断并剪枝
    class Solution {
        public TreeNode pruneTree(TreeNode root) {
            if(root == null){
                return null;
            }

            if(judge(root.left)){
                root.left = null;
            } else{
                pruneTree(root.left);
            }
            if(judge(root.right)){
                root.right = null;
            } else{
                pruneTree(root.right);
            }
            return root;
        }

        //先行判断
        boolean judge(TreeNode root){
            if(root == null){
                return true;
            } else if(root.val == 1){
                return false;
            } else if(root.left == null && root.right == null){
                return root.val == 0;
            }
            return judge(root.left) && judge(root.right);
        }
    }


    //错误解法。。。
    class Solution1{
        public TreeNode pruneTree(TreeNode root) {
            if(root == null){
                return null;
            }

            root.left = pruneTree(root.left);
            root.right = pruneTree(root.right);

            if(root.left != null && root.right != null && root.val == 0)
                return null;
            return root;
        }
    }

}
