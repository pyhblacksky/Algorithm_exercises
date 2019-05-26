package LeetCodeRace.Contest137;

import java.util.stream.IntStream;

/**
 * @Author: pyh
 * @Date: 2019/5/19 11:32
 * @Version: 1.0
 * @Function:
 * @Description:
 */
public class 最后一块石头的重量2 {

    public static int lastStoneWeightII(int[] stones) {
        int sum = IntStream.of(stones).sum();
        boolean[] f = new boolean[sum + 1];
        f[0] = true;
        int ans = sum;
        for (int stone : stones) {
            for (int j = sum; j - stone >= 0; j--) {
                f[j] = f[j] || f[j - stone];
                if (f[j]) {
                    ans = Math.min(ans, Math.abs(j - (sum - j)));
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1}));
        System.out.println(lastStoneWeightII(new int[]{9, 9}));
        System.out.println(lastStoneWeightII(new int[]{9, 9, 9}));
        System.out.println(lastStoneWeightII(new int[]{1, 2, 3, 4}));
    }

}
