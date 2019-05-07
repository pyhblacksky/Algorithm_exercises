package 校招真题_2018.字节跳动_2018;

import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/5/7 14:09
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 题目描述
 *  有三只球队，每只球队编号分别为球队1，球队2，球队3，这三只球队一共需要进行 n 场比赛。
 *  现在已经踢完了k场比赛，每场比赛不能打平，踢赢一场比赛得一分，输了不得分不减分。
 *  已知球队1和球队2的比分相差d1分，球队2和球队3的比分相差d2分，每场比赛可以任意选择两只队伍进行。
 *  求如果打完最后的 (n-k) 场比赛，有没有可能三只球队的分数打平。  
 *
 * 输入描述:
 *  第一行包含一个数字 t (1 <= t <= 10)
 *  接下来的t行每行包括四个数字 n, k, d1, d2(1 <= n <= 10^12; 0 <= k <= n, 0 <= d1, d2 <= k)
 *
 * 输出描述:
 *  每行的比分数据，最终三只球队若能够打平，则输出“yes”，否则输出“no”
 *
 * 示例1
 *
 * 输入
 * 2
 * 3 3 0 0
 * 3 3 3 3
 *
 * 输出
 * yes
 * no
 *
 * 说明
 * case1: 球队1和球队2 差0分，球队2 和球队3也差0分，所以可能的赛得分是三只球队各得1分
 * case2: 球队1和球队2差3分，球队2和球队3差3分，所以可能的得分是 球队1得0分，球队2得3分, 球队3 得0分，
 *      比赛已经全部结束因此最终不能打平。
 *
 */
public class 编程题1_球队打平 {

    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        while(t != 0){
            long n = cin.nextLong();//总比赛数
            long k = cin.nextLong();//已经进行完的比赛数
            long d1 = cin.nextLong();//队伍1 和队伍2 相差分数
            long d2 = cin.nextLong();//队伍2和队伍3的相差分数

            if(help(n, k, d1, d2)){
                System.out.println("yes");
            } else{
                System.out.println("no");
            }

            t--;
        }
    }
    static boolean help(long n, long k, long d1, long d2 ){

        long tmp = k - d1 - d1 - d2; //球队1< 球队2，球队2<球队3
        long left = 0;
        //球队1的得分有解是大前提
        if(tmp >= 0 && tmp % 3 == 0) {
            left = (n - k) - (d1 + d2 + d2);
            //剩下的场次不小于need，并且可以均分3场。
            if(left >= 0 && left % 3 == 0) {
                return true;
            }
        }

        tmp = k - d1 - d1 + d2; //球队1< 球队2，球队2>球队3
        if(tmp >= 0 && tmp % 3 == 0) {
            left = (n - k) - (d1 + d2);
            if(left >= 0 && left % 3 == 0) {
                return true;
            }
        }

        tmp = k + d1 + d1 + d2;//球队1> 球队2，球队2>球队3
        if(tmp >= 0 && tmp % 3 == 0) {
            left = (n - k) - (d1 + d1 + d2);
            if(left >= 0 && left % 3 == 0) {
                return true;
            }
        }

        tmp = k + d1 + d1 - d2;//球队1>球队2，球队2<球队3
        if(tmp >= 0 && tmp % 3 == 0) {
            if(d1 >= d2) {
                left = (n - k) - (d1 + d1 - d2);
            }
            else {
                left = (n - k) - (d2 + d2 - d1);
            }
            if(left >= 0 && left % 3 == 0) {
                return true;
            }
        }

        return false;
    }

    //返回是否打平
    //每场比赛不能打平，踢赢一场比赛得一分，输了不得分不减分
    static boolean whetherEqual(long n, long k, long d1, long d2){
        long lease = n - k;//剩余可以进行的比赛数
        if(lease == 0 && d1 == 0 && d2 == 0){
            return true;
        }
        if(lease == 0 && (d1 != 0 || d2 != 0)){
            return false;
        }

        //4种情况 x，y， z 代表三个队
        //设 x = m

        long tmp = k + d1 + d1 + d2;
        if(tmp >= 0 && tmp % 3 == 0) { //球队得分有解是大前提
            //1. 如果x>y  -> x-y=d1  ， 若y>z -> y-z=d2 ， 则有  x=m  y=m-d1  z=m-d1-d2
            //y  赢  d1  z 赢d1+d2
            if(lease == (d1+d1+d2)){
                return true;
            }
        }

        tmp = k + d1 + d1 - d2;
        if(tmp >= 0 && tmp % 3 == 0) {
            //2. 如果x>y  -> x-y=d1  ， 若y<z -> y-z=-d2 ，则有  x=m  y=m-d1  z=m-d1+d2
            //再分情况
            if (d1 >= d2) {
                // d1 > d2
                if (lease == (d1 + d1 - d2)) {
                    return true;
                }
            } else {
                //d1 < d2  d2 - d1 + d2
                if (lease == (d2 - d1 + d2)) {
                    return true;
                }
            }
        }

        tmp = k - d1 - d1 + d2;
        if(tmp >= 0 && tmp % 3 == 0) {
            //3. 如果x<y  -> x-y=-d1  ， 若y>z -> y-z=d2 ，则有  x=m  y=m+d1  z=m+d1-d2
            //x赢d1，z赢d2
            if (lease == (d1 + d2)) {
                return true;
            }
        }


        tmp = k - d1 - d1 - d2;
        if(tmp >= 0 && tmp % 3 == 0) {
            //4. 如果x<y  -> x-y=d1  ， 若y<z -> y-z=d2 ， 则有  x=m  y=m+d1  z=m+d1+d2
            //x需要赢d1+d2  y需要赢d2
            if (lease == (d1 + d2 + d2)) {
                return true;
            }
        }

        return false;
    }

}
