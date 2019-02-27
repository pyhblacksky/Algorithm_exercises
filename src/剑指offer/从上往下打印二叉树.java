package 剑指offer;

import java.util.ArrayList;

import static 剑指offer.Tools.printArrList;

/**
 * @Author: pyh
 * @Date: 2019/2/18 8:25
 * @Version 1.0
 * @Function:
 *      从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class 从上往下打印二叉树 {

    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<TreeNode> queue = new ArrayList<>();

        if(root == null){
            return res;
        }

        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.remove(0);
            res.add(node.val);
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
        return res;

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

        ArrayList<Integer> res = PrintFromTopToBottom(r1);
        printArrList(res);
    }
}
