package 剑指offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: pyh
 * @Date: 2019/2/20 10:41
 * @Version 1.0
 * @Function:
 *      请实现两个函数，分别用来序列化和反序列化二叉树
 *
 */
public class 序列化二叉树 {

    //前序遍历序列化
    String Serialize(TreeNode root) {
        if(root == null){
            return "#_";
        }

        String res = root.val + "_";
        res += Serialize(root.left);
        res += Serialize(root.right);
        return res;
    }
    TreeNode Deserialize(String str) {
        String[] res = str.split("_");
        Queue<String> queue = new LinkedList<>();
        for(String s : res){
            queue.offer(s);
        }
        return help(queue);
    }
    private TreeNode help(Queue<String> queue){
        String str = queue.poll();
        if(str.equals("#")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(str));
        node.left = help(queue);
        node.right = help(queue);
        return node;
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
