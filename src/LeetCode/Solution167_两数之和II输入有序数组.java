package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/8/29 10:48
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 *
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 *
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution167_两数之和II输入有序数组 {

    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            if(numbers == null || numbers.length < 1){
                return new int[]{-1,-1};
            }

            int p1 = 0;
            int p2 = numbers.length-1;
            while(p1 < p2){
                int sum = numbers[p1] + numbers[p2];
                if(sum == target){
                    return new int[]{p1+1, p2+1};//返回下表从1开始
                } else if(sum < target){
                    p1++;
                } else {
                    p2--;
                }
            }

            return new int[]{-1,-1};
        }
    }

}
