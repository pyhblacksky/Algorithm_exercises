package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/6/30 20:56
 * @Version: 1.0
 * @Function:
 * @Description:
 * 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
 *
 * 给定一个数字 n，找出可形成完整阶梯行的总行数。
 *
 * n 是一个非负整数，并且在32位有符号整型的范围内。
 *
 * 示例 1:
 *
 * n = 5
 *
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤
 *
 * 因为第三行不完整，所以返回2.
 * 示例 2:
 *
 * n = 8
 *
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 *
 * 因为第四行不完整，所以返回3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/arranging-coins
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution441_排列硬币 {

    //暴力...
    class Solution {
        public int arrangeCoins(int n) {
            if(n < 1){
                return 0;
            }

            int count = 0;
            int ceil = 1;
            while(n-ceil >= 0){
                n -= ceil;
                ceil++;
                count++;
            }

            return count;
        }
    }

    //二分查找..
    class Solution1 {
        public int arrangeCoins(int n) {
            int l = 0, r = n;
            while (l < r) {
                int mid = l + r + 1 >>> 1;
                if ((long)mid * (mid + 1) / 2 <= n)
                    l = mid;
                else
                    r = mid - 1;
            }
            return r;
        }
    }

}
