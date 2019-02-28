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
        int[] arr = new int[18];
        for(int i = 0; i < arr.length; i++){
            arr[i] = i;
        }

        //查找3
        int res = binSearch(arr, 0, arr.length-1, 3);
        System.out.println(res);
    }

    //二分查找
    public static int binSearch(int[] arr, int min, int max, int target){
        if(min > max){
            return -1;
        }
        int mid = min + (max-min)/2;
        //System.out.println(mid);
        if(arr[mid] == target){
            return mid;
        } else if(arr[mid] < target){
            min = mid+1;
            return binSearch(arr, min, max, target);
        } else{
            max = mid-1;
            return binSearch(arr, min, max, target);
        }
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
