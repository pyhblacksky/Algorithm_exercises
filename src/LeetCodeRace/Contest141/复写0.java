package LeetCodeRace.Contest141;

/**
 * @Author: pyh
 * @Date: 2019/6/16 10:33
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 *
 * 注意：请不要在超过该数组长度的位置写入元素。
 *
 * 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1,0,2,3,0,4,5,0]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
 * 示例 2：
 *
 * 输入：[1,2,3]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,2,3]
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 10000
 * 0 <= arr[i] <= 9
 */
public class 复写0 {

    static class Solution {
        public static void duplicateZeros(int[] arr) {
            if(arr == null || arr.length == 0)
                return;

            for(int i = 0; i < arr.length; i++){
                if(arr[i] == 0 && i+1 < arr.length){
                    if(i+2 < arr.length) {
                        for (int j = arr.length-1; j >= i+2; j--) {
                            arr[j] = arr[j-1];
                        }
                    }
                    arr[i+1] = 0;
                    i++;
                }
            }
        }

        public static void main(String[] args){
            int[] arr = {1,2,3};
            duplicateZeros(arr);
        }
    }

}
