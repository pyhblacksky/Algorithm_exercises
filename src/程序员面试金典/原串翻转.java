package 程序员面试金典;

/**
 * @Author: pyh
 * @Date: 2019/7/7 16:15
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 题目描述
 * 请实现一个算法，在不使用额外数据结构和储存空间的情况下，翻转一个给定的字符串(可以使用单个过程变量)。
 *
 * 给定一个string iniString，请返回一个string，为翻转后的字符串。保证字符串的长度小于等于5000。
 *
 * 测试样例：
 * "This is nowcoder"
 * 返回："redocwon si sihT"
 */
public class 原串翻转 {

    //String是不可变的，在java中这道题如果不使用额外空间，基本无解
    public static class Reverse {
        public String reverseString(String iniString) {
            // write code here
            if(iniString == null || iniString.length() <= 1)
                return iniString;

            int len = iniString.length();

            int p1 = 0;
            int p2 = len-1;
            char[] ch = iniString.toCharArray();
            while(p1 <= p2){
                swap(ch, p1++, p2--);
            }
            return new String(ch);
        }

        private void swap(char[] ch, int p1, int p2){
            char tmp = ch[p1];
            ch[p1] = ch[p2];
            ch[p2] = tmp;
        }

        public static void main(String[] args){
            Reverse reverse = new Reverse();
            String a = "abcde";
            System.out.println(reverse.reverseString(a));
        }
    }

}
