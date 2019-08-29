package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: pyh
 * @Date: 2019/8/20 21:06
 * @Version: 1.0
 * @Function:
 * @Description:
 */
public class Solution865_具有所有最深结点的最小子树 {


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //两次深度优先搜索
    /**
     * 最直白的做法，先做一次深度优先搜索标记所有节点的深度来找到最深的节点，再做一次深度优先搜索用回溯法找最小子树。定义第二次深度优先搜索方法为 answer(node)，每次递归有以下四种情况需要处理：
     *
     * 如果 node 没有左右子树，返回 node。
     *
     * 如果 node 左右子树的后代中都有最深节点，返回 node。
     *
     * 如果只有左子树或右子树中有且拥有所有的最深节点，返回这棵子树的根节点（即 node 的左/右孩子）。
     *
     * 否则，当前子树中不存在答案。
     * */
    class Solution {
        Map<TreeNode, Integer> map = new HashMap<>();
        int maxDep;

        public TreeNode subtreeWithAllDeepest(TreeNode root) {
            if(root == null || (root.left == null && root.right == null))
                return root;

            map.put(null, -1);
            dfs(root, null);
            maxDep = -1;
            for(Integer num : map.values()){
                maxDep = Math.max(maxDep, num);
            }


            return getAnswer(root);
        }

        public void dfs(TreeNode node, TreeNode parent){
            if(node != null){
                map.put(node, map.get(parent) + 1);
                dfs(node.left, node);
                dfs(node.right, node);
            }
        }

        public TreeNode getAnswer(TreeNode root){
            if(root == null || map.get(root) == maxDep){
                return root;
            }

            TreeNode L = getAnswer(root.left);
            TreeNode R = getAnswer(root.right);
            if(L != null && R != null)
                return root;
            if(L != null)
                return L;
            if(R != null)
                return R;

            return null;
        }

    }

    //一次深度优先搜索
    class Solution1{
        class Result{
            TreeNode node;
            int dist;
            Result(TreeNode node, int dist){
                this.node = node;
                this.dist = dist;
            }
        }

        public TreeNode subtreeWithAllDeepest(TreeNode root) {
            return dfs(root).node;
        }

        public Result dfs(TreeNode root){
            if(root == null)
                return new Result(null, 0);
            Result L = dfs(root.left);
            Result R = dfs(root.right);
            if(L.dist > R.dist)
                return new Result(L.node, L.dist+1);
            if(L.dist < R.dist)
                return new Result(R.node, R.dist+1);

            return new Result(root, L.dist+1);
        }
    }

}
