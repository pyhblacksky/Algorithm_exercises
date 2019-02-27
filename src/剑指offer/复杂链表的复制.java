package 剑指offer;

/**
 * @Author: pyh
 * @Date: 2019/2/18 10:50
 * @Version 1.0
 * @Function:
 *      输入一个复杂链表
 *      （每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 *      返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class 复杂链表的复制 {

    public RandomListNode Clone(RandomListNode pHead) {

        //在每一个节点处插入一个新节点
        RandomListNode saveHead = pHead;
        while(pHead != null){
            RandomListNode node = pHead.next;
            pHead.next = new RandomListNode(pHead.label);
            pHead.next.next = node;
            pHead = pHead.next.next;
        }

        //复制随机指向的节点
        pHead = saveHead;
        while(pHead != null){
            if(pHead.random != null){
                pHead.next.random = pHead.random.next;
            }
            pHead = pHead.next.next;
        }

        //断开关系
        pHead = saveHead;
        RandomListNode newHead = new RandomListNode(0);
        RandomListNode temp = newHead;
        while(pHead != null){
            newHead.next = pHead.next;
            pHead.next = pHead.next.next;

            newHead = newHead.next;
            newHead.next = null;
            pHead = pHead.next;
        }

        return temp.next;
    }

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public static void main(String[] args){

    }
}
