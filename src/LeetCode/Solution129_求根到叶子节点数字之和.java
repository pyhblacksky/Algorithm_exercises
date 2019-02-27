package LeetCode;

import java.util.ArrayList;

/**
 * @Author: pyh
 * @Date: 2019/2/26 15:23
 * @Version 1.0
 * @Function:   129、求根到叶子节点数字之和
 *
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 *
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *
 * 计算从根到叶子节点生成的所有数字之和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *     1
 *    / \
 *   2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 * 示例 2:
 *
 * 输入: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * 输出: 1026
 * 解释:
 * 从根到叶子节点路径 4->9->5 代表数字 495.
 * 从根到叶子节点路径 4->9->1 代表数字 491.
 * 从根到叶子节点路径 4->0 代表数字 40.
 * 因此，数字总和 = 495 + 491 + 40 = 1026.
 */
public class Solution129_求根到叶子节点数字之和 {

    //方法一：利用字符串存储特性
    public int sumNumbers1(TreeNode root) {
        if(root == null){
            return 0;
        }
        ArrayList<String> list = new ArrayList<>();
        sumString(root, new StringBuilder(), list);
        long res = 0;
        for(int i = 0; i < list.size(); i++){
            res += Long.valueOf(list.get(i));
        }
        return (int)res;
    }
    private static void sumString(TreeNode root, StringBuilder str, ArrayList<String> list){
        if(root == null){
            return;
        }
        str.append(root.val);

        if(root.left == null && root.right == null){
            list.add(str.toString());
            str.deleteCharAt(str.length()-1);//移除最后的字符，回溯
            return;
        }

        sumString(root.left, str, list);
        sumString(root.right, str, list);
        str.deleteCharAt(str.length()-1);//回溯的时候，移除最后的字符
    }

    //方法二：直接计算，不存储字符串
    public int sumNumbers(TreeNode root){
        if(root == null){
            return 0;
        }

        return help(root, 0);
    }
    //每个节点依次增加十倍
    private int help(TreeNode root, int k){
        int leftSum = 0, rightSum = 0;
        if(root.right == null && root.left == null){
            return k+root.val;
        }
        if(root.left != null){
            leftSum = help(root.left, 10*(k+root.val));
        }
        if(root.right != null){
            rightSum = help(root.right, 10*(k+root.val));
        }
        return leftSum + rightSum;
    }



    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
