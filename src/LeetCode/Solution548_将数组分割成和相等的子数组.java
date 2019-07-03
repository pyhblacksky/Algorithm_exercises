package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: pyh
 * @Date: 2019/7/3 10:51
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个有 n 个整数的数组，你需要找到满足以下条件的三元组 (i, j, k) ：
 *
 * 0 < i, i + 1 < j, j + 1 < k < n - 1
 * 子数组 (0, i - 1)，(i + 1, j - 1)，(j + 1, k - 1)，(k + 1, n - 1) 的和应该相等。
 * 这里我们定义子数组 (L, R) 表示原数组从索引为L的元素开始至索引为R的元素。
 *
 *  
 *
 * 示例:
 *
 * 输入: [1,2,1,2,1,2,1]
 * 输出: True
 * 解释:
 * i = 1, j = 3, k = 5.
 * sum(0, i - 1) = sum(0, 0) = 1
 * sum(i + 1, j - 1) = sum(2, 2) = 1
 * sum(j + 1, k - 1) = sum(4, 4) = 1
 * sum(k + 1, n - 1) = sum(6, 6) = 1
 *  
 *
 * 注意:
 *
 * 1 <= n <= 2000。
 * 给定数组中的元素会在 [-1,000,000, 1,000,000] 范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-array-with-equal-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution548_将数组分割成和相等的子数组 {

    class Solution {
        public boolean splitArray(int[] nums) {
            if(nums == null || nums.length <= 4){
                return false;
            }

            int n = nums.length;

            for(int i = 1; i < n; i++){
                nums[i] += nums[i-1];
            }

            for(int i = 3; i < n-3; i++){
                Map<Integer, Boolean> map = new HashMap<>();
                for(int j = 1; j < i-1; j++){
                    if(nums[j-1] == nums[i-1] - nums[j]){
                        map.put(nums[j-1], true);
                    }
                }

                for(int j = i+1; j < n-1; j++){
                    int s3 = nums[j-1] - nums[i];
                    int s4 = nums[n-1] - nums[j];
                    if(s3 == s4 && map.get(s3) != null && map.get(s3)){
                        return true;
                    }
                }
            }
            return false;
        }
    }

}
