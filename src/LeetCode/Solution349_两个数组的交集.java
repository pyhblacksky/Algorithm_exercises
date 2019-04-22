package LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: pyh
 * @Date: 2019/4/22 15:16
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 */
public class Solution349_两个数组的交集 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
            return new int[]{};
        }

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for(int num : nums1){
            set1.add(num);
        }
        for(int num : nums2){
            set2.add(num);
        }

        set1.retainAll(set2);
        Object[] temp = set1.toArray();
        int[] res = new int[temp.length];
        for(int i = 0; i < temp.length; i++){
            res[i] = (int)temp[i];
        }

        return res;
    }
}
