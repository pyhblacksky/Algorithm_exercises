package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: pyh
 * @Date: 2019/6/20 7:53
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution118_杨辉三角 {
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> res = new ArrayList<>();
            if(numRows == 0){
                return res;
            }

            res.add(new ArrayList<>());
            res.get(0).add(1);
            for(int i = 1; i < numRows; i++){
                List<Integer> list = new ArrayList<>();
                List<Integer> pre = res.get(i-1);
                list.add(1);
                for(int j = 1; j < i; j++){
                    list.add(pre.get(j-1) + pre.get(j));
                }
                list.add(1);
                res.add(list);
            }

            return res;
        }

    }
}
