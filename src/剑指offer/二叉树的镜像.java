package 剑指offer;

/**
 * @Author: pyh
 * @Date: 2019/2/17 16:48
 * @Version 1.0
 * @Function:
 *      操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class 二叉树的镜像 {

    //方法一,利用exch的思想
    public static void Mirror1(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;

        if(root.left != null){
            Mirror1(root.left);
        }
        if(root.right != null){
            Mirror1(root.right);
        }
    }

    //方法二
    public static void Mirror(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode node = help(root);
        root.val = node.val;
        root.left = node.left;
        root.right = node.right;
    }
    private static TreeNode help(TreeNode root){
        if(root == null){
            return null;
        }

        TreeNode node = new TreeNode(root.val);
        node.left = help(root.right);
        node.right = help(root.left);
        return node;
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args){
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);

        r1.left = r2;
        r1.right = r3;
        r2.left = r4;
        r2.right = r5;

        Mirror(r1);

        int a = 0;
    }

}
