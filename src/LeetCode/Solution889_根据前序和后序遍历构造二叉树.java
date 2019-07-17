package LeetCode;

import java.util.Arrays;

/**
 * @Author: pyh
 * @Date: 2019/7/17 15:21
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 返回与给定的前序和后序遍历匹配的任何二叉树。
 *
 *  pre 和 post 遍历中的值是不同的正整数。
 *
 *  
 *
 * 示例：
 *
 * 输入：pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
 * 输出：[1,2,3,4,5,6,7]
 *  
 *
 * 提示：
 *
 * 1 <= pre.length == post.length <= 30
 * pre[] 和 post[] 都是 1, 2, ..., pre.length 的排列
 * 每个输入保证至少有一个答案。如果有多个答案，可以返回其中一个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution889_根据前序和后序遍历构造二叉树 {

    static class Solution {
        public TreeNode constructFromPrePost(int[] pre, int[] post) {
            if(pre == null || post == null)
                return null;

            int N = pre.length;
            if(N == 0)
                return null;
            if(N == 1)
                return new TreeNode(pre[0]);

            int L = 0;
            TreeNode root = new TreeNode(pre[0]);
            for(int i = 0; i < N; i++){
                if(pre[1] == post[i])
                    L = i+1;
            }

            root.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, L+1),
                    Arrays.copyOfRange(post, 0, L));
            root.right = constructFromPrePost(Arrays.copyOfRange(pre, L+1, N),
                    Arrays.copyOfRange(post, L, N-1));

            return root;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] pre = {1,2,4,5,3,6,7};
        int[] post = {4,5,2,6,7,3,1};
        solution.constructFromPrePost(pre, post);
    }

}
