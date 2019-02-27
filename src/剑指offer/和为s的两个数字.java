package 剑指offer;

import java.util.ArrayList;

import static 剑指offer.Tools.printArrList;

/**
 * @Author: pyh
 * @Date: 2019/2/19 10:28
 * @Version 1.0
 * @Function:
 *      输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 *      如果有多对数字的和等于S，输出两个数的乘积最小的。
 *      输出描述:
 *      对应每个测试案例，输出两个数，小的先输出。
 */
public class 和为s的两个数字 {

    //双指针,头尾双指针
    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();

        int p1 = 0;
        int p2 = array.length-1;
        while(p1 < p2){
            int temp = array[p1]+array[p2];
            if(temp == sum){
                res.add(array[p1]);
                res.add(array[p2]);
                return res;
            } else if(temp < sum){
                p1++;
            } else {
                p2--;
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[] arr = {1,2,4,7,11,15};
        ArrayList<Integer> res = FindNumbersWithSum(arr, 15);
        printArrList(res);
    }
}
