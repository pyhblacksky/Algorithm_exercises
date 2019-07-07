package LeetCodeRace.Contest144;

/**
 * @Author: pyh
 * @Date: 2019/7/7 10:32
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 这里有 n 个航班，它们分别从 1 到 n 进行编号。
 *
 * 我们这儿有一份航班预订表，表中第 i 条预订记录 bookings[i] = [i, j, k] 意味着我们在从 i 到 j 的每个航班上预订了 k 个座位。
 *
 * 请你返回一个长度为 n 的数组 answer，按航班编号顺序返回每个航班上预订的座位数。
 *
 *
 *
 * 示例：
 *
 * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * 输出：[10,55,45,25,25]
 *
 *
 * 提示：
 *
 * 1 <= bookings.length <= 20000
 * 1 <= bookings[i][0] <= bookings[i][1] <= n <= 20000
 * 1 <= bookings[i][2] <= 10000
 */
public class 航班预订统计 {

    //暴力  超时
    class Solution {
        public int[] corpFlightBookings(int[][] bookings, int n) {

            int[] dp = new int[n];
            for(int i = 0; i < bookings.length; i++){
                for(int j = 0; j < n; j++){
                    int index = j+1;
                    if(index >= bookings[i][0] && index <= bookings[i][1]){
                        dp[index-1] += bookings[i][2];
                    } else if(index < bookings[i][0]){
                        continue;
                    } else if(index > bookings[i][1]){
                        break;
                    }
                }
            }

            return dp;
        }
    }

    //超时
    class Solution1 {
        public int[] corpFlightBookings(int[][] bookings, int n) {
            int[] arr = new int[n];
            for(int[] book : bookings){
                int start = book[0];
                int end = book[1];
                while(start < end){
                    arr[start-1] += book[2];
                    arr[end-1] += book[2];
                    start++;
                    end--;
                }
                if(start == end) {
                    arr[start - 1] +=book[2];
                }
            }

            return arr;
        }
    }

    static class Solution2{
        public int[] corpFlightBookings(int[][] bookings, int n){
            int[] res = new int[n];

            for(int[] arr : bookings){
                int start = arr[0];
                int end = arr[1];
                int k = arr[2];

                res[start-1] += k;
                if(end != n){
                    res[end] -= k;
                }
            }

            for(int i=1;i<n;++i){
                res[i] += res[i-1];
            }
            return res;
        }
    }

    public static void main(String[] args){
        Solution2 solution2 = new Solution2();
        int[][] bookings = {{1,2,10},{2,3,20},{2,5,25}};
        solution2.corpFlightBookings(bookings, 5);
    }

}
