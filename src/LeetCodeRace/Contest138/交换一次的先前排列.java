package LeetCodeRace.Contest138;

/**
 * @Author: pyh
 * @Date: 2019/5/26 17:50
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给你一个正整数的数组 A（其中的元素不一定完全不同），请你返回可在 一次交换（交换两数字 A[i] 和 A[j] 的位置）后得到的、按字典序排列小于 A 的最大可能排列。
 *
 * 如果无法这么操作，就请返回原数组。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[3,2,1]
 * 输出：[3,1,2]
 * 解释：
 * 交换 2 和 1
 *
 *
 * 示例 2：
 *
 * 输入：[1,1,5]
 * 输出：[1,1,5]
 * 解释：
 * 这已经是最小排列
 *
 *
 * 示例 3：
 *
 * 输入：[1,9,4,6,7]
 * 输出：[1,7,4,6,9]
 * 解释：
 * 交换 9 和 7
 *
 *
 * 示例 4：
 *
 * 输入：[3,1,1,3]
 * 输出：[1,1,3,3]
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * 1 <= A[i] <= 10000
 */
public class 交换一次的先前排列 {

    public int[] prevPermOpt1(int[] A) {
        if(A == null || A.length <= 1){
            return A;
        }

        for(int i = A.length - 2; i >= 0; i--){
            if(A[i] > A[i+1]){
                //从后看，出现非降序
                for(int j = A.length-1; j >= 0 && j >= i;j--){
                    if(A[i] > A[j]){
                        swap(A, i, j);
                        return A;
                    }
                }
            }
        }
        return A;
    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
