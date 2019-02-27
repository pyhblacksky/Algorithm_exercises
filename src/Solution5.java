public class Solution5 {
    /**
     * 题目：二叉搜索树与双向链表
     * 描述：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
     *      要求不能创建任何新的结点，只能调整树中结点指针的指向。
     * 方法：
     *      按照中序遍历的方法，值得注意的是传递的是引用不是值
     * */
    public static TreeNode Convert(TreeNode pRootOfTree){
        if(pRootOfTree == null){
            return pRootOfTree;
        }
        //中序遍历搜索
        TreeNode[] temp = new TreeNode[1];//必须采用此方法，建立一个大小为1的数组来进行指针传递，否则是值传递
        help(pRootOfTree, temp);

        TreeNode res = pRootOfTree;
        while(res.left != null){
            res = res.left;
        }
        return res;
    }

    public static void help(TreeNode node, TreeNode[] temp){
        if(node == null){
            return;
        }
        help(node.left, temp);

        node.left = temp[0];
        if(temp[0] != null){
            temp[0].right = node;
        }
        temp[0] = node;//在java中，必须引用其指针。如果使用temp = node；则值不会发生改变

        help(node.right, temp);
    }

    public static class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right= null;
        public TreeNode(int val){
            this.val = val;
        }
    }

    /**
     * 类似二叉线索化的方法
     * */
    TreeNode  pre = null;
    TreeNode lastLeft = null;
    public TreeNode Convert1(TreeNode pRootOfTree){
        if(pRootOfTree == null){
            return null;
        }

        Convert1(pRootOfTree.left);
        pRootOfTree.left = pre;
        if(pre != null){
            pre.right = pRootOfTree;
        }
        pre = pRootOfTree;
        lastLeft = lastLeft == null ? pRootOfTree : lastLeft;
        Convert1(pRootOfTree.right);
        return lastLeft;
    }

    public static void main(String[] args){
        //测试用例
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t2.left = t1;
        t2.right = t3;
        //Convert(t2);

        Solution5 s5 = new Solution5();
        s5.Convert1(t2);
        while(t2 != null){
            System.out.print(t2.val + " ");
            t2 = t2.left;
        }
        System.out.println();
    }
}
