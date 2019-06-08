package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: pyh
 * @Date: 2019/6/8 10:16
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 */
public class Solution103_二叉树的锯齿形遍历 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //就是二叉树的层次遍历，最后加入结果集的时候再逆序即可
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode first = root;
        TreeNode last = root;
        boolean change = false;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if(node.left != null){
                queue.add(node.left);
                last = node.left;
            }
            if(node.right != null){
                queue.add(node.right);
                last = node.right;
            }

            if(first == node){
                //加入结果集
                first = last;//变换节点
                if(!change){
                    //按照原来的顺序添加
                    List<Integer> temp = new ArrayList<>(list);
                    res.add(temp);
                    list = new ArrayList<>();
                } else{
                    List<Integer> temp = new ArrayList<>();
                    for(int i = list.size() - 1; i >= 0; i--){
                        temp.add(list.get(i));
                    }
                    res.add(temp);
                    list = new ArrayList<>();
                }
                change = !change;//反置
            }
        }

        return res;
    }

}
