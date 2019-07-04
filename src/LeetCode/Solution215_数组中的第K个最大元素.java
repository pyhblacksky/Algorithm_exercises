package LeetCode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: pyh
 * @Date: 2019/7/4 14:52
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution215_数组中的第K个最大元素 {

    //堆
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            if(nums == null || nums.length == 0)
                return 0;

            Queue<Integer> queue = new PriorityQueue<>((o1,o2)->o2-o1);
            //利用堆
            for(int i = 0; i < nums.length; i++){
                queue.add(nums[i]);
            }

            int res = 0;
            if(!queue.isEmpty())
                res = queue.peek();
            while(k > 0 && !queue.isEmpty()){
                k--;
                res = queue.poll();
            }
            return res;
        }
    }

    //利用排序
    class Solution1{
        public int findKthLargest(int[] nums, int k) {
            if(nums == null || nums.length == 0)
                return 0;

            Arrays.sort(nums);

            if(k > nums.length || k < 0)
                return nums[nums.length-1];

            return nums[nums.length-k];
        }
    }

}
