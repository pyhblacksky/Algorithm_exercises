package 剑指offer;

import static 剑指offer.Tools.printArrInt;

/**
 * @Author: pyh
 * @Date: 2019/2/19 18:57
 * @Version 1.0
 * @Function:
 *      给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 *      其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class 构建乘积数组 {

    //时间复杂度O(n)    上三角乘积和下三角乘积
    public static int[] multiply(int[] A){
        int[] B = new int[A.length];
        //计算前半部分
        B[0] = 1;
        int temp = 1;
        for(int i = 1; i < A.length; i++){
            temp *= A[i-1];
            B[i] = temp;
        }

        //计算后半部分
        temp = 1;
        for(int i = A.length - 2; i >= 0; i--){
            temp *= A[i+1];
            B[i] = B[i] * temp;
        }

        return B;
    }

    //时间复杂度O(n^2)
    public int[] multiply1(int[] A) {
        int[] B = new int[A.length];
        for(int i = 0; i < B.length; i++){
            int temp = 1;
            for(int j = 0; j < A.length; j++){
                if(j != i){
                    temp *= A[j];
                }
            }
            B[i] = temp;
        }
        return B;
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5};
        int[] res = multiply(arr);
        printArrInt(res);
    }
}
