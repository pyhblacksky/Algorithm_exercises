package 零碎的算法题;

import java.util.Arrays;

/**
 * @Author: pyh
 * @Date: 2019/7/8 20:29
 * @Version: 1.0
 * @Function:
 * @Description:
 * 找出一串字符串的最长子串，要求最多两个不同的字母
 */
public class 字符串最长子串 {

    static class Solution{
        public int max_substring(String str){
            if(str == null || str.length() <= 1)
                return str.length();

            char[] ch = str.toCharArray();
            int length = str.length();
            int begin = 0;  //记录最长子串的起点
            int end = 0;    //记录最长子串的终点
            int maxlen = 0;
            int j = 0;  //记录当前不重复字符串的起点
            int i = 0;  //记录当前不重复字符串的终点

            int[] hash = new int[128];  //用数组代替哈希表map

            Arrays.fill(hash, -1);

            //遍历字符数组
            while(i < length){
                if(hash[ch[i] - '0'] >= j){ //如果当前维护的不重复子串中出现了ch[i]
                    j = hash[ch[i] - '0'] + 1;
                } else{
                    if(i - j + 1 > maxlen){
                        maxlen = i - j + 1;
                        begin = j;
                        end = i;
                    }
                }
                hash[ch[i] - '0'] = i;
                i++;
            }

            //打印
            System.out.println(str.substring(begin, end+1));

            return maxlen;
        }
    }

    public static void main(String[] args) {
        String str = "abcdeabcdefabcdefga";

        Solution solution = new Solution();
        int n = solution.max_substring(str);
        System.out.println(n);
    }

}
