package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: pyh
 * @Date: 2019/2/26 14:26
 * @Version 1.0
 * @Function:   107. 二叉树的层次遍历 II
 *
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
public class Solution107_二叉树的层次遍历2 {

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode pre = root;
        TreeNode last = root;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if(node.left != null){
                queue.offer(node.left);
                last = node.left;
            }
            if(node.right != null){
                queue.offer(node.right);
                last = node.right;
            }

            if(pre == node){
                pre = last;
                List<Integer> temp = new ArrayList<>(list);
                res.add(temp);
                list = new ArrayList<>();
            }
        }

        //翻转操作
        List<List<Integer>> result = new ArrayList<>();
        for(int i = res.size()-1; i >= 0; i--){
            result.add(res.get(i));
        }

        return result;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
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

        levelOrderBottom(r1);
    }
}