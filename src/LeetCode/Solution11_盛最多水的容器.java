package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/5/28 8:22
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，
 * 使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 *
 *
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，
 * 容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 *
 *
 * 示例:
 *
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 *
 */
public class Solution11_盛最多水的容器 {

    //正解,复杂的O(N^2)，暴力
    public int maxArea(int[] height) {
        if(height == null || height.length <= 1){
            return 0;
        }

        int maxArea = 0;
        for(int i = 0; i < height.length; i++){
            for(int j = i +1; j < height.length; j++){
                maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * Math.abs(i-j));
            }
        }

        return maxArea;
    }

    //正解2， 双指针法  复杂度O(N)
    public int maxArea1(int[] height){
        if(height == null || height.length <= 1){
            return 0;
        }

        int maxArea = 0;
        int first = 0;//头指针
        int last = height.length-1;//尾指针
        while(first <= last){
            int h = Math.min(height[first], height[last]);
            int len = last - first;
            maxArea = Math.max(maxArea, h * len);
            if(height[first] < height[last]){
                first++;
            } else{
                last--;
            }
        }

        return maxArea;
    }



    //错解1， 找到最高点
    public int maxAreaNo(int[] height) {
        if(height == null || height.length <= 1){
            return 0;
        }

        //找到最大值
        int maxH = 0;
        int maxI = 0;//最大值的坐标
        for(int i = 0; i < height.length; i++){
            if(height[i] > maxH){
                maxH = height[i];
                maxI = i;
            }
        }

        int maxArea = 0;
        //从i的左边
        for(int i = 0; i <= maxI; i++){
            maxArea = Math.max(maxArea, Math.min(maxH, height[i]) * Math.abs(maxI - i));
        }

        //从i的右边
        for(int i = maxI; i < height.length; i++){
            maxArea = Math.max(maxArea, Math.min(maxH, height[i]) * Math.abs(maxI - i));
        }

        return maxArea;
    }

}
