package LeetCodeRace.Contest144;

import java.util.*;

/**
 * @Author: pyh
 * @Date: 2019/7/7 10:52
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 给出二叉树的根节点 root，树上每个节点都有一个不同的值。
 *
 * 如果节点值在 to_delete 中出现，我们就把该节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。
 *
 * 返回森林中的每棵树。你可以按任意顺序组织答案。
 *
 *
 *
 * 示例：
 *
 *
 *
 * 输入：root = [1,2,3,4,5,6,7], to_delete = [3,5]
 * 输出：[[1,2,null,4],[6],[7]]
 *
 *
 * 提示：
 *
 * 树中的节点数最大为 1000。
 * 每个节点都有一个介于 1 到 1000 之间的值，且各不相同。
 * to_delete.length <= 1000
 * to_delete 包含一些从 1 到 1000、各不相同的值。
 */
public class 删点成林 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        List<TreeNode> list = new ArrayList<>();
        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            if(root == null || to_delete == null || to_delete.length == 0)
                return list;

            Set<Integer> set = new HashSet<>();
            for(int num : to_delete)
                set.add(num);

            if(!set.contains(root.val))
                list.add(root);

            getRes(root,set,null);
            return list;
        }

        public void getRes(TreeNode root,Set<Integer> set,TreeNode parrent){
            if(root == null)
                return;

            if(set.contains(root.val)){
                //断开前项连接
                if(parrent != null){
                    if(parrent.left == root){
                        parrent.left = null;
                    }else{
                        parrent.right = null;
                    }
                }
                //判断左子树
                if(root.left != null){
                    if(!set.contains(root.left.val)){
                        list.add(root.left);
                    }
                    getRes(root.left, set, root);
                }

                //判断右子树
                if(root.right != null){
                    if(!set.contains(root.right.val)){
                        list.add(root.right);
                    }
                    getRes(root.right, set, root);
                }
            } else{
                if(root.left != null){
                    getRes(root.left,set,root);
                }

                if(root.right != null){
                    getRes(root.right,set,root);
                }
            }
        }
    }

}
