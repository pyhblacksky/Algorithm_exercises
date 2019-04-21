package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/4/20 16:31
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class Solution42_接雨水 {
    public int trap(int[] height) {
        if(height == null || height.length <= 1){
            return 0;
        }

        int area = 0;
        //找到最高点，从最高点两边开始遍历
        int max = 0;
        int maxIndex = -1;
        for(int i = 0; i < height.length; i++){
            if(height[i] > max){
                max = height[i];
                maxIndex = i;
            }
        }

        //从左向右遍历，如果递减就可以接雨水
        int temp = height[0];
        for(int i = 1; i <= maxIndex; i++){
            if(height[i] > temp){
                temp = height[i];
            } else {
                area += temp - height[i];
            }
        }

        //从右向左遍历，如果递减就可以接雨水
        temp = height[height.length-1];
        for(int i = height.length-2; i >= maxIndex; i--){
            if(height[i] > temp){
                temp = height[i];
            } else{
                area += temp - height[i];
            }
        }

        return area;
    }

    public static int countVol(int[] arr, int start, int end, int thread){
        int res = 0;
        for(int i = start; i <= end; i++){
            if(arr[i] < thread){
                res += thread - arr[i];
            }
        }
        return res;
    }

    public static void main(String[] args){
        Solution42_接雨水 solution = new Solution42_接雨水();
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solution.trap(height));
    }
}
