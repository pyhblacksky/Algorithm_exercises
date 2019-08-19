package LeetCodeRace.Contest150;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: pyh
 * @Date: 2019/8/18 10:42
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
 *
 * 请你找出层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
 *
 *
 *
 * 示例：
 *
 *
 *
 * 输入：[1,7,0,7,-8,null,null]
 * 输出：2
 * 解释：
 * 第 1 层各元素之和为 1，
 * 第 2 层各元素之和为 7 + 0 = 7，
 * 第 3 层各元素之和为 7 + -8 = -1，
 * 所以我们返回第 2 层的层号，它的层内元素之和最大。
 *
 *
 * 提示：
 *
 * 树中的节点数介于 1 和 10^4 之间
 * -10^5 <= node.val <= 10^5
 */
public class S2 {

    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static class Solution {
        public int maxLevelSum(TreeNode root) {
            if(root == null || (root.left == null && root.right == null))
                return 1;

            Queue<TreeNode> queue = new LinkedList<>();
            List<Integer> cellSum = new LinkedList<>();
            queue.add(root);
            TreeNode pre = root;
            TreeNode last = root;
            int count = 0;
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                count += node.val;
                if(node.left != null){
                    queue.add(node.left);
                    last = node.left;
                }
                if(node.right != null){
                    queue.add(node.right);
                    last = node.right;
                }

                if(node == pre){
                    cellSum.add(count);
                    count = 0;
                    pre = last;
                }
            }

            int index = 0;
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < cellSum.size(); i++){
                if(cellSum.get(i) > max){
                    max = cellSum.get(i);
                    index = i;
                }
            }

            return index+1;
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(989);

        TreeNode t2 = new TreeNode(10250);
        TreeNode t3 = new TreeNode(98693);
        TreeNode t4 = new TreeNode(-89388);
        TreeNode t5 = new TreeNode(-32127);

        t1.right = t2;
        t2.left = t3;
        t2.right = t4;
        t4.right = t5;

        Solution solution = new Solution();
        int num = solution.maxLevelSum(t1);
        System.out.println(num);
    }
}
