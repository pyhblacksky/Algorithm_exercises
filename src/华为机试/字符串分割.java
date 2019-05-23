package 华为机试;

import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/5/23 8:35
 * @Version: 1.0
 * @Function:
 * @Description:
 * 题目描述
 * •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * 输入描述:
 * 连续输入字符串(输入2次,每个字符串长度小于100)
 *
 * 输出描述:
 * 输出到长度为8的新字符串数组
 *
 * 示例1
 * 输入
 * 复制
 * abc
 * 123456789
 * 输出
 * 复制
 * abc00000
 * 12345678
 * 90000000
 */
public class 字符串分割 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String line2 = sc.nextLine();
        if(line1 == null || line1.length() == 0 || line2 == null || line2.length() == 0){
            //空串不做处理
            return;
        }
        int line1Len = line1.length() % 8 == 0 ? line1.length()/8 : line1.length()/8 + 1;
        int line2Len = line2.length() % 8 == 0 ? line2.length()/8 : line2.length()/8 + 1;
        String[] res = new String[line1Len+line2Len];
        int index = 0;
        for(int i = 0; i < line1.length(); i = i+8){
            if(i+8 > line1.length()){
                String temp = line1.substring(i);
                int tempLen = temp.length();
                res[index++] = temp+getZero(tempLen);
            } else{
                String temp = line1.substring(i, i+8);
                res[index++] = temp;
            }
        }

        for(int i = 0; i < line2.length(); i = i+8){
            if(i+8 > line2.length()){
                String temp = line2.substring(i);
                int tempLen = temp.length();
                res[index++] = temp+getZero(tempLen);
            } else{
                String temp = line2.substring(i, i+8);
                res[index++] = temp;
            }
        }

        //显示
        for(int i = 0; i < index; i++){
            System.out.println(res[i]);
        }

    }

    static String getZero(int n){
        int count = 8 - n;
        StringBuilder sb = new StringBuilder();
        while(count != 0){
            sb.append("0");
            count--;
        }
        return sb.toString();
    }
}
