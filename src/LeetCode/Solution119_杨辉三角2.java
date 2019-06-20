package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: pyh
 * @Date: 2019/6/20 8:05
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 *
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution119_杨辉三角2 {

    //O(N^2)的常规解法
    static class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> pre = new ArrayList<>();
            if(rowIndex == 0){
                return pre;
            }

            pre.add(1);
            for(int i = 1; i < rowIndex; i++){
                List<Integer> list = new ArrayList<>();
                list.add(1);
                for(int j = 1; j < i; j++){
                    list.add(pre.get(j) + pre.get(j-1));
                }
                list.add(1);
                pre = new ArrayList<>(list);
            }

            return pre;
        }
    }

    //O(N)的解法,杨辉三角通项公式
    static class Solution1{
        public List<Integer> getRow(int rowIndex){
            List<Integer> list = new ArrayList<>(rowIndex+1);
            long nk = 1;
            for(int i = 0; i <= rowIndex; i++){
                list.add((int)nk);
                nk = nk * (rowIndex - i) / (i+1);
            }
            return list;
        }
    }

    public static void main(String[] args){
        Solution1 solution1 = new Solution1();
        solution1.getRow(3);
    }

}
