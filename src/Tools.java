import java.util.ArrayList;
import java.util.Scanner;

//此为工具类
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


    //输入模板
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){

        }
        scan.close();
    }
}
