package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static 剑指offer.Tools.printArrList;

/**
 * @Author: pyh
 * @Date: 2019/2/20 8:31
 * @Version 1.0
 * @Function:
 *      请实现一个函数按照之字形打印二叉树，
 *      即第一行按照从左到右的顺序打印，
 *      第二层按照从右至左的顺序打印，
 *      第三行按照从左到右的顺序打印，其他行以此类推。
 *
 */
public class 按之字形顺序打印二叉树 {

    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(pRoot == null){
            return res;
        }

        //先按行打印，再翻转
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode pre = pRoot;
        TreeNode last = pRoot;
        boolean zPrint = false;
        queue.offer(pRoot);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if(node.left != null){
                queue.offer(node.left);
                last = node.left;
            }
            if(node.right != null){
                queue.offer(node.right);
                last = node.right;
            }

            if(node == pre){
                if (zPrint){
                    //翻转
                    ArrayList<Integer> temp = new ArrayList<>();
                    for(int i = list.size()-1; i >= 0; i--){
                        temp.add(list.get(i));
                    }
                    res.add(temp);
                } else {
                    ArrayList<Integer> temp = new ArrayList<>(list);
                    res.add(temp);
                }
                zPrint = !zPrint;
                list = new ArrayList<>();
                pre = last;
            }
        }
        return res;
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args){
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);

        r1.left = r2;
        r1.right = r3;
        r2.left = r4;
        r2.right = r5;

        ArrayList<ArrayList<Integer>> res = Print(r1);
        for(ArrayList list : res){
            printArrList(list);
        }
    }
}
