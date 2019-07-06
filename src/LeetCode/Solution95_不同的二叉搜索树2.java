package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: pyh
 * @Date: 2019/7/6 7:59
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution95_不同的二叉搜索树2 {

    //回溯    存在重复的情况!!!怎么去重呢?
    class Solution {
        List<TreeNode> list = new ArrayList<>();
        public List<TreeNode> generateTrees(int n) {
            if(n == 0)
                return list;

            TreeNode root = new TreeNode(0);//作为哨兵
            getRes(root, n ,0);
            return list;
        }

        private void getRes(TreeNode root, int n, int index){
            if(n == index){
                TreeNode copy = treeCopy(root);
                list.add(copy.right);
                return;
            }

            TreeNode copyRoot = root;
            for(int i = 1; i <= n; i++){
                root = copyRoot;
                while(root != null){
                    if(i < root.val){
                        //插入左子树
                        if(root.left == null){
                            root.left = new TreeNode(i);
                            getRes(copyRoot, n, index+1);
                            root.left = null;
                            break;
                        }
                        root = root.left;
                    } else if(i > root.val){
                        //插入右子树
                        if(root.right == null){
                            root.right = new TreeNode(i);
                            getRes(copyRoot, n, index+1);
                            root.right = null;
                            break;
                        }
                        root = root.right;
                    } else
                        break;//相同值，结束
                }
            }
        }

        //拷贝树的功能函数
        private TreeNode treeCopy(TreeNode root){
            if(root == null)
                return null;
            TreeNode node = new TreeNode(root.val);
            node.left = treeCopy(root.left);
            node.right = treeCopy(root.right);
            return node;
        }

    }

    //递归   利用二叉搜索树的性质 每个数字作为根节点，其他数字可能作为左右子树，组合起来
    class Solution1{
        public List<TreeNode> generateTrees(int n) {
            if(n == 0)
                return new ArrayList<>();

            return getRes(1, n);
        }

        private List<TreeNode> getRes(int start, int end){
            List<TreeNode> res = new ArrayList<>();
            if(start > end){
                res.add(null);
                return res;
            }

            if(start == end){
                TreeNode node = new TreeNode(start);
                res.add(node);
                return res;
            }

            for(int i = start; i <= end; i++){
                List<TreeNode> left = getRes(start, i-1);
                List<TreeNode> right = getRes(i+1, end);
                //组合
                for(TreeNode leftNode : left){
                    for(TreeNode rightNode : right){
                        TreeNode root = new TreeNode(i);
                        root.left = leftNode;
                        root.right = rightNode;
                        res.add(root);
                    }
                }
            }

            return res;
        }
    }

    //动态规划
    class Solution2{
        public List<TreeNode> generateTrees(int n) {
            List<TreeNode> pre = new ArrayList<>();
            if(n == 0)
                return pre;

            pre.add(null);
            for(int i = 1; i <= n; i++){    //每次增加一个数字
                List<TreeNode> cur = new ArrayList<>();
                for(TreeNode root : pre){   //遍历之前所有解
                    TreeNode insert = new TreeNode(i);  //插入到根节点
                    insert.left = root;
                    cur.add(insert);
                    for(int j = 0; j <= n; j++){    //插入到右孩子，右孩子的右孩子，...，最多查找n次右孩子
                        TreeNode rootCopy = copyTree(root); //复制当前的树
                        TreeNode right = rootCopy;      //找到要插入的右孩子的位置

                        for(int k = 0; k < j; k++){      //遍历j次找右孩子
                            if(right == null)
                                break;
                            right = right.right;
                        }

                        if(right == null)
                            break;//到达null 提前结束

                        //保存当前右孩子的位置的子树作为插入节点的左孩子
                        TreeNode rightTree = right.right;
                        insert = new TreeNode(i);
                        right.right = insert;   //右孩子是插入节点
                        insert.left = rightTree;    //插入节点的左孩子更新为插入位置之前的子树
                        cur.add(rootCopy);
                    }
                }
                pre = cur;
            }

            return pre;
        }

        //复制当前树的方法
        private TreeNode copyTree(TreeNode root){
            if(root == null)
                return null;
            TreeNode node = new TreeNode(root.val);
            node.left = copyTree(root.left);
            node.right = copyTree(root.right);
            return node;
        }
    }
}
