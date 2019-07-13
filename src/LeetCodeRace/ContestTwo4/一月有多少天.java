package LeetCodeRace.ContestTwo4;

/**
 * @Author: pyh
 * @Date: 2019/7/13 22:30
 * @Description:
 * 指定年份 Y 和月份 M，请你帮忙计算出该月一共有多少天。
 *
 *
 *
 * 示例 1：
 *
 * 输入：Y = 1992, M = 7
 * 输出：31
 * 示例 2：
 *
 * 输入：Y = 2000, M = 2
 * 输出：29
 * 示例 3：
 *
 * 输入：Y = 1900, M = 2
 * 输出：28
 *
 *
 * 提示：
 *
 * 1583 <= Y <= 2100
 * 1 <= M <= 12
 */

public class 一月有多少天 {

    class Solution {
        public int numberOfDays(int Y, int M) {
            if(M == 1 || M == 3 || M == 5 || M == 7 || M == 8 || M == 10 || M == 12){
                return 31;
            } else if(M == 2){
                if(Y % 400 == 0){
                    return 29;
                }
                if(Y % 4 == 0 && Y % 100 != 0){
                    return 29;
                }
                return 28;
            } else{
                return 30;
            }
        }
    }

}
