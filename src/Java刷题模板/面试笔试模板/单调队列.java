package Java刷题模板.面试笔试模板;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Author: pyh
 * @Date: 2019/4/28 15:25
 * @Version: 1.0
 * @Function:
 * @Description:
 *  用来求出在数组的某个区间范围内求出最大值。
 *
 *  经典的滑动窗口问题
 *
 *  lintCode 362
 *  https://www.lintcode.com/problem/sliding-window-maximum/descripti
 */
public class 单调队列 {

    /**
     * 单调队列：用来求出在数组的某个区间范围内求出最大值
     * 经典问题：滑动窗口
     * */
    public static ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        if(nums == null || k < 1 || nums.length < k){
            return null;
        }
        ArrayList<Integer> res = new ArrayList<>();
        LinkedList<Integer> qmax = new LinkedList<>();//保存的是下标
        for(int i = 0; i < nums.length; i++){
            while(!qmax.isEmpty() && nums[qmax.peekLast()] <= nums[i]){
                //队尾满足条件,只保留一个最大的元素
                qmax.pollLast();
            }
            qmax.addLast(i);
            if(i - k == qmax.peekFirst()){
                qmax.pollFirst();//向左弹出，过期的数据s
            }
            if(i >= k - 1){
                res.add(nums[qmax.peekFirst()]);
            }
        }

        return res;
    }

    //测试方法
    public static void main(String[] args){
        int[] arr = {1, 2, 7, 7, 8};
        System.out.println(maxSlidingWindow(arr, 3)); // 7, 7, 8
    }
}
