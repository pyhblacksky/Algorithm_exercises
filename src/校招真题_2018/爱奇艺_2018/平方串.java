package 校招真题_2018.爱奇艺_2018;

import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/2/22 20:31
 * @Version 1.0
 * @Function:
 * 如果一个字符串S是由两个字符串T连接而成, 即S = T + T, 我们就称S叫做平方串,例如"","aabaab","xxxx"都是平方串.
 * 牛牛现在有一个字符串s,请你帮助牛牛从s中移除尽量少的字符,让剩下的字符串是一个平方串。换句话说,就是找出s的最长子序列并且这个子序列构成一个平方串。
 * 输入描述:
 * 输入一个字符串s,字符串长度length(1 ≤ length ≤ 50),字符串只包括小写字符。
 * 输出描述:
 * 输出一个正整数,即满足要求的平方串的长度。
 *
 */
public class 平方串 {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String str = scan.nextLine();
            int res = countLen(str);
            System.out.println(res);
        }
        scan.close();
    }

    private static int countLen(String str){
        if(str == null || str.length() == 0){
            return 0;
        }

        int count = 0;

        //区分奇数偶数
        if(str.length() % 2 == 0){
            String str1 = str.substring(0, str.length()/2);
            String str2 = str.substring(str.length()/2);
            for(int i = 0; i < str1.length(); i++){
                for(int j = i; j < str2.length(); j++){
                    if(str1.charAt(i) == str2.charAt(j)){
                        count++;
                        break;
                    }
                }
            }
        } else {
            String str1 = str.substring(0, str.length()/2);
            String str2 = str.substring(str.length()/2+1);
            for(int i = 0; i < str1.length(); i++){
                for(int j = i; j < str2.length(); j++){
                    if(str1.charAt(i) == str2.charAt(j)){
                        count++;
                        break;
                    }
                }
            }
        }
        return (str.length()/2 - count) * 2;
    }
}
