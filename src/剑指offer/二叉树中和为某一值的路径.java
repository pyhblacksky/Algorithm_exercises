package 剑指offer;

import java.util.ArrayList;

import static 剑指offer.Tools.printArrList;

/**
 * @Author: pyh
 * @Date: 2019/2/18 10:05
 * @Version 1.0
 * @Function:
 *      输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 *      路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 *      (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class 二叉树中和为某一值的路径 {

    //方法一：精简版
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
    private ArrayList<Integer> arrayList = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target){
        if(root == null){
            return listAll;
        }
        arrayList.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null){
            listAll.add(new ArrayList<>(arrayList));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        arrayList.remove(arrayList.size()-1);//添加完后，回滚数据
        return listAll;
    }

    //方法二：分写函数
    public static ArrayList<ArrayList<Integer>> FindPath1(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null){
            return res;
        }
        help(root, list, res, 0, target);
        return res;
    }

    public static void help(TreeNode root, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> res, int sum, int target){
        if(root == null){
            if(sum == target && !res.contains(list)){
                ArrayList<Integer> temp =  new ArrayList<>(list);
                res.add(temp);
            }
            return;
        }

        sum += root.val;
        list.add(root.val);
        ArrayList<Integer> arr = new ArrayList<>(list);
        help(root.left, arr, res, sum, target);

        arr = new ArrayList<>(list);
        help(root.right, arr, res, sum, target);
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

        ArrayList<ArrayList<Integer>> res = FindPath1(r1, 4);

        for(ArrayList<Integer> list : res){
            printArrList(list);
        }
    }
}
