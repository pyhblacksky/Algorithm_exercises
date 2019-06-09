package LeetCodeRace.Contest140;

/**
 * @Author: pyh
 * @Date: 2019/6/9 11:38
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定二叉树的根 root，考虑所有从根到叶的路径：从根到任何叶的路径。 （叶节点是没有子节点的节点。）
 *
 * 如果交于节点 node 的每个根到叶路径的总和严格小于限制 limit，则该节点为不足节点。
 *
 * 同时删除所有不足节点，并返回生成的二叉树的根。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3,4,-99,-99,7,8,9,-99,-99,12,13,-99,14], limit = 1
 *
 * 输出：[1,2,3,4,null,null,7,8,9,null,14]
 * 示例 2：
 *
 *
 * 输入：root = [5,4,8,11,null,17,4,7,1,null,null,5,3], limit = 22
 *
 * 输出：[5,4,8,11,null,17,4,7,null,null,null,5]
 * 示例 3：
 *
 *
 * 输入：root = [5,-6,-6], limit = 0
 * 输出：[]
 *
 *
 * 提示：
 *
 * 给定的树有 1 到 5000 个节点
 * -10^5 <= node.val <= 10^5
 * -10^9 <= limit <= 10^9
 */
public class 根到叶路径上的不足节点 {

    //应该是对每个进行消除
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        int val = dfs(root, limit, 0);
        if(val < limit){
            return null;
        }
        return root;
    }

    private int dfs(TreeNode node,int lim,int p){
        if(node==null)
            return 0;
        if(node.left == null && node.right == null)
            return node.val;

        p += node.val;
        int sumLeft = 0, sumRight = 0;
        if(node.left != null){
            sumLeft = dfs(node.left, lim, p);
            if(p + sumLeft < lim)
                node.left = null;
        }

        if(node.right != null){
            sumRight = dfs(node.right, lim, p);
            if(p + sumRight < lim)
                node.right = null;
        }

        return node.val + Math.max(sumLeft, sumRight);
    }


    public static void main(String[] args){

    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
