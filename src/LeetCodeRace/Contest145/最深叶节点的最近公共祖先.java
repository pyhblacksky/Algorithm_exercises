package LeetCodeRace.Contest145;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: pyh
 * @Date: 2019/7/14 10:31
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 给你一个有根节点的二叉树，找到它最深的叶节点的最近公共祖先。
 *
 * 回想一下：
 *
 * 叶节点 是二叉树中没有子节点的节点
 * 树的根节点的 深度 为 0，如果某一节点的深度为 d，那它的子节点的深度就是 d+1
 * 如果我们假定 A 是一组节点 S 的 最近公共祖先，s 中的每个节点都在以 A 为根节点的子树中，且 A 的深度达到此条件下可能的最大值。
 *
 *
 * 示例 1：
 *
 * 输入：root = [1,2,3]
 * 输出：[1,2,3]
 * 示例 2：
 *
 * 输入：root = [1,2,3,4]
 * 输出：[4]
 * 示例 3：
 *
 * 输入：root = [1,2,3,4,5]
 * 输出：[2,4,5]
 *
 *
 * 提示：
 *
 * 给你的树中将有 1 到 1000 个节点。
 * 树中每个节点的值都在 1 到 1000 之间。
 */
public class 最深叶节点的最近公共祖先 {

    class Solution {
        public TreeNode lcaDeepestLeaves(TreeNode root) {
            if(root == null){
                return null;
            }

            int dep = getDepth(root);
            List<TreeNode> nodes = new ArrayList<>();
            getNode(root, dep-1, nodes);

            if(nodes.size() == 0){
                return root;
            }
            if(nodes.size() == 1){
                return nodes.get(0);
            }
            if(nodes.size() == 2){
                return findCom(root, nodes.get(0), nodes.get(1));
            }
            TreeNode res = findCom(root, nodes.get(0), nodes.get(1));
            for(int i = 1; i < nodes.size(); i++){
                res = findCom(root, nodes.get(i), res);
            }
            return res;
        }

        TreeNode findCom(TreeNode root, TreeNode p, TreeNode q){
            if(root == null || root == p || root == q){
                return root;
            }
            TreeNode left = findCom(root.left, p, q);
            TreeNode right = findCom(root.right, p, q);
            return left == null ? right : (right == null ? left : root);
        }

        int getDepth(TreeNode root){
            if(root == null)
                return 0;
            int left = getDepth(root.left);
            int right = getDepth(root.right);
            return Math.max(left, right) + 1;
        }

        void getNode(TreeNode root, int dep, List<TreeNode> nodes){
            if(root == null)
                return;
            if(dep == 0){
                if(!nodes.contains(root)){
                    nodes.add(root);
                }
                return;
            }

            getNode(root.left, dep-1, nodes);
            getNode(root.right, dep-1, nodes);
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
}
