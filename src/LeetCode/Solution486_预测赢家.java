package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/5/22 9:26
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 给定一个表示分数的非负整数数组。 玩家1从数组任意一端拿取一个分数，随后玩家2继续从剩余数组任意一端拿取分数，然后玩家1拿，……。每次一个玩家只能拿取一个分数，分数被拿取之后不再可取。直到没有剩余分数可取时游戏结束。最终获得分数总和最多的玩家获胜。
 *
 * 给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。
 *
 * 示例 1:
 *
 * 输入: [1, 5, 2]
 * 输出: False
 * 解释: 一开始，玩家1可以从1和2中进行选择。
 * 如果他选择2（或者1），那么玩家2可以从1（或者2）和5中进行选择。如果玩家2选择了5，那么玩家1则只剩下1（或者2）可选。
 * 所以，玩家1的最终分数为 1 + 2 = 3，而玩家2为 5。
 * 因此，玩家1永远不会成为赢家，返回 False。
 * 示例 2:
 *
 * 输入: [1, 5, 233, 7]
 * 输出: True
 * 解释: 玩家1一开始选择1。然后玩家2必须从5和7中进行选择。无论玩家2选择了哪个，玩家1都可以选择233。
 * 最终，玩家1（234分）比玩家2（12分）获得更多的分数，所以返回 True，表示玩家1可以成为赢家。
 * 注意:
 *
 * 1 <= 给定的数组长度 <= 20.
 * 数组里所有分数都为非负数且不会大于10000000。
 * 如果最终两个玩家的分数相等，那么玩家1仍为赢家。
 */
public class Solution486_预测赢家 {

    //方法一： dp
    /**
     *  比如我们现在需要在区间nums[i, j]中取出最大分数和，
     *      那么我们有两种取法，一种是取nums[i]，一种是取nums[j]。
     *  第一种，取nums[i]，对手可取的最大分数和就是dp[i + 1][j]，
     *          此时当手可取和为nums[ i ] + sum[i + 1 到 j] - dp[i + 1][j]
     *          （nums[ i ] + sum[i + 1 到 j]可优化为sum[i 到 j ]）
     *  第二种，取nums[j]，对手可取的最大分数和就是dp[i][j - 1]，
     *          此时当手可取和为nums[ j ] + sum[i 到 j - 1 ] - dp[i][j - 1]
     *          （nums[ j ] + sum[i  到 j - 1 ]可优化为sum[i 到 j ]）
     *  所以动态转移方程为  dp[i][j] = dp[j][i] - min(dp[i][j - 1], dp[i + 1][j]);
     *      （ dp[j][i]代表的是sum [i][j]）
     * */
    public static boolean PredictTheWinner(int[] nums) {
        //如果个数为偶数，则1直接胜利
        if(nums == null || nums.length <= 2){
            return true;
        }

        int n = nums.length;
        if(n % 2 == 0){
            //为偶数
            return true;
        }

        int[][] dp = new int[n][n];
        //dp[i][j]表示当J >= i时， i 到 j的和
        //第一步，计算j >= i时，nums[i, j]的和
        for(int i = 0; i < n; i++){
            int temp = 0;
            for(int j = i; j < n; j++){
                temp += nums[j];
                dp[j][i] = temp;
            }
        }

        //第二步，动态规划
        for(int i = n - 2; i >= 0; i--){
            for(int j = i+1; j < n; j++){
                //上面的两层循环是穷举区间[i, j]
                //因为当前要从[i, j]取出最大分数和，而区间[i, j]的总和是个定值dp[j][i]
                //对手取的可取的分数和有两种情况
                //第一种，对手取dp[i][j - 1]，此时当手取nums[j]
                //第二种，对手取dp[i + 1][j]，此时当手取nums[i],
                //而我们要是当手取得局部最大值
                dp[i][j] = dp[j][i] - Math.min(dp[i][j-1], dp[i+1][j]);
            }
        }

        //如果从[0, n - 1]取出的最大分数和超过了总和的一半，则说明当手可赢
        return dp[0][n - 1] * 2 >= dp[n - 1][0];
    }

    //方法二：博弈树
    public boolean PredictTheWinner1(int[] nums) {

        return false;
    }

    public static void main(String[] args){
        int[] arr = {1,5,2};
        PredictTheWinner(arr);
    }

}
