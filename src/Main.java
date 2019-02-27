import java.util.ArrayList;

/**
 * @Author: pyh
 * @Date: 2019/2/20 18:56
 * @Version 1.0
 * @Function:
 */
public class Main {

    private static int val = 100;

    public static void main(String[] args){
        Main main = new Main();
        main.val++;
        System.out.println(val);
        Main main2 = new Main();
        main2.val++;
        Main.val++;
        System.out.println(val);
    }

    public static void exch(int[] arr, int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printList(ArrayList list){
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public static void printArr(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
