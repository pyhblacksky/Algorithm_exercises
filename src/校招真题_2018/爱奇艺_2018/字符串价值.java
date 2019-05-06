package 校招真题_2018.爱奇艺_2018;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/5/6 16:22
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 题目描述
 * 有一种有趣的字符串价值计算方式:统计字符串中每种字符出现的次数,然后求所有字符次数的平方和作为字符串的价值
 * 例如: 字符串"abacaba",里面包括4个'a',2个'b',1个'c',于是这个字符串的价值为4 * 4 + 2 * 2 + 1 * 1 = 21
 * 牛牛有一个字符串s,并且允许你从s中移除最多k个字符,你的目标是让得到的字符串的价值最小。
 *
 * 输入描述:
 * 输入包括两行,第一行一个字符串s,字符串s的长度length(1 ≤ length ≤ 50),其中只包含小写字母('a'-'z')。
 * 第二行包含一个整数k(0 ≤ k ≤ length),即允许移除的字符个数。
 *
 * 输出描述:
 * 输出一个整数,表示得到的最小价值
 *
 * 示例1
 * 输入
 * aba
 * 1
 * 输出
 * 2
 *
 * wersrsresesrsesrawsdsw
 * 11
 *
 * 对应输出应该为:
 *
 * 23
 */
public class 字符串价值 {

    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        String str = cin.nextLine();
        int r = cin.nextInt();

        System.out.println(countValue(str, r));
    }

    //计算价值
    public static int countValue(String str, int r){
        if(str == null || str.length() == 0 || str.length() <= r){
            return 0;
        }

        //只包含小写字母'a' - 'z'，所以建立一一对应的数组
        int[] size = new int[26];
        char[] ch = str.toCharArray();
        for(int i = 0; i < ch.length; i++){
            size[(ch[i]-'a')]++;
        }

        Arrays.sort(size);//排序，升序排列
        reverse(size);//逆序
        printArr(size);
        //构造堆，因为减1了以后，第一个元素有可能不是最大值
        while(r != 0){
            size[0]--;
            r--;
            shiftDown(size, 0, size.length);
        }
       printArr(size);

        //计算
        int res = 0;
        for(int i = 0; i < size.length; i++){
            if(size[i] != 0){
                res += size[i]*size[i];
            }
        }
        return res;
    }

    static void shiftDown(int[] arr, int parent, int heapSize){
        //下沉操作
        int child = parent * 2 + 1;
        while(child < heapSize){
            if(child + 1 < heapSize && arr[child+1] > arr[child]){
                child++;
            }
            if(arr[parent] > arr[child]){
                break;
            }
            swap(arr, parent, child);
            parent = child;
            child = parent * 2 +1;
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void reverse(int[] arr){
        int i = 0;
        int j = arr.length - 1;
        while(i < j){
            swap(arr, i, j);
            i++;
            j--;
        }
    }


    static void printArr(int[] arr){
        for(int num : arr){
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
