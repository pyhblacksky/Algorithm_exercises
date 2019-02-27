package 剑指offer.水题;

/**
 * @Author: pyh
 * @Date: 2019/2/16 20:21
 * @Version 1.0
 * @Function:
 *      斐波那契数列
 *      1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...
 *      现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 *      n<=39
 */
public class 斐波那契数列 {

    public static int Fibonacci(int n) {
        if(n <= 0){
            return 0;
        }
        if(n == 1 || n == 2){
            return 1;
        }
        int n1 = 1;
        int n2 = 1;
        while(n > 2){
            int temp = n2;
            n2 = n1 + n2;
            n1 = temp;
            n--;
        }
        return n2;
    }

    public static void main(String[] args){
        for(int i = 1; i < 10; i++){
            System.out.println(Fibonacci(i));
        }

    }

}
