package 剑指offer;

/**
 * @Author: pyh
 * @Date: 2019/2/16 15:27
 * @Version 1.0
 * @Function:
 *      重建二叉树
 *      输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 *      假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *      例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 *      思路：
 *      按照复原的步骤进行编写
 */
public class reConstructBinaryTree {

    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode node = preOrder(pre, 0, pre.length-1, in, 0, in.length-1);
        return node;
    }

    public static TreeNode preOrder(int[] pre, int preStart, int preEnd, int[] in, int midStart, int midEnd){
        if (preStart > preEnd || midStart > midEnd){
            return null;
        }

        TreeNode node = new TreeNode(pre[preStart]);
        for(int i = midStart; i <= midEnd; i++){
            if(in[i] == pre[preStart]){
                // i - midStart是此根节点前面的节点个数
                node.left = preOrder(pre, preStart+1, i-midStart+preStart, in, midStart, i-1);
                node.right = preOrder(pre, i - midStart + preStart + 1, preEnd, in, i+1, midEnd);
                break;
            }
        }
        return node;
    }

    /******************************************************************************************************************/
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args){

    }
}
