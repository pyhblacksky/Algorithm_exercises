package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/5/21 17:00
 * @Version: 1.0
 * @Function:
 * @Description:
 * 8 间牢房排成一排，每间牢房不是有人住就是空着。
 *
 * 每天，无论牢房是被占用或空置，都会根据以下规则进行更改：
 *
 * 如果一间牢房的两个相邻的房间都被占用或都是空的，那么该牢房就会被占用。
 * 否则，它就会被空置。
 * （请注意，由于监狱中的牢房排成一行，所以行中的第一个和最后一个房间无法有两个相邻的房间。）
 *
 * 我们用以下方式描述监狱的当前状态：如果第 i 间牢房被占用，则 cell[i]==1，否则 cell[i]==0。
 *
 * 根据监狱的初始状态，在 N 天后返回监狱的状况（和上述 N 种变化）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：cells = [0,1,0,1,1,0,0,1], N = 7
 * 输出：[0,0,1,1,0,0,0,0]
 * 解释：
 * 下表概述了监狱每天的状况：
 * Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
 * Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
 * Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
 * Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
 * Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
 * Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
 * Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
 * Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
 *
 * 示例 2：
 *
 * 输入：cells = [1,0,0,1,0,0,1,0], N = 1000000000
 * 输出：[0,0,1,1,1,1,1,0]
 *
 *
 * 提示：
 *
 * cells.length == 8
 * cells[i] 的值为 0 或 1
 * 1 <= N <= 10^9
 */
public class Solution957_N天后的牢房 {

    //模拟的方法，超时 找规律
    public static int[] prisonAfterNDays(int[] cells, int N) {
        if(cells == null || cells.length == 0 || N <= 0){
            return cells;
        }

        N = N % 14;
        if(N == 0){
            N = 14; //此时取模为0，说明是进行了14天后
        }
        //int Day = N;
        while(N > 0){
            N--;
            int[] temp = new int[cells.length];
            //第一间和最后一间必被空置
            for(int i = 1; i < 7; i++){
                if(cells[i-1] == cells[i+1]){
                    temp[i] = 1;
                } else{
                    temp[i] = 0;
                }
            }

            //复制当前
            for(int i = 0; i < cells.length; i++){
                cells[i] = temp[i];
            }

            //System.out.println(ArrToDec(cells) + " 天数 ：" + (Day-N));
        }

        return cells;
    }

    public static void main(String[] args){
        int[] cells = {1, 1, 1, 1, 0, 0, 0, 1};
        int N = 826;
        prisonAfterNDays(cells, N);
    }

    static int ArrToDec(int[] arr){
        int res = 0;
        int n = 1;
        for(int i = arr.length-1; i > 0; i--){
            res += arr[i] * n;
            n = n << 1;
        }
        return res;
    }

}
