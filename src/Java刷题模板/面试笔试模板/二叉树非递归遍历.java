package Java刷题模板.面试笔试模板;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: pyh
 * @Date: 2019/4/23 14:32
 * @Version: 1.0
 * @Function:
 * @Description:
 *  这里给出非递归的前序、中序及后序遍历
 */
public class 二叉树非递归遍历 {

    static PrintStream out = System.out;//打印

    //基础节点
    static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val = val;
        }
    }

    //构建树,根据数组序列, i 是该树的根
    static Node buildTree(int[] arr, int i){
        if(i >= arr.length || arr[i] == -1){
            return null;
        }

        Node root = new Node(arr[i]);
        root.left = buildTree(arr, i*2 + 1);
        root.right = buildTree(arr, i*2 + 2);
        return root;
    }

    //构建树，根据输入
    static Node buildTree(Scanner in){
        Node root = null;
        int val = in.nextInt();
        if(val != -1){//-1为结束字符
            root = new Node(val);
            root.left = buildTree(in);
            root.right = buildTree(in);
        }
        return root;
    }

    //非递归版，前序遍历
    static void preOrder(Node root){
        if(root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node p = root;
        while(p != null || !stack.isEmpty()){
            while(p != null){
                out.print(p.val + " ");
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            p = p.right;
        }
        out.println();
    }

    //中序遍历
    static void inOrder(Node root){
        if(root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node p = root;
        while(p != null || !stack.isEmpty()){
            while(p != null){
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            out.print(p.val + " ");
            p = p.right;
        }
        out.println();
    }

    //后序遍历，方法1:双栈，实现 中 - > 右 -> 左， 然后使用一个栈逆转
    static void postOrder(Node root){
        if(root == null){
            return;
        }
        Node p = root;
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(root);
        while(!s1.isEmpty()){
            Node cur = s1.pop();
            s2.push(cur);
            if(cur.left != null)    s1.push(cur.left);
            if(cur.right != null)   s1.push(cur.right);
        }
        while(!s2.isEmpty()){
            out.print(s2.pop().val + " ");
        }
        out.println();
    }

    //后序遍历第二种，前插法
    static void postOrder2(Node root){
        if(root == null){
            return;
        }
        Stack<Node> s = new Stack<>();
        s.push(root);
        Node pre = null;
        while(!s.isEmpty()){
            Node cur = s.peek();
            if((cur.left == null && cur.right == null)
                    || (pre != null && (pre == cur.left || pre == cur.right))){
                out.print(cur.val + " ");
                s.pop();
                pre = cur;
            } else{
                if(cur.right != null)   s.push(cur.right);
                if(cur.left != null)    s.push(cur.left);
            }
        }
        out.println();
    }

    //测试方法
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, -1, 9, -1, 10, -1, 11, -1};
        Node root = buildTree(arr, 0);
//           1
//          / \
//        2     3
//        /\    /\
//       4  5  6  7
//      /  /  /   /
//     8  9  10  11

        preOrder(root);
        inOrder(root);
        postOrder(root);
        postOrder2(root);
    }
}
