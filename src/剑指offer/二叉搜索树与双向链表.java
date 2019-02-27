package 剑指offer;

import java.util.ArrayList;
import java.util.Stack;

import static 剑指offer.Tools.printArrList;

/**
 * @Author: pyh
 * @Date: 2019/2/18 11:14
 * @Version 1.0
 * @Function:
 *      输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 *      要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class 二叉搜索树与双向链表 {

    //方法一：递归版本
    //利用二叉树线索化
    private TreeNode pre = null;
    private TreeNode lastLeft = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }

        Convert(pRootOfTree.left);
        pRootOfTree.left = pre;
        if(pre != null){
            pre.right = pRootOfTree;
        }
        pre = pRootOfTree;
        lastLeft = lastLeft == null ? pRootOfTree : lastLeft;
        Convert(pRootOfTree.right);
        return lastLeft;
    }

    //方法二：非递归版本
    public TreeNode Convert1(TreeNode pRootOfTree){
        if(pRootOfTree == null){
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = pRootOfTree;
        TreeNode pre = null;
        boolean isFirst = true;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            if(isFirst){
                pre = cur;
                pRootOfTree = cur;
                isFirst = false;
            } else{
                pre.right = cur;
                cur.left = pre;
                pre = cur;
            }

            cur = cur.right;
        }

        return pRootOfTree;
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    //二叉树的中序遍历，非递归版本
    public static ArrayList<Integer> InOrder(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        while(root != null){
            stack.push(root);
            root = root.left;
        }

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if(node.right != null){
                TreeNode temp = node.right;
                stack.push(temp);
                while (temp.left != null){
                    stack.push(temp.left);
                    temp = temp.left;
                }
            }
        }

        return res;
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

        ArrayList<Integer> res = InOrder(r1);
        printArrList(res);
    }
}
