package 华为机试;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/5/23 8:18
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 题目描述
 * 明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，他先用计算机生成了N个1到1000之间的随机整数（N≤1000），对于其中重复的数字，只保留一个，把其余相同的数去掉，不同的数对应着不同的学生的学号。然后再把这些数从小到大排序，按照排好的顺序去找同学做调查。请你协助明明完成“去重”与“排序”的工作(同一个测试用例里可能会有多组数据，希望大家能正确处理)。
 *
 *
 *
 * Input Param
 *
 * n               输入随机数的个数
 *
 * inputArray      n个随机整数组成的数组
 *
 *
 * Return Value
 *
 * OutputArray    输出处理后的随机整数
 *
 *
 *
 * 注：测试用例保证输入参数的正确性，答题者无需验证。测试用例不止一组。
 *
 *
 *
 * 输入描述:
 * 输入多行，先输入随机整数的个数，再输入相应个数的整数
 *
 * 输出描述:
 * 返回多行，处理后的结果
 *
 * 示例1
 * 输入
 * 复制
 * 11
 * 10
 * 20
 * 40
 * 32
 * 67
 * 40
 * 20
 * 89
 * 300
 * 400
 * 15
 * 输出
 * 复制
 * 10
 * 15
 * 20
 * 32
 * 40
 * 67
 * 89
 * 300
 * 400
 */
public class 明明的随机数 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            if(n <= 0){
                break;
            }

            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }

            Arrays.sort(nums);

            //去重
            int index = 0;
            for (int num : nums) {
                if (index < 1 || num != nums[index - 1]) {
                    nums[index++] = num;
                }
            }

            //显示
            for (int i = 0; i < index; i++) {
                System.out.println(nums[i]);
            }
        }

        sc.close();
    }

}
