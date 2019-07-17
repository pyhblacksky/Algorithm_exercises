package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/7/17 15:07
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution106_从中序与后序遍历序列构造二叉树 {

    static class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if(inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0)
                return null;

            return getNode(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
        }

        public TreeNode getNode(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend){
            if(instart > inend || poststart > postend){
                return null;
            }

            TreeNode root = new TreeNode(postorder[postend]);
            for(int i = instart; i <= inend; i++){
                if(inorder[i] == root.val){
                    root.left = getNode(inorder, instart, i-1, postorder, poststart, i - instart + poststart-1);
                    root.right = getNode(inorder, i+1, inend, postorder, i - instart + poststart, postend-1);
                    break;
                }
            }
            return root;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] in = {9,3,15,20,7};
        int[] post= {9,15,7,20,3};

        solution.buildTree(in, post);
    }

}
