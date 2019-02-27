package 零碎的算法题;

/**
 * @Author: pyh
 * @Date: 2019/2/16 15:44
 * @Version 1.0
 * @Function:
 */
public class 双向链表排序 {


    //双向链表节点
    public static class Node{
        int val;
        Node next;
        Node pre;

        public Node(int val){
            this.val = val;
            next = null;
            pre = null;
        }
    }


    public static void main(String[] args){
        Node n1 = new Node(1);
        Node n2 = new Node(3);
        Node n3 = new Node(2);
        Node n4 = new Node(4);

        n1.next = n2;
        n2.pre = n1;
        n2.next = n3;
        n3.pre = n2;
        n3.next = n4;
        n4.pre = n3;

        int[] arr = {1,4,2,3};
        bubleSort(arr);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //冒泡排序
    public static void bubleSort(int[] arr){
        if(arr == null || arr.length == 0){
            return;
        }

        for(int i = 0; i < arr.length; i++){
            for(int j = i+1; j < arr.length; j++){
                if(arr[j] < arr[i]){
                    exch(arr, i, j);
                }
            }
        }
    }

    public static void exch(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
