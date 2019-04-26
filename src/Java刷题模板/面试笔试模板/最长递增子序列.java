package Java刷题模板.面试笔试模板;

import java.io.PrintWriter;

/**
 * @Author: pyh
 * @Date: 2019/4/23 16:27
 * @Version: 1.0
 * @Function:
 * @Description:
 * 详细解答：
 * https://github.com/ZXZxin/ZXBlog/blob/master/%E5%88%B7%E9%A2%98/LeetCode/DP/LeetCode%20-%20354.%20Russian%20Doll%20Envelopes%E5%8F%8A%E6%9C%80%E9%95%BF%E4%B8%8A%E5%8D%87%E5%AD%90%E5%BA%8F%E5%88%97%E9%97%AE%E9%A2%98%E6%80%BB%E7%BB%93.md
 *
 * 题目：
 *  leetCode 345 俄罗斯套娃信封问题
 */
public class 最长递增子序列 {

    //复杂度O(N^2)的方法，最长递增子序列的长度
    public int lengthOfLIS(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }

        int[] dp = new int[nums.length];
        int res = 1;
        for(int i = 0; i < nums.length; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    //复杂度O(N^2)的, 返回dp序列
    public int[] getDp(int[] nums){
        if(nums == null || nums.length == 0){
            return new int[]{};
        }

        int[] dp = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp;
    }

    //获取最长递增序列
    static int[] getLIS(int[] arr, int[] dp){
        int maxLen = 0;
        int end = 0;
        for(int i = 0; i < dp.length; i++){
            if(dp[i] > maxLen){
                maxLen = dp[i];
                end = i;
            }
        }

        //递减还原数列
        int[] lis = new int[maxLen];
        lis[--maxLen] = arr[end];
        for(int i = end - 1; i >= 0; i--){
            if(dp[i] == dp[end] - 1 && arr[i] < arr[end]){
                lis[--maxLen] = arr[i];
                end = i;
            }
        }
        return lis;
    }

    //获取最长递增子序列的长度，复杂度为O(N*logN)的方法
    public int lengthOfLIS2(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }

        int[] dp = new int[nums.length];
        int[] ends = new int[nums.length + 1];
        dp[0] = 1;
        ends[1] = nums[0];//保存最小的结尾数
        int right = 1;  // [1~right] 为有效区 ends数组是有序的(升序),right是右边界
        int L, mid, R;
        for(int i = 1; i < nums.length; i++){
            L = 1;
            R = right;
            //找到第一个>=arr[i]的， 返回结果是L
            while(L <= R){
                mid = L + (R - L) / 2;
                if(ends[mid] >= nums[i]){
                    R = mid - 1;
                } else{
                    L = mid + 1;
                }
            }

            //说明以arr[i]结尾的最长递增子序列的=ends区有效长度+1
            if(L > right){
                //没有找到arr[i]是最长的(因为下标从1开始，所以判断是>right)
                dp[i] = right + 1;
                ends[right + 1] = nums[i]; //扩大ends数组
                right++;    //扩大有效区
            } else{
                //找到了arr[l] > arr[i]， 更新end[l] = arr[i]，表示l长度的最长子序列结尾可以更新为arr[i]
                dp[i] = right; //dp[i]没有加长
                ends[L] = nums[i];
            }
        }
        return right;
    }

    //测试
    public static void main(String[] args){
        PrintWriter out = new PrintWriter(System.out);
        int[] arr = {10,9,2,5,3,7,101,18};
        最长递增子序列 solution = new 最长递增子序列();
        out.println(solution.lengthOfLIS(arr));
        int[] dp = solution.getDp(arr);
        int[] lis = getLIS(arr, dp);
        printArr(solution.getDp(arr));
        printArr(lis);
        solution.lengthOfLIS2(arr);
        out.close();
    }

    public static void printArr(int[] arr){
        for(int x : arr){
            System.out.print(x + " ");
        }
        System.out.println();
    }

}
