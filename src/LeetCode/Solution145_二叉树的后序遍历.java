package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: pyh
 * @Date: 2019/2/26 17:14
 * @Version 1.0
 * @Function:
 *
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 */
public class Solution145_二叉树的后序遍历 {

    //递归版
    public List<Integer> postorderTraversal1(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        last(root, list);
        return list;
    }
    public void last(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        last(root.left, list);
        last(root.right, list);
        list.add(root.val);
    }

    //非递归版，使用前插法
    public List<Integer> postorderTraversal2(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.add(0, node.val);
            if(node.left != null){
                stack.push(node.left);
            }
            if(node.right != null){
                stack.push(node.right);
            }
        }
        return list;
    }

    //非递归版不使用前插
    public List<Integer> postorderTraversal3(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode pre = null;    //表示上一个访问节点
        while(!stack.isEmpty()){
            TreeNode cur = stack.peek();
            //如果当前节点左右子节点为空或上一个访问的节点为当前节点的子节点
            if((cur.left == null && cur.right == null) ||
                    (pre != null && (pre == cur.left || pre == cur.right))){
                pre = cur;
                list.add(cur.val);
                stack.pop();
            } else{
                //先右节点入栈
                if(cur.right != null){
                    stack.push(cur.right);
                }
                if(cur.left != null){
                    stack.push(cur.left);
                }
            }
        }
        return list;
    }

    //方法4，用两个栈，一个栈存放标志位，是否写入
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }

        Stack<TreeNode> stack1 = new Stack<>();//用于存放数据
        Stack<Integer> stack2 = new Stack<>();//存放数字，表示什么时候写入
        stack1.push(root);
        stack2.push(0);//为0表示不写入，1表示写入
        while(!stack1.isEmpty()){
            int flag = stack2.pop();
            if(flag == 0){
                stack2.push(1);
                TreeNode cur = stack1.peek();
                if(cur.right != null){
                    stack1.push(cur.right);
                    stack2.push(0);
                }
                if(cur.left != null){
                    stack1.push(cur.left);
                    stack2.push(0);
                }
            } else{
                list.add(stack1.pop().val);
            }
        }
        return list;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
