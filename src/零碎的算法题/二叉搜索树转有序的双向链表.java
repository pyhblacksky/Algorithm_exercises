package 零碎的算法题;

/**
 * @Author: pyh
 * @Date: 2019/2/16 15:48
 * @Version 1.0
 * @Function:
 *      二叉搜索树转有序的双向链表
 *      输入一棵二叉搜索树，将该二叉搜索树转换为一个排序的双向链表。
 *      要求：不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 *      求额外的空间复杂度必须控制在O(1)，也就是说必须在遍历的过程中完整链表的操作，所以会设计很多指针转换。
 */
public class 二叉搜索树转有序的双向链表 {
    public TreeNode Convert1(TreeNode pRootOfTree){
        return null;
    }

    public static class TreeNode{
        int val = 0;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
}
