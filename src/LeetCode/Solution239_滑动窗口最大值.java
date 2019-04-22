package LeetCode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: pyh
 * @Date: 2019/4/22 15:49
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 注意：
 *
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 输入数组的大小，且输入数组不为空。
 *
 * 进阶：
 *
 * 你能在线性时间复杂度内解决此题吗？
 */
public class Solution239_滑动窗口最大值 {
    //普通解法
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return nums;
        }

        if(nums.length <= k){
            int res = getMax(nums, 0, nums.length-1);
            return new int[]{res};
        }

        ArrayList<Integer> list = new ArrayList<>();
        int start = 0;
        int end = k-1;
        for(int i = 0; i < nums.length; i++){
            if(end == nums.length){
                break;
            }
            int temp = getMax(nums, start, end);
            list.add(temp);
            start++;
            end++;
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = list.get(i);
        }
        return res;
    }

    //返回一定区间的最大值
    public int getMax(int[] nums, int start, int end){
        int max = Integer.MIN_VALUE;
        for(int i = start; i <= end; i++){
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    //使用双端队列,大元素保留，小元素弹出
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 0 || nums.length < k){
            return nums;
        }

        int[] res = new int[nums.length - k + 1];

        //双端队列, 保存的是下标
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0; i < nums.length; i++){
            //尾部添加元素，保证左边元素比尾部大
            while(!deque.isEmpty() && nums[deque.getLast()] < nums[i]){
                deque.removeLast();
            }

            deque.addLast(i);

            //在头部移除元素,超限了
            if(deque.getFirst() == i-k){
                deque.removeFirst();
            }

            //输出结果
            if(i >= k-1){
                res[i-k+1] = nums[deque.getFirst()];
            }
        }
        return res;
    }

    public  static void main(String[] args){
        Solution239_滑动窗口最大值 solution = new Solution239_滑动窗口最大值();
        int[] arr = new int[]{1,3,-1,-3,5,3,6,7};
        solution.maxSlidingWindow1(arr, 3);
    }

}
