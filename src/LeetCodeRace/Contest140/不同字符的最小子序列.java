package LeetCodeRace.Contest140;

import java.util.*;

/**
 * @Author: pyh
 * @Date: 2019/6/9 10:57
 * @Version: 1.0
 * @Function:
 * @Description:
 * 返回字符串 text 中按字典序排列最小的子序列，该子序列包含 text 中所有不同字符一次。
 *
 * 示例 1：
 *
 * 输入："cdadabcc"
 * 输出："adbc"
 * 示例 2：
 *
 * 输入："abcd"
 * 输出："abcd"
 * 示例 3：
 *
 * 输入："ecbacba"
 * 输出："eacb"
 * 示例 4：
 *
 * 输入："leetcode"
 * 输出："letcod"
 *
 *
 * 提示：
 *
 * 1 <= text.length <= 1000
 * text 由小写英文字母组成
 */
public class 不同字符的最小子序列 {
    //求最小子序列
    Map<Character, Integer> map = new HashMap<>();//对应字符出现次数的map
    public String smallestSubsequence(String text) {
        for(char ch : text.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        String res = dfs(text, 0, text.length(), "");
        return res;
    }
    private String dfs(String text, int startpos, int n, String cur){
        char ch = 'z'+1;//边界
        int pos = 0;
        int i;
        for(i = startpos; i < n; i++){
            char c = text.charAt(i);
            if(map.get(c) == -1)
                continue;
            if(c < ch){
                ch = c;
                pos = i;
            }

            map.put(c, map.get(c)-1);
            if(map.get(c) == 0){//最后一个
                for(int j = pos; j <= i; j++){
                    if(map.get(text.charAt(j)) != -1){
                        map.put(text.charAt(j), map.get(text.charAt(j)) + 1);//恢复
                    }
                }
                break;
            }
        }

        if(i == n){//到底
            return cur;
        }
        map.put(ch, -1);//该字符剩下最后一个，加入结果集，置-1表示已加入
        return dfs(text, pos+1, n, cur+ch);
    }


    public static void main(String[] args){
        不同字符的最小子序列 solution = new 不同字符的最小子序列();
        System.out.println(solution.smallestSubsequence("ecbacba"));
    }

    /***************************************************************************/
    //以下是错误方法。。。。
    //不可用，无法找到最小字典序的
    private String help(char[] chars){
        if(chars == null || chars.length == 0){
            return "";
        }

        //求最长的长度
        int[] dp = new int[chars.length];
        int max = 1;
        for(int i = 0; i < chars.length; i++){
            dp[i] = 1;
            Set<Character> tempSet = new HashSet<>();
            tempSet.add(chars[i]);
            for(int j = 0; j < i; j++){
                if(chars[j] != chars[i] && !tempSet.contains(chars[j])){
                    dp[i] = Math.min(dp[i]+1, dp[j]+1);
                    tempSet.add(chars[j]);
                    max = Math.max(dp[i], max);
                }
            }
        }

        List<String> list = new ArrayList<>();
        //集合再排序
        for(int i = 0; i < chars.length; i++){
            StringBuilder sb = new StringBuilder();
            sb.append(chars[i]);

            Set<Character> tempSet = new HashSet<>();
            tempSet.add(chars[i]);
            for(int j = i + 1; j < chars.length; j++){
                if(!tempSet.contains(chars[j])){
                    tempSet.add(chars[j]);
                    sb.append(chars[j]);
                }
            }

            if(sb.length() == max){
                list.add(sb.toString());
            }
        }

        //字典序排序
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //两个str的长度一样
                for(int i = 0; i < o1.length(); i++){
                    if(o1.charAt(i) < o2.charAt(i)){
                        return -1;
                    } else if(o1.charAt(i) > o2.charAt(i)){
                        return 1;
                    }
                }
                return 0;
            }
        });

        return list.get(0);
    }

    //暂时没用
    private String getDp(char[] nums){
        if(nums == null || nums.length == 0){
            return "";
        }

        int[] dp = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            dp[i] = 1;
            Set<Character> set = new HashSet<>();
            set.add(nums[i]);
            for(int j = 0; j < i; j++){
                if(nums[j] != nums[i] && !set.contains(nums[j])){
                    dp[i] = Math.min(dp[i]+1, dp[j]+1);
                    set.add(nums[j]);
                }
            }
        }

        int maxLen = 0;
        int end = 0;
        for(int i = 0; i < dp.length; i++){
            if(dp[i] > maxLen){
                maxLen = dp[i];
                end = i;
            }
        }

        //递减还原数列
        char[] lis = new char[maxLen];
        lis[--maxLen] = nums[end];
        for(int i = end - 1; i >= 0; i--){
            if(dp[i] == dp[end] - 1){
                lis[--maxLen] = nums[i];
                end = i;
            }
        }
        String res = new String(lis);

        return res;
    }

}
