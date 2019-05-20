package 牛客竞赛OJ.牛客练习赛_46;

import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/5/20 20:19
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 链接：https://ac.nowcoder.com/acm/contest/894/A
 * 来源：牛客网
 *
 * 题目描述
 * 奕奕的几何很差，然而奕奕并不承认，所以华华扔给奕奕一道题目。如图：
 *
 * 已知大半圆的半径等于两个小半圆半径之和。若给出红色部分的面积，那么大圆的半径最小是多少呢？反正奕奕是不会的，所以现在请你回答。
 * 输入描述:
 * 输入一个正整数s表示红色部分的面积。
 * 1<=s<=1e9
 * 输出描述:
 * 输出一个小数表示大圆的最小半径，保留三位小数
 * 示例1
 * 输入
 * 复制
 * 2
 * 输出
 * 复制
 * 1.596
 * 示例2
 * 输入
 * 复制
 * 3
 * 输出
 * 复制
 * 1.954
 */
public class 华华教奕奕写几何 {

    // R = √(4*S)/pi
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long s = sc.nextInt();
        double res = Math.sqrt(4*s/Math.PI);
        System.out.println(String.format("%.3f", res));
    }

}
