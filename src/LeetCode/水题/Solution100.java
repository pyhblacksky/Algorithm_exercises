package LeetCode.水题;

/**
 * @Author: pyh
 * @Date: 2019/2/25 14:09
 * @Version 1.0
 * @Function:   100、相同的树
 *
 */
public class Solution100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        if(p.val == q.val){
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else{
            return false;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
