package LeetCodeRace.Contest145;

import java.util.*;

/**
 * @Author: pyh
 * @Date: 2019/7/14 10:30
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 给你两个数组，arr1 和 arr2，
 *
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。
 * 未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 *
 *
 * 示例：
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *
 *
 * 提示：
 *
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 */
public class 数组的相对排序 {

    static class Solution {
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            if(arr1 == null || arr1.length == 0)
                return arr1;

            Map<Integer, Integer> mapArr = new HashMap<>();
            for(int i = 0; i < arr1.length; i++){
                mapArr.put(arr1[i], mapArr.getOrDefault(arr1[i], 0) + 1);
            }

            int[] arr = new int[arr1.length];
            int index = 0;
            for(int i = 0; i < arr2.length; i++){
                while(mapArr.containsKey(arr2[i]) && mapArr.get(arr2[i]) > 0){
                    arr[index++] = arr2[i];
                    mapArr.put(arr2[i], mapArr.get(arr2[i]) - 1);
                }
            }

            //剩下的排序
            int mark = index;
            for(Map.Entry<Integer, Integer> entry : mapArr.entrySet()){
                while(entry.getValue() > 0){
                    int val = entry.getValue();
                    arr[index++] = entry.getKey();
                    entry.setValue(val-1);
                }
            }

            Arrays.sort(arr, mark, arr.length);
            return arr;
        }
    }

    public static void main(String[] args){

        Solution solution = new Solution();
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        solution.relativeSortArray(arr1, arr2);

    }

}
