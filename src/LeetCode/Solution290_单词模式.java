package LeetCode;

import java.util.HashMap;

/**
 * @Author: pyh
 * @Date: 2019/4/22 14:34
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一种 pattern(模式) 和一个字符串 str ，判断 str 是否遵循相同的模式。
 *
 * 这里的遵循指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应模式。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 *
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 */
public class Solution290_单词模式 {
    public boolean wordPattern(String pattern, String str) {
        if(str == null || str.length() == 0 || pattern == null || pattern.length() == 0){
            return false;
        }
        String[] word = str.split(" ");

        //长度不等肯定不匹配
        if(word.length != pattern.length()){
            return false;
        }

        //用两个HashMap, 建立相互之间的对应关系
        HashMap<Character, String> CharToStr = new HashMap<>();
        HashMap<String, Character> StrToChar = new HashMap<>();

        for(int i = 0; i < pattern.length(); i++){
            char temp = pattern.charAt(i);
            if(!CharToStr.containsKey(temp)){
                CharToStr.put(temp, word[i]);
            }

            if(!StrToChar.containsKey(word[i])){
                StrToChar.put(word[i], temp);
            }

            if(CharToStr.get(temp).equals(word[i]) && StrToChar.get(word[i]).equals(temp)){
                continue;
            } else{
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        Solution290_单词模式 solution = new Solution290_单词模式();
        solution.wordPattern("abba", "dog dog dog dog");
    }
}
