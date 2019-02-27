package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/2/24 15:42
 * @Version 1.0
 * @Function:   27、移除元素
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 1:
 * 给定 nums = [3,2,2,3], val = 3,
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 2:
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * 注意这五个元素可为任意顺序。
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class Solution27_移除元素 {

    //双指针法
    // 当 nums[j]nums[j] 与给定的值相等时，递增 jj 以跳过该元素。只要 nums[j] != val
    // 我们就复制 nums[j]nums[j] 到 nums[i]nums[i] 并同时递增两个索引。
    // 重复这一过程，直到j到达数组的末尾，该数组的新长度为i。
    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for(int j = 0; j < nums.length; j++){
            if(nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args){
        int[] arr = {0,1,2,2,3,0,4,2};
        System.out.println(removeElement(arr, 2));
        printArr(arr);
        int[] arr1 = {1};
        System.out.println(removeElement(arr1, 1));
        printArr(arr1);
    }

    public static void printArr(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
