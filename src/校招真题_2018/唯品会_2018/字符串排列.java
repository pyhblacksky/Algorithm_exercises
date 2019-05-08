package 校招真题_2018.唯品会_2018;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/5/8 15:28
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 题目描述
 * 输入一个字符串，输出该字符串中相邻字符的所有排列。
 * 举个例子，如果输入abc，它的组合有acb bca abc cba bac cab 。
 *
 * 输入描述:
 * 一个字符串
 * 输出描述:
 * 一行，每个排列以空格分隔
 *
 * 示例1
 *
 * 输入
 * bac
 * 输出
 * a b c ac ba bac
 */
public class 字符串排列 {

    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        String str = cin.nextLine();
        String[] res = getAllStr(str);
        for(String s : res){
            System.out.print(s + " ");
        }
        System.out.println();
    }

    static String[] getAllStr(String str){
        if(str == null || str.length() == 0){
            return null;
        }
        char[] arr = str.toCharArray();

        HashSet<String> save = new HashSet<>();
        permutation(arr, 0, arr.length, save);

        String[] res = new String[save.size()];
        int index = 0;
        for(String s : save){
            res[index++] = s;
        }
        return res;
    }

    static void permutation(char[] arr, int cur, int n, HashSet<String> set){
        if(cur == n){
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < n; i++){
                sb.append(arr[i]);
            }
            set.add(sb.toString());
            return;
        }

        for(int i = cur; i < n; i++){
            swap(arr, cur, i);
            permutation(arr, cur+1, n, set);
            swap(arr, cur, i);
        }
    }

    static void swap(char[] arr, int i , int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
