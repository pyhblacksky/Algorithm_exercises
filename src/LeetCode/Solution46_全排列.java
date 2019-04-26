package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: pyh
 * @Date: 2019/4/24 16:37
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Solution46_全排列 {
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        help(nums, 0, nums.length, res);
        //printList(res);
        return res;
    }

    public static void help(int[] arr, int cur, int n, List<List<Integer>> list){
        if(cur == n){
            List<Integer> t = new ArrayList<>();
            for(int i = 0; i < arr.length; i++){
                t.add(arr[i]);
            }
            list.add(t);
            return;
        }

        for(int i = cur; i < n; i++){
            swap(arr, cur, i);
            help(arr, cur+1, n, list);
            swap(arr, cur, i);
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){
        int[] arr = {1,2,3};
        Solution46_全排列 solution = new Solution46_全排列();
        solution.permute(arr);
    }

    public static void printList(List<List<Integer>> res){
        for(List<Integer> temp : res){
            for(Integer x : temp){
                System.out.print(x + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
