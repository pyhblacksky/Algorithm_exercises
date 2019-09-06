package 校招笔试2020.顺丰829;

import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/8/29 18:43
 * @Version: 1.0
 * @Function:
 * @Description:
 */
public class Main2 {

    //AC
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(func(arr));
    }

    static int lengthOfLIS(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }

        int[] dp = new int[nums.length];
        int res = 1;
        for(int i = 0; i < nums.length; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[j] <= nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    static int func(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }

        int[] dp = new int[nums.length];
        int[] ends = new int[nums.length + 1];
        dp[0] = 1;
        ends[1] = nums[0];
        int right = 1;
        int L, mid, R;
        for(int i = 1; i < nums.length; i++){
            L = 1;
            R = right;
            while(L <= R){
                mid = L + (R - L) / 2;
                if(ends[mid] > nums[i]){//修改此处条件即可满足大于等于
                    R = mid - 1;
                } else{
                    L = mid + 1;
                }
            }

            if(L > right){
                dp[i] = right + 1;
                ends[right + 1] = nums[i];
                right++;
            } else{
                dp[i] = right;
                ends[L] = nums[i];
            }
        }
        return right;
    }

}
