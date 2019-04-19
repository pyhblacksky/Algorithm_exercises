package LeetCode;

import java.util.Arrays;

/**
 * @Author: pyh
 * @Date: 2019/4/19 15:51
 * @Version 1.0
 * @Function:
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 *
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 *
 * Example 1:
 *
 * 输入: [3,2,1,6,0,5]
 * 输入: 返回下面这棵树的根节点：
 *
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 */
public class Solution654_最大二叉树 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            max = Math.max(max, nums[i]);
        }
        TreeNode root = new TreeNode(max);
        for(int i = 0; i < nums.length; i++){
            if(root.val == nums[i]){
                int[] lessArr = Arrays.copyOfRange(nums, 0, i);
                int[] moreArr = Arrays.copyOfRange(nums, i+1, nums.length);
                TreeNode left = constructMaximumBinaryTree(lessArr);
                TreeNode right = constructMaximumBinaryTree(moreArr);
                root.left = left;
                root.right = right;
                break;
            }
        }
        return root;
    }

    public TreeNode findMaxNode(int[] num){
        if(num == null || num.length == 0){
            return null;
        }

        int max = num[0];
        for(int i = 1; i < num.length; i++){
            max = Math.max(max, num[i]);
        }

        return new TreeNode(max);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args){
        Solution654_最大二叉树 solution = new Solution654_最大二叉树();
        solution.constructMaximumBinaryTree(new int[]{3,2,1,6,0,5});

    }
}
