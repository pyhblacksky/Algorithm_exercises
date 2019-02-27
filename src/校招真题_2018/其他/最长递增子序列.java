package 校招真题_2018.其他;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/2/23 14:07
 * @Version 1.0
 * @Function:
 * 题目描述
 * 给定一个序列 An = a1 ,a2 ,  ... , an ，找出最长的子序列使得对所有 i < j ，ai < aj 。求出这个子序列的长度
 * 输入描述:
 * 输入的序列
 * 输出描述:
 * 最长递增子序列的长度
 */
public class 最长递增子序列 {

    public static void main(String[] args){
        Scanner read = new Scanner(System.in);

        while(read.hasNext()){
            String str = read.nextLine();
            String[] strArr = str.split("\\s+");
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0; i < strArr.length; i++){
                list.add(Integer.valueOf(strArr[i]));
            }
            int res = countRes(list);
            System.out.println(res);
        }

        read.close();
    }
    private static int countRes(ArrayList<Integer> list){
        int res = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < list.size(); i++){
            res = 0;
            res++;
            for(int j = i+1; j < list.size(); j++){
                if(list.get(j) > list.get(i)){
                    res++;
                }
            }
            max = Math.max(max, res);
        }
        return max;
    }

}
