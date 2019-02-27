package 校招真题_2018.网易_2018;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/2/15 17:01
 * @Version 1.0
 * @Function:
 *      操作序列
 *      小易有一个长度为n的整数序列,a_1,...,a_n。
 *      然后考虑在一个空序列b上进行n次以下操作:
 *      1、将a_i放入b序列的末尾
 *      2、逆置b序列
 *      小易需要你计算输出操作n次之后的b序列。
 *
 *      思想：观察可得！！！不需要逆序，直接从后向前间隔一个输出，然后没有输出的顺序输出即可
 */

public class controlList {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        while(scan.hasNext()){
            int n = scan.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0; i < n; i++){
                list.add(scan.nextInt());
            }

            //从最后开始打印，跳一个打印
            for(int i = list.size()-1; i >= 0; i = i-2){
                System.out.print(list.remove(i) + " ");
            }

            //剩下的按照顺序打印
            for(int i = 0; i < list.size(); i++){
                if(i == list.size()-1){
                    System.out.print(list.get(i));
                    break;
                }
                System.out.print(list.get(i) + " ");
            }
            System.out.println();

        }
        scan.close();
    }

}
