package 剑指offer;

/**
 * @Author: pyh
 * @Date: 2019/2/20 8:18
 * @Version 1.0
 * @Function:
 *      请实现一个函数，用来判断一颗二叉树是不是对称的。
 *      注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class 对称的二叉树 {

    static boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot == null){
            return false;
        }

        return help(pRoot.left, pRoot.right);
    }
    private static boolean help(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null && root2 != null){
            return false;
        }
        if(root1 != null && root2 == null){
            return false;
        }

        if(root1.val != root2.val){
            return false;
        }

        return help(root1.left, root2.right) && help(root1.right, root2.left);
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
        TreeNode r3 = new TreeNode(2);
        TreeNode r4 = new TreeNode(3);
        TreeNode r5 = new TreeNode(4);
        TreeNode r6 = new TreeNode(4);
        TreeNode r7 = new TreeNode(3);

        r1.left = r2;
        r1.right = r3;
        r2.left = r4;
        r2.right = r5;
        r3.left = r6;
        r3.right = r7;

        System.out.println(isSymmetrical(r1));
    }
}
