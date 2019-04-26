package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/4/23 8:52
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个单词，你需要判断单词的大写使用是否正确。
 *
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 *
 * 全部字母都是大写，比如"USA"。
 * 单词中所有字母都不是大写，比如"leetcode"。
 * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
 * 否则，我们定义这个单词没有正确使用大写字母。
 *
 * 示例 1:
 *
 * 输入: "USA"
 * 输出: True
 * 示例 2:
 *
 * 输入: "FlaG"
 * 输出: False
 */
public class Solution520_检测大写字母 {
    public boolean detectCapitalUse(String word) {
        if(word == null || word.length() == 0){
            return false;
        }

        //三种规则：全为大写，全为小写，首字母是大写
        char[] ch = word.toCharArray();
        if(ch[0] >= 65 && ch[0] <= 90){//首字母是大写
            if(ch.length > 1 && (ch[1] >= 65 && ch[1] <= 90)){
                //第二个字母也是大写，判断是否全为大写
                for(int i = 2; i < ch.length; i++){
                    if(ch[i] < 65 || ch[i] > 90){
                        return false;
                    }
                }
                return true;
            } else if(ch.length > 1){
                //判断接下来的字符是否全为小写
                for(int i = 1; i < ch.length; i++){
                    if(ch[i] < 97 || ch[i] > 122){
                        return false;
                    }
                }
                return true;
            } else{
                return true;//只有一个字符
            }
        } else{
            //判断是否全为小写
            for(int i = 0; i < ch.length; i++){
                if(ch[i] < 97 || ch[i] > 122){
                    return false;
                }
            }
            return true;
        }
    }
}
