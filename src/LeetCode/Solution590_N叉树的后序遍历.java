package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: pyh
 * @Date: 2019/2/26 19:41
 * @Version 1.0
 * @Function: 590. N叉树的后序遍历
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 *      1
 *  3   2   4
 *5 6
 * 返回其后序遍历: [5,6,3,2,4,1].
 */
public class Solution590_N叉树的后序遍历 {

    //类似二叉树的后序遍历

    //递归版本
    public List<Integer> postorder1(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }

        last(root, list);
        return list;
    }
    private static void last(Node node, List<Integer> list){
        if(node == null){
            return;
        }
        List<Node> temp = node.children;
        for(int i = 0; i < temp.size(); i++){
            last(temp.get(i), list);
        }
        list.add(node.val);
    }

    //非递归版,前插法
    public List<Integer> postorder(Node node){
        List<Integer> list = new ArrayList<>();
        if(node == null){
            return list;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            list.add(0, cur.val);
            if(cur.children != null){
                for(int i = 0; i < cur.children.size(); i++){
                    stack.push(cur.children.get(i));
                }
            }
        }
        return list;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
