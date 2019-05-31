package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/5/30 9:47
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 *
 *
 *
 *
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 *
 *
 *
 *
 *
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 *
 *
 *
 * 示例:
 *
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 */
public class Solution87_柱状图中最大的矩形 {

    //复杂度O(N^2)
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }
        if(heights.length == 1){
            return heights[0];
        }

        int maxArea = 0;
        for(int i = 0; i < heights.length; i++){
            int minH = heights[i];
            maxArea = Math.max(heights[i], maxArea);
            for(int j = i+1; j < heights.length; j++){
                minH = Math.min(heights[j], minH);
                maxArea = Math.max(minH * (j - i + 1), maxArea);
            }
        }

        return maxArea;
    }

    //使用单点栈
}
