package 剑指offer;

import java.util.ArrayList;

/**
 * @Author: pyh
 * @Date: 2019/2/16 15:02
 * @Version 1.0
 * @Function:
 *      此为辅助工具类
 */
public class Tools {

    public static void printArrInt(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void printArrList(ArrayList list){
        for (int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
