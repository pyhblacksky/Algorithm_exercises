package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: pyh
 * @Date: 2019/7/4 13:45
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution56_合并区间 {
    class Solution {
        public int[][] merge(int[][] intervals) {
            if(intervals == null || intervals.length == 0 || intervals[0] == null || intervals[0].length == 0)
                return intervals;

            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            ArrayList<int[]> list = new ArrayList<>();
            for(int i = 0; i < intervals.length; i++){
                int[] temp = new int[2];
                temp[0] = intervals[i][0];
                int right = intervals[i][1];
                for(int j = i+1; j < intervals.length; j++){
                    if(right < intervals[j][0])
                        break;
                    else{
                        right = Math.max(intervals[j][1],right);//右边界最大值
                        i++;
                    }
                }
                temp[1] = right;
                list.add(temp);
            }

            int[][] res = new int[list.size()][2];
            for(int i = 0; i < res.length; i++){
                res[i][0] = list.get(i)[0];
                res[i][1] = list.get(i)[1];
            }

            return res;
        }
    }
}
