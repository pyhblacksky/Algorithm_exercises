package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/7/4 20:41
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
 *
 * 一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。
 *
 * 返回一对观光景点能取得的最高分。
 *
 *  
 *
 * 示例：
 *
 * 输入：[8,1,5,2,6]
 * 输出：11
 * 解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
 *  
 *
 * 提示：
 *
 * 2 <= A.length <= 50000
 * 1 <= A[i] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-sightseeing-pair
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1014_最佳观光组合 {

    //暴力解法，超时
    class Solution {
        public int maxScoreSightseeingPair(int[] A) {
            if(A == null || A.length < 2)
                return 0;

            int max = Integer.MIN_VALUE;
            for(int i = 0; i < A.length; i++){
                for(int j = i + 1; j < A.length; j++){
                    max = Math.max(max, A[i]+A[j] + i - j);
                }
            }

            return max;
        }
    }

    class Solution1 {
        public int maxScoreSightseeingPair(int[] A) {
            if(A == null || A.length < 2)
                return 0;

            //分为两部分， 求A[i]+i的最大值
            //求A[j] + j 的最大值
            int res = 0;
            int pre = A[0] + 0;
            for(int i = 1; i < A.length; i++){
                res = Math.max(res, pre + A[i] - i);
                pre = Math.max(pre, A[i] + i);
            }

            return res;
        }
    }

}
