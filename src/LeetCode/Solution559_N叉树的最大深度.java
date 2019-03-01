package LeetCode;

import java.util.List;

/**
 * @Author: pyh
 * @Date: 2019/2/28 20:29
 * @Version 1.0
 * @Function:   559、N叉树的最大深度
 *
 * 给定一个 N 叉树，找到其最大深度。
 *
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 *
 * 说明:
 *
 * 树的深度不会超过 1000。
 * 树的节点总不会超过 5000。
 */
public class Solution559_N叉树的最大深度 {

    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        if(root.children == null){
            return 1;
        }
        int max = 0;
        for(Node node : root.children){
            max = Math.max(max, maxDepth(node));
        }
        return max + 1;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static void main(String[] args){
        int j = 10;
        System.out.println(~j);
    }
}