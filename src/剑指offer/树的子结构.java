package 剑指offer;

/**
 * @Author: pyh
 * @Date: 2019/2/17 15:56
 * @Version 1.0
 * @Function:
 *      输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class 树的子结构 {

    public static boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null){
            return false;
        }
        return help(root1, root2) || HasSubtree(root1.right, root2) || HasSubtree(root1.left, root2);
    }
    private static boolean help(TreeNode root1, TreeNode root2){
        if(root2 == null){
            return true;
        }
        if(root1 == null){
            return false;
        }
        if(root1.val == root2.val){
            return help(root1.left, root2.left) && help(root1.right, root2.right);
        } else{
            return false;
        }
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

        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;
        node3.right = node4;

        System.out.println(HasSubtree(r1, node1));
    }
}
