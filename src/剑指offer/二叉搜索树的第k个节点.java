package 剑指offer;

import java.util.Stack;

/**
 * @Author: pyh
 * @Date: 2019/2/20 10:48
 * @Version 1.0
 * @Function:
 *      给定一棵二叉搜索树，请找出其中的第k小的结点。
 *      例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 */
public class 二叉搜索树的第k个节点 {



    //中序遍历后得出结果
    static TreeNode KthNode(TreeNode pRoot, int k) {
        if(pRoot == null){
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();

        while(pRoot != null){
            stack.push(pRoot);
            pRoot = pRoot.left;
        }
        int count = 1;
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(count == k){
                return node;
            }
            count++;
            if(node.right != null){
                TreeNode temp = node.right;
                stack.push(temp);
                while (temp.left != null){
                    stack.push(temp.left);
                    temp = temp.left;
                }
            }
        }

        return null;
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
        TreeNode r1 = new TreeNode(8);
        TreeNode r2 = new TreeNode(6);
        TreeNode r3 = new TreeNode(10);
        TreeNode r4 = new TreeNode(5);
        TreeNode r5 = new TreeNode(7);
        TreeNode r6 = new TreeNode(9);
        TreeNode r7 = new TreeNode(11);

        r1.left = r2;
        r1.right = r3;
        r2.left = r4;
        r2.right = r5;
        r3.left = r6;
        r3.right = r7;

        TreeNode node = KthNode(r1, 5);
    }
}
