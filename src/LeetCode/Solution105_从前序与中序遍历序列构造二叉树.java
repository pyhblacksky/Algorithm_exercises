package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/6/19 16:09
 * @Version: 1.0
 * @Function:
 * @Description:
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution105_从前序与中序遍历序列构造二叉树 {

    //递归
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return recover(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
        }

        TreeNode recover(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd){
            if(preStart > preEnd || inStart > inEnd)
                return null;

            TreeNode root = new TreeNode(pre[preStart]);
            for(int i = inStart; i <= inEnd; i++){
                if(in[i] == pre[preStart]){
                    root.left = recover(pre,preStart+1, preStart + i - inStart, in, inStart, i-1);
                    root.right = recover(pre, i - inStart + preStart + 1, preEnd, in, i+1, inEnd);
                    break;
                }
            }

            return root;
        }
    }

}
