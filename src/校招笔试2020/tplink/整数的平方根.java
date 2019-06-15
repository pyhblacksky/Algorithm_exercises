package 校招笔试2020.tplink;

import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/6/15 10:57
 * @Version: 1.0
 * @Function:
 * @Description:
 *  保留整数部分
 */
public class 整数的平方根 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(mySqrt(num));
    }

    //牛顿迭代法求平方根
    static int mySqrt(int num){
        if(num == 1)
            return 1;

        long res = num;
        while(res != 0 && res > num/res){
            res = (res + num/res)/2;
        }

        return (int)res;
    }

}
