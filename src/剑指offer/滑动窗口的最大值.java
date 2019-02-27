package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Author: pyh
 * @Date: 2019/2/20 14:16
 * @Version 1.0
 * @Function:
 *      给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 *      例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 *      那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 *      针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 *      {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 *      {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class 滑动窗口的最大值 {

    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if(num == null || num.length == 0 || size == 0){
            return res;
        }

        int p1 = 0;
        int p2 = p1 + size - 1;
        while(p2 < num.length){
            int max = Integer.MIN_VALUE;
            for(int i = p1; i <= p2; i++){
                max = Math.max(max, num[i]);
            }
            res.add(max);
            p1++;
            p2++;
        }
        return res;
    }

    //使用双端队列，复杂度O(n)
    public ArrayList<Integer> maxInWindows1(int [] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (num == null || num.length == 0 || size <= 0 || num.length < size) {
            return result;
        }

        //双端队列，用来记录每个窗口的最大值下标
        LinkedList<Integer> qmax = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            while (!qmax.isEmpty() && num[qmax.peekLast()] < num[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            //判断队首元素是否过期
            if (qmax.peekFirst() == i - size) {
                qmax.pollFirst();
            }
            //向result列表中加入元素
            if (i >= size - 1) {
                result.add(num[qmax.peekFirst()]);
            }
        }
        return result;
    }

}
