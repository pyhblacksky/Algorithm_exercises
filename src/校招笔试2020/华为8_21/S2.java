package 校招笔试2020.华为8_21;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/8/21 19:07
 * @Version: 1.0
 * @Function:
 * @Description:
 */
public class S2 {

    //AC
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long low = sc.nextLong();
        long high = sc.nextLong();

        List<Integer> res = func(low, high);

        long bitTen = 0;
        long bitNum = 0;
        for(int num : res){
            String str = String.valueOf(num);
            if(str.length() < 2){
                bitNum += num;
            } else{
                bitTen += str.charAt(str.length() - 2) - '0';
                bitNum += str.charAt(str.length() - 1) - '0';
            }
        }

        System.out.println(Math.min(bitTen, bitNum));
    }

    static List<Integer> func(long MIN, long MAX){
        List<Integer> prime = new LinkedList<>();
        boolean[] is_prime = new boolean[(int)(MAX+1)];
        is_prime[0] = is_prime[1] = true;//0 1 不是素数
        boolean flag;
        for(int i = 2; i <= MAX; i++){
            flag = true;
            for(int j = 2; j * j <= i; j++){ //根号i 的时间复杂度
                if(i % j == 0){
                    is_prime[i] = true;
                    flag = false;
                    break;
                }
            }

            if(flag){
                if(i >= MIN && i < MAX)
                    prime.add(i);
                is_prime[i] = false;
            }
        }

        return prime;
    }


    static void printArr(List<Integer> list){
        for(int num : list){
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
