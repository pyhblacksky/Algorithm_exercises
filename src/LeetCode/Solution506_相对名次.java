package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: pyh
 * @Date: 2019/6/30 21:30
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal", "Silver Medal", "Bronze Medal"）。
 *
 * (注：分数越高的选手，排名越靠前。)
 *
 * 示例 1:
 *
 * 输入: [5, 4, 3, 2, 1]
 * 输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * 解释: 前三名运动员的成绩为前三高的，因此将会分别被授予 “金牌”，“银牌”和“铜牌” ("Gold Medal", "Silver Medal" and "Bronze Medal").
 * 余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。
 * 提示:
 *
 * N 是一个正整数并且不会超过 10000。
 * 所有运动员的成绩都不相同。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-ranks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution506_相对名次 {

    //暴力解法，一一对应关系
    static class Solution {
        public String[] findRelativeRanks(int[] nums) {
            if(nums == null || nums.length == 0)
                return new String[0];

            String[] str = new String[nums.length];
            int[] temp = nums.clone();
            Arrays.sort(temp);
            for(int i = 0; i < nums.length; i++){
                for(int j = temp.length - 1; j >= 0; j--){
                    if(nums[i] == temp[j]){
                        if(j == temp.length - 1){
                            str[i] = "Gold Medal";
                        } else if(j == temp.length - 2){
                            str[i] = "Silver Medal";
                        } else if(j == temp.length - 3){
                            str[i] = "Bronze Medal";
                        } else{
                            str[i] = String.valueOf(Math.abs(j-temp.length));
                        }
                        break;
                    }
                }
            }

            return str;
        }
    }

    //使用map,空间换时间,??????但是时间反而更长了......
    class Solution1 {
        public String[] findRelativeRanks(int[] nums) {
            if(nums == null || nums.length == 0)
                return new String[0];

            Map<Integer, Integer> map = new HashMap<>();
            Integer[] help = new Integer[nums.length];
            for(int i = 0; i < nums.length; i++){
                help[i] = nums[i];
            }
            Arrays.sort(help,(o1, o2)->o2-o1);

            for(int i = 0; i < help.length; i++){
                map.put(help[i], i+1);
            }

            String[] res = new String[nums.length];
            for(int i = 0; i < nums.length; i++){
                int val = map.get(nums[i]);
                if(val == 1){
                    res[i] = "Gold Medal";
                } else if(val == 2){
                    res[i] = "Silver Medal";
                } else if(val == 3){
                    res[i] = "Bronze Medal";
                } else{
                    res[i] = String.valueOf(val);
                }
            }

            return res;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        solution.findRelativeRanks(new int[]{1,7,5,4,2});
    }

}
