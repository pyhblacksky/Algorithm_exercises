package LeetCode.水题;

/**
 * @Author: pyh
 * @Date: 2019/2/28 14:12
 * @Version 1.0
 * @Function:   374、猜数字大小
 *
 * 我们正在玩一个猜数字游戏。 游戏规则如下：
 * 我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
 * 每次你猜错了，我会告诉你这个数字是大了还是小了。
 * 你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：
 *
 * -1 : 我的数字比较小
 *  1 : 我的数字比较大
 *  0 : 恭喜！你猜对了！
 * 示例 :
 *
 * 输入: n = 10, pick = 6
 * 输出: 6
 *
 */
public class Solution374_猜数字大小 {

    /* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

    public int guessNumber(int n) {
        int start = 0;
        int end = n;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(guess(mid) == 0){
                return mid;
            } else if(guess(mid) == -1){
                end = mid - 1;
            } else{
                start = mid + 1;
            }
        }
        return -1;
    }

    private int guess(int num){
        //假设所猜数字为6
        if(num > 6){
            return -1;
        } else if(num == 6){
            return 0;
        } else{
            return 1;
        }
    }


}
