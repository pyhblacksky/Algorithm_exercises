package LeetCode;

import java.util.ArrayList;

/**
 * @Author: pyh
 * @Date: 2019/5/27 11:18
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * 输出: 6
 * 示例 2:
 *
 * 输入: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 输出: 42
 *
 */
public class Solution124_二叉树中的最大路径和 {


    //正解,递归计算,分开函数
    public int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root){
        if(root == null){
            return 0;
        }

        getMax(root);
        return maxSum;
    }
    public int getMax(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftVal = Math.max(0,getMax(root.left));
        int rightVal = Math.max(0,getMax(root.right));
        maxSum = Math.max(maxSum, leftVal+rightVal+root.val);
        return Math.max(leftVal, rightVal) + root.val;
    }


    /*************************************************************/
    //中序遍历后，求最大连续序列和，错误解法
    public int maxPathSum1(TreeNode root) {
        if(root == null){
            return 0;
        }

        ArrayList<Integer> list = new ArrayList<>();

        //存在问题，不能一步跨越到root节点

        midOrder(root, list);
        for(int num : list){
            System.out.print(num + " ");
        }
        System.out.println();
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < list.size(); i++){
            int num = list.get(i);
            if(sum < 0){
                sum = num;
            } else{
                sum += num;
            }

            max = Math.max(max, sum);
        }

        return max;
    }

    static void midOrder(TreeNode node, ArrayList<Integer> list){
        if(node == null) {
            return;
        }

        midOrder(node.left, list);
        list.add(node.val);
        midOrder(node.right, list);
    }

}
