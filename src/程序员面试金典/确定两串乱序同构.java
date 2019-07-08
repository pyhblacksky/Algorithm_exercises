package 程序员面试金典;

import java.util.Arrays;

/**
 * @Author: pyh
 * @Date: 2019/7/7 16:25
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 题目描述
 * 给定两个字符串，请编写程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。这里规定大小写为不同字符，且考虑字符串中的空格。
 *
 * 给定一个string stringA和一个string stringB，请返回一个bool，代表两串是否重新排列后可相同。保证两串的长度都小于等于5000。
 *
 * 测试样例：
 * "This is nowcoder","is This nowcoder"
 * 返回：true
 * "Here you are","Are you here"
 * 返回：false
 */
public class 确定两串乱序同构 {

    //不是每个单词可否重排序，是每个字母都可以重排序
    public class Same {
        public boolean checkSam(String stringA, String stringB) {
            // write code here
            char[] c1 = stringA.toCharArray();
            char[] c2 = stringB.toCharArray();
            Arrays.sort(c1);
            Arrays.sort(c2);

            return Arrays.equals(c1, c2);
        }
    }

}
