package LeetCode;

import java.util.*;

/**
 * @Author: pyh
 * @Date: 2019/5/27 9:57
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 *
 * 例如，给定一个 3叉树 :
 *
 *
 *
 *
 *
 *
 *
 * 返回其层序遍历:
 *
 * [
 *      [1],
 *      [3,2,4],
 *      [5,6]
 * ]
 *
 *
 * 说明:
 *
 * 树的深度不会超过 1000。
 */
public class Solution429_N叉树的层次遍历 {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        Queue<Node> queue = new LinkedList<>();
        Node start = root;
        Node end = root;
        queue.add(root);
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            Node node = queue.poll();
            list.add(node.val);

            for(int i = 0; i < node.children.size(); i++){
                queue.add(node.children.get(i));
                start = node.children.get(i);
            }

            if(node == end){
                List<Integer> temp = new ArrayList<>(list);
                res.add(temp);
                list = new ArrayList<>();
                end = start;
            }
        }

        return res;
    }

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