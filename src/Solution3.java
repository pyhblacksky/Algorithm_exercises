import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Solution3 {

    public static void main1(String[] args){

        int[] arr = {1,2,3,2,2,2,5,4,2};

        boolean yes = true;

        System.out.println(NumberOf1Between1AndN_Solution(1));

        System.out.println(MoreThanHalfNum_Solution(arr));

        System.out.println(Sum_Solution(5));
    }

    public static int MoreThanHalfNum_Solution(int [] array) {

        if(array.length == 0){
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < array.length; i++){
            if(map.containsKey(array[i])){
                map.put(array[i], map.get(array[i]) + 1);
            } else{
                map.put(array[i], 1);
            }
        }

        int size = array.length / 2;
        for(int i : map.keySet()){
            if(map.get(i) > size){
                return i;
            }
        }
        return 0;

    }

    /**
     * 题目：整数1出现的次数
     * 方法：数学归纳法
     * 题目描述：
     * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
     * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
     * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
     *
     * 解决思路：
     * 设N = abcde ,其中abcde分别为十进制中各位上的数字。
     * 如果要计算百位上1出现的次数，它要受到3方面的影响：百位上的数字，百位以下（低位）的数字，百位以上（高位）的数字。
     * ① 如果百位上数字为0，百位上可能出现1的次数由更高位决定。比如：12013，
     *      则可以知道百位出现1的情况可能是：100~199，1100~1199,2100~2199，，...，11100~11199，一共1200个。
     *      可以看出是由更高位数字（12）决定，并且等于更高位数字（12）乘以 当前位数（100）。
     * ② 如果百位上数字为1，百位上可能出现1的次数不仅受更高位影响还受低位影响。
     *      比如：12113，则可以知道百位受高位影响出现的情况是：100~199，1100~1199,2100~2199，....，11100~11199，一共1200个。
     *      和上面情况一样，并且等于更高位数字（12）乘以 当前位数（100）。
     *      但同时它还受低位影响，百位出现1的情况是：12100~12113,一共114个，等于低位数字（113）+1。
     * ③ 如果百位上数字大于1（2~9），则百位上出现1的情况仅由更高位决定，
     *      比如12213，则百位出现1的情况是：100~199,1100~1199，2100~2199，...，11100~11199,12100~12199,
     *      一共有1300个，并且等于更高位数字+1（12+1）乘以当前位数（100）。
     * */
    public static int NumberOf1Between1AndN_Solution(int n) {

        int count = 0;//1的个数
        int i = 1;//当前位
        int current = 0,after = 0,before = 0;
        while((n/i)!= 0){
            current = (n/i)%10; //高位数字
            before = n/(i*10); //当前位数字
            after = n-(n/i)*i; //低位数字

            //如果为0,出现1的次数由高位决定,等于高位数字 * 当前位数
            if (current == 0) {
                count += before * i;
            }else if(current == 1) {
                //如果为1,出现1的次数由高位和低位决定,高位*当前位+低位+1
                count += before * i + after + 1;
            }else{
                //如果大于1,出现1的次数由高位决定,//（高位数字+1）* 当前位数
                count += (before + 1) * i;
            }
            //前移一位
            i = i*10;
        }
        return count;
    }

    /**
     * 题目：二叉树的下个节点
     * 描述：给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
     *      注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
     *
     * 方法描述：根据中序遍历的特点寻找，注意带有next指针可以找到父节点
     * */
    public static TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode == null){
            return pNode;
        }

        //如果当前节点有右子树，则找右子树最左节点
        if(pNode.right != null){
            TreeLinkNode node = pNode.right;
            while(node.left != null){
                node = node.left;
            }
            return node;
        }

        //没有右子树，则找第一个当前节点是父节点左孩子的节点
        while(pNode.next != null){
            if(pNode.next.left == pNode){
                return pNode.next;
            }
            pNode = pNode.next;
        }

        //退回到了根节点，还没找到，返回null，即他下个节点就是null
        return null;
    }

    public static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    /**
     * 题目：求1+2+3+...+n
     * 描述：求1+2+3+...+n，不使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     *
     * 解题方法：
     *  1.递归，利用&&的短路特性
     *      C++中可直接实现
     *      Java中需创建boolean变量
     *
     *  2.创建一个二维数组，a[n][n+1]
     *      求数组大小，将其右移1位.本质还是使用了乘法
     *      C++中实现，利用sizeOf()
     * */
    public static int Sum_Solution(int n){
        int ans = n;
        //当ans == 0，由&&短路特性，停止后面的调用
        boolean judge = (ans != 0) && (ans += Sum_Solution(n-1)) != 0;
        return ans;
    }

    /**
     * 题目：二叉树中和为某一值的路径
     * 描述：
     *  输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
     *  路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
     *
     *  方法：
     *      举例？
     * */
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<ArrayList<Integer>> temp_res = new ArrayList<>();
        help_findpath(root, temp_res, temp);
        temp_res.sort(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o2.size() - o1.size();
            }
        });
        for(int i = 0; i < temp_res.size(); i++){
            printList(temp_res.get(i));
            int count = 0;
            for(int j = 0; j < temp_res.get(i).size(); j++){
                count += temp_res.get(i).get(j);
            }
            if(count == target){
                res.add(temp_res.get(i));
            }
        }

        return res;
    }

    public static void help_findpath(TreeNode node, ArrayList<ArrayList<Integer>> list, ArrayList<Integer> singleList){
        if(node == null){
            return;
        }
        singleList.add(node.val);

        //分叉
        ArrayList<Integer> temp = new ArrayList<>(singleList);
        if(node.left != null){
            help_findpath(node.left, list, temp);
        }
        temp = new ArrayList<>(singleList);
        if(node.right != null){
            help_findpath(node.right, list, temp);
        }
        //左右子树为空，说明为叶子节点
        if(node.right == null && node.left == null){
            list.add(singleList);
        }
    }

    public static class TreeNode{
        TreeNode left = null;
        TreeNode right = null;
        int val = 0;
        TreeNode(int val){
            this.val = val;
        }
    }

    public static void printList(ArrayList<Integer> list){
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    //测试样例
    public static void main(String[] args){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n5.left = n6;
        n3.right = n7;


        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(7);
        TreeNode t5 = new TreeNode(12);

        t1.left = t2;
        t1.right = t5;
        t2.left = t4;
        t2.right = t3;


        ArrayList<ArrayList<Integer>> res1 = FindPath(t1,22);
        System.out.println("Result:");
        for (int i = 0; i < res1.size(); i++){
            printList(res1.get(i));
        }
    }
}
