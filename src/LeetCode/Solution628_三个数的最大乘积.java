package LeetCode;

import java.util.Arrays;

/**
 * @Author: pyh
 * @Date: 2019/7/2 9:34
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: 6
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: 24
 * 注意:
 *
 * 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
 * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-of-three-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution628_三个数的最大乘积 {

    //排序，然后分情况...
    class Solution {
        public int maximumProduct(int[] nums) {
            if(nums == null || nums.length < 3)
                return 0;

            int n = nums.length;
            //两负一正，全正
            Arrays.sort(nums);
            int res1 = nums[n-1] * nums[n-2] * nums[n-3];
            int res2 = nums[0] * nums[1] * nums[n-1];

            return Math.max(res1, res2);
        }
    }
}
