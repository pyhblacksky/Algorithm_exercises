package 剑指offer;

/**
 * @Author: pyh
 * @Date: 2019/2/19 21:58
 * @Version 1.0
 * @Function:
 *      给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 *      注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class 二叉树的下一个结点 {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode == null){
            return null;
        }

        //如果有右子树
        if(pNode.right != null){
            TreeLinkNode node = pNode.right;
            while(node.left != null){
                node = node.left;
            }
            return node;
        }

        //如果没有右子树
        while(pNode.next != null){
            if(pNode.next.left == pNode){
                return pNode.next;
            }
            pNode = pNode.next;
        }

        return null;
    }

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

}
