package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/7/17 17:03
 * @Version: 1.0
 * @Function:
 * @Description:
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 *
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 *
 * 你允许：
 *
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 * 示例 1: (From the famous "Die Hard" example)
 *
 * 输入: x = 3, y = 5, z = 4
 * 输出: True
 * 示例 2:
 *
 * 输入: x = 2, y = 6, z = 5
 * 输出: False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/water-and-jug-problem
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution365_水壶问题 {

    //最大公约数问题
    class Solution {
        public boolean canMeasureWater(int x, int y, int z) {
            if(z == 0)
                return true;
            //最后请用以上水壶中的一或两个来盛放取得的 z升 水。
            if(z > x+y)
                return false;

            int gcd = 1;
            if(x > y){
                gcd = getGcd(x, y);
            } else{
                gcd = getGcd(y, x);
            }

            if(gcd == 0)
                return false;

            return z % gcd == 0;
        }

        int getGcd(int a, int b){
            while(b != 0){
                int tmp = a % b;
                a = b;
                b = tmp;
            }
            return a;
        }
    }

}
