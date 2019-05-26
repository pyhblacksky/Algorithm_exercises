package LeetCodeRace.Contest138;

import java.util.Arrays;

/**
 * @Author: pyh
 * @Date: 2019/5/26 20:17
 * @Version: 1.0
 * @Function:
 * @Description:
 * 学校在拍年度纪念照时，一般要求学生按照 非递减 的高度顺序排列。
 *
 * 请你返回至少有多少个学生没有站在正确位置数量。该人数指的是：能让所有学生以 非递减 高度排列的必要移动人数。
 *
 *
 *
 * 示例：
 *
 * 输入：[1,1,4,2,1,3]
 * 输出：3
 * 解释：
 * 高度为 4、3 和最后一个 1 的学生，没有站在正确的位置。
 *
 *
 * 提示：
 *
 * 1 <= heights.length <= 100
 * 1 <= heights[i] <= 100
 */
public class 高度检察器 {

    public int heightChecker(int[] heights) {
        if(heights == null){
            return 0;
        }
        if(heights.length <= 1){
            return heights.length;
        }

        int cnt = 0;
        int[] temp = heights.clone();
        Arrays.sort(temp);
        for(int i = 1; i < heights.length; i++){
            if(temp[i] != heights[i]){
                cnt++;
            }
        }
        return cnt;
    }

}
