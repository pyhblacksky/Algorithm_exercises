package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/5/29 7:59
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 *
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 */
public class Solution75_颜色分类 {

    /**
     * 简单的解法，计数并扫描
     * 空间复杂度O(N)
     * */
    public void sortColors(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return;
        }

        int zero = 0;
        int one = 0;
        int two = 0;
        for(int num : nums){
            switch (num){
                case 0:
                    zero++;
                    break;
                case 1:
                    one++;
                    break;
                case 2:
                    two++;
                    break;
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(zero != 0){
                nums[i] = 0;
                zero--;
            } else if(one != 0){
                nums[i] = 1;
                one--;
            } else if(two != 0){
                nums[i] = 2;
                two--;
            }
        }
    }

    //空间复杂度O(1),三指针,一次遍历
    public void sortColors1(int[] nums){
        if(nums == null || nums.length <= 1) {
            return;
        }

        int p0 = 0;
        int cur = 0;
        int p2 = nums.length - 1;
        while(cur <= p2){
            if(nums[cur] == 0){
                swap(nums, p0++, cur++);
            } else if (nums[cur] == 2){
                swap(nums, cur, p2--);
            } else{
                cur++;
            }
        }

    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
