package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: pyh
 * @Date: 2019/5/31 8:28
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 *
 * 示例 1:
 *
 * 输入: [10,2]
 * 输出: 210
 * 示例 2:
 *
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 */
public class Solution179_最大数 {

    public static String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return "0";
        }
        if(nums.length == 1){
            return String.valueOf(nums[0]);
        }


        String[] strs = new String[nums.length];
        int index = 0;
        for(int num : nums){
            strs[index++] = String.valueOf(num);
        }

        //定义比较器
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1+o2;
                String s2 = o2+o1;

                for(int i = 0; i < s1.length(); i++){
                    if(s1.charAt(i) > s2.charAt(i)){
                        return -1;
                    } else if(s1.charAt(i) < s2.charAt(i)){
                        return 1;
                    }
                }

                return 0;
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strs.length; i++){
            sb.append(strs[i]);
        }

        //去除前缀0
        index = 0;
        for(int i = 0; i < sb.length(); i++){
            if(sb.charAt(i) == '0'){
                index++;
            } else{
                break;
            }
        }
        String res = sb.substring(index);
        return res.length() == 0 ? "0" : res;
    }

    public static void main(String[] args){
        int[] arr = {0, 0};
        largestNumber(arr);
    }

}
