package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/4/20 10:35
 * @Version: 1.0
 * @Function:
 * @Description:
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 1,3,2 -> 2,1,3
 * 4,2,0,2,3,2,0 -> 4,2,0,3,0,2,2
 */
public class Solution31_下一个排列 {
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        while(i >= 0 && nums[i] >= nums[i+1]) --i; //找到第一个 左边元素<右边元素 的 元素位置

        if(i < 0){  //如果i<0； 说明没找到，即不存在下一个排列
            reverse(nums,0,nums.length-1); //反转整个数组，得到最小排列
            return ;
        }

        //到这一步说明找到了，即存在下一个排列
        //假设找到的元素记为 K
        int j = nums.length-1;
        while(j > i && nums[j] <= nums[i]) --j; //继续从最后开始向前找，直到找到第一个大于K的元素
        swap(nums,i,j); //交换这两个元素的位置，
        reverse(nums,i+1,nums.length-1); //将i向后的元素反转，即可得到下一个排列
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void reverse(int[] arr, int start, int end){
        while(start < end){
            swap(arr, start++, end--);
        }
    }

    //测试方法
    public static void main(String[] args){
        Solution31_下一个排列 solution = new Solution31_下一个排列();
        int[] arr = new int[]{1, 3, 2};
        int[] arr1 = new int[]{4,2,0,2,3,2,0};
        solution.nextPermutation(arr);
        printArr(arr);
    }

    public static void printArr(int[] arr){
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
