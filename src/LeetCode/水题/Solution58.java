package LeetCode.水题;

/**
 * @Author: pyh
 * @Date: 2019/2/25 14:17
 * @Version 1.0
 * @Function:   58. 最后一个单词的长度
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * 如果不存在最后一个单词，请返回 0 。
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 *
 * 示例:
 * 输入: "Hello World"
 * 输出: 5
 */
public class Solution58 {

    //内置函数解法2
    public int lengthOfLastWord(String s){
        s = s.trim();
        int count = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) == ' '){
                break;
            }
            count++;
        }
        return count;
    }

    //内置函数解法1
    public int lengthOfLastWord1(String s) {
        String[] str = s.split("\\s+");
        if(str.length == 0){
            return 0;
        }

        return str[str.length - 1].length();
    }

}
