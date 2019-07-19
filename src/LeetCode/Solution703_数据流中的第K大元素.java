package LeetCode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: pyh
 * @Date: 2019/7/18 22:48
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 *
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 *
 * 示例:
 *
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 * 说明:
 * 你可以假设 nums 的长度≥ k-1 且k ≥ 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-a-stream
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution703_数据流中的第K大元素 {

    class KthLargest {
        final PriorityQueue<Integer> minHeap;

        final int k;

        public KthLargest(int k, int[] nums) {

            this.k = k;
            this.minHeap = new PriorityQueue(k);

            for (int i = 0; i < nums.length; i++) {
                add(nums[i]);
            }

        }

        public int add(int val) {

            if (minHeap.size() < k) {
                minHeap.offer(val);
            } else if (minHeap.peek() < val){
                minHeap.poll();
                minHeap.offer(val);
            }

            return minHeap.peek();

        }
    }

    class KthLargest1 {
        final Queue<Integer> queue;
        final int k;
        public KthLargest1(int k, int[] nums) {
            this.k = k;
            this.queue = new PriorityQueue(k);

            for(int num : nums){
                add(num);
            }
        }

        public int add(int val) {
            if(queue.size() < k){
                queue.offer(val);
            } else if(queue.peek() < val){
                queue.poll();
                queue.offer(val);
            }

            return queue.peek();
        }
    }

}
