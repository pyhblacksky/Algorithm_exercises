package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: pyh
 * @Date: 2019/4/23 17:11
 * @Version: 1.0
 * @Function:
 * @Description:
 *  (最长上升子序列问题、最长递增子序列问题)
 *
 *  给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。
 *  当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 说明:
 * 不允许旋转信封。
 *
 * 示例:
 *
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 */
public class Solution354_俄罗斯套娃信封问题 {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0 || envelopes[0].length == 0){
            return 0;
        }

        //排序，定义一个比较器
        /**
         *
         * 排序后等于把在二维(长、宽)
         * 上的最长递增子序列问题转换成一维(宽)上的最长递增子序列的查找, 因为对于
         * 长度来说已经满足递增, 只需要在宽度上也递增即为递增序列。
         * 同长时按宽度降序排列的原因是
         * 避免同长时宽度小的也被列入递增序列中, 例如[3,3], [3,4]
         * 如果宽度也按升序来排列, [3,3]和[3,4]会形成递增序列, 而实际上不行
         */
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //先按照长度升序，再按照宽度降序
                if(o1[0] == o2[0]){
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            }
        });
        printArr(envelopes);

        int[] ends = new int[envelopes.length + 1];
        int right = 1;
        int l, m, r;
        ends[1] = envelopes[0][1];
        for(int i = 1; i < envelopes.length; i++){
            l = 1;
            r = right;
            while(l <= r){
                m = l + (r - l) / 2;
                if(ends[m] >= envelopes[i][1]){
                    r = m - 1;
                } else{
                    l = m + 1;
                }
            }

            if(l > right){
                ends[right+1] = envelopes[i][1];
                right += 1;
            } else{
                ends[l] = envelopes[i][1];
            }
        }

        return right;
    }

    public static void main(String[] args){
        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        int[][] arr = {{4,5},{4,6},{6,7},{2,3},{1,1}};
        int[][] arr1 = {{1,2},{2,3},{3,4},{3,5},{4,5},{5,5},{5,6},{6,7},{7,8}};
        int[][] arr2 = {{2,100},{3,200},{4,300},{5,500},{5,400},{5,250},{6,370},{6,360},{7,380}};
        int[][] arr3 = {{1,1}, {1,1}, {1,1}};
        Solution354_俄罗斯套娃信封问题 solution = new Solution354_俄罗斯套娃信封问题();
        //int res = solution.maxEnvelopes(envelopes);
        int res = solution.maxEnvelopes(arr);
        System.out.println(res);
    }

    public static void printArr(int[][] arr){
        for(int[] temp : arr){
            for(int x : temp){
                System.out.print(x + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
