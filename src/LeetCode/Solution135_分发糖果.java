package LeetCode;

import java.util.Arrays;

/**
 * @Author: pyh
 * @Date: 2019/7/2 9:50
 * @Version: 1.0
 * @Function:
 * @Description:
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 *
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 *
 * 示例 1:
 *
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * 示例 2:
 *
 * 输入: [1,2,2]
 * 输出: 4
 * 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
 *      第三个孩子只得到 1 颗糖果，这已满足上述两个条件
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/candy
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution135_分发糖果 {

    //暴力走起...  O(N^2)
    class Solution {
        public int candy(int[] ratings) {
            if(ratings == null || ratings.length == 0)
                return 0;

            //每人至少一个
            int[] candies = new int[ratings.length];
            Arrays.fill(candies, 1);

            int res = 0;
            boolean flag = true;
            //直到没有符合条件的产生为止，复杂度较高
            while(flag){
                flag = false;
                for(int i = 0; i < ratings.length; i++){
                    if(i+1 < ratings.length && ratings[i] > ratings[i+1] && candies[i] <= candies[i+1]){
                        candies[i] = candies[i+1] + 1;
                        flag = true;
                    }
                    if(i-1 >= 0 && ratings[i] > ratings[i-1] && candies[i] <= candies[i-1]){
                        candies[i] = candies[i-1] + 1;
                        flag = true;
                    }
                }
            }

            for(int i = 0; i < candies.length; i++){
                res += candies[i];
            }

            return res;
        }
    }

    //方法二，使用左右两个数组存储    O(N)
    class Solution1 {
        public int candy(int[] ratings) {
            if(ratings == null || ratings.length == 0)
                return 0;

            int[] left = new int[ratings.length];//从左到右数组
            int[] right = new int[ratings.length];//从右到左数组

            Arrays.fill(left, 1);
            Arrays.fill(right, 1);

            for(int i = 1; i < ratings.length; i++){
                if(ratings[i] > ratings[i-1]){
                    left[i] = left[i-1]+1;
                }
            }

            for(int i = ratings.length-2; i >= 0; i--){
                if(ratings[i] > ratings[i+1]){
                    right[i] = right[i+1]+1;
                }
            }

            int res = 0;
            for(int i = 0; i < ratings.length; i++){
                res += Math.max(left[i], right[i]);
            }

            return res;
        }
    }

    //方法三，只使用一个数组存储
    class Solution2 {
        public int candy(int[] ratings) {
            if(ratings == null || ratings.length == 0)
                return 0;

            int[] candies = new int[ratings.length];
            Arrays.fill(candies, 1);
            for(int i = 1; i < ratings.length; i++){
                if(ratings[i] > ratings[i-1])
                    candies[i] = candies[i-1]+1;
            }

            int res = candies[ratings.length-1];
            for(int i = ratings.length-2; i >= 0; i--){
                if(ratings[i] > ratings[i+1]){
                    candies[i] = Math.max(candies[i], candies[i+1] + 1);
                }
                res += candies[i];
            }

            return res;
        }
    }

    //方法四， 常数空间,利用数组的特性，分为峰顶和峰谷,区分的部分使用等差数列求和公式可以计算得出
    class Solution3{
        public int candy(int[] ratings){
            if(ratings == null)
                return 0;
            if(ratings.length <= 1)
                return ratings.length;

            int res = 0;
            int up = 0;
            int down = 0;
            int old_slope = 0;
            for(int i = 1; i < ratings.length; i++){
                int new_slope = (ratings[i] > ratings[i-1]) ? 1 : (ratings[i] < ratings[i-1] ? -1 : 0);
                if((old_slope > 0 && new_slope == 0) || (old_slope < 0 && new_slope >= 0)){
                    res += count(up) + count(down) + Math.max(up, down);
                    up = 0;
                    down = 0;
                }

                if(new_slope > 0)
                    up++;

                if(new_slope < 0)
                    down++;

                if(new_slope == 0)
                    res++;//加一

                old_slope = new_slope;//表示变化的趋势
            }

            res += count(up) + count(down) + Math.max(up, down) + 1;
            return res;
        }

        private int count(int n){
            return (n*(n+1))/2;
        }
    }

}
