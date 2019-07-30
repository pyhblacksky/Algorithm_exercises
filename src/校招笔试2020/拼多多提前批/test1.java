package 校招笔试2020.拼多多提前批;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/7/28 14:54
 * @Version: 1.0
 * @Function:
 * @Description:
 * 严格升序数组A，有一个或多个数字不符合
 * 从第二个数组B中选一个替换该不符合的数字，满足A严格升序，只能替换一次，竟可能从B中找大的值
 */
public class test1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strA = sc.nextLine();
        String strB = sc.nextLine();

        String[] str = strA.split(" ");
        int[] A = new int[str.length];
        if(A == null || A.length == 0){
            System.out.println("NO");
        }
        for(int i = 0; i < str.length; i++){
            A[i] = Integer.valueOf(str[i]);
        }

        if(A.length == 1){
            printArr(A);
            return;
        }

        str = strB.split(" ");
        int[] B = new int[str.length];
        for(int i = 0; i < str.length; i++){
            B[i] = Integer.valueOf(str[i]);
        }
        Arrays.sort(B);

        boolean flag = false;
        for(int i = 1; i < A.length; i++){
            if(A[i] <= A[i-1] && flag){
                System.out.println("NO");
                return;
            }

            if(A[i] <= A[i-1] && !flag){
                boolean res = replaceFunc(A, i, B);
                if(!res){
                    System.out.println("NO");
                    return;
                }
                flag = true;
            }
        }

        //Check
        for(int i = 1; i < A.length; i++){
            if(A[i] <= A[i-1]){
                System.out.println("NO");
                return;
            }
        }

        printArr(A);
    }

    static void printArr(int[] arr){
        StringBuilder sb = new StringBuilder();
        for(int num : arr){
            sb.append(num + " ");
        }

        String res = sb.toString().trim();
        System.out.println(res);
    }

    static boolean replaceFunc(int[] A, int index, int[] B){
        if(B == null || B.length == 0)
            return false;
        if(index == A.length - 1){
            //最后一个
            for(int i = B.length-1; i >= 0; i--){
                if(B[i] > A[index-1]){
                    A[index] = B[i];
                    return true;
                }
            }
            return false;
        } else{
            for(int i = B.length-1; i >= 0; i--){
                if(B[i] > A[index-1] && B[i] < A[index+1]){
                    A[index] = B[i];
                    return true;
                }
            }
            return false;
        }
    }
}
