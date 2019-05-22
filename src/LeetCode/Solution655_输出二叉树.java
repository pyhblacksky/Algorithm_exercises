package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: pyh
 * @Date: 2019/5/21 16:24
 * @Version: 1.0
 * @Function:
 * @Description:
 * 在一个 m*n 的二维字符串数组中输出二叉树，并遵守以下规则：
 *
 * 行数 m 应当等于给定二叉树的高度。
 * 列数 n 应当总是奇数。
 * 根节点的值（以字符串格式给出）应当放在可放置的第一行正中间。根节点所在的行与列会将剩余空间划分为两部分（左下部分和右下部分）。你应该将左子树输出在左下部分，右子树输出在右下部分。左下和右下部分应当有相同的大小。即使一个子树为空而另一个非空，你不需要为空的子树输出任何东西，但仍需要为另一个子树留出足够的空间。然而，如果两个子树都为空则不需要为它们留出任何空间。
 * 每个未使用的空间应包含一个空的字符串""。
 * 使用相同的规则输出子树。
 * 示例 1:
 *
 * 输入:
 *      1
 *     /
 *    2
 * 输出:
 * [["", "1", ""],
 *  ["2", "", ""]]
 * 示例 2:
 *
 * 输入:
 *      1
 *     / \
 *    2   3
 *     \
 *      4
 * 输出:
 * [["", "", "", "1", "", "", ""],
 *  ["", "2", "", "", "", "3", ""],
 *  ["", "", "4", "", "", "", ""]]
 * 示例 3:
 *
 * 输入:
 *       1
 *      / \
 *     2   5
 *    /
 *   3
 *  /
 * 4
 * 输出:
 * [["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 *  ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 *  ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 *  ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
 */
public class Solution655_输出二叉树 {

    //先取得树的高度，再进行填充
    public List<List<String>> printTree(TreeNode root) {
        if(root == null){
            return null;
        }

        int h = getDepth(root);
        int n = (1 << h) - 1;
        List<List<String>> res = new ArrayList<>(h);
        for (int i = 0; i < h; i++) {
            List<String> list=new ArrayList<>(n);
            res.add(list);
            for (int j=0;j < n;j++) {
                list.add("");
            }
        }

        dfs(root,0,n-1,0,res);
        return res;
    }
    private void dfs(TreeNode root, int left, int right, int h, List<List<String>> res) {
        if(root == null){
            return;
        }

        int mid = (left+right) / 2;
        res.get(h).set(mid, String.valueOf(root.val));
        dfs(root.left, left, mid-1, h+1, res);
        dfs(root.right, mid+1, right, h+1, res);

    }

    static int getDepth(TreeNode node){
        if(node == null){
            return 0;
        }

        int right = getDepth(node.right) + 1;
        int left = getDepth(node.left) + 1;
        return Math.max(left, right);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args){

    }
}
